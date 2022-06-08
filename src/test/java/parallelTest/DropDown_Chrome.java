package parallelTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * Le but de cette classe est d'utiliser un conteneur docker en faisant appel à une classe BASE
 * @author abdirahman
 *
 *
 *
 *comprendre pk l'appel à la classe mere est KO pour le container ??!!
 */
public class DropDown_Chrome extends Base_Rapport {

		WebDriver driver;
		
		@BeforeMethod
	    public void setUp() throws MalformedURLException {
	 
			//DesiredCapabilities cap = new DesiredCapabilities();
			//cap.setBrowserName(BrowserType.CHROME);
			//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
			System.out.println("début setUP - Chrome");
		//Test sur chrome browser
			driver = SetUpDriverBase("chrome");
			System.out.println("Fin setUP - Chrome");
	    }

	    @Test(priority=1)
	    public void testSelectFunctionality() throws InterruptedException
	    { 
	           
	//Accéder au site 
	           driver.get("https://the-internet.herokuapp.com/");
	           driver.manage().window().maximize();
	           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
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

			  System.out.println("Titre de la page : "+driver.getTitle());
	  		  System.out.println("I'm in the body methode and it is was a success - Chrome");
	         
	    }
	    
	    @Test(priority=0)
	    public void testGoogle() throws InterruptedException
	    {

	           //Thread.sleep(5000);     
	           driver.get("https://google.com/");
	           Thread.sleep(2000);     
	           String title = driver.getTitle();	  
	           System.out.println("Titre de la page Chrome : "+title);
	          // assert.assertEquals(title, "Google");		//assert entre deux string ne fonctionne pas !!! à investiguer
	          if( title.equalsIgnoreCase("google"))
	          {

	  			System.out.println("The title google is OK");
	          }
	          else 
	          {
	  			Assert.fail("Le titre google est KO");
	          }
	    }

		@AfterMethod
	    public void tearDown() throws InterruptedException 
	    { 

	        Thread.sleep(2000);     
			System.out.println("I'm in the tearnDown methode - Chrome");
	        driver.quit();
	    }

	}


