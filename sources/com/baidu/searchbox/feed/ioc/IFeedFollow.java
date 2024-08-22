package com.baidu.searchbox.feed.ioc;

import android.content.Context;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.base.ResultCallback;
import java.util.List;

public interface IFeedFollow {
    public static final IFeedFollow EMPTY = new IFeedFollow() {
        public void batchFollow(Context context, List<String> list, String source, ResultCallback<BaseJsonData> resultCallback) {
        }

        public void showRedPacketDialog(Context context, String portrait, String name, String title, String content, String redPacketId, String extraInfo, boolean needUbc) {
        }

        public void showFollowGuideDialog(Context context, String source) {
        }
    };

    void batchFollow(Context context, List<String> list, String str, ResultCallback<BaseJsonData> resultCallback);

    void showFollowGuideDialog(Context context, String str);

    void showRedPacketDialog(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z);

    public static final class Impl {
        private static IFeedFollow sFeedFollow = FeedRuntime.getFeedFollow();

        private Impl() {
        }

        public static IFeedFollow get() {
            if (sFeedFollow == null) {
                sFeedFollow = IFeedFollow.EMPTY;
            }
            return sFeedFollow;
        }
    }
}
