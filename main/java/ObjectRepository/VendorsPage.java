package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage

{

	//Declaration
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement CreateVendorsLookUpImg;
	
	//Initializations
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateVendorsLookUpImg()
	{
		return CreateVendorsLookUpImg;
	}
	
	//Business libraries
	
	public void clickOnCreateVendorsLookUpImg()
	{
		CreateVendorsLookUpImg.click();
	}
	
	
	
}
