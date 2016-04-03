package br.com.caelum.argentum.testes;

import java.util.Calendar;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;

public class TesteXStream {

	public static void main(String[] args) {
		Negociacao negociacao = new Negociacao(32.5, 120, Calendar.getInstance());
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("negociacao", Negociacao.class);
		
		System.out.println(xstream.toXML(negociacao));

	}

}
