package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Suporte.ComandosPadrao;

public class Login extends ComandosPadrao {

	public Login(WebDriver navegador) {
		super(navegador);
	}

	public Home fazerLogin(String login, String senha) {

		// Login
		navegador.findElement(By.id("username")).sendKeys(login);

		// Senha
		navegador.findElement(By.id("password")).sendKeys(senha);

		// Entrar
		navegador.findElement(By.id("imageField")).click();
		
		return new Home(navegador);
	}
}
