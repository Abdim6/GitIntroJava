package listeners;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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



public class FormDemo_Listeners extends Base_Listeners{

	WebDriver driver;
	ExtentTest test = rapport.createTest("Test2")
			.createNode("Node2")
			.assignAuthor("abdi").assignCategory("Reg").assignDevice("Chrome");
	
	 @BeforeClass
	    public void setUp() {
			 //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			 //driver=new FirefoxDriver();
	    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
	           
	//Accéder au site 6play
	           driver.get("https://demoqa.com/automation-practice-form");
	           driver.manage().window().maximize();
	           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	           test.log(Status.PASS, "Le driver est affiché");
	    }
	 /**
	  * Ici c'est une demo pour Alert et les PopUp
	 * @throws InterruptedException 
	  */

	    @Test
	    public void testAlertPopUp() throws InterruptedException 
	    { 
	    	test.log(Status.PASS, "Accès à la tableau est -OK-");
			test.fail("Le test est KO");
			
	    	String titreFormulaire = driver.findElement(By.xpath("//h5")).getText();
	    	Assert.assertTrue(titreFormulaire.contains("Student"));
	    	//vérifie si les gens sont renseignés ou pas
	        Thread.sleep(5000);
	    	List<WebElement> listInput = driver.findElements(By.xpath("(//input[contains(@id,'gender-radio')])"));
	    	for (int i=0; i<listInput.size();i++)
	    	{
	    		Assert.assertTrue(!listInput.get(i).isSelected());
	    		System.out.println("Les genres ne sont pas encore renseignés ! ");
	    	}
	    	
	    	//Recupère la date de naissance
	    	String dateNaissance = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).getAttribute("value");
	    	System.out.println("la date de naissance est : "+dateNaissance);
	    	Thread.sleep(2000);
	    	
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
