
import java.util.Arrays;

public class Playlist {
	private Song[] songs;
	private int numSongs;
	private final int MIN_CAPACITY = 2;
	

	public Playlist() {
		this.songs = new Song[MIN_CAPACITY];
		this.numSongs = 0;
		

		
	}

	public int getCapacity() {
		return songs.length;
		
	}

	public int getNumSongs() {
		
		return numSongs;
		
	}

	public Song getSong(int index) {
		if (index>= 0 && index < numSongs) {
			
			return this.songs[index];
			
		} else {
			
			return null;
		}
		
	}

	public void addSong(Song song) {
		addSong(numSongs, song);
		
	}

	public void addSong(int index, Song song) {
		if (index>= 0 && index<= numSongs) {
		
			if(songs.length == numSongs) {
				
				songs = Arrays.copyOf(songs, songs.length*2);
				}
		
		int i;
		
		for (i = numSongs; i> index;--i) {
			songs[i] = songs[i-1];	
		}
		
		
		songs[index] = song;
		numSongs++;
		
		
		
		
		} else {
			return;
		}
			
		
		
	}

	public Song removeSong() {
		return removeSong(numSongs-1);
		
		
	}

	public Song removeSong(int index) {
	
		if (index>= 0 && index< numSongs) {
			Song tempSong = songs[index];
			for(int i = index; i< numSongs-1;++i) {
				songs[i] = songs[i+1];
				
			}
			
			
			numSongs--;
			
			if (numSongs <= songs.length/4 && songs.length > MIN_CAPACITY) {
				songs = Arrays.copyOf(songs, songs.length/2);
				if (songs.length < MIN_CAPACITY) {
					songs = Arrays.copyOf(songs, MIN_CAPACITY);
				}
				
			}
			
			return tempSong;
			
		} else {
			return null;
			
		}
		
		
		
	}

}