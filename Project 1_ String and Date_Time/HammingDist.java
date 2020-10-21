//Complete this...
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;

public class HammingDist {
	
	//initializing norman station Id, arguments for HammingDist constructor and arrayList for storing stationId's from file
	private String station1;
	private String station2;
	private ArrayList<String> stationId = new ArrayList<String>();
	private final String NORMAN = "NRMN";
	
	// constructor for HammingDist, as well as calls readFile method with filename Mesonet.txt written later
	
	public HammingDist(String station1, String station2) throws IOException{
		this.station1 = station1;
		this.station2 = station2;
		readFile("Mesonet.txt");
		
	}
	
	//readFile method reads the first column of filename and skips first 5 lines of file
	
	public void readFile(String filename) throws IOException {

		Scanner fileScan = new Scanner(new File(filename));
		String line;
		String[] firstCol;
		
		int numFileLines=0;
		
		// for loop skips the first five lines of file
		
			for (int i=0; i<5 ;++i) {
				fileScan.nextLine();
			}
		
	//reads the first String of every line in file and adds to ArrayList stationId
	
			while(fileScan.hasNextLine()) {
				
				 line = fileScan.next();
				 fileScan.nextLine();
				 
				stationId.add(line);
				
			}
		fileScan.close();
	}
	
	//method to find the hammingDist between two stationId's
	
	public int findHammingDist(String stationNum, String norman) {
		
		int hammingDistInt = 0;
		
			for(int i=0 ; i<stationNum.length(); ++i) {
			
			//if statement compares each index of stationId String and adds one to hammingDistInt if index's are not equal
				if (!(stationNum.substring(i, i+1).equals(norman.substring(i, i+1)))) {	
				hammingDistInt++;	
				}
			
			}
		
		return hammingDistInt;
	} 
	
	//checks a stationId String with all stationId's read in file.
	
	public int checkAllHammingDist(ArrayList<String> allStations, String stationNum) {
		
		int sameHammingDist = 0;
		int hamStation = findHammingDist(stationNum, NORMAN);
	
		//for loop to check if each stationId in file's hamming distance with stationNum 
		//is equal to that same stationNum's hamming Dist with Norman
			for(int i =0 ; i< allStations.size() ; ++i) {
				if(findHammingDist(allStations.get(i), stationNum) == hamStation) {
				
				sameHammingDist++;
				}	
			}
		
		return sameHammingDist;
		
	}
	
	//to string method to allow HammingDist class to be 
	//called in system on driver class by converting information in to a string
	public String toString()  {
		
		String firstLine;
		String secondLine;
		String thirdLine;
	
			firstLine = "The Hamming distance between Norman and "+ this.station1 + "  is "+ findHammingDist(this.station1, NORMAN) +
						"; between Norman and "+ this.station2 + " is "+ findHammingDist(this.station2 , NORMAN) + ".";
		
			secondLine = "For "+ this.station1 +": Number of stations with Hamming Distance "+ 
						findHammingDist(this.station1 , NORMAN) + ": " + checkAllHammingDist(stationId, this.station1) +"." ;
		
			thirdLine = "For " + this.station2 + ": Number of stations with Hamming Distance " + 
						findHammingDist(this.station2, NORMAN) + ": "+ checkAllHammingDist(stationId,this.station2) + "." ;
		
		//returns all three lines of output containing desired information from Hamming Distance class.
		
		return firstLine + "\n" + secondLine + "\n" + thirdLine;
	}
	
}


