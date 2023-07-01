package org.crm.crmback.infrastructure.api.controllers.advice;

import org.crm.crmback.infrastructure.api.controllers.advice.dto.ErrorResponse;
import org.crm.crmback.domain.exception.PasswordDoesNotMatchException;
import org.crm.crmback.domain.exception.UserAlreadyExistsException;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.crm.crmback.infrastructure.exception.JwtException;
import org.crm.crmback.infrastructure.exception.RsaKeyParserException;
import org.crm.crmback.infrastructure.exception.TokenGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonControllerAdvice {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ItemNotFoundException.class)
  public ErrorResponse notFoundException(ItemNotFoundException exception) {
    return new ErrorResponse(exception.getMessage());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(
      value = {RsaKeyParserException.class, JwtException.class, TokenGenerationException.class})
  public ErrorResponse internalServerErrorException(Exception exception) {
    return new ErrorResponse(exception.getMessage());
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(PasswordDoesNotMatchException.class)
  public ErrorResponse passwordDoesNotMatchException(PasswordDoesNotMatchException exception) {
    return new ErrorResponse(exception.getMessage());
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(UserAlreadyExistsException.class)
  public ErrorResponse userAlreadyExistsException(UserAlreadyExistsException exception) {
    return new ErrorResponse(exception.getMessage());
  }
}
