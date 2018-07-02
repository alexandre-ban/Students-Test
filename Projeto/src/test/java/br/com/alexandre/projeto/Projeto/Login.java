package br.com.alexandre.projeto.Projeto;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.jetty.html.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.codemodel.util.Surrogate.Generator;

import Suporte.ScreenShot;

public class Login {

	private WebDriver navegador;

	@Before
	public void setUP() {

		// Abrindo o navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anselmo.alcantara\\Drivers\\chromedriver.exe");

		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.manage().window().maximize();

		// Navegando até a página
		navegador.get("http://www.juliodelima.com.br/taskit");

		WebElement signIn = navegador.findElement(By.linkText("Sign in"));
		JavascriptExecutor executor = (JavascriptExecutor) navegador;
		executor.executeScript("arguments[0].click();", signIn);

		// Encontrar o formulário
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		navegador.findElement(By.linkText("SIGN IN")).click();

		// Validar se funcionou WebElement me =
		WebElement me = navegador.findElement(By.className("me"));
		String meunome = me.getText();

		// Essa linha ta errada, mas assim funciona
		assertEquals("Hi, Julio", meunome);

		// Clicar em Hi, Julio
		navegador.findElement(By.className("me")).click();

		// Clicar em more data about you
		navegador.findElement(By.xpath("//div[@class=\"col s12\"]//a[@href=\"#moredata\"]")).click();

	}

	@Test
	public void testLogin() throws InterruptedException {

		// Clicar em + ADD MORE DATA
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

		ScreenShot.tirar(navegador, "C:\\Users\\anselmo.alcantara\\Drivers\\"+Suporte.Generator.dataHora()+ "AlexandreBanContato.png");
		
		// Clicar em type e selecionar phone
		WebElement type = navegador.findElement(By.name("type"));
		new org.openqa.selenium.support.ui.Select(type).selectByVisibleText("Phone");
/*
		// Digitar em contact
		navegador.findElement(By.name("contact")).sendKeys("BAN.132");

		// Clicar em save
		navegador.findElement(By.xpath("//div[@class=\"modal-footer\"]//a[@class=\"modal-action waves-effect waves-green btn-flat\"]")).click();

		// verificar toast-container
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Your contact has been added!", mensagem);
*/
	}

	//@Test
	public void removerContato() {
		// Clicar no elemento
		navegador.findElement(By.xpath("//span[text()=\"BAN.132\"]/following-sibling::a")).click();

		// Clicar na janela JavaScript
		navegador.switchTo().alert().accept();

		// Validar a mensagem "Rest in peace, dear phone!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);

		// 10 segundos para a janela desaparecer
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

		// Logout
		navegador.findElement(By.linkText("Logout")).click();

	}

	@After
	public void tearDown() {
		// Fechar Navegador
		// navegador.quit();
	}
}