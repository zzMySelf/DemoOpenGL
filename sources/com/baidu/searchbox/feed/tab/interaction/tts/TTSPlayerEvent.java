package com.baidu.searchbox.feed.tab.interaction.tts;

import android.graphics.Rect;

public class TTSPlayerEvent {
    public static final int EVENT_TTS_PLAYER_HIDE = 1;
    public static final int EVENT_TTS_PLAYER_SHOW = 2;
    public Rect playerRect;
    public int ttsPlayerState;
}
