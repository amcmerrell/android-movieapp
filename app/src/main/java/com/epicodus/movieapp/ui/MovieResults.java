package com.epicodus.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.movieapp.models.Movie;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieResults extends AppCompatActivity {
    public static final String TAG = MovieResults.class.getSimpleName();
    public ArrayList<Movie> mMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_results);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        getMovies(title);
    }

    private void getMovies(String title) {
        final MovieService movieService = new MovieService();
        movieService.findMovies(title, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mMovies = movieService.processResults(response);

            }
        });
    }
}