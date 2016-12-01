package com.epicodus.movieapp.models;

import java.util.ArrayList;

public class MovieDetail {
    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500/";
    private String mTitle;
    //private String mDirector;
    private String mOverview;
    private String mBackDropUrl;
    private Double mRating;
    private ArrayList<String> mActors;
    private String mReleaseDate;

    public MovieDetail(String title, String backDropUrl, Double rating, ArrayList<String> actors, String releaseDate, String overview){
        this.mTitle = title;
        //this.mDirector = director;
        this.mBackDropUrl = backDropUrl;
        this.mRating = rating;
        this.mActors = actors;
        this.mReleaseDate = releaseDate;
        this.mOverview = overview;
    }

//    public String getDirector() {
//        return mDirector;
//    }

    public String getTitle() {
        return mTitle;
    }

    public String getBackdrop() {
        return IMAGE_BASE_URL + mBackDropUrl;
    }

    public Double getRating() {
        return mRating;
    }

    public ArrayList<String> getActors() {
        return mActors;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }
}
