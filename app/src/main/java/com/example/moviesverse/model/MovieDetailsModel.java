package com.example.moviesverse.model;

import java.util.ArrayList;

public class MovieDetailsModel {

    public String backdrop_path,original_title,original_language,overview,release_date;
    public int id,runtime,vote_count;
    public float popularity,vote_average;

    public ArrayList<Genre> genreArrayList;

    public MovieDetailsModel() {
    }

    public MovieDetailsModel(String backdrop_path, String original_title, String original_language, String overview, String release_date, int id, int runtime, int vote_count, float popularity, float vote_average, ArrayList<Genre> genreArrayList) {
        this.backdrop_path = backdrop_path;
        this.original_title = original_title;
        this.original_language = original_language;
        this.overview = overview;
        this.release_date = release_date;
        this.id = id;
        this.runtime = runtime;
        this.vote_count = vote_count;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.genreArrayList = genreArrayList;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public ArrayList<Genre> getGenreArrayList() {
        return genreArrayList;
    }

    public void setGenreArrayList(ArrayList<Genre> genreArrayList) {
        this.genreArrayList = genreArrayList;
    }
}
