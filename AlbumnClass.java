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

    //add a song
    public void addSong (int i, int addedSong)
    {
    if (i == 1) song1 = addedSong;
    else if (i == 2) song2 = addedSong;
    else if (i == 3) song3 = addedSong;
    else song4 = addedSong
    }

    //get song list
    public String getSongList ()
    {
        return song1
        return song2
        return song3
        return song4
    }
    
}

    