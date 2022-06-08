package demo_Rapport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class TableauDemo_Rapport extends Base_Rapport{
	WebDriver driver;
	ExtentTest test = rapport.createTest("Test1")
			.createNode("Node1")
			.assignAuthor("abdi").assignCategory("Reg").assignDevice("Chrome");
	
    @BeforeMethod
	@BeforeClass
    public void setUp() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
          
			//Accéder au site 
           driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/tables/");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           test.log(Status.PASS, "Le driver est affiché");
    }

    @Test
    public void testActionsClass() throws InterruptedException
    { 
    	test.log(Status.PASS, "Accès à la tableau est -OK-");
		Assert.fail("Le test est KO");
		
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
    @AfterClass
    public void tearnDown()
    {
    	test.log(Status.PASS, "Fermeture de driver est -OK-");
    	driver.quit();
    }
   
}
