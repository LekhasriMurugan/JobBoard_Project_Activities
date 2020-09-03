package AlchemyJob;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class Activity7Job {
	WebDriver driver;
	WebDriver wait;
	@BeforeClass
	public void before( ) {
		driver = new FirefoxDriver();
	}
	@Test
	public void Test() {
	driver.get("https://alchemy.hguy.co/jobs/");
	WebElement postAJob = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a"));
	postAJob.click();
	WebElement email = driver.findElement(By.xpath("//*[@id=\"create_account_email\"]"));
	email.sendKeys("test913@email.com");
	WebElement jobTitle = driver.findElement(By.xpath("//*[@id=\"job_title\"]"));
	jobTitle.sendKeys("New Job2");
	WebElement location = driver.findElement(By.xpath("//*[@id=\"job_location\"]"));
	location.sendKeys("India");
	WebElement jobType = driver.findElement(By.xpath("//*[@id=\"job_type\"]"));
	Select select = new Select(jobType);
	select.selectByVisibleText("Freelance");
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("window.scrollBy(0,500)");
	//Enter Job Description
    driver.switchTo().frame(driver.findElement(By.id("job_description_ifr")));
    driver.findElement(By.id("tinymce")).sendKeys("test");
    driver.switchTo().parentFrame();
    //Enter Application URL
	WebElement applnURL = driver.findElement(By.id("application"));
	applnURL.sendKeys("test924@gmail.com");
	WebElement compName = driver.findElement(By.xpath("//*[@id=\"company_name\"]"));
	compName.sendKeys("IBM");
	WebElement compSite = driver.findElement(By.xpath("//*[@id=\"company_website\"]"));
	compSite.sendKeys("www.ibm.com");
	WebElement compTagLine = driver.findElement(By.xpath("//*[@id=\"company_tagline\"]"));
	compTagLine.sendKeys("Test Test");
	WebElement compVideoURL = driver.findElement(By.xpath("//*[@id=\"company_video\"]"));
	compVideoURL.sendKeys("www.test.com");
	WebElement twitterUserName = driver.findElement(By.xpath("//*[@id=\"company_twitter\"]"));
	twitterUserName.sendKeys("xxxxyyyy");
	//Upload file
	WebElement browseButton = driver.findElement(By.xpath("//*[@id=\"company_logo\"]"));
	browseButton.sendKeys("C:\\Users\\LekhasriMurugan\\Downloads\\IBM_logo_in.jpg");
	//Click On Preview button
	WebElement preview = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/form/p/input[4]"));
	preview.click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//Click on Submit listing
	driver.findElement(By.xpath("//*[@id=\"job_preview_submit_button\"]")).click();
	//Go to Jobs
	driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	//search Keyword and type
	WebElement keyword = driver.findElement(By.xpath("//*[@id=\"search_keywords\"]"));
	keyword.sendKeys("New Job1");
	//Click on Search Jobs
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
	//Verifying pending
	String jobTitleValidation = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).getText();
	Assert.assertEquals("New Job1", jobTitleValidation);
	System.out.println("Job Posted");
	}
	@AfterClass
	public void after() {
		driver.close();
		System.out.println("Driver closed");	
	}
	public static void main(String[] args) {
			
	}

}
