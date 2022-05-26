package webDriverActions;

import org.testng.annotations.Test;

import PagesObjects.LandingPageObject;

public class testHomePage extends Base{

	@Test
	public void homePage() throws InterruptedException {
		//driver= SetUpDriver();

		System.out.println("Ceci est le troisieme test");
		
		LandingPageObject landing = new LandingPageObject(driver);
		
		Thread.sleep(2000);
		
		//System.out.println("Le text du bouton : "+landing.getTextButton());
		System.out.println("Ceci est le troisieme test - 3");
		Thread.sleep(2000);
	}
	
}
