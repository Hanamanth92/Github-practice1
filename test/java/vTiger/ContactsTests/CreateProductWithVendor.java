package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.CreateNewProduct;
import ObjectRepository.CreateNewVendorPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;
import ObjectRepository.VendorsInfoPage;
import ObjectRepository.VendorsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductWithVendor extends WebDriverUtility
{ 
	
	public static void main(String[] args) throws IOException {

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

		String VENDORNAME = eUtil.readDataFromExcel("Product", 4, 3) + jUtil.getRandomNumber();
		String PRODUCTNAME = eUtil.readDataFromExcel("Product", 4, 2);

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
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		HomePage hp=new HomePage(driver);
		hp.MoreTab(driver);
		
		VendorsPage vp=new VendorsPage(driver);
		vp.clickOnCreateVendorsLookUpImg();
		
	
		CreateNewVendorPage cnvp=new CreateNewVendorPage(driver);
		cnvp.clickOnCreateNewVendor(VENDORNAME, PRODUCTNAME);
		
		
		
		hp.clickOnProductsLnk();
		
		ProductPage pp=new ProductPage(driver);
		pp.clickOnProductLookUpImg();
		
		CreateNewProduct cnp=new CreateNewProduct(driver);
		
		
		
		
		
		
		
				
	}   

}
