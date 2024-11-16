package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealSongService implements SongService {
    private Map<Integer, Song> songDatabase;

    public RealSongService() {
        this.songDatabase = new HashMap<>();
        // Populate the database with some example songs
        songDatabase.put(1, new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354));
        songDatabase.put(2, new Song("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 482));
        songDatabase.put(3, new Song("Hotel California", "Eagles", "Hotel California", 391));
        songDatabase.put(4, new Song("Imagine", "John Lennon", "Imagine", 183));
        songDatabase.put(5, new Song("Billie Jean", "Michael Jackson", "Thriller", 294));
        songDatabase.put(6, new Song("Like a Rolling Stone", "Bob Dylan", "Highway 61 Revisited", 369));

    }

    @Override
    public Song searchByID(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        // Simulate fetching from server
        return songDatabase.get(songID);
    }

    @Override
    public List<Song> seachByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> result = new ArrayList<>();
        // Simulate fetching from server
        for (Song song : songDatabase.values()) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "RealSongService{" +
                "songDatabase=" + songDatabase +
                '}';
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> result = new ArrayList<>();
        // Simulate fetching from server
        for (Song song : songDatabase.values()) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                result.add(song);
            }
        }
        return result;
    }
}