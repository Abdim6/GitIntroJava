package screenShot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class DropDown_Listeners extends BaseScreenShot{

		WebDriver driver;
		

	    @BeforeClass
	    public void setUp() {
			 //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			 //driver=new FirefoxDriver();
	    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
	           
	//Accéder au site 6play
	           driver.get("https://the-internet.herokuapp.com/");
	           driver.manage().window().maximize();
	           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	           
	    }

	    @Test
	    public void testSelectFunctionality() throws InterruptedException, IOException
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
	           
	//Faire une Capture d'ecran
	           getSceenShot(driver);
	           
	//Vérification de la selection 
	          WebElement option1 = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']"));
	          //driver.navigate().back();
	    }    
	    /**
	     * Tear down the setup after test completes
	     **/

	    @AfterClass
	    public void tearDown() 
	    { 
	           driver.quit();
	    }

	}