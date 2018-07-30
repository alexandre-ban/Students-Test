package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Acao.Post;
import Suporte.ComandosPadrao;

public class Home extends ComandosPadrao{

	public Home(WebDriver navegador) {
		super(navegador);
	}

	public Post acaoPost() {		
		
		return new Post(navegador);		
	}
	
	public Mensagens acaoMensagem() {
		
		// MENU MENSAGENS
				WebElement menuMensagens = navegador
						.findElement(By.xpath("//div[@class=\"navbar-fixed-left\"]//a[@href=\"/message/message/index\"]"));
				menuMensagens.click();
		
		return new Mensagens(navegador);		
	}
}
