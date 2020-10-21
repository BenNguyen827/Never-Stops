import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PosAvg {
	private ArrayList<String> stationIdArray = new ArrayList<String>();
	private String stationId;
	private String filename = "Mesonet.txt";
	
	
	//constructor for PosAvg initializes stationId and reads a specified file;
	public PosAvg(String stationId) {
		this.stationId = stationId;
		readFile(filename);
		
	}
	
	
	//reads the inputed file
	public void readFile(String filename) {
		this.filename = filename;
		
	//try catch used to catch IOException error when reading file;
		try {
		Scanner fileScan = new Scanner(new File(this.filename));
		String line;
		String[] firstCol;
		
		int numFileLines=0;
		
		// for loop skips the first three lines of file
		
		
			for (int i=0; i<3 ;++i) {
				fileScan.nextLine();
			}
		
	//reads the first String of every line in file and adds to ArrayList stationIdArray
	
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
	
	//finds the index of the station in the list of stationId's found in the mesonet.txt file where the first index
	//is equal to 1 rather than 0
	public int indexOfStation() {
		for(int i = 0 ; i< stationIdArray.size()-2; ++i) {
		if(this.stationId.equals(stationIdArray.get(i))){
			return i+1;
		}
		}
		return 0;
	}
	//@override
	//uses a toString to override built in toString so that when PosAvg object is S.O.P in the driver the program 
	//automatically outputs the object in a specified format
	public String toString() {
		int indexOfStationId = indexOfStation()-1;
		String bottomAvg1 = "";
		String topAvg1 = "";
		String bottomAvg2 = "";
		String topAvg2 = "";
		
		for(int i = 0 ; i< stationIdArray.size()-2; ++i) {
			if(i == indexOfStationId){
				bottomAvg1 = stationIdArray.get(i-1);
				topAvg1 = stationIdArray.get(i+1);
				bottomAvg2 = stationIdArray.get(i-2);
				topAvg2 = stationIdArray.get(i+2);
			}
			}
		String outputToString = "This index is average of "+ bottomAvg1 + 
								" and " + topAvg1 + ", " + bottomAvg2 + " and " + topAvg2+", and so on.";
		return outputToString;
	}
	
	
	
}
