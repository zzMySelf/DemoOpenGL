package com.baidu.swan.card.api.modules.interaction;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.card.api.base.CardApiResult;
import com.baidu.swan.card.api.base.ICardApiContext;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.launch.dispatcher.SwanCardEventDispatcher;
import com.baidu.swan.card.launch.model.SwanEvents;
import com.baidu.swan.card.pkg.config.SwanCardConfigData;
import com.baidu.swan.card.pkg.model.SwanEvent;
import com.baidu.swan.card.utils.SwanCardLog;
import com.baidu.swan.card.utils.SwanCardUtil;
import org.json.JSONObject;

public class NavigationBarApi extends AbsInteractionApi {
    private static final String ACTION_HIDE_NAVIGATION_BAR_COLOR = "hideNavigationBarLoading";
    private static final String ACTION_SET_NAVIGATION_BAR_COLOR = "setNavigationBarColor";
    private static final String ACTION_SET_NAVIGATION_BAR_TITLE = "setNavigationBarTitle";
    private static final String ACTION_SHOW_NAVIGATION_BAR_LOADING = "showNavigationBarLoading";
    public static final String ANIMATION = "animation";
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String DURATION = "duration";
    public static final String FRONT_COLOR = "frontColor";
    private static final String TAG = "NavigationBarApi";
    public static final String TIMING_FUNC = "timingFunc";
    public static final String TITLE = "title";
    private static final String WHITELIST_HIDE_NAVIGATION_BAR_COLOR = "swanAPI/hideNavigationBarLoading";
    private static final String WHITELIST_SET_NAVIGATION_BAR_COLOR = "swanAPI/setNavigationBarColor";
    private static final String WHITELIST_SET_NAVIGATION_BAR_TITLE = "swanAPI/setNavigationBarTitle";
    private static final String WHITELIST_SHOW_NAVIGATION_BAR_LOADING = "swanAPI/showNavigationBarLoading";

    public NavigationBarApi(ICardApiContext swanApiContext) {
        super(swanApiContext);
    }

    public String getLogTag() {
        return TAG;
    }

    public CardApiResult setNavigationBarTitle(String params) {
        logInfo("#setNavigationBarTitle", false);
        Pair<CardApiResult, JSONObject> pairResult = parseJson(params);
        CardApiResult parseResult = (CardApiResult) pairResult.first;
        if (!parseResult.isSuccess()) {
            return parseResult;
        }
        JSONObject paramsJson = (JSONObject) pairResult.second;
        SwanCard swanCard = getCardOrNull(paramsJson);
        if (swanCard == null) {
            return CardApiResult.cardIsNull();
        }
        String callback = paramsJson.optString("cb");
        if (TextUtils.isEmpty(callback)) {
            logError("cb is empty", (Throwable) null, true);
            return new CardApiResult(1001, "cb is empty");
        }
        updateActionBar(swanCard.getCardId(), (String) null, (String) null, paramsJson.optString("title"));
        invokeCallback(callback, new CardApiResult(0));
        return CardApiResult.ok();
    }

    public CardApiResult setNavigationBarColor(String params) {
        logInfo("#setNavigationBarColor", false);
        Pair<CardApiResult, JSONObject> pairResult = parseJson(params);
        CardApiResult parseResult = (CardApiResult) pairResult.first;
        if (!parseResult.isSuccess()) {
            return parseResult;
        }
        JSONObject paramsJson = (JSONObject) pairResult.second;
        if (getCardOrNull(paramsJson) == null) {
            return CardApiResult.cardIsNull();
        }
        String callback = paramsJson.optString("cb");
        if (TextUtils.isEmpty(callback)) {
            logError("cb is empty", (Throwable) null, true);
            return new CardApiResult(1001, "cb is empty");
        }
        final JSONObject jSONObject = paramsJson;
        final String str = callback;
        final String optString = paramsJson.optString("frontColor");
        final String optString2 = paramsJson.optString("backgroundColor");
        SwanCardUtil.runOnUiThread(new Runnable() {
            public void run() {
                SwanCard swanCard = NavigationBarApi.this.getCardOrNull(jSONObject);
                if (swanCard == null) {
                    NavigationBarApi.this.invokeCallback(str, CardApiResult.cardIsNull());
                } else if (SwanCardManager.get().getCurCardPage(swanCard.getCardId()) == null) {
                    SwanCardLog.e(NavigationBarApi.TAG, "top cardPage null");
                    NavigationBarApi.this.invokeCallback(str, new CardApiResult(1001));
                } else {
                    NavigationBarApi.this.updateActionBar(swanCard.getCardId(), optString, optString2, (String) null);
                    NavigationBarApi.this.invokeCallback(str, new CardApiResult(0));
                }
            }
        });
        return CardApiResult.ok();
    }

    /* access modifiers changed from: private */
    public void updateActionBar(String cardId, String frontColor, String backgroundColor, String title) {
        SwanEvent.Impl barUpdate = new SwanEvent.Impl(SwanEvents.ActionBarUpdate.EVENT_NAME);
        if (!TextUtils.isEmpty(frontColor)) {
            barUpdate.putInt("txtColor", SwanCardConfigData.parseColor(frontColor));
        }
        if (TextUtils.isEmpty(backgroundColor) == 0) {
            barUpdate.putInt("bgColor", SwanCardConfigData.parseColor(backgroundColor));
        }
        if (TextUtils.isEmpty(title) == 0) {
            barUpdate.putString("title", title);
        }
        SwanCardEventDispatcher.dispatchEvent(cardId, barUpdate);
    }
}
