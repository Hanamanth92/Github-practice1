package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsInfoPage 
{
	
	
    //Decalration
	
	@FindBy(xpath="lvtHeaderText")
    private WebElement VndHeaderText;
	
	//Initialization
	public VendorsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//Utilization
	public WebElement getVndHeaderText()
	{
		return VndHeaderText;
	}
	
	
	//Business libraries
	
	public String getVndHeader()
	{
		return VndHeaderText.getText();
	}
	
	
	

}
