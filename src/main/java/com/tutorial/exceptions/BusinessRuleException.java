package com.tutorial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusinessRuleException extends Exception {

  public BusinessRuleException() {
    this("Regla de negocios violada!");
  }

  public BusinessRuleException(String message) {
    this(message, null);
  }

  private BusinessRuleException(String message, Throwable cause) {
    super(message, cause);
  }

}
