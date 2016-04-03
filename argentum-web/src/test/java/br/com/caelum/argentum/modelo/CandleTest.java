package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import static org.junit.Assert.*;
import org.junit.Test;

public class CandleTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		@SuppressWarnings("unused")
		Candle candle = new Candle(10, 20, 20, 10, 1000, Calendar.getInstance());
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void dataNaoPodemSerNula(){
		Candle candle = new Candle(10, 10, 10, 20, 1000, null);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void argumentosNaoPodemSerNegativos(){
		Candle candleAbertura = new Candle(-1, 10, 10, 20, 1000, Calendar.getInstance());
		Candle candleFechamento = new Candle(10, -1, 10, 20, 1000, Calendar.getInstance());
		Candle candleMinimo = new Candle(10, 10, -1, 20, 1000, Calendar.getInstance());
		Candle candleMaximo = new Candle(10, 10, 10, -1, 1000, Calendar.getInstance());
		Candle candleVolume = new Candle(10, 10, 10, 20, -1, Calendar.getInstance());
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta(){
		Candle candlestick = new Candle(10, 10, 5, 18.4, 1000, Calendar.getInstance());
		assertTrue(candlestick.isAlta());
	}

}
