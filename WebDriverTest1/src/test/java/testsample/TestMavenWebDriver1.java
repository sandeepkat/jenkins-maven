package testsample;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;

public class TestMavenWebDriver1 {
	private WebDriver driver;		
	@Test				
	public void testEasy() {	
		
		driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		AssertJUnit.assertTrue(title.contains("Demo Guru99 Page")); 	
		System.out.println("Test Passes, Voola");
	}	
	@BeforeTest
	public void beforeTest() {	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\shivakumar\\Eclipse\\geckodriver.exe");
//	      FirefoxOptions options = new FirefoxOptions();
//	  	  options.setLegacy(true);
	    driver = new FirefoxDriver();  
	    
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	
}
