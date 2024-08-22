package com.baidu.voicesearch.component.impl;

import com.baidu.voice.pyramid.VoiceRecognitionInterface;
import com.baidu.voice.recognition.VoiceRecognitionCallback;
import com.baidu.voicesearch.component.api.IVoiceItemCallback;
import com.baidu.voicesearch.component.voice.VoiceMultiRecognitionManager;
import com.baidu.voicesearch.component.voice.VoiceRecognitionManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J$\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/voicesearch/component/impl/VoiceRecognitionImpl;", "Lcom/baidu/voice/pyramid/VoiceRecognitionInterface;", "()V", "cancelVoiceRecognition", "", "changeToShortPress", "clearCallbackMap", "releaseVoiceItemCallback", "startVoiceRecognition", "callBack", "Lcom/baidu/voice/recognition/VoiceRecognitionCallback;", "configParams", "", "isPeripheralAudio", "", "stopVoiceRecognition", "Companion", "lib-speech-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceRecognitionImpl.kt */
public final class VoiceRecognitionImpl implements VoiceRecognitionInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Map<Integer, IVoiceItemCallback> voiceRecognitionCallbackMap = new HashMap();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/voicesearch/component/impl/VoiceRecognitionImpl$Companion;", "", "()V", "voiceRecognitionCallbackMap", "", "", "Lcom/baidu/voicesearch/component/api/IVoiceItemCallback;", "lib-speech-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VoiceRecognitionImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void startVoiceRecognition(VoiceRecognitionCallback callBack, String configParams, boolean isPeripheralAudio) {
        if (callBack != null) {
            int callBackHashCode = callBack.hashCode();
            Map<Integer, IVoiceItemCallback> map = voiceRecognitionCallbackMap;
            if (map.containsKey(Integer.valueOf(callBackHashCode))) {
                VoiceMultiRecognitionManager.startVoiceRecognition(map.get(Integer.valueOf(callBackHashCode)), configParams, isPeripheralAudio);
                return;
            }
            clearCallbackMap();
            VoiceRecognitionImpl$startVoiceRecognition$iVoiceItemCallback$1 iVoiceItemCallback = new VoiceRecognitionImpl$startVoiceRecognition$iVoiceItemCallback$1(callBack);
            map.put(Integer.valueOf(callBackHashCode), iVoiceItemCallback);
            VoiceMultiRecognitionManager.startVoiceRecognition(iVoiceItemCallback, configParams, isPeripheralAudio);
        }
    }

    public void stopVoiceRecognition() {
        VoiceMultiRecognitionManager.stopVoiceRecognition();
    }

    public void cancelVoiceRecognition() {
        VoiceMultiRecognitionManager.cancelVoiceRecognition();
    }

    public void releaseVoiceItemCallback() {
        VoiceMultiRecognitionManager.releaseVoiceItemCallback();
        clearCallbackMap();
    }

    public void changeToShortPress() {
        VoiceRecognitionManager.getSharedInstance().changeToShortPress();
    }

    private final void clearCallbackMap() {
        Map<Integer, IVoiceItemCallback> map = voiceRecognitionCallbackMap;
        if (!map.isEmpty()) {
            map.clear();
        }
    }
}
