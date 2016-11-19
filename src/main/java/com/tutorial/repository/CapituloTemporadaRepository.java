package com.tutorial.repository;


import com.tutorial.domain.entities.CapituloTemporada;
import com.tutorial.domain.entities.CapituloTemporadaID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "capitulos-temporadas")
public interface CapituloTemporadaRepository extends CrudRepository<CapituloTemporada ,CapituloTemporadaID> {
}
