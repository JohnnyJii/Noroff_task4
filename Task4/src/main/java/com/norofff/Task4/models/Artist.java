package com.norofff.Task4.models;

public class Artist {
    private String ArtistId;
    private String Name;

    public Artist() {

    }

    public Artist(String artistId, String name) {
        ArtistId = artistId;
        Name = name;
    }

    public String getArtistId() {
        return ArtistId;
    }

    public void setArtistId(String artistId) {
        ArtistId = artistId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
