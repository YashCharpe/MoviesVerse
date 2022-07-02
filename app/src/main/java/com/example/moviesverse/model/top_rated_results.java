package com.example.moviesverse.model;

import java.io.Serializable;
import java.util.List;

public class top_rated_results  {

    private List<top_rated> results;

    public top_rated_results() {
    }

    public List<top_rated> getResults() {
        return results;
    }

    public void setResults(List<top_rated> results) {
        this.results = results;
    }
}
