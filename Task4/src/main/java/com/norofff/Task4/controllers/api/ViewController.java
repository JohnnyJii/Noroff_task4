package com.norofff.Task4.controllers.api;

import com.norofff.Task4.data_access.ArtistRepository;
import com.norofff.Task4.data_access.GenreRepository;
import com.norofff.Task4.data_access.TrackRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    public ArtistRepository artistRepository = new ArtistRepository();
    public TrackRepository trackRepository = new TrackRepository();
    public GenreRepository genreRepository = new GenreRepository();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("artists", artistRepository.getRandomArtists());
        return "home";
    }



}
