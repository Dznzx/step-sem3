/*
 * Category C Assignment - Problem 2: The Playlist
 * Songs are stored in a private array; getSongs() hands back a copy so
 * external edits never touch the playlist's real contents.
 */
import java.util.Arrays;

public class Homework2_ThePlaylist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println(p.getSongCount());
    }
}

class Playlist {
    private final String[] songs;
    private int songCount;

    Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    void addSong(String title) {
        if (songCount >= songs.length) {
            return;
        }
        songs[songCount] = title;
        songCount++;
    }

    String[] getSongs() {
        String[] copy = new String[songCount];
        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    int getSongCount() {
        return songCount;
    }
}
