import java.util.Scanner;

public class SongCollection {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Album album1 = null; // initialize album1 to null
    boolean quit = false;

    while (!quit) {
      System.out.println("Enter the number corresponding to the action you want to perform:");
      System.out.println("1. Create a new album");
      System.out.println("2. Add a new song to an album");
      System.out.println("3. Request the list of all songs from an album");
      System.out.println("4. Quit");

      int action = scanner.nextInt();

      switch (action) {
        case 1:
          System.out.println("Enter the name of the album:");
          String albumName = scanner.next();
          album1 = new Album(albumName);
          System.out.println("Album created: " + album1.getName());
          break;
        case 2:
          if (album1 == null) {
            System.out.println("No album created yet.");
            break;
          }
          System.out.println("Enter the name of the song:");
          String songName = scanner.next();
          System.out.println("Enter the name of the artist:");
          String artistName = scanner.next();
          System.out.println("Enter the duration of the song in seconds:");
          int songDuration = scanner.nextInt();
          Song song = new Song(songName, artistName, songDuration);
          boolean success = album1.addSong(song);
          if (success) {
            System.out.println("Song added to " + album1.getName() + ": " + song.getName());
          } else {
            System.out.println("Could not add song to " + album1.getName() + ".");
          }
          break;
        case 3:
          if (album1 == null) {
            System.out.println("No album created yet.");
            break;
          }
          String songList = album1.getSongList();
          System.out.println("Songs in " + album1.getName() + ":");
          System.out.println(songList);
          break;
        case 4:
          quit = true;
          System.out.println("Exiting the program.");
          break;
        default:
          System.out.println("Invalid input. Please enter a number from 1 to 4.");
          break;
      }
    }
    scanner.close();
  }
}
