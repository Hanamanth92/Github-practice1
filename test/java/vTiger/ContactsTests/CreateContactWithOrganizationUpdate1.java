package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactsPage;
import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationUpdate1 


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

		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);

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
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("Login successful");

		// Step 3: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 5: Create Organization with mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		// Step 6: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		
		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		} else {
			System.out.println("FAIL");
		}

		// Step 7: Navigate to Contacts link
		hp.clickOnContactsLink();

		// Step 8: click on create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsLookUpImg();

		// Step 9: Create Contact
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.CreateNewContact(driver, LASTNAME, ORGNAME);

		// Step 10: Validate for Organization
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String ContactHeader = cip.getContactHeader();
		
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		//Step 11: Logout of App
		hp.logOutOfApp(driver);
		System.out.println("Logout successful");
		
	}

}
