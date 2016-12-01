package com.epicodus.movieapp.models;

public class Movie {
    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    private String mTitle;
    private String mPosterUrl;
    private String mOverview;
    private Double mRating;


    public Movie(String title, String posterUrl, String overview, Double rating){
        this.mTitle = title;
        this.mPosterUrl = posterUrl; //TODO: append base url
        this.mOverview = overview;
        this.mRating = rating;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    public Double getRating() {
        return mRating;
    }
}
