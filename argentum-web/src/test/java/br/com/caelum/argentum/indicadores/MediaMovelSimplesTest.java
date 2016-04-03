package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimplesTest {

	@Test
	public void sequenciaSimplesDosCandles() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
		
		MediaMovelSimples mms = new MediaMovelSimples(new IndicadorFechamento());
		
		assertEquals(2.0, mms.calcula(2, 3, serie), 0.00001);
		assertEquals(3.0, mms.calcula(3, 3, serie), 0.00001);
		assertEquals(10.0/3, mms.calcula(4, 3, serie), 0.00001);
		assertEquals(11.0/3, mms.calcula(5, 3, serie), 0.00001);
		assertEquals(4.0, mms.calcula(6, 3, serie), 0.00001);
		assertEquals(13.0/3, mms.calcula(7, 3, serie), 0.00001);
		assertEquals(4.0, mms.calcula(8, 3, serie), 0.00001);
	}
	
	@Test
	public void chamandoIndicadorAbertura(){
		MediaMovelSimples mms = new MediaMovelSimples(new IndicadorAbertura());
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
		
		assertEquals(3.33, mms.calcula(4, 3, serie), 0.01);
	}

}
