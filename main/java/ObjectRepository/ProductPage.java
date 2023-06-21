package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
  
	//Declaration
	
	@FindBy(xpath=("//img[@title='Create Product...']"))
     private WebElement ProductLookUpImg;
	
	//Initializations
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProductLookUpImg()
	{
		return ProductLookUpImg;
	}	
	
	//Business libraries
	
	public void clickOnProductLookUpImg()
	{
		ProductLookUpImg.click();
	}
		
		
  
  
  
}
