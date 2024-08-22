package com.baidu.swan.apps.api.module.topping;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.api.base.ISwanApi;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.base.SwanBaseApi;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.aps.SwanAppApsUtils;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.toppingdata.SwanToppingItemData;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0002*+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0014J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002Ji\u0010 \u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112K\u0010!\u001aG\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00190\"H\u0002J\f\u0010(\u001a\u00020#*\u00020)H\u0002¨\u0006,"}, d2 = {"Lcom/baidu/swan/apps/api/module/topping/SwanToppingApi;", "Lcom/baidu/swan/apps/api/base/SwanBaseApi;", "context", "Lcom/baidu/swan/apps/api/base/ISwanApiContext;", "(Lcom/baidu/swan/apps/api/base/ISwanApiContext;)V", "addTop", "Lcom/baidu/swan/apps/api/result/SwanApiResult;", "params", "", "buildSwanApiResult", "errNo", "", "deleteTop", "getApiModule", "getLogTag", "getScopeId", "scopeType", "Lcom/baidu/swan/apps/api/module/topping/SwanToppingApi$ScopeType;", "invokeFromComponent", "", "getSwanApiResultByDbStatus", "affectRowCount", "getTopList", "getTopStatus", "logInfo", "", "msg", "logcatDebugMsg", "parseAppIdListFromParams", "", "appIds", "Lorg/json/JSONArray;", "parseParamsAndAuthorize", "callback", "Lkotlin/Function3;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "paramsJo", "cb", "toJsonObject", "Lcom/baidu/swan/apps/toppingdata/SwanToppingItemData;", "Companion", "ScopeType", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanToppingApi.kt */
public final class SwanToppingApi extends SwanBaseApi {
    private static final String API_ADD_TOP = "addTop";
    private static final String API_DELETE_TOP = "deleteTop";
    private static final String API_GET_TOP_LIST = "getTopList";
    private static final String API_GET_TOP_STATUS = "getTopStatus";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ERR_DATABASE_ERROR = 1005;
    private static final int ERR_EXCEED_MAX_QUANTITY = 1003;
    private static final int ERR_OFFLINE_APP_ID = 1002;
    private static final int ERR_OPERATION_FAILED = 1004;
    private static final String KEY_APP_ID = "appid";
    private static final String KEY_FRAME_TYPE = "frameType";
    private static final String KEY_ICON_URL = "iconUrl";
    private static final String KEY_IS_TOP = "isTop";
    private static final String KEY_LIVE_SCHEME = "liveScheme";
    private static final String KEY_LIVE_START_TIME = "liveStartTime";
    private static final String KEY_LIVE_STATUS = "liveStatus";
    private static final String KEY_PAY_PROTECTED = "payProtected";
    private static final String KEY_SWAN_APP_TITLE = "title";
    private static final String KEY_TOPS = "tops";
    private static final String MSG_DATABASE_ERROR = "top operation failed，database error";
    private static final String MSG_EXCEED_MAX_QUANTITY = "addTop failed, exceeded the maximum quantity";
    private static final String MSG_OFFLINE_APP_ID = "top operation failed, app is not released";
    private static final String MSG_OPERATION_FAILED = "top operation failed, appid item or app is invalid，or fetch app meta failed";
    private static final String TAG = "SwanToppingApi";
    private static final String WHITE_NAME_ADD_TOP = "swanAPI/addTop";
    private static final String WHITE_NAME_DELETE_TOP = "swanAPI/deleteTop";
    private static final String WHITE_NAME_GET_TOP_LIST = "swanAPI/getTopList";
    private static final String WHITE_NAME_GET_TOP_STATUS = "swanAPI/getTopStatus";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/swan/apps/api/module/topping/SwanToppingApi$ScopeType;", "", "(Ljava/lang/String;I)V", "TYPE_COMPONENT", "TYPE_API", "TYPE_USE_INVOKE_FROM", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SwanToppingApi.kt */
    private enum ScopeType {
        TYPE_COMPONENT,
        TYPE_API,
        TYPE_USE_INVOKE_FROM
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SwanToppingApi.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScopeType.values().length];
            iArr[ScopeType.TYPE_COMPONENT.ordinal()] = 1;
            iArr[ScopeType.TYPE_API.ordinal()] = 2;
            iArr[ScopeType.TYPE_USE_INVOKE_FROM.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwanToppingApi(ISwanApiContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/swan/apps/api/module/topping/SwanToppingApi$Companion;", "", "()V", "API_ADD_TOP", "", "API_DELETE_TOP", "API_GET_TOP_LIST", "API_GET_TOP_STATUS", "ERR_DATABASE_ERROR", "", "ERR_EXCEED_MAX_QUANTITY", "ERR_OFFLINE_APP_ID", "ERR_OPERATION_FAILED", "KEY_APP_ID", "KEY_FRAME_TYPE", "KEY_ICON_URL", "KEY_IS_TOP", "KEY_LIVE_SCHEME", "KEY_LIVE_START_TIME", "KEY_LIVE_STATUS", "KEY_PAY_PROTECTED", "KEY_SWAN_APP_TITLE", "KEY_TOPS", "MSG_DATABASE_ERROR", "MSG_EXCEED_MAX_QUANTITY", "MSG_OFFLINE_APP_ID", "MSG_OPERATION_FAILED", "TAG", "WHITE_NAME_ADD_TOP", "WHITE_NAME_DELETE_TOP", "WHITE_NAME_GET_TOP_LIST", "WHITE_NAME_GET_TOP_STATUS", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SwanToppingApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public String getLogTag() {
        return TAG;
    }

    /* access modifiers changed from: protected */
    public String getApiModule() {
        return ISwanApi.TOPPING;
    }

    public final SwanApiResult getTopStatus(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        logInfo$default(this, "#getTopStatus", (String) null, 2, (Object) null);
        return parseParamsAndAuthorize(params, ScopeType.TYPE_COMPONENT, new SwanToppingApi$getTopStatus$1(this));
    }

    public final SwanApiResult addTop(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        logInfo("#addTop", params);
        return parseParamsAndAuthorize$default(this, params, (ScopeType) null, new SwanToppingApi$addTop$1(this), 2, (Object) null);
    }

    public final SwanApiResult deleteTop(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        logInfo("#deleteTop", params);
        return parseParamsAndAuthorize$default(this, params, (ScopeType) null, new SwanToppingApi$deleteTop$1(this), 2, (Object) null);
    }

    public final SwanApiResult getTopList(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        logInfo$default(this, "#getTopList", (String) null, 2, (Object) null);
        return parseParamsAndAuthorize(params, ScopeType.TYPE_API, new SwanToppingApi$getTopList$1(this));
    }

    static /* synthetic */ SwanApiResult parseParamsAndAuthorize$default(SwanToppingApi swanToppingApi, String str, ScopeType scopeType, Function3 function3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            scopeType = ScopeType.TYPE_USE_INVOKE_FROM;
        }
        return swanToppingApi.parseParamsAndAuthorize(str, scopeType, function3);
    }

    private final SwanApiResult parseParamsAndAuthorize(String params, ScopeType scopeType, Function3<? super JSONObject, ? super Boolean, ? super String, Unit> callback) {
        SwanApiResult handleParseCommonParam = handleParseCommonParam(params, true, false, true, new SwanToppingApi$$ExternalSyntheticLambda1(this, scopeType, callback));
        Intrinsics.checkNotNullExpressionValue(handleParseCommonParam, "handleParseCommonParam(p…nApiResult.ok()\n        }");
        return handleParseCommonParam;
    }

    /* access modifiers changed from: private */
    /* renamed from: parseParamsAndAuthorize$lambda-2  reason: not valid java name */
    public static final SwanApiResult m7872parseParamsAndAuthorize$lambda2(SwanToppingApi this$0, ScopeType $scopeType, Function3 $callback, SwanApp swanApp, Activity activity, JSONObject paramsJo, String cb) {
        SwanToppingApi swanToppingApi = this$0;
        ScopeType scopeType = $scopeType;
        JSONObject jSONObject = paramsJo;
        Intrinsics.checkNotNullParameter(swanToppingApi, "this$0");
        Intrinsics.checkNotNullParameter(scopeType, "$scopeType");
        Intrinsics.checkNotNullParameter($callback, "$callback");
        Intrinsics.checkNotNullParameter(jSONObject, "paramsJo");
        boolean invokeFromComponent = TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
        swanApp.getSetting().checkOrAuthorize(SwanAppRuntime.getAppContext(), swanToppingApi.getScopeId(scopeType, invokeFromComponent), new SwanToppingApi$$ExternalSyntheticLambda0(this$0, cb, $callback, paramsJo, invokeFromComponent));
        return SwanApiResult.ok();
    }

    /* access modifiers changed from: private */
    /* renamed from: parseParamsAndAuthorize$lambda-2$lambda-1  reason: not valid java name */
    public static final void m7873parseParamsAndAuthorize$lambda2$lambda1(SwanToppingApi this$0, String $cb, Function3 $callback, JSONObject $paramsJo, boolean $invokeFromComponent, TaskResult it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($callback, "$callback");
        Intrinsics.checkNotNullParameter($paramsJo, "$paramsJo");
        if (!OAuthUtils.isAuthorizeOk(it)) {
            int errCode = it.getErrorCode();
            this$0.invokeCallback($cb, new SwanApiResult(errCode, OAuthUtils.getErrorMessage(errCode)));
            return;
        }
        ExecutorUtilsExt.postOnElastic(new SwanToppingApi$$ExternalSyntheticLambda2($callback, $paramsJo, $invokeFromComponent, $cb), TAG, 3);
    }

    /* access modifiers changed from: private */
    /* renamed from: parseParamsAndAuthorize$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m7874parseParamsAndAuthorize$lambda2$lambda1$lambda0(Function3 $callback, JSONObject $paramsJo, boolean $invokeFromComponent, String $cb) {
        Intrinsics.checkNotNullParameter($callback, "$callback");
        Intrinsics.checkNotNullParameter($paramsJo, "$paramsJo");
        Boolean valueOf = Boolean.valueOf($invokeFromComponent);
        Intrinsics.checkNotNullExpressionValue($cb, "cb");
        $callback.invoke($paramsJo, valueOf, $cb);
    }

    static /* synthetic */ void logInfo$default(SwanToppingApi swanToppingApi, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        swanToppingApi.logInfo(str, str2);
    }

    private final void logInfo(String msg, String logcatDebugMsg) {
        logInfo(msg, false);
    }

    private final String getScopeId(ScopeType scopeType, boolean invokeFromComponent) {
        switch (WhenMappings.$EnumSwitchMapping$0[scopeType.ordinal()]) {
            case 1:
                return ScopeInfo.SCOPE_ID_OPERATE_TOPPING;
            case 2:
                return ScopeInfo.SCOPE_ID_BULK_OPERATE_TOPPING;
            case 3:
                return invokeFromComponent ? ScopeInfo.SCOPE_ID_OPERATE_TOPPING : ScopeInfo.SCOPE_ID_BULK_OPERATE_TOPPING;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final SwanApiResult getSwanApiResultByDbStatus(int affectRowCount) {
        switch (affectRowCount) {
            case -2:
                return buildSwanApiResult(1003);
            case -1:
                return buildSwanApiResult(1004);
            case 0:
                return buildSwanApiResult(1005);
            default:
                SwanApiResult ok = SwanApiResult.ok();
                Intrinsics.checkNotNullExpressionValue(ok, "ok()");
                return ok;
        }
    }

    /* access modifiers changed from: private */
    public final SwanApiResult buildSwanApiResult(int errNo) {
        switch (errNo) {
            case 1002:
                return new SwanApiResult(1002, MSG_OFFLINE_APP_ID);
            case 1003:
                return new SwanApiResult(1003, MSG_EXCEED_MAX_QUANTITY);
            case 1004:
                return new SwanApiResult(1004, MSG_OPERATION_FAILED);
            case 1005:
                return new SwanApiResult(1005, MSG_DATABASE_ERROR);
            default:
                return new SwanApiResult(1001);
        }
    }

    /* access modifiers changed from: private */
    public final List<String> parseAppIdListFromParams(JSONArray appIds) {
        if (appIds == null || appIds.length() == 0) {
            return null;
        }
        ArrayList appIdList = new ArrayList();
        int length = appIds.length();
        for (int i2 = 0; i2 < length; i2++) {
            String appId = appIds.optString(i2);
            CharSequence charSequence = appId;
            if ((charSequence == null || charSequence.length() == 0) || SwanAppApsUtils.getAppTypeByAppKey(appId) != 0) {
                return null;
            }
            appIdList.add(appId);
        }
        return appIdList;
    }

    /* access modifiers changed from: private */
    public final JSONObject toJsonObject(SwanToppingItemData $this$toJsonObject) {
        JSONObject json = new JSONObject();
        SwanAppJSONUtils.setValue(json, "appid", $this$toJsonObject.getAppKey());
        SwanAppJSONUtils.setValue(json, "iconUrl", $this$toJsonObject.getIconUrl());
        SwanAppJSONUtils.setValue(json, "title", $this$toJsonObject.getAppName());
        SwanAppJSONUtils.setValue(json, "frameType", Integer.valueOf($this$toJsonObject.getAppFrameType()));
        SwanAppJSONUtils.setValue(json, "payProtected", Integer.valueOf($this$toJsonObject.getPayProtected()));
        boolean liveNow = $this$toJsonObject.isLiveNow();
        SwanAppJSONUtils.setValue(json, KEY_LIVE_STATUS, Integer.valueOf(liveNow));
        if (liveNow) {
            SwanAppJSONUtils.setValue(json, KEY_LIVE_START_TIME, Long.valueOf($this$toJsonObject.getLiveStartTime()));
            SwanAppJSONUtils.setValue(json, KEY_LIVE_SCHEME, $this$toJsonObject.getLiveScheme());
        }
        SwanAppJSONUtils.setValue(json, "rootSource", $this$toJsonObject.getRootSource());
        return json;
    }
}
