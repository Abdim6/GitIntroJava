package listeners;

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

public class DropDown_Listeners extends Base_Listeners{

		WebDriver driver;
		ExtentTest test = rapport.createTest("Test3")
				.createNode("Node3")
				.assignAuthor("abdi").assignCategory("Reg").assignDevice("Chrome");
		
	    /**
	     * Set up browser settings and open the application
	     */

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
	           test.log(Status.PASS, "Le driver est affiché");
	           
	    }

	    /**
	     * Test to select the dropdown values
	     * @throws InterruptedException
	     **/

	    @Test
	    public void testSelectFunctionality() throws InterruptedException
	    { 

	    	test.log(Status.PASS, "Accès à la tableau est -OK-");
			test.fail("Le test est KO");
			
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
	          //driver.navigate().back();
	          //Impossible à vérifier si l'option est selectionnée
	          /**
	  		  System.out.println("La valeur de l'option est : "+option1.getAttribute("selected"));
	  		  System.out.println("La valeur de  true : "+"true"=="true");
	  		  Assert.assertTrue(option1.getAttribute("selected")=="true");
	           */

	           
/**
	           
	//select the first operator using "select by value"
	           Select selectByValue = new Select(driver.findElement(By.id("SelectID_One")));
	           selectByValue.selectByValue("greenvalue");
	           Thread.sleep(5000);
	           
	//select the second dropdown using "select by visible text"
	           Select selectByVisibleText = new Select (driver.findElement(By.id("SelectID_Two")));
	           selectByVisibleText.selectByVisibleText("Lime");
	           Thread.sleep(5000);
	           
	//select the third dropdown using "select by index"
	           Select selectByIndex = new Select(driver.findElement(By.id("SelectID_Three")));
	           selectByIndex.selectByIndex(2);
	           Thread.sleep(5000);   
	           
   //navigate back to previous webpage
	           driver.navigate().back();
	           Thread.sleep(5000);     
	           
	           
	           
	  */         
	    }

	    /**
	     * Tear down the setup after test completes
	     **/

	    @AfterClass
	    public void tearDown() 
	    { 
	    	test.log(Status.PASS, "Fermeture de driver est -OK-");
	           driver.quit();
	    }

	}


