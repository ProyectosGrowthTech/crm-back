package org.crm.crmback.domain.exception;

public class PasswordDoesNotMatchException extends RuntimeException {

  public PasswordDoesNotMatchException(String message) {
    super(message);
  }

  public PasswordDoesNotMatchException(String message, Throwable e) {
    super(message, e);
  }
}
