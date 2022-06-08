package webDriverActions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox {

	WebDriver driver;
	 @BeforeMethod
	@BeforeTest
	    public void setUp() {
			 //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			 //driver=new FirefoxDriver();
	    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
	           
	//Accéder au site 6play
	           driver.get("https://demoqa.com/checkbox");
	           driver.manage().window().maximize();
	           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	           
	    }
	 /**
	  * Ici c'est une demo pour Alert et les PopUp
	 * @throws InterruptedException 
	  */

	    @Test
	    public void testCheckBox() throws InterruptedException 
	    { 
	    	driver.findElement(By.xpath("(//button[@title='Toggle'])")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("(//label[contains(@for,'tree-node-downloads')])/parent::span/button")).click();
	    	//driver.findElement(By.xpath("(//input[@id='tree-node-excelFile'])/parent::label/span[@class='rct-checkbox']")).clear();
	    	driver.findElement(By.xpath("(//input[@id='tree-node-excelFile'])/parent::label/span[@class='rct-checkbox']")).click();
	    	Thread.sleep(2000);
	    	WebElement checkBox = driver.findElement(By.xpath("(//label[@for='tree-node-home'])/span[@class='rct-checkbox']"));
	    	checkBox.click();
	    	//checkBox.click();
	    	Thread.sleep(1000);
	  //Compliqué à vérifier si le checkbox est checké ou pas, l'element svg me pose un souci de localisation
	    	System.out.println("L'état de checkBox :"+checkBox.getAttribute("checked"));
	    	Thread.sleep(5000);

	    	 //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
	    }
	    /**
	     * Tear down the setup after test completes
	     **/

	    @AfterMethod
		@AfterTest
	    public void tearDown() 
	    { 
	           driver.quit();
	    }
}
