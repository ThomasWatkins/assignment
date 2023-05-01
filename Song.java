/*Song Class
 *Author: Thomas Watkins
 *Student No: 3442737
 *Date Started: 1/4/23
 *Description: 
 * A Class for storing methods and information about the song object for the SongCollection Program
 */ 

 public class Song {

    //initialising instance variables for the Song object//
        private String songName;
        private String songArtist;
        private int songDuration;
        private String songGenre;
    
    //constructor Album to the empty string and empty interior data
        public Song(String songName, String songArtist, int songDuration, String songGenre)
        {
        this.songName = songName;
        this.songArtist = songArtist;
        this.songDuration = songDuration;
        this.songGenre = songGenre;
        }
    
    
//METHODS 
//set a song name
public void setSongName (String sn)
    {
    songName = sn;
    }
//return song name
public String getSongName ()
    {
    return songName;
    }
//set song artist
public void setSongArtist (String sa)
    {
    songArtist = sa;
    }
//return song artist
public String getSongArtist ()
    {
    return songArtist;
    }
//set song duration IN SECONDS
public void setSongDuration (int sd)
    {   
    songDuration = sd;
    }
//return song duration
public int getSongDuration ()
    {
    return songDuration;
    }
//set genre ignoring case by checking the input and the options provided
public void setGenre(String g) 
    {
    String genre;
        if (g.equalsIgnoreCase("rock")) {
        genre = "rock";
        }
        else if (g.equalsIgnoreCase("pop")) {
        genre = "pop";
        }
        else if (g.equalsIgnoreCase("hip-hop")) {
        genre = "hip-hop";
        }
        else if (g.equalsIgnoreCase("bossa nova")) {
        genre = "bossa nova";
        }
        else {
        genre = "invalid input";
    }
    songGenre = genre;
    }
//get the song genre
public String getSongGenre()
    {
        return songGenre;
    }    
//print the song details by using all other methods
public String getSongDetails() {
            return "Name: " + getSongName() + "\nArtist: " + getSongArtist() + "\nDuration: " + getSongDuration() + " seconds\nGenre: " + getSongGenre();
        }
    }