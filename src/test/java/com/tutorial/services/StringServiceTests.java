package com.tutorial.services;

import com.tutorial.exceptions.ContractViolationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringServiceTests {

  private StringService stringService;

  @Before
  public void setUp() {
    this.stringService = new StringService();
  }

  @Test
  public void esNumeroCuandoIngresoCaracteres() {
    Assert.assertEquals(true, stringService.esNumero("129"));
  }

  @Test
  public void esNumeroCuandoIngresasLetras() {
    Assert.assertEquals(false, stringService.esNumero("fd") );
  }

  @Test
  public void esNumeroCaratcterVacio() {
    Assert.assertEquals(false, stringService.esNumero("") );
  }

  @Test
  public void removerCaracteresEspecialesEntradaEstaVacia(){

    Assert.assertEquals("", stringService.removerCaracteresEspeciales(""));
  }

  @Test
  public void removerCaracteresEspecialesEntradaNoContieneCaracteresEspeciales(){
    Assert.assertEquals("ABC", stringService.removerCaracteresEspeciales("ABC"));
  }

  @Test
  public void removerCaracteresEspecialesEntradaContieneCaracteresEspeciales(){
    Assert.assertEquals("ABC", stringService.removerCaracteresEspeciales("ABC.,"));
  }

  @Test
  public void rellenarConCerosAlaIzquierda() {
    String result = stringService.rellenarConCerosAlaIzquierda("5", 5);
    Assert.assertEquals(true, "00005".equals(result));
  }

  @Test
  public void rellenarConCerosAlaIzquierdaCuandoDigitoYaMideLaLongitudEsperada() {
    String input = "12345";
    String result = stringService.rellenarConCerosAlaIzquierda(input, 5);
    Assert.assertEquals(true, input.equals(result));
  }

  @Test(expected = ContractViolationException.class)
  public void rellenarConCerosAlaDerechaCadenaNull() {
    this.stringService.rellenarConCerosAlaDerecha(null,1);
  }

  @Test(expected = ContractViolationException.class)
  public void rellenarConCerosAlaDerechaTamanioCadena() {
    this.stringService.rellenarConCerosAlaDerecha("",null);
  }

  @Test
  public void rellenarConCerosAlaDerechaEqual() {
    String cadenaResultante = this.stringService.rellenarConCerosAlaDerecha("12345",10);
    Assert.assertEquals(cadenaResultante,"1234500000");
  }

  @Test
  public void rellenarConCerosAlaDerechaNotEqual() {
    String cadenaResultante = this.stringService.rellenarConCerosAlaDerecha("",10);
    Assert.assertNotEquals(cadenaResultante, "1234501");
  }

}
