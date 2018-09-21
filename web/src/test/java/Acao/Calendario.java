package Acao;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Suporte.ComandosPadrao;

public class Calendario extends ComandosPadrao {

	JavascriptExecutor executor = (JavascriptExecutor) navegador;

	public Calendario(WebDriver navegador) {
		super(navegador);

	}

	public Calendario novoEvento() throws InterruptedException {

		navegador
				.findElement(By.xpath(
						"//div[@id=\"event-calendar\"]//button[@class=\"btn btn-circle fc-create-button\"]/span"))
				.click();

		WebElement titulo = navegador.findElement(By.xpath("//div[@class=\"form-group\"]//input[@name=\"title\"]"));
		titulo.sendKeys("Teste");

		navegador
				.findElement(By
						.xpath("(.//*[normalize-space(text()) and normalize-space(.)='school'])[1]/following::span[1]"))
				.click();
		navegador.findElement(By.linkText("ANGLO ARARAS")).click();
		executor.executeScript("arguments[0].click();", titulo);

		WebElement descricao = navegador.findElement(By.xpath("//div[@class=\"md-editor\"]/textarea"));
		descricao.click();
		descricao.sendKeys("Rolim");

		navegador.findElement(By.xpath("//div[@id='event-calendar']/div[3]/div[2]/form/div/div/div[3]/div/div/label"))
				.click();

		// Campo data Inicio
		navegador
				.findElement(By.xpath(
						"//div[@class=\"form-group\"]//div[@class=\"input-group date\"]//input[@name=\"start\"]"))
				.click();
		// Encontrar o filtro
		navegador
				.findElement(By.xpath(
						"(.//*[normalize-space(text()) and normalize-space(.)='date_range'])[1]/following::th[2]"))
				.click();
		// Selecionar mês
		navegador
				.findElement(
						By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Nov'])[1]/following::span[1]"))
				.click();
		// Selecionar dia
		navegador
				.findElement(
						By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::td[31]"))
				.click();
		// Campo data fim
		navegador
				.findElement(By
						.xpath("//div[@class=\"form-group\"]//div[@class=\"input-group date\"]//input[@name=\"end\"]"))
				.click();
		// Encontrar o filtro
		navegador
				.findElement(By.xpath(
						"(.//*[normalize-space(text()) and normalize-space(.)='date_range'])[2]/following::th[2]"))
				.click();
		// Selecionar mês
		navegador.findElement(By.xpath(
				"//div[@id='event-calendar']/div[3]/div[2]/form/div/div/div[2]/div/div/div/ul/li/div/div[2]/table/tbody/tr/td/span[12]"))
				.click();
		// Selecionar dia
		navegador.findElement(By.xpath(
				"//div[@id='event-calendar']/div[3]/div[2]/form/div/div/div[2]/div/div/div/ul/li/div/div/table/tbody/tr[5]/td[4]"))
				.click();

		WebElement notificar = navegador
				.findElement(By.xpath("//div[@id='event-calendar']/div[3]/div[2]/form/div[2]/div/div/button/span"));
		notificar.click();
		navegador
				.findElement(By.xpath("//div[@id='event-calendar']/div[3]/div[2]/form/div[2]/div/div/div/ul/li/a/span"))
				.click();
		notificar.click();
		
		navegador.findElement(By.xpath("//div[@id='event-calendar']/div[3]/div[2]/form/div[3]/button")).click();

		return this;
	}

	public Calendario lerMais(String pesquisa) {

		navegador.findElement(By.xpath("//div[6]/a")).click();
		
		if (pesquisa == "s") {
			
			WebElement pesquisar = navegador.findElement(By.xpath("//div[@id='table-event-list-grid_filter']/label/input"));
			pesquisar.click();
			pesquisar.sendKeys("trabalhador");
		}
		

		return this;
	}

}
