package com.example.moviesverse.model;

import java.util.List;

public class CreditDetails {

    public List<CastModel> cast;

    public CreditDetails(List<CastModel> cast) {
        this.cast = cast;
    }

    public List<CastModel> getCastModel() {
        return cast;
    }

    public void setCastModel(List<CastModel> cast) {
        this.cast = cast;
    }
}
