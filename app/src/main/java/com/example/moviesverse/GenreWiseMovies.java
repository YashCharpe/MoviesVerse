package com.example.moviesverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviesverse.model.MovieCardModel;
import com.example.moviesverse.model.top_rated_results;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GenreWiseMovies extends AppCompatActivity implements RecyclerMovieCardAdapter.OnNoteListner {

    private top_rated_results topRatedResults;
    private RecyclerView recyclerViewList;
    private ArrayList<MovieCardModel> arrMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_wise_movies);

        recyclerViewList = findViewById(R.id.recyclerViewList);

        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String value = bundle.getString("value");

            if(value.equals("topRated")){
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.themoviedb.org/3/movie/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                MovieDatabaseApi movieDatabaseApi = retrofit.create(MovieDatabaseApi.class);

                Call<top_rated_results> call = movieDatabaseApi.getTopRatedMovies();

                call.enqueue(new Callback<top_rated_results>() {
                    @Override
                    public void onResponse(Call<top_rated_results> call, Response<top_rated_results> response) {

                        if(!response.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Error1: "+response.code(),Toast.LENGTH_SHORT).show();
                            return;
                        }

                        topRatedResults = response.body();
                        Toast.makeText(getApplicationContext(),"msg: "+topRatedResults.getResults().get(0).getTitle(),Toast.LENGTH_SHORT).show();
                        String a = "";
                        for(int i=0;i<topRatedResults.getResults().size();i++){
                            a+=topRatedResults.getResults().get(i).getTitle()+"\n";
                        }
                        //String url = "https://image.tmdb.org/t/p/w500/" + topRatedResults.getResults().get(1).getPoster_path();
                        //Picasso.get().load(url).into(imageView);
                        //Toast.makeText(getApplicationContext(),"url: "+url,Toast.LENGTH_LONG).show();

                        for(int i=0;i<topRatedResults.getResults().size();i++) {

                            String url = "https://image.tmdb.org/t/p/w500/" + topRatedResults.getResults().get(i).getPoster_path();

                            arrMovie.add(new MovieCardModel(url,
                                        topRatedResults.getResults().get(i).getTitle(),
                                        Float. toString(topRatedResults.getResults().get(i).getVote_average()),
                                        topRatedResults.getResults().get(i).getRelease_date(),
                                        Float. toString(topRatedResults.getResults().get(i).getPopularity()),
                                        topRatedResults.getResults().get(i).getId()));
                        }

                        RecyclerMovieCardAdapter adapter = new RecyclerMovieCardAdapter(getApplicationContext(),arrMovie, (RecyclerMovieCardAdapter.OnNoteListner) recyclerViewList.getContext());
                        recyclerViewList.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<top_rated_results> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Error: "+t,Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }

    }

    @Override
    public void onNoteClick(int position) {
        //Toast.makeText(getApplicationContext(), arrMovie.get(position).title+" "+arrMovie.get(position).id,Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("movieId",Integer.toString(arrMovie.get(position).id));
        Intent intent = new Intent(getApplicationContext(),MovieDetails.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}