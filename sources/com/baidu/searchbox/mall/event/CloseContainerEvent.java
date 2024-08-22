package com.baidu.searchbox.mall.event;

import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/mall/event/CloseContainerEvent;", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloseContainerEvent.kt */
public final class CloseContainerEvent {
    private final UniqueId token;

    public CloseContainerEvent(UniqueId token2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        this.token = token2;
    }

    public final UniqueId getToken() {
        return this.token;
    }
}
