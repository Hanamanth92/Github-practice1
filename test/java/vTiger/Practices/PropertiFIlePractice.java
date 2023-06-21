package vTiger.Practices;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiFIlePractice 
{
public static void main(String[] args) throws IOException 
{

	
	//Step1: Open the file in java readable format
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	//Step2: Create Object of Properties class from java.util
	Properties pObj=new Properties();
	
	//Step3: Load the file into properties
	pObj.load(fisp);
	
	//Step4: Give the key and read the value 
	String value =pObj.getProperty("browser");
	System.out.println(value);
	
	String value1=pObj.getProperty("url");
	System.out.println(value1);
	
	
	
	
	
}
}
