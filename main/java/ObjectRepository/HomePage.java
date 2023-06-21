package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	
	@FindBy(linkText="Opportunities")
	private WebElement oppurtunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement MoreBtn;
	
	@FindBy(linkText="Vendors")
	private WebElement VendorsLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignoutLnk;
	
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule 4: Provide getters to access	
	
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}


	public WebElement getContactsLnk() {
		return ContactsLnk;
	}


	public WebElement getOppurtunitiesLnk() {
		return oppurtunitiesLnk;
	}
	
	
	public WebElement getProductsLnk()
	{
		return ProductsLnk;
	}
	
	public WebElement getVendorsLnk()
	{
		return VendorsLnk;
	}
	
	public WebElement getMoreBtn()
	{
		return MoreBtn;
	}
	
	public WebElement getAdministratorImg() {
		return AdminstratorImg;
	}


	public WebElement getSignOutLnk() {
		return SignoutLnk;
	}
	
	
	
	//Business libraries
	
	public void clickOnOrganizationsLink()
	{
		OrganizationsLnk.click();
	}
	
	public void clickOnContactsLink()
	{
		ContactsLnk.click();
	}
	public void clickOnOppurtunitiesLink()
	{
		oppurtunitiesLnk.click();
	}
	
	public void clickOnProductsLnk()
	{
		ProductsLnk.click();
	}
	
	public void clickOnVendorsLnk()
	{
		VendorsLnk.click();
	}
	
	public void clickOnSignoutLnk()
	{
		SignoutLnk.click();
	}
	
	public void MoreTab(WebDriver driver)
	{
		WebElement More=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions a=new Actions(driver);
		a.moveToElement(More).perform();
		VendorsLnk.click();
	}
	public void logOutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdminstratorImg);
		SignoutLnk.click();
	}

}
