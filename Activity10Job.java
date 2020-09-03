package AlchemyJob;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity10Job {
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
		//Click Users Menu and add new
		WebElement usersMenu = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]"));
		usersMenu.click();
		WebElement addNew = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a"));
		addNew.click();
		//Adding Details
		WebElement userName1 = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
		userName1.sendKeys("adduser3154");
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("test223@test.com");
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
		firstName.sendKeys("adduser3154");
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
		lastName.sendKeys("adduser31last");
		WebElement website = driver.findElement(By.xpath("//*[@id=\"url\"]"));
		website.sendKeys("www.url.com");
		WebElement password2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[6]/td/button"));
		password2.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		for(int i = 0; i < 26; i++) {
		   password2.sendKeys(Keys.DELETE);
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('pass1').value='#tesT1&&927639_';");
	    driver.findElement(By.xpath("//*[@id=\"send_user_notification\"]")).click();
		Select roleDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"role\"]")));
		roleDropDown.selectByVisibleText("Subscriber");
		//Add New User Button Click
		WebElement addUserButton = driver.findElement(By.xpath("//*[@id=\"createusersub\"]"));
		addUserButton.click(); 
		//Search and Validate User created
		WebElement search = driver.findElement(By.xpath("//*[@id=\"user-search-input\"]"));
		search.sendKeys("adduser3154");
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String username = "adduser3154";
		List<WebElement> Rowmatch = driver.findElements(By.xpath("//table[@class='wp-list-table widefat fixed striped users']//tbody//tr"));
		            int rowcount = Rowmatch.size();
		            for(int m=1;m<=rowcount+1;m++)    
		            {
		                
		                WebElement usernameElement= driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped users']//tbody//tr["+m+"]//td[1]//strong//a"));
                        String usernameStr=usernameElement.getText();
		                if(usernameStr.equalsIgnoreCase(username))
		                {
		                System.out.println("User Found");
		                break;
		                }
		            }
		                
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