package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.PageAplicaciones;
import Pages.PageLogin;
import Pages.PageMantenedorOP;


public class Drivers {
	
	public static WebDriver driver;
	static String browser = "chrome";
	
	@BeforeMethod
	public static void Setup() {
		if (browser.equalsIgnoreCase("ie")) {

			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			 capabilities.setCapability("requireWindowFocus", true);
			 System.setProperty("webdriver.ie.driver", "./IEDriver/IEDriverServer.exe");
			 driver = new InternetExplorerDriver(capabilities);
			 driver.navigate().to("https://testfalanet.falabella.com/admfats/PRT/logica/jsp/PRTFFInicio.jsp");
			 SleepTime sleepTime = new SleepTime();
			 sleepTime.Esperar(5);

		 }

		 if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./DriverChrome/chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("https://testfalanet.falabella.com/admfats/PRT/logica/jsp/PRTFFInicio.jsp");
			SleepTime sleepTime = new SleepTime();
			sleepTime.Esperar(5);
		 }
	}
	
	@Test
	public void MantenedorOP() {
		driver.manage().window().maximize();
		PageMantenedorOP pageMantenedor = new PageMantenedorOP(driver);		
		PageAplicaciones pageAplicaciones = new PageAplicaciones(driver);
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("25579499","Edismar23.");
		pageAplicaciones.selectAplicaciones();
		pageAplicaciones.selectModulo();
		pageMantenedor.selectMantOP();
		pageMantenedor.selectNegocio("SODIMAC PERU S.A.");
		pageMantenedor.Ingresar();
		SleepTime sleepTime = new SleepTime();
		sleepTime.Esperar(5);
		//Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'username']")).getText().contains("EDISMAR"), "login incorrecto vuelva a ingresar los datos");
	}

	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing IE browser");
			driver.quit();
		}
	}
}