package br.com.caelum.argentum.ws;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class ClienteWebServiceTest {

	@Test
	public void verificaSeWebServiceFunciona() {
		ClienteWebService clienteWebService = new ClienteWebService();
		List<Negociacao> negociacoes = clienteWebService.getNegociacoes();
		
		assertFalse(negociacoes.isEmpty());
	}

}
