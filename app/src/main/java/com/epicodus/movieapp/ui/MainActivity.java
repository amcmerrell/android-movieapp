package com.epicodus.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.movieapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

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
