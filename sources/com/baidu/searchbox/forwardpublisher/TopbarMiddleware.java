package com.baidu.searchbox.forwardpublisher;

import com.baidu.searchbox.dynamicpublisher.topbar.TitleModel;
import com.baidu.searchbox.dynamicpublisher.topbar.TopbarAction;
import com.baidu.searchbox.dynamicpublisher.wordlimit.WordLimitAction;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.forwardpublisher.ForwardPublisherCoreAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/forwardpublisher/TopbarMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "isOverLimitText", "", "lastStatus", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "isPublishClickable", "updatePublishBtnStatusIfNeed", "", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopbarMiddleware.kt */
public final class TopbarMiddleware implements Middleware<CommonState> {
    private boolean isOverLimitText;
    private boolean lastStatus;

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof ForwardPublisherCoreAction.InitAction) {
            store.dispatch(new TopbarAction.UpdateTitle(new TitleModel(((ForwardPublisherCoreAction.InitAction) action).getModel().getPlaceTopbarTitle(), (String) null, (String) null, 6, (DefaultConstructorMarker) null)));
            updatePublishBtnStatusIfNeed(store);
        } else if (action instanceof WordLimitAction.WordLimitOverrun) {
            this.isOverLimitText = ((WordLimitAction.WordLimitOverrun) action).getStatus();
            updatePublishBtnStatusIfNeed(store);
        }
        return next.next(store, action);
    }

    private final void updatePublishBtnStatusIfNeed(Store<CommonState> store) {
        boolean newStatus = isPublishClickable();
        if (this.lastStatus != newStatus) {
            this.lastStatus = newStatus;
            store.dispatch(new TopbarAction.ChangePublishBtnStatus(newStatus));
        }
    }

    private final boolean isPublishClickable() {
        return !this.isOverLimitText;
    }
}
