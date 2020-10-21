import java.util.Arrays;

public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	private static final String INFO_DELIMITER = "; ";
	private static final String TIME_DELIMITER = ":";
	private static final int IDX_TITLE = 0;
	private static final int IDX_ARTIST = 1;
	private static final int IDX_TIME = 2;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
	}
	public Song(String info) {
		String[] infoSplit = info.split(INFO_DELIMITER);
		this.title = infoSplit[0];
		this.artist = infoSplit[1];
		
		String[] timeSplit = infoSplit[2].split(TIME_DELIMITER);
		
		this.time = new int[timeSplit.length];
		for(int i=0; i<timeSplit.length ; ++i) {
			this.time[i] = Integer.parseInt(timeSplit[time.length-1-i]);
			
		}
		
		
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}
	public String toString() {
		String time= "";
		
			if (this.time.length == 3) {
				String seconds = String.valueOf(this.time[0]);
				String minutes = String.valueOf(this.time[1]);
				String hours = String.valueOf(this.time[2]);
				
				if(this.time[1]<10) {
					minutes = String.format("%02d", this.time[1]);
				}
				if(this.time[0]<10) {
					seconds = String.format("%02d", this.time[0]);
				}
				
				
				time  = hours + TIME_DELIMITER + minutes +TIME_DELIMITER +seconds;
				
			}
			if (this.time.length ==2) {
				String seconds = String.valueOf(this.time[0]);
				String minutes = String.valueOf(this.time[1]);
				
				
				if(this.time[0]<10) {
					seconds = String.format("%02d", this.time[0]);
				}
				
				time  = minutes + TIME_DELIMITER + seconds;
			}
			if (this.time.length ==1) {
				
				
				String seconds = String.valueOf(this.time[0]);
				 time  = seconds;
				
			}
			
			return  this.title + INFO_DELIMITER + this.artist +INFO_DELIMITER + time;
			
	}
}
