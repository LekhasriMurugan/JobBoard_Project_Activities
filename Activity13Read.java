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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity13Read {

    public static void main(String args[]) {
    	
    	WebDriver driver = new FirefoxDriver();
    	
    	
    	String filePath = "src/test/java/Activity13ExcelInputFile.xlsx";
    	 
        //Create an object of current class
    	Activity13Read srcExcel = new Activity13Read();
    	
        //Call read file method of the class to read data
		  List<List<String>> data = srcExcel.readExcel(filePath);
	      List<String> row ;
	      
	      driver.get("https://alchemy.hguy.co/jobs/post-a-job/");
	      WebElement postAJob = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a"));
	  	  postAJob.click();
	  	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	 row = data.get(1);
		 
		 //Email
	  	 WebElement email = driver.findElement(By.xpath("//*[@id=\"create_account_email\"]"));
		 email.sendKeys(row.get(1));
		 
		 //JobTitle
		 WebElement jobTitle = driver.findElement(By.xpath("//*[@id=\"job_title\"]"));
		 jobTitle.sendKeys(row.get(2));
		 
		 //Location
		 WebElement location = driver.findElement(By.xpath("//*[@id=\"job_location\"]"));
		 location.sendKeys(row.get(3));
		 
		 
		 //JobType
		 WebElement jobType = driver.findElement(By.xpath("//*[@id=\"job_type\"]"));
		 jobType.sendKeys(row.get(4));
		 
		//Enter Job Description
		 driver.switchTo().frame(driver.findElement(By.id("job_description_ifr")));
	     driver.findElement(By.id("tinymce")).sendKeys(row.get(5));
		 driver.switchTo().parentFrame();
		 
		 //Application URL
		 WebElement applnURL = driver.findElement(By.id("application"));
		 applnURL.sendKeys(row.get(6));
		 
		 //Company Name
		 WebElement compName = driver.findElement(By.xpath("//*[@id=\"company_name\"]"));
		 compName.sendKeys(row.get(7));
		 
		 //WebSite
		 WebElement compSite = driver.findElement(By.xpath("//*[@id=\"company_website\"]"));
		 compSite.sendKeys(row.get(8));
		 
		 //Tagline
		 WebElement compTagLine = driver.findElement(By.xpath("//*[@id=\"company_tagline\"]"));
		 compTagLine.sendKeys(row.get(9));
		 
		 //Video URL
		 WebElement compVideoURL = driver.findElement(By.xpath("//*[@id=\"company_video\"]"));
		 compVideoURL.sendKeys(row.get(10));
		 
		 //Twitter UserName
		 WebElement twitterUserName = driver.findElement(By.xpath("//*[@id=\"company_twitter\"]"));
		 twitterUserName.sendKeys(row.get(11));
		 
		 //Upload file
		 WebElement browseButton = driver.findElement(By.xpath("//*[@id=\"company_logo\"]"));
		 browseButton.sendKeys(row.get(12));
		 
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
		keyword.sendKeys("Test Specialist");
		
		//Click on Search Jobs
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
		//Verifying pending
		String jobTitleValidation = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).getText();
		Assert.assertEquals("Test Specialist", jobTitleValidation);
		System.out.println("Job Posted");
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
                    if(row.getLastCellNum() == 13) {
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
