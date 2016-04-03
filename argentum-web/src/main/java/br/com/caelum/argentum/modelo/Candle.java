package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public final class Candle {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;
	
	public Candle(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		
		@SuppressWarnings("rawtypes")
		List argumentos = Arrays.asList(abertura, fechamento, minimo, maximo, volume);
		
		for(int c = 0; c < argumentos.size(); c++){
			if((double)argumentos.get(c) < 0){
				throw new IllegalArgumentException("Existem parametros com valores negativos!");
			}
		}
		
		if(data == null){
			throw new IllegalArgumentException("Voce informou a data nula!");
		}
		
		if(maximo < minimo){
			throw new IllegalArgumentException("O preco máximo informado é menor que o preço mínimo!");
		}
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}
	
	public boolean isAlta(){
		return this.abertura <= this.fechamento;
	}
	
	public boolean isBaixa(){
		return this.abertura > this.fechamento;
	}
	
	@Override
	public String toString() {
		String retorno;
		retorno = "Abertura: " + getAbertura() + "\n";
		retorno += "Fechamento: " + getFechamento() + "\n";
		retorno += "Minimo: " + getMinimo() + "\n";
		retorno += "Maximo: " + getMaximo() + "\n";
		retorno += "Volume: " + getVolume() + "\n";
		
		String data = new SimpleDateFormat("dd/MM/yyyy").format(this.data.getTime());
		retorno += "Data: " + data;
		
		return retorno;
	}
	
}
