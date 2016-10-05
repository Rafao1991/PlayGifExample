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
        playGifView.setImageResource(R.drawable.freakdroid);

        Button buttonPlay = (Button) findViewById(R.id.button_play);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGifView.playAndPause();
            }
        });
    }
}
