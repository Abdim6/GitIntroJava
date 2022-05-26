package webDriverActions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass_demo {

	ExtentReports rapport = new ExtentReports();
	ExtentSparkReporter spak = new ExtentSparkReporter("Rapport/extent.html");
/** - ICI - un rapport pour les cas KO */
	ExtentSparkReporter  spak_fail	 = new ExtentSparkReporter("Rapport/fail.html")
			.filter().statusFilter()
			.as(new Status [] {Status.FAIL})
			.apply();
	
	
	@BeforeTest
	public void getExtent()
	{
		 //rapport.attachReporter(spak);
		//rapport.createTest("NameTest");
		 rapport.attachReporter(spak_fail,spak);
	}
	
	@AfterTest
	public void tearnDown()
	{
		rapport.flush();
	}
	
	
	
	
	
	@Test
	public void test1() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.6play.fr/");
		
		ExtentTest test = rapport.createTest("Test1")
				.createNode("Node")
				.assignAuthor("abdi").assignCategory("Reg").assignDevice("Chrome");
		test.log(Status.FAIL, "Tout est ok");
		test.fail("Le test est KO");
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/Rapport/img.png").build());

		//Capture d'ecran de cas en KO
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("target/_monScreenshot.png"));
				
	}
	@Test
	public void test2()
	{
		ExtentTest test = rapport.createTest("Test2")
		.log(Status.INFO, "Tout est ok");
	}
	@Test
	public void test3()
	{
		ExtentTest test = rapport.createTest("Test3")
				.assignAuthor("abdi").assignCategory("Reg").assignDevice("Firefox");
		test.log(Status.PASS, "Tout est ok");
	}
	@Test
	public void test4()
	{
		ExtentTest test = rapport.createTest("Test4")
				.assignAuthor("abdi").assignCategory("Reg").assignDevice("IE");
		test.log(Status.INFO, "Tout est ok");
	}
	@Test
	public void test5()
	{
		ExtentTest test = rapport.createTest("Test5")
		.assignAuthor("abdi").assignCategory("Reg").assignDevice("Chrome");
		test.log(Status.FAIL, "Tout est ok");
	}
	@Test
	public void test6()
	{
		ExtentTest test = rapport.createTest("Test6")
		.log(Status.PASS, "Tout est ok");
	}	
}
