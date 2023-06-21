package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility

{
	
 @FindBy(name="accountname")
 private WebElement OrgNameEdt;
 
 @FindBy(name="industry")
 private WebElement IndustryDropDown;
 
 @FindBy(xpath="//input[@title='Save [Alt+S]']")
 private WebElement SaveBtn;
 
 //Initialization 
 public CreateNewOrganizationPage(WebDriver driver)
 {
	 PageFactory.initElements(driver,this);
 }
 
 //Utilization
 public WebElement getOrgNameEdt()
 {
	 return OrgNameEdt;
 }
 
 public WebElement getIndustryDropDown()
 {
	 return IndustryDropDown;
 }
 
 public WebElement getSaveBtn()
 {
	 return SaveBtn;
 }
 
 /**
  * This method will create a new Organization
  * @param ORGNAME
  */
 public void createNewOrganization(String ORGNAME)
 {
	 OrgNameEdt.sendKeys(ORGNAME);
	 SaveBtn.click();
 }
 
 
 public void createNewOrganization(String ORGNAME,String INDUSTRY)
 {
	 OrgNameEdt.sendKeys(ORGNAME);
	 handleDropDown(IndustryDropDown, INDUSTRY);
	 SaveBtn.click();
 }
}
