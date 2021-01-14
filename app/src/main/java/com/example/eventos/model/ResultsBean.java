package com.example.eventos.model;

import java.util.List;

public  class ResultsBean {

    private String poster_path;
    private Boolean adult;
    private String overview;
    private String release_Date;
    private List<Integer> genre_Ids = null;
    private Integer id;
    private String original_Title;
    private String original_Language;
    private String title;
    private String backdrop_Path;
    private Double popularity;
    private Integer vote_Count;
    private Boolean video;
    private List<MovieResults> movieResults;
    private String voteAverage;

    public ResultsBean() {

        this.poster_path = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.release_Date = release_Date;
        this.genre_Ids = genre_Ids;
        this.id = id;
        this.original_Title = original_Title;
        this.original_Language = original_Language;
        this.title = title;
        this.backdrop_Path = backdrop_Path;
        this.popularity = popularity;
        this.vote_Count = vote_Count;
        this.video = video;
        this.movieResults = movieResults;

    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public List<MovieResults> getMovieResults() {
        return movieResults;
    }

    public void setMovieResults(List<MovieResults> movieResults) {
        this.movieResults = movieResults;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return release_Date;
    }

    public void setReleaseDate(String releaseDate) {
        this.release_Date = releaseDate;
    }

    public List<Integer> getGenreIds() {
        return genre_Ids;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genre_Ids = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return original_Title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.original_Title = originalTitle;
    }

    public String getOriginalLanguage() {
        return original_Language;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.original_Language = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdrop_Path;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdrop_Path = backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return vote_Count;
    }

    public void setVoteCount(Integer voteCount) {
        this.vote_Count = voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }
}
