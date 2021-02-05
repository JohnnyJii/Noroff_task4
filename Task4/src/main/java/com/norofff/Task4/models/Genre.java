package com.norofff.Task4.models;

public class Genre {
    private String GenreId;
    private String Name;

    public Genre() {
    }

    public Genre(String genreId, String name) {
        this.GenreId = genreId;
        this.Name = name;
    }
    public String getGenreId() {
        return GenreId;
    }

    public void setGenreId(String genreId) {
        GenreId = genreId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
