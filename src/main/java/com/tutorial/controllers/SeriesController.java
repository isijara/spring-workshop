package com.tutorial.controllers;

import com.tutorial.application.SeriesApplication;
import com.tutorial.domain.entities.Serie;
import com.tutorial.repository.SerieRepository;
import com.tutorial.services.IntegerResponse;
import com.tutorial.services.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/series")
public class SeriesController {

  @Autowired
  private SerieRepository serieRepository;

  @Autowired
  private Validator validator;

  @Autowired
  private SeriesApplication seriesApplication;

  @RequestMapping(method = RequestMethod.POST, produces = "application/hal+json")
  private Serie save(@RequestBody Serie serie) {

    this.validator.isNotNull(serie, "serie no debe ser null");

    return this.serieRepository.save(serie);
  }

  @RequestMapping(method = RequestMethod.GET, produces = "application/hal+json")
  private Iterable<Serie> get() {

    return this.serieRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "{idSerie}/numero-capitulos")
  private IntegerResponse numeroDeCapitulosPorSerie(@PathVariable("idSerie") Integer idSerie){
    this.validator.isNotNull(idSerie, "idSerie no debe ser null");

    Integer resultado = this.seriesApplication.numeroDeCapitulosDeUnaSerie(idSerie);

    return new IntegerResponse(resultado);
  }

}
