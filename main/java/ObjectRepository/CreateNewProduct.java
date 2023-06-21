package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct 
{
	
	@FindBy(name="productname")
	private WebElement PrdNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement SaveBtn;
	
	//Initialization 
	
	public CreateNewProduct(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }

	
	 //Utilization
	
	public WebElement getPrdNameEdt() {
		return PrdNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}	 
	
	public void clickOnCreateNewProduct(String PRODUCTNAME)
	{
		PrdNameEdt.sendKeys(PRODUCTNAME);
		 SaveBtn.click();
	}
		

}
