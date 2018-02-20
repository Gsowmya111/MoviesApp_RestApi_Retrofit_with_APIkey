package com.example.sowmyaram.moviesapp_restapi_retrofit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

/**
 * Created by sowmyaram on 11/9/2017.
 */

public class DetailActivity extends AppCompatActivity {
    TextView nameofmovie, plotsynopsis, userrating, releaseDate;
    ImageView imageview;
    Toolbar toolbar;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
      //  toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
      //  initcollapsingtoolbar();
        imageview = (ImageView) findViewById(R.id.turbail_image_header);
        nameofmovie = (TextView) findViewById(R.id.movie_title);
        plotsynopsis = (TextView) findViewById(R.id.plot_synopsys);
        userrating = (TextView) findViewById(R.id.user_rating);
        releaseDate = (TextView) findViewById(R.id.release_date);

        Intent intentthatstardthisactivity = getIntent();
        if (intentthatstardthisactivity.hasExtra("original_title")) {
            String thumbnail = getIntent().getExtras().getString("poster_path");
            String movieName = getIntent().getExtras().getString("original_title");
            String synopsis = getIntent().getExtras().getString("overview");
            String rating = getIntent().getExtras().getString("vote_average");
            String dateOfRelaese = getIntent().getExtras().getString("release_date");

            Glide.with(this).load(thumbnail).placeholder(R.drawable.load).into(imageview);
            nameofmovie.setText(movieName);
            plotsynopsis.setText(synopsis);
            userrating.setText(rating);
            releaseDate.setText(dateOfRelaese);

        } else {
            Toast.makeText(this, "No API Data", Toast.LENGTH_LONG).show();
        }

    }

    /*private void initcollapsingtoolbar() {
        final CollapsingToolbarLayout colapsingtoolabar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        colapsingtoolabar.setTitle(" ");
        AppBarLayout Appbarlayour = (AppBarLayout) findViewById(R.id.appbar);
        Appbarlayour.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isshow = false;
            int scrollrange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollrange == -1) {
                    scrollrange = appBarLayout.getTotalScrollRange();
                }
                if (scrollrange + verticalOffset == 0) {
                    colapsingtoolabar.setTitle(getString(R.string.name_details));
                    isshow = true;
                } else if (isshow) {
                    colapsingtoolabar.setTitle("");
                    isshow = false;
                }
            }
        });
    }*/


}
