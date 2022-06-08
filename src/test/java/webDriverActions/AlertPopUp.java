package webDriverActions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AlertPopUp {
	WebDriver driver;
		
		@BeforeMethod
		@BeforeTest
	    public void setUp() {
	 //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
	 //driver=new FirefoxDriver();
		 	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
	           
	//Accéder au site 6play
           driver.get("https://demoqa.com/");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	           
	    }
	 /**
	  * Ici c'est une demo pour Alert et les PopUp
	 * @throws InterruptedException 
	  */

	    @Test
	    public void testAlertPopUp() throws InterruptedException 
	    { 
	           
	//Acces à la page Alert & PopUp 
	// Utiliser le locator fils->parent->parent->fils pour trouver le bon lien 
	    	
	           WebElement titreSection = driver.findElement(By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']"));
	           System.out.println("Titre d ela section est : "+ titreSection.getText());
	           driver.findElement(By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']/parent::div/parent::div/div[1]")).click();
	           
	           Thread.sleep(2000);
	    
	   /**
	           //c'est spécial comment localise une balise svg -> trouver sur google
	           WebElement mapObject = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']/*[local-name() = 'svg']"));
	          
	           Actions action = new Actions(driver);
	           action.click(mapObject).build().perform();
	           action.doubleClick(mapObject).build().perform();
	    */       
	           
	           
	           driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']/span")).click();
	           //Acces à la page alert via l'URL - debug le prob posé par svg
	           //driver.get("https://demoqa.com/alerts");
	           
	           System.out.println("le titre de la page est : " +driver.getTitle());
	           System.out.println("l'url de la page est : " +driver.getCurrentUrl());
	           
	           AssertJUnit.assertTrue(driver.getCurrentUrl().contains("alerts"));

	           //Affichage de l'alerte 1 + click  - ok -
	           driver.findElement(By.xpath("//button[@id='alertButton']")).click();
	           Thread.sleep(2000);
	           Alert alert = driver.switchTo().alert();
	           System.out.println("le text dans l'alerte : "+ alert.getText());
	           alert.accept();
	           Thread.sleep(2000);
	           

	           //Affichage de l'alerte 2 + click  - ok -
	           driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
	           Thread.sleep(6000);
	           
	   /**Prob wait explicite à resoudre*/
	           //WebDriverWait wait = new WebDriverWait(driver,5000);
	           //wait.until(ExpectedConditions.alertIsPresent());
	           Alert alert2 = driver.switchTo().alert();
	           System.out.println("le text dans l'alerte 2 : "+ alert2.getText());
	           alert2.accept();	           

	           //Affichage de l'alerte 3 + click  - annuler -
	           driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
	           Thread.sleep(1000);
	           Alert alert3 = driver.switchTo().alert();
	           System.out.println("le text dans l'alerte 3 : "+ alert3.getText());
	           alert3.dismiss();
	           Thread.sleep(2000);
	           String textConfirm = driver.findElement(By.xpath("(//span[@id='confirmResult'])")).getText();
	           AssertJUnit.assertTrue(textConfirm.contains("Cancel"));
	    }

	    /**
	     * Teardown the setup after test completes
	     **/

	    @AfterMethod
		@AfterTest
	    public void tearDown() 
	    { 
	           driver.quit();
	    }
}
