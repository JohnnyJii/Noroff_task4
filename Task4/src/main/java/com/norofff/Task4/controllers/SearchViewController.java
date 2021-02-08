package com.norofff.Task4.controllers;

import com.norofff.Task4.data_access.SearchRepository;
import com.norofff.Task4.models.Search;
import com.norofff.Task4.models.SearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SearchViewController {
    public SearchRepository searchRepository = new SearchRepository();


    @GetMapping("/search")
    public String index(Model model) {
        Search search = new Search();
        SearchResult searchResult= new SearchResult();
        search.setSearchResult(searchResult);
        model.addAttribute("searchResult", search);
        return "search";
    }
}



