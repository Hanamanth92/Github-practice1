package vTiger.Practices;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndudtryUsingPOM 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	 {
	   
		 
		 //Create all the objects of All objects
		 
		 JavaUtility jUtil=new JavaUtility();
		 PropertyFileUtility pUtil=new PropertyFileUtility();
		 ExcelFileUtility eUtil=new ExcelFileUtility();
		 WebDriverUtility wUtil=new WebDriverUtility();
		 WebDriver driver=null;
		 
		 /*Read all the required data*/	
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY=eUtil.readDataFromExcel("Organization", 4, 3);
		
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
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME,PASSWORD);
			System.out.println("Login Successfull");
		 
		 //Step3: click on Organization link
		  HomePage hm=new HomePage(driver);
		  hm.clickOnOrganizationsLink();
				  
			
		 //Stpe4: click on create org lookup image
		  OrganizationsPage op=new OrganizationsPage(driver);
		   op.clickOnCreateOrgLookUpImg();
			
		 //Step5: Create Organization with mandatory fields
		   CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		   cnop.createNewOrganization(ORGNAME, INDUSTRY);
		   
		 //Step6: Choose 'Chemicals' on Industry drop-down
		   
		    WebElement industrydropdown=driver.findElement(By.name("industry"));
	     Select sel=new Select(industrydropdown);
	     sel.selectByValue(INDUSTRY);
	     
	   
	    //Step8: validate
	     OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	    String  OrgHeader=oip.getOrgHeader();
	    		 
	     
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
