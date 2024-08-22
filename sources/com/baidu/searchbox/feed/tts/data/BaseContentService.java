package com.baidu.searchbox.feed.tts.data;

import android.util.Log;
import com.baidu.searchbox.feed.tts.commonstreams.StreamsContentHelper;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;

public abstract class BaseContentService implements ITTSContentService {
    protected static final boolean DEBUG = TTSRuntime.DEBUG;
    protected static final String TAG = "BaseContent";
    protected String appendContent;
    protected boolean isAppend;
    protected IFeedTTSModel ttsModel;

    public void setParams(IFeedTTSModel ttsModel2, boolean isAppend2, String appendContent2) {
        this.ttsModel = ttsModel2;
        this.isAppend = isAppend2;
        this.appendContent = appendContent2;
    }

    /* access modifiers changed from: protected */
    public void addContentCache(String cache) {
        String cacheID = getContentCacheKey();
        if (DEBUG) {
            Log.d(TAG, cacheID + " addContent=>" + cache);
        }
        StreamsContentHelper.addContentToCache(cacheID, cache);
    }

    /* access modifiers changed from: protected */
    public void appendContentCache(String cache) {
        String cacheID = getContentCacheKey();
        if (DEBUG) {
            Log.d(TAG, cacheID + " appendContent=>" + cache);
        }
        StreamsContentHelper.appendContentToCache(cacheID, cache);
    }

    /* access modifiers changed from: protected */
    public String getContentCache() {
        return StreamsContentHelper.getContentFromCache(getContentCacheKey());
    }

    /* access modifiers changed from: protected */
    public String getContentCacheKey() {
        String category = this.ttsModel.getExtInfo("category", "");
        return category + "_" + this.ttsModel.getId();
    }

    public int prefetch() {
        return 6;
    }
}
