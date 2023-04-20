package org.crm.crmback.infrastructure.token;

import java.security.SecureRandom;
import org.crm.crmback.infrastructure.exception.TokenGenerationException;
import org.crm.crmback.infrastructure.token.charset.TokenCharset;
import org.springframework.stereotype.Component;

@Component
public class SecureRandomTokenGenerator implements TokenGenerator {

  private final SecureRandom secureRandom;

  public SecureRandomTokenGenerator(SecureRandom secureRandom) {
    this.secureRandom = secureRandom;
  }

  @Override
  public String generate(TokenCharset tokenCharset, int size) {
    this.validateInput(tokenCharset, size);
    byte[] token = this.generateRandomToken(size);
    return this.buildStringToken(token, tokenCharset);
  }

  private void validateInput(TokenCharset tokenCharset, int size) {
    if (tokenCharset == null) {
      throw new TokenGenerationException("charset must not be null");
    }
    if (size <= 0) {
      throw new TokenGenerationException("size must be greater than 0");
    }
  }

  private byte[] generateRandomToken(int size) {
    byte[] byteToken = new byte[size];
    secureRandom.nextBytes(byteToken);
    return byteToken;
  }

  private String buildStringToken(byte[] byteToken, TokenCharset tokenCharset) {
    StringBuilder tokenBuilder = new StringBuilder();
    for (byte b : byteToken) {
      String charset = tokenCharset.getCharset();
      int charPosition = b % charset.length();
      int index = this.calculateIndex(charset, charPosition);
      tokenBuilder.append(charset.charAt(index));
    }
    return tokenBuilder.toString();
  }

  private int calculateIndex(String charset, int position) {
    if (position > 0) {
      return position;
    }
    int positiveValue = Math.abs(position);
    return charset.length() - positiveValue - 1;
  }
}
