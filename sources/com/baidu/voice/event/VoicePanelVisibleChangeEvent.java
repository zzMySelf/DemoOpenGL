package com.baidu.voice.event;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/baidu/voice/event/VoicePanelVisibleChangeEvent;", "", "isVisible", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "lib-speech-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoicePanelVisibleChangeEvent.kt */
public final class VoicePanelVisibleChangeEvent {
    private final boolean isVisible;

    public static /* synthetic */ VoicePanelVisibleChangeEvent copy$default(VoicePanelVisibleChangeEvent voicePanelVisibleChangeEvent, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = voicePanelVisibleChangeEvent.isVisible;
        }
        return voicePanelVisibleChangeEvent.copy(z);
    }

    public final boolean component1() {
        return this.isVisible;
    }

    public final VoicePanelVisibleChangeEvent copy(boolean z) {
        return new VoicePanelVisibleChangeEvent(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VoicePanelVisibleChangeEvent) && this.isVisible == ((VoicePanelVisibleChangeEvent) obj).isVisible;
    }

    public int hashCode() {
        boolean z = this.isVisible;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "VoicePanelVisibleChangeEvent(isVisible=" + this.isVisible + ')';
    }

    public VoicePanelVisibleChangeEvent(boolean isVisible2) {
        this.isVisible = isVisible2;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }
}
