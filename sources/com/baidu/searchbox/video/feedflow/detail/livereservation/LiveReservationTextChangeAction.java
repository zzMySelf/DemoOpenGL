package com.baidu.searchbox.video.feedflow.detail.livereservation;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livereservation/LiveReservationTextChangeAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "state", "", "(Z)V", "getState", "()Z", "setState", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: LiveReservationActionManifest.kt */
public final class LiveReservationTextChangeAction implements Action {
    private boolean state;

    public static /* synthetic */ LiveReservationTextChangeAction copy$default(LiveReservationTextChangeAction liveReservationTextChangeAction, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = liveReservationTextChangeAction.state;
        }
        return liveReservationTextChangeAction.copy(z);
    }

    public final boolean component1() {
        return this.state;
    }

    public final LiveReservationTextChangeAction copy(boolean z) {
        return new LiveReservationTextChangeAction(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveReservationTextChangeAction) && this.state == ((LiveReservationTextChangeAction) obj).state;
    }

    public int hashCode() {
        boolean z = this.state;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "LiveReservationTextChangeAction(state=" + this.state + ')';
    }

    public LiveReservationTextChangeAction(boolean state2) {
        this.state = state2;
    }

    public final boolean getState() {
        return this.state;
    }

    public final void setState(boolean z) {
        this.state = z;
    }
}
