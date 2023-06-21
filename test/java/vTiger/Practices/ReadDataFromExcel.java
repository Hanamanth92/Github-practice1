package vTiger.Practices;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException
{
	//Step1:Open the file in java readable format
	FileInputStream fise= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	
	
	//Step2:Create a workbook factory
	Workbook wb=WorkbookFactory.create(fise);
	
	//Step3:get control of Sheet
	Sheet sh=wb.getSheet("Organization");
	
	//Step4: get control of row 
	Row rw=sh.getRow(1);
	
	//Step5: get control of cell
	Cell ce=rw.getCell(2);
	
	//Step6:capture the information inside the cell
	String value =ce.getStringCellValue();
	System.out.println(value);
}
}
