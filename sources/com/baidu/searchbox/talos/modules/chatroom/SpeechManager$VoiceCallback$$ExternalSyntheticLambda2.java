package com.baidu.searchbox.talos.modules.chatroom;

import com.baidu.searchbox.talos.modules.chatroom.SpeechManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SpeechManager$VoiceCallback$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ SpeechManager.VoiceCallback f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ SpeechManager$VoiceCallback$$ExternalSyntheticLambda2(SpeechManager.VoiceCallback voiceCallback, int i2) {
        this.f$0 = voiceCallback;
        this.f$1 = i2;
    }

    public final void run() {
        SpeechManager.VoiceCallback.m4234onMicInitializeFailed$lambda0(this.f$0, this.f$1);
    }
}
