package com.epicodus.movieapp.models;

public class Movie {
    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500/";

    private String mTitle;
    private String mPosterUrl;
    private String mOverview;
    private String mSnippet;
    private Double mRating;
    private Integer mId;


    public Movie(String title, String posterUrl, String overview, Double rating, Integer id){
        this.mTitle = title;
        this.mPosterUrl = posterUrl;
        this.mOverview = overview;
        this.mSnippet = createSnippet(overview);
        this.mRating = rating;
        this.mId = id;
    }

    public Integer getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getSnippet() {
        return mSnippet;
    }

    public String getPosterUrl() {
        return IMAGE_BASE_URL + mPosterUrl;
    }

    public Double getRating() {
        return mRating;
    }

    private String createSnippet(String fullText) {
        if (fullText.length() <= 75) {
            return fullText;
        } else if (fullText == null) {
            return "No description.";
        } else {
            return fullText.substring(0,75).trim() + "...";
        }
    }
}
