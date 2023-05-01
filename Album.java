/*Album Class
 *Author: Thomas Watkins
 *Student No: 3442737
 *Date Started: 27/3/23
 *Description: 
 * A Class for storing methods and information about the album object for the SongCollection Program
 */ 

 public class Album{
    //initialising instance variables for the album object//
    private String albumName;
    private Song song1 = new Song("no name added", "no artist added", 0, "no genre added" );
    private Song song2 = new Song("no name added", "no artist added", 0, "no genre added" );
    private Song song3 = new Song("no name added", "no artist added", 0, "no genre added" );
    private Song song4 = new Song("no name added", "no artist added", 0, "no genre added" );
    private int albumTime;
    private int maxAlbumTime = 1200;

//constructor Album to the empty string and empty interior data
public Album(String albumName, int albumTime, int maxAlbumTime) {
    this.albumName = albumName;
    this.albumTime = albumTime;
    this.maxAlbumTime = maxAlbumTime;
    song1 = null;
    song2 = null;
    song3 = null;
    song4 = null;
}


//other methods
    //set an album name
public void setAlbumName (String am)
    {
        albumName = am;
    }
    
//get an album name
public String getAlbumName ()
    {
        return albumName ;
    }

//add song + error messages ---------------------------
public void addSong(Song song) {
// Check if the album already has four songs

    if (song1 != null && song2 != null && song3 != null && song4 != null) {
        System.out.println("Error: This album already has the maximum number of songs.");
        return;
        }
    
// Check if adding the new song will exceed the 20-minute limit

        int totalAlbumDuration = getAlbumDuration() + song.getSongDuration();
        if (totalAlbumDuration > maxAlbumTime) {
            System.out.println("Error: The total duration of the album cannot exceed 20 minutes.");
            return;
        }
    
// Check if song already exists in the album
    for (int i = 1; i <= 4; i++) {
        Song existingSong = getSongByNumber(i);
        if (existingSong != null && 
            existingSong.getSongName().equalsIgnoreCase(song.getSongName()) && 
            existingSong.getSongArtist().equalsIgnoreCase(song.getSongArtist()) && 
            existingSong.getSongGenre().equalsIgnoreCase(song.getSongGenre()) && 
            existingSong.getSongDuration() == song.getSongDuration()) {
            System.out.println("Error: This song already exists in the album.");
            return;
        }
        }
    
// Add the song to the album
        if (song1 == null) {
            song1 = song;
        } else if (song2 == null) {
            song2 = song;
        } else if (song3 == null) {
            song3 = song;
        } else if (song4 == null) {
            song4 = song;
        }
        System.out.println("Song added to " + albumName + ": " + song.getSongName());
    }
    
//------------------------------------------------------------


//print song names
public String getSongList() {
    String songList = "";
    if (song1 != null) {
        songList += song1.getSongName() + "\n";
    }
    if (song2 != null) {
        songList += song2.getSongName() + "\n";
    }
    if (song3 != null) {
        songList += song3.getSongName() + "\n";
    }
    if (song4 != null) {
        songList += song4.getSongName() + "\n";
    }
    return songList;
}

     
//checking album total duration
public int getAlbumDuration() {
    int totalDuration = 0;
        if (song1 != null) {
            totalDuration += song1.getSongDuration();
        }
        if (song2 != null) {
            totalDuration += song2.getSongDuration();
        }
        if (song3 != null) {
            totalDuration += song3.getSongDuration();
        }
        if (song4 != null) {
            totalDuration += song4.getSongDuration();
        }
        return totalDuration;
    }
//getting the song by checking the name entered
public Song getSongByName(String songName) {
        if (song1 != null && song1.getSongName().equals(songName)) {
            return song1;
        }
        if (song2 != null && song2.getSongName().equals(songName)) {
            return song2;
        }
        if (song3 != null && song3.getSongName().equals(songName)) {
            return song3;
        }
        if (song4 != null && song4.getSongName().equals(songName)) {
            return song4;
        }
            return null;
        }
//removing a song by setting the song object to null
public void removeSong(Album album, Song song) {
        if (album.getSong1() != null && album.getSong1().equals(song)) {
            album.setSong1(null);
            album.setAlbumTime(album.getAlbumTime() - song.getSongDuration());
        } else if (album.getSong2() != null && album.getSong2().equals(song)) {
            album.setSong2(null);
            album.setAlbumTime(album.getAlbumTime() - song.getSongDuration());
        } else if (album.getSong3() != null && album.getSong3().equals(song)) {
            album.setSong3(null);
            album.setAlbumTime(album.getAlbumTime() - song.getSongDuration());
        } else if (album.getSong4() != null && album.getSong4().equals(song)) {
            album.setSong4(null);
            album.setAlbumTime(album.getAlbumTime() - song.getSongDuration());
        }
        }
//getting the album time by checking if song exists, then adding the duration 
public int getAlbumTime() {
        int albumTime = 0;
        if (song1 != null) {
            albumTime += song1.getSongDuration();
        }
        if (song2 != null) {
            albumTime += song2.getSongDuration();
        }
        if (song3 != null) {
            albumTime += song3.getSongDuration();
        }
        if (song4 != null) {
            albumTime += song4.getSongDuration();
        }
        return albumTime;
        }
    
//returning each song for the getSongByDuration method 
public Song getSong1() {
        return song1;
    }

public Song getSong2() {
        return song2;
    }

public Song getSong3() {
        return song3;
    }

public Song getSong4() {
        return song4;
    }

//checking each song object, if song exists check if entered genre matches the song genre data of the song (ignore cases)
public String getSongByGenre(String genre) {
        if (song1.getSongGenre().equalsIgnoreCase(genre)) {
            return song1.getSongName();
        } else if (song2.getSongGenre().equalsIgnoreCase(genre)) {
            return song2.getSongName();
        } else if (song3.getSongGenre().equalsIgnoreCase(genre)) {
            return song3.getSongName();
        } else if (song4.getSongGenre().equalsIgnoreCase(genre)) {
            return song4.getSongName();
        } else {
            return "No song found with genre " + genre;
        }
    }
//getting songs under duration by getting each song object and checking if its duration is < given duration
public String getSongsUnderDuration(int duration) {
        String result = "";
        if (song1.getSongDuration() < duration) {
            result += song1.getSongName() + " ";
        }
        if (song2.getSongDuration() < duration) {
            result += song2.getSongName() + " ";
        }
        if (song3.getSongDuration() < duration) {
            result += song3.getSongName() + " ";
        }
        if (song4.getSongDuration() < duration) {
            result += song4.getSongName() + " ";
        }
        if (result.equals("")) {
            return "No songs found under " + duration + " seconds.";
        } else {
            return "Songs under " + duration + " seconds: " + result;
        }
    }

// This method returns the number of songs in an album by iterating over the first 4 songs
public int getNumberOfSongs() {
    int numberOfSongs = 0; 
    for (int i = 0; i < 4; i++) { // iterate over the first 4 songs
    Song song = getSongByNumber(i); // get the song at the current index
    if (song != null) { // if a song exists at this index, increment the count
    numberOfSongs++;
    } else { 
    break;
    }
    }
    return numberOfSongs; // return the final count of songs
    }
//creates an index for each song corresponding to their position in the album 1 through 4
public Song getSongByNumber(int songNumber) {
    for (int i = 1; i <= 4; i++) {
        if (song1 != null && i == songNumber) {
            return song1;
        } else if (song2 != null && i == songNumber) {
            return song2;
        } else if (song3 != null && i == songNumber) {
            return song3;
        } else if (song4 != null && i == songNumber) {
            return song4;
        }
    }
    return null;
    }
//setting the song numbers 1 through 4 corresponding to the album position using 
public void setSong1(Song song) {
    this.song1 = song;
    }
public void setSong2(Song song) {
    this.song2 = song;
    }
public void setSong3(Song song) {
    this.song3 = song;
    }
  public void setSong4(Song song) {
    this.song4 = song;
    }
//initialsing a variable for album time to use for the album duration method and removing songs method
public void setAlbumTime(int time) {
    this.albumTime = time;
    }
    
    

}
    

    