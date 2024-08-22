package com.baidu.voice.event;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/baidu/voice/event/AssistantChangeEvent;", "", "assistantId", "", "assistantName", "changeSuccess", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getAssistantId", "()Ljava/lang/String;", "getAssistantName", "getChangeSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "lib-speech-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantChangeEvent.kt */
public final class AssistantChangeEvent {
    private final String assistantId;
    private final String assistantName;
    private final boolean changeSuccess;

    public static /* synthetic */ AssistantChangeEvent copy$default(AssistantChangeEvent assistantChangeEvent, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = assistantChangeEvent.assistantId;
        }
        if ((i2 & 2) != 0) {
            str2 = assistantChangeEvent.assistantName;
        }
        if ((i2 & 4) != 0) {
            z = assistantChangeEvent.changeSuccess;
        }
        return assistantChangeEvent.copy(str, str2, z);
    }

    public final String component1() {
        return this.assistantId;
    }

    public final String component2() {
        return this.assistantName;
    }

    public final boolean component3() {
        return this.changeSuccess;
    }

    public final AssistantChangeEvent copy(String str, String str2, boolean z) {
        return new AssistantChangeEvent(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssistantChangeEvent)) {
            return false;
        }
        AssistantChangeEvent assistantChangeEvent = (AssistantChangeEvent) obj;
        return Intrinsics.areEqual((Object) this.assistantId, (Object) assistantChangeEvent.assistantId) && Intrinsics.areEqual((Object) this.assistantName, (Object) assistantChangeEvent.assistantName) && this.changeSuccess == assistantChangeEvent.changeSuccess;
    }

    public int hashCode() {
        String str = this.assistantId;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.assistantName;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.changeSuccess;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public String toString() {
        return "AssistantChangeEvent(assistantId=" + this.assistantId + ", assistantName=" + this.assistantName + ", changeSuccess=" + this.changeSuccess + ')';
    }

    public AssistantChangeEvent(String assistantId2, String assistantName2, boolean changeSuccess2) {
        this.assistantId = assistantId2;
        this.assistantName = assistantName2;
        this.changeSuccess = changeSuccess2;
    }

    public final String getAssistantId() {
        return this.assistantId;
    }

    public final String getAssistantName() {
        return this.assistantName;
    }

    public final boolean getChangeSuccess() {
        return this.changeSuccess;
    }
}
