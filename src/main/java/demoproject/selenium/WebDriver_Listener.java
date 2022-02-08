package demoproject.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriver_Listener {
	
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\a846393\\eclipse-workspace\\demoproject\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		//EventCapture eventCaptured = new EventCapture();
		
		eventHandler.navigate().to("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwiTwbOkvOD1AhWrmWoFHR-NDmkQPAgI");
		Thread.sleep(3000);
		
		eventHandler.navigate().to("https://www.geeksforgeeks.org/");
		Thread.sleep(5000);
		eventHandler.navigate().back();
		Thread.sleep(5000);
		eventHandler.quit();
	}

}
