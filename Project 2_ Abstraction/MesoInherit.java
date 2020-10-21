public class MesoInherit extends MesoAbstract
{
	
	private MesoStation stationMeso;
	
	//constructor initializes MesoStation argument for MesoInherit class
	public MesoInherit(MesoStation stationMeso) {
		this.stationMeso = stationMeso;
	}
	
	
	//method returns the MathCeil, MathFloor, and the average of the average of the ascii values of each char in the 
	//MesoStation class
	public int[] calAverage() {
		//uses MesoStation method to initialize a String
		String stationMesoString = this.stationMeso.getStID();
		int[] stationMesoArr = new int[3];
		double asciiAverage = 0 ;
		
	//for loop to loop through each char of the stationMesoString and adds up the ascii values of each Char into ascii average
			for(int i = 0 ; i< stationMesoString.length() ; ++i) {
				asciiAverage = asciiAverage + (int) stationMesoString.charAt(i);
			}
	//divides ascii average by the number of chars in the string to find the true average.
		asciiAverage = asciiAverage/stationMesoString.length();
	
	//uses the Math ceil and foor methods to respectively round up and down to the nearest integer.
		stationMesoArr[0] = (int) Math.ceil(asciiAverage);
		stationMesoArr[1] = (int) Math.floor(asciiAverage);
	
	//if the decimal portion of the asciiAverage value is equal to or greater than 0.75 then the 
	//ascii average is equal to the math.ceil value if not then ascii average is equal to the math.floor value
			if(stationMesoArr[0]-0.25 <= asciiAverage) {
				stationMesoArr[2] = stationMesoArr[0];
			}
			if(stationMesoArr[0]- 0.25 > asciiAverage) {
				stationMesoArr[2] = stationMesoArr[1];
			}
			
		return stationMesoArr;
	}
	
	//finds the char representation by converting the int ascii average obtained in calAverage() into a char using ascii;
	public char letterAverage() {
		int averageInt = calAverage()[2];
		char letterAverage = (char) averageInt;
		return letterAverage;
	}
	
	
}