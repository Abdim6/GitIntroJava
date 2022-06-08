package dockerIntro;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Le but de cette classe est d'utiliser un conteneur docker utilisant une classe E2E 
 * donc le driver utilisé est dans la classe même
 * @author abdirahman
 *
 */

public class E2EtestWithDocker {

	WebDriver driver;

	@BeforeTest
    public void setUp() throws MalformedURLException  {
//Firefox
		//System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		 //driver=new FirefoxDriver();
//Chrome
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		//driver = new ChromeDriver();
		
//Ci dessous utilisation de docker !
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		           
//Accéder au site 
           driver.get("https://the-internet.herokuapp.com/");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
   		System.out.println("I'm in the end of setUp methode");      
    }

    @Test
    public void testSelectFunctionality() throws InterruptedException
    { 
           driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
           
//Wait explicit wait + selection par valeur 
           WebElement listeElem = driver.findElement(By.id("dropdown"));
           Select optionsByValue = new Select(listeElem);
           optionsByValue.selectByValue("1");
           Thread.sleep(2000);
           
//selection par text 
           Select optionsByText = new Select(listeElem);
           optionsByText.selectByVisibleText("Option 2");
           Thread.sleep(2000);
           
//Vérification de la selection 
          WebElement option1 = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']"));

  		  System.out.println("I'm in the body methode and it is was a success");
    }

	@AfterTest
    public void tearDown() 
    { 
		System.out.println("I'm in the tearnDown methode");
           driver.quit();
    }
    
}
