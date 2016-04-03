package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador {

	@Override
	public double calcula(int posicao, int quantidadeDeDias, SerieTemporal serie) {
		return serie.getCandle(posicao).getFechamento();
	}
	
	@Override
	public String toString() {
		return "Fechamento";
	}

}
