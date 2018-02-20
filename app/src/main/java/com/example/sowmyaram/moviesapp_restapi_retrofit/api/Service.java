package com.example.sowmyaram.moviesapp_restapi_retrofit.api;



import com.example.sowmyaram.moviesapp_restapi_retrofit.model.MoviesResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sowmyaram on 11/9/2017.
 */

public interface Service {

    @GET("movie/top_rated?api_key=f47dd4de64c6ef630c2b0d50a087cc33")
 //Call<MoviesResponse> getPopularMovies ();
Call<MoviesResponse> getPopularMoives();



    @GET("movies/toprated")
    Call<MoviesResponse> getTopaRatedarMovies(@Query("f47dd4de64c6ef630c2b0d50a087cc35") String apiKey) ;


}
