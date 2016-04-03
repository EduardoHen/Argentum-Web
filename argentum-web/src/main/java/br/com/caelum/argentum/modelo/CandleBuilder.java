package br.com.caelum.argentum.modelo;

import java.lang.reflect.Field;
import java.util.Calendar;

public class CandleBuilder {
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	
	@SuppressWarnings("unused")
	private boolean aberturaBool = false;
	@SuppressWarnings("unused")
	private boolean fechamentoBool = false;
	@SuppressWarnings("unused")
	private boolean minimoBool = false;
	@SuppressWarnings("unused")
	private boolean maximoBool = false;
	@SuppressWarnings("unused")
	private boolean volumeBool = false;
	@SuppressWarnings("unused")
	private boolean dataBool = false;
	
	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		this.aberturaBool = true;
		return this;
	}
	
	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		this.fechamentoBool = true;
		return this;
	}
	
	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		this.minimoBool = true;
		return this;
	}
	
	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		this.maximoBool = true;
		return this;
	}
	
	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		this.volumeBool = true;
		return this;
	}
	
	public CandleBuilder comData(Calendar data) {
		this.data = data;
		this.dataBool = true;
		return this;
	}
	
	public Candle geraCandle(){
		Field[] atributos = this.getClass().getDeclaredFields();
		for(Field atributo : atributos){
			
			try {
				if((atributo.getType() == boolean.class) && (boolean)atributo.get(this) == false){
					throw new IllegalStateException("Falta informar o atributo " + atributo.getName());
				}
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return new Candle(abertura, fechamento, minimo, maximo, volume, data);
	}
	

}
