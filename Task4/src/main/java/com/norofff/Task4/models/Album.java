package com.norofff.Task4.models;

public class Album {

    private String AlbumId;
    private String Title;

    public Album() {
    }

    public Album(String albumId, String title) {
        AlbumId = albumId;
        Title = title;
    }
    public String getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(String albumId) {
        AlbumId = albumId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
