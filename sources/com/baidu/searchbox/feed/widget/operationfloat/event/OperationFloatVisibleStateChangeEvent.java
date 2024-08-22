package com.baidu.searchbox.feed.widget.operationfloat.event;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/feed/widget/operationfloat/event/OperationFloatVisibleStateChangeEvent;", "", "isVisible", "", "(Z)V", "()Z", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OperationFloatVisibleStateChangeEvent.kt */
public final class OperationFloatVisibleStateChangeEvent {
    private final boolean isVisible;

    public OperationFloatVisibleStateChangeEvent(boolean isVisible2) {
        this.isVisible = isVisible2;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }
}
