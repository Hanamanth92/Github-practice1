package vTiger.Practices;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustry1stChanges

{
 public static void main(String[] args) throws EncryptedDocumentException, IOException 
 {
  
	 WebDriver driver=null;
	 Random ran = new Random();
		int r = ran.nextInt(1000);
		
		/*Read all the required data*/
		
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		
	String BROWSER=p.getProperty("browser");
	String URL=p.getProperty("url");
	String USERNAME=p.getProperty("username");
	String PASSWORD=p.getProperty("password");
	
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fise);
	Row rw=wb.getSheet("Organization"
			+ "").getRow(4);
	String ORGNAME=rw.getCell(2).getStringCellValue()+ran;
	String INDUSTRY=rw.getCell(3).getStringCellValue();
	
	 //Step1: launch the browser
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 System.out.println(BROWSER + "----Launched");
	}	
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 System.out.println(BROWSER + "----Launched");
	}
	else
	{
		System.out.println("Invalid browser");
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
	 
	 //Step2: login into the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login Successfull");
	 
	 //Step3: click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
		
	 //Stpe4: click on create org lookup image
	   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
	 //Step5: Create Organization with mandatory fields
	   driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
	   
	 //Step6: Choose 'Chemicals' on Industry drop-down
	   
	    WebElement industrydropdown=driver.findElement(By.name("industry"));
     Select sel=new Select(industrydropdown);
     sel.selectByValue(INDUSTRY);
     
   //Step7: Save 
     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
     
    //Step8: validate
     String OrgHeader= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
     
     if(OrgHeader.contains(ORGNAME))
     {
     	System.out.println(OrgHeader);
     	System.out.println("Test Script Passed");
     }
     else
     {
     	System.out.println("FAIL");
     }
     
     //Step9: LogOut of application
     WebElement adImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     Actions act=new Actions(driver);
     act.moveToElement(adImg).perform();
     driver.findElement(By.linkText("Sign Out")).click();
     System.out.println("Sign Out Successfull");
      
      
}
}