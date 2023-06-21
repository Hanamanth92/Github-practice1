package GenericUtilities;

import java.util.Date;
import java.util.Random;



/**
 * This class consist of generic methods related to java
 * @author bandu
 *
 */
public class JavaUtility 
{
	
	/**
	 * This method will generate System date in format
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	
	public String getSystemDate()

	{
		Date d=new Date();
		return d.toString();
	}
	
	public String getSystemInFormat()
	{
		Date d=new Date();
		String[] dArr=d.toString().split(" ");
		String date=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":", "-");
		
		return date + " "+ month + " " + year + " " + time ;
	}
}
