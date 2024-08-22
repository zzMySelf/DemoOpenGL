package com.baidu.searchbox.video.feedflow.detail.air;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/air/AirTimerCountDown;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "countText", "", "(Ljava/lang/String;)V", "getCountText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: AirPlayActionManifest.kt */
public final class AirTimerCountDown implements Action {
    private final String countText;

    public static /* synthetic */ AirTimerCountDown copy$default(AirTimerCountDown airTimerCountDown, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = airTimerCountDown.countText;
        }
        return airTimerCountDown.copy(str);
    }

    public final String component1() {
        return this.countText;
    }

    public final AirTimerCountDown copy(String str) {
        Intrinsics.checkNotNullParameter(str, "countText");
        return new AirTimerCountDown(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AirTimerCountDown) && Intrinsics.areEqual((Object) this.countText, (Object) ((AirTimerCountDown) obj).countText);
    }

    public int hashCode() {
        return this.countText.hashCode();
    }

    public String toString() {
        return "AirTimerCountDown(countText=" + this.countText + ')';
    }

    public AirTimerCountDown(String countText2) {
        Intrinsics.checkNotNullParameter(countText2, "countText");
        this.countText = countText2;
    }

    public final String getCountText() {
        return this.countText;
    }
}
