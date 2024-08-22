package com.baidu.swan.apps.impl.ai.tts.action;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.impl.ai.tts.manager.SwanTTSManager;
import com.baidu.swan.apps.process.delegate.observe.event.SwanAppMessengerObserveEvent;
import com.baidu.swan.apps.process.delegate.observe.observer.SwanAppDefaultMessengerObserver;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SwanTTSAction extends SwanAppAction {
    public static final String ACTION_APPEND = "/swanAPI/tts/appendStream";
    public static final String ACTION_PAUSE = "/swanAPI/tts/pauseStream";
    public static final String ACTION_PLAY = "/swanAPI/tts/playStream";
    public static final String ACTION_RESUME = "/swanAPI/tts/resumeStream";
    public static final String ACTION_STATUS = "/swanAPI/tts/streamStatus";
    public static final String ACTION_STOP = "/swanAPI/tts/stopStream";
    public static final String ACTION_SWAN_PROCESS_HIDE = "swanProcessHide";
    public static final String ACTION_SWAN_PROCESS_SHOW = "swanProcessShow";
    public static final String ACTION_SWAN_PROCESS_SHOWING = "swanProcessShowing";
    /* access modifiers changed from: private */
    public static final Map<String, Pair<String, CallbackHandler>> CALLBACK_HANDLE_MAP = new HashMap();
    public static final String EVENT_NAME_TTS_TAP = "ttsTap";
    public static final String EVENT_PARAM_HAS_TTS_AUTH = "hasTTSAuth";
    public static final String EVENT_PARAM_INVOKE_FROM = "invokeFrom";
    public static final String EVENT_PARAM_SLAVE_ID = "slaveId";
    public static final int INVOKE_FROM_API = 0;
    public static final int INVOKE_FROM_MENU = 1;
    public static final int INVOKE_FROM_NAVI = 2;
    public static final String KEY_ACTION = "key_action";
    public static final String KEY_APP_KEY = "key_appKey";
    public static final String KEY_APP_NAME = "key_appName";
    public static final String KEY_CB_NAME = "key_cb_name";
    public static final String KEY_CONTEXT = "context";
    public static final String KEY_DATA = "key_data";
    public static final String KEY_ERROR_MSG = "key_error_msg";
    public static final String KEY_FAB_SPECIFIED_POSITION = "fabSpecifiedPosition";
    public static final String KEY_GET_STATUS = "key_get_status";
    public static final String KEY_PROCESS_INDEX = "key_process_index";
    public static final String KEY_REGISTER_EVENT_RECEIVER = "key_register_event_receiver";
    public static final String KEY_TTS_NOTIFY = "key_tts_notify";
    private static final String MODULE_NAME = "/swanAPI/tts";
    private static final String MODULE_PATH = "/swanAPI/tts/";
    private static final String TAG = "SwanTTSAction";

    public SwanTTSAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, MODULE_NAME);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        return false;
    }

    public boolean handleSubAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler, String subAction, SwanApp swanApp) {
        if (entity == null) {
            return false;
        }
        if (handler == null || swanApp == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            return false;
        } else if (TextUtils.isEmpty(subAction)) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(401, "subAction empty");
            return false;
        } else if (Swan.get().getActivity() == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(401, "activity is null.");
            return false;
        } else {
            final String str = subAction;
            final UnitedSchemeEntity unitedSchemeEntity = entity;
            final CallbackHandler callbackHandler = handler;
            final SwanApp swanApp2 = swanApp;
            swanApp.getSetting().checkOrAuthorize(Swan.get().getActivity(), "scope_stream_tts", new TypedCallback<TaskResult<Authorize.Result>>() {
                public void onCallback(TaskResult<Authorize.Result> result) {
                    boolean enable = OAuthUtils.isAuthorizeOk(result);
                    if (SwanTTSAction.DEBUG) {
                        Log.d(SwanTTSAction.TAG, "checkOrAuthorize " + enable);
                    }
                    if (enable) {
                        SwanTTSAction.this.doAction(str, unitedSchemeEntity, callbackHandler, swanApp2);
                        return;
                    }
                    JSONObject joParams = SwanAppAction.getParamAsJo(unitedSchemeEntity, "params");
                    if (joParams != null) {
                        int errorCode = result.getErrorCode();
                        callbackHandler.handleSchemeDispatchCallback(joParams.optString("cb"), UnitedSchemeUtility.wrapCallbackParams(errorCode, OAuthUtils.getErrorMessage(errorCode)).toString());
                    }
                }
            });
            UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doAction(java.lang.String r17, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r18, com.baidu.searchbox.unitedscheme.CallbackHandler r19, com.baidu.swan.apps.runtime.SwanApp r20) {
        /*
            r16 = this;
            r6 = r17
            r7 = r19
            java.lang.String r0 = "params"
            r8 = r18
            java.lang.String r9 = r8.getParam(r0)
            org.json.JSONObject r10 = com.baidu.swan.apps.util.SwanAppJSONUtils.parseString(r9)
            r0 = 0
            com.baidu.swan.apps.impl.ai.tts.utils.SwanTTSUtils.buildPlayTTSParams(r6, r10, r0)
            int r1 = r17.hashCode()
            r11 = 3
            r12 = 1
            switch(r1) {
                case -1864901531: goto L_0x0051;
                case -1324362075: goto L_0x0047;
                case -943572085: goto L_0x003d;
                case -756884898: goto L_0x0033;
                case -502266189: goto L_0x0029;
                case 604428259: goto L_0x001f;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x005b
        L_0x001f:
            java.lang.String r1 = "/swanAPI/tts/streamStatus"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x001e
            r1 = 5
            goto L_0x005c
        L_0x0029:
            java.lang.String r1 = "/swanAPI/tts/stopStream"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x001e
            r1 = r11
            goto L_0x005c
        L_0x0033:
            java.lang.String r1 = "/swanAPI/tts/resumeStream"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x001e
            r1 = 2
            goto L_0x005c
        L_0x003d:
            java.lang.String r1 = "/swanAPI/tts/appendStream"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x001e
            r1 = 4
            goto L_0x005c
        L_0x0047:
            java.lang.String r1 = "/swanAPI/tts/pauseStream"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x001e
            r1 = r12
            goto L_0x005c
        L_0x0051:
            java.lang.String r1 = "/swanAPI/tts/playStream"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x001e
            r1 = r0
            goto L_0x005c
        L_0x005b:
            r1 = -1
        L_0x005c:
            switch(r1) {
                case 0: goto L_0x0093;
                case 1: goto L_0x0071;
                case 2: goto L_0x0071;
                case 3: goto L_0x0071;
                case 4: goto L_0x0071;
                case 5: goto L_0x0062;
                default: goto L_0x005f;
            }
        L_0x005f:
            r13 = r16
            goto L_0x00bb
        L_0x0062:
            java.lang.String r0 = r10.toString()
            com.baidu.swan.apps.impl.ai.tts.action.SwanTTSAction$3 r1 = new com.baidu.swan.apps.impl.ai.tts.action.SwanTTSAction$3
            r13 = r16
            r1.<init>(r7)
            com.baidu.swan.apps.impl.ai.tts.manager.SwanTTSManager.sendActionToMainProcess(r6, r0, r1)
            goto L_0x00bb
        L_0x0071:
            r13 = r16
            java.lang.String r1 = r10.toString()
            r2 = 0
            com.baidu.swan.apps.impl.ai.tts.manager.SwanTTSManager.sendActionToMainProcess(r6, r1, r2)
            java.lang.String r1 = "cb"
            java.lang.String r1 = r10.optString(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x00bb
            org.json.JSONObject r0 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r0)
            java.lang.String r0 = r0.toString()
            r7.handleSchemeDispatchCallback(r1, r0)
            goto L_0x00bb
        L_0x0093:
            r13 = r16
            com.baidu.swan.apps.impl.ai.tts.manager.SwanTTSManager.sendSwanShowingMessageToMainProcess()
            com.baidu.swan.apps.impl.ai.tts.model.Params r0 = new com.baidu.swan.apps.impl.ai.tts.model.Params
            r0.<init>(r10)
            r14 = r0
            com.baidu.swan.apps.impl.ai.tts.action.SwanTTSAction$2 r15 = new com.baidu.swan.apps.impl.ai.tts.action.SwanTTSAction$2
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r10
            r4 = r20
            r5 = r19
            r0.<init>(r2, r3, r4, r5)
            boolean r1 = r14.shouldIgnoreFloatView()
            if (r1 == 0) goto L_0x00b7
            r0.onResult(r12, r11)
            goto L_0x00bb
        L_0x00b7:
            com.baidu.swan.apps.impl.ai.tts.utils.SwanHoverUtils.requestPermissionIfNeed(r0)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.ai.tts.action.SwanTTSAction.doAction(java.lang.String, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler, com.baidu.swan.apps.runtime.SwanApp):void");
    }

    /* access modifiers changed from: private */
    public void doPlay(String subAction, String params, final SwanApp swanApp, final CallbackHandler handler) {
        SwanTTSManager.sendActionToMainProcess(subAction, params, true, new SwanAppDefaultMessengerObserver() {
            public void onEvent(SwanAppMessengerObserveEvent event) {
                Bundle bundle = (Bundle) event.getResult();
                if (bundle != null) {
                    String cb = bundle.getString(SwanTTSAction.KEY_CB_NAME);
                    String errorMsg = bundle.getString("key_error_msg");
                    SwanTTSAction.CALLBACK_HANDLE_MAP.put(swanApp.getAppKey(), Pair.create(cb, handler));
                    boolean success = TextUtils.isEmpty(errorMsg);
                    if (!success && !TextUtils.isEmpty(cb)) {
                        handler.handleSchemeDispatchCallback(cb, errorMsg);
                    }
                    if (!success) {
                        SwanTTSManager.hideTTSLoading();
                    }
                }
            }
        });
    }

    public static Map<String, Pair<String, CallbackHandler>> getCallbackHandlerMap() {
        return CALLBACK_HANDLE_MAP;
    }
}
