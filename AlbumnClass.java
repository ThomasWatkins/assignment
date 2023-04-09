/*Album Class
 *Author: Thomas Watkins
 *Student No: 3442737
 *Date Started: 27/3/23
 *Description: 
 * A Class for storing methods and information about the album object for the SongCollection Program
 */ 


public class AlbumClass {

    //initialising instance variables for the album object//
    private String albumName;
    private new song = song1;
    private new song = song2;
    private new song = song3;
    private new song = song4;
    private int albumTime;
    private int maxAlbumTime = 1200

//constructor Album to the empty string and empty interior data
    public Album()
    {
    albumName = "No information added yet";
    song1 = "No information yet";
    song2 = "No information yet";
    song3 = "No information yet";
    song4 = "No information yet";
    albumTime = "No information yet";
    maxAlbumTime = 1200
    }

//other methods
    //set an album name
    public void setAlbumName (String am)
    {
        albumName = am
    }
    
    //get an album name
    public String getAlbumName ()
    {
        return albumName 
    }
    //add song + error messages ---------------------------
    public void addSong(SongClass song) {
    // Check if the album already has four songs
    if (song1 != null && song2 != null && song3 != null && song4 != null) {
        System.out.println("Error: This album already has the maximum number of songs.");
        return;
    }

    // Check if adding the new song will exceed the 20-minute limit
    int totalDuration = 0;
    if (song1 != null) totalDuration += song1.getSongDuration();
    if (song2 != null) totalDuration += song2.getSongDuration();
    if (song3 != null) totalDuration += song3.getSongDuration();
    if (song4 != null) totalDuration += song4.getSongDuration();
    totalDuration += song.getSongDuration();

    if (totalDuration > 1200) {
        System.out.println("Error: The total duration of the album cannot exceed 20 minutes.");
        return;
    }

    // Add the song to the album
    if (song1 == null) song1 = song;
    else if (song2 == null) song2 = song;
    else if (song3 == null) song3 = song;
    else song4 = song;

    System.out.println("The song " + song.getSongName() + " has been added to the album " + albumName + ".");
}
//------------------------------------------------------------
    //print song list
    public void getSongList ()
    {
    System.out.println("Song List:");
    System.out.println(song1.getName());
    System.out.println(song2.getName());
    System.out.println(song3.getName());
    System.out.println(song4.getName());
    }
     // delete album
    public void deleteAlbum() 
    {
        albumName = "No information added yet";
        song1 = "No information yet";
        song2 = "No information yet";
        song3 = "No information yet";
        song4 = "No information yet";
        albumTime = 0;
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
    

    
}

    