package com.tutorial.domain.model;

import com.tutorial.AppConfigTest;
import com.tutorial.domain.entities.TemporadaSerie;
import com.tutorial.domain.entities.model.Series;
import com.tutorial.exceptions.ContractViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {AppConfigTest.class})
public class SeriesTest {

  @Autowired
  private Series series;

 @Test(expected = ContractViolationException.class)
  public void totalDeCapituloDeUnaSerieListaDeTemporadasNullTest() {
    this.series.totalDeCapitulosDeUnaSerie(null);
  }

  @Test
  public void totalDeCapituloDeUnaSerieRegresaNumeroDeCapitulosCorrectamenteTest() {
    List<TemporadaSerie> temporada= new ArrayList<>();
    TemporadaSerie temporadaSerie = new TemporadaSerie();
    temporadaSerie.setTotalCapitulos(10);

    temporada.add(temporadaSerie);

    int resultadoEsperado = 10;

   int resultadoObtenido = this.series.totalDeCapitulosDeUnaSerie(temporada);

    Assert.assertEquals(resultadoEsperado, resultadoObtenido);
  }

  @Test
  public void totalDeCapituloDeUnaSerieRegresaNumeroDeCapitulosIncorrectamenteTest() {
    List<TemporadaSerie> temporadas = new ArrayList<>();
    TemporadaSerie temporadaSerie = new TemporadaSerie();
    temporadaSerie.setTotalCapitulos(10);

    temporadas.add(temporadaSerie);

    int resultadoEsperado = 9;

    int resultadoObtenido = this.series.totalDeCapitulosDeUnaSerie(temporadas);

    Assert.assertNotEquals(resultadoEsperado, resultadoObtenido);
  }



}
