package com.baidu.searchbox.search.map.container.common;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.search.basic.utils.SearchUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.search.map.scheme.UnitedSchemePoiDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseAction;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class BaseMapSchemeAction extends UnitedSchemeBaseAction<UnitedSchemePoiDispatcher> {
    protected static final boolean DEBUG = AppConfig.isDebug();
    protected static final String PARAM_KEY_PARAM = "params";
    protected static final String TAG = "BaseMapSchemeHandler";
    /* access modifiers changed from: private */
    public static long sLastHandleTime = 0;

    /* access modifiers changed from: protected */
    public abstract boolean handleSchemeImpl(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap);

    public BaseMapSchemeAction(UnitedSchemePoiDispatcher dispatcher) {
        super(dispatcher);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        Context extractContext;
        if (SystemClock.elapsedRealtime() - sLastHandleTime < 2000) {
            invokeCallback(entity, handler, 0);
            return true;
        }
        HashMap<String, String> params = entity.getParams();
        if (params == null || params.size() <= 0) {
            if (!entity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "no params");
            }
            if (DEBUG) {
                Log.d(TAG, getActionName() + ": params is null or empty");
            }
            invokeCallback(entity, handler, 201);
            return false;
        }
        Context extractContext2 = SearchUtils.convertContextToActivity(context);
        if (extractContext2 == null) {
            extractContext = AppRuntime.getAppContext();
        } else {
            extractContext = extractContext2;
        }
        if (!UiThreadUtils.isOnUiThread()) {
            final Context finalContext = extractContext;
            final UnitedSchemeEntity unitedSchemeEntity = entity;
            final CallbackHandler callbackHandler = handler;
            final HashMap<String, String> hashMap = params;
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (BaseMapSchemeAction.this.handleSchemeImpl(finalContext, unitedSchemeEntity, callbackHandler, hashMap)) {
                        long unused = BaseMapSchemeAction.sLastHandleTime = SystemClock.elapsedRealtime();
                    }
                }
            });
            return true;
        } else if (!handleSchemeImpl(extractContext, entity, handler, params)) {
            return false;
        } else {
            sLastHandleTime = SystemClock.elapsedRealtime();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void invokeCallback(UnitedSchemeEntity entity, CallbackHandler handler, int statusCode) {
        UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(new JSONObject(), statusCode));
    }
}
