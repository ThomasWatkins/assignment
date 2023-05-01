/*Album Class
 *Author: Thomas Watkins
 *Student No: 3442737
 *Date Started: 27/3/23
 *Description: 
 * A Class for storing methods and information about the album object for the SongCollection Program
 */
import java.util.Scanner;
public class SongCollectionMainUpdated {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SongCollectionClass songCollection = new SongCollectionClass(); // create a new SongCollectionClass instance
    boolean quit = false;
    
    while (!quit) { // loop main interface options until the user chooses to quit
        System.out.println("Enter the number corresponding to the action you want to perform:");
        System.out.println("1. Album management");
        System.out.println("2. Song management");
        System.out.println("3. Other Search options");
        System.out.println("4. Quit program");
        
        Scanner input = new Scanner(System.in);
        int mainChoice = input.nextInt();
        
        switch (mainChoice) {
            case 1: //enter album management section
            System.out.println("Album management menu:");
            System.out.println("1. Add album");
            System.out.println("2. Get album duration");
            System.out.println("3. Delete album");
            System.out.println("4. View all albums");
            System.out.println("5. Get album song list");
            System.out.println("6. Go back");
            int albumChoice = input.nextInt();
            switch (albumChoice) {
                case 1: // create a new album
                System.out.println("Enter the name of the album you wish to create:");
                String albumName = scanner.nextLine(); // read the name of the album
                if (songCollection.getAlbumByName(albumName) == null) { // check if album already exists
                    boolean success = songCollection.createAlbum(albumName); // attempt to create the album
                    if (success) {
                        System.out.println(albumName +" Created");
                    } else {
                        System.out.println("Max number of albums reached.");
                    }
                } else {
                    System.out.println("Album name already exists.");
                }
                break;                        
                case 2:
                // prompts user to enter the name of the album
                System.out.println("Enter the name of the album:");
                albumName = scanner.nextLine();
                
                // retrieves the album object using getAlbumByName method
                Album album2 = songCollection.getAlbumByName(albumName);
                
                // if album is not found, displays error message
                if (album2 == null) {
                    System.out.println("Could not get album duration. Album not found.");
                } else {
                    // retrieves the album duration and displays it
                    int albumDuration = album2.getAlbumDuration();
                    System.out.println("Album duration of " + albumName + " is " + albumDuration + " seconds.");
                }
                break;
                case 3: // delete album
                System.out.println("Enter the name of the album you wish to delete:");
                albumName = scanner.nextLine(); // read the name of the album
                boolean deletedalbum = songCollection.deleteAlbum(albumName); // attempt to delete the album
                if (deletedalbum) {
                    System.out.println(albumName + " deleted.");
                } else {
                    System.out.println("Album not found.");
                }
                break;
                case 4: //getting the album list
                String albumList = songCollection.getAlbumList();
                System.out.println(albumList);
                break;
                default:
                System.out.println("Invalid input");
                break;
                case 5:
                // prompts user to enter the name of the album
                System.out.println("Enter the name of the album:");
                albumName = scanner.nextLine();
                
                // retrieves the list of songs from the album using getSongList method
                String songList = songCollection.getSongList(albumName);
                
                // displays the album name and the list of songs in the album
                System.out.println("Songs in " + albumName + ":");
                System.out.println(songList);
                System.out.println("for more information on each song go to Song Management\n");
                
                break;
                case 6: //go back option, exiting the album management section
                break;
            }
            break;
            case 2: //enter song management section
            System.out.println("Song management menu:");
            System.out.println("1. Add song");
            System.out.println("2. get song details");
            System.out.println("3. Delete song");
            System.out.println("4. Go back");
            
            int songChoice = input.nextInt();
            switch (songChoice) {
                case 1: // add a new song to an album
                System.out.println("Enter the name of the album you wish to add a song to:");
                String albumName = scanner.nextLine(); // read the name of the album                    
                Album album = songCollection.getAlbumByName(albumName); // get the album with the given name
                if (album == null) { // if the album is not found
                    System.out.println("Could not add song to " + albumName + ". Album not found.");
                } else { // if the album is found
                    System.out.println("Enter the name of the song:");
                    String songName = scanner.nextLine(); // read the name of the song
                    System.out.println("Enter the name of the artist:");
                    String artistName = scanner.nextLine(); // read the name of the artist
                    System.out.println("Enter the genre from:");
                    System.out.println("1) rock");
                    System.out.println("2) pop");
                    System.out.println("3) hip hop");
                    System.out.println("4) bossa nova");
                    String genreOption = scanner.nextLine(); // read the genre option
                    String songGenre;
                    switch (genreOption) { // map the genre option to a string value
                        case "1":
                        songGenre = "rock";
                        break;
                        case "2":
                        songGenre = "pop";
                        break;
                        case "3":
                        songGenre = "hip hop";
                        break;
                        case "4":
                        songGenre = "bossa nova";
                        break;
                        default:
                        songGenre = "no genre added";
                        break;
                    }
                    System.out.println("Enter the duration of the song in seconds:");
                    int songDuration = scanner.nextInt(); // read the duration of the song
                    scanner.nextLine(); // consume the newline character
                    
                    // check if adding the song would exceed the time limit of the album
                    int albumDuration = album.getAlbumDuration(); // get the current duration of the album
                    if (albumDuration + songDuration > 1200) { // if adding the song would exceed the time limit
                        System.out.println("Could not add song to " + albumName + ". Album duration would exceed the timelimit of 20 minutes (1200 seconds).");
                    } else {
                        Song song = new Song(songName, artistName, songDuration, songGenre);
                        album.addSong(song);
                        albumDuration = album.getAlbumDuration(); // update album duration
                    }
                }
                break;
                case 2: //getting the song details of a specific song
                System.out.println("Enter the name of the album containing your song:");
                albumName = scanner.nextLine();
                album = songCollection.getAlbumByName(albumName);
                if (album == null) { //checking if the album exists
                    System.out.println("Album not found.");
                    break;
                }
                System.out.println("Enter the name of the song:");
                String songName = scanner.nextLine();
                Song song = album.getSongByName(songName);
                if (song == null) { //checking if the song exists
                    System.out.println("Song not found.");
                    break;
                }
                //if song withing album exist, print all details
                System.out.println("Song name: " + songName);
                System.out.println("Artist: " + song.getSongArtist());
                System.out.println("Genre: " + song.getSongGenre());
                System.out.println("Duration: " + song.getSongDuration() + " seconds");
                break;
                case 3: // delete a song from an album
                System.out.println("Enter the name of the album you wish to delete a song from:");
                String albumNameToDeleteFrom = scanner.nextLine(); // input the name of the album
                if (albumNameToDeleteFrom == null) {
                    System.out.println("Album not found.");
                    break;
                }
                System.out.println("Enter the name of the song you wish to delete:");
                String songNameToDelete = scanner.nextLine(); // input the name of the song
                songCollection.deleteSong(albumNameToDeleteFrom, songNameToDelete);
                break;
                case 4:
                break;
                default:
                System.out.println("Invalid input");
                break;
                
            }
            break;
            case 3: //search management selection menu
            System.out.println("Search management menu:");
            System.out.println("1. get songs under certain duration");   
            System.out.println("2. view songs of a specific genre");
            System.out.println("3. Go back");   
            
            int searchChoice = input.nextInt();
            switch (searchChoice) {
                case 1: //getting songs under certain duration by using getSongsByDuration method
                System.out.print("Enter the maximum duration (in seconds) of the songs you want to print: ");
                int maxDuration = scanner.nextInt();
                String songsByDuration = songCollection.getSongsByDuration(maxDuration);
                System.out.print("Songs under this duration are: ");
                System.out.println(songsByDuration);
                break;
                case 2: // print all songs of a specific genre
                boolean validGenre = false;
                String genre = "";
                while (!validGenre) { //loops until one of the four genres is input, ignoring capitalisation
                    System.out.println("Enter the genre of songs you want to print (rock, pop, hip hop, or bossa nova):");
                    genre = scanner.nextLine().toLowerCase();
                    if (genre.equalsIgnoreCase("rock") || genre.equalsIgnoreCase("pop") || genre.equalsIgnoreCase("hip hop") || genre.equalsIgnoreCase("bossa nova")) {
                        validGenre = true; //valid input achieved
                    } else {
                        System.out.println("Invalid genre. Please enter a valid genre."); //if invalid input
                    }
                }
                songCollection.printSongsByGenre(genre);
                break;
                case 3: //go back option
                break;
                default:
                System.out.println("Invalid input");
                break;
            }
            break;
            case 4: //exit the system by breaking the main program loop
            quit = true;
            System.out.println("Goodbye!");
            break;
            default:
            System.out.println("Invalid input");
            break;
        }
    }
}
}        
