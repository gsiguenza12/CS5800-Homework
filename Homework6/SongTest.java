package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    public void testConstructorAndGetters() {
        Song song = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);

        assertEquals("Bohemian Rhapsody", song.getTitle());
        assertEquals("Queen", song.getArtist());
        assertEquals("A Night at the Opera", song.getAlbum());
        assertEquals(354, song.getDuration());
    }

    @Test
    public void testSetTitle() {
        Song song = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);
        song.setTitle("Stairway to Heaven");

        assertEquals("Stairway to Heaven", song.getTitle());
    }

    @Test
    public void testSetArtist() {
        Song song = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);
        song.setArtist("Led Zeppelin");

        assertEquals("Led Zeppelin", song.getArtist());
    }

    @Test
    public void testSetAlbum() {
        Song song = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);
        song.setAlbum("Led Zeppelin IV");

        assertEquals("Led Zeppelin IV", song.getAlbum());
    }

    @Test
    public void testSetDuration() {
        Song song = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);
        song.setDuration(482);

        assertEquals(482, song.getDuration());
    }

    @Test
    public void testToString() {
        Song song = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);

        String expected = "Song{title='Bohemian Rhapsody', artist='Queen', album='A Night at the Opera', duration=354}";
        assertEquals(expected, song.toString());
    }
}
