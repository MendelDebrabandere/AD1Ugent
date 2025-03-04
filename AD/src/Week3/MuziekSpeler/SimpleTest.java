package Week3.MuziekSpeler;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;


@SuppressWarnings("DuplicatedCode")
public class SimpleTest {

    private MusicPlayer player;
    private List<Song> songs;

    @Before
    public void init() {
        player = new MyMusicPlayer();
        songs = Arrays.asList(
                new Song("Kapitan Korsakov - In the Shade of the Sun", 8*60 + 50),
                new Song("Mogwai - Take Me Somewhere Nice", 6*60 + 57),
                new Song("Sigur Rós - Fljótavík", 3*60 + 49),
                new Song("The Books - Smells Like Content", 3*60 + 42),
                new Song("Cage The Elephant - Ain't No Rest For The Wicked", 2*60 + 55),
                new Song("The Heavy - Short Change Hero", 5*60 + 22),
                new Song("Darren Korb - The Pantheon (Ain't Gonna Catch You)", 2*60 + 27),
                new Song("Hidden Orchestra - Overture", 6*60 + 17),
                new Song("Sufjan Stevens - Casimir Pulaski Day", 5*60 + 53),
                new Song("Yo La Tengo - Green Arrow", 5*60 + 43),
                new Song("Mogwai - Coolverine", 6*60 + 16),
                new Song("Mogwai - Party In the Dark", 4*60 + 2),
                new Song("65daysofstatic - Radio Protector", 5*60 + 28),
                new Song("Moby - Porcelain", 3*60 + 58),
                new Song("Mogwai - Summer", 3*60 + 28),
                new Song("Nils Frahm - Says", 8*60 + 18),
                new Song("Magma Waves - Scrt", 7*60 + 3),
                new Song("Mogwai - Rano Pano", 5*60 + 14),
                new Song("Radical Face - Family Portrait", 4*60 + 40),
                new Song("Godspeed You! Black Emperor - Moya", 10*60 + 51),
                new Song("They Dream By Day - Birdsong", 4*60 + 16),
                new Song("Explosions In The Sky - Your Hand in Mine", 8*60 + 17),
                new Song("The Antlers - Shiva", 3*60 + 45)
        );
    }

    @Test
    public void testAddSongs() {
        assertEquals(10, player.addSongs(songs.subList(0, 10)));
        assertEquals(5, player.addSongs(songs.subList(5, 15)));
    }

    @Test
    public void testQueueLast() {
        assertEquals(5, player.addSongs(songs.subList(0, 5)));

        Song s1 = songs.get(1);
        Song s2 = songs.get(2);
        Song s3 = songs.get(10);

        assertTrue(player.queueLast(s1.getName()));
        assertTrue(player.queueLast(s2.getName()));
        assertFalse(player.queueLast(s3.getName()));

        assertEquals(s1, player.playNext());
        assertEquals(s2, player.playNext());
        assertNull(player.playNext());

        assertEquals(s1.getDuration() + s2.getDuration(), player.timePlayed());

        assertTrue(player.hasPlayed(s1.getName()));
        assertTrue(player.hasPlayed(s2.getName()));
        assertFalse(player.hasPlayed(s3.getName()));
    }

    @Test
    public void testQueueNext() {
        assertEquals(5, player.addSongs(songs.subList(5, 10)));
        Song s1 = songs.get(6);
        Song s2 = songs.get(8);
        Song s3 = songs.get(15);
        assertTrue(player.queueNext(s1.getName()));
        assertTrue(player.queueNext(s2.getName()));
        assertFalse(player.queueNext(s3.getName()));

        assertEquals(s2, player.playNext());
        assertEquals(s1, player.playNext());
        assertNull(player.playNext());
    }

    @Test
    public void testQueueNextAndLast() {
        assertEquals(10, player.addSongs(songs.subList(0, 10)));
        Song s1 = songs.get(1);
        Song s2 = songs.get(2);
        Song s3 = songs.get(3);
        Song s4 = songs.get(4);

        assertTrue(player.queueNext(s1.getName()));
        assertTrue(player.queueLast(s2.getName()));
        assertTrue(player.queueNext(s3.getName()));
        assertTrue(player.queueLast(s4.getName()));

        assertEquals(s3, player.playNext());
        assertEquals(s1, player.playNext());
        assertEquals(s2, player.playNext());
        assertEquals(s4, player.playNext());
        assertNull(player.playNext());
    }

    @Test
    public void testPlayTime() {
        assertEquals(5, player.addSongs(songs.subList(0, 5)));
        Song s1 = songs.get(1);
        Song s2 = songs.get(2);
        Song s3 = songs.get(3);
        Song s4 = songs.get(4);

        player.queueNext(s1.getName());
        player.queueNext(s2.getName());
        player.queueNext(s3.getName());
        player.queueNext(s1.getName());
        player.queueNext(s4.getName());

        player.playNext();
        player.playNext();
        player.playNext();
        player.playNext();
        player.playNext();

        assertEquals(2*s1.getDuration() + s2.getDuration() + s3.getDuration() + s4.getDuration(), player.timePlayed());
    }

    @Test
    public void testHasPlayed() {
        assertEquals(10, player.addSongs(songs.subList(0, 10)));
        Song s1 = songs.get(1);
        Song s2 = songs.get(3);
        Song s3 = songs.get(5);
        Song s4 = songs.get(7);

        player.queueLast(s1.getName());
        player.queueLast(s2.getName());
        player.queueLast(s3.getName());
        player.queueLast(s4.getName());

        assertFalse(player.hasPlayed(s1.getName()));
        assertFalse(player.hasPlayed(s2.getName()));
        assertFalse(player.hasPlayed(s3.getName()));
        assertFalse(player.hasPlayed(s4.getName()));

        player.playNext();
        player.playNext();

        assertTrue(player.hasPlayed(s1.getName()));
        assertTrue(player.hasPlayed(s2.getName()));
        assertFalse(player.hasPlayed(s3.getName()));
        assertFalse(player.hasPlayed(s4.getName()));

        player.playNext();
        player.playNext();

        assertTrue(player.hasPlayed(s1.getName()));
        assertTrue(player.hasPlayed(s2.getName()));
        assertTrue(player.hasPlayed(s3.getName()));
        assertTrue(player.hasPlayed(s4.getName()));
    }
}
