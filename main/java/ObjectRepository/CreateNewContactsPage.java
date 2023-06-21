package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility
{
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	//initialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getLastNameEdt()
	{
		return LastNameEdt;
	}
	
	
	//Business library
	
	public void CreateNewContact(String LASTNAME)
	
	{
	    LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
		
	}
	
	public void CreateNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "CONTACTS");
	 	SaveBtn.click();
	 	HomePage hp=new HomePage(driver);
	 	hp.logOutOfApp(driver);
	 	
	 	
	 
	    	
	  
	}
	
	
}
