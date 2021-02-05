package com.norofff.Task4.controllers.api;

import com.norofff.Task4.data_access.SearchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SearchViewController {
    public SearchRepository searchRepository = new SearchRepository();


    @GetMapping("/search")
    public String index(Model model) {
        model.addAttribute("search", searchRepository.searchTrackByName());
        return "search";
    }
}
