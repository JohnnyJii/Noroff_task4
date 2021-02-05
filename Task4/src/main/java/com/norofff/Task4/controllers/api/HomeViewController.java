package com.norofff.Task4.controllers.api;

import com.norofff.Task4.data_access.ArtistRepository;
import com.norofff.Task4.data_access.GenreRepository;
import com.norofff.Task4.data_access.SearchRepository;
import com.norofff.Task4.data_access.TrackRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {
    public ArtistRepository artistRepository = new ArtistRepository();
    public TrackRepository trackRepository = new TrackRepository();
    public GenreRepository genreRepository = new GenreRepository();
    public SearchRepository searchRepository = new SearchRepository();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("artists", artistRepository.getRandomArtists());
        model.addAttribute("tracks", trackRepository.getRandomTracks());
        model.addAttribute("genres", genreRepository.getRandomGenres());
        return "home";
    }



}
