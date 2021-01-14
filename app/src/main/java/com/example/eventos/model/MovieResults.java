package com.example.eventos.model;

import java.util.List;

public class MovieResults {


    private Integer page;
    private Integer total_Results;
    private Integer total_Pages;
    private List<ResultsBean> resultsBeans;
    private String poster_path;
    private String title;
    private Integer id;
    private Integer vote_Count;

    public MovieResults(String poster_path, String title, Integer id, Integer vote_Count) {
        this.poster_path = poster_path;
        this.title = title;
        this.id = id;
        this.vote_Count = vote_Count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultsBean> getResults() {
        return resultsBeans;
    }

    public void setResults(List<ResultsBean> results) {
        this.resultsBeans = results;
    }

    public Integer getTotalResults() {
        return total_Results;
    }

    public void setTotalResults(Integer totalResults) {
        this.total_Results = totalResults;
    }

    public Integer getTotalPages() {
        return total_Pages;
    }

    public void setTotalPages(Integer totalPages) {
        this.total_Pages = totalPages;
    }

}
