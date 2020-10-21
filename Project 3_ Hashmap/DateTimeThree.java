import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeThree {
	private HashMap<LocalDate, Integer> hashmap;
	LocalDateTime showDateTime;
	private String filename = "Dates.txt";
	private ArrayList<String> dayArray = new ArrayList<String>();
	private String[] splitDayArray;
	LocalDate newDateTime;
	
	
	public DateTimeThree() {
		this.hashmap = new HashMap<LocalDate, Integer>();
		this.showDateTime = LocalDateTime.now();
		readFile(filename);
		
	}
	
	
	
	public void readFile(String filename) {
		this.filename = filename;
		
	//try catch used to catch IOException error when reading file;
		try {
		Scanner fileScan = new Scanner(new File(this.filename));
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
					
				splitDayArray = dayArray.get(i).split(".");
				
				year = Integer.parseInt(splitDayArray[2]);
				month = Integer.parseInt(splitDayArray[0]);
				day = Integer.parseInt(splitDayArray[1]);
				
				newDateTime = LocalDate.of(year, month, day);
				
				hashmap.put(newDateTime, count);
				count++;
				}
		fileScan.close();
	}catch (IOException e) {
		e.getMessage();
		}
		
		
	
	}
	
	

	public void compareYear() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
	}

}
