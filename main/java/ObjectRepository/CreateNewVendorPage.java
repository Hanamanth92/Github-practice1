package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewVendorPage extends WebDriverUtility
{

	@FindBy(name="vendorname")
	private WebElement VndNameEdt;
	
	@FindBy(name="glacct")
	private WebElement GLAccDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement SaveBtn;
	
	//Initialization 
	 public CreateNewVendorPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }

	 
	 //Utilization
	 
	public WebElement getVndNameEdt() {
		return VndNameEdt;
	}

	public WebElement getGLAccDropdown() {
		return GLAccDropdown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	 
	

	 
	public void clickOnCreateNewVendor(String VENDORNAME,String GLAcc)
	{
		VndNameEdt.sendKeys(VENDORNAME);
		handleDropDown(GLAccDropdown, GLAcc);
		 SaveBtn.click();
	}

	 
	
	
}
