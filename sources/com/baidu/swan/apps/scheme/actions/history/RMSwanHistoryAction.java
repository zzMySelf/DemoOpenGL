package com.baidu.swan.apps.scheme.actions.history;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.database.history.SwanAppHistoryHelper;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.env.statistic.PurgerStatistic;
import com.baidu.swan.apps.env.statistic.PurgerUBC;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.messaging.client.SwanAppMessengerClient;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.setting.SwanAppSetting;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import org.json.JSONObject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RMSwanHistoryAction extends SwanAppAction {
    private static final String ACTION_TYPE = "/swanAPI/deleteHistory";
    private static final String KEY_IS_SUCCESS = "success";
    private static final String MODULE_TAG = "history";
    private static final String PARAMS_KEY_APP_ID = "appid";
    private static final String PARAMS_KEY_APP_KEY = "appKey";
    private static final String PARAMS_KEY_TYPE = "type";
    private static final String PARAMS_KEY_VERSION = "version";
    private static final String VALUE_FAILED = "0";
    private static final String VALUE_SUCCESS = "1";

    public RMSwanHistoryAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        UnitedSchemeEntity unitedSchemeEntity = entity;
        if (swanApp == null) {
            SwanAppLog.e("history", "none swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty swanApp");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty swanApp");
            return false;
        }
        JSONObject joParams = UnitedSchemeUtility.optParamsAsJo(entity);
        if (joParams == null) {
            SwanAppLog.e("history", "empty joParams");
            if (DEBUG) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty joParams");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        String cb = joParams.optString("cb");
        if (TextUtils.isEmpty(cb)) {
            SwanAppLog.e("history", "empty cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "RMSwanHistory --- empty cb");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
            return false;
        }
        String appId = joParams.optString("appid");
        String appKey = joParams.optString("appKey");
        String version = joParams.optString("version");
        String type = joParams.optString("type");
        if (!TextUtils.isEmpty(appId) || !TextUtils.isEmpty(appKey)) {
            final CallbackHandler callbackHandler = handler;
            final String str = cb;
            final UnitedSchemeEntity unitedSchemeEntity2 = entity;
            final String str2 = appId;
            final String str3 = appKey;
            AnonymousClass1 r10 = r0;
            final String str4 = version;
            JSONObject jSONObject = joParams;
            SwanAppSetting setting = swanApp.getSetting();
            final String str5 = type;
            AnonymousClass1 r0 = new TypedCallback<TaskResult<Authorize.Result>>() {
                public void onCallback(TaskResult<Authorize.Result> result) {
                    if (!OAuthUtils.isAuthorizeOk(result)) {
                        OAuthUtils.processPermissionDeny(result, callbackHandler, str);
                    } else {
                        RMSwanHistoryAction.this.handleRemoveHistory(unitedSchemeEntity2, callbackHandler, str2, str3, str4, str5, str);
                    }
                }
            };
            setting.checkOrAuthorize(context, "mapp_i_delete_history", r10);
            UnitedSchemeUtility.callCallback(handler, unitedSchemeEntity, 0);
            return true;
        }
        SwanAppLog.e("history", "empty appKey");
        if (DEBUG) {
            Log.d("SwanAppAction", "RMSwanHistory --- empty appKey");
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty appId");
        return false;
    }

    /* access modifiers changed from: private */
    public void handleRemoveHistory(UnitedSchemeEntity entity, CallbackHandler handler, String appId, String appKey, String version, String type, String cb) {
        SwanAppLog.i("history", "start remove history");
        PurgerStatistic.PurgerTracer finalTracer = PurgerUBC.track().updateScenesTypeDefault(4).tracer();
        final String str = appId;
        final String str2 = version;
        final String str3 = type;
        final PurgerStatistic.PurgerTracer purgerTracer = finalTracer;
        final PurgerStatistic.PurgerTracer purgerTracer2 = finalTracer;
        final CallbackHandler callbackHandler = handler;
        final UnitedSchemeEntity unitedSchemeEntity = entity;
        final String str4 = cb;
        Observable.just(appKey).subscribeOn(Schedulers.io()).map(new Func1<String, Boolean>() {
            public Boolean call(String appKey) {
                return Boolean.valueOf(SwanAppHistoryHelper.deleteHistory(AppRuntime.getAppContext().getContentResolver(), str, appKey, str2, str3, false, purgerTracer));
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Boolean>() {
            public void call(Boolean isSuccess) {
                SwanApp swanApp;
                SwanAppMessengerClient messengerClient;
                if (isSuccess.booleanValue()) {
                    if (!(TextUtils.isEmpty(str) || (swanApp = SwanApp.get()) == null || (messengerClient = swanApp.getMsgClient()) == null)) {
                        messengerClient.sendMessage(8, (SwanAppIPCData) new SwanAppDeleteInfo(str).setPurgerScenes(PurgerUBC.track(purgerTracer2).getScenesType()));
                    }
                    SwanAppLog.i("history", "remove success");
                    if (RMSwanHistoryAction.DEBUG) {
                        Log.d("SwanAppAction", "RMSwanHistory --- success & appid : " + str);
                    }
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(SwanAppJSONUtils.newJSONObject("success", "1"), 0).toString(), str4);
                    return;
                }
                SwanAppLog.w("history", "execute fail --- no match app id");
                if (RMSwanHistoryAction.DEBUG) {
                    Log.d("SwanAppAction", "RMSwanHistory --- no match app id");
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "no match app id").toString(), str4);
            }
        });
    }
}
