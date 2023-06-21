package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
	@FindBy(linkText="lvtHeaderText")
	private WebElement PrdHeaderText;
	
	//Initialization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}	
	
	
	//Utilization
	public WebElement getPrdHeaderText()
	{
		return PrdHeaderText;
	}
	
	
	//Business library
	public String getPrdHeader()
	{
		return PrdHeaderText.getText();
	}
}
