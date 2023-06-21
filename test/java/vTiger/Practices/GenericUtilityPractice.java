package vTiger.Practices;

import java.io.IOException;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice 
{
public static void main(String[] args) throws IOException 
{

 PropertyFileUtility pUtil=new PropertyFileUtility();
 String value=pUtil.readDataFromPropertyFile("username");
 System.out.println(value);
 
 ExcelFileUtility eUtil=new ExcelFileUtility();
 String data=eUtil.readDataFromExcel("Organization", 1, 2);
 System.out.println(data);

 // eUtil.writeDataIntoExcel("Trail", 3, 4, "SpiderMan");
 // System.out.println("Data Added");
 
  JavaUtility jUtil=new JavaUtility();
  System.out.println(jUtil.getRandomNumber());
  System.out.println(jUtil.getSystemDate());
  System.out.println(jUtil.getSystemInFormat());
 
 
 
}
}
