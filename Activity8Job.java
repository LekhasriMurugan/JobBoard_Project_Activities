package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity8Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	@Test
	public void test() {
	WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
	userName.sendKeys("root");
	WebElement password = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
	password.sendKeys("pa$$w0rd");
	driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
	String title = driver.getTitle();
	System.out.println("Page Title is" +title);
	Assert.assertEquals("Dashboard ‹ Alchemy Jobs — WordPress", title);
	}
	@AfterClass
	public void after() {
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
