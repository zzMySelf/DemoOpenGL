package com.baidu.browser.autoexpand;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.utils.SearchPreferenceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0006\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/browser/autoexpand/AutoExpandArticleManager;", "", "()V", "AUTO_EXPAND_ARTICLE_UBC_ID", "", "CONDITION_KEY_AUTO_EXPAND_CONTENT", "DEBUG", "", "SP_KEY_AUTO_EXPAND_ARTICLE", "SP_KEY_AUTO_EXPAND_ARTICLE_COUNT", "TAG", "cachedExpandCount", "", "cachedUrl", "getAutoExpandArticleCount", "url", "handleMessage", "", "message", "makeAutoExpandContentUbcEventLog", "expandSuccess", "errorCode", "shouldInjectExpandArticleJS", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoExpandArticleManager.kt */
public final class AutoExpandArticleManager {
    private static final String AUTO_EXPAND_ARTICLE_UBC_ID = "5897";
    public static final String CONDITION_KEY_AUTO_EXPAND_CONTENT = "auto-expand-content";
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final AutoExpandArticleManager INSTANCE = new AutoExpandArticleManager();
    private static final String SP_KEY_AUTO_EXPAND_ARTICLE = "SP_KEY_AUTO_EXPAND_ARTICLE";
    private static final String SP_KEY_AUTO_EXPAND_ARTICLE_COUNT = "SP_KEY_AUTO_EXPAND_ARTICLE_COUNT";
    private static final String TAG = "AutoExpandArticle";
    private static int cachedExpandCount;
    private static String cachedUrl = "";

    private AutoExpandArticleManager() {
    }

    public final boolean shouldInjectExpandArticleJS() {
        boolean enableAutoExpandArticle = SearchPreferenceUtils.getInstance().getBoolean(SP_KEY_AUTO_EXPAND_ARTICLE, true);
        if (DEBUG) {
            Log.d(TAG, "shouldInjectExpandArticleJS: " + enableAutoExpandArticle);
        }
        return enableAutoExpandArticle;
    }

    public final void handleMessage(Object message) {
        if (message != null) {
            JSONObject messageJson = message instanceof JSONObject ? (JSONObject) message : null;
            if (messageJson != null) {
                String url = messageJson.optString("url", "");
                String expandResult = messageJson.optString("expandResult", "");
                String errorCode = messageJson.optString("errorCode", "-1");
                if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(expandResult)) {
                    boolean expandSuccess = expandResult.equals("1");
                    if (expandSuccess) {
                        long currentAutoExpandCount = SearchPreferenceUtils.getInstance().getLong(SP_KEY_AUTO_EXPAND_ARTICLE_COUNT, 0) + 1;
                        SearchPreferenceUtils.getInstance().putLong(SP_KEY_AUTO_EXPAND_ARTICLE_COUNT, currentAutoExpandCount);
                        if (DEBUG) {
                            Log.d(TAG, "handlerMessage: 展开成功，总折叠展开次数=" + currentAutoExpandCount + " url=" + url);
                        }
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        cachedUrl = url;
                        cachedExpandCount = 1;
                    } else if (DEBUG) {
                        Log.d(TAG, "handlerMessage: 展开失败，url=" + url);
                    }
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    Intrinsics.checkNotNullExpressionValue(errorCode, "errorCode");
                    makeAutoExpandContentUbcEventLog(url, expandSuccess, errorCode);
                }
            }
        }
    }

    public final int getAutoExpandArticleCount(String url) {
        if (TextUtils.isEmpty(url) || !Intrinsics.areEqual((Object) url, (Object) cachedUrl) || !SearchPreferenceUtils.getInstance().getBoolean(SP_KEY_AUTO_EXPAND_ARTICLE, true)) {
            return 0;
        }
        return cachedExpandCount;
    }

    private final void makeAutoExpandContentUbcEventLog(String url, boolean expandSuccess, String errorCode) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("from", "search");
            jsonObject.put("page", "landing");
            jsonObject.put("source", "auto_expand");
            jsonObject.put("type", "click");
            JSONObject extJsonObject = new JSONObject();
            extJsonObject.put("action_result", expandSuccess ? "1" : "0");
            extJsonObject.put("url", !TextUtils.isEmpty(url) ? url : "");
            extJsonObject.put("error_code", !TextUtils.isEmpty(errorCode) ? errorCode : "-1");
            jsonObject.put("ext", extJsonObject);
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("5897", jsonObject);
            if (DEBUG) {
                Log.d(TAG, "makeAutoExpandContentUbcEventLog: " + jsonObject);
            }
        } catch (JSONException e2) {
            Log.e(TAG, "makeAutoExpandContentUbcEventLog: " + Log.getStackTraceString(e2));
        }
    }
}
