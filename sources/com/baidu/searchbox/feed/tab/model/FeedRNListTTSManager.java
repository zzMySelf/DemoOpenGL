package com.baidu.searchbox.feed.tab.model;

import android.util.Log;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import java.util.ArrayList;
import java.util.List;

public class FeedRNListTTSManager {
    private static final boolean DEBUG = TTSRuntime.DEBUG;
    public static final String TAB_ID = "RNList";
    private static final String TAG = "FeedRNListTTSManager";
    private List<IFeedTTSModel> mFeedModels = new ArrayList();
    private int mPlayingIndex = 0;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final FeedRNListTTSManager INSTANCE = new FeedRNListTTSManager();

        private Holder() {
        }
    }

    public static FeedRNListTTSManager getInstance() {
        return Holder.INSTANCE;
    }

    public List<IFeedTTSModel> getFeedList() {
        return this.mFeedModels;
    }

    public void setFeedList(List<IFeedTTSModel> feedModels) {
        if (feedModels != null && feedModels.size() > 0) {
            this.mFeedModels = feedModels;
        } else if (DEBUG) {
            Log.d(TAG, "feedModels is invalid");
        }
    }

    public void setPlayingIndexByModel(IFeedTTSModel feedModel) {
        List<IFeedTTSModel> list;
        if (feedModel != null && (list = this.mFeedModels) != null && list.size() > 0) {
            this.mPlayingIndex = this.mFeedModels.indexOf(feedModel);
        }
    }

    public int getPlayingIndex() {
        return this.mPlayingIndex;
    }

    public void clearRNTTSData() {
        this.mFeedModels.clear();
    }
}
