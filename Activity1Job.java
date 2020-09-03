package AlchemyJob;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Activity1Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void test() {
	String title = driver.getTitle();
	Reporter.log("Title is" + title);
	Assert.assertEquals("Alchemy Jobs – Job Board Application", title);
	Reporter.log("Title matched");
	}
	@AfterClass
	public void after() {
	driver.close();	
	Reporter.log("Driver closed");
	}
		public static void main(String[] args) {
			
		}
		
	}


