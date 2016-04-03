package br.com.caelum.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {
	private final String nomeMedia;
	private final String nomeIndicadorBase;
	private final String pacote = "br.com.caelum.argentum.indicadores.";
	
	public IndicadorFactory(String nomeMedia, String nomeIndicadorBase) {
		this.nomeMedia = nomeMedia;
		this.nomeIndicadorBase = nomeIndicadorBase;
	}
	
	public Indicador defineIndicador(){
		
		try{
			Class<?> classeIndicador = Class.forName(pacote + nomeIndicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicador.newInstance();
			
			Class<?> classeMediaMovel = Class.forName(pacote + nomeMedia);
			Constructor<?> construtorMediaMovel = classeMediaMovel.getConstructor(Indicador.class);
			Indicador mediaMovel = (Indicador) construtorMediaMovel.newInstance(indicadorBase);
			
			return mediaMovel;
			
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

}
