package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private SongService songService;
    private Map<Integer, Song> cacheById;
    private Map<String, List<Song>> cacheByTitle;
    private Map<String, List<Song>> cacheByAlbum;

    public SongServiceProxy(SongService songService) {
        this.songService = songService;
        this.cacheById = new HashMap<>();
        this.cacheByTitle = new HashMap<>();
        this.cacheByAlbum = new HashMap<>();
    }

    @Override
    public Song searchByID(Integer songID) {
        if (cacheById.containsKey(songID)) {
            return cacheById.get(songID);
        }
        Song song = songService.searchByID(songID);
        cacheById.put(songID, song);
        return song;
    }

    @Override
    public String toString() {
        return "SongServiceProxy{" +
                "songService=" + songService +
                ", cacheById=" + cacheById +
                ", cacheByTitle=" + cacheByTitle +
                ", cacheByAlbum=" + cacheByAlbum +
                '}';
    }

    @Override
    public List<Song> seachByTitle(String title) {
        if (cacheByTitle.containsKey(title)) {
            return cacheByTitle.get(title);
        }
        List<Song> songs = songService.seachByTitle(title);
        cacheByTitle.put(title, songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (cacheByAlbum.containsKey(album)) {
            return cacheByAlbum.get(album);
        }
        List<Song> songs = songService.searchByAlbum(album);
        cacheByAlbum.put(album, songs);
        return songs;
    }
}
