package Datastructuren.MuziekSpeler;

import java.util.Collection;

public interface MusicPlayer {
    /**
     * Add new songs to the music player library.
     * Each song name should be unique.
     *
     * @param songs a collection of songs to add to this library.
     * @return the number of new songs that were added, does not include songs
     * already present in the library.
     */
    int addSongs(Collection<Song> songs);

    /**
     * Search a song by name and add it as the next song in the playlist.
     *
     * @param songName the name of the song to add.
     * @return whether the song was found and added to the playlist.
     */
    boolean queueNext(String songName);

    /**
     * Search a song by name and add it as the last song in the playlist.
     *
     * @param songName the name of the song to add.
     * @return whether the song was found and added to the playlist.
     */
    boolean queueLast(String songName);

    /**
     * Play the next song in the playlist
     *
     * @return the next {@link Song} or <tt>null</tt> if the playlist is empty.
     */
    Song playNext();

    /**
     * Query whether a song has already been played by this playlist.
     *
     * @param songName the name of the song to query.
     * @return whether this song has been played by this music player.
     */
    boolean hasPlayed(String songName);

    /**
     * Query the total playtime of this music player.
     *
     * @return the sum of the duration of all played songs.
     */
    int timePlayed();
}
