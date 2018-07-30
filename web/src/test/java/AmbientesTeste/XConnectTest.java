package AmbientesTeste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument.WhiteSpace.Value;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XConnectTest {

	private WebDriver navegador;

	@Before
	public void setUP() {

		// Abrindo o navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexandre.lima\\Drivers\\chromedriver.exe");

		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.manage().window().maximize();

		// Navegando até a página
		navegador.get("https://qa.wenodes.com");

		// Login
		navegador.findElement(By.id("username")).sendKeys("diretor");

		// Senha
		navegador.findElement(By.id("password")).sendKeys("quality");

		// Entrar
		navegador.findElement(By.id("imageField")).click();
	}

	// @Test
	public void testTexto() throws InterruptedException {

		// PUBLICAR TEXTO

		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		// Escrever texto
		WebElement btnTexto = navegador.findElement(
				By.xpath("//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_text_tab\"]/span"));
		Thread.sleep(800);
		executor.executeScript("arguments[0].click();", btnTexto);
		WebElement content = navegador.findElement(By.name("content"));
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.visibilityOf(content));
		content.click();
		content.clear();
		content.sendKeys(
				"teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto"
						+ " teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de"
						+ " texto teste de texto teste de texto teste de texto teste de texto teste de texto ");

		// Publicar texto
		WebElement btnPublicar = navegador.findElement(By.name("submit"));
		executor.executeScript("arguments[0].click();", btnPublicar);

		/*
		 * // Validação do post WebElement msgAlerta = navegador .findElement(By.
		 * xpath("//div[@id=\"messages-container\"]//div[@class=\"alert alert-success\"]"
		 * )); wait.until(ExpectedConditions.visibilityOf(msgAlerta)); String alerta =
		 * msgAlerta.getText(); assertEquals("×" + "" + "Post criado com sucesso",
		 * alerta);
		 */

		// EDITAR TEXTO

		Thread.sleep(1000);
		WebElement engrenagemEditar = navegador.findElement(By.xpath(
				"//div[@class=\"river-post-menu col-sm-5 text-left\"]//button[@class=\"btn-icon river-post-menu-button primary\"]//span"));
		engrenagemEditar.click();

		Thread.sleep(2000);
		WebElement btnEditar = navegador.findElement(By.linkText("Editar"));
		btnEditar.click();

		WebElement editar = navegador.findElement(By.xpath("//div[2]/div/div/textarea"));
		editar.click();
		editar.clear();
		editar.sendKeys(
				"Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil "
						+ "Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil"
						+ " Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil "
						+ "Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil Brasil ");

		Thread.sleep(1000);
		navegador
				.findElement(By.xpath(
						"//div[3]/div/div/div/div[2]/div/button[@class=\"btn-primary btn river-content-submit\"]"))
				.click();

		// REMOVER TEXTO
		Thread.sleep(1000);
		WebElement engrenagemRemover = navegador.findElement(By.xpath(
				"//div[@class=\"river-post-menu col-sm-5 text-left\"]//button[@class=\"btn-icon river-post-menu-button primary\"]//span"));
		engrenagemRemover.click();

		Thread.sleep(2000);
		WebElement btnRemover = navegador.findElement(By.linkText("Remover"));
		btnRemover.click();

		Thread.sleep(1000);
		WebElement remover = navegador.findElement(By.xpath("//div[@class=\"col-xs-12 col-sm-6\"]//button"));
		remover.click();

		
	}

	@Test
	public void testLink() throws InterruptedException {

		// PUBLICAR LINK

		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		WebElement btnLink = navegador.findElement(
				By.xpath("//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_link_tab\"]/span"));
		btnLink.click();

		Thread.sleep(1000);

		WebElement descricaoLink = navegador.findElement(By.xpath("//div[@class=\"md-editor active\"]"));
		executor.executeScript("arguments[0].click();", descricaoLink);
		
		Thread.sleep(1000);
		WebElement tituloLink = navegador.findElement(By.name("post_link_title[]"));
		tituloLink.click();
		tituloLink.sendKeys("Pudim");

		WebElement link = navegador.findElement(By.name("post_link[]"));
		link.click();
		link.sendKeys("https://youtu.be/O4z2AdG26YY");

	

		WebElement escreverLink = navegador.findElement(By.xpath("//div[@class=\"form-group\"]/div/textarea"));
		executor.executeScript("arguments[0].click();", escreverLink);

		// NÃO ENCONTRA O CAMPO PARA ESCREVER UMA DESCRIÇÃO.
		escreverLink.sendKeys("teste");

		WebElement publicar = navegador.findElement(By.name("submit"));
		executor.executeScript("arguments[0].click();", publicar);

}

	// @Test
	public void testArquivo() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		navegador
				.findElement(By.xpath(
						"//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_files_tab\"]/span"))
				.click();
	}

	// @Test
	public void testPhoto() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		navegador
				.findElement(By.xpath(
						"//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_photo_tab\"]/span"))
				.click();
	}

	// @Test
	public void testVideo() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		navegador
				.findElement(By.xpath(
						"//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_video_tab\"]/span"))
				.click();

	}

	//@Test
	public void testMensagens() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		// MENU MENSAGENS
		WebElement menuMensagens = navegador
				.findElement(By.xpath("//div[@class=\"navbar-fixed-left\"]//a[@href=\"/message/message/index\"]"));
		menuMensagens.click();

		// ESCREVER MENSAGENS
		WebElement novaMensagem = navegador.findElement(By.xpath(
				"//div[@class=\"folder-options-header panel-heading\"]//a/span[@class=\"fa fa fa-plus fa-lg \"]"));
		executor.executeScript("arguments[0].click();", novaMensagem);
		
		WebElement enviarPara = navegador.findElement(By.xpath("//form[@id='compose-message']/fieldset/div/div[1]/div/span"));
		executor.executeScript("arguments[0].click();", enviarPara);
		//APARECE QUE NÃO PODE FOCAR NO CAMPO
		
		enviarPara.click();
		enviarPara.sendKeys("alexandre.lima@eduxe.com.br");
		
		/*
		WebElement copiaOculta = navegador.findElement(By.xpath("//form[@id='compose-message']/fieldset/div/div[2]/div/span"));
		executor.executeScript("arguments[0].click();", copiaOculta);
		//copiaOculta.sendKeys("teste");
		*/
	}

	// @Test
	public void testAmbiente() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		// Selecionar ambiente
		navegador.findElement(By.xpath("//div[@class=\"input-group\"]//a[@title=\"Selecionar ambiente\"]")).click();

		WebElement container = navegador.findElement(By.id("container-menu-body"));
		container.findElement(By.className("box-container-menu-list")).click();

		WebElement selected = navegador.findElement(
				By.xpath("//div[@id=\"container-menu-list\"]//select[@data-parent-container-id=\"281474976813094\"]"));
		new org.openqa.selenium.support.ui.Select(selected).selectByValue("281474976813095");

		WebElement selected1 = navegador.findElement(
				By.xpath("//div[@id=\"container-menu-list\"]//select[@data-parent-container-id=\"281474976813095\"]"));
		new org.openqa.selenium.support.ui.Select(selected1).selectByValue("281474976813098");

		WebElement selected2 = navegador.findElement(
				By.xpath("//div[@id=\"container-menu-list\"]//select[@data-parent-container-id=\"281474976813098\"]"));
		new org.openqa.selenium.support.ui.Select(selected2).selectByValue("281474976813102");

		WebElement selected3 = navegador.findElement(
				By.xpath("//div[@id=\"container-menu-list\"]//select[@data-parent-container-id=\"281474976813102\"]"));
		new org.openqa.selenium.support.ui.Select(selected3).selectByValue("281474976813117");

		WebElement selected4 = navegador.findElement(
				By.xpath("//div[@id=\"container-menu-list\"]//select[@data-parent-container-id=\"281474976813117\"]"));
		new org.openqa.selenium.support.ui.Select(selected4).selectByValue("281474976813130");

		// Entrar no ambiente
		WebElement Entrar = navegador.findElement(By.id("container-menu-confirm"));
		Thread.sleep(3000);
		// clicar no botão Entrar
		executor.executeScript("arguments[0].click();", Entrar);

		// Escrever texto
		WebElement btnTexto = navegador.findElement(
				By.xpath("//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_text_tab\"]/span"));
		Thread.sleep(800);
		executor.executeScript("arguments[0].click();", btnTexto);
		WebElement content = navegador.findElement(By.name("content"));
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.visibilityOf(content));
		content.click();
		content.clear();
		content.sendKeys(
				"teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto"
						+ " teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de texto teste de"
						+ " texto teste de texto teste de texto teste de texto teste de texto teste de texto ");

		// Publicar texto
		WebElement btnPublicar = navegador.findElement(By.name("submit"));
		executor.executeScript("arguments[0].click();", btnPublicar);

		// Validação do post
		WebElement msgAlerta = navegador
				.findElement(By.xpath("//div[@id=\"messages-container\"]//div[@class=\"alert alert-success\"]"));
		wait.until(ExpectedConditions.visibilityOf(msgAlerta));
		String alerta = msgAlerta.getText();
		assertEquals("×" + "" + "Post criado com sucesso", alerta);

	}

}
