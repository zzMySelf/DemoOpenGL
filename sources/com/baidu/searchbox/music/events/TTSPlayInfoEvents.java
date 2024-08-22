package com.baidu.searchbox.music.events;

import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;

public class TTSPlayInfoEvents {
    public static final int CURRNENT_TTS_CHANGED = 1;
    public int mAction;
    public IFeedTTSModel mModel;

    public TTSPlayInfoEvents(int action) {
        this.mAction = action;
    }

    public TTSPlayInfoEvents(int action, IFeedTTSModel model) {
        this.mAction = action;
        this.mModel = model;
    }
}
