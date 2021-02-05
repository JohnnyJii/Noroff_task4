package com.norofff.Task4.controllers;

import com.norofff.Task4.data_access.ArtistRepository;
import com.norofff.Task4.models.Artist;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ArtistController {
    private ArtistRepository artistRepository = new ArtistRepository();

    //Get all tracks
    @RequestMapping(value = "/main/Artist", method = RequestMethod.GET)
    public ArrayList<Artist> getAllArtists() {
        ArrayList<Artist> artists = artistRepository.getAllArtists();
        return artists;
    }
}