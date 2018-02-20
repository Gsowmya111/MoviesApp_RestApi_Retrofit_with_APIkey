package com.example.sowmyaram.moviesapp_restapi_retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sowmyaram on 11/9/2017.
 */

public class MoviesResponse {

    //this is main parameters 4


    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("total_results")
    private int totalresults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getpage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }


    public List<Movie> getMovies(){
        return results;
    }
    public void setMovies(List<Movie> results) {
        this.results = results;
    }

    public int getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(int totalresults) {
        this.totalresults = totalresults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
