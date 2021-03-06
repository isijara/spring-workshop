package com.tutorial;

import com.tutorial.domain.entities.CapituloTemporada;
import com.tutorial.domain.entities.TemporadaSerie;
import com.tutorial.domain.entities.GeneroSerie;
import com.tutorial.domain.entities.Serie;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(GeneroSerie.class);
    config.exposeIdsFor(Serie.class);
    config.exposeIdsFor(CapituloTemporada.class);
    config.exposeIdsFor(TemporadaSerie.class);
    config.setReturnBodyOnCreate(true);
  }
}