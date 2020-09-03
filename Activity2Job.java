package AlchemyJob;

import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;


public class Activity2Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void Test() {
	String heading = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/h1")).getText();
	Assert.assertEquals("Welcome to Alchemy Jobs", heading);
	System.out.println("Heading matched");
	}
	@AfterClass
	public void after() {
	driver.close();	
	System.out.println("Driver closed");
	}
	

	public static void main(String[] args) {
		}
		
	}


