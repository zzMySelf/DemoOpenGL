package com.baidu.searchbox.talos.modules.chatroom;

import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.talos.modules.chatroom.SpeechManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeechManager.kt */
final class SpeechManager$VoiceCallback$executeVoiceItem$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $params;
    final /* synthetic */ SpeechManager.VoiceCallback this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpeechManager$VoiceCallback$executeVoiceItem$4(String str, SpeechManager.VoiceCallback voiceCallback) {
        super(0);
        this.$params = str;
        this.this$0 = voiceCallback;
    }

    public final void invoke() {
        UiThreadUtils.runOnUiThread(new SpeechManager$VoiceCallback$executeVoiceItem$4$$ExternalSyntheticLambda0(this.this$0, SpeechManager.INSTANCE.parseVolume(this.$params)));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m4237invoke$lambda0(SpeechManager.VoiceCallback this$02, float $volumePercent) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        SpeechManager.VolumeListener volumeListener = this$02.getVolumeListener();
        if (volumeListener != null) {
            volumeListener.onVoiceVolumeChanged($volumePercent);
        }
        if (SpeechManager.DEBUG) {
            Log.d("TLS_SpeechManager", "volume: " + $volumePercent);
        }
    }
}
