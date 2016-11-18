package com.tutorial.services;


import com.tutorial.exceptions.ContractViolationException;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateServiceTest {

  private DateService dateServiceService;

  @Before
  public void setUp() {
    this.dateServiceService = new DateService();
  }

  @Test
  public void obtenerEdadConFechaActual() {

    String dateValue = "1989-07-20";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    try {
      Date date = df.parse(dateValue);
      Assert.assertEquals(27, this.dateServiceService.obtenerEdadConFechaActual(date));
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void obtenerEdadConFechaIntervaloDeFechas() {

    String dateValue = "1989-07-20";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String objectiveDate = "2016-01-01";

    try {
      Date initialDate = df.parse(dateValue);
      Date finalDate = df.parse(objectiveDate);

      Assert.assertEquals(26, this.dateServiceService.obtenerEdadConIntervaloDeFechas(initialDate, finalDate));
    } catch (ParseException e) {
      e.printStackTrace();
    }


  }

  @Test
  public void parsearStringToDateNotEqual(){
    Date fechaActual = new Date();
    Assert.assertNotEquals(fechaActual,this.dateServiceService.parsearStringToDate("2016-01-01"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void parsearStringToDateExceptionParametroVacio() {
    this.dateServiceService.parsearStringToDate("");
  }

  @Test(expected = NullPointerException.class)
  public void parsearStringToDateExceptionNull() {
    this.dateServiceService.parsearStringToDate(null);
  }

  @Test
  public void obtenerFechaUtimoDiaDelMesEqual() {
    Date          fechaUno          = this.dateServiceService.parsearStringToDate("2016-07-11");
    Date          fechaDos          = this.dateServiceService.parsearStringToDate("2016-07-31");
    java.sql.Date fechaCorrecta     = new java.sql.Date(fechaDos.getTime());
    java.sql.Date fechaUltimoDiaMes = this.dateServiceService.obtenerFechaUtimoDiaDelMes(fechaUno);

    Assert.assertEquals(fechaCorrecta,fechaUltimoDiaMes);
  }

  @Test(expected = IllegalArgumentException.class)
  public void obtenerFechaUtimoDiaDelMesNull() {
    this.dateServiceService.obtenerFechaUtimoDiaDelMes(null);
  }

  @Test
  public void obtenerFechaUtimoDiaDelMesNotEqual() {
    Date          fechaUno          = this.dateServiceService.parsearStringToDate("2016-07-11");
    Date          fechaDos          = this.dateServiceService.parsearStringToDate("2016-07-29");
    java.sql.Date fechaCorrecta     = new java.sql.Date(fechaDos.getTime());
    java.sql.Date fechaUltimoDiaMes = this.dateServiceService.obtenerFechaUtimoDiaDelMes(fechaUno);

    Assert.assertNotEquals(fechaCorrecta,fechaUltimoDiaMes);
  }

  @Test
  public void mesEnStringEspaniolNotEqual() {
    String mes = this.dateServiceService.mesEnStringEspaniol(1);

    Assert.assertNotEquals( "FEBRERO", mes);
  }

  @Test
  public void mesEnStringEspaniolEqualJunio() {
    String mes = this.dateServiceService.mesEnStringEspaniol(6);
    Assert.assertEquals( "JUNIO", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualEnero() {
    String mes = this.dateServiceService.mesEnStringEspaniol(1);
    Assert.assertEquals( "ENERO", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualFebrero() {
    String mes = this.dateServiceService.mesEnStringEspaniol(2);
    Assert.assertEquals( "FEBRERO", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualMarzo() {
    String mes = this.dateServiceService.mesEnStringEspaniol(3);
    Assert.assertEquals( "MARZO", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualMayo() {
    String mes = this.dateServiceService.mesEnStringEspaniol(5);
    Assert.assertEquals( "MAYO", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualAgosto() {
    String mes = this.dateServiceService.mesEnStringEspaniol(8);
    Assert.assertEquals( "AGOSTO", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualSeptiembre() {
    String mes = this.dateServiceService.mesEnStringEspaniol(9);
    Assert.assertEquals( "SEPTIEMBRE", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualOctubre() {
    String mes = this.dateServiceService.mesEnStringEspaniol(10);
    Assert.assertEquals( "OCTUBRE", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualNoviembre() {
    String mes = this.dateServiceService.mesEnStringEspaniol(11);
    Assert.assertEquals( "NOVIEMBRE", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualDiciembre() {
    String mes = this.dateServiceService.mesEnStringEspaniol(12);
    Assert.assertEquals( "DICIEMBRE", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualJulio() {
    String mes = this.dateServiceService.mesEnStringEspaniol(7);
    Assert.assertEquals( "JULIO", mes );
  }

  @Test
  public void mesEnStringEspaniolEqualAbril() {
    String mes = this.dateServiceService.mesEnStringEspaniol(4);
    Assert.assertEquals( "ABRIL", mes );
  }

  @Test(expected = ContractViolationException.class)
  public void mesEnStringEspaniolMesNull() {
    this.dateServiceService.mesEnStringEspaniol(null);
  }

  @Test(expected = ContractViolationException.class)
  public void mesEnStringEspaniolMesNegativo() {
    this.dateServiceService.mesEnStringEspaniol(-6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void mesEnStringEspaniolNumeroDeMesFueraDeRangoDeMesesDelAnio() {
    this.dateServiceService.mesEnStringEspaniol(13);
  }

  @Test(expected = ContractViolationException.class)
  public void quitarUnDiaAUnaFechaFechaNull() {
    this.dateServiceService.quitarDiasAUnaFecha(null,1);
  }

  @Test(expected = ContractViolationException.class)
  public void quitarUnDiaAUnaFechaNumeroDeDiasNull() {
    DateTime fecha = new DateTime("2016-01-20");

    this.dateServiceService.quitarDiasAUnaFecha(fecha.toDate(),null);
  }

  @Test
  public void quitarUnDiaAUnaFechaNotEqual() {
    DateTime fecha = new DateTime("2016-01-20");

    Date fechaMenosUnDia  = this.dateServiceService.quitarDiasAUnaFecha(fecha.toDate(),1);

    Assert.assertNotEquals(fecha.toDate(),fechaMenosUnDia);
  }

  @Test
  public void quitarUnDiaAUnaFechaEqual() {
    DateTime fecha = new DateTime("2016-01-20");

    DateTime fechaAComparar = new DateTime("2016-01-19");

    Date fechaMenosUnDia  = this.dateServiceService.quitarDiasAUnaFecha(fecha.toDate(),1);

    Assert.assertEquals(fechaAComparar.toDate(),fechaMenosUnDia);
  }
  @Test(expected = ContractViolationException.class)
  public void agregarDiasAUnaFechaFechaNull() {
    this.dateServiceService.agregarDiasAUnaFecha(null,1);
  }

  @Test(expected = ContractViolationException.class)
  public void agregarDiasAUnaFechaNumeroDeDiasNull() {
    DateTime fecha = new DateTime("2016-01-20");

    this.dateServiceService.agregarDiasAUnaFecha(fecha.toDate(),null);
  }

  @Test
  public void agregarDiasAUnaFechaNotEqual() {
    DateTime fecha = new DateTime("2016-01-20");

    Date fechaMenosUnDia  = this.dateServiceService.agregarDiasAUnaFecha(fecha.toDate(),5);

    Assert.assertNotEquals(fecha.toDate(),fechaMenosUnDia);
  }

  @Test
  public void agregarDiasAUnaFechaEqual() {
    DateTime fecha = new DateTime("2016-01-20");

    DateTime fechaAComparar = new DateTime("2016-01-26");

    Date fechaMenosUnDia  = this.dateServiceService.agregarDiasAUnaFecha(fecha.toDate(),6);

    Assert.assertEquals(fechaAComparar.toDate(),fechaMenosUnDia);
  }


  @Test(expected = ContractViolationException.class)
  public void agregarAniosAUnaFechaFechaNull() {
    this.dateServiceService.agregarAniosAUnaFecha(null,1);
  }

  @Test(expected = ContractViolationException.class)
  public void agregarAniosAUnaFechaNumeroDeDiasNull() {
    DateTime fecha = new DateTime("2016-01-20");

    this.dateServiceService.agregarAniosAUnaFecha(fecha.toDate(),null);
  }

  @Test
  public void agregarAniosAUnaFechaNotEqual() {
    DateTime fecha = new DateTime("2016-01-20");

    Date fechaMenosUnDia  = this.dateServiceService.agregarAniosAUnaFecha(fecha.toDate(),5);

    Assert.assertNotEquals(fecha.toDate(),fechaMenosUnDia);
  }

  @Test
  public void agregarAniosAUnaFechaEqual() {
    DateTime fecha = new DateTime("2016-01-20");

    DateTime fechaAComparar = new DateTime("2020-01-20");

    Date fechaMenosUnDia  = this.dateServiceService.agregarAniosAUnaFecha(fecha.toDate(),4);

    Assert.assertEquals(fechaAComparar.toDate(),fechaMenosUnDia);
  }


}