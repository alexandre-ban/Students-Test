package Suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navegador {

	public static WebDriver createChrome() {

		// Abrindo o navegador
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexandre.lima\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ban\\Desktop\\Repositorio\\Drivers\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.manage().window().maximize();

		// Navegando até a página
		navegador.get("https://qa.wenodes.com");
		
		return navegador;
	}
}


