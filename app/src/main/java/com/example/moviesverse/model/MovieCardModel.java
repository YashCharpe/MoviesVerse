package com.example.moviesverse.model;

import android.graphics.drawable.Drawable;

public class MovieCardModel {

    public String img;
    public String title, rating, releaseDate, popularity;
    public int id;

    public MovieCardModel(String img, String title, String rating, String releaseDate, String popularity, int id) {
        this.img = img;
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.popularity = popularity;
        this.id = id;
    }
}
