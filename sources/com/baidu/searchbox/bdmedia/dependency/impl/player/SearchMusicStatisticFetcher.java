package com.baidu.searchbox.bdmedia.dependency.impl.player;

import android.text.TextUtils;
import com.baidu.searchbox.music.MusicManager;

public class SearchMusicStatisticFetcher extends MusicPlayerStatisticFetcher {
    public String getAudioFrom() {
        return "search";
    }

    public String getAudioPage() {
        if (TextUtils.equals(MusicManager.Companion.get().getInvokeSource(), "feed")) {
            return "feed_music";
        }
        return "aladdin";
    }
}
