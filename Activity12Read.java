package AlchemyJob;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity12Read {

    public static void main(String args[]) {
    	
    	WebDriver driver = new FirefoxDriver();
    	
    	
    	String filePath = "src/test/java/sample.xlsx";
    	 
        //Create an object of current class
    	Activity12Read srcExcel = new Activity12Read();
    	
        //Call read file method of the class to read data
		  List<List<String>> data = srcExcel.readExcel(filePath);
	      List<String> row ;
	      
	      driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	      
	      row = data.get(1);
	      
	      WebElement ADMINusername = driver.findElement(By.id("user_login"));
	      ADMINusername.sendKeys("root");
		  
	      WebElement password =  driver.findElement(By.id("user_pass"));
	      password.sendKeys("pa$$w0rd");
		  
		  driver.findElement(By.id("wp-submit")).click();
		
		 //users
		  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]")).click();
		  
		  
		 //add new
		  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/ul/li[3]/a")).click();
		  
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //username
		 WebElement username = driver.findElement(By.id("user_login"));
		 username.sendKeys(row.get(3));
		 
		 //email
		 WebElement email = driver.findElement(By.id("email"));
		 email.sendKeys(row.get(4));
		 
		 //firstname
		 WebElement fristname = driver.findElement(By.id("first_name"));
		 fristname.sendKeys(row.get(5));
		 
		 
		 //lastname
		 WebElement lastname = driver.findElement(By.id("last_name"));
		 lastname.sendKeys(row.get(6));
		 
		 //website
		 WebElement website = driver.findElement(By.id("url"));
		 website.sendKeys(row.get(7));
		 WebElement password2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[6]/td/button"));
		 password2.click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		 for(int i = 0; i < 26; i++) {
			   password2.sendKeys(Keys.DELETE);
			}
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById('pass1').value='#tesT1&&927639_';");
		 
		 //add
		 driver.findElement(By.id("createusersub")).click();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //search
		 WebElement search = driver.findElement(By.id("user-search-input"));
		 search.sendKeys(row.get(8));
	     
		 driver.findElement(By.id("search-submit")).click();
		 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 String usernametitle = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr/td[1]/strong/a")).getText();
		 
		 Assert.assertEquals(usernametitle, "addUser818");
		 
		 System.out.println("The user was created");
		 
		 driver.close();
    }
    	
    public List<List<String>> readExcel(String filePath) {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            FileInputStream file = new FileInputStream(filePath);

            //Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                //Temp variable
                List<String> rowData = new ArrayList<String>();
                Row row = rowIterator.next();

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if(row.getLastCellNum() == 9) {
                        //Store row data
                        rowData.add(cell.getStringCellValue());
                    }
                }
                //Store row data in List
                data.add(rowData);
            }
            file.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

