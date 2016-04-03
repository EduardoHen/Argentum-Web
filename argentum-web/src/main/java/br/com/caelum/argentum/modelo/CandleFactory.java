package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class CandleFactory {
	public Candle constroiCandleParaData(Calendar data, List<Negociacao> negociacoes){
		Calendar dataDoCandle = negociacoes.isEmpty() ? Calendar.getInstance() : negociacoes.get(0).getData();
		for(Negociacao negociacao : negociacoes){
			if(negociacao.getData().before(dataDoCandle)){
				throw new IllegalStateException("Negociacoes em ordem errada!");
			}
		}
		
		double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double volume = 0;
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			double preco = negociacao.getPreco();
			if(preco > maximo){
				maximo = preco;
			}
			if(preco < minimo){
				minimo = preco;
			}
		}
		
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
		
		return new CandleBuilder().comAbertura(abertura).comFechamento(fechamento)
				.comMinimo(minimo).comMaximo(maximo).comVolume(volume).comData(data).geraCandle();
		
	}

	public List<Candle> constroiCandleParaData(List<Negociacao> negociacoes) {
		List<Candle> candles = new ArrayList<>();
		
		negociacoes.sort(new Comparator<Negociacao>() {
			@Override
			public int compare(Negociacao n1, Negociacao n2) {
				return n1.getData().compareTo(n2.getData());
			}
		});
		
		List<Negociacao> negociacoesSeparadasPorData = new ArrayList<>();
		Calendar data = negociacoes.get(0).getData();
		for(Negociacao negociacao : negociacoes){
			
			if(negociacao.isMesmoDia(data)){
				negociacoesSeparadasPorData.add(negociacao);
			}
			if(!negociacao.isMesmoDia(data) || negociacao == negociacoes.get(negociacoes.size() - 1)){
				
				candles.add(this.constroiCandleParaData(data, negociacoesSeparadasPorData));
				
				data = negociacao.getData();
				negociacoesSeparadasPorData = new ArrayList<>();
				negociacoesSeparadasPorData.add(negociacao);
			}
		}
		
		return candles;
	}

}
