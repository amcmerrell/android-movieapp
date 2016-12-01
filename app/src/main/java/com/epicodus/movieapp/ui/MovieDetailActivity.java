package com.epicodus.movieapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.movieapp.R;
import com.epicodus.movieapp.models.MovieDetail;
import com.epicodus.movieapp.services.MovieService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String TAG = MovieDetailActivity.class.getSimpleName();
    public MovieDetail mMovie;
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.backdropImageView) ImageView mBackdropImageView;
    @Bind(R.id.releaseDateTextView) TextView mReleaseDateTextView;
    @Bind(R.id.ratingTextView) TextView mRatingTextView;
    @Bind(R.id.actorListView) ListView mActorListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        ButterKnife.bind(this);
        getDetails(this, id);
    }

    private void getDetails(final Context context, String id){
        MovieService.findMovie(id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mMovie = MovieService.processResult(response);
                final ArrayList <String> actors = mMovie.getActors();
                MovieDetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, actors);
                        mActorListView.setAdapter(adapter);
                        Picasso.with(getApplicationContext()).load(mMovie.getBackdrop()).into(mBackdropImageView);
                        mTitleTextView.setText(mMovie.getTitle());
                        mReleaseDateTextView.setText(mMovie.getReleaseDate());
                        mRatingTextView.setText(mMovie.getRating().toString());
                    }
                });
            }
        });
    }
}
