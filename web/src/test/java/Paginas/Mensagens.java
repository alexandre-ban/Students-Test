package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Suporte.ComandosPadrao;

public class Mensagens extends ComandosPadrao {

	JavascriptExecutor executor = (JavascriptExecutor) navegador;

	public Mensagens(WebDriver navegador) {
		super(navegador);
	}

	public Mensagens criarMensagem() throws InterruptedException {

		Thread.sleep(1000);

		// ESCREVER MENSAGENS
		WebElement novaMensagem = navegador.findElement(By.id("write-new-message"));
		novaMensagem.click();
		
		return this;
	}
}
