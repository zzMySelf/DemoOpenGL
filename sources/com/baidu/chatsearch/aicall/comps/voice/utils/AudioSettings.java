package com.baidu.chatsearch.aicall.comps.voice.utils;

import android.media.AudioManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/voice/utils/AudioSettings;", "", "()V", "mAudioManager", "Landroid/media/AudioManager;", "pauseOtherAudio", "", "resumeOtherAudio", "AudioSettingHelper", "Companion", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AudioSettings.kt */
public final class AudioSettings {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AudioManager mAudioManager;

    public /* synthetic */ AudioSettings(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/voice/utils/AudioSettings$Companion;", "", "()V", "getInstance", "Lcom/baidu/chatsearch/aicall/comps/voice/utils/AudioSettings;", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AudioSettings.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AudioSettings getInstance() {
            return AudioSettingHelper.INSTANCE.getInstance();
        }
    }

    private AudioSettings() {
        Object systemService = AppRuntime.getApplication().getSystemService("audio");
        this.mAudioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/voice/utils/AudioSettings$AudioSettingHelper;", "", "()V", "instance", "Lcom/baidu/chatsearch/aicall/comps/voice/utils/AudioSettings;", "getInstance", "()Lcom/baidu/chatsearch/aicall/comps/voice/utils/AudioSettings;", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AudioSettings.kt */
    public static final class AudioSettingHelper {
        public static final AudioSettingHelper INSTANCE = new AudioSettingHelper();
        private static final AudioSettings instance = new AudioSettings((DefaultConstructorMarker) null);

        private AudioSettingHelper() {
        }

        public final AudioSettings getInstance() {
            return instance;
        }
    }

    public final void pauseOtherAudio() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 2);
        }
    }

    public final void resumeOtherAudio() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }
}
