package com.norofff.Task4.data_access;

import com.norofff.Task4.models.SearchResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchRepository {
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public SearchResult getTrackByName(String name) {
        SearchResult searchResult = new SearchResult();
        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "SELECT " +
                            "Track.Name as track, " +
                            "Artist.name as artist, " +
                            "Album.Title as album, " +
                            "Genre.name as genre " +
                                    "from Track join Album on Track.AlbumId = Album.AlbumId " +
                                    "join Artist on Artist.ArtistId = Album.ArtistId " +
                                    "join Genre on Genre.GenreId = Track.GenreId = Genre.GenreId " +
                                    "WHERE UPPER(Track.Name) LIKE UPPER(?)");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                searchResult = new SearchResult(
                                resultSet.getString("track"),
                                resultSet.getString("artist"),
                                resultSet.getString("album"),
                                resultSet.getString("genre")
                        );
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return searchResult;

    }
}
