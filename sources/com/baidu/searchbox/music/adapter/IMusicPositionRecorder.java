package com.baidu.searchbox.music.adapter;

import com.baidu.searchbox.music.bean.Song;

public interface IMusicPositionRecorder {
    int getAudioHistoryPosition(Song song);

    void onAudioClosed(Song song, int i2);

    void onAudioStopped(Song song, int i2);

    void recordMusicPosition(Song song, int i2, boolean z);

    void recordWhenAudioStart(Song song, int i2, Song song2);
}
