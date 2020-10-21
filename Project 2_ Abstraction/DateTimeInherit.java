/**
 * DateTimeInherit is a class that inherits the class named, DateTimeAbstract  
 */
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.DayOfWeek;

public class DateTimeInherit extends DateTimeAbstract {
//prints out the input year and month and finds the weekday that is the first day of the specified month and the 
//weekday for the last day of the specified month
	public void daysOfAnyMonth(int monthOfYear, int theYear) {
		//uses the year and month int arguments to create a YearMonth object
		YearMonth yearMonth = YearMonth.of(theYear, monthOfYear);
		
		//uses the YearMonth object to find the date for the first and last days in a LocalDate object
		LocalDate firstDay = yearMonth.atDay(1);
		LocalDate lastDay = yearMonth.atEndOfMonth();
		
		//uses those LocalDate objects to find the day of the week as a DayOfWeek object
		DayOfWeek firstDay2 = firstDay.getDayOfWeek();
		DayOfWeek lastDay2 = lastDay.getDayOfWeek();
		
		//prints out the information into the specified format
		System.out.println("In the year "+theYear+" , for the "+monthOfYear+"th month: the first day is "+ firstDay2 + "and the last day is " + lastDay2 );
	}
}