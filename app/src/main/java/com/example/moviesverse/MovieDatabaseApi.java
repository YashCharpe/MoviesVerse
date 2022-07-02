package com.example.moviesverse;

import com.example.moviesverse.model.CastModel;
import com.example.moviesverse.model.CreditDetails;
import com.example.moviesverse.model.Genre;
import com.example.moviesverse.model.MovieDetailsModel;
import com.example.moviesverse.model.top_rated;
import com.example.moviesverse.model.top_rated_results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieDatabaseApi {

    @GET("top_rated?api_key=65c15f872cdbb9bd20f4ba60f0407aff")
    Call<top_rated_results> getTopRatedMovies();

    @GET("movie/{id}?api_key=65c15f872cdbb9bd20f4ba60f0407aff&language=en-US")
    Call<MovieDetailsModel> getMovieDetails(@Path("id") String id);

    @GET("movie/{id}/credits?api_key=65c15f872cdbb9bd20f4ba60f0407aff&language=en-US")
    Call<CreditDetails> getCreditDetails(@Path("id") String id);

}
