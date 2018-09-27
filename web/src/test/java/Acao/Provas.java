package Acao;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Suporte.ComandosPadrao;

public class Provas extends ComandosPadrao {

	JavascriptExecutor executor = (JavascriptExecutor) navegador;

	public Provas(WebDriver navegador) {
		super(navegador);
	}

	public Provas criarProvas(String titulo, String escala, String tempo, String questao) throws InterruptedException {

		WebElement criarProvas = navegador.findElement(By.id("btn-add"));
		executor.executeScript("arguments[0].click();", criarProvas);

		WebElement escreverTitulo = navegador.findElement(By.name("title"));
		executor.executeScript("arguments[0].click();", escreverTitulo);
		Thread.sleep(1000);
		escreverTitulo.sendKeys(titulo);

		navegador.findElement(By.xpath("//div[2]/div/div/button/span")).click();
		WebElement escreverEscala = navegador.findElement(By.xpath("//div/div/div/div/input"));
		escreverEscala.click();
		escreverEscala.sendKeys(escala);
		escreverEscala.sendKeys(Keys.ENTER);

		WebElement escolherTempo = navegador.findElement(By.name("timer"));
		escolherTempo.click();
		escolherTempo.clear();
		escolherTempo.sendKeys(tempo);
		escolherTempo.sendKeys(Keys.ENTER);

		adicionarQuestao(questao);

		return this;
	}

	public Provas adicionarQuestao(String questao) {

		if (questao == "alternativa") {

		} else if (questao == "dissertativa") {
			
			navegador.findElement(By.xpath("//a[2]")).click();
		}

		return this;	
	}

}
