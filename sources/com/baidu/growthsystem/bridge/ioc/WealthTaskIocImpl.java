package com.baidu.growthsystem.bridge.ioc;

import com.baidu.growthsystem.wealth.common.ioc.IWealthTaskIocContext;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/growthsystem/bridge/ioc/WealthTaskIocImpl;", "Lcom/baidu/growthsystem/wealth/common/ioc/IWealthTaskIocContext;", "()V", "getFlowVideoEventActionName", "", "getFlowVideoPraiseActionName", "impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthTaskIocImpl.kt */
public final class WealthTaskIocImpl implements IWealthTaskIocContext {
    public String getFlowVideoPraiseActionName() {
        return "com.baidu.searchbox.video.feedflow.detail.praise";
    }

    public String getFlowVideoEventActionName() {
        return "com.baidu.channel.flowvideoevents";
    }
}
