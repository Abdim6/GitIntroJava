package PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConsentsPage {
	
	WebDriver driver;
	
	public ConsentsPage(WebDriver driver)
	{
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	/*
		Ces 3 annotations ci-dessous pointent vers le même objet 
		attention le findBy permet d'inclure le driver l'autre est juste la location de l'objet.
	*/
	
//@FindBy(how=How.XPATH, using="//div[@class = 's9pqpz-3 fcBJOP']/ button") WebElement consentOK;
By toutAccepterConsentBtn = By.xpath("//div[@class = 's9pqpz-3 fcBJOP']/ button");
/*
@FindBy(xpath="//div[@class = 's9pqpz-3 fcBJOP']/ button")
WebElement toutAccepterConsentBtn;
*/

public void cliquerAccepterTout()
{
	driver.findElement(toutAccepterConsentBtn).click();
	//toutAccepterConsentBtn.click();
	//driver.findElement(toutAccepterConsentBtn).click();  
}

}
