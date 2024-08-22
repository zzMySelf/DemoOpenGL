package com.baidu.searchbox.browserenhanceengine.cache;

import android.util.Log;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.browserenhanceengine.ConstantDef;
import com.baidu.searchbox.browserenhanceengine.cache.BaseCacheModel;
import java.util.ArrayList;
import java.util.List;

public class CacheGetTask<T extends BaseCacheModel> extends BaseCacheTask<T> {
    private static final boolean DEBUG = ConstantDef.DEBUG;
    private static final String TAG = "CacheGetTask";
    private List<String> mWaitForGetKeys;

    CacheGetTask(CacheManager cacheManager, List<String> waitForGetKeys, CacheListener cacheListener) {
        super(cacheManager, cacheListener);
        ArrayList arrayList = new ArrayList();
        this.mWaitForGetKeys = arrayList;
        arrayList.addAll(waitForGetKeys);
        if (DEBUG) {
            Log.i(TAG, "task [" + this + "] scheduled. wait for get elements count [" + waitForGetKeys.size() + "].");
        }
    }

    public void run() {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "wait for get count [" + this.mWaitForGetKeys.size() + RhetoricalTagUtilKt.TAG_END_SYMBOL);
        }
        if (this.mCacheManager != null) {
            for (String element : this.mWaitForGetKeys) {
                T cacheModel = this.mCacheManager.get(element);
                if (cacheModel != null) {
                    if (this.mCacheListener != null) {
                        this.mCacheListener.onSuccess(cacheModel);
                    }
                    if (DEBUG) {
                        Log.d(TAG, "get [" + element + "] success.");
                    }
                } else {
                    if (this.mCacheListener != null) {
                        this.mCacheListener.onFailure(null, CacheErrorCode.GET_FAILURE, CacheErrorCode.GET_FAILURE.getDesc());
                    }
                    if (DEBUG) {
                        Log.d(TAG, "get [" + element + "] failure.");
                    }
                }
            }
            if (this.mWaitForGetKeys.isEmpty()) {
                List<T> all = this.mCacheManager.getAll();
                if (all.isEmpty()) {
                    if (this.mCacheListener != null) {
                        this.mCacheListener.onSuccess(null);
                    }
                    if (DEBUG) {
                        Log.d(TAG, "get success in getAll mode, but do not have any data.");
                    }
                }
                for (T cacheModel2 : all) {
                    if (this.mCacheListener != null) {
                        this.mCacheListener.onSuccess(cacheModel2);
                    }
                    if (DEBUG) {
                        Log.d(TAG, "get [" + cacheModel2.key + "] success in getAll mode.");
                    }
                }
            }
        } else if (z) {
            Log.e(TAG, "task [" + this + "] does not run because of mCacheManager is null.");
        }
    }
}
