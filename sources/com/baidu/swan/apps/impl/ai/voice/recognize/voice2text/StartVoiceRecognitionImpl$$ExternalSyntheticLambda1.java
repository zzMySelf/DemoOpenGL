package com.baidu.swan.apps.impl.ai.voice.recognize.voice2text;

import android.app.Activity;
import com.baidu.swan.apps.llm.api.StartVoiceRecognitionApi;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class StartVoiceRecognitionImpl$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ StartVoiceRecognitionApi.IVoiceRecognitionResultCallback f$1;
    public final /* synthetic */ StartVoiceRecognitionImpl f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ StartVoiceRecognitionImpl$$ExternalSyntheticLambda1(Activity activity, StartVoiceRecognitionApi.IVoiceRecognitionResultCallback iVoiceRecognitionResultCallback, StartVoiceRecognitionImpl startVoiceRecognitionImpl, String str) {
        this.f$0 = activity;
        this.f$1 = iVoiceRecognitionResultCallback;
        this.f$2 = startVoiceRecognitionImpl;
        this.f$3 = str;
    }

    public final void run() {
        StartVoiceRecognitionImpl.m7970startVoiceRecognition$lambda2(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
