package com.epicodus.movieapp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 12/1/16.
 */
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
}
