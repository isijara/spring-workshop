package com.tutorial.repository;

import com.tutorial.domain.entities.GeneroSerie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "generos-series")
public interface GeneroSerieRepository extends CrudRepository<GeneroSerie, Integer > {
}
