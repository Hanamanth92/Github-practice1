package vTiger.Practices;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticePrgm1 
{
	public static void main(String[] args) throws IOException
	{
		
	
	// Create all the objects of All Utilities
			JavaUtility jUtil = new JavaUtility();
			PropertyFileUtility pUtil = new PropertyFileUtility();
			ExcelFileUtility eUtil = new ExcelFileUtility();
			WebDriverUtility wUtil = new WebDriverUtility();

			WebDriver driver = null;
			
			/* Read all the required Data */
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
			String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3) + jUtil.getRandomNumber();
			String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);

			// Step 1: launch the browser - Run Time Polymorphism
			if (BROWSER.equalsIgnoreCase("chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(BROWSER + " --- Launched");
			} 
			else if (BROWSER.equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println(BROWSER + " --- Launched");
			} 
			else 
			{
				System.out.println("Invalid Browser Name");
			}
			
			wUtil.maximizeWindow(driver);
			wUtil.waitForPageLoad(driver);
			driver.get(URL);
			
			// Step 2: Login to Application
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			System.out.println("Login Successfull");
			
		  HomePage hp=new HomePage(driver);
		  hp.clickOnOrganizationsLink();
		  
		  hp.logOutOfApp(driver);
		  System.out.println("Logut Successfull");
}
}