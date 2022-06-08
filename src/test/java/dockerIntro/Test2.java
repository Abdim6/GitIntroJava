package dockerIntro;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	public  void monTest2() throws MalformedURLException
	{
		//ChromeOptions chromeOptions = new ChromeOptions();
		//DesiredCapabilities dc = DesiredCapabilities.chrome();
		FirefoxOptions fire	 = new FirefoxOptions(); 
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), fire);
		
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		System.out.println("Test n°2");
		driver.quit();
	}

}
