package br.com.caelum.argentum.aceitacao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeraGraficoTest {
	private static final String url = "http://localhost:8080/argentum-web/index.xhtml";
	private WebDriver driver;

	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@After
	public void tearDown(){
		driver.close();
	}
	
	@Test
	public void testeAoGerarGraficoSemTituloUmaMensagemEhApresentada(){
		
		WebElement titulo = driver.findElement(By.id("dadosGrafico:titulo"));
		
		titulo.sendKeys("");
		titulo.submit();
		
		boolean existeMensagem = driver.getPageSource().contains("Erro de Validacao");
		
		Assert.assertTrue(existeMensagem);
		
	}
}
