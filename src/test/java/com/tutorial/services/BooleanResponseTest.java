package com.tutorial.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooleanResponseTest {

  @Test
  public  void BooleanResponseGetResultTest() {
    BooleanResponse respuesta =  new BooleanResponse(true);

    Boolean resultadoEsperado = true;
    Boolean resultadoObtenido = respuesta.getResult();

    Assert.assertEquals(resultadoEsperado, resultadoObtenido);
  }

  @Test
  public  void BooleanResponseSetResultTest() {
    BooleanResponse respuesta =  new BooleanResponse(true);

    Boolean resultadoEsperado = true;
    respuesta.setResult(true);
    Boolean resultadoObtenido = respuesta.getResult();

    Assert.assertEquals(resultadoEsperado, resultadoObtenido);
  }

  @Test
  public  void BooleanResponseSetResultYResultadoIncorrectoTest() {
    BooleanResponse respuesta =  new BooleanResponse(true);

    Boolean resultadoEsperado = true;
    respuesta.setResult(false);
    Boolean resultadoObtenido = respuesta.getResult();

    Assert.assertNotEquals(resultadoEsperado, resultadoObtenido);
  }

}
