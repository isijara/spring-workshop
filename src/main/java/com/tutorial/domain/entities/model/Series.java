package com.tutorial.domain.entities.model;

import com.tutorial.domain.entities.TemporadaSerie;
import com.tutorial.services.IntegerResponse;
import com.tutorial.services.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Series {

  @Autowired
  private Validator  validator;


  public int totalDeCapitulosDeUnaSerie(List<TemporadaSerie> temporadaSerie) {
    this.validator.isNotNull(temporadaSerie, "temporadaSerie no debe ser null");

    Integer totalCapitulos = 0;
    for (TemporadaSerie temporada : temporadaSerie) {
      totalCapitulos += temporada.getTotalCapitulos();
    }
    return totalCapitulos;
  }
}
