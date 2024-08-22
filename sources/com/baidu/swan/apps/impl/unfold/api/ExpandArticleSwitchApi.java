package com.baidu.swan.apps.impl.unfold.api;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.api.base.ISwanApi;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.base.SwanBaseApi;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.impl.unfold.SwanUnFoldSwitchSharedPrefs;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.event.SwanAppUBCBaseEvent;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExpandArticleSwitchApi extends SwanBaseApi {
    private static final String API_COUNT_EXPAND_ARTICLE = "countExpandArticle";
    private static final String API_GET_EXPAND_ARTICLE_SWITCH = "getExpandArticleSwitch";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String EXT_KEY_RESULT = "action_result";
    private static final String EXT_KEY_URL = "url";
    private static final String KEY_ENABLE = "enable";
    private static final String KEY_PATTERN = "pattern";
    private static final String PARAMS_KEY_RESULT = "expandResult";
    private static final String SP_KEY_AUTO_EXPAND_ARTICLE = "SP_KEY_AUTO_EXPAND_ARTICLE";
    private static final String SP_KEY_AUTO_EXPAND_ARTICLE_COUNT = "SP_KEY_AUTO_EXPAND_ARTICLE_COUNT";
    private static final String TAG = "ExpandArticleSwitchApi";
    private static final String VALUE_FROM = "swan";
    private static final String VALUE_PAGE = "landing";
    private static final String VALUE_SOURCE = "auto_expand";
    private static final String VALUE_TYPE = "click";
    private static final String WHITELIST_COUNT_EXPAND_ARTICLE = "swanAPI/countExpandArticle";
    private static final String WHITELIST_GET_EXPAND_ARTICLE_SWITCH = "swanAPI/getExpandArticleSwitch";
    /* access modifiers changed from: private */
    public final SwanUnFoldSwitchSharedPrefs mUnFoldSwitchSP = new SwanUnFoldSwitchSharedPrefs();

    public ExpandArticleSwitchApi(ISwanApiContext swanApiContext) {
        super(swanApiContext);
    }

    public SwanApiResult getExpandArticleSwitch(String params) {
        logInfo("#getExpandArticleSwitch", false);
        return handleParseCommonParam(params, true, true, true, new SwanBaseApi.CommonApiHandler() {
            public SwanApiResult handle(SwanApp swanApp, Activity swanActivity, JSONObject paramsJo, String cb) {
                PMSAppInfo appInfo = swanApp.getInfo().getPmsAppInfo();
                if (appInfo == null) {
                    if (ExpandArticleSwitchApi.DEBUG) {
                        Log.d(ExpandArticleSwitchApi.TAG, "getExpandArticleSwitch: appInfo is null");
                    }
                    return new SwanApiResult(1001, "appInfo is null");
                }
                JSONObject data = new JSONObject();
                if (TextUtils.isEmpty(appInfo.expandArticle)) {
                    SwanAppJSONUtils.setValue(data, "enable", false);
                } else {
                    boolean finalResult = true;
                    boolean isSwitchCheck = ExpandArticleSwitchApi.this.mUnFoldSwitchSP.getBoolean(ExpandArticleSwitchApi.SP_KEY_AUTO_EXPAND_ARTICLE, true);
                    if (ExpandArticleSwitchApi.DEBUG) {
                        Log.d(ExpandArticleSwitchApi.TAG, "自动展开全文开关: " + isSwitchCheck);
                    }
                    JSONObject expandArticle = SwanAppJSONUtils.parseString(appInfo.expandArticle);
                    boolean isWhiteEnable = expandArticle.optBoolean("enable");
                    if (!isSwitchCheck || !isWhiteEnable) {
                        finalResult = false;
                    }
                    SwanAppJSONUtils.setValue(data, "enable", Boolean.valueOf(finalResult));
                    if (finalResult) {
                        JSONArray pattern = expandArticle.optJSONArray("pattern");
                        SwanAppJSONUtils.setValue(data, "pattern", pattern != null ? pattern : new JSONArray());
                    }
                }
                if (ExpandArticleSwitchApi.DEBUG) {
                    Log.d(ExpandArticleSwitchApi.TAG, "expandArticle=" + data);
                }
                ExpandArticleSwitchApi.this.invokeCallback(cb, new SwanApiResult(0, data));
                return SwanApiResult.ok();
            }
        });
    }

    public SwanApiResult countExpandArticle(String params) {
        logInfo("#countExpandArticle", false);
        Pair<SwanApiResult, JSONObject> pairResult = parseJson(params);
        if (!((SwanApiResult) pairResult.first).isSuccess() || !((JSONObject) pairResult.second).has(PARAMS_KEY_RESULT) || !((JSONObject) pairResult.second).has("url")) {
            return new SwanApiResult(202, "json str parse fail");
        }
        this.mUnFoldSwitchSP.putLong(SP_KEY_AUTO_EXPAND_ARTICLE_COUNT, 1 + this.mUnFoldSwitchSP.getLong(SP_KEY_AUTO_EXPAND_ARTICLE_COUNT, 0));
        reportUbc((JSONObject) pairResult.second);
        return SwanApiResult.ok();
    }

    private void reportUbc(JSONObject params) {
        SwanAppUBCBaseEvent ubcEvent = new SwanAppUBCBaseEvent();
        ubcEvent.mFrom = "swan";
        ubcEvent.mType = "click";
        ubcEvent.mPage = "landing";
        ubcEvent.mSource = VALUE_SOURCE;
        ubcEvent.addExt("action_result", params.optString(PARAMS_KEY_RESULT));
        ubcEvent.addExt("url", params.optString("url"));
        SwanAppUBCStatistic.onEvent("5897", ubcEvent);
    }

    /* access modifiers changed from: protected */
    public String getLogTag() {
        return TAG;
    }

    /* access modifiers changed from: protected */
    public String getApiModule() {
        return ISwanApi.ExtensionModule.EXPAND_ARTICLE;
    }
}
