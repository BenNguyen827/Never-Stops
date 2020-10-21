import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LetterAvg{
	private ArrayList<String> stationIdArray = new ArrayList<String>();
	private ArrayList<String> letterAvgStations = new ArrayList<String>();
	private String filename = "Mesonet.txt";
	private char letterAvg;
	
	//constructor initializes the letterAvg variable
	public LetterAvg(char letterAvg) {
		this.letterAvg = letterAvg;
		readFile(filename);
	}
	
	//reads a file 
	public void readFile(String filename) {
		this.filename = filename;
		
	//uses try catch to catch IOException when reading the file
		try {
		Scanner fileScan = new Scanner(new File(this.filename));
		String line;
		String[] firstCol;
		
		int numFileLines=0;
		
		// for loop skips the first three lines of file
		
		
			for (int i=0; i<3 ;++i) {
				fileScan.nextLine();
			}
		
	//reads the first String of every line in file and adds to ArrayList stationId
	
			while(fileScan.hasNextLine()) {
				
				 line = fileScan.next();
				 fileScan.nextLine();
				 
				stationIdArray.add(line);
				
			}
		fileScan.close();
	}catch (IOException e) {
		e.getMessage();
		}
	}
	
	//finds the number of stations in the file that start with the the letter Avg variable inputed into the constructor.
	public int numberOfStationWithLetterAvg() {
		int count = 0;
		for(int i = 0 ; i < stationIdArray.size(); ++i) {
			if(this.letterAvg == (stationIdArray.get(i).charAt(0))) {
				count++;
				letterAvgStations.add(stationIdArray.get(i));
			}
		}
		return count;
	}
	
	//@override
	//overrides the built in toString method to output the information in LetterAvg as a string in a specified format when 
	//printed in the driver class.
public String toString() {
		String outputString = "These stations are:";
			for(int i = 0; i< letterAvgStations.size(); ++i) {
				outputString = outputString + " " + letterAvgStations.get(i);
			}
		return outputString;
		
	}
}
