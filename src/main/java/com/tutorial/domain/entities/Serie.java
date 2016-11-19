package com.tutorial.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "series")
public class Serie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String nombre;

  private Time duracion;

  @OneToOne
  @JoinColumn(name = "idGenero", referencedColumnName = "id")
  GeneroSerie generoSerie;

  @OneToMany
  @JoinColumn(name = "idSerie")
  List<TemporadaSerie> temporadaSeries;

  private String sinopsis;

  private String compania;
}
