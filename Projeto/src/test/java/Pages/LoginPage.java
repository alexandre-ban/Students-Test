package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver navegador) {
		super(navegador);
	}

	public LoginFormPage clicarSignIn() {

		WebElement signIn = navegador.findElement(By.linkText("Sign in"));
		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		executor.executeScript("arguments[0].click();", signIn);

		return new LoginFormPage(navegador);
	}

}
