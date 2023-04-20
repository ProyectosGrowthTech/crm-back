package org.crm.crmback.infrastructure.exception;

public class ItemNotFoundException extends RuntimeException {

  public ItemNotFoundException(String message) {
    super(message);
  }

  public ItemNotFoundException(String message, Throwable e) {
    super(message, e);
  }
}
