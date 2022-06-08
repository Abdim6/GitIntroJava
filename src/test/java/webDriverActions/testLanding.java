package webDriverActions;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import PagesObjects.LandingPageObject;

public class testLanding extends Base{

	@Test
	public void landingPage() throws InterruptedException  {
		//driver= SetUpDriver();

		System.out.println("Ceci est le deuxieme test ");
		LandingPageObject l = new LandingPageObject(driver);
		Thread.sleep(2000);
		
		l.cliquerMonCompteBtn();
		System.out.println("Ceci est le deuxieme test - 2");
		Thread.sleep(2000);
		
	}
	
}
