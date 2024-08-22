package com.baidu.mms.voicesearch.invoke.voicerecognition;

import com.baidu.voicesearch.component.voice.Stat;
import org.json.JSONObject;

public interface IVoiceRecognitionCallback {
    void onIntermediateResultChange(String str, String str2);

    void onLongSpeechFinish();

    void onMicNoPermissionButtonClick(int i2);

    void onMicRelease();

    void onRecognitionFail(String str);

    void onRecognitionStatusChanged(Stat stat);

    void onRecognitionStatusChanged(String str);

    void onRecognitionSuccess(String str);

    void onSearchFinish(JSONObject jSONObject, String str);

    void onVoiceRecogniitonCancel();

    void onVoiceRecognitionStarted();

    void onVoiceRecordData(byte[] bArr, int i2);

    void onVoiceRecordStarted();

    void onVolumeChange(double d2);
}
