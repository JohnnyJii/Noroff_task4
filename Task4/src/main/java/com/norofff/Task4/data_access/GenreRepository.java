package com.norofff.Task4.data_access;

import com.norofff.Task4.models.Genre;
import com.norofff.Task4.models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GenreRepository {
    //Get connection
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    // Get all tracks
    public ArrayList<Genre> getAllGenres() {
        ArrayList<Genre> genres = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT " +
                            "GenreId, " +
                            "Name " +
                            "FROM Genre");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                genres.add(
                        new Genre(
                                resultSet.getString("GenreId"),
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
        return genres;
    }
}
