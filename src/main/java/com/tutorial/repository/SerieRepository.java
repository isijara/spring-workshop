package com.tutorial.repository;

import com.tutorial.domain.entities.Serie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "series")
public interface SerieRepository extends CrudRepository<Serie, Integer > {

  List<Serie> findSerieByNombreAndCompania(@Param("nombreSerie") String nombreSerie,
                                           @Param("companiaSerie") String companiaSerie);
}
