package br.com.caelum.argentum.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorFactory;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean {
	
	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	private String nomeMedia;
	private String nomeIndicadorBase;
	
	public ArgentumBean(){
		this.negociacoes = new ClienteWebService().getNegociacoes();
		this.nomeMedia = "MediaMovelSimples";
		this.nomeIndicadorBase = "IndicadorFechamento";
		geraGrafico();
		
	}

	public void geraGrafico() {
		System.out.println("PLOTANDO: " + nomeMedia + " de " + nomeIndicadorBase);
		List<Candle> candles = new CandleFactory().constroiCandleParaData(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorModeloGrafico geradorDeGraficos = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		
		geradorDeGraficos.plotaIndicador(new IndicadorFactory(nomeMedia, nomeIndicadorBase).defineIndicador(), 3);
		
		this.modeloGrafico = geradorDeGraficos.getModeloGrafico();
	}
	
	public ChartModel getModeloGrafico(){
		return this.modeloGrafico;
	}
	
	public List<Negociacao> getNegociacoes(){
		return negociacoes;
	}

	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getNomeIndicadorBase() {
		return nomeIndicadorBase;
	}

	public void setNomeIndicadorBase(String nomeIndicadorBase) {
		this.nomeIndicadorBase = nomeIndicadorBase;
	}
}
