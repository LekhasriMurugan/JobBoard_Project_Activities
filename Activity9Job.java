package AlchemyJob;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	@Test
	public void test() {
		//Loggin In
		 WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
		 userName.sendKeys("root");
		 WebElement password = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
		 password.sendKeys("pa$$w0rd");
		 driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
		//Click Job Listings
		 WebElement jobListing = driver.findElement(By.xpath("//*[@id=\"menu-posts-job_listing\"]/a/div[3]"));
		 jobListing.click();
		 //add new job
		 WebElement addNewButton = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a"));
		 addNewButton.click();
		 WebElement position = driver.findElement(By.xpath("//*[@id=\"post-title-0\"]"));
		 position.sendKeys("New QA2 Analyst");
		 WebElement website = driver.findElement(By.xpath("//*[@id=\"_company_website\"]"));
		 website.sendKeys("www.ibm.com");
		 WebElement twitter = driver.findElement(By.xpath("//*[@id=\"_company_twitter\"]"));
		 twitter.sendKeys("test7788");
		 WebElement date = driver.findElement(By.xpath("//*[@id=\"_job_expires\"]"));
		 WebElement dateSelectbox = driver.findElement(By.xpath("//*[@id=\"_job_expires\"]"));
		 dateSelectbox.click();
		 //driver.findElement(By.xpath("/html/body/div[2]/div/a[2]/span"));
		 WebElement datelink = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[5]/td[3]/a"));
		 datelink.click();
		 WebElement location = driver.findElement(By.xpath("//*[@id=\"_job_location\"]"));
		 location.sendKeys("Bangalore");;
		 WebElement companyName = driver.findElement(By.xpath("//*[@id=\"_company_name\"]"));
		 companyName.sendKeys("IBM");
		 WebElement companyTagLine = driver.findElement(By.xpath("//*[@id=\"_company_tagline\"]"));
		 companyTagLine.sendKeys("cjjnkjnkj");
		 WebElement videoURL = driver.findElement(By.xpath("//*[@id=\"_company_video\"]"));
		 videoURL.sendKeys("www.video.com");
		 //Clicking Publish button twice
		 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
		 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 WebElement viewJob = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a"));
		 viewJob.click();
		 String expectedTitle = driver.getTitle();
		 System.out.println("Title is " +expectedTitle);
		 Assert.assertEquals("New QA2 Analyst – Alchemy Jobs",expectedTitle);
	}
	@AfterClass
	public void after() {
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
