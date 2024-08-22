package com.baidu.searchbox.feed.controller;

import android.util.Log;
import com.baidu.searchbox.feed.FeedRuntime;

public final class FeedRefreshController {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    public static final int FORCE_REFRESH_FLAG_INTEREST_CHANGED = 1;
    public static final int FORCE_REFRESH_FLAG_INTEREST_SELECTED = 2;
    public static final int FORCE_REFRESH_FLAG_PRIVACY_MODE = 3;
    private static final String TAG = "FeedRefreshController";
    private static volatile FeedRefreshController sInstance;
    private int mForceRefreshFlags = 0;

    public static FeedRefreshController getInstance() {
        if (sInstance == null) {
            synchronized (FeedLinkageManager.class) {
                if (sInstance == null) {
                    sInstance = new FeedRefreshController();
                }
            }
        }
        return sInstance;
    }

    private FeedRefreshController() {
    }

    public void addForceRefreshFlag(int flag) {
        if (DEBUG) {
            Log.d(TAG, "Add force refresh flag, reason: " + flag);
        }
        this.mForceRefreshFlags |= flag;
    }

    public void removeForceRefreshFlag() {
        if (DEBUG) {
            Log.d(TAG, "Remove force refresh flag, reason: " + this.mForceRefreshFlags);
        }
        this.mForceRefreshFlags = 0;
    }

    public boolean needRefreshByReason() {
        if (DEBUG) {
            Log.d(TAG, "need refresh by reason: " + this.mForceRefreshFlags);
        }
        return this.mForceRefreshFlags != 0;
    }
}
