package br.com.caelum.argentum.modelo;

import java.util.List;

public class SerieTemporal {
	private final List<Candle> candles;
	
	public SerieTemporal(List<Candle> candles){
		if(candles.isEmpty() || candles == null){
			throw new IllegalArgumentException("A lista de candles está vazia!");
		}
		this.candles = candles;
	}
	
	public Candle getCandle(int i){
		if(i > this.candles.size() - 1 || i < 0){
			throw new IllegalArgumentException("Candle inexistente");
		}
		return this.candles.get(i);
	}
	
	public int getUltimaPosicao(){
		return this.candles.size() - 1;
	}
	
	public int size(){
		return this.candles.size();
	}
}
