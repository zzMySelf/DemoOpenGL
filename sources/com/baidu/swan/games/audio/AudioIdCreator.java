package com.baidu.swan.games.audio;

public class AudioIdCreator {
    private static final int MAX_VALUE = 100;
    private static volatile int mAudioId;

    public static synchronized int createAudioId() {
        int id;
        synchronized (AudioIdCreator.class) {
            id = mAudioId;
            mAudioId = id + 1;
        }
        return id;
    }
}
