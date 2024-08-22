package com.baidu.searchbox.search;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.android.util.time.ServerDeltaChangeEvent;
import com.baidu.browser.BrowserRuntime;
import com.baidu.browser.statistic.BrowserStatisticConstantsNew;
import com.baidu.sapi2.SapiWebView;
import com.baidu.search.core.utils.BrowserUrlUtils;
import com.baidu.searchbox.NativeBds;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.schemedispatch.SchemeUtility;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.video.feedflow.ubc.UBC6123;
import com.baidu.ubc.UBC;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchTokenCookieManager {
    private static final String CAT_MS_FLAG_COOKIE = "cat_ms";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = BrowserRuntime.GLOBAL_DEBUG;
    private static final String TAG = "SearchTokenCookieMgr";
    private static final String TASK_SEARCH_CAT_COOKIE = "search_cat_ms_cookie";
    private static final String TOKEN_COOKIE_DOMAIN = "m.baidu.com";
    private static final int TOKEN_UPATE_TIMESTAMP = 90000;
    private static volatile SearchTokenCookieManager mInstance;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private long mInitTimestamp = 0;
    /* access modifiers changed from: private */
    public boolean mIsForeground = true;
    /* access modifiers changed from: private */
    public Runnable mSetTokenTask = new Runnable() {
        public void run() {
            SearchTokenCookieManager.this.asyncSetTokenCookie();
        }
    };

    public static SearchTokenCookieManager getInstance() {
        if (mInstance == null) {
            synchronized (SearchTokenCookieManager.class) {
                if (mInstance == null) {
                    mInstance = new SearchTokenCookieManager();
                }
            }
        }
        return mInstance;
    }

    private SearchTokenCookieManager() {
        syncSetTokenCookie();
        if (DEBUG) {
            Log.i(TAG, "init SetTokenCookie");
        }
        this.mInitTimestamp = System.currentTimeMillis();
        BdEventBus.Companion.getDefault().register(this, ServerDeltaChangeEvent.class, 2, new Action<ServerDeltaChangeEvent>() {
            public void call(ServerDeltaChangeEvent serverDeltaChangeEvent) {
                if (SearchTokenCookieManager.DEBUG) {
                    Log.i(SearchTokenCookieManager.TAG, "form ServerDeltaChangeEvent delta=" + DateTimeUtil.getDelta());
                }
                SearchTokenCookieManager.this.asyncSetTokenCookie();
            }
        });
    }

    /* access modifiers changed from: private */
    public void asyncSetTokenCookie() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                SearchTokenCookieManager.this.syncSetTokenCookie();
            }
        }, TASK_SEARCH_CAT_COOKIE, 2);
    }

    /* access modifiers changed from: private */
    public void syncSetTokenCookie() {
        setTokenCookie();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (SearchTokenCookieManager.this.mIsForeground) {
                    SearchTokenCookieManager.this.mHandler.removeCallbacks(SearchTokenCookieManager.this.mSetTokenTask);
                    SearchTokenCookieManager.this.mHandler.postDelayed(SearchTokenCookieManager.this.mSetTokenTask, SapiWebView.DEFAULT_TIMEOUT_MILLIS);
                }
            }
        });
    }

    private void setTokenCookie() {
        long startTime = System.currentTimeMillis();
        boolean z = DEBUG;
        if (z) {
            Log.i(TAG, "setTokenCookie start");
        }
        String cookieValue = generateToken();
        long tokenDuration = System.currentTimeMillis() - startTime;
        String url = "m.baidu.com";
        if (z) {
            URL aURL = null;
            try {
                if (!TextUtils.isEmpty(BrowserUrlUtils.getDebugSearchHost())) {
                    aURL = new URL(BrowserUrlUtils.getDebugSearchHostUrl(false));
                } else if (!TextUtils.isEmpty(AppConfig.getQAWebSearchUrl())) {
                    aURL = new URL(AppConfig.getQAWebSearchUrl());
                }
                if (aURL != null) {
                    url = aURL.getHost();
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        String cookieString = UrlUtil.getCookieStr(url, CAT_MS_FLAG_COOKIE, cookieValue, 31449600);
        boolean z2 = DEBUG;
        if (z2) {
            Log.i(TAG, "setTokenCookie cookieString=" + cookieString);
        }
        BrowserRuntime.getContext().setCookieManualNoBdussOperate(url, cookieString, false, "");
        if (this.mInitTimestamp == 0) {
            statisticSetCookieTime(System.currentTimeMillis() - startTime, tokenDuration);
        }
        if (z2) {
            Log.i(TAG, "setTokenCookie end time =" + (System.currentTimeMillis() - startTime));
            Log.i(TAG, "setTokenCookie Thread =" + Thread.currentThread());
        }
    }

    private String generateToken() {
        return aesEncyptToken(SchemeUtility.URL_HOST_TARGET_TYPE + DateTimeUtil.getCalibratedTime() + "&w=" + MD5Utils.toMd5(BaiduIdentityManager.getInstance().getEnUid().getBytes(), false));
    }

    private static String aesEncyptToken(String tokenText) {
        if (TextUtils.isEmpty(tokenText)) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(Base64.encode(NativeBds.ae(BaiduIdentityManager.getInstance().getEnUid(), tokenText), 2)), "UTF-8");
        } catch (Throwable e2) {
            if (!DEBUG) {
                return "";
            }
            Log.e(TAG, "aesEncyptToken exception:", e2);
            return "";
        }
    }

    public void handle(boolean isForeground, Activity activity) {
        Runnable runnable;
        Runnable runnable2;
        this.mIsForeground = isForeground;
        if (isForeground) {
            boolean z = DEBUG;
            if (z) {
                Log.i(TAG, "isForeground is true SetTokenCookie");
            }
            if ((System.currentTimeMillis() - this.mInitTimestamp) / 1000 == 0) {
                if (z) {
                    Log.i(TAG, "timeStamp=0 not setTokenCookie");
                }
                Handler handler = this.mHandler;
                if (handler != null && (runnable2 = this.mSetTokenTask) != null) {
                    handler.removeCallbacks(runnable2);
                    this.mHandler.postDelayed(this.mSetTokenTask, SapiWebView.DEFAULT_TIMEOUT_MILLIS);
                }
            } else if (BrowserRuntime.getContext().isBrowser(activity)) {
                syncSetTokenCookie();
            } else {
                asyncSetTokenCookie();
            }
        } else {
            Handler handler2 = this.mHandler;
            if (!(handler2 == null || (runnable = this.mSetTokenTask) == null)) {
                handler2.removeCallbacks(runnable);
            }
            if (DEBUG) {
                Log.i(TAG, "isForeground is false cancel SetTokenCookie");
            }
        }
    }

    public void setTokenCookieFromClear() {
        if (DEBUG) {
            Log.i(TAG, "setTokenCookieFromClear");
        }
        asyncSetTokenCookie();
    }

    private void statisticSetCookieTime(long totalDuration, long tokenDuration) {
        JSONObject extJson = new JSONObject();
        try {
            extJson.put(UBC6123.Type.TYPE_TOTAL_DURATION, String.valueOf(totalDuration));
            extJson.put("tokenDuration", String.valueOf(tokenDuration));
            JSONObject ubcObj = new JSONObject();
            ubcObj.put("from", "search");
            ubcObj.put("page", "browser_result");
            ubcObj.put("ext", extJson);
            UBC.onEvent(BrowserStatisticConstantsNew.UBC_SEARCH_TOKEN_COOKIE_ID, ubcObj);
            if (DEBUG) {
                Log.i(TAG, "statisticSetCookieTime totalDuration=" + totalDuration + "----tokenDuration=" + tokenDuration);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }
}
