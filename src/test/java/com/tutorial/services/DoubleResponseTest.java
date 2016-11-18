package com.tutorial.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoubleResponseTest {


  @Test
  public  void DoubleGetResultTest() {
    DoubleResponse doubleResponse =  new DoubleResponse(2.3);

    Double resultadoEsperado = 2.3;
    Double resultadoObtenido = doubleResponse.getResult();

    Assert.assertEquals(resultadoEsperado, resultadoObtenido);
  }

  @Test
  public  void DoubleSetResultTest() {
    DoubleResponse doubleResponse =  new DoubleResponse(2.3);

    Double resultadoEsperado = 2.4;
    doubleResponse.setResult(2.4);
    Double resultadoObtenido = doubleResponse.getResult();

    Assert.assertEquals(resultadoEsperado, resultadoObtenido);
  }

  @Test
  public  void DoubleSetResultYResutadoIncorrectoTest() {
    DoubleResponse doubleResponse =  new DoubleResponse(2.3);

    Double resultadoEsperado = 2.4;
    doubleResponse.setResult(2.5);
    Double resultadoObtenido = doubleResponse.getResult();

    Assert.assertNotEquals(resultadoEsperado, resultadoObtenido);
  }
}
