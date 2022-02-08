package demoproject.selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1- By.id(“id”)
2- By.name("name")
3- By.className(“class”)
4- By.tagName("tag")
5- By.linkText("string")
6- By.partialLinkText("string")
7- By.cssSelector("input[name='q']")
8- By.xpath("//input[@name='q']")
9- JavaScript
*/
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/*			LOCALIZADORES
 * By.id("string")			busca un elemento por id
 * By.name("string")
 * By.className("class")	busca un elemento por nu clase (bueno para buscar un conjunto de elementos)
 * By.tagName("tag")		
 * By.linkText("string")	busca una caja de texto que contenga el string descrito
 * By.partialLinkText("string")		va a buscar un patron que coincida con la cadena descrita
 * By.cssSelector("string")
 * By.xpath("string")
 */

public class Localizadore {
	
	private WebDriver webDriver;
		
	// DAMOS CLICK EN REGISTER
	By usingLinkText = By.linkText("REGISTER");
	// COMPLETAMOS USER NAME, PASSWORD, CONFIRM PASSWORD, Y CLICK EN SUBMIT
	By usingXpath = By.xpath("//img[@src='images/banner2.gif']");
	
	
	By usingName = By.name("firstName");
	By usignName2 = By.name("lastName");
	By usingName3 = By.name("phone");
	By usingName4 = By.name("password");
	
	
	By usingId = By.id("email");
	
	By usingCssSelector = By.cssSelector("input[name='confirmPassword']");
	
	By usingName5 = By.name("submit");
	
	
	
	// REGRESAMOS A HOME Y NOS AUTENTICAMOS CON EL USUARIO Y CONTRASENA CREADOS 
	
	@BeforeClass
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\a846393\\eclipse-workspace\\demoproject\\src\\main\\resources\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("https://demo.guru99.com/test/newtours/");
	}
	
	@Test
	public void registerUser()throws InterruptedException {
		webDriver.findElement(usingLinkText).click();
		Thread.sleep(3000);
		//Para comprobar que la pagina haya cargado correctamente, vamos a revisar si los resources como las imagenes son desplegadas
		if(webDriver.findElement(usingXpath).isDisplayed()) {
			webDriver.findElement(usingName).sendKeys("Contreras");
			webDriver.findElement(usignName2).sendKeys("Jimenes");
			webDriver.findElement(usingName3).sendKeys("555100044155");
			webDriver.findElement(usingId).sendKeys("elalancho");
			webDriver.findElement(usingName4).sendKeys("secretPassword");
			webDriver.findElement(usingCssSelector).sendKeys("secretPassword");
			
			
			Thread.sleep(3000);
			webDriver.findElement(usingName5).click();
		}else {
			System.out.println("Error while loading this page");
		}	
		
		List<WebElement> webElementsFont = webDriver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is elalancho.", webElementsFont.get(5).getText());
		
	}
	
	@Test
	public void tearDown() {
		webDriver.quit();
		
	}
			

}
