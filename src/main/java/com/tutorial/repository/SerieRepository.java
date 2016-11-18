package com.tutorial.repository;

import com.tutorial.domain.Serie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "series")
public interface SerieRepository extends CrudRepository<Serie, Integer > {
}
