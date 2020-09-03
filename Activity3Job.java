package AlchemyJob;

import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void Test() {
	WebElement headerImage = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/div/img"));
    String src = headerImage.getAttribute("src");
    Assert.assertEquals("https://alchemy.hguy.co/jobs/wp-content/uploads/2019/09/career-corporate-job-776615-e1569782235456-1024x271.jpg",src);
    System.out.println("Image URL is " +src);
	}
    @AfterClass
    public void after() {
    driver.close();
    System.out.println("Driver Closed");
    }
    

	public static void main(String[] args) {
		}
	}


