package vTiger.Practices;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Clickonallcheckboxes 
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
		
		// Step 1: launch the browser - Run Time Polymorphism
				if (BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println(BROWSER + " --- Launched");
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					System.out.println(BROWSER + " --- Launched");
				} else {
					System.out.println("Invalid Browser Name");
				}
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get(URL);

				// Step 2: Login to Application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				System.out.println("Login successful");
				// Step 3: Click on Organizations link
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr/td/input[@name=\"selectall\"]")).click();
				
				

}
}