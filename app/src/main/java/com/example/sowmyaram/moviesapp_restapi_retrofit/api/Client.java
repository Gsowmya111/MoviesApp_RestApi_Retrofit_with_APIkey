package com.example.sowmyaram.moviesapp_restapi_retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sowmyaram on 11/9/2017.
 */

public class Client {

    //http://api.themoviedb.org/3/movie/top_rated?api_key=f47dd4de64c6ef630c2b0d50a087cc33-----full url should be divided as
    //"http://api.themoviedb.org/3/"----------1(client class)
    //"movie/top_rated?api_key=f47dd4de64c6ef630c2b0d50a087cc33"-----------2(Service class)

    public static final String BASEURL="http://api.themoviedb.org/3/";

    private static Retrofit getRetrofitInstance() {
       return new Retrofit.Builder()
               .baseUrl(BASEURL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
   }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static Service getApiService() {
        return getRetrofitInstance().create(Service.class);
    }
}