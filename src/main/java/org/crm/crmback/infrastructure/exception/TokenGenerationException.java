package org.crm.crmback.infrastructure.exception;

public class TokenGenerationException extends RuntimeException {

  public TokenGenerationException(String message) {
    super(message);
  }

  public TokenGenerationException(String message, Throwable e) {
    super(message, e);
  }
}
