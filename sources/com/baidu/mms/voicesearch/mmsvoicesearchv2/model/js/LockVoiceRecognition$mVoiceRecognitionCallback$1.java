package com.baidu.mms.voicesearch.mmsvoicesearchv2.model.js;

import android.text.TextUtils;
import com.baidu.mms.voicesearch.api.VoiceSearchManager;
import com.baidu.mms.voicesearch.invoke.voicerecognition.IVoiceRecognitionCallback;
import com.baidu.voice.vscb.IVoiceSearchCallback;
import com.baidu.voicesearch.component.voice.Stat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016¨\u0006!"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/model/js/LockVoiceRecognition$mVoiceRecognitionCallback$1", "Lcom/baidu/mms/voicesearch/invoke/voicerecognition/IVoiceRecognitionCallback;", "onIntermediateResultChange", "", "certainResult", "", "unCertainResult", "onLongSpeechFinish", "onMicNoPermissionButtonClick", "micBtnClickType", "", "onMicRelease", "onRecognitionFail", "errorCode", "onRecognitionStatusChanged", "state", "Lcom/baidu/voicesearch/component/voice/Stat;", "onRecognitionSuccess", "json", "onSearchFinish", "jsonObject", "Lorg/json/JSONObject;", "word", "onVoiceRecogniitonCancel", "onVoiceRecognitionStarted", "onVoiceRecordData", "data", "", "length", "onVoiceRecordStarted", "onVolumeChange", "volume", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LockVoiceRecognition.kt */
public final class LockVoiceRecognition$mVoiceRecognitionCallback$1 implements IVoiceRecognitionCallback {
    LockVoiceRecognition$mVoiceRecognitionCallback$1() {
    }

    public void onRecognitionSuccess(String json) {
        String resultType;
        if (LockVoiceRecognition.mJsCallback != null) {
            String result = "";
            String resultType2 = "";
            if (!TextUtils.isEmpty(json)) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    String optString = jsonObject.optString("data");
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"data\")");
                    result = optString;
                    String optString2 = jsonObject.optString("type");
                    Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"type\")");
                    resultType2 = optString2;
                } catch (JSONException e2) {
                }
            }
            if (TextUtils.isEmpty(resultType2) || !Intrinsics.areEqual((Object) resultType2, (Object) "command")) {
                resultType = LockVoiceRecognition.ACTION_END;
            } else {
                resultType = LockVoiceRecognition.ACTION_COMMAND;
            }
            String resultJs = LockVoiceRecognition.INSTANCE.getResultJson(resultType, result);
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }

    public void onRecognitionFail(String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (LockVoiceRecognition.mJsCallback != null) {
            String resultJs = LockVoiceRecognition.INSTANCE.getResultJson(LockVoiceRecognition.ACTION_ERROR, errorCode);
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }

    public void onRecognitionStatusChanged(String state) {
    }

    public void onVolumeChange(double volume) {
        if (LockVoiceRecognition.mJsCallback != null) {
            String resultJs = LockVoiceRecognition.INSTANCE.getResultJson(LockVoiceRecognition.ACTION_VOLUME, String.valueOf(volume));
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }

    public void onVoiceRecognitionStarted() {
        if (LockVoiceRecognition.mJsCallback != null) {
            String resultJs = LockVoiceRecognition.INSTANCE.getResultJson(LockVoiceRecognition.ACTION_RECORD_END, "");
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }

    public void onVoiceRecordStarted() {
        if (LockVoiceRecognition.mJsCallback != null) {
            String resultJs = LockVoiceRecognition.INSTANCE.getResultJson(LockVoiceRecognition.ACTION_START, "");
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }

    public void onVoiceRecogniitonCancel() {
    }

    public void onIntermediateResultChange(String certainResult, String unCertainResult) {
        if (LockVoiceRecognition.mJsCallback != null) {
            LockVoiceRecognition lockVoiceRecognition = LockVoiceRecognition.INSTANCE;
            String access$getACTION_INPUTTING$p = LockVoiceRecognition.ACTION_INPUTTING;
            Intrinsics.checkNotNull(certainResult);
            String resultJs = lockVoiceRecognition.getResultJson(access$getACTION_INPUTTING$p, certainResult);
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }

    public void onVoiceRecordData(byte[] data, int length) {
    }

    public void onMicNoPermissionButtonClick(int micBtnClickType) {
    }

    public void onMicRelease() {
        if (LockVoiceRecognition.mJsCallback != null) {
            String resultJs = LockVoiceRecognition.INSTANCE.getResultJson(LockVoiceRecognition.ACTION_FINISH, "");
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }

    public void onRecognitionStatusChanged(Stat state) {
        String action;
        if (LockVoiceRecognition.mJsCallback != null && state != null) {
            switch (state.mCurrentStat) {
                case 3:
                    action = LockVoiceRecognition.ACTION_VAD_START;
                    break;
                case 4:
                    action = LockVoiceRecognition.ACTION_VAD_END;
                    break;
                default:
                    return;
            }
            if (!TextUtils.isEmpty(action)) {
                String resultJs = LockVoiceRecognition.INSTANCE.getResultJson(action, "");
                ArrayList voiceItemsJs = new ArrayList();
                IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
                if (access$getMJsCallback$p != null) {
                    access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
                }
            }
        }
    }

    public void onSearchFinish(JSONObject jsonObject, String word) {
        Intrinsics.checkNotNullParameter(word, "word");
        if (LockVoiceRecognition.mJsCallback != null && jsonObject != null) {
            String resultJs = LockVoiceRecognition.INSTANCE.getSearchResultJson(LockVoiceRecognition.ACTION_SEARCH, word, jsonObject.toString());
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }

    public void onLongSpeechFinish() {
        if (LockVoiceRecognition.mJsCallback != null) {
            String resultJs = LockVoiceRecognition.INSTANCE.getResultJson(LockVoiceRecognition.ACTION_LONG_FINISH, "");
            ArrayList voiceItemsJs = new ArrayList();
            IVoiceSearchCallback.IThirdPartSearchCallBack access$getMJsCallback$p = LockVoiceRecognition.mJsCallback;
            if (access$getMJsCallback$p != null) {
                access$getMJsCallback$p.executeThirdSearch(VoiceSearchManager.getApplicationContext(), voiceItemsJs, resultJs);
            }
        }
    }
}
