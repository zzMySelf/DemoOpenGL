package com.baidu.searchbox.feed.ioc;

import android.content.Context;
import com.baidu.searchbox.feed.FeedRuntime;

public interface IFeedVoice {
    public static final IFeedVoice EMPTY = new IFeedVoice() {
        public void startVoiceWakeUp(Context context, String ok) {
        }

        public void stopVoiceWakeUp(Context context, String ok) {
        }
    };

    void startVoiceWakeUp(Context context, String str);

    void stopVoiceWakeUp(Context context, String str);

    public static final class Impl {
        private static IFeedVoice sVoiceIoc = FeedRuntime.getFeedVoice();

        private Impl() {
        }

        public static IFeedVoice get() {
            if (sVoiceIoc == null) {
                sVoiceIoc = IFeedVoice.EMPTY;
            }
            return sVoiceIoc;
        }
    }
}
