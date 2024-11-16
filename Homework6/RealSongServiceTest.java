package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class RealSongServiceTest {

    private RealSongService realSongService;

    @BeforeEach
    public void setUp() {
        realSongService = new RealSongService();
    }

    @Test
    public void testDefaultConstructorAndGetSongDatabase() {
        assertNotNull(realSongService);
        assertEquals(6, realSongService.searchByAlbum("A Night at the Opera").size() + realSongService.searchByAlbum("Led Zeppelin IV").size() +
                realSongService.searchByAlbum("Hotel California").size() + realSongService.searchByAlbum("Imagine").size() +
                realSongService.searchByAlbum("Thriller").size() + realSongService.searchByAlbum("Highway 61 Revisited").size());
    }

    @Test
    public void testParameterizedConstructorAndGetSongDatabase() {
        Map<Integer, Song> songDatabase = new HashMap<>();
        songDatabase.put(1, new Song("Test Song", "Test Artist", "Test Album", 300));
        RealSongService customService = new RealSongService(songDatabase);

        assertNotNull(customService);
        assertEquals(1, customService.searchByAlbum("Test Album").size());
        assertEquals("Test Song", customService.searchByID(1).getTitle());
    }

    @Test
    public void testSearchByID() {
        Song song = realSongService.searchByID(1);
        assertNotNull(song);
        assertEquals("Bohemian Rhapsody", song.getTitle());

        assertNull(realSongService.searchByID(100));  // Test for non-existent ID
    }

    @Test
    public void testSearchByTitle() {
        List<Song> songs = realSongService.seachByTitle("Hotel California");
        assertEquals(1, songs.size());
        assertEquals("Hotel California", songs.get(0).getTitle());

        songs = realSongService.seachByTitle("Nonexistent Title");
        assertTrue(songs.isEmpty());  // Test for non-existent title
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> songs = realSongService.searchByAlbum("Imagine");
        assertEquals(1, songs.size());
        assertEquals("Imagine", songs.get(0).getTitle());

        songs = realSongService.searchByAlbum("Nonexistent Album");
        assertTrue(songs.isEmpty());  // Test for non-existent album
    }

    @Test
    public void testToString() {
        String expected = "RealSongService{songDatabase={1=Song{title='Bohemian Rhapsody', artist='Queen', album='A Night at the Opera', duration=354}, 2=Song{title='Stairway to Heaven', artist='Led Zeppelin', album='Led Zeppelin IV', duration=482}, 3=Song{title='Hotel California', artist='Eagles', album='Hotel California', duration=391}, 4=Song{title='Imagine', artist='John Lennon', album='Imagine', duration=183}, 5=Song{title='Billie Jean', artist='Michael Jackson', album='Thriller', duration=294}, 6=Song{title='Like a Rolling Stone', artist='Bob Dylan', album='Highway 61 Revisited', duration=369}}}";
        assertEquals(expected, realSongService.toString());
    }
}
