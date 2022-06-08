package parallelTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


/**
 * le but de cette classe de base est de  créer l'objet "extent" de la classe ExtentReport pour le rapport HTML
 * @author abdirahman
 */
public class Base_Rapport {

	WebDriver driver;
	
	public WebDriver SetUpDriverBase(String browser) throws MalformedURLException  
	{		
		if(browser == "firefox")
		{
			//Firefox
			 System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			 driver=new FirefoxDriver();		
		}
		else if(browser=="chrome")
		{
			//Chrome			
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
		}

		else
		{//Utilise le Docker

			System.out.println("début Base setUP");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName(BrowserType.CHROME);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

			System.out.println("Fin Base setUP");
			
		}
		return driver;
		}


	
	
	public void TearnDown()
	{
		driver.close();
		driver.quit();	
	}

}


/**
 * ANALYSE LA SIMPLIFICATION DES ETAPES POUR ARRIVER JUSQU'AU LOG 
 * 
			ExtentReports extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
			extent.attachReporter(spark);
			extent.createTest("MyFirstTest")
			  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
			extent.flush();
*/
