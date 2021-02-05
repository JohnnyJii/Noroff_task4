package com.norofff.Task4.controllers;


import com.norofff.Task4.data_access.AlbumRepository;
import com.norofff.Task4.models.Album;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AlbumController {
    private AlbumRepository albumRepository = new AlbumRepository();

    @RequestMapping(value = "/main/Album", method = RequestMethod.GET)
    public ArrayList<Album> getAllAlbums() {
        ArrayList<Album> albums = albumRepository.getAllAlbums();
        return albums;
    }
}