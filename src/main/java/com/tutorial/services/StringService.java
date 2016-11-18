package com.tutorial.services;

import org.springframework.stereotype.Component;

@Component
public class StringService implements iStringService {

  private Validator validator;

  public StringService() {
    this.validator = new Validator();
  }

  public boolean esNumero(String input) {
    this.validator.isNotNull(input,"input no debe ser null");
    return input.matches("\\d+");
  }

  public String removerCaracteresEspeciales(String input) {
    this.validator.isNotNull(input,"input no debe ser null");
    return input.replaceAll("[-+.^:,^\\s*]", "");
  }

  public String rellenarConCerosAlaIzquierda(String input, Integer tamanioCadena) {
    this.validator.isNotNull(input,"La cadena no debe ser null");
    this.validator.isNotNull(tamanioCadena,"El tamanio de cadena no debe ser null");

    return String.format("%0" + tamanioCadena + "d", Integer.parseInt(input));
  }

  public String rellenarConCerosAlaDerecha(String input,Integer tamanioCadena) {
    this.validator.isNotNull(input,"La cadena no debe ser null");
    this.validator.isNotNull(tamanioCadena,"El tamanio de cadena no debe ser null");

    String cadenaResultante = input;
    Integer tamanioInput = input.length();

    for (int i = tamanioInput; i < tamanioCadena; i++)  {
      cadenaResultante += "0";
    }

    return cadenaResultante;
  }

}
