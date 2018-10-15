package Acao;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Suporte.ComandosPadrao;
import net.bytebuddy.asm.Advice.Argument;

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

	public Provas adicionarQuestao(String questao) throws InterruptedException {

		if (questao == "alternativa") {

		} else if (questao == "dissertativa") {

			navegador.findElement(By.xpath("//a[2]")).click();

//			Thread.sleep(1000);
//			WebElement anexo = navegador.findElement(
//					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Anexo'])[1]/following::div[2]"));
//			Thread.sleep(1000);
//			anexo.click();
//			anexo.sendKeys("C:\\Users\\alexandre.lima\\Desktop\\Automacao\\pascoa.jpg");

			WebElement enunciado = navegador.findElement(By.xpath("//form[@id='question-form']/div[3]/div/textarea"));
			enunciado.click();
			enunciado.sendKeys("Prova Automação");

			WebElement valor = navegador.findElement(By.name("field_grade"));
			valor.click();
			valor.sendKeys("10");

			Thread.sleep(1000);
			navegador.findElement(By.xpath("//div[4]/button")).click();

			navegador.findElement(By.name("Save")).click();
		}

		return this;
	}

	public Provas excluirProva() {
		
		WebElement excluir = navegador.findElement(By.xpath("//table[@id='dt-scales']/tbody/tr/td[4]/div/a[3]/i"));
		executor.executeScript("arguments[0].click();", excluir);
		
		navegador.findElement(By.xpath("//div[@id='modal-confirm-remodal-content']/div/div[2]/form/button")).click();
		
		WebElement questionarioDeletado = navegador.findElement(By.xpath("//div[@id='messages-container']/div"));
		String validacao = questionarioDeletado.getText();
		assertEquals("×" + "\n" + "Questionário deletado", validacao);
		
		return this;
	}

}
