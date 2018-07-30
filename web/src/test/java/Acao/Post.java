package Acao;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Suporte.ComandosPadrao;

public class Post extends ComandosPadrao {
	
	
	JavascriptExecutor executor = (JavascriptExecutor) navegador;

	public Post(WebDriver navegador) {
		super(navegador);
	}

	public Post publicarTexto() throws InterruptedException {

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

		validacao();

		return this;
	}

	
	public Post publicarLink() throws InterruptedException {

		// PUBLICAR LINK

		WebElement btnLink = navegador.findElement(
				By.xpath("//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_link_tab\"]/span"));
		btnLink.click();

		WebElement DescricaoDoLink = navegador.findElement(By.xpath(
				"//div[@id=\"river_post_link_tab\"]//div[@class=\"form-group\"]//div[@class=\"md-editor\"]/textarea[@placeholder=\"Compartilhe novidades e sugestões\"]"));
		executor.executeScript("arguments[0].click();", DescricaoDoLink);

		DescricaoDoLink.sendKeys(
				"A linha EDUXE foi desenvolvida pensando em sempre enxergar além do óbvio. É uma solução completa e realmente integrada para a instituição de ensino, ...");

		Thread.sleep(1000);
		WebElement FixarNoTopo = navegador.findElement(By.xpath(
				"//div[@id=\"river_post_link_tab\"]//div[@class=\"col-sm-6\"]/div/label//input[@type=\"checkbox\" and @name = \"pin\"] "));
		FixarNoTopo.click();
		Thread.sleep(1000);

		WebElement TituloDoLink = navegador.findElement(By.name("post_link_title[]"));
		TituloDoLink.click();
		TituloDoLink.sendKeys("EDUXE - Bett Educar 2018 | Transformando a educação");
		Thread.sleep(1000);
		WebElement inserindolink = navegador.findElement(By.name("post_link[]"));
		inserindolink.click();
		inserindolink.sendKeys("https://www.bettbrasileducar.com.br/expositores/eduxe");

		Thread.sleep(2000);

		WebElement publicar = navegador
				.findElement(By.xpath("//div[@id=\"river_post_link_tab\"]//button[@type=\"submit\"]"));
		executor.executeScript("arguments[0].click();", publicar);

		validacao();

		return this;
	}

	public Post publicarArquivo() throws InterruptedException {
		
		String tipo = "uploadFile";
		WebElement btnArquivo = navegador.findElement(
				By.xpath("//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_files_tab\"]/span"));
		btnArquivo.click();

		WebElement descricaoArquivo = navegador
				.findElement(By.xpath("//div[@id=\"river_post_files_tab\"]//div[@class=\"md-editor\"]//textarea"));
		executor.executeScript("arguments[0].click();", descricaoArquivo);
		descricaoArquivo.sendKeys("Qualquer coisa");
		
		WebElement tituloDoArquivo = navegador.findElement(By.name("post_file_title[]"));
		tituloDoArquivo.sendKeys("teste 2");
		
		upload("uploadFile");
		
		Thread.sleep(1000);
		WebElement FixarNoTopo = navegador.findElement(By.xpath(
				"//div[@id=\"river_post_files_tab\"]//div[@class=\"col-sm-6\"]/div/label//input[@type=\"checkbox\" and @name = \"pin\"] "));
		executor.executeScript("arguments[0].click();", FixarNoTopo);
		
		WebElement publicar = navegador
				.findElement(By.xpath("//div[@id=\"river_post_files_tab\"]//button[@type=\"submit\"]"));
		executor.executeScript("arguments[0].click();", publicar);
		
		validacao();

		return this;
	}
	
	public Post publicarFoto() throws InterruptedException {
		
		String tipo = "uploadFoto";
		
		WebElement btnFoto = navegador.findElement(
				By.xpath("//div[@class=\"river-post-types-tab\"]//a[@aria-controls=\"river_post_photo_tab\"]/span"));
		btnFoto.click();
		
		WebElement descricaoFoto = navegador.findElement(By.xpath("//div[@id=\"river_post_photo_tab\"]//div[@class=\"md-editor\"]//textarea"));
		executor.executeScript("arguments[0].click();", descricaoFoto);
		descricaoFoto.sendKeys("Páscoa 2018");
		
		Thread.sleep(1000);
		WebElement FixarNoTopo = navegador.findElement(By.xpath(
				"//div[@id=\"river_post_photo_tab\"]//div[@class=\"col-sm-6\"]/div/label//input[@type=\"checkbox\" and @name = \"pin\"] "));
		executor.executeScript("arguments[0].click();", FixarNoTopo);
		
		WebElement tituloFoto = navegador.findElement(By.name("post_photo_title[]"));
		tituloFoto.click();
		tituloFoto.sendKeys("Páscoa de novo");
		
		upload(tipo);
		
	
		
		WebElement publicar = navegador
				.findElement(By.xpath("//div[@id=\"river_post_photo_tab\"]//button[@type=\"submit\"]"));
		executor.executeScript("arguments[0].click();", publicar);
		
		validacao();		
		
		return this;
	}
	
	public void upload(String tipo) {
		
		
	       if(tipo == "uploadFoto"){
	    		WebElement uploadArquivo = navegador.findElement(By.name("post_photo_file[]"));
	    		uploadArquivo.sendKeys("C:\\Users\\alexandre.lima\\Desktop\\Automacao\\pascoa.jpg");
	            
	        }else if(tipo == "uploadFile"){
	         
	        	WebElement uploadArquivo = navegador.findElement(By.name("post_file[]"));
	    		uploadArquivo.sendKeys("C:\\Users\\alexandre.lima\\Desktop\\Automacao\\Rolim.jpg");
	        }
		
		
	}
	
	

	public Post validacao() throws InterruptedException {

		// Validar se funcionou

		Thread.sleep(2000);

		WebElement postCriadoSucesso = navegador.findElement(By.xpath("//div[@class=\"alert alert-success\"]"));
		String validacao = postCriadoSucesso.getText();
		assertEquals("×" + "\n" + "Post criado com sucesso", validacao);

		return this;
	}

	public Post editarPost() throws InterruptedException {

		// EDITAR POST
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

		return this;
	}

	public Post excluirPost() throws InterruptedException {

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

		return this;
	}
}
