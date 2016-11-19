package com.tutorial.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "generoSeries")
public class GeneroSerie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private  int id;

  private String nombre;
}
