package webDriverActions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerSansExtent.class)
public class tableauDemo {
	WebDriver driver;
	 
    /**
     * Set up browser settings and open the application
     */

    @BeforeMethod
	@BeforeTest
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
           
//Accéder au site 
           driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/tables/");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
    }

    /**
     * Test to select the dropdown values
     * @throws InterruptedException
     **/

    @Test
    public void testActionsClass() throws InterruptedException
    { 
    	 List<WebElement> listeElem = driver.findElements(By.xpath("//table[@id='tablepress-1']//td"));
    	 String population="";
    	 String rangPays = "";
    	 
    	 for (int i=0; i<listeElem.size();i++)
    	 {
    		 if(listeElem.get(i).getText()=="Indonesia");
    		 {
    			  population = listeElem.get(i+1).getText();
    			  rangPays = listeElem.get(i-1).getText();
    		 }
    	 }
    	 System.out.println("L'indonesia a "+population+ " population, et elle est classé : "+rangPays);
    	 Thread.sleep(2000);
    } 
   
}
