package listeners;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * le but de cette classe de base est de  créer l'objet "extent" de la classe ExtentReport pour le rapport HTML
 * @author abdirahman
 */

public class Base_Listeners {

	public static ExtentReports rapport = new ExtentReports();
	public ExtentSparkReporter spak = new ExtentSparkReporter("Rapport/extent.html"); 
	
	@BeforeSuite
	public void SetUpDriver()  
	{		
		spak.config().setReportName(" - Le test DEMO Rapport -");
		rapport.attachReporter(spak);
				
		/** - ICI - un rapport pour les cas KO 
		ExtentSparkReporter  spak_fail	 = new ExtentSparkReporter("Rapport/fail.html")
				.filter().statusFilter()
				.as(new Status [] {Status.FAIL})
				.apply();	*/
	}
	
	

	/*
	@Test
	public void test() throws InterruptedException 
	{
		Thread.sleep(5000);
	}
	@Test
	public WebDriver initialiseDriver() throws IOException 
	{
		//Mondatory, il est comprendre les enchainements des ces commandes
		FileInputStream file = new FileInputStream("/Users/abdi.bileh17/Documents/Java/Toto_6Play/src/main/java/Ressources/Donnees.Properties");
		
		prop.load(file);
		String browserName = prop.getProperty("browser");
		System.out.println("Le test tourne avec le browser : "+browserName);
		
		if(browserName.equals("chrome"))
		{
			//execute avec chromedriver
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			 driver = new ChromeDriver();
		}
		
	
		else if(browserName.equals("firefox"))
		{
			//execute avec firefox driver
			 System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			  driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//execute avec IE driver
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	*/
	
	@AfterSuite
	public void TearnDown()
	{
		rapport.flush();
		
	}

}
