package Acao;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Suporte.ComandosPadrao;

public class Mensagens extends ComandosPadrao {

	JavascriptExecutor executor = (JavascriptExecutor) navegador;

	public Mensagens(WebDriver navegador) {
		super(navegador);
	}

	public Mensagens menu(String tipo) {

		if (tipo == "caixa de entrada") {
			navegador.findElement(By.xpath(
					"//div[@class=\"margin-top-0 module-menu\"]//li/a[@href=\"/message/message/index/folder/281474977505366\"]"))
					.click();
		} else if (tipo == "enviadas") {
			navegador.findElement(By.xpath(
					"//div[@class=\"margin-top-0 module-menu\"]//li/a[@href=\"/message/message/index/folder/281474977505367\"]"))
					.click();
		} else if (tipo == "removidos") {
			navegador.findElement(By.xpath(
					"//div[@class=\"margin-top-0 module-menu\"]//li/a[@href=\"/message/message/index/folder/281474977505368\"]"))
					.click();
		} else if (tipo == "rascunho") {
			navegador.findElement(By.xpath(
					"//div[@class=\"margin-top-0 module-menu\"]//li/a[@href=\"/message/message/index/folder/281474977505369\"]"))
					.click();
		}
		return this;
	}

	public Mensagens criarMensagem(String tipoEnvio) throws InterruptedException {

		Thread.sleep(1000);

		// ESCREVER MENSAGENS
		WebElement novaMensagem = navegador.findElement(By.id("write-new-message"));
		novaMensagem.click();

		// Clicar na lupa

		WebElement enviarPara = navegador.findElement(By.name("message-add-recipients"));
		executor.executeScript("arguments[0].click();", enviarPara);

		// Selecionar "Publicar para:"
		navegador
				.findElement(By
						.xpath("//div[@class=\"btn-group bootstrap-select show-tick form-control container-select\"]"))
				.click();
		navegador.findElement(By.linkText("ANGLO ARARAS")).click();

		navegador.findElement(By.id("modal-message-search-remodal-content")).click();

		navegador.findElement(By.xpath(
				"//div[@class=\"form-group\"]/div[@class=\"btn-group bootstrap-select show-tick form-control role-select\"]"))
				.click();
		navegador.findElement(By.linkText("Diretor")).click();

		navegador.findElement(By.id("modal-message-search-remodal-content")).click();

		navegador
				.findElement(By.xpath(
						"//div[@class=\"form-group\"]//button[@class=\"btn btn-primary message-search-submit\"]"))
				.click();

		// CÓPIA OULTA NÃO FUNCIONA
		// selecionar cópia oculta

		// WebElement copiaOculta =
		// navegador.findElement(By.name("message-add-bcc-recipients"));
		// executor.executeScript("arguments[0].click();", copiaOculta);
		//
		// navegador
		// .findElement(By
		// .xpath("//div[@class=\"btn-group bootstrap-select show-tick form-control
		// container-select\"]"))
		// .click();
		// navegador.findElement(By.linkText("ANGLO ARARAS")).click();
		//
		// navegador.findElement(By.id("modal-message-search-remodal-content")).click();
		//
		// navegador.findElement(By.xpath(
		// "//div[@class=\"form-group\"]/div[@class=\"btn-group bootstrap-select
		// show-tick form-control role-select\"]"))
		// .click();
		// navegador.findElement(By.linkText("Diretor")).click();
		//
		// navegador.findElement(By.id("modal-message-search-remodal-content")).click();
		//
		// navegador
		// .findElement(By.xpath(
		// "//div[@class=\"form-group\"]//button[@class=\"btn btn-primary
		// message-search-submit\"]"))
		// .click();

		tipoEnvio(tipoEnvio);

		// navegador.findElement(By.xpath("//div[@class=\"text-right\"]//button[@data-action=\"send\"]")).click();

		return this;
	}

	// ------------------------------------------------------------------------------------

