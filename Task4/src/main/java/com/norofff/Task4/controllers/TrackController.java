package com.norofff.Task4.controllers;

import com.norofff.Task4.data_access.TrackRepository;
import com.norofff.Task4.models.Track;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TrackController {
    private TrackRepository trackRepository = new TrackRepository();

    //Get all tracks
    @RequestMapping(value = "/main/Track", method = RequestMethod.GET)
    public ArrayList<Track> getAllTracks() {
        ArrayList<Track> tracks = trackRepository.getAllTracks();
        return tracks;
    }
}
