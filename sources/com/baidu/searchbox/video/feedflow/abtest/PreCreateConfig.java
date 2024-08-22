package com.baidu.searchbox.video.feedflow.abtest;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/abtest/PreCreateConfig;", "", "componentEnable", "", "stateEnable", "middlewareEnable", "reducerEnable", "aotEnable", "tabThreshold", "", "preParseTabConfigEnable", "denyComponentList", "", "", "(ZZZZZDZLjava/util/List;)V", "getAotEnable", "()Z", "getComponentEnable", "getDenyComponentList", "()Ljava/util/List;", "getMiddlewareEnable", "getPreParseTabConfigEnable", "getReducerEnable", "getStateEnable", "getTabThreshold", "()D", "isDeny", "componentName", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreCreateOptSwitcher.kt */
public final class PreCreateConfig {
    private final boolean aotEnable;
    private final boolean componentEnable;
    private final List<String> denyComponentList;
    private final boolean middlewareEnable;
    private final boolean preParseTabConfigEnable;
    private final boolean reducerEnable;
    private final boolean stateEnable;
    private final double tabThreshold;

    public PreCreateConfig(boolean componentEnable2, boolean stateEnable2, boolean middlewareEnable2, boolean reducerEnable2, boolean aotEnable2, double tabThreshold2, boolean preParseTabConfigEnable2, List<String> denyComponentList2) {
        this.componentEnable = componentEnable2;
        this.stateEnable = stateEnable2;
        this.middlewareEnable = middlewareEnable2;
        this.reducerEnable = reducerEnable2;
        this.aotEnable = aotEnable2;
        this.tabThreshold = tabThreshold2;
        this.preParseTabConfigEnable = preParseTabConfigEnable2;
        this.denyComponentList = denyComponentList2;
    }

    public final boolean getComponentEnable() {
        return this.componentEnable;
    }

    public final boolean getStateEnable() {
        return this.stateEnable;
    }

    public final boolean getMiddlewareEnable() {
        return this.middlewareEnable;
    }

    public final boolean getReducerEnable() {
        return this.reducerEnable;
    }

    public final boolean getAotEnable() {
        return this.aotEnable;
    }

    public final double getTabThreshold() {
        return this.tabThreshold;
    }

    public final boolean getPreParseTabConfigEnable() {
        return this.preParseTabConfigEnable;
    }

    public final List<String> getDenyComponentList() {
        return this.denyComponentList;
    }

    public final boolean isDeny(String componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        List<String> list = this.denyComponentList;
        if (list != null) {
            return list.contains(componentName);
        }
        return false;
    }
}
