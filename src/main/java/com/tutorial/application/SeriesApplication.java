package com.tutorial.application;



import com.tutorial.domain.entities.Serie;
import com.tutorial.domain.entities.TemporadaSerie;
import com.tutorial.domain.entities.model.Series;
import com.tutorial.repository.CapituloTemporadaRepository;
import com.tutorial.repository.SerieRepository;
import com.tutorial.repository.TemporadaSerieRepository;
import com.tutorial.services.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeriesApplication {

  @Autowired
  private Series series;

  @Autowired
  private SerieRepository serieRepository;

  @Autowired
  private TemporadaSerieRepository temporadaSerieRepository;

  @Autowired
  private CapituloTemporadaRepository capituloTemporadaRepository;

  @Autowired
  private Validator validator;

  public int numeroDeCapitulosDeUnaSerie(int idSerie) {
    this.validator.isNotNull(idSerie, "idSerie no debe ser null");

    Serie serie = this.serieRepository.findOne(idSerie);

    this.validator.resourceExists(serie, "No existe la serie que solicito");

    List<TemporadaSerie> temporadaSerie = this.temporadaSerieRepository.findByIdSerie(serie.getId());

    return series.totalDeCapitulosDeUnaSerie(temporadaSerie);
  }

}
