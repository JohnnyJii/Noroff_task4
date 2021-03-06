package com.norofff.Task4.data_access;

import com.norofff.Task4.models.CustomerCountry;
import com.norofff.Task4.models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackRepository {
    public List<Track> getRandomTracks() {
        ArrayList<Track> allTracks = getAllTracks();
        Collections.shuffle(allTracks);
        return allTracks.subList(0, 5);
    }

    //Get connection
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    // Get all tracks
    public ArrayList<Track> getAllTracks() {
        ArrayList<Track> tracks = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT " +
                            "TrackId, " +
                            "Name " +
                            "FROM Track");
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
