package demoproject.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Integrating_Selenium {
	static WebDriver webDriver;
	
	
// No es necesario un psvm se corre con el archivo xml de tstng	
	public static void main(String[] args)throws Exception {
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\a846393\\eclipse-workspace\\demoproject\\src\\main\\resources\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwixr__C3uH1AhUTIUQIHYZjB48QPAgI");
		System.out.println(webDriver.getTitle());
		webDriver.findElement(By.name("q")).sendKeys("Selenium");*/

	}
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\a846393\\eclipse-workspace\\demoproject\\src\\main\\resources\\chromedriver.exe");
		webDriver = new ChromeDriver();
	}
	
	
	@Test
	public void testMethod1() {
		webDriver.get("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwixr__C3uH1AhUTIUQIHYZjB48QPAgI");
		System.out.println("Test 1 Case Passed");
	}
	
	@Test(dependsOnMethods = {"testMethod1"})
	public void testMethod2() {
		System.out.println(webDriver.getTitle());
		System.out.println("Test Case 2 passed");
	}
	
	
	@Test(dependsOnMethods = {"testMethod1"})
	public void testMethod3() {
		webDriver.findElement(By.name("q")).sendKeys("Selenium");
		System.out.println("Test Cse 3 passed");
	}
	
	
	
	
	
}
