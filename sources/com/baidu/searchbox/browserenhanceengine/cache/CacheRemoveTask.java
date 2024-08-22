package com.baidu.searchbox.browserenhanceengine.cache;

import android.util.Log;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.browserenhanceengine.ConstantDef;
import com.baidu.searchbox.browserenhanceengine.cache.BaseCacheModel;
import java.util.ArrayList;
import java.util.List;

public class CacheRemoveTask<T extends BaseCacheModel> extends BaseCacheTask<T> {
    private static final boolean DEBUG = ConstantDef.DEBUG;
    private static final String TAG = "CacheRemoveTask";
    private List<String> mWaitForRemoveKeys;

    CacheRemoveTask(CacheManager cacheManager, List<String> waitForRemoveKeys, CacheListener cacheListener) {
        super(cacheManager, cacheListener);
        ArrayList arrayList = new ArrayList();
        this.mWaitForRemoveKeys = arrayList;
        arrayList.addAll(waitForRemoveKeys);
        if (DEBUG) {
            Log.i(TAG, "task [" + this + "] scheduled. wait for remove elements count [" + waitForRemoveKeys.size() + "].");
        }
    }

    public void run() {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "wait for remove elements count [" + this.mWaitForRemoveKeys.size() + RhetoricalTagUtilKt.TAG_END_SYMBOL);
        }
        if (this.mCacheManager != null) {
            for (String key : this.mWaitForRemoveKeys) {
                if (this.mCacheManager.remove(key)) {
                    if (this.mCacheListener != null) {
                        this.mCacheListener.onSuccess(key);
                    }
                    if (DEBUG) {
                        Log.d(TAG, "remove element [" + key + "] success");
                    }
                } else {
                    if (this.mCacheListener != null) {
                        this.mCacheListener.onFailure(key, CacheErrorCode.REMOVE_FAILURE, CacheErrorCode.REMOVE_FAILURE.getDesc());
                    }
                    if (DEBUG) {
                        Log.d(TAG, "remove element [" + key + "] failure");
                    }
                }
            }
        } else if (z) {
            Log.e(TAG, "task [" + this + "] does not run because of mCacheManager is null.");
        }
    }
}
