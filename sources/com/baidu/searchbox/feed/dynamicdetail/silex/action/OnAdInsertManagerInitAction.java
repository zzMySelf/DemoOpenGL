package com.baidu.searchbox.feed.dynamicdetail.silex.action;

import com.baidu.searchbox.feed.ad.ioc.INadDynamicImmersiveInsertManager;
import com.baidu.texas.context.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/action/OnAdInsertManagerInitAction;", "Lcom/baidu/texas/context/Action;", "adInsertManager", "Lcom/baidu/searchbox/feed/ad/ioc/INadDynamicImmersiveInsertManager;", "(Lcom/baidu/searchbox/feed/ad/ioc/INadDynamicImmersiveInsertManager;)V", "getAdInsertManager", "()Lcom/baidu/searchbox/feed/ad/ioc/INadDynamicImmersiveInsertManager;", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicNadActions.kt */
public final class OnAdInsertManagerInitAction implements Action {
    private final INadDynamicImmersiveInsertManager adInsertManager;

    public OnAdInsertManagerInitAction(INadDynamicImmersiveInsertManager adInsertManager2) {
        this.adInsertManager = adInsertManager2;
    }

    public final INadDynamicImmersiveInsertManager getAdInsertManager() {
        return this.adInsertManager;
    }
}
