package com.example.sowmyaram.moviesapp_restapi_retrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sowmyaram.moviesapp_restapi_retrofit.DetailActivity;
import com.example.sowmyaram.moviesapp_restapi_retrofit.R;
import com.example.sowmyaram.moviesapp_restapi_retrofit.model.Movie;

import java.util.List;

/**
 * Created by sowmyaram on 11/9/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mcontext;
    private List<Movie> movielist;

    public MoviesAdapter(Context mcontext,List<Movie> movielist){
        this.mcontext=mcontext;
        this.movielist=movielist;
    }


    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view= LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.movies_card,viewgroup ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.MyViewHolder viewHolder, int i) {
        viewHolder.title.setText(movielist.get(i).getOriginal_title());
        String Vote =Double.toString(movielist.get(i).getVote_average());
//        viewHolder.userating.setText(Vote);

        Glide.with(mcontext).load(movielist.get(i).getposterpath()).placeholder(R.drawable.load).into(viewHolder.turbnail);
    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title,userating;
        ImageView  turbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            userating = (TextView) view.findViewById(R.id.user_rating);
            turbnail = (ImageView) view.findViewById(R.id.turbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        Movie clickedDataItem=movielist.get(pos);
                        Intent i =new Intent(mcontext, DetailActivity.class);
                       i.putExtra("original_title",movielist.get(pos).getOriginal_title());
                        i.putExtra("poster_Path",movielist.get(pos).getposterpath());
                        i.putExtra("overview",movielist.get(pos).getOverview());
                        i.putExtra("vote_average",Double.toString(movielist.get(pos).getVote_average()));
                        i.putExtra("release_date",movielist.get(pos).getRelease_date());
                        i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
                        mcontext.startActivity(i);
                        Toast.makeText(view.getContext(),"you clicked "+clickedDataItem.getOriginal_title(),Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}
