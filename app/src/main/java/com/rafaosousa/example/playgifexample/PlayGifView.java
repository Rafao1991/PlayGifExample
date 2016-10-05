package com.rafaosousa.example.playgifexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class PlayGifView extends View implements PlayGifToggleFeature{

    private static final int DEFAULT_MOVIEW_DURATION = 1000;

    private int mMovieResourceId;
    private Movie mMovie;

    private long mMovieStart = 0;
    private int mCurrentAnimationTime = 0;

    private Boolean play = true;

    @SuppressLint("NewApi")
    public PlayGifView(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**
         * Starting from HONEYCOMB have to turn off HardWare acceleration to draw
         * Movie on Canvas.
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    @Override
    public void setGifResource(int mvId){
        this.mMovieResourceId = mvId;
        mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
        requestLayout();
    }

    @Override
    public void setGifResourceWithDuration(int mvId, int duration) {
        this.mMovieResourceId = mvId;
        mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
        requestLayout();

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                playAndPause();
            }
        }, duration);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(mMovie != null){
            setMeasuredDimension(mMovie.width(), mMovie.height());
        }else{
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mMovie != null){
            updateAnimtionTime();
            drawGif(canvas);
            if (play) {
                invalidate();
            }
        }else{
            drawGif(canvas);
        }
    }

    private void updateAnimtionTime() {
        long now = android.os.SystemClock.uptimeMillis();

        if (mMovieStart == 0) {
            mMovieStart = now;
        }
        int dur = mMovie.duration();
        if (dur == 0) {
            dur = DEFAULT_MOVIEW_DURATION;
        }
        mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
    }

    private void drawGif(Canvas canvas) {
        mMovie.setTime(mCurrentAnimationTime);
        mMovie.draw(canvas, 0, 0);
        canvas.restore();
    }

    @Override
    public void playAndPause() {
        if (play) {
            play = false;
        } else {
            play = true;
            invalidate();
        }
    }

    @Override
    public void playDuringTime(int duration) {
        play = true;
        invalidate();
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                playAndPause();
            }
        }, duration);
    }
}