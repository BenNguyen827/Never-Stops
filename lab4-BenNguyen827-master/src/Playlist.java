import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;



public class Playlist {
	
	private ArrayList<Song> songs;
	
	public Playlist() {
		songs = new ArrayList<Song>();
	}
	
	public Playlist(String filename) throws IOException {
		 this();
		addSongs(filename);	
	}
	
	public int getNumSongs() {
		return songs.size();
	}
	
	public Song getSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.get(index);
	}

	public void addSong(Song song) {
		addSong(getNumSongs(), song);
	}

	public void addSong(int index, Song song) {
		if (index < 0 || index > getNumSongs()) {
			return;
		}
		songs.add(index, song);
	}
	
	public void addSongs(String filename) throws IOException{
		Scanner file = new Scanner(new File(filename));
		
		while(file.hasNextLine()) {
			
			Song newSong  = new Song(file.nextLine());
			songs.add(newSong);
		
		}
		
	}
	
	public Song removeSong() {
		return removeSong(getNumSongs() - 1);
	}
	
	public Song removeSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.remove(index);
	}
	
	public void saveSongs(String filename) throws IOException {
	
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		bw.write(this.toString());
		bw.close();
	}
	
	public String toString() {
		StringBuilder toString = new StringBuilder();
		
		if (songs.size() > 0) {
		toString  = toString.append(songs.get(0));
		
		
		for(int i=1 ; i< this.songs.size(); ++i) {
			toString = toString.append("\n");
			toString = toString.append(songs.get(i));
		}
		
		}
		return toString.toString();
		
	}
	
	public Song getLongestSong(){
	
		if(songs.size() > 0) {
			
			
			Song longestSong = songs.get(0);
			
			for(int i =1 ; i < songs.size(); ++i) {
				int[] songsTimeArray1 = songs.get(i).getTime();
			int[] 	songsTimeArray2 = longestSong.getTime();
		
				
		
			
				
				
				if(songsTimeArray2.length < songsTimeArray1.length) {
					longestSong = songs.get(i);
				}
				
				
				
					
				
				
				if(songsTimeArray1.length == 3 && songsTimeArray2.length ==3) {
			
				if (songsTimeArray1[2] > songsTimeArray2[2]) {
					longestSong = songs.get(i);
				
				} else if (songsTimeArray1[2] == songsTimeArray2[2]) {
					
					if (songsTimeArray1[1] > songsTimeArray2[1]) {
						longestSong = songs.get(i);
						
					} else if (songsTimeArray1[1] == songsTimeArray2[1]) {
						
						if (songsTimeArray1[0] > songsTimeArray2[0]) {
						longestSong = songs.get(i);
						
						} 
						
					}
					
				}
				}
				
				if(songsTimeArray1.length == 2 && songsTimeArray2.length ==2) {
					
					 if (songsTimeArray1[1] > songsTimeArray2[1]) {
						longestSong = songs.get(i);
						
				}else if (songsTimeArray1[1] == songsTimeArray2[1]) {
						
						if (songsTimeArray1[0] > songsTimeArray2[0]) {
							longestSong = songs.get(i);
							
						} else if (songsTimeArray1[0] == songsTimeArray2[0]) {
							
							
							longestSong = songs.get(i);	
								
							
							
						}
						
					} 
					}
				
				
		if(songsTimeArray1.length == 1 && songsTimeArray2.length ==1) {
					
					if (songsTimeArray1[0] > songsTimeArray2[0]) {
						longestSong = songs.get(i);
					
					} else if (songsTimeArray1[0] == songsTimeArray2[0]) {	
						longestSong = songs.get(i);	
						
					}
					}

			
	
			}
			
			return longestSong;
				
				
				
			
			
		}else {
			return null;
		}
		
	}
	
	public int[] getTotalTime() {
		ArrayList<Integer> seconds = new ArrayList<Integer>();
		ArrayList<Integer> minutes = new ArrayList<Integer>();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		ArrayList<Integer> totalTime = new ArrayList<Integer>();
		
		
		int secondsInt = 0;
		int minutesInt = 0;
		int hoursInt = 0;
		
		if (songs.size() >0) {
		
		for(int i =0 ; i < songs.size(); ++i) {
			int[] songsTimeArray = songs.get(i).getTime();
			
			seconds.add(songsTimeArray[0]);
			if(songsTimeArray.length > 1) {
			minutes.add(songsTimeArray[1]);
			}
			if(songsTimeArray.length > 2) {
			hours.add(songsTimeArray[2]);
			}
		}
		
		for(int j=0 ; j<seconds.size(); ++j) {
			int secondsTemp  = secondsInt;
			secondsInt = secondsTemp + seconds.get(j);
			secondsTemp = 0;
				
			}
		
		for(int k=0 ; k<minutes.size(); ++k) {
			int minutesTemp = minutesInt;
			minutesInt = minutesTemp +minutes.get(k);
			minutesTemp = 0;
				
			}
		
		
		for(int g=0 ; g<hours.size(); ++g) {
			int hoursTemp = hoursInt;
			hoursInt =  hoursTemp +hours.get(g);
				hoursTemp =0;
			}
		
		while(secondsInt >=60) {
			if (secondsInt >= 60) {
				minutesInt++;
				secondsInt = secondsInt -60;
			}
			}
			while(minutesInt >= 60) {
			if (minutesInt >= 60) {
				hoursInt++;
				minutesInt = minutesInt -60;
			}
			}
		
		if (hoursInt != 0) {
			
		
		
		System.out.println(secondsInt);
		
		
		totalTime.add(secondsInt);
		totalTime.add(minutesInt);
		totalTime.add(hoursInt);
	
		
		
		}
		
		if (minutesInt != 0 && hoursInt == 0) {
			System.out.println(secondsInt);
			
			System.out.println(secondsInt);
		
			totalTime.add(secondsInt);
			totalTime.add(minutesInt);
			
			}
		
		if (minutesInt == 0) {
			
			
			
			totalTime.add(secondsInt);
		}
	
		int[] totalTimeArray = new int[totalTime.size()];
		System.out.println(totalTime.toString());
		
		for(int i= 0; i< totalTime.size(); ++i) {
			totalTimeArray[i] = totalTime.get(i);
			
		}
		
		System.out.println(totalTimeArray[0]);
		
		return totalTimeArray;
		} else {
			int[] totalTimeArray = new int[1];
			totalTimeArray[0] = 0;
			return totalTimeArray;
		}
		
	
		
		
		
			
		}
	
	
	public String getFavoriteArtist() {
		int topArtist = 0;
		int countArtist = 0;
		int j;
		if (songs.size()>0) {
		String favArtist = songs.get(0).getArtist();
		
		for(int i = 0; i< songs.size(); ++i) {
			String artist1 = songs.get(i).getArtist();
			for( j =0; j<songs.size(); ++j) {
				String artist2 = songs.get(j).getArtist();
				if(artist1.equals(artist2)) {
					countArtist++;
					
				}
				
			}
			if (countArtist > topArtist) {
				System.out.println(countArtist);
				topArtist = countArtist;
				favArtist = artist1;
				System.out.println(favArtist);
			if (countArtist == topArtist) {
				if(i<j) {
					favArtist = songs.get(i).getArtist();
				}
				if(i>j) {
					favArtist = songs.get(j).getArtist();
				}
			}
			}
			countArtist = 0;
		}
		
		return favArtist;
	}else {
		return null;
	}
	}
}
