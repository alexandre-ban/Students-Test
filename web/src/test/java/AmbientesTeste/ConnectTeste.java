package AmbientesTeste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Paginas.Login;
import Suporte.Navegador;

public class ConnectTeste {
	private WebDriver navegador;

	@Before
	public void setUp() {

		navegador = Navegador.createChrome();
	}

	// @Test
	public void testHomeCriacaoDePost() throws InterruptedException {

		new Login(navegador).fazerLogin("diretor", "quality")
		.acaoPost()
		.publicarTexto();
	}

	//@Test
	public void testMensagens() throws InterruptedException {

		new Login(navegador).fazerLogin("diretor", "quality")
		.acaoMensagem()
		.criarMensagem("mensagem");
	}

	@Test
	public void testCalendario() throws InterruptedException {
		
		new Login(navegador).fazerLogin("diretor", "quality")
		.acaoCalendario()
		.novoEvento()
		.excluir();		
	}
	
	//@Test
	public void testProvas() throws InterruptedException {
		
		new Login(navegador).fazerLogin("diretor", "quality")
		.acaoProva()
		.criarProvas();
	}

	@After
	public void tearDown() {
		// navegador.quit();
	}
}