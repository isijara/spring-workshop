package com.tutorial.services;

import com.tutorial.exceptions.ContractViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class Validator {

  public void isNotNull(Object object, String message) {
    if ( object == null ) {
      throw new ContractViolationException(message);
    }
  }

  public void isPositiveValue(Integer integer, String message) {
    if( integer.intValue() < 0  ) {
      throw new ContractViolationException(message);
    }
  }

  public void resourceExists(Object resource, String message) {
    if (resource == null ) {
      throw new ResourceNotFoundException(message);
    }
  }

}
