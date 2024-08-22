package com.baidu.browser.components.novel.utils;

import android.text.TextUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.novel.ioc.container.hijack.NovelHijackAbilityManager;
import okhttp3.Response;

public class NovelJsTask {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final int REQUEST_CONN_TIMEOUT = 5000;
    private static final int REQUEST_SO_TIMEOUT = 3000;
    private static String injectJsStr = null;

    public interface Callback {
        void onGetJs(String str, String str2);
    }

    public static void getNovelJs(final String sourceUrl, final Callback callback) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                if (AppConfig.isDebug()) {
                    NovelJsTask.executeSyncForDebug(sourceUrl, callback);
                } else {
                    NovelJsTask.executeSync(sourceUrl, callback);
                }
            }
        }, "INIT_DETECT_JS_DATA", 3);
    }

    /* access modifiers changed from: private */
    public static void executeSyncForDebug(String sourceUrl, Callback callback) {
        String url;
        Response response;
        try {
            GetRequest.GetRequestBuilder builder = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest();
            if (AppConfig.isDebug()) {
                String host = AppConfig.getStringConfig("NOVEL_FE_HOST", "");
                if (TextUtils.isEmpty(host)) {
                    url = NovelHijackAbilityManager.get().novelTransWebInjectJSUrl();
                } else {
                    url = host + "/static/n/boxnovel/lib-trans-inject.js";
                }
            } else {
                url = NovelHijackAbilityManager.get().novelTransWebInjectJSUrl();
            }
            ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) builder.connectionTimeout(5000)).readTimeout(3000)).writeTimeout(3000)).url(url);
            if (NetWorkUtils.isNetworkConnected() && (response = builder.build().executeSync()) != null && response.isSuccessful() && response.body() != null) {
                String bodyStr = response.body().string();
                if (!TextUtils.isEmpty(bodyStr)) {
                    injectJsStr = bodyStr;
                    if (callback != null) {
                        callback.onGetJs(sourceUrl, bodyStr);
                    }
                }
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void executeSync(String sourceUrl, Callback callback) {
        Response response;
        if (TextUtils.isEmpty(injectJsStr)) {
            try {
                GetRequest.GetRequestBuilder builder = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest();
                ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) builder.connectionTimeout(5000)).readTimeout(3000)).writeTimeout(3000)).url(NovelHijackAbilityManager.get().novelTransWebInjectJSUrl());
                if (NetWorkUtils.isNetworkConnected() && (response = builder.build().executeSync()) != null && response.isSuccessful() && response.body() != null) {
                    String bodyStr = response.body().string();
                    if (!TextUtils.isEmpty(bodyStr)) {
                        injectJsStr = bodyStr;
                        if (callback != null) {
                            callback.onGetJs(sourceUrl, bodyStr);
                        }
                    }
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        } else if (callback != null) {
            callback.onGetJs(sourceUrl, injectJsStr);
        }
    }
}
