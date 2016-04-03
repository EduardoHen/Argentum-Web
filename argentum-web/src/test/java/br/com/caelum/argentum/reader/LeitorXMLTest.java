package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list> "+
							"	<negociacao> "+
						    "	    <preco>43.5</preco> "+
						    "	    <quantidade>1000</quantidade> "+
						    "	    <data> "+
						    "	        <time>1222333777999</time> "+
						    "	    </data> "+
						    "	</negociacao> "+
					        "</list> ";
		
		LeitorXML leitorXML = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitorXML.carrega(xml);
		
		assertEquals(1, negociacoes.size());
		assertEquals(43.5, negociacoes.get(0).getPreco(), 0.00001);
		assertEquals(1000, negociacoes.get(0).getQuantidade());
	}
	
	@Test
	public void carregaXmlComZeroNegociacoes(){
		String xmlDeTeste = "<list></list>";
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("negociacoes", Negociacao.class);
		List<Negociacao> negociacoes = new LeitorXML().carrega(xml);
		
		assertEquals(0, negociacoes.size());
	}
	
	@Test
	public void carregaXmlSemTagPreco(){
		String xmlDeTeste = "<list> "+
							"	<negociacao> "+
							"	    <quantidade>1000</quantidade> "+
							"	    <data> "+
							"	        <time>1222333777999</time> "+
							"	    </data> "+
							"	</negociacao> "+
							"</list> ";
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = new LeitorXML().carrega(xml);
		
		assertEquals(1, negociacoes.size());
		assertEquals(0, negociacoes.get(0).getPreco(), 0.00001);
	}
	
	@Test
	public void carregaXmlComVariaNegociacoes(){
		InputStream xmlDeTeste = null;
		try {
			xmlDeTeste = new FileInputStream(this.getClass().getResource("negociacoes.xml").getPath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Negociacao> negociacoes = new LeitorXML().carrega(xmlDeTeste);
		
		assertEquals(3, negociacoes.size());
		assertEquals(700, negociacoes.get(1).getQuantidade());
		
	}

}
