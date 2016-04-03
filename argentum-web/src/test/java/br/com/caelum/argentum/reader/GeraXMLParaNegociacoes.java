package br.com.caelum.argentum.reader;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;

public class GeraXMLParaNegociacoes {

	public static void main(String[] args) throws IOException {
		Negociacao negociacao1 = new Negociacao(42.2, 1200, Calendar.getInstance());
		Negociacao negociacao2 = new Negociacao(38.2, 700, Calendar.getInstance());
		Negociacao negociacao3 = new Negociacao(46.0, 1000, Calendar.getInstance());

		List<Negociacao> negociacoes = new ArrayList<>();
		negociacoes.add(negociacao1);
		negociacoes.add(negociacao2);
		negociacoes.add(negociacao3);
		
		XStream stream = new XStream(new DomDriver());
		
		stream.alias("negociacao", Negociacao.class);
		stream.setMode(XStream.NO_REFERENCES);
		
		String xmlNegociacoes = stream.toXML(negociacoes);
		
		System.out.println(xmlNegociacoes);
		
		PrintStream saida = new PrintStream(new File("negociacoes.xml"));
		saida.println(xmlNegociacoes);
		saida.close();
	}

}
