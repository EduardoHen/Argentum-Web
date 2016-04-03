package br.com.caelum.argentum.managedbean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	private String mensagem = "Quem é voce?";
	private String nome;
	
	public String getMensagem(){
		return mensagem;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void nomeFoiDigitado(){
		
	}
}
