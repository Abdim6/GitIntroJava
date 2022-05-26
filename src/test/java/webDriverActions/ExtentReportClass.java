package webDriverActions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportClass {

	private static final String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
    private static final String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";

    public static void main(String[] args) throws ClassNotFoundException {
    	
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        //ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");

        extent.attachReporter(spark);


		extent.createTest("MyFirstTest")
		  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		

        extent.createTest("ScreenCapture")
                .addScreenCaptureFromPath("extent.png")
                .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());

        extent.createTest("LogLevels")
                .info("info")
                .pass("pass")
                .warning("warn")
                .skip("skip")
                .fail("fail");

        extent.createTest("CodeBlock").generateLog(
                Status.PASS,
                MarkupHelper.createCodeBlock(CODE1, CODE2));
        /*
        extent.createTest("ParentWithChild")
                .createNode("Child")
                .pass("This test is created as a toggle as part of a child test of 'ParentWithChild'");

        extent.createTest("Tags")
                .assignCategory("MyTag")
                .pass("The test 'Tags' was assigned by the tag <span class='badge badge-primary'>MyTag</span>");

        extent.createTest("Authors")
                .assignAuthor("TheAuthor")
                .pass("This test 'Authors' was assigned by a special kind of author tag.");

        extent.createTest("Devices")
                .assignDevice("TheDevice")
                .pass("This test 'Devices' was assigned by a special kind of devices tag.");

        extent.createTest("Exception! <i class='fa fa-frown-o'></i>")
                .fail(new RuntimeException("A runtime exception occurred!"));
*/
        extent.flush();
    }
	/**
	  ExtentTest test;
	  ExtentReports report;
	  WebDriver driver;
	
	@BeforeClass
	public void startTest()
	{
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("");
		//ExtentSparkReporter spark = new ExtentSparkReporter((System.getProperty("user.dir")+"ExtentReportResults.html"));
		report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}
	
	@Test
	public void extentReportsDemo()
	{

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		
	if(driver.getTitle().equals("Google"))
	{
		test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	else
	{
		test.log(LogStatus.FAIL, "Test Failed");
	}
	}
	
	@AfterClass
	public  void endTest()
	{
		driver.close();
		report.endTest(test);
		report.flush();
	}
*/
}