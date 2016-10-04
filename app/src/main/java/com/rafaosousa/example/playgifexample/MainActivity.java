package com.rafaosousa.example.playgifexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayGifView playGifView = (PlayGifView) findViewById(R.id.viewGif);
        playGifView.setImageResource(R.drawable.freakdroid);
    }
}
