	package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of generic methods related to all web driver 
 * @author bandu
 *
 */
public class WebDriverUtility 
{
    /**
     * This method will maximize the window
     * @param driver
     */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
     * This method will minimize the window
     * @param driver
     */
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();	
	}
	
	
	/**
	 * This method will wait for page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	/**
	 * This method will wait for 20 sec for a element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle drop down by value 
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select (element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * This method will handle drop down by index 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sel=new Select (element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down by VisibleText 
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(String visibleText,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will right click anywhere on webPage
	 * @param driver
	 * @param element
	 */
	
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
   	
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will right click  on particular WebElement
	 * @param driver
	 * @param element
	 */

	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will 
	 * @param driver
	 */
	public void doubleClickaction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	
	public void doubleClickaction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will drag and drop from src	element to target element
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	
	public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement targetElement)
	{
	 
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement,targetElement).perform();
	
	}
	
	
	/**
	 * This method will drag and drop from src element to target element offsets
	 * @param driver
	 * @param src
	 * @param x
	 * @param y
	 */
	public void dragAndDropAction(WebDriver driver,WebElement src,int x,int y)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(src,x,y).perform();
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame by WebElement 
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,WebElement element )
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will handle frame to the default frame
	 * @param driver
	 */
	
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will accept alert pop-up
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss alert pop-up
	 * @param driver
	 */
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * This method will dismiss the alert pop-up
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	/**
	 * This method will take screenShot and return absolute path
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File dst=new File(".\\ScreenShots\\" + screenShotName+ ".png" );
                                              //ScreenShot1.png	
	  
	  Files.copy(src,dst);
	  
	  return dst.getAbsolutePath();
	}
	
	
	/**
	 * This method will switch the windows based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		//Step1: Capture all the WindowIDs
		Set<String> winIDs=driver.getWindowHandles();
		
		
		//Step2:Navigate to each window
		for(String windID:winIDs)
		{
			//Step3:capture the title of each window
			String actTitle=driver.switchTo().window(windID).getTitle();
			
			//Step4:compare the title
			if(actTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
		
	}
	
	
	
	
	
	
	
}
