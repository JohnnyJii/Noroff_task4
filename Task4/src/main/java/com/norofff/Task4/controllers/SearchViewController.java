package com.norofff.Task4.controllers;

import com.norofff.Task4.data_access.SearchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SearchViewController {
    public SearchRepository searchRepository = new SearchRepository();


    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("query", searchRepository.getTrackByName());
    }
}



