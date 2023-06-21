package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
 //Rule 1: Create a Class
	
	
	//Rule 2: Identify the element using annotations
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	
	
	//Rule 3: Create a constructor to initialize
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	
	//Rule 4: Provide getters to access	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	
	//Business Libraries - project generic utilities
	/**
	 * This method will login to app
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
}
