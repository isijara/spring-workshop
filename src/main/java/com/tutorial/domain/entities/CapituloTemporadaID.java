package com.tutorial.domain.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Embeddable
public class CapituloTemporadaID implements Serializable{

  private Integer idSerie;
  private Integer idTemporada;

}
