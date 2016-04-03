package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorAbertura implements Indicador {

	@Override
	public double calcula(int posicao, int quantidadeDeDias, SerieTemporal serie) {
		return serie.getCandle(posicao).getAbertura();
	}
	
	@Override
	public String toString() {
		return "Abertura";
	}

}
