package com.baidu.searchbox.feed.dependency.iocimpl.feedtts;

import android.os.Bundle;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.tts.ui.FeedTTSDispatcher;
import java.util.ArrayList;
import java.util.List;

public class FeedHistoryTtsDataProvider extends FeedTtsBaseMediaDataProvider {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final String TAG = "BDMEDIA-ttsHistory";

    public List<IFeedTTSModel> queryNowBizList(Bundle params) {
        List<IFeedTTSModel> feedBaseModelList = new ArrayList<>();
        feedBaseModelList.add(FeedTTSDispatcher.getInstance().getToPlayFeed());
        return feedBaseModelList;
    }
}
