package com.norofff.Task4.data_access;

import com.norofff.Task4.models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchRepository {
    public List<Track> searchTrackByName() {
        ArrayList<Track> allTracks = getAllTracks();
        Collections.shuffle(allTracks);
        return allTracks.subList(1, 1000);
    }

    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Track> getAllTracks() {
        ArrayList<Track> tracks = new ArrayList<>();
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
                                    "WHERE UPPER(Track.Name) " +
                                    "LIKE UPPER(?)");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tracks.add(
                        new Track(
                                resultSet.getString("TrackId"),
                                resultSet.getString("Name")
                        ));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return tracks;

    }
}
