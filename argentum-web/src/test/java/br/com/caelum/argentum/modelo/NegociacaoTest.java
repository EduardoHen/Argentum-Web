package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;
import org.junit.Test;

public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoEhImutavel() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		
		Negociacao negociacao = new Negociacao(10, 5, c);
		
		negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula(){
		new Negociacao(10, 5, null);
	}
	
	@Test
	public void mesmoMilisegundoEhDoMesmoDia(){
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorariosDiferentesEhNoMesmoDia(){
		Calendar manha = new GregorianCalendar(2016, 02, 14, 8, 30);
		Calendar tarde = new GregorianCalendar(2016, 02, 14, 15, 30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(){
		Calendar diaAtual = Calendar.getInstance();
		Negociacao negociacao = new Negociacao(40.0, 100, diaAtual);
		
		Calendar umMesAtrasNoMesmoDia = Calendar.getInstance();
		umMesAtrasNoMesmoDia.add(Calendar.MONTH, -1);
		
		assertFalse(negociacao.isMesmoDia(umMesAtrasNoMesmoDia));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia(){
		Calendar dataAtual = Calendar.getInstance();
		Negociacao negociacao = new Negociacao(40.0, 100, dataAtual);
		
		Calendar mesmoDiaEhMesUmAnoAtras = Calendar.getInstance();
		mesmoDiaEhMesUmAnoAtras.add(Calendar.YEAR, -1);
		
		assertFalse(negociacao.isMesmoDia(mesmoDiaEhMesUmAnoAtras));
	}

}
