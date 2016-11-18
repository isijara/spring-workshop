package com.tutorial.domain.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "capitulosTemporada")
public class CapituloTemporada {

  @EmbeddedId
  private CapituloTemporadaID id;

  private String nombre;


}
