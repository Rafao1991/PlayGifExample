package com.rafaosousa.example.playgifexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PlayGifView playGifView = (PlayGifView) findViewById(R.id.view_gif);
        playGifView.setGifResource(R.drawable.freakdroid);

        final PlayGifView playGifViewWithDuration = (PlayGifView) findViewById(R.id.view_gif_with_duration);
        playGifViewWithDuration.setGifResourceWithDuration(R.drawable.freakdroid, 5000);

        Button buttonPlay = (Button) findViewById(R.id.button_play);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGifView.playAndPause();
            }
        });

        Button buttonPlay5 = (Button) findViewById(R.id.button_play_5_secs);
        buttonPlay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGifViewWithDuration.playDuringTime(5000);
            }
        });

        Button buttonPlay10 = (Button) findViewById(R.id.button_play_10_secs);
        buttonPlay10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGifViewWithDuration.playDuringTime(10000);
            }
        });

        Button buttonPlay15 = (Button) findViewById(R.id.button_play_15_secs);
        buttonPlay15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGifViewWithDuration.playDuringTime(15000);
            }
        });
    }
}
