package webDriverActions;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PagesObjects.LandingPageObject;

public class TotoTestConnexion extends Base{
	
	/*
	@BeforeTest
	public void SetUp() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.6play.fr/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PagesObjects.ConsentsPage consents = new PagesObjects.ConsentsPage(driver);
		consents.cliquerAccepterTout();
		
		Thread.sleep(2000);
		
	}*/
	//public WebDriver driver;
	
	@Test
	public void toto() throws InterruptedException {
		//driver= SetUpDriver();
		
		LandingPageObject landing = new LandingPageObject(driver);

		Thread.sleep(2000);
		List<WebElement> titre = landing.getTitreSections();
		
		for(int i=0; i<titre.size();i++)
		{
			System.out.println("Titre sections : "+titre.get(i).getText());
		}
		
		Thread.sleep(2000);
		//landing.cliquerMonCompteBtn();
		//System.out.println(titre);
		
	}
	
	
	/*
	 WebElement UserName = driver.findElement(By.Id("UserName"));
	 
	  et le même que ça
	  
	  By locator = By.id("UserName");
	  WebElement UserName = driver.findElement(locator);
	 */
}