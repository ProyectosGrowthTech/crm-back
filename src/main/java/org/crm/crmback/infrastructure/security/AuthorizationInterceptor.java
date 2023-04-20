package org.crm.crmback.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.infrastructure.security.annotation.Authorized;
import org.crm.crmback.infrastructure.security.model.RequestSecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthorizationInterceptor implements HandlerInterceptor {

  private final RequestSecurityContextHolder requestSecurityContextHolder;

  private final ObjectMapper objectMapper;

  public boolean preHandle(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull Object handler)
      throws IOException {
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    Authorized authorizedAnnotation = method.getAnnotation(Authorized.class);
    if (authorizedAnnotation == null) {
      return true;
    }
    String[] allowedRoles = authorizedAnnotation.allowedRoles();
    for (String role : allowedRoles) {
      if (role.equalsIgnoreCase(requestSecurityContextHolder.getClaims().role())) {
        return true;
      }
    }
    this.fillForbiddenResponse(response);
    return false;
  }

  private void fillForbiddenResponse(HttpServletResponse response) throws IOException {
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
    String message =
        objectMapper.writeValueAsString(
            Map.of("message", "user role not allowed to perform this operation"));
    response.getWriter().write(message);
  }
}
