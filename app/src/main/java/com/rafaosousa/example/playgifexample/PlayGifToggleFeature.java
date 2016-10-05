package com.rafaosousa.example.playgifexample;

interface PlayGifToggleFeature {

    void setGifResource(int mvId);
    void setGifResourceWithDuration(int mvId, int duration);
    void playAndPause();
    void playDuringTime(int duration);
}
