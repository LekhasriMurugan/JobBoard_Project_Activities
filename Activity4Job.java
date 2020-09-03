package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void test() {
	String Secondheading = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/h2")).getText();
	Assert.assertEquals("Quia quis non", Secondheading);
	System.out.println("Second Heading matched");
	}
	@AfterClass
	public void after() {
	driver.close();	
	System.out.println("Driver closed");
	}

	public static void main(String[] args) {
		}
}
