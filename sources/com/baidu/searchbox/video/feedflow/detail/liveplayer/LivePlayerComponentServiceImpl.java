package com.baidu.searchbox.video.feedflow.detail.liveplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/liveplayer/LivePlayerComponentServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/detail/liveplayer/ILivePlayerComponentService;", "component", "Lcom/baidu/searchbox/video/feedflow/detail/liveplayer/LivePlayerComponent;", "(Lcom/baidu/searchbox/video/feedflow/detail/liveplayer/LivePlayerComponent;)V", "getComponent", "()Lcom/baidu/searchbox/video/feedflow/detail/liveplayer/LivePlayerComponent;", "getLiveUnionId", "", "isFakeOnResume", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LivePlayerComponentServiceImpl.kt */
public final class LivePlayerComponentServiceImpl implements ILivePlayerComponentService {
    private final LivePlayerComponent component;

    public LivePlayerComponentServiceImpl(LivePlayerComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public final LivePlayerComponent getComponent() {
        return this.component;
    }

    public String getLiveUnionId() {
        return this.component.getLiveUnionId();
    }

    public boolean isFakeOnResume() {
        return this.component.isFakeOnResume();
    }
}
