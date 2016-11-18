package com.tutorial.services;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Date;

public class DateService {

  private Validator validator;

  public DateService() {
    this.validator = new Validator();
  }


  public int obtenerEdadConFechaActual(Date fechaNac) {

    Calendar fechaNacimiento = Calendar.getInstance();
    Calendar fechaActual = Calendar.getInstance();
    fechaNacimiento.setTime(fechaNac);

    return this.obtenerEdadConIntervaloDeFechas(fechaNac, fechaActual.getTime());

  }

  public int obtenerEdadConIntervaloDeFechas(Date fecha, Date fechaObjetivo) {

    Date fechaNac = fecha;

    Calendar fechaNacimiento = Calendar.getInstance();
    Calendar fechaActual = Calendar.getInstance();

    fechaActual.setTime(fechaObjetivo);
    fechaNacimiento.setTime(fechaNac);
    int año = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
    int mes = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
    int dia = fechaActual.get(Calendar.DATE) - fechaNacimiento.get(Calendar.DATE);

    if (mes < 0 || (mes == 0 && dia < 0)) {
      año--;
    }

    return año;
  }

  public java.sql.Date obtenerFechaUtimoDiaDelMes(Date fecha) {
    Assert.notNull(fecha);

    DateTime date        = new DateTime(fecha);

    DateTime endOfMonth  = date.dayOfMonth().withMaximumValue();

    java.sql.Date fechaUltimoDiaDeMes = new java.sql.Date(endOfMonth.toDate().getTime());

    return fechaUltimoDiaDeMes;
  }

  public Date parsearStringToDate(String fecha) {
    DateTime date;

    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    date = formatter.parseDateTime(fecha);

    return date.toDate();
  }

  public Date agregarDiasAUnaFecha(Date fecha, Integer diasARestar) {

    this.validator.isNotNull(fecha, "La fecha no debe ser null");
    this.validator.isNotNull(diasARestar, "Los Dias a restar no deben ser null");

    DateTime dateTime = new DateTime(fecha);

    Date fechaResultante = dateTime.plusDays(+diasARestar).toDate();

    return fechaResultante;
  }

  public  Date quitarDiasAUnaFecha(Date fecha, Integer diasARestar ) {//Todo prueba unitaria
    this.validator.isNotNull(fecha, "La fecha no debe ser null");
    this.validator.isNotNull(diasARestar, "Los Dias a restar no deben ser null");

    DateTime dateTime = new DateTime(fecha);

    Date fechaResultante = dateTime.plusDays(-diasARestar).toDate();

    return fechaResultante;
  }


  public  Date agregarAniosAUnaFecha(Date fecha,Integer anios) {
    this.validator.isNotNull(fecha, "La fecha no debe ser null");
    this.validator.isNotNull(anios, "Los Dias a restar no deben ser null");

    DateTime dateTime = new DateTime(fecha);

    Date fechaResultante = dateTime.plusYears(+anios).toDate();

    return fechaResultante;
  }

  public String mesEnStringEspaniol(Integer numeroMes) {

    this.validator.isNotNull(numeroMes, "El numero de mes no debe ser nulo");
    this.validator.isPositiveValue(numeroMes, "El numero de mes no debe ser negativo");


    if ( numeroMes > 12 ) {
      throw new IllegalArgumentException("El mes no debe ser mayor a 12");
    }

    String mes = "";

    switch (numeroMes) {
      case 1:
        mes = "ENERO";
        break;
      case 2:
        mes = "FEBRERO";
        break;
      case 3:
        mes = "MARZO";
        break;
      case 4:
        mes = "ABRIL";
        break;
      case 5:
        mes = "MAYO";
        break;
      case 6:
        mes = "JUNIO";
        break;
      case 7:
        mes = "JULIO";
        break;
      case 8:
        mes = "AGOSTO";
        break;
      case 9:
        mes = "SEPTIEMBRE";
        break;
      case 10:
        mes = "OCTUBRE";
        break;
      case 11:
        mes = "NOVIEMBRE";
        break;
      case 12:
        mes = "DICIEMBRE";
        break;
    }

    return mes;
  }

}
