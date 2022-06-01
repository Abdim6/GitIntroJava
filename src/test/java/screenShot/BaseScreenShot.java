package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseScreenShot {
	
	/**
	 * cette méthode statique est une mecthode générique qui pemettra de faire une capture d'écran 
	 * depuis n'importe quel script. 
	 * Faut juste faire appelle à cette methode en rentrant en paramètre le driver en cours. 
	 * @param driver
	 * @throws IOException
	 */
	public static void getSceenShot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//String dest = System.getProperty("user.dir")+"ma capture.png";
		FileUtils.copyFile(source, new File("./target/maScreenDuLundi.png"));
	}

}
