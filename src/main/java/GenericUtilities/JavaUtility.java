package GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public String getSystemDate() {
		Date d= new Date();
		return d.toString();
	}
	
	public int getRandomNumber()
	{
		Random rNum= new Random();
		return rNum.nextInt(1000);
	}
	
	public String getSystemDateInFormat() {
		Date d= new Date();
		String date[]=d.toString().split(" ");
		String month= date[1];
		String date1= date[2];
		String time=date[3].replace(":","-");
		String year=date[5];
		
		String modifiedDate= date1+" "+month+" "+year+" "+time;
		
		return modifiedDate;
	}
	
	
}
