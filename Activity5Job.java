package AlchemyJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void Test() {
	WebElement jobMenu = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a"));
	jobMenu.click();
	String jobMenuTitle = driver.getTitle();
	Assert.assertEquals("Jobs – Alchemy Jobs",jobMenuTitle);
	System.out.println("Job Menu Title is " + jobMenuTitle);
	}
	@AfterClass
	public void after() {
	driver.close();
	System.out.println("Driver closed");
	}
	public static void main(String[] args) {
			}
	}



