package com.epicodus.movieapp.services;

import com.epicodus.movieapp.Constants;
import com.epicodus.movieapp.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieService {
    public static void findMovies(String title, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_DATABASE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MOVIE_DATABASE_KEY_PARAMETER, Constants.MOVIE_DATABASE_API_KEY)
                .addQueryParameter(Constants.MOVIE_DATABASE_TITLE_PARAMETER, title);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject movieJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = movieJSON.getJSONArray("results");
                for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject movie = resultsJSON.getJSONObject(i);
                    String title = movie.getString("title");
                    String posterUrl = movie.getString("poster_path");
                    String overview = movie.getString("overview");
                    Double rating = movie.getDouble("vote_average");

                    movies.add(new Movie(title, posterUrl, overview, rating));
                }
            }
        } catch (JSONException|IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}