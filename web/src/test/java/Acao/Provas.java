package Acao;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Suporte.ComandosPadrao;

public class Provas extends ComandosPadrao {

	JavascriptExecutor executor = (JavascriptExecutor) navegador;

	public Provas(WebDriver navegador) {
		super(navegador);
	}

	public Provas criarProvas() throws InterruptedException {

		WebElement criarProvas = navegador.findElement(By.id("btn-add"));
		executor.executeScript("arguments[0].click();", criarProvas);
		
		WebElement titulo = navegador.findElement(By.name("title"));
		executor.executeScript("arguments[0].click();", titulo);
		Thread.sleep(1000);
		titulo.sendKeys("Teste");
		
		// Validar com o Rolim
		//cronometro(hora, minutos, segundos)
		
		return this;
	}
	
}
