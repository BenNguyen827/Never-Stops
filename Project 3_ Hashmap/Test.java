import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
	
	public static void readFile() {
		 HashMap<LocalDate, Integer> hashmap = new HashMap<LocalDate, Integer>();
		LocalDateTime showDateTime;
		 String filename = "Dates.txt";
		 ArrayList<String> dayArray = new ArrayList<String>();
		String[] splitDayArray;
		LocalDate newDateTime;
		
		
	//try catch used to catch IOException error when reading file;
		try {
		Scanner fileScan = new Scanner(new File("Dates.txt"));
		String line;
		
		
		// for loop skips the first three lines of file
		
		
			for (int i=0; i<3 ;++i) {
				fileScan.nextLine();
			}
		
	//reads the first String of every line in file and adds to ArrayList stationIdArray
	
			while(fileScan.hasNextLine()) {
				
				 line = fileScan.next();
				 fileScan.nextLine();
				 
				dayArray.add(line);
				
			}
			
			
			for(int i = 0; i< dayArray.size(); ++i) {
				int year;
				int month;
				int day;
				int count = 1;
				
				dayArray.toString();
				splitDayArray = dayArray.get(i).split(".");
				
				year = Integer.parseInt(splitDayArray[2]);
				month = Integer.parseInt(splitDayArray[0]);
				day = Integer.parseInt(splitDayArray[1]);
				
				newDateTime = LocalDate.of(year, month, day);
				
				hashmap.put(newDateTime, count);
				System.out.println(hashmap.toString());
				
				count++;
				}
		fileScan.close();
	}catch (IOException e) {
		e.getMessage();
		}
		
		
	
	}
	
	public static void main(String[] args) {
		readFile();
	}
}