	public Mensagens tipoEnvio(String tipoEnvio) throws InterruptedException {

		WebElement SelecioneTipoDeMensagem = navegador.findElement(By.xpath(
				"//div[@class=\"dropdown-menu open\"]//div[@class=\"bs-searchbox\"]/input[@class=\"form-control\"]"));

		Thread.sleep(1000);

		WebElement tipoMensagem = navegador.findElement(By.xpath(
				"//div[@class=\"col-sm-6\"]//div[@class=\"btn-group bootstrap-select form-control\"]//button[@class=\"btn dropdown-toggle btn-default\"]"));

		tipoMensagem.click();
		Thread.sleep(1000);

		if (tipoEnvio == "autorização") {

			SelecioneTipoDeMensagem.click();
			SelecioneTipoDeMensagem.sendKeys(tipoEnvio);
			SelecioneTipoDeMensagem.sendKeys(Keys.ENTER);

			WebElement data = navegador.findElement(By.name("validity"));
			data.click();
			data.clear();
			data.sendKeys("31/12/2018");

			WebElement assunto = navegador.findElement(By.name("subject"));
			assunto.click();
			assunto.sendKeys("Excursão");

			// Escrever texto

		} else if (tipoEnvio == "notificação") {

			SelecioneTipoDeMensagem.click();
			SelecioneTipoDeMensagem.sendKeys(tipoEnvio);
			SelecioneTipoDeMensagem.sendKeys(Keys.ENTER);

			WebElement data = navegador.findElement(By.name("validity"));
			data.click();
			data.clear();
			data.sendKeys("31/12/2018");

			WebElement assunto = navegador.findElement(By.name("subject"));
			assunto.click();
			assunto.sendKeys("Feriado");

			// Escrever texto

		} else if (tipoEnvio == "mensagem") {

			SelecioneTipoDeMensagem.click();
			SelecioneTipoDeMensagem.sendKeys(tipoEnvio);
			SelecioneTipoDeMensagem.sendKeys(Keys.ENTER);

			WebElement assunto = navegador.findElement(By.name("subject"));
			assunto.click();
			assunto.sendKeys("Brasil");

			// Não está escrevendo
			WebElement conteudo = navegador.findElement(By.id("cke_1_contents"));
			conteudo.click();
			Thread.sleep(1000);
			conteudo.sendKeys(
					"A História do Brasil começa com a chegada dos primeiros humanos no continente americano há mais de 8.000 anos.");

		} else if (tipoEnvio == "convite") {

			SelecioneTipoDeMensagem.click();
			SelecioneTipoDeMensagem.sendKeys(tipoEnvio);
			SelecioneTipoDeMensagem.sendKeys(Keys.ENTER);

			WebElement data = navegador.findElement(By.name("validity"));
			data.click();
			data.clear();
			data.sendKeys("31/12/2018");

			WebElement assunto = navegador.findElement(By.name("subject"));
			assunto.click();
			assunto.sendKeys("Formatura");

			// Escrever texto

		} else if (tipoEnvio == "enquete") {

			SelecioneTipoDeMensagem.click();
			SelecioneTipoDeMensagem.sendKeys(tipoEnvio);
			SelecioneTipoDeMensagem.sendKeys(Keys.ENTER);

			WebElement assunto = navegador.findElement(By.name("subject"));
			assunto.click();
			assunto.sendKeys("Tema");

			WebElement opcao1 = navegador.findElement(By.name("status_option1"));
			opcao1.click();
			opcao1.sendKeys("Opção 1");
			WebElement opcao2 = navegador.findElement(By.name("status_option2"));
			opcao2.click();
			opcao2.sendKeys("Opção 2");
			WebElement opcao3 = navegador.findElement(By.name("status_option3"));
			opcao3.click();
			opcao3.sendKeys("Opção 3");
			WebElement opcao4 = navegador.findElement(By.name("status_option4"));
			opcao4.click();
			opcao4.sendKeys("Opção 4");

			// Escrever texto

		}

		return this;
	}

	// -------------------------------------------------------------------------------------

	public Mensagens atualizar() throws InterruptedException {

		// Clicar no botão atualizar
		WebElement atualizar = navegador.findElement(By.id("message-refresh"));
		atualizar.click();

		return this;
	}

	public Mensagens selecionarTodos() {

		// Clicar no botão selecionar todos
		WebElement selecionarTodos = navegador.findElement(By.id("message-select"));
		selecionarTodos.click();

		return this;
	}

	public Mensagens marcarComoLido(String marcado) throws InterruptedException {

		// Clicar no botão marcar como lido
		WebElement marcarComoLido = navegador.findElement(By.id("message-mark-read"));

		if (marcado == "S") {
			selecionarTodos();
			marcarComoLido.click();
			navegador.findElement(By.xpath(
					"//div[@class=\"wrapper-container padding-left-right-20 padding-top-bottom-20\"]/div/div[@class=\"alert alert-dismissible alert-success\"]"));
			System.out.println("A(s) mensagen(s) foi(ram) marcada(s) como lida(s)");
		} else {
			marcarComoLido.click();
			Thread.sleep(5000);
			navegador.findElement(By.xpath("//div[@id=\"modal-confirm\"]/div/div/div/button")).click();
		}
		return this;
	}

	public Mensagens marcarComoNaoLido(String marcado) throws InterruptedException {

		// Clicar no botão marcar como não lido
		WebElement marcarComoLidoNaoLido = navegador.findElement(By.id("message-mark-unread"));

		if (marcado == "S") {
			selecionarTodos();
			marcarComoLidoNaoLido.click();
			navegador.findElement(By.xpath(
					"//div[@class=\"wrapper-container padding-left-right-20 padding-top-bottom-20\"]/div/div[@class=\"alert alert-dismissible alert-success\"]"));
			System.out.println("A(s) mensagen(s) foi(ram) marcada(s) como não lida(s)");
		} else {
			marcarComoLidoNaoLido.click();
			Thread.sleep(5000);
			navegador.findElement(By.xpath("//div[@id=\"modal-confirm\"]/div/div/div/button")).click();
		}
		return this;
	}

	// -------------------------------------------------------------------------------------

	public Mensagens apagarMensagem() {

		// Clicar em apagar mensagem

		return this;
	}

	// -------------------------------------------------------------------------------------

	public Mensagens pesquisar(String pesquisa) {

		// pesquisar alguma mesagem
		WebElement pesquisar = navegador.findElement(By.className("message-search"));
		executor.executeScript("arguments[0].click();", pesquisar);
		pesquisar.sendKeys(pesquisa);

		return this;
	}

}
