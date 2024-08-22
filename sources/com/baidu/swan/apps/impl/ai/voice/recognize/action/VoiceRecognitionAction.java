package com.baidu.swan.apps.impl.ai.voice.recognize.action;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.ai.auth.AISDKAuthManager;
import com.baidu.swan.apps.impl.ai.auth.AITokenResultListener;
import com.baidu.swan.apps.impl.ai.voice.recognize.ErrorCodeReMapUtil;
import com.baidu.swan.apps.impl.ai.voice.recognize.SwanAppVoiceRecognitionLifecycleManager;
import com.baidu.swan.apps.impl.ai.voice.recognize.VoiceMultiRecognitionCallback;
import com.baidu.swan.apps.impl.ai.voice.recognize.VoiceRecognitionParams;
import com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback;
import com.baidu.swan.apps.permission.RequestPermissionHelper;
import com.baidu.swan.apps.permission.RequestPermissionListener;
import com.baidu.swan.apps.permission.SwanAppPermission;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.record.SwanAppAuthRecordManager;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.voice.pyramid.VoiceRecognitionInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceRecognitionAction extends SwanAppAction {
    private static final String ACTION_CANCLE = "/swanAPI/voiceRecognize/cancel";
    private static final String ACTION_START = "/swanAPI/voiceRecognize/start";
    private static final String ACTION_STOP = "/swanAPI/voiceRecognize/stop";
    private static final String CALLBACK_KEY_INTERRUPT = "unregister";
    private static final String MODULE_NAME = "/swanAPI/voiceRecognize";
    private static final String MODULE_PATH = "/swanAPI/voiceRecognize/";
    private static final String MODULE_TAG = "voiceRecognize";
    private static final String TAG = "VoiceRecognitionAction";
    private VoiceRecognitionParams currentParams;
    private VoiceStatusCallback mCallback;
    private JSONObject mFinalResult = null;
    /* access modifiers changed from: private */
    public String mToken;
    private VoiceMultiRecognitionCallback mVoiceCallback;

    public VoiceRecognitionAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, MODULE_NAME);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "handle entity: " + entity.toString());
        return false;
    }

    public boolean handleSubAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler, String subAction, SwanApp swanApp) {
        UnitedSchemeEntity unitedSchemeEntity = entity;
        String str = subAction;
        SwanApp swanApp2 = swanApp;
        if (DEBUG) {
            Log.d(TAG, "handleSubAction subAction: " + str);
        }
        if (swanApp2 == null) {
            SwanAppLog.e(MODULE_TAG, "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            return false;
        } else if (TextUtils.isEmpty(swanApp2.id)) {
            SwanAppLog.e(MODULE_TAG, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            return false;
        } else {
            JSONObject params = getParamsJSONObject(unitedSchemeEntity.getParam("params"));
            if (!TextUtils.equals(ACTION_START, str) || params != null) {
                boolean needCheckCb = !TextUtils.equals(ACTION_CANCLE, str) && !TextUtils.equals(ACTION_STOP, str);
                final VoiceRecognitionParams recognitionParams = VoiceRecognitionParams.createFromJson(params, this.currentParams);
                if (recognitionParams == null) {
                } else if (!needCheckCb || !TextUtils.isEmpty(recognitionParams.callbacks)) {
                    JSONObject result = recognitionParams.getParamsWrongCode();
                    if (result != null) {
                        SwanAppLog.e(MODULE_TAG, "error params");
                        unitedSchemeEntity.result = result;
                        return false;
                    }
                    VoiceStatusCallback callbacks = VoiceStatusCallback.createFromJson(handler, unitedSchemeEntity, recognitionParams.callbacks, this.mCallback);
                    if (needCheckCb && callbacks == null) {
                        SwanAppLog.e(MODULE_TAG, "error cb");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                        return false;
                    } else if (!(context instanceof Activity)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        SwanAppLog.e(MODULE_TAG, "handle action, but context is not Activity");
                        return false;
                    } else {
                        final SwanApp swanApp3 = swanApp;
                        AnonymousClass1 r15 = r0;
                        final Context context2 = context;
                        AISDKAuthManager instance = AISDKAuthManager.getInstance(swanApp);
                        final CallbackHandler callbackHandler = handler;
                        final UnitedSchemeEntity unitedSchemeEntity2 = entity;
                        final VoiceStatusCallback voiceStatusCallback = callbacks;
                        JSONObject jSONObject = result;
                        final String str2 = subAction;
                        VoiceRecognitionParams voiceRecognitionParams = recognitionParams;
                        AnonymousClass1 r0 = new AITokenResultListener() {
                            public void onSuccess(String token) {
                                String unused = VoiceRecognitionAction.this.mToken = token;
                                swanApp3.getSetting().checkOrAuthorize(context2, "mapp_record", new TypedCallback<TaskResult<Authorize.Result>>() {
                                    public void onCallback(TaskResult<Authorize.Result> taskResult) {
                                        int errCode;
                                        if (!OAuthUtils.isAuthorizeOk(taskResult)) {
                                            SwanAppLog.e(VoiceRecognitionAction.MODULE_TAG, "voice authorize failure");
                                            OAuthUtils.processPermissionDeny(taskResult, callbackHandler, unitedSchemeEntity2);
                                            if (taskResult == null) {
                                                errCode = 10001;
                                            } else {
                                                errCode = taskResult.getErrorCode();
                                            }
                                            voiceStatusCallback.dispatchErrorCallback(errCode, OAuthUtils.getErrorMessage(errCode));
                                            return;
                                        }
                                        VoiceRecognitionAction.this.handleAuthorized(unitedSchemeEntity2, callbackHandler, str2, recognitionParams, voiceStatusCallback);
                                    }
                                });
                            }

                            public void onFailure() {
                                voiceStatusCallback.dispatchErrorCallback(2007, ErrorCodeReMapUtil.Error.ERROR_MSG_AI_AUTH);
                            }
                        };
                        instance.requestAIToken(r15);
                        if (!DEBUG) {
                            return true;
                        }
                        Log.d(TAG, "subAction is : " + str);
                        return true;
                    }
                } else {
                    VoiceRecognitionParams voiceRecognitionParams2 = recognitionParams;
                }
                SwanAppLog.e(MODULE_TAG, "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty cb");
                return false;
            }
            SwanAppLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        }
    }

    private JSONObject getParamsJSONObject(String param) {
        if (TextUtils.isEmpty(param)) {
            return null;
        }
        try {
            return new JSONObject(param);
        } catch (JSONException e2) {
            if (!DEBUG) {
                return null;
            }
            Log.d(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void handleAuthorized(UnitedSchemeEntity entity, CallbackHandler handler, String subAction, VoiceRecognitionParams params, VoiceStatusCallback callback) {
        final String str = subAction;
        final VoiceRecognitionParams voiceRecognitionParams = params;
        final VoiceStatusCallback voiceStatusCallback = callback;
        final CallbackHandler callbackHandler = handler;
        final UnitedSchemeEntity unitedSchemeEntity = entity;
        RequestPermissionListener listener = new RequestPermissionListener() {
            public void onAuthorizedSuccess(String msg) {
                if (VoiceRecognitionAction.DEBUG) {
                    Log.d(VoiceRecognitionAction.TAG, msg + "");
                }
                VoiceRecognitionAction.this.dispatchSubAction(str, voiceRecognitionParams, voiceStatusCallback);
            }

            public void onAuthorizedFailed(int errorCode, String errorMsg) {
                if (VoiceRecognitionAction.DEBUG) {
                    Log.d(VoiceRecognitionAction.TAG, errorMsg);
                }
                SwanAppLog.e(VoiceRecognitionAction.MODULE_TAG, errorMsg);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                VoiceStatusCallback voiceStatusCallback = voiceStatusCallback;
                if (voiceStatusCallback != null) {
                    voiceStatusCallback.dispatchErrorCallback(10005, "system deny");
                }
            }
        };
        String[] strArr = {"android.permission.RECORD_AUDIO"};
        RequestPermissionHelper.handleSystemAuthorizedWithDialog("android.permission.RECORD_AUDIO", strArr, SwanAppPermission.REQUEST_RECORD_CODE, Swan.get().getActivity(), listener);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchSubAction(java.lang.String r3, com.baidu.swan.apps.impl.ai.voice.recognize.VoiceRecognitionParams r4, com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r5) {
        /*
            r2 = this;
            com.baidu.pyramid.runtime.service.ServiceReference r0 = com.baidu.voice.pyramid.VoiceRecognitionInterface.SERVICE_REFERENCE
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)
            com.baidu.voice.pyramid.VoiceRecognitionInterface r0 = (com.baidu.voice.pyramid.VoiceRecognitionInterface) r0
            int r1 = r3.hashCode()
            switch(r1) {
                case -2076558376: goto L_0x0024;
                case 1610912580: goto L_0x001a;
                case 1991628000: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x002e
        L_0x0010:
            java.lang.String r1 = "/swanAPI/voiceRecognize/stop"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x000f
            r1 = 1
            goto L_0x002f
        L_0x001a:
            java.lang.String r1 = "/swanAPI/voiceRecognize/start"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x000f
            r1 = 0
            goto L_0x002f
        L_0x0024:
            java.lang.String r1 = "/swanAPI/voiceRecognize/cancel"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x000f
            r1 = 2
            goto L_0x002f
        L_0x002e:
            r1 = -1
        L_0x002f:
            switch(r1) {
                case 0: goto L_0x003f;
                case 1: goto L_0x0039;
                case 2: goto L_0x0033;
                default: goto L_0x0032;
            }
        L_0x0032:
            goto L_0x0043
        L_0x0033:
            if (r0 == 0) goto L_0x0043
            r0.cancelVoiceRecognition()
            goto L_0x0043
        L_0x0039:
            if (r0 == 0) goto L_0x0043
            r0.stopVoiceRecognition()
            goto L_0x0043
        L_0x003f:
            r2.startRecognize(r4, r5)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.ai.voice.recognize.action.VoiceRecognitionAction.dispatchSubAction(java.lang.String, com.baidu.swan.apps.impl.ai.voice.recognize.VoiceRecognitionParams, com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResult(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "raw log : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r2 = ": "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "VoiceRecognitionAction"
            com.baidu.swan.apps.console.SwanAppLog.i(r2, r0)
            int r0 = r8.hashCode()
            r3 = 1
            switch(r0) {
                case -1572870207: goto L_0x005f;
                case -1454255085: goto L_0x0055;
                case -1159767782: goto L_0x004b;
                case -1148165963: goto L_0x0041;
                case -453048372: goto L_0x0037;
                case 836015164: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0069
        L_0x002c:
            java.lang.String r0 = "unregister"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x002b
            r0 = 4
            goto L_0x006a
        L_0x0037:
            java.lang.String r0 = "asr.exit"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x002b
            r0 = 5
            goto L_0x006a
        L_0x0041:
            java.lang.String r0 = "asr.ready"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x002b
            r0 = 0
            goto L_0x006a
        L_0x004b:
            java.lang.String r0 = "asr.error"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x002b
            r0 = 3
            goto L_0x006a
        L_0x0055:
            java.lang.String r0 = "asr.partial"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x002b
            r0 = r3
            goto L_0x006a
        L_0x005f:
            java.lang.String r0 = "asr.finish"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x002b
            r0 = 2
            goto L_0x006a
        L_0x0069:
            r0 = -1
        L_0x006a:
            r4 = 4004(0xfa4, float:5.611E-42)
            java.lang.String r5 = "onResult: onError: "
            r6 = 0
            switch(r0) {
                case 0: goto L_0x01b6;
                case 1: goto L_0x0162;
                case 2: goto L_0x00ea;
                case 3: goto L_0x00ac;
                case 4: goto L_0x009a;
                case 5: goto L_0x0089;
                default: goto L_0x0073;
            }
        L_0x0073:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.baidu.swan.apps.console.SwanAppLog.i(r2, r0)
            goto L_0x01c4
        L_0x0089:
            r7.mFinalResult = r6
            java.lang.String r0 = "onResult: onExit "
            com.baidu.swan.apps.console.SwanAppLog.i(r2, r0)
            com.baidu.swan.apps.impl.ai.voice.recognize.SwanAppVoiceRecognitionLifecycleManager r0 = com.baidu.swan.apps.impl.ai.voice.recognize.SwanAppVoiceRecognitionLifecycleManager.get()
            r0.release(r3)
            goto L_0x01c4
        L_0x009a:
            java.lang.String r0 = "onResult: onError: 识别被打断"
            com.baidu.swan.apps.console.SwanAppLog.i(r2, r0)
            com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r0 = r7.mCallback
            r1 = 2006(0x7d6, float:2.811E-42)
            java.lang.String r2 = "识别被打断"
            r0.dispatchErrorCallback(r1, r2)
            goto L_0x01c4
        L_0x00ac:
            r7.mFinalResult = r6
            java.lang.String r0 = r7.parseErrorCode(r9)
            com.baidu.swan.apps.impl.ai.voice.recognize.ErrorCodeReMapUtil$Error r0 = com.baidu.swan.apps.impl.ai.voice.recognize.ErrorCodeReMapUtil.getMappedError(r0)
            com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r1 = r7.mCallback
            int r3 = r0.errorCode
            java.lang.String r4 = r0.errorMsg
            r1.dispatchErrorCallback(r3, r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r3 = r0.errorMsg
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.baidu.swan.apps.console.SwanAppLog.i(r2, r1)
            r1 = 2008(0x7d8, float:2.814E-42)
            int r2 = r0.errorCode
            if (r1 != r2) goto L_0x01c4
            r7.mToken = r6
            com.baidu.swan.apps.runtime.SwanApp r1 = r7.getSwanApp()
            com.baidu.swan.apps.impl.ai.auth.AISDKAuthManager r1 = com.baidu.swan.apps.impl.ai.auth.AISDKAuthManager.getInstance(r1)
            r1.resetToken()
            goto L_0x01c4
        L_0x00ea:
            r0 = 9000(0x2328, float:1.2612E-41)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f9 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r3 = "error"
            int r3 = r1.optInt(r3, r4)     // Catch:{ Exception -> 0x00f9 }
            r0 = r3
            goto L_0x0101
        L_0x00f9:
            r1 = move-exception
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0101
            r1.printStackTrace()
        L_0x0101:
            if (r0 == 0) goto L_0x012e
            r7.mFinalResult = r6
            java.lang.String r1 = r7.parseErrorCode(r9)
            com.baidu.swan.apps.impl.ai.voice.recognize.ErrorCodeReMapUtil$Error r1 = com.baidu.swan.apps.impl.ai.voice.recognize.ErrorCodeReMapUtil.getMappedError(r1)
            com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r3 = r7.mCallback
            int r4 = r1.errorCode
            java.lang.String r6 = r1.errorMsg
            r3.dispatchErrorCallback(r4, r6)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r4 = r1.errorMsg
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.baidu.swan.apps.console.SwanAppLog.e(r2, r3)
            goto L_0x01c4
        L_0x012e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "onResult:  onFinish: "
            java.lang.StringBuilder r1 = r1.append(r3)
            org.json.JSONObject r3 = r7.mFinalResult
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.baidu.swan.apps.console.SwanAppLog.i(r2, r1)
            org.json.JSONObject r1 = r7.mFinalResult
            if (r1 == 0) goto L_0x0155
            com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r1 = r7.mCallback
            java.lang.String r2 = r1.finishCallback
            org.json.JSONObject r3 = r7.mFinalResult
            r1.dispatchCallback(r2, r3)
            goto L_0x015f
        L_0x0155:
            com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r1 = r7.mCallback
            r2 = 4003(0xfa3, float:5.61E-42)
            java.lang.String r3 = "没有匹配的识别结果"
            r1.dispatchErrorCallback(r2, r3)
        L_0x015f:
            r7.mFinalResult = r6
            goto L_0x01c4
        L_0x0162:
            r7.mFinalResult = r6
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a6 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x01a6 }
            java.lang.String r3 = "best_result"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ Exception -> 0x01a6 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01a6 }
            if (r5 != 0) goto L_0x0182
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a6 }
            r5.<init>()     // Catch:{ Exception -> 0x01a6 }
            r0 = r5
            java.lang.String r5 = "result"
            r0.put(r5, r3)     // Catch:{ Exception -> 0x01a6 }
        L_0x0182:
            if (r0 == 0) goto L_0x01c4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "onResult:  onRecognize: "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.baidu.swan.apps.console.SwanAppLog.i(r2, r1)
            com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r1 = r7.mCallback
            java.lang.String r2 = r1.recognizeCallback
            r1.dispatchCallback(r2, r0)
            r7.mFinalResult = r0
            goto L_0x01c4
        L_0x01a6:
            r1 = move-exception
            java.lang.String r3 = "onResult: onError: 返回结果异常"
            com.baidu.swan.apps.console.SwanAppLog.e(r2, r3, r1)
            com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r2 = r7.mCallback
            java.lang.String r3 = "返回结果异常"
            r2.dispatchErrorCallback(r4, r3)
            return
        L_0x01b6:
            java.lang.String r0 = "onResult: onStart"
            com.baidu.swan.apps.console.SwanAppLog.i(r2, r0)
            com.baidu.swan.apps.impl.ai.voice.recognize.VoiceStatusCallback r0 = r7.mCallback
            java.lang.String r1 = r0.startCallback
            r0.dispatchCallback(r1)
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.ai.voice.recognize.action.VoiceRecognitionAction.onResult(java.lang.String, java.lang.String):void");
    }

    private String parseErrorCode(String jsonParams) {
        try {
            return new JSONObject(jsonParams).optString("error");
        } catch (JSONException e2) {
            if (SwanAppLibConfig.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    private void startRecognize(VoiceRecognitionParams params, VoiceStatusCallback callback) {
        SwanAppLog.i(MODULE_TAG, "init");
        this.currentParams = params;
        this.mCallback = callback;
        SwanAppVoiceRecognitionLifecycleManager.get().init(callback);
        SwanAppLog.i(MODULE_TAG, "start");
        SwanAppVoiceRecognitionLifecycleManager.get().setNeedManulRelease(true);
        if (this.mVoiceCallback == null) {
            this.mVoiceCallback = new VoiceMultiRecognitionCallback() {
                public void executeVoiceItem(String name, String params, byte[] data, int offset, int length) {
                    VoiceRecognitionAction.this.onResult(name, params);
                }
            };
        }
        String requestParams = params.generateParams(this.mToken);
        SwanAppLog.i(TAG, "requestParams: " + requestParams);
        VoiceRecognitionInterface voiceRecognitionInterface = (VoiceRecognitionInterface) ServiceManager.getService(VoiceRecognitionInterface.SERVICE_REFERENCE);
        if (voiceRecognitionInterface != null) {
            voiceRecognitionInterface.startVoiceRecognition(this.mVoiceCallback, requestParams, false);
        }
        SwanAppAuthRecordManager.INSTANCE.record("mapp_record");
    }
}
