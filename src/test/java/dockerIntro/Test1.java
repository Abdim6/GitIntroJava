package dockerIntro;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test1 {

	@Test
	public  void monTest1() throws MalformedURLException
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		
		driver.get("http://www.yahoo.com");
		System.out.println(driver.getTitle());
		System.out.println("Test n°1");
		driver.quit();
	}

}
