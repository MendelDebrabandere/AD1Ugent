package Week3.MuziekSpeler;

import java.util.*;

public class MyMusicPlayer implements MusicPlayer{

    private HashMap<String, Song> library;
    private LinkedList<Song> playlist;
    private int playtime;
    private TreeSet<String> playedSongs;

    public MyMusicPlayer() {
        library = new HashMap<>();
        playlist = new LinkedList<Song>();
        playtime = 0;
        playedSongs = new TreeSet<>();
    }

    /**
     * Add new songs to the music player library.
     * Each song name should be unique.
     *
     * @param songs a collection of songs to add to this library.
     * @return the number of new songs that were added, does not include songs
     * already present in the library.
     */
    @Override
    public int addSongs(Collection<Song> songs) {
        int addedCounter = 0;
        for (Song song : songs) {
            if (!library.containsKey(song.getName())) {
                library.put(song.getName(), song);
                addedCounter++;
            }
        }
        return addedCounter;
    }

    /**
     * Search a song by name and add it as the next song in the playlist.
     *
     * @param songName the name of the song to add.
     * @return whether the song was found and added to the playlist.
     */
    @Override
    public boolean queueNext(String songName) {
        if (library.containsKey(songName)) {
            playlist.addFirst(library.get(songName));
            return true;
        }
        return false;
    }

    /**
     * Search a song by name and add it as the last song in the playlist.
     *
     * @param songName the name of the song to add.
     * @return whether the song was found and added to the playlist.
     */
    @Override
    public boolean queueLast(String songName) {
        if (library.containsKey(songName)) {
            playlist.add(library.get(songName));
            return true;
        }
        return false;
    }

    /**
     * Play the next song in the playlist
     *
     * @return the next {@link Song} or <tt>null</tt> if the playlist is empty.
     */
    @Override
    public Song playNext() {
        Song curr = playlist.pollFirst();
        if (curr != null) {
            playtime += curr.getDuration();
            playedSongs.add(curr.getName());
        }
        return curr;
    }

    /**
     * Query whether a song has already been played by this playlist.
     *
     * @param songName the name of the song to query.
     * @return whether this song has been played by this music player.
     */
    @Override
    public boolean hasPlayed(String songName) {
        return playedSongs.contains(songName);
    }

    /**
     * Query the total playtime of this music player.
     *
     * @return the sum of the duration of all played songs.
     */
    @Override
    public int timePlayed() {
        return playtime;
    }
}
