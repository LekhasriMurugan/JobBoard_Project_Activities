package AlchemyJob;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
	}
	@Test
	public void test() {
		WebElement jobsTab = driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a"));
		jobsTab.click();
		//Sending Job Keyword
		driver.findElement(By.xpath("//*[@id=\"search_keywords\"]")).sendKeys("Test Engineer");
		//Click on Submit button
		driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/div[1]/div[4]/input")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Clicking a job from results
		driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[4]/a/div[1]/h3")).click();
		//Click apply button
		driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/input")).click();
		WebElement email = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p/a"));
		String emailId = email.getText();
		System.out.println("Email id is " + emailId);
	}
	@AfterClass
	public void after() {
		driver.close();
		System.out.println("Driver closed");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
