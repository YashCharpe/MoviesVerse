package com.example.moviesverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.RoundedCorner;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviesverse.model.top_rated;
import com.example.moviesverse.model.top_rated_results;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainDashboard extends AppCompatActivity {

    private Button expandTopRated;
    private TextView tv2;
    private top_rated_results topRatedResults;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        expandTopRated = findViewById(R.id.expandTopRated);
        tv2 = findViewById(R.id.tv2);
        imageView = findViewById(R.id.imageView);



        expandTopRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("https://api.themoviedb.org/3/movie/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                MovieDatabaseApi movieDatabaseApi = retrofit.create(MovieDatabaseApi.class);
//
//                Call<top_rated_results> call = movieDatabaseApi.getTopRatedMovies();
//
//                call.enqueue(new Callback<top_rated_results>() {
//                    @Override
//                    public void onResponse(Call<top_rated_results> call, Response<top_rated_results> response) {
//
//                        if(!response.isSuccessful()){
//                            Toast.makeText(getApplicationContext(),"Error1: "+response.code(),Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//
//                        topRatedResults = response.body();
//
//                        Toast.makeText(getApplicationContext(),"msg: "+topRatedResults.getResults().get(0).getTitle(),Toast.LENGTH_LONG).show();
//
//                        String a = "";
//
//                        for(int i=0;i<topRatedResults.getResults().size();i++){
//                            a+=topRatedResults.getResults().get(i).getTitle()+"\n";
//                        }
//                        tv2.setText(a);
//
//                        String url = "https://image.tmdb.org/t/p/w500/" + topRatedResults.getResults().get(1).getPoster_path();
//
//                        final int radius = 5;
//                        final int margin = 5;
//
//                        Picasso.get().load(url).into(imageView);
//
//                        Toast.makeText(getApplicationContext(),"url: "+url,Toast.LENGTH_LONG).show();
//


                        Intent intent =new Intent(MainDashboard.this,GenreWiseMovies.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("value","topRated");

                        intent.putExtras(bundle);
                        startActivity(intent);


                    //}

//                    @Override
//                    public void onFailure(Call<top_rated_results> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(),"Error: "+t,Toast.LENGTH_SHORT).show();
//
//                        tv2.setText("Error: "+t);
//                    }
//                });






            }
        });


    }
}