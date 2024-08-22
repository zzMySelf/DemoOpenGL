package com.baidu.searchbox.aisearch.scheme;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.URLUtil;
import com.baidu.browser.Browser;
import com.baidu.browser.utils.SearchChatUtilsKt;
import com.baidu.searchbox.aibot.AIBotLaunchParams;
import com.baidu.searchbox.aibot.AIBotManager;
import com.baidu.searchbox.aisearch.AISearchPreloadParams;
import com.baidu.searchbox.aisearch.PreloadScene;
import com.baidu.searchbox.aisearch.comps.conversation.preload.ConversationPreloadManager;
import com.baidu.searchbox.aisearch.comps.conversation.preload.PreloadSceneConfig;
import com.baidu.searchbox.aisearch.comps.page.AISearchPageComp;
import com.baidu.searchbox.aisearch.comps.page.AISearchPageParams;
import com.baidu.searchbox.aisearch.comps.page.AISearchTab;
import com.baidu.searchbox.aisearch.config.conversation.ConversationConfig;
import com.baidu.searchbox.aisearch.config.global.GlobalConfig;
import com.baidu.searchbox.aisearch.config.inspiration.InspirationConfig;
import com.baidu.searchbox.aisearch.runtime.IAISearchRouter;
import com.baidu.searchbox.aisearch.runtime.IAISearchSpeedStat;
import com.baidu.searchbox.aisearch.store.AISearchHostDebugStore;
import com.baidu.searchbox.aisearch.utils.AISearchDebugUtils;
import com.baidu.searchbox.aisearch.utils.LoginUtilsKt;
import com.baidu.searchbox.aisearch.yalog.AISearchYalog;
import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseAction;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemePriorityDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002J0\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002J0\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J0\u0010\u001b\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J0\u0010\u001c\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u001f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010!\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\"\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010#\u001a\u00020\u0010H\u0002J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010(\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\nH\u0002¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/aisearch/scheme/OpenAISearchAction;", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeBaseAction;", "Lcom/baidu/searchbox/aisearch/scheme/UnitedSchemeAISearchDispatcher;", "dispatcher", "(Lcom/baidu/searchbox/aisearch/scheme/UnitedSchemeAISearchDispatcher;)V", "buildAISearchPageParams", "Lcom/baidu/searchbox/aisearch/comps/page/AISearchPageParams;", "json", "Lorg/json/JSONObject;", "buildInspirationUrl", "", "buildUrl", "isFromNa", "", "chatUrl", "callback", "", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "statusCode", "", "paramsJson", "executeCmd", "context", "Landroid/content/Context;", "executeDegradedCmd", "executeReuseUrlCmd", "getActionName", "getSpeedStatPage", "handle", "onStartSpeedStats", "openAISearchBotContainer", "openAISearchContainer", "preloadWhenOpenContainer", "validScheme", "cmd", "validUrlHost", "urlStr", "validUrlParam", "CallbackHandlerImpl", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenAISearchAction.kt */
public final class OpenAISearchAction extends UnitedSchemeBaseAction<UnitedSchemeAISearchDispatcher> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OpenAISearchAction(UnitedSchemeAISearchDispatcher dispatcher) {
        super(dispatcher);
        Intrinsics.checkNotNullParameter(dispatcher, UnitedSchemePriorityDispatcher.SCHEME_PATH_DISPATCHER);
    }

    public String getActionName() {
        return "open";
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        Object obj;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        HashMap params = entity != null ? entity.getParams() : null;
        if (OpenAISearchActionKt.DEBUG) {
            Log.d("OpenAISearchAction", "handleScheme:" + params);
        }
        boolean z = true;
        if (params == null || params.size() <= 0) {
            if (entity == null || entity.isOnlyVerify()) {
                z = false;
            }
            if (z) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "no params");
            }
            callback$default(this, handler, entity, 201, (JSONObject) null, 8, (Object) null);
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            OpenAISearchAction openAISearchAction = this;
            String $this$handle_u24lambda_u2d1_u24lambda_u2d0 = params.get("params");
            if ($this$handle_u24lambda_u2d1_u24lambda_u2d0 != null) {
                jSONObject = new JSONObject($this$handle_u24lambda_u2d1_u24lambda_u2d0);
            } else {
                jSONObject = null;
            }
            obj = Result.m8971constructorimpl(jSONObject);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m8977isFailureimpl(obj)) {
            jSONObject2 = obj;
        }
        JSONObject json = jSONObject2;
        if (json == null) {
            callback$default(this, handler, entity, 202, (JSONObject) null, 8, (Object) null);
            return false;
        }
        if (!(json.optInt("outside", 0) == 1)) {
            onStartSpeedStats(json);
        }
        if (!GlobalConfig.INSTANCE.getUseNAContainer()) {
            AISearchYalog.INSTANCE.e("OpenAISearchAction", "update switch: use h5 container");
            return executeCmd(context, handler, entity, json);
        }
        String url = JSONExtKt.optStringIgnoreNulls(json, "url", "");
        if (!validUrlParam(url) || !validUrlHost(url)) {
            AISearchYalog.INSTANCE.e("OpenAISearchAction", "param: url error: " + JSONExtKt.optStringIgnoreNulls(json, "url", ""));
            return executeCmd(context, handler, entity, json);
        } else if (!GlobalConfig.INSTANCE.getSupportLogout() && !LoginUtilsKt.isLogin()) {
            AISearchYalog.INSTANCE.e("OpenAISearchAction", "user no login");
            return executeCmd(context, handler, entity, json);
        } else if (!openAISearchContainer(context, json)) {
            AISearchYalog.INSTANCE.e("OpenAISearchAction", "openAISearchContainer error");
            return executeCmd(context, handler, entity, json);
        } else {
            callback(handler, entity, 0, json);
            return true;
        }
    }

    private final void onStartSpeedStats(JSONObject json) {
        IAISearchSpeedStat $this$onStartSpeedStats_u24lambda_u2d2 = IAISearchSpeedStat.Companion.getImpl();
        String page = getSpeedStatPage(json);
        String from = JSONExtKt.optStringIgnoreNulls(json, "from", "");
        $this$onStartSpeedStats_u24lambda_u2d2.updateStatistic(page, "onDispatch");
        if (from.length() > 0) {
            $this$onStartSpeedStats_u24lambda_u2d2.updateStatistic(page, "source", from);
        }
        $this$onStartSpeedStats_u24lambda_u2d2.updateStatistic(page, "containerType", "0");
    }

    static /* synthetic */ void callback$default(OpenAISearchAction openAISearchAction, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, int i2, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            jSONObject = null;
        }
        openAISearchAction.callback(callbackHandler, unitedSchemeEntity, i2, jSONObject);
    }

    private final void callback(CallbackHandler handler, UnitedSchemeEntity entity, int statusCode, JSONObject paramsJson) {
        UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(new JSONObject(), statusCode));
        if (entity != null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(statusCode);
        }
        if (entity != null) {
            IAISearchSpeedStat.Companion.getImpl().statInvokeStatus(getSpeedStatPage(paramsJson), entity, statusCode);
        }
    }

    private final boolean openAISearchContainer(Context context, JSONObject json) {
        if (context == null) {
            return false;
        }
        String page = getSpeedStatPage(json);
        IAISearchSpeedStat $this$openAISearchContainer_u24lambda_u2d3 = IAISearchSpeedStat.Companion.getImpl();
        String isLogin = "1";
        $this$openAISearchContainer_u24lambda_u2d3.updateStatistic(page, "user_status", isLogin);
        if (!LoginUtilsKt.isLogin()) {
            isLogin = "0";
        }
        $this$openAISearchContainer_u24lambda_u2d3.updateStatistic(page, "isLogin", isLogin);
        String optStringIgnoreNulls = JSONExtKt.optStringIgnoreNulls(json, "pageType", "main");
        if (Intrinsics.areEqual((Object) optStringIgnoreNulls, (Object) "main")) {
            if (OpenAISearchActionKt.DEBUG) {
                Log.d("OpenAISearchAction", "打开主bot，快速过滤开关为：" + GlobalConfig.INSTANCE.getFilterFastOpen());
            }
            if (!GlobalConfig.INSTANCE.getFilterFastOpen() || SystemClock.elapsedRealtime() - OpenAISearchActionKt.mainBotLastOpenTime >= 1000) {
                AISearchPageParams pageParams = buildAISearchPageParams(json);
                if (pageParams == null) {
                    return false;
                }
                preloadWhenOpenContainer();
                boolean result = IAISearchRouter.Companion.getImpl().launchAISearch(context, pageParams);
                if (result) {
                    OpenAISearchActionKt.mainBotLastOpenTime = SystemClock.elapsedRealtime();
                }
                return result;
            } else if (!OpenAISearchActionKt.DEBUG) {
                return true;
            } else {
                Log.d("OpenAISearchAction", "打开主bot，快速点击被过滤");
                return true;
            }
        } else if (Intrinsics.areEqual((Object) optStringIgnoreNulls, (Object) "bot")) {
            return openAISearchBotContainer(context, json);
        } else {
            return false;
        }
    }

    private final void preloadWhenOpenContainer() {
        long start = System.currentTimeMillis();
        if (PreloadSceneConfig.INSTANCE.isSceneActive(PreloadScene.OPENING)) {
            ConversationPreloadManager.INSTANCE.preloadOnMainThread$lib_aisearch_impl_release(new AISearchPreloadParams(PreloadScene.OPENING, (String) null, 2, (DefaultConstructorMarker) null));
        }
        long end = System.currentTimeMillis();
        if (OpenAISearchActionKt.DEBUG) {
            Log.d("OpenAISearchAction", "start=" + start + ", end=" + end + ", cost=" + (end - start));
        }
    }

    private final boolean openAISearchBotContainer(Context context, JSONObject json) {
        String str;
        if (context == null || json == null) {
            return false;
        }
        String $this$openAISearchBotContainer_u24lambda_u2d4 = buildUrl$default(this, json, true, (String) null, 4, (Object) null);
        if ($this$openAISearchBotContainer_u24lambda_u2d4 == null) {
            str = null;
        } else if (OpenAISearchActionKt.DEBUG) {
            str = AISearchDebugUtils.INSTANCE.replaceHost($this$openAISearchBotContainer_u24lambda_u2d4, AISearchHostDebugStore.INSTANCE.getDebugWebUrl());
        } else {
            str = $this$openAISearchBotContainer_u24lambda_u2d4;
        }
        String url = str;
        CharSequence charSequence = url;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        json.put("url", url);
        AIBotManager aiBotManager = AIBotManager.Companion.getOrNull();
        if (aiBotManager == null) {
            return false;
        }
        return aiBotManager.launchAIBot(context, AIBotLaunchParams.Companion.create(json));
    }

    private final String getSpeedStatPage(JSONObject json) {
        AISearchTab tab;
        String optStringIgnoreNulls = JSONExtKt.optStringIgnoreNulls(json, "pageType", "main");
        if (Intrinsics.areEqual((Object) optStringIgnoreNulls, (Object) "main")) {
            String optStringIgnoreNulls2 = JSONExtKt.optStringIgnoreNulls(json, "tab", "");
            if (Intrinsics.areEqual((Object) optStringIgnoreNulls2, (Object) AISearchTab.CHAT.getTabId())) {
                tab = AISearchTab.CHAT;
            } else if (Intrinsics.areEqual((Object) optStringIgnoreNulls2, (Object) AISearchTab.INSPIRATION.getTabId())) {
                tab = AISearchTab.INSPIRATION;
            } else {
                tab = AISearchPageComp.Companion.getCurrentTab();
            }
            return tab == AISearchTab.CHAT ? "aisearch" : "aisearch_inspiration";
        } else if (Intrinsics.areEqual((Object) optStringIgnoreNulls, (Object) "bot")) {
            return "aibot";
        } else {
            return "";
        }
    }

    private final AISearchPageParams buildAISearchPageParams(JSONObject json) {
        String str;
        String str2;
        JSONObject jSONObject = json;
        String str3 = null;
        if (jSONObject == null) {
            return null;
        }
        String tab = JSONExtKt.optStringIgnoreNulls(jSONObject, "tab", "");
        String conversationUrl = null;
        String str4 = null;
        boolean z = true;
        if (Intrinsics.areEqual((Object) tab, (Object) "")) {
            conversationUrl = buildUrl$default(this, json, true, (String) null, 4, (Object) null);
            str4 = InspirationConfig.INSTANCE.getInspirationUrl();
            tab = AISearchPageComp.Companion.getCurrentTab().getTabId();
        } else if (Intrinsics.areEqual((Object) tab, (Object) AISearchTab.CHAT.getTabId())) {
            conversationUrl = buildUrl$default(this, json, true, (String) null, 4, (Object) null);
            str4 = InspirationConfig.INSTANCE.getInspirationUrl();
        } else if (Intrinsics.areEqual((Object) tab, (Object) AISearchTab.INSPIRATION.getTabId())) {
            CharSequence conversationUrl2 = ConversationConfig.INSTANCE.getConversationUrl();
            if (conversationUrl2 == null || conversationUrl2.length() == 0) {
                return null;
            }
            conversationUrl = buildUrl(jSONObject, true, ConversationConfig.INSTANCE.getConversationUrl());
            str4 = buildInspirationUrl(json);
        }
        CharSequence charSequence = conversationUrl;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = str4;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                if (OpenAISearchActionKt.DEBUG) {
                    str = AISearchDebugUtils.INSTANCE.replaceHost(conversationUrl, AISearchHostDebugStore.INSTANCE.getDebugWebUrl());
                } else {
                    str = conversationUrl;
                }
                if (OpenAISearchActionKt.DEBUG) {
                    CharSequence debugInspirationUrl = AISearchHostDebugStore.INSTANCE.getDebugInspirationUrl();
                    if (debugInspirationUrl.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        debugInspirationUrl = str4;
                    }
                    str2 = (String) debugInspirationUrl;
                } else {
                    str2 = str4;
                }
                String optStringIgnoreNulls = JSONExtKt.optStringIgnoreNulls(jSONObject, "animation", "");
                String optStringIgnoreNulls2 = JSONExtKt.optStringIgnoreNulls(jSONObject, "from", "");
                String optStringIgnoreNulls3 = JSONExtKt.optStringIgnoreNulls(jSONObject, "statistic", "");
                int optInt = jSONObject.optInt("keyboard", 0);
                int optInt2 = jSONObject.optInt("inputType", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("asyncData");
                if (optJSONObject != null) {
                    str3 = optJSONObject.toString();
                }
                return new AISearchPageParams(str, str2, optStringIgnoreNulls, optStringIgnoreNulls2, optStringIgnoreNulls3, optInt, optInt2, tab, str3);
            }
        }
        return null;
    }

    static /* synthetic */ String buildUrl$default(OpenAISearchAction openAISearchAction, JSONObject jSONObject, boolean z, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        return openAISearchAction.buildUrl(jSONObject, z, str);
    }

    private final String buildUrl(JSONObject json, boolean isFromNa, String chatUrl) {
        JSONObject jSONObject = json;
        Unit unit = null;
        if (jSONObject == null) {
            return null;
        }
        CharSequence charSequence = chatUrl;
        String url = charSequence == null || charSequence.length() == 0 ? JSONExtKt.optStringIgnoreNulls(jSONObject, "url", "") : chatUrl;
        if (!validUrlParam(url)) {
            return null;
        }
        Uri.Builder urlBuilder = Uri.parse(url).buildUpon();
        if (isFromNa) {
            urlBuilder.appendQueryParameter("page_type", "na");
        }
        String from = JSONExtKt.optStringIgnoreNulls(jSONObject, "from", "");
        if (from.length() > 0) {
            urlBuilder.appendQueryParameter("source", from);
        }
        urlBuilder.appendQueryParameter("containerType", "0");
        try {
            Result.Companion companion = Result.Companion;
            JSONObject optJSONObject = jSONObject.optJSONObject(SearchChatUtilsKt.KEY_EXT);
            if (optJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(PARAM_EXT)");
                JSONObject $this$buildUrl_u24lambda_u2d7_u24lambda_u2d6 = optJSONObject;
                Iterator keys = $this$buildUrl_u24lambda_u2d7_u24lambda_u2d6.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    String value = JSONExtKt.optStringIgnoreNulls($this$buildUrl_u24lambda_u2d7_u24lambda_u2d6, key, "");
                    if (value.length() > 0) {
                        urlBuilder.appendQueryParameter(key, value);
                    }
                }
                unit = Unit.INSTANCE;
            }
            Result.m8971constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        return urlBuilder.build().toString();
    }

    private final String buildInspirationUrl(JSONObject json) {
        String url = JSONExtKt.optStringIgnoreNulls(json, "url", "");
        if (!validUrlParam(url)) {
            return null;
        }
        Uri.Builder urlBuilder = Uri.parse(url).buildUpon();
        urlBuilder.appendQueryParameter("source", "aisearch");
        urlBuilder.appendQueryParameter("page_type", "na");
        return urlBuilder.build().toString();
    }

    private final boolean executeCmd(Context context, CallbackHandler handler, UnitedSchemeEntity entity, JSONObject json) {
        if (executeDegradedCmd(context, handler, entity, json)) {
            return true;
        }
        return executeReuseUrlCmd(context, handler, entity, json);
    }

    private final boolean executeDegradedCmd(Context context, CallbackHandler handler, UnitedSchemeEntity entity, JSONObject json) {
        HashMap<String, String> params;
        String $this$executeDegradedCmd_u24lambda_u2d8;
        String str = null;
        String cmd = json != null ? JSONExtKt.optStringIgnoreNulls(json, "degradedCmd", "") : null;
        if (validScheme(cmd)) {
            Uri.Builder scheme = Uri.parse(cmd).buildUpon();
            scheme.appendQueryParameter(Browser.PARAM_KEY_FROM_AI_SEARCH, "1");
            if (!(entity == null || (params = entity.getParams()) == null || ($this$executeDegradedCmd_u24lambda_u2d8 = params.get("callback")) == null)) {
                scheme.appendQueryParameter("callback", $this$executeDegradedCmd_u24lambda_u2d8);
            }
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(scheme.build());
            UnitedSchemeEntity $this$executeDegradedCmd_u24lambda_u2d9 = unitedSchemeEntity;
            $this$executeDegradedCmd_u24lambda_u2d9.setReferUrl(entity != null ? entity.getReferUrl() : null);
            if (entity != null) {
                str = entity.getPageUrl();
            }
            $this$executeDegradedCmd_u24lambda_u2d9.setPageUrl(str);
            return SchemeRouter.invokeScheme(context, unitedSchemeEntity, (CallbackHandler) new CallbackHandlerImpl(this, handler, "degradedCmd"));
        }
        AISearchYalog.INSTANCE.e("OpenAISearchAction", "degradedCmd error: " + cmd);
        return false;
    }

    private final boolean executeReuseUrlCmd(Context context, CallbackHandler handler, UnitedSchemeEntity entity, JSONObject json) {
        HashMap<String, String> params;
        String $this$executeReuseUrlCmd_u24lambda_u2d10;
        String str = null;
        String cmd = json != null ? JSONExtKt.optStringIgnoreNulls(json, "reuseUrlCmd", "") : null;
        String url = buildUrl$default(this, json, false, (String) null, 4, (Object) null);
        CharSequence charSequence = cmd;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = url;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (!z) {
                if (!validScheme(cmd) || !validUrlParam(url)) {
                    callback(handler, entity, 202, json);
                    AISearchYalog.INSTANCE.e("OpenAISearchAction", "executeReuseUrlCmd error: " + cmd + ' ' + url);
                    return false;
                }
                Uri.Builder scheme = Uri.parse(cmd).buildUpon();
                scheme.appendQueryParameter(Browser.PARAM_KEY_FROM_AI_SEARCH, "1");
                scheme.appendQueryParameter("url", url);
                if (!(entity == null || (params = entity.getParams()) == null || ($this$executeReuseUrlCmd_u24lambda_u2d10 = params.get("callback")) == null)) {
                    scheme.appendQueryParameter("callback", $this$executeReuseUrlCmd_u24lambda_u2d10);
                }
                UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(scheme.build());
                UnitedSchemeEntity $this$executeReuseUrlCmd_u24lambda_u2d11 = unitedSchemeEntity;
                $this$executeReuseUrlCmd_u24lambda_u2d11.setReferUrl(entity != null ? entity.getReferUrl() : null);
                if (entity != null) {
                    str = entity.getPageUrl();
                }
                $this$executeReuseUrlCmd_u24lambda_u2d11.setPageUrl(str);
                return SchemeRouter.invokeScheme(context, unitedSchemeEntity, (CallbackHandler) new CallbackHandlerImpl(this, handler, "reuseUrlCmd"));
            }
        }
        callback(handler, entity, 202, json);
        AISearchYalog.INSTANCE.e("OpenAISearchAction", "executeReuseUrlCmd param error: " + cmd + ' ' + url);
        return false;
    }

    private final boolean validUrlParam(String urlStr) {
        if (OpenAISearchActionKt.DEBUG) {
            Log.d("OpenAISearchAction", "validUrlParam " + urlStr);
        }
        CharSequence charSequence = urlStr;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        return URLUtil.isValidUrl(urlStr);
    }

    private final boolean validUrlHost(String urlStr) {
        if (OpenAISearchActionKt.DEBUG) {
            Log.d("OpenAISearchAction", "validUrlHost " + urlStr);
        }
        if (OpenAISearchActionKt.DEBUG && !AISearchHostDebugStore.INSTANCE.getDebugHostEvent()) {
            return true;
        }
        CharSequence charSequence = urlStr;
        if (charSequence == null || charSequence.length() == 0) {
            AISearchYalog.INSTANCE.e("OpenAISearchAction", "validUrlHost urlStr null");
            return false;
        }
        String urlHost = Uri.parse(urlStr).getHost();
        CharSequence charSequence2 = urlHost;
        if (charSequence2 == null || charSequence2.length() == 0) {
            AISearchYalog.INSTANCE.e("OpenAISearchAction", "validUrlHost urlHost null");
            return false;
        }
        List<String> chatHostList = GlobalConfig.INSTANCE.getChatHostList();
        Collection collection = chatHostList;
        if (collection == null || collection.isEmpty()) {
            AISearchYalog.INSTANCE.e("OpenAISearchAction", "validUrlHost hostConfig null");
            return false;
        }
        for (String host : chatHostList) {
            if (Intrinsics.areEqual((Object) urlHost, (Object) host)) {
                return true;
            }
        }
        AISearchYalog.INSTANCE.e("OpenAISearchAction", "validUrlHost hostConfig " + chatHostList);
        return false;
    }

    private final boolean validScheme(String cmd) {
        if (OpenAISearchActionKt.DEBUG) {
            Log.d("OpenAISearchAction", "validScheme " + cmd);
        }
        return UnitedSchemeUtility.isUnitedScheme(cmd);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/aisearch/scheme/OpenAISearchAction$CallbackHandlerImpl;", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "handler", "logTag", "", "(Lcom/baidu/searchbox/aisearch/scheme/OpenAISearchAction;Lcom/baidu/searchbox/unitedscheme/CallbackHandler;Ljava/lang/String;)V", "implRef", "Ljava/lang/ref/WeakReference;", "getCurrentPageUrl", "handleSchemeDispatchCallback", "", "callback", "params", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenAISearchAction.kt */
    private final class CallbackHandlerImpl implements CallbackHandler {
        private final WeakReference<CallbackHandler> implRef;
        private final String logTag;
        final /* synthetic */ OpenAISearchAction this$0;

        public CallbackHandlerImpl(OpenAISearchAction this$02, CallbackHandler handler, String logTag2) {
            Intrinsics.checkNotNullParameter(logTag2, "logTag");
            this.this$0 = this$02;
            this.logTag = logTag2;
            this.implRef = new WeakReference<>(handler);
        }

        public void handleSchemeDispatchCallback(String callback, String params) {
            CallbackHandler callbackHandler = (CallbackHandler) this.implRef.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(callback, params);
            }
            AISearchYalog.INSTANCE.e("OpenAISearchAction", this.logTag + " execute callback：" + params);
        }

        public String getCurrentPageUrl() {
            CallbackHandler callbackHandler = (CallbackHandler) this.implRef.get();
            if (callbackHandler != null) {
                return callbackHandler.getCurrentPageUrl();
            }
            return null;
        }
    }
}
