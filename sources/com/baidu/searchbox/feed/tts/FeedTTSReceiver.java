package com.baidu.searchbox.feed.tts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.ui.FeedTTSDispatcher;

public class FeedTTSReceiver extends BroadcastReceiver {
    public static final String ACTION_STOP_TTS = "stop_tts";

    public void onReceive(Context context, Intent intent) {
        if (ACTION_STOP_TTS.equals(intent.getAction()) && FeedTTSDispatcher.getInstance().getTTSFlowState() != 0) {
            FeedTTSDispatcher.getInstance().stop();
            TTSRuntime.getInstance().finishTTSPlayers(false);
        }
    }
}
