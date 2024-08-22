package com.baidu.searchbox.feed.silex.config;

import com.baidu.searchbox.feed.silex.refresh.domain.PolicyState;
import com.baidu.searchbox.feed.silex.refresh.domain.RefreshState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/silex/config/SilexState;", "", "refreshState", "Lcom/baidu/searchbox/feed/silex/refresh/domain/RefreshState;", "policyState", "Lcom/baidu/searchbox/feed/silex/refresh/domain/PolicyState;", "(Lcom/baidu/searchbox/feed/silex/refresh/domain/RefreshState;Lcom/baidu/searchbox/feed/silex/refresh/domain/PolicyState;)V", "getPolicyState", "()Lcom/baidu/searchbox/feed/silex/refresh/domain/PolicyState;", "getRefreshState", "()Lcom/baidu/searchbox/feed/silex/refresh/domain/RefreshState;", "lib-feed-silex_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SilexState.kt */
public final class SilexState {
    private final PolicyState policyState;
    private final RefreshState refreshState;

    public SilexState(RefreshState refreshState2, PolicyState policyState2) {
        Intrinsics.checkNotNullParameter(refreshState2, "refreshState");
        Intrinsics.checkNotNullParameter(policyState2, "policyState");
        this.refreshState = refreshState2;
        this.policyState = policyState2;
    }

    public final PolicyState getPolicyState() {
        return this.policyState;
    }

    public final RefreshState getRefreshState() {
        return this.refreshState;
    }
}
