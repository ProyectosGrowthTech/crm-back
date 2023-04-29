package org.crm.crmback.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.infrastructure.configuration.model.Secrets;
import org.crm.crmback.infrastructure.exception.AuthenticationException;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.crm.crmback.infrastructure.exception.JwtException;
import org.crm.crmback.infrastructure.jwt.JwtFacade;
import org.crm.crmback.infrastructure.redis.facade.TokenPersistenceFacade;
import org.crm.crmback.infrastructure.security.model.RequestSecurityContextHolder;
import org.crm.crmback.infrastructure.security.model.UserClaims;
import org.crm.crmback.infrastructure.utils.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.MimeTypeUtils;

@RequiredArgsConstructor
public class AuthenticationFilter implements Filter {

  private final Secrets secrets;

  private final JwtFacade jwtFacade;

  private final TokenPersistenceFacade tokenPersistenceFacade;

  private final ObjectMapper objectMapper;

  private final RequestSecurityContextHolder requestSecurityContextHolder;

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    try {
      if (!isExcludedEndpoint(request)) {
        String accessToken = this.getAccessToken(request);
        String identityToken = tokenPersistenceFacade.getIdentityTokenByAccessToken(accessToken);
        Map<String, Object> claims = jwtFacade.decode(identityToken);
        requestSecurityContextHolder.setClaims(this.buildUserClaims(claims));
        filterChain.doFilter(servletRequest, servletResponse);
      } else {
        filterChain.doFilter(servletRequest, servletResponse);
      }
    } catch (AuthenticationException | JwtException | ItemNotFoundException exception) {
      this.fillUnauthorizedResponse(response, exception.getMessage());
    }
  }

  private boolean isExcludedEndpoint(HttpServletRequest request) {
    String requestUri = request.getRequestURI().toLowerCase();
    List<String> excludedPatterns = secrets.security().authentication().excluded();

    // Use AntPathMatcher to match request URI against excluded patterns
    AntPathMatcher pathMatcher = new AntPathMatcher();
    for (String pattern : excludedPatterns) {
      if (pathMatcher.match(pattern, requestUri)) {
        return true;
      }
    }
    return false;
  }

  private String getAccessToken(HttpServletRequest request) throws AuthenticationException {
    String accessToken = request.getHeader(SecurityConstants.ACCESS_TOKEN_HEADER);
    if (StringUtils.isBlank(accessToken)) {
      throw new AuthenticationException("access token not present on header");
    }
    return accessToken;
  }

  private void fillUnauthorizedResponse(HttpServletResponse response, String errorMessage)
      throws IOException {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
    String message = objectMapper.writeValueAsString(Map.of("message", errorMessage));
    response.getWriter().write(message);
  }

  private UserClaims buildUserClaims(Map<String, Object> claims) {
    Long id = (long) (int) claims.get(SecurityConstants.ID_USER_CLAIM);
    String username = (String) claims.get(SecurityConstants.USERNAME_USER_CLAIM);
    String role = (String) claims.get(SecurityConstants.ROLE_USER_CLAIM);
    return new UserClaims(id, username, role);
  }
}
