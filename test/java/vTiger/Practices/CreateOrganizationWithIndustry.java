package vTiger.Practices;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustry 
{
 public static void main(String[] args) 
 {
  
	 
	    Random ran = new Random();
		int r = ran.nextInt(1000);
	 //Step1: launch the browser
	 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
	 
	 //Step2: login into the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login Successfull");
	 
	 //Step3: click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
		
	 //Stpe4: click on create org lookup image
	   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
	 //Step5: Create Organization with mandatory fields
	   driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("landmark" +r);
	   
	 //Step6: Choose 'Chemicals' on Industry drop-down
	   
	    WebElement industrydropdown=driver.findElement(By.name("industry"));
        Select sel=new Select(industrydropdown);
        sel.selectByValue("Chemicals");
        
      //Step7: Save 
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
       //Step8: validate
        String OrgHeader= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        
        if(OrgHeader.contains("landmark"))
        {
        	System.out.println(OrgHeader);
        	System.out.println("Test Script Passed");
        }
        else
        {
        	System.out.println("FAIL");
        }
        
        //Step9: LogOut of application
        WebElement adImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions act=new Actions(driver);
        act.moveToElement(adImg).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("Sign Out Successfull");
         
         
}
      	   
}

