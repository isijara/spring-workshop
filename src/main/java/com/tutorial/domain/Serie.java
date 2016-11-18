package com.tutorial.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "series")
public class Serie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String nombre;

  private Time duracion;

  private String genero;

  private String sinopsis;

  private String compania;
}
