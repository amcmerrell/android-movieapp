package com.epicodus.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.movieapp.models.Movie;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public String mSearchTitle;
    @Bind(R.id.button) Button mButton;
    @Bind(R.id.textView) TextView mTexView;
    @Bind(R.id.editText) EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == mButton) {
            mSearchTitle = mEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, MovieResults.class);
            intent.putExtra("title", mSearchTitle);
            startActivity(intent);
        }
    }
}
