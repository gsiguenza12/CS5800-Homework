package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class SongServiceProxyTest {

    private SongServiceProxy songServiceProxy;
    private RealSongService realSongService;
    private Song testSong1;
    private Song testSong2;
    private List<Song> testSongs;

    @BeforeEach
    public void setUp() {
        realSongService = new RealSongService();
        songServiceProxy = new SongServiceProxy(realSongService);

        testSong1 = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);
        testSong2 = new Song("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 482);
        testSongs = new ArrayList<>();
        testSongs.add(testSong1);
        testSongs.add(testSong2);
    }

    @Test
    public void testConstructor() {
        assertNotNull(songServiceProxy);
    }

    @Test
    public void testSearchByID() {
        // Test fetching from real service
        Song song = songServiceProxy.searchByID(1);
        assertEquals("Bohemian Rhapsody", song.getTitle());

        // Test fetching from cache
        Song cachedSong = songServiceProxy.searchByID(1);
        assertEquals("Bohemian Rhapsody", cachedSong.getTitle());

        // Test non-existent ID
        assertNull(songServiceProxy.searchByID(100));
    }

    @Test
    public void testSearchByTitle() {
        // Test fetching from real service
        List<Song> songs = songServiceProxy.seachByTitle("Bohemian Rhapsody");
        assertEquals(1, songs.size());
        assertEquals("Bohemian Rhapsody", songs.get(0).getTitle());

        // Test fetching from cache
        List<Song> cachedSongs = songServiceProxy.seachByTitle("Bohemian Rhapsody");
        assertEquals(1, cachedSongs.size());
        assertEquals("Bohemian Rhapsody", cachedSongs.get(0).getTitle());

        // Test non-existent title
        assertTrue(songServiceProxy.seachByTitle("Nonexistent Title").isEmpty());
    }

    @Test
    public void testSearchByAlbum() {
        // Test fetching from real service
        List<Song> songs = songServiceProxy.searchByAlbum("A Night at the Opera");
        assertEquals(1, songs.size());
        assertEquals("Bohemian Rhapsody", songs.get(0).getTitle());

        // Test fetching from cache
        List<Song> cachedSongs = songServiceProxy.searchByAlbum("A Night at the Opera");
        assertEquals(1, cachedSongs.size());
        assertEquals("Bohemian Rhapsody", cachedSongs.get(0).getTitle());

        // Test non-existent album
        assertTrue(songServiceProxy.searchByAlbum("Nonexistent Album").isEmpty());
    }

    @Test
    public void testToString() {
        String expected = "SongServiceProxy{songService=" + realSongService.toString() +
                ", cacheById={}, cacheByTitle={}, cacheByAlbum={}}";
        assertEquals(expected, songServiceProxy.toString());
    }
}
