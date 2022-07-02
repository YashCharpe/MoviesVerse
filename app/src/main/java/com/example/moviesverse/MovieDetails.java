package com.example.moviesverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviesverse.model.CastModel;
import com.example.moviesverse.model.CreditDetails;
import com.example.moviesverse.model.MovieDetailsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetails extends AppCompatActivity {

    private ImageView backdropImageView,castImg1,castImg2,castImg3,castImg4,castImg5;
    private TextView movieDescriptionTv,title,releaseDateTv,vote_count,length_genre,castName1,castWork1,castName2,castWork2,castName3,castWork3,castName4,castWork4,castName5,castWork5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        backdropImageView = findViewById(R.id.backdropImageView);
        movieDescriptionTv = findViewById(R.id.movieDescriptionTv);
        title = findViewById(R.id.title);
        releaseDateTv = findViewById(R.id.releaseDateTv);
        vote_count = findViewById(R.id.vote_count);
        length_genre = findViewById(R.id.length_genre);

        castImg1 = findViewById(R.id.castImg1);
        castName1 = findViewById(R.id.castName1);
        castWork1= findViewById(R.id.castWork1);

        castImg2 = findViewById(R.id.castImg2);
        castName2 = findViewById(R.id.castName2);
        castWork2= findViewById(R.id.castWork2);

        castImg3 = findViewById(R.id.castImg3);
        castName3 = findViewById(R.id.castName3);
        castWork3= findViewById(R.id.castWork3);

        castImg4 = findViewById(R.id.castImg4);
        castName4 = findViewById(R.id.castName4);
        castWork4= findViewById(R.id.castWork4);

        castImg5 = findViewById(R.id.castImg5);
        castName5 = findViewById(R.id.castName5);
        castWork5= findViewById(R.id.castWork5);

        backdropImageView.setClipToOutline(true);

        Bundle bundle = getIntent().getExtras();

        String movieId =  bundle.getString("movieId");

        //Toast.makeText(getApplicationContext(),"Id: "+movieId,Toast.LENGTH_SHORT).show();

        String apiUrl = "https://api.themoviedb.org/3/";

        getMovieDetail(movieId,apiUrl);

    }

    private void getMovieDetail(String movieId, String apiUrl) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(GsonConverterFactory.create()).build();

        MovieDatabaseApi movieDatabaseApi = retrofit.create(MovieDatabaseApi.class);

        Call<MovieDetailsModel> call = movieDatabaseApi.getMovieDetails(movieId);

        call.enqueue(new Callback<MovieDetailsModel>() {
            @Override
            public void onResponse(Call<MovieDetailsModel> call, Response<MovieDetailsModel> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Unsuccessful: "+response,Toast.LENGTH_SHORT).show();
                    return;
                }
                MovieDetailsModel movieDetails = response.body();

                Toast.makeText(getApplicationContext(),"Hey!: "+movieDetails.getOverview(),Toast.LENGTH_SHORT).show();

                String urlImg = "https://image.tmdb.org/t/p/w500/"+movieDetails.getBackdrop_path();
                Picasso.get().load(urlImg).into(backdropImageView);
                title.setText(movieDetails.getOriginal_title());
                releaseDateTv.setText("UA | "+movieDetails.getRelease_date());
                vote_count.setText(movieDetails.getVote_count()+" votes");
                length_genre.setText(movieDetails.getRuntime()+" mins | Drama Fantasy");
                movieDescriptionTv.setText(movieDetails.getOverview());

                getCastDetails(apiUrl,movieId);

            }

            private void getCastDetails(String url, String movieId) {

                Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
                MovieDatabaseApi movieDatabaseApi = retrofit.create(MovieDatabaseApi.class);
                Call<CreditDetails> call = movieDatabaseApi.getCreditDetails(movieId);
                Toast.makeText(getApplicationContext(),movieId,Toast.LENGTH_SHORT).show();
                call.enqueue(new Callback<CreditDetails>() {
                    @Override
                    public void onResponse(Call<CreditDetails> call, Response<CreditDetails> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Unsuccessful: "+response,Toast.LENGTH_SHORT).show();
                            return;
                        }

                        CreditDetails creditDetails = response.body();

                        int i=0;

                            String urlImg = "https://image.tmdb.org/t/p/w500/"+creditDetails.getCastModel().get(i).profile_path;
                            Picasso.get().load(urlImg).into(castImg1);
                            castName1.setText(creditDetails.getCastModel().get(i).original_name);
                            castWork1.setText(creditDetails.getCastModel().get(i).character);

                             urlImg = "https://image.tmdb.org/t/p/w500/"+creditDetails.getCastModel().get(i+1).profile_path;
                            Picasso.get().load(urlImg).into(castImg2);
                            castName2.setText(creditDetails.getCastModel().get(i+1).original_name);
                            castWork2.setText(creditDetails.getCastModel().get(i+1).character);

                             urlImg = "https://image.tmdb.org/t/p/w500/"+creditDetails.getCastModel().get(i+2).profile_path;
                            Picasso.get().load(urlImg).into(castImg3);
                            castName3.setText(creditDetails.getCastModel().get(i+2).original_name);
                            castWork3.setText(creditDetails.getCastModel().get(i+2).character);

                             urlImg = "https://image.tmdb.org/t/p/w500/"+creditDetails.getCastModel().get(i+3).profile_path;
                            Picasso.get().load(urlImg).into(castImg4);
                            castName4.setText(creditDetails.getCastModel().get(i+3).original_name);
                            castWork4.setText(creditDetails.getCastModel().get(i+3).character);

                             urlImg = "https://image.tmdb.org/t/p/w500/"+creditDetails.getCastModel().get(i+4).profile_path;
                            Picasso.get().load(urlImg).into(castImg5);
                            castName5.setText(creditDetails.getCastModel().get(i+4).original_name);
                            castWork5.setText(creditDetails.getCastModel().get(i+4).character);



                    }

                    @Override
                    public void onFailure(Call<CreditDetails> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Error Cause: "+t.getMessage(),Toast.LENGTH_SHORT).show();;
                        movieDescriptionTv.setText(t.getMessage());
                    }
                });

            }

            @Override
            public void onFailure(Call<MovieDetailsModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error Cause: "+t.getMessage(),Toast.LENGTH_SHORT).show();;
                movieDescriptionTv.setText(t.getMessage());
            }
        });

    }

}