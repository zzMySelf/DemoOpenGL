package com.baidu.searchbox.feed.tts.ui.delegates;

import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;

public class StatisticDelegateImpl implements IStatisticDelegate {
    public void afterPlayAction(String source) {
    }

    public void beforeOfflineModelCheck() {
    }

    public void afterOfflineModelCheck() {
    }

    public void onTTSItemDataReady() {
    }

    public void beforeTTSSDKPrepare() {
    }

    public void beforeTTSSDKInvokeSpeak() {
    }

    public void afterTTSSDKSpeaked() {
    }

    public void beforeItemChanged(IFeedTTSModel beforeModel) {
        TTSRuntime.getInstance().endTtsDurationUbcFlow(beforeModel);
    }
}
