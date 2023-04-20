package org.crm.crmback.infrastructure.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import org.crm.crmback.infrastructure.exception.JwtException;

public class JwtRsa512Facade implements JwtFacade {

  private final RSAPublicKey publicKey;

  private final RSAPrivateKey privateKey;

  public JwtRsa512Facade(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
    this.privateKey = privateKey;
    this.publicKey = publicKey;
  }

  @Override
  public String generate(Map<String, Object> claims) {
    try {
      if (claims == null) {
        throw new IllegalArgumentException("claims cannot be null");
      }
      return JWT.create().withPayload(claims).sign(Algorithm.RSA512(publicKey, privateKey));
    } catch (IllegalArgumentException | JWTCreationException ex) {
      throw new JwtException("error while creating jwt token: " + ex.getMessage(), ex);
    }
  }

  public void validate(String jwtToken) {
    try {
      JWTVerifier verifier = JWT.require(Algorithm.RSA512(publicKey, privateKey)).build();
      verifier.verify(jwtToken);
    } catch (JWTVerificationException ex) {
      throw new JwtException("error while validating jwt token", ex);
    }
  }

  public Map<String, Object> decode(String jwtToken) {
    try {
      JWTVerifier verifier = JWT.require(Algorithm.RSA512(publicKey, privateKey)).build();
      DecodedJWT decodedToken = verifier.verify(jwtToken);
      return this.buildClaims(decodedToken);
    } catch (JWTVerificationException ex) {
      throw new JwtException("error while decoding and validating jwt token", ex);
    }
  }

  private Map<String, Object> buildClaims(DecodedJWT decodedJwt) {
    Map<String, Object> claims = new HashMap<>();
    Map<String, Claim> decodedTokenClaims = decodedJwt.getClaims();
    for (String key : decodedTokenClaims.keySet()) {
      claims.put(key, decodedTokenClaims.get(key).as(Object.class));
    }
    return claims;
  }
}
