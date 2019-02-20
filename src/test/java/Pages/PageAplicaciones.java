package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageAplicaciones {
	private WebDriver driver;
	private By aplicacion; 
	private By mpp;
	
	public PageAplicaciones(WebDriver driver) {
		this.driver = driver;
		aplicacion = By.id("fichas2");
		mpp = By.xpath("//*[@id=\"tabs-2\"]/ul/li[34]/a[2]/span");
	}
	
	
	public void selectAplicaciones() {
		driver.findElement(aplicacion).click();		
	}
	
	public void selectModulo() {
		driver.findElement(mpp).click();	
	}
}
