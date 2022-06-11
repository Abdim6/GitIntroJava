package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerDemo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		/**
		 * Finir la vidéo : https://www.youtube.com/watch?v=Y7kwlYGCDNI&list=PLFh6J1ZHhqNiDLdTBQov509Zwdd-iK6WZ&index=5
		 * Et exécuter un test via le docker. 
		 * un exemple assez simple 
		 * puis approfondir la documentation + les terminologies
		 * concentre toi sur l'interêt de docker en autom plus precisement pour SELENIUM
		 * 
		 * image : docker pull selenium/standalone-chrome
		 * 
		 * When building a docker image on apple M1, i used the --platform option: i.e.
		 * docker build -t imagename --platform linux/x86_64 .
		 * 
		 * look at it : https://github.com/docker/for-mac/issues/5310#issuecomment-877653653
		 * 
		 * comment arreter un container - docker -kill? docker stop nomIdImage
		 * peut être j'ai besoin de selenium grid pour utiliser le docker?
		 * 
		 * QUESTION : est-il possible de créer un docker-container window sur une machine MAC?
		 * 
		 * Surveille ce lien lors des exécutions : http://localhost:4444/ui
		 * REFAIS CET EXO : https://www.youtube.com/watch?v=vuHXpQqoNq8&t=26s
		 * Exemple de doc pour ARCHI Docker : https://geekflare.com/docker-architecture/
		 * Video Tuto : https://www.youtube.com/watch?v=LJwmYuEaWBY&list=PLUDwpEzHYYLtpm24ojHwubwmMNQildHBc&index=4
		 * Faire des tests en parallèle avec deux browsers différents avec et sans docker 
		 * 
		 * 
		 * #RUn#
		 * docker run -d -p 4444:4444 seleniarm/standalone-chromium
		 * docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:3.141.59-yttrium
		 * 
		 * */

		/*
		//DesiredCapabilities cap =  DesiredCapabilities.chrome;
		ChromeOptions options = new ChromeOptions();
		URL url = new URL("http//localhost:4444/wd/hub");
		RemoteWebDriver driver = RemoteWebDriver(url, options);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");  //chrome binary location specified here
		//options.addArguments("start-maximized");
		//options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		//options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.google.com/");
		*/
		
		/**
		 * CECI EST UN TEST POUR GIT - GITHUB
		 */
		/**
		 * CECI EST UN TEST-2 POUR GIT - GITHUB
		 */
/*
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		//ChromeOptions chromeOptions = new ChromeOptions();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
		
		// Pour lancer un test, faut que un conteneur soit en mode run (ouvert)? 
		//ou c'est le test qui permet de le lancer le conteneur?
		*/
		
	
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.setCapability("browserVersion", "100");
		//chromeOptions.setCapability("platformName", "Windows");
		// Showing a test name instead of the session id in the Grid UI
		//chromeOptions.setCapability("se:name", "My simple test"); 
		// Other type of metadata can be seen in the Grid UI by clicking on the 
		// session info or via GraphQL
		//chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value"); 
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
		driver.get("http://www.google.com");
		driver.quit();

		
	}

}
