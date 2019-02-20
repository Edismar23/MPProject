package Pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;

import Utility.SleepTime;



public class PageLogin {
	private WebDriver driver;
	private By userField;
	private By passField;
	private By loginButton;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userField = By.name("rut_aux");
		passField = By.name("clave_aux");
		loginButton = By.name("Submit"); 
	}

	public void Login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(loginButton).click();
		SleepTime sleepTime = new SleepTime();
		sleepTime.Esperar(5);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //espera maximo 10 segundos que cargue la pag, sino arroja timeout

	}
	
	
}
