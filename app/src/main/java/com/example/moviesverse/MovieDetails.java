package com.example.moviesverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MovieDetails extends AppCompatActivity {

    private ImageView backdropImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        backdropImageView = findViewById(R.id.backdropImageView);

        backdropImageView.setClipToOutline(true);

        Bundle bundle = getIntent().getExtras();

        String movieId =  bundle.getString("movieId");

        Toast.makeText(getApplicationContext(),"Id: "+movieId,Toast.LENGTH_SHORT).show();


    }
}