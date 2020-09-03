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
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Activity14Job {
	WebDriver driver;
	@BeforeClass
	public void before() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		Reporter.log("Logged in as admin");
	}
    @DataProvider(name="Inputs")
    public static Object[][] inputs() {
    	return new Object[][] { {"root", "pa$$w0rd", "adduser5107", "test277@test.com",
    		"adduser5107FN", "adduser5107LN","www.url.com"} };
    }
    @Test (dataProvider = "Inputs")
    public void testCase(String userNameValue, String passwordValue, String userName1Value, String emailValue,
    		   String firstNameValue, String lastNameValue, String websiteValue) {
    	//Loggin In
    	WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
    	userName.sendKeys(userNameValue);
    	WebElement password = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
    	password.sendKeys(passwordValue);
    	driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
    	//Click Users Menu and add new
    	WebElement usersMenu = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]"));
    	usersMenu.click();
    	WebElement addNew = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a"));
    	addNew.click();
    	//Adding Details
        WebElement userName1 = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
    	userName1.sendKeys(userName1Value);
    	WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
    	email.sendKeys(emailValue);
    	WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
    	firstName.sendKeys(firstNameValue);
    	WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
    	lastName.sendKeys(lastNameValue);
    	WebElement website = driver.findElement(By.xpath("//*[@id=\"url\"]"));
    	website.sendKeys(websiteValue);
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
    	Reporter.log("User Created");
    	//Search and Validate User created
    	WebElement search = driver.findElement(By.xpath("//*[@id=\"user-search-input\"]"));
    	search.sendKeys(userName1Value);
    	driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	String match = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr/td[1]/strong/a")).getText();
        Assert.assertEquals("adduser5107", match);
        Reporter.log("User Found");
    }
    @AfterClass
    public void after() {
    	driver.close();
    	Reporter.log("Driver Closed");
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
