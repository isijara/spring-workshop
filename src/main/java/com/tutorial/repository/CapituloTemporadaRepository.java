package com.tutorial.repository;


import com.tutorial.domain.entities.CapituloTemporada;
import com.tutorial.domain.entities.CapituloTemporadaID;
import org.springframework.data.repository.CrudRepository;

public interface CapituloTemporadaRepository extends CrudRepository<CapituloTemporada ,CapituloTemporadaID> {
}
