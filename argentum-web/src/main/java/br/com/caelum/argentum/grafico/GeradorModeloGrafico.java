package br.com.caelum.argentum.grafico;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico {
	private SerieTemporal serie;
	private int inicio;
	private int fim;
	private LineChartModel modeloGrafico;
	
	public GeradorModeloGrafico(SerieTemporal serie, int inicio, int fim){
		this.serie = serie;
		this.inicio = inicio;
		this.fim = fim;
		this.modeloGrafico = new LineChartModel();
		this.modeloGrafico.setAnimate(true);
	}
	
	public void plotaIndicador(Indicador indicador, int quantidadeDeDias){
		
		ChartSeries chartSerie = new ChartSeries(indicador.toString());
		
		for(int i = this.inicio; i <= this.fim; i++){
			double valor = indicador.calcula(i, quantidadeDeDias, serie);
			chartSerie.set(i, valor);
		}
		chartSerie.setLabel(indicador.toString());
		this.modeloGrafico.setLegendPosition("e");
		this.modeloGrafico.setShadow(true);
		this.modeloGrafico.setTitle("Indicadores");
		this.modeloGrafico.addSeries(chartSerie);
	}
	
	public ChartModel getModeloGrafico(){
		return this.modeloGrafico;
	}

}
