package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador{
	
	private Indicador outroIndicador;

	public MediaMovelPonderada(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}
	
	public double calcula(int posicao, int quantidadeDeDias, SerieTemporal serie){
		double soma = 0.0;
		int peso = quantidadeDeDias;
		
		for(int i = posicao; i > posicao - quantidadeDeDias; i--){
			soma += outroIndicador.calcula(i, quantidadeDeDias, serie) * peso;
			peso--;
		}
		int divisor =  0;
		
		for(int i = quantidadeDeDias; i >= 1; i--){
			divisor += i;
		}
		
		return soma / divisor;
	}
	
	@Override
	public String toString() {
		return "Media Movel Ponderada de Fechamento";
	}

}