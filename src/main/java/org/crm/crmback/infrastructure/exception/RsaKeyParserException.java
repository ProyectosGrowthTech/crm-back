package org.crm.crmback.infrastructure.exception;

public class RsaKeyParserException extends RuntimeException {

  public RsaKeyParserException(String message) {
    super(message);
  }

  public RsaKeyParserException(String message, Throwable e) {
    super(message, e);
  }
}
