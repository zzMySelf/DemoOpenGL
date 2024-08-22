package com.baidu.swan.game.ad.interfaces;

public interface IAdVideoPlayerListener {
    void onCompletion();

    boolean onError();

    void onPause();

    void onPrepared();

    void onResume();

    void onStart();
}
