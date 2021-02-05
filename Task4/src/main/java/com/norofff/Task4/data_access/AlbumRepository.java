package com.norofff.Task4.data_access;

import com.norofff.Task4.models.Album;
import com.norofff.Task4.models.Genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlbumRepository {
    //Get connection
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    // Get all tracks
    public ArrayList<Album> getAllAlbums() {
        ArrayList<Album> albums = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT " +
                            "AlbumId, " +
                            "Title " +
                            "FROM Album");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                albums.add(
                        new Album(
                                resultSet.getString("AlbumId"),
                                resultSet.getString("Title")
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
        return albums;
    }
}
