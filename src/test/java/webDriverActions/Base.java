package webDriverActions;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class Base {

	public WebDriver driver;
	public Properties prop = new Properties();
	
	@BeforeSuite
	public void SetUpDriver() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.6play.fr/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PagesObjects.ConsentsPage consents = new PagesObjects.ConsentsPage(driver);
		consents.cliquerAccepterTout();
		
		//return driver;	
	
	}
	
	
	/*
	@Test
	public void test() throws InterruptedException 
	{
		Thread.sleep(2000);
	}
	
	@Test
	public WebDriver initialiseDriver() throws IOException 
	{
		//Mondatory, il est comprendre les enchainements des ces commandes
		FileInputStream file = new FileInputStream("/Users/abdi.bileh17/Documents/Java/Toto_6Play/src/main/java/Ressources/Donnees.Properties");
		
		prop.load(file);
		String browserName = prop.getProperty("browser");
		System.out.println("Le test tourne avec le browser : "+browserName);
		
		if(browserName.equals("chrome"))
		{
			//execute avec chromedriver
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			 driver = new ChromeDriver();
		}
		
	
		else if(browserName.equals("firefox"))
		{
			//execute avec firefox driver
			 System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			  driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//execute avec IE driver
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	*/
	
	@AfterSuite
	public void TearnDown()
	{
		driver.close();
		driver.quit();
	}

}
