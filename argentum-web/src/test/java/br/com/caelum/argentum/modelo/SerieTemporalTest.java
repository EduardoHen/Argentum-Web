package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.indicadores.GeradorDeSerie;

public class SerieTemporalTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoBuscaPosicaoMaiorQueOTamanhoDaSerie() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(2, 3, 4, 5, 6);
		@SuppressWarnings("unused")
		Candle candle = serie.getCandle(5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoBuscaPosicaoMenorQueZero(){
		SerieTemporal serie = GeradorDeSerie.criaSerie(2, 3, 4, 5, 6);
		@SuppressWarnings("unused")
		Candle candle = serie.getCandle(-1);
	}
	
	@Test
	public void serieComUmCandle(){
		SerieTemporal serie = GeradorDeSerie.criaSerie(1);
		
		assertEquals(1, serie.size());
		assertEquals(1, serie.getCandle(0).getAbertura(), 0.00001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void serieComListaDeCandlesNula(){
		List<Candle> listaVazia = new ArrayList<>();
		@SuppressWarnings("unused")
		SerieTemporal serie = new SerieTemporal(listaVazia);
	}

}
