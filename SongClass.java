/*Song Class
 *Author: Thomas Watkins
 *Student No: 3442737
 *Date Started: 1/4/23
 *Description: 
 * A Class for storing methods and information about the song object for the SongCollection Program
 */ 

public class SongClass {

//initialising instance variables for the Song object//
    private String songName;
    private String songArtist;
    private int songDuration;
    private String songGenre;

//constructor Album to the empty string and empty interior data
    public Song()
    {
        songName = "no name added";
        songArtist = "no artist added";
        songDuration = 0;
        songGenre = 0;
    }

//METHODS 
    //set a song name
    public void setSongName (String sn)
    {
        songName = sn 
    }
    //return song name
    public String getSongName ()
    {
        return songName
    }
    //set song artist
    public void setSongArtist (String sa)
    {
        songArtist = sa
    }
    //return song artist
    public String getSongArtist ()
    {
        return songArtist
    }
    //set song duration IN SECONDS
    public void setSongDuration (int sd)
    {
        songDuration = sd
    }
    //return song duration
    public String getSongDuration ()
    {
        return songDuration
    }
    //set song genre 
    public void setGenre (int i) {
    String genre;
    if (i == 1) {
        genre = "rock";
    }
    else if (i == 2) {
        genre = "pop";
    }
    else if (i == 3) {
        genre = "hip-hop";
    }
    else if (i == 4) {
        genre = "bossa nova";
    }
    else {
        genre = "invalid input";
    }
    songGenre = genre;
}

}