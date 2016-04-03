package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador{

	private Indicador outroIndicador;

	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
		
	}
	
	public double calcula(int posicao, int quantidadeDeDias, SerieTemporal serie){
		double soma = 0.0;
		
		for(int i = posicao; i > posicao - quantidadeDeDias; i--){
			soma += outroIndicador.calcula(i, quantidadeDeDias, serie);
		}
		
		return soma / quantidadeDeDias;
	}
	
	@Override
	public String toString() {
		return "Media Movel Simples de Fechamento";
	}
	
}
