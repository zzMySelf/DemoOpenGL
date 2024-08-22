package com.baidu.searchbox.video.feedflow.detail.liveend;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/liveend/LiveEndServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/detail/liveend/ILiveEndService;", "component", "Lcom/baidu/searchbox/video/feedflow/detail/liveend/LiveEndComponent;", "(Lcom/baidu/searchbox/video/feedflow/detail/liveend/LiveEndComponent;)V", "getComponent", "()Lcom/baidu/searchbox/video/feedflow/detail/liveend/LiveEndComponent;", "tryQueryLiveStatus", "", "callback", "Lkotlin/Function1;", "", "tryShowLiveEnd", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveEndServiceImpl.kt */
public final class LiveEndServiceImpl implements ILiveEndService {
    private final LiveEndComponent component;

    public LiveEndServiceImpl(LiveEndComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public final LiveEndComponent getComponent() {
        return this.component;
    }

    public boolean tryQueryLiveStatus(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.component.tryQueryLiveStatus(callback);
    }

    public void tryShowLiveEnd() {
        this.component.tryShowLiveEnd();
    }
}
