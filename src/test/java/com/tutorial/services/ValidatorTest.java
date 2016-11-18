package com.tutorial.services;


import com.tutorial.exceptions.ContractViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorTest {

  @Autowired
  private Validator validator;

  @Test(expected = ContractViolationException.class)
  public void isNotNullTest(){
    this.validator.isNotNull(null,"");
  }

  @Test(expected = ContractViolationException.class)
  public void isNegativeValueTest(){
    this.validator.isPositiveValue(-1, "");
  }

  @Test(expected = ResourceNotFoundException.class)
  public void resourceExistsExceptionTest(){
    this.validator.resourceExists(null, "Resource not found");
  }

  @Test
  public void resourceExistsTest(){
    String string = new String();
    string = "Soy el objeto";
    this.validator.resourceExists(string, "Si pase el text");
  }
}
