package AlchemyJob;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity11Job {
	
	WebDriver driver;
	@BeforeClass
	public void before() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void test() {
		WebElement jobsMenu = driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a"));
		jobsMenu.click();
		WebElement keyword = driver.findElement(By.xpath("//*[@id=\"search_keywords\"]"));
		keyword.sendKeys("Test Engineer");
		driver.findElement(By.xpath("//*[@id=\"job_type_freelance\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"job_type_internship\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"job_type_part-time\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"job_type_temporary\"]")).click();
		WebElement search = driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/div[1]/div[4]/input"));
		search.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).click();
		System.out.println("Job Title is " +driver.getTitle());
		WebElement applyJob = driver.findElement(By.xpath("//*[@id=\"post-1239\"]/div/div/div/div[3]/input"));
		applyJob.click();	
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
