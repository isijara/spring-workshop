package com.tutorial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ContractViolationException extends RuntimeException {

  public ContractViolationException() {
    this("Regla de negocios violada!");
  }

  public ContractViolationException(String message) {
    this(message, null);
  }

  private ContractViolationException(String message, Throwable cause) {
    super(message, cause);
  }

}
