package com.baidu.searchbox.feed.news;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.lightbrowser.LightBrowserActivity;
import com.baidu.searchbox.lightbrowser.LightBrowserRuntime;
import com.baidu.searchbox.lightbrowser.view.LightBrowserView;
import com.baidu.searchbox.ng.browser.cache.NgCacheableContext;

public class HybridPreloadManager {
    private static final boolean DEBUG = LightBrowserRuntime.GLOBAL_DEBUG;
    private static final String TAG = "HybridPreload";
    private static HybridPreloadManager instance;
    private LightBrowserView mCachedBrowser;

    private HybridPreloadManager() {
    }

    public static HybridPreloadManager getInstance() {
        if (instance == null) {
            synchronized (HybridPreloadManager.class) {
                if (instance == null) {
                    instance = new HybridPreloadManager();
                }
            }
        }
        return instance;
    }

    public static void releaseInstance() {
        HybridPreloadManager hybridPreloadManager = instance;
        if (hybridPreloadManager != null) {
            hybridPreloadManager.release();
        }
        instance = null;
    }

    private void release() {
        LightBrowserView lightBrowserView = this.mCachedBrowser;
        if (lightBrowserView != null) {
            lightBrowserView.onDestroy();
            this.mCachedBrowser = null;
        }
    }

    public void preload(Context context, String url) {
        if (context instanceof NgCacheableContext) {
            if (this.mCachedBrowser == null) {
                try {
                    this.mCachedBrowser = new LightBrowserView(context, 2);
                } catch (Exception e2) {
                    if (DEBUG) {
                        throw new RuntimeException("prepare CachedBrowser error", e2);
                    }
                }
            }
            LightBrowserView lightBrowserView = this.mCachedBrowser;
            if (lightBrowserView != null) {
                lightBrowserView.loadUrl(url);
                this.mCachedBrowser.getHostContext().setName(LightBrowserActivity.TAG);
                if (DEBUG) {
                    Log.d(TAG, "preload hybrid:" + url);
                }
            }
        }
    }
}
