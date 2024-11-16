package com.company;
import java.util.List;

public interface SongService {
    Song searchByID(Integer songID);
    List<Song> seachByTitle(String title);
    List<Song> searchByAlbum(String album);
}
