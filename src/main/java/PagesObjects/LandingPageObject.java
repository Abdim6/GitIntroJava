package PagesObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPageObject {



	public WebDriver driver;
	
	public LandingPageObject(WebDriver driver)
	{
		this.driver=driver;
	//Faire des essaies avec la classe pagefactory
		//PageFactory.initElements(driver, this);
	}
	
	
	
	

//@FindBy(how=How.CSS, using="button[title='Mon Compte']") WebElement monCompteBtn;
//@FindBy(how=How.XPATH, using="//section[@class='sc-17ahufu-0 bHxVLI is-fullViewport is-first']//parent::div/section/div/h1") WebElement titreSection;

By monCompteBtn = By.cssSelector("button[title='Mon Compte']");
By titreSection = By.xpath("//section[@class='sc-17ahufu-0 bHxVLI is-fullViewport is-first']//parent::div/section/div/h1");

By accueilBtn = By.cssSelector(("a[class ='sc-1ajxxj-0 kInStr ye0ny3-1 bRTmBv active']"));

public void cliquerMonCompteBtn()
{
	driver.findElement(monCompteBtn).click();
}

public List<WebElement> getTitreSections()
{
	return driver.findElements(titreSection);
	
}
public String getTextButton()
{
	return driver.findElement(accueilBtn).getText();
	
}


	/*
	//By monCompteBtn = By.cssSelector("button[title='Mon Compte']");
	By homePageBtn = By.cssSelector("");
	By listeChaineBtn = By.xpath("//button[@class ='sc-1ajxxj-0 sc-1c6u83a-3 iUrMAG']");
	By sectionDivertissement = By.cssSelector("a[href$='/6play/divertissement-6play-f_10']");
	By accueilBtn = By.cssSelector(("a[class ='sc-1ajxxj-0 kInStr ye0ny3-1 bRTmBv active']"));
	By homeBtn = By.xpath(("//a[@class ='sc-1ajxxj-0 kInStr ye0ny3-1 bRTmBv is-brand active']"));
	By rechercheBtn = By.xpath(("//a[@class ='sc-1ajxxj-0 kInStr ye0ny3-1 bRTmBv']"));
	By footeRSection = By.cssSelector("footer[class='sc-1o0n65j-5 dYHJOz']");
	By titreDivertissement = By.xpath("(//div[@class='y84eg7-0 sc-8pi7if-0 LuxLU'])/h1[@class = 'sc-1veuio6-0 iBPSfB nngvz8-0 hIgyya']");
	//By lienTousLesProg = By.xpath("//a[normalize-space()='Tous les programmes']");
	By lienTousLesProg = By.xpath("//div[@label='Les programmes']//li[1]");
	By googleplay = By.xpath("//img[@alt='GooglePlay']");
	By listeSection = By.xpath("//section[@class='sc-17ahufu-0 bHxVLI is-fullViewport is-first']//parent::div/section");
	//By titreSection = By.xpath("//section[@class='sc-17ahufu-0 bHxVLI is-fullViewport is-first']//parent::div/section/div/h1");
	
	
	public WebElement cliquerMonCompteBtn()
	{
		return driver.findElement(monCompteBtn);
	}
	public WebElement cliquerHomePageBtn()
	{
		return driver.findElement(homePageBtn);
	}
	public WebElement cliquerRechercheBtn()
	{
		return driver.findElement(rechercheBtn);
	}
	public WebElement cliquerListeChainesBtn()
	{
		return driver.findElement(listeChaineBtn);
	}
	public WebElement cliquerDivertissement()
	{
		return driver.findElement(sectionDivertissement);
	}
	public WebElement cliquerAcueil()
	{
		return driver.findElement(accueilBtn);
	}
	public WebElement cliquerHome()
	{
		return driver.findElement(homeBtn);
	}
	public WebElement cliquerrechercheBtn()
	{
		return driver.findElement(rechercheBtn);
	}
	public WebElement cliquerFooter()
	{
		return driver.findElement(footeRSection);
	}
	public WebElement getTitreDivertissement()
	{
		return driver.findElement(titreDivertissement);
	}
	public WebElement clickTousLesprog()
	{
		return driver.findElement(lienTousLesProg);
	}
	public WebElement clickGooglePlay()
	{
		return driver.findElement(googleplay);
	}
	public List<WebElement> getListeSections()
	{
		return driver.findElements(listeSection);
	}
	public List<WebElement> getTitreSections()
	{
		return driver.findElements(titreSection);
	}
	*/
	
}
