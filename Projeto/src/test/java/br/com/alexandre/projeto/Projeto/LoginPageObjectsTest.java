package br.com.alexandre.projeto.Projeto;

import static org.junit.Assert.*;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Pages.LoginPage;
import Suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LoginPageObjectsTest.csv")

public class LoginPageObjectsTest {
	private WebDriver navegador;

	@Before
	public void setUp() {
		navegador = Web.createChrome();
	}

	@Test
	public void testLogin(
			@Param(name = "login") String login, 
			@Param(name = "senha") String senha,
			@Param(name = "tipo") String tipo,
			@Param(name = "contato") String contato,
			@Param(name = "mensagem") String mensagemEsperada) {

		String textoToast = new LoginPage(navegador)
				.clicarSignIn()
				.fazerLogin(login, senha)
				.clicarMe()
				.clicarAbaMoreDataAboutYou()
				.clicarBotaoMoreDataAboutYou()
				.adicionarContato(tipo, contato)
				.capturarTextoToast();

		assertEquals(mensagemEsperada, textoToast);
	}

	@After
	public void tearDown() {
		// navegador.quit();
	}
}
