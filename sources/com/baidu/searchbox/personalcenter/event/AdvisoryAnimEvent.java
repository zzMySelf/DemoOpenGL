package com.baidu.searchbox.personalcenter.event;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/personalcenter/event/AdvisoryAnimEvent;", "Lcom/baidu/searchbox/NoProGuard;", "hasAnim", "", "(Z)V", "mHasAnim", "getMHasAnim", "()Z", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdvisoryAnimEvent.kt */
public final class AdvisoryAnimEvent implements NoProGuard {
    private final boolean mHasAnim;

    public final boolean getMHasAnim() {
        return this.mHasAnim;
    }

    public AdvisoryAnimEvent(boolean hasAnim) {
        this.mHasAnim = hasAnim;
    }
}
