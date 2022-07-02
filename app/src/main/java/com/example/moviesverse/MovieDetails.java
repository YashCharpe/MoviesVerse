package com.example.moviesverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Bundle bundle = getIntent().getExtras();

        String movieId =  bundle.getString("movieId");

        Toast.makeText(getApplicationContext(),"Id: "+movieId,Toast.LENGTH_SHORT).show();


    }
}