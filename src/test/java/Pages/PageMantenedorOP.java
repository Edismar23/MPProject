package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.SleepTime;

public class PageMantenedorOP {
	private WebDriver driver;
	private By menu;
	private By subMenu;
	private By negocio;
	private By ingresar;
	
	public PageMantenedorOP(WebDriver driver) {
		this.driver = driver;
		menu = By.xpath("/html/body/div[1]/div[1]/ul[2]/li/span");
		subMenu = By.linkText("Mantenedor OP"); 
		negocio = By.xpath("(//*[@name = 'empresa'])[2]");
		ingresar = By.xpath("//*[@name = 'ingresar']");
  }
	
	public void selectMantOP() {
		
		WebElement element = driver.findElement(menu);  // seleccionar de una lista de menú
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(subMenu).click();
        SleepTime sleepTime = new SleepTime();
		sleepTime.Esperar(5);
		
}
	public void selectNegocio(String neg) {
		Select selectTo = new Select(driver.findElement(negocio));
		selectTo.selectByVisibleText(neg);	
	}
	
	public void Ingresar() {
		driver.findElement(ingresar).click();
		
	}
}
