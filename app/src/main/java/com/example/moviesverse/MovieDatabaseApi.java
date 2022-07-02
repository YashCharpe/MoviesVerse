package com.example.moviesverse;

import com.example.moviesverse.model.top_rated;
import com.example.moviesverse.model.top_rated_results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieDatabaseApi {

    @GET("top_rated?api_key=65c15f872cdbb9bd20f4ba60f0407aff")
    Call<top_rated_results> getTopRatedMovies();

}
