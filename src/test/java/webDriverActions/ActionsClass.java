package webDriverActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsClass {

	WebDriver driver;
	 
    /**
     * Set up browser settings and open the application
     */

    @BeforeTest
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
           
//Accéder au site 
           driver.get("https://demoqa.com/buttons");
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
       
//double click section
    	   WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
    	   doubleClickBtn.click();
           Thread.sleep(2000);
           
     /**Comment vérifier que le message ne s'affiche pas*/
           //Assert.assertTrue(textDoubleClick.isDisplayed());
           
           Actions act =new Actions(driver);
           act.doubleClick(doubleClickBtn).build().perform();
           Thread.sleep(2000); 
           WebElement textDoubleClick = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
           Assert.assertTrue(textDoubleClick.isDisplayed());   
           System.out.println(textDoubleClick.getText());
           Thread.sleep(2000); 
           
//Click droite
    	   WebElement rightClickBtn = driver.findElement(By.xpath("//button[@id='rightClickBtn'] "));
           act.moveToElement(rightClickBtn).build().perform(); 
           Thread.sleep(2000); 
           act.keyDown(Keys.CONTROL).click().build().perform();
           Thread.sleep(2000); 
           WebElement textRightClick = driver.findElement(By.xpath("//p[@id='rightClickMessage']"));
           Assert.assertTrue(textRightClick.isDisplayed());
           System.out.println(textRightClick.getText());  
           Thread.sleep(2000); 
           
//Mouse actions dans une liste deroulante
           driver.get("https://demoqa.com/menu/");
    	   WebElement menu2 = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
    	   act.moveToElement(menu2).build().perform(); 
           Thread.sleep(2000); 
    	   WebElement sousMenu3 = driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"));
    	   act.moveToElement(sousMenu3).build().perform(); 
           Thread.sleep(2000); 
    	   WebElement sousSousMenu3 = driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 2']"));
    	   act.moveToElement(sousSousMenu3).click().build().perform(); 
           Thread.sleep(2000); 
           
/**Un petit souci de copier coller - A revoir */           
//Keyboard actions - copier coller // Lettre capitale
           driver.get("https://demoqa.com/automation-practice-form");
           String titreFormulaire = driver.findElement(By.xpath("//h5")).getText();
           WebElement textArea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
           WebElement subjectArea = driver.findElement(By.id("userEmail"));
           Actions act2 =new Actions(driver);
           
           subjectArea.sendKeys(titreFormulaire);
           act2.keyDown(Keys.CONTROL);
           act2.sendKeys("c");
           act2.keyUp(Keys.CONTROL);
           Thread.sleep(1000); 
           
           act2.moveToElement(textArea).build().perform();
           act2.keyDown(Keys.CONTROL);
           act2.sendKeys("v");
           act2.keyUp(Keys.CONTROL);
           Thread.sleep(1000); 
           
           String text = textArea.getText();
           System.out.println("le texte dans le champ est : "+text);
           Thread.sleep(2000); 
    	   
    }

    /**
     * Tear down the setup after test completes
     **/

    @AfterTest
    public void tearDown() 
    { 
           driver.quit();
    }

}
