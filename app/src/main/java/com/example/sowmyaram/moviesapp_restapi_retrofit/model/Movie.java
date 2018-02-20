package com.example.sowmyaram.moviesapp_restapi_retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sowmyaram on 11/9/2017.
 */

public class Movie {

    //this are all sub parameters

    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("genre_ids")
    private List<Integer> genre_ids = new ArrayList<Integer>();
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("vote_count")
    private Integer vote_count;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private Double vote_average;


    public Movie(String poster_path, boolean adult, String overview, String release_date, List<Integer> genre_ids, Integer id, String original_title,
                 String original_language, String title, String backdrop_path, Double popularity, Integer vote_count, boolean video, Double vote_average) {

        this.poster_path = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;

        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;

    }

    String baseimageURl = "https://image.tmdb.org/t/p/w500";

    public String getposterpath() {
        return "https://image.tmdb.org/t/p/w500" + poster_path;
    }

    public void setposterpath(String poster_path) {
        this.poster_path = poster_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;

    }
    public String getOverview() {
        return overview;
    }

    public void setOverviewt(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<Integer> getgenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public Integer getid() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }


    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }


    public String gettitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

public Double getPopularity(){
    return popularity;
}
public void setPopularity(Double popularity){
    this.popularity=popularity;
}


    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }


    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;

    }


    public Double getVote_average(){
        return vote_average;
    }
    public void setVote_average(Double vote_average){
        this.vote_average=vote_average;
    }




}
