package com.norofff.Task4.models;

public class Track {
    private String TrackId;
    private String Name;

    public Track() {
    }

    public Track (String trackId, String name) {
        this.TrackId = trackId;
        this.Name = name;
    }

    public String getTrackId() {
        return TrackId;
    }

    public void setTrackId(String trackId) {
        TrackId = trackId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
