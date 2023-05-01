/*Song Class
 *Author: Thomas Watkins
 *Student No: 3442737
 *Date Started: 1/4/23
 *Description: 
 * A Class for storing methods and information about the task involved within the song collection program
 */ 

public class SongCollectionClass {
    private Album album1;
    private Album album2;
    private Album album3;

  //constructor method, creating 3 null album objects 
    public SongCollectionClass() {
      album1 = null;
      album2 = null;
      album3 = null;
    }
  //check which album is not null from 1 to 3 and create a new album from the first empty one, first setting the name then using 
  //the new Album function with the album name inputed and default values for the rest
    public boolean createAlbum(String albumName) {
      if (album1 != null && album1.getAlbumName().equals(albumName)) {
        return false;
      }
      if (album2 != null && album2.getAlbumName().equals(albumName)) {
        return false;
      }
      if (album3 != null && album3.getAlbumName().equals(albumName)) {
        return false;
      }
      
      if (album1 == null) {
        album1 = new Album(albumName, 0, 1200 );
        return true;
      } else if (album2 == null) {
        album2 = new Album(albumName, 0, 1200 );
        return true;
      } else if (album3 == null) {
        album3 = new Album(albumName, 0, 1200 );
        return true;
      } else {
        return false; // all 3 albums are already created
      }
    }
    
  //first check if album exists, if so, create new song object, then add to the album object corresponding to the name given
    public boolean addSongToAlbum(String albumName, String songName, String artistName, int songDuration, String genre) {
      Album album = getAlbumByName(albumName);
      if (album == null) {
          return false; // album not found
      }
      Song song = new Song(songName, artistName, songDuration, genre);
      album.addSong(song);
      return true;
  }
  
