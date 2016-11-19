package com.tutorial.repository;

import com.tutorial.domain.entities.TemporadaSerie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "temporadas-series")
public interface TemporadaSerieRepository extends CrudRepository<TemporadaSerie, Integer> {
  List<TemporadaSerie> findByIdSerie(@Param("idSerie") Integer idSerie);
}
