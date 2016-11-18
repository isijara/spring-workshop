package com.tutorial.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "temporadasSerie")
public class TemporadaSerie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer idSerie;

  private String nombre;

  private Integer totalCapitulos;

}
