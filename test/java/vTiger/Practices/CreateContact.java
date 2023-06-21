package vTiger.Practices;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact 
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
		
		
		//Step3:click on contact link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Stpe4: click on create Contact lookup image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step5: Create Contact with mandatory fields
        driver.findElement(By.name("firstname")).sendKeys("Hanamanth");
        driver.findElement(By.name("lastname")).sendKeys("Hugar"+r);
        
        //Step6:save
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
         //Step7: validate
        WebElement ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
        
        if( ContactHeader.equals("Hugar"+r+"Hanamanth"))
        {
        System.out.println(ContactHeader);
        System.out.println("Test Script pass");
        }
        else
        {
        	System.out.println("fail");
        }
        
      //Step9: LogOut of application
        WebElement adImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions act=new Actions(driver);
        act.moveToElement(adImg).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("Sign Out Successfull");
         
}
 
 
}
