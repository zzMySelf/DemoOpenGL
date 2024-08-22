package com.baidu.searchbox.feed.ioc;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.topview.ITopView;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPop;
import com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPopViewBuilder;
import com.baidu.searchbox.lightbrowser.model.PageBackData;

public interface IFeedAd {
    public static final IFeedAd EMPTY = new IFeedAd() {
        public void cacheTopView(FeedBaseModel model, ITopView videoView) {
        }

        public boolean getIfAfterCountdown() {
            return false;
        }

        public void resetIfAfterCountdown() {
        }

        public String getTopViewVideoVid() {
            return null;
        }

        public FeedbackPopViewBuilder getPageAdDislikePopViewBuilder(Context context, PageBackData data, FeedbackPop.NotInterestCallback callback) {
            return null;
        }

        public boolean isAdFeedView(View view2) {
            return false;
        }
    };

    void cacheTopView(FeedBaseModel feedBaseModel, ITopView iTopView);

    boolean getIfAfterCountdown();

    FeedbackPopViewBuilder getPageAdDislikePopViewBuilder(Context context, PageBackData pageBackData, FeedbackPop.NotInterestCallback notInterestCallback);

    String getTopViewVideoVid();

    boolean isAdFeedView(View view2);

    void resetIfAfterCountdown();

    public static final class Impl {
        private static IFeedAd sFeedAd = FeedRuntime.getFeedAd();

        private Impl() {
        }

        public static IFeedAd get() {
            if (sFeedAd == null) {
                sFeedAd = IFeedAd.EMPTY;
            }
            return sFeedAd;
        }
    }
}
