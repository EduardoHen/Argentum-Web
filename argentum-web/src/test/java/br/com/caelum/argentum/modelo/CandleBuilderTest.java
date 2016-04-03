package br.com.caelum.argentum.modelo;

import org.junit.Test;

public class CandleBuilderTest {

	@Test(expected = IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		CandleBuilder candleBuilder = new CandleBuilder();
		
		candleBuilder.comAbertura(40.5);
		candleBuilder.comFechamento(55.0);
		candleBuilder.geraCandle();
	}

}
