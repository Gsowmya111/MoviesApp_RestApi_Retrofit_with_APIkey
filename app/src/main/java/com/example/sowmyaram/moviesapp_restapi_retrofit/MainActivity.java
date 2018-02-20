package com.example.sowmyaram.moviesapp_restapi_retrofit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sowmyaram.moviesapp_restapi_retrofit.adapter.MoviesAdapter;
import com.example.sowmyaram.moviesapp_restapi_retrofit.api.Client;
import com.example.sowmyaram.moviesapp_restapi_retrofit.api.Service;
import com.example.sowmyaram.moviesapp_restapi_retrofit.model.Movie;
import com.example.sowmyaram.moviesapp_restapi_retrofit.model.MoviesResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private MoviesAdapter adapter;
    private List<Movie> movieList;
    ProgressDialog pg;
    SwipeRefreshLayout swipecontainer;
    public static final String LOG_TAG = MoviesAdapter.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        swipecontainer = (SwipeRefreshLayout) findViewById(R.id.main_content);
        swipecontainer.setColorSchemeColors(android.R.color.holo_orange_dark);
        swipecontainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViews();
                Toast.makeText(MainActivity.this, "Movies refreshed", Toast.LENGTH_LONG).show();
            }
        });
    }

    public Activity getActivity() {
        Context context = this;
        while (context instanceof ContextWrapper) {
            if (context instanceof ContextWrapper) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private void initViews() {

     /*   pg = new ProgressDialog(this);
        pg.setMessage("Fetching Movies........");
        pg.setCancelable(false);
        pg.show();*/
        recyclerview = (RecyclerView) findViewById(R.id.recycler_view);

        movieList = new ArrayList<>();
        adapter = new MoviesAdapter(this, movieList);
        if(getActivity().getResources().getConfiguration().orientation ==Configuration.ORIENTATION_PORTRAIT){
     //   if (getActivity.getResources.getConfiguration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerview.setLayoutManager(new GridLayoutManager(this, 4));
        }
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        loadJSON();
    }

    private void loadJSON1() {

        Service api = Client.getApiService();
      //  Call<MoviesResponse> call=api.getPopularMoives();
        retrofit2.Call<MoviesResponse> call = api.getPopularMoives();


        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(retrofit2.Call<MoviesResponse> call, Response<MoviesResponse> response) {
                //Dismiss Dialog
            //    dialog.dismiss();

                if(response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    List<Movie> movies = response.body().getResults();

                    /**
                     * Binding that List to Adapter
                     */
                    recyclerview.setAdapter(new MoviesAdapter(getApplicationContext(), movies));

                } else {
                     //Snackbar.make(, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<MoviesResponse> call, Throwable t) {
                //dialog.dismiss();
            }
        });


        // Snackbar.make(parentView, R.string.string_internet_connection_not_available, Snackbar.LENGTH_LONG).show();









    }

    private void loadJSON() {

        try {
            if (BuildConfig.THE_MOVIE_DB_API_TOKEN.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please first obtain Apikey from themoviesdborg", Toast.LENGTH_LONG).show();
                pg.dismiss();
                return;
            }
            Client client = new Client();
            Service api = client.getApiService();
           // Service apiservice = client.getClient().create(Service.class);
            //  call= apiservice.getPopularMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN);
            retrofit2.Call<MoviesResponse> call = (retrofit2.Call<MoviesResponse>) api.getPopularMoives();
            call.enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(retrofit2.Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    List<Movie> movies = response.body().getResults();
                    recyclerview.setAdapter(new MoviesAdapter(getApplicationContext(), movies));
                    recyclerview.smoothScrollToPosition(0);
                    if (swipecontainer.isRefreshing()) {
                        swipecontainer.setRefreshing(false);
                    }
                 //   pg.dismiss();
                }

                @Override
                public void onFailure(retrofit2.Call<MoviesResponse> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                    Toast.makeText(MainActivity.this, "Error Fetching data", Toast.LENGTH_LONG).show();

                }
            });
        }catch (Exception e){
            Log.d("Error",e.getMessage());
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.menu_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
