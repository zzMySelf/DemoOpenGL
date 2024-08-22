package com.baidu.searchbox.feed.tts.ui.delegates.finishchains;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.tts.R;
import com.baidu.searchbox.feed.tts.ui.FeedTTSDispatcher;

public class PluginErrorChain extends BaseChain {
    public PluginErrorChain(ITTSModelFinishResponsibility next) {
        super(next);
    }

    public int process() {
        if (TTSEndResponsibilityController.get().getFinishStatus() != 7) {
            return 0;
        }
        FeedTTSDispatcher.getInstance().onPlaybackStopState(-1, true, FeedTTSDispatcher.getInstance().getNid(TTSEndResponsibilityController.get().getFinishData()));
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.tts_engine_speak_fail).showToast();
            }
        });
        return 1;
    }
}
