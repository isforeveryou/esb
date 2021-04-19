package com.forever.provider.db;

import com.forever.provider.dto.Artist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WJX
 * @date 2021/4/15 11:24
 */
public class ArtistTable {

    private static volatile ArtistTable ARTIST_TABLE;

    private boolean writeStatus = false;

    private Map<Integer, Artist> artistTable = new HashMap<>();

    private ArtistTable() {}

    public static ArtistTable getInstance() {
        if (ARTIST_TABLE == null) {
            synchronized (ArtistTable.class) {
                if (ARTIST_TABLE == null) {
                    ARTIST_TABLE = new ArtistTable();
                }
            }
        }
        return ARTIST_TABLE;
    }

    boolean getWriteStatus() {
        return writeStatus;
    }

    void setWriteStatus(boolean status) {
        this.writeStatus = status;
    }

    void setArtistTable(Map<Integer, Artist> artistMap) {
        artistTable = artistMap;
    }

    Map<Integer, Artist> getArtistTable() {
        return artistTable;
    }

    public Artist selectArtist(Integer key) {
        return artistTable.get(key);
    }

    public void insertArtist(Integer key, Artist artist) {
        setWriteStatus(true);
        artistTable.put(key, artist);
    }

    public Integer insertArtist(Artist artist) {
        setWriteStatus(true);
        int size = artistTable.size();
        artistTable.put(size + 1, artist);
        return size + 1;
    }
}
