package com.norofff.Task4.models;

public class Search {
    private String search;

    public SearchResult getSearchResult() {
        return searchResult;
    }
    public Search() {
        this.searchResult = new SearchResult();
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    private SearchResult searchResult;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
