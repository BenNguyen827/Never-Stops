import java.sql.Date;

import javax.print.DocFlavor.STRING;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateTimeOne
{
	
	public void dateTimeNow() 
	{
		//Date/time object for date/time
		DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		LocalDateTime showDateTime = LocalDateTime.now();
		String formattedDateTimeFinal = showDateTime.format(formattedDateTime);
	    System.out.println("Current Date/Time: " + formattedDateTimeFinal);
	    
	}
	//method to obtain the current value of seconds in Date/time;
	public int getValueOfSecond() {
		LocalDateTime showDateTime = LocalDateTime.now();
		return showDateTime.getSecond();
	}
	//method to make the program sleep using thread.sleep for 3 seconds when called. 
	public void sleepForThreeSec() {
		
		 try{
			 Thread.sleep(3000);
			 }catch(InterruptedException e){
				 System.out.println("interrupted");
				 }  
		
	
	}	
	}
