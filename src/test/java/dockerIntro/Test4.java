package dockerIntro;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test4 {

	@Test
	public  void monTest4() throws MalformedURLException
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println("Test n°4");
		driver.quit();
	}
		
	

}