  //return song list of an album if album exists
    public String getSongList(String albumName) {
      Album album = getAlbumByName(albumName);
      if (album == null) {
        return "Album not found.";
      }
      return album.getSongList();
    }
  //collecting album 1-3 based off the name of the album input by the user, ignoring cases
    public Album getAlbumByName(String albumName) {
        if (album1 != null && album1.getAlbumName().equalsIgnoreCase(albumName)) {
          return album1;
        } else if (album2 != null && album2.getAlbumName().equalsIgnoreCase(albumName)) {
          return album2;
        } else if (album3 != null && album3.getAlbumName().equalsIgnoreCase(albumName)) {
          return album3;
        } else {
          return null;
        }
    }  
  //getting the album list based of which albums do exist
    public String getAlbumList() {
      String albumList = "";
      if (album1 != null) {
          albumList += album1.getAlbumName() + "\n";
      }
      if (album2 != null) {
          albumList += album2.getAlbumName() + "\n";
      }
      if (album3 != null) {
          albumList += album3.getAlbumName() + "\n";
      }
      if (albumList.equals("")) {
          return "No albums found.";
      } else {
          return "Album List:\n" + albumList;
      }
    
  }
  //getting the number of albums that exist, by checking each album object for if they are NOT null
    public int getNumAlbums() {
      int albumNum = 0;
      if (album1 != null) {
          albumNum++;
      }
      if (album2 != null) {
          albumNum++;
      }
      if (album3 != null) {
          albumNum++;
      }
      return albumNum;
  }
  //deleting a song by first getting the album its in, then using the removesong method, also giving appropriate error messages
    public void deleteSong(String albumName, String songName) {
      Album album = getAlbumByName(albumName);
      if (album != null) {
          Song song = album.getSongByName(songName);
          if (song != null) {
              album.removeSong(album, song);
              System.out.println("The Song \"" + songName + "\" removed from album \"" + albumName + "\"");
          } else {
              System.out.println("The Song \"" + songName + "\" not found in album \"" + albumName + "\"");
          }
      } else {
          System.out.println("Album \"" + albumName + "\" not found");
      }
    }
  //printing the songs of a input genre by checking each song from each album to see if the genre matches to the inputted genre
  //once song is found, the song is retrieved by getsong(num) then the song name is provided
    public void printSongsByGenre(String genre) {
      System.out.println("Songs of genre " + genre + ":");
      boolean foundSongs = false; // track whether any song of the given genre was found

  if (album1 != null) {
      if (album1.getSong1() != null && album1.getSong1().getSongGenre().equalsIgnoreCase(genre)) {
        foundSongs = true;
        System.out.println(album1.getAlbumName() + ":  " +album1.getSong1().getSongName());
      }
      if (album1.getSong2() != null && album1.getSong2().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album1.getAlbumName() + ":  " +album1.getSong2().getSongName());
        foundSongs = true;
      }
      if (album1.getSong3() != null && album1.getSong3().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album1.getAlbumName() + ":  " +album1.getSong3().getSongName());
        foundSongs = true;
      }
      if (album1.getSong4() != null && album1.getSong4().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album1.getAlbumName() + ":  " +album1.getSong4().getSongName());
        foundSongs = true;
      }
  }
  if (album2 != null) {
      if (album2.getSong1() != null && album2.getSong1().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album2.getAlbumName() + ":  " +album2.getSong1().getSongName());
        foundSongs = true;
      }
      if (album2.getSong2() != null && album2.getSong2().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album2.getAlbumName() + ":  " +album2.getSong2().getSongName());
        foundSongs = true;
      }
      if (album2.getSong3() != null && album2.getSong3().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album2.getAlbumName() + ":  " +album2.getSong3().getSongName());
        foundSongs = true;
      }
      if (album2.getSong4() != null && album2.getSong4().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album2.getAlbumName() + ":  " +album2.getSong4().getSongName());
        foundSongs = true;
      }
  }
  if (album3 != null) {
      if (album3.getSong1() != null && album3.getSong1().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album3.getAlbumName() + ":  " +album3.getSong1().getSongName());
        foundSongs = true;
      }
      if (album3.getSong2() != null && album3.getSong2().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album3.getAlbumName() + ":  " +album3.getSong2().getSongName());
        foundSongs = true;
      }
      if (album3.getSong3() != null && album3.getSong3().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album3.getAlbumName() + ":  " +album3.getSong3().getSongName());
        foundSongs = true;
      }
      if (album3.getSong4() != null && album3.getSong4().getSongGenre().equalsIgnoreCase(genre)) {
        System.out.println(album3.getAlbumName() + ":  " +album3.getSong4().getSongName());
        foundSongs = true;
      }
  }
  //no songs were found message
  if (!foundSongs) {
        System.out.println("No songs of genre " + genre + " were found.");
    
  }
}
  //same process as getting songs by genre but this time by the duration being less than or equal to the max duration provided
    public String getSongsByDuration(int maxDuration) {
      String result = "";
      if (album1 != null) {
          if (album1.getSong1() != null && album1.getSong1().getSongDuration() <= maxDuration) {
              result += album1.getSong1().getSongName() + ", ";
          }
          if (album1.getSong2() != null && album1.getSong2().getSongDuration() <= maxDuration) {
              result += album1.getSong2().getSongName() + ", ";
          }
          if (album1.getSong3() != null && album1.getSong3().getSongDuration() <= maxDuration) {
              result += album1.getSong3().getSongName() + ", ";
          }
          if (album1.getSong4() != null && album1.getSong4().getSongDuration() <= maxDuration) {
              result += album1.getSong4().getSongName() + ", ";
          }
      }
      if (album2 != null) {
          if (album2.getSong1() != null && album2.getSong1().getSongDuration() <= maxDuration) {
              result += album2.getSong1().getSongName() + ", ";
          }
          if (album2.getSong2() != null && album2.getSong2().getSongDuration() <= maxDuration) {
              result += album2.getSong2().getSongName() + ", ";
          }
          if (album2.getSong3() != null && album2.getSong3().getSongDuration() <= maxDuration) {
              result += album2.getSong3().getSongName() + ", ";
          }
          if (album2.getSong4() != null && album2.getSong4().getSongDuration() <= maxDuration) {
              result += album2.getSong4().getSongName() + ", ";
          }
      }
      if (album3 != null) {
          if (album3.getSong1() != null && album3.getSong1().getSongDuration() <= maxDuration) {
              result += album3.getSong1().getSongName() + ", ";
          }
          if (album3.getSong2() != null && album3.getSong2().getSongDuration() <= maxDuration) {
              result += album3.getSong2().getSongName() + ", ";
          }
          if (album3.getSong3() != null && album3.getSong3().getSongDuration() <= maxDuration) {
              result += album3.getSong3().getSongName() + ", ";
          }
          if (album3.getSong4() != null && album3.getSong4().getSongDuration() <= maxDuration) {
              result += album3.getSong4().getSongName() + ", ";
          }
      }
      //if no songs under this duration exist, appropriate message displayed
      if (result.equals("")) {
          result = "No songs found with duration less than or equal to " + maxDuration + " seconds.";
      } 
      
      return result;
    }
  //deleting an album by setting all objects held within an album object to null
    public boolean deleteAlbum(String albumName) {
      Album album = getAlbumByName(albumName);
      if (album != null) {
          album.setAlbumName(null);
          album.setSong1(null);
          album.setSong2(null);
          album.setSong3(null);
          album.setSong4(null);
          album.setAlbumTime(0);
          return true; // album successfully deleted
      } else {
          return false; // album not found
      }
    }
}
  