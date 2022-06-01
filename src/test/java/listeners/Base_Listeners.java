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
	
	@AfterSuite
	public void TearnDown()
	{
		rapport.flush();
		
	}

}
