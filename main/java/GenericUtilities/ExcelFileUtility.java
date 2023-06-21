package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility 
{
	public String readDataFromExcel(String sheetName, int rowNo,int celNo) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
		
	}
	
	public void writeDataIntoExcel(String sheetName, int rowNo,int celNo,String value ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.createSheet(sheetName).createRow(rowNo).createCell(celNo).setCellValue(value);
		
		
		FileOutputStream fos=new FileOutputStream(IConstantUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}
}	


