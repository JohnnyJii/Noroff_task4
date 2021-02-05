package com.norofff.Task4.data_access;

import com.norofff.Task4.models.Artist;
import com.norofff.Task4.models.Genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArtistRepository {
    //Get connection
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    // Get all tracks
    public ArrayList<Artist> getAllArtists() {
        ArrayList<Artist> artists = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT " +
                            "ArtistId, " +
                            "Name " +
                            "FROM Genre");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                artists.add(
                        new Artist(
                                resultSet.getString("ArtistId"),
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
        return artists;
    }
}
