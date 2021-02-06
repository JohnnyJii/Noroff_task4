package com.norofff.Task4.controllers;

import com.norofff.Task4.data_access.SearchRepository;
import com.norofff.Task4.models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SearchViewController {
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearch(Search search, Model model) {
        model.addAttribute("query", search.getQuery());
        model.addAttribute("results", SearchRepository.getTrackByName());
        return String.valueOf(search);
    }
}



