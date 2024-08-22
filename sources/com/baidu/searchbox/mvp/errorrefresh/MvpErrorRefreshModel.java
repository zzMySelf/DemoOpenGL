package com.baidu.searchbox.mvp.errorrefresh;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.mvp.common.MvpCommonPageId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/mvp/errorrefresh/MvpErrorRefreshModel;", "Lcom/baidu/searchbox/NoProGuard;", "title", "", "refreshClickAction", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lastPage", "Lcom/baidu/searchbox/mvp/common/MvpCommonPageId;", "(Ljava/lang/String;Lcom/baidu/searchbox/feed/detail/frame/Action;Lcom/baidu/searchbox/mvp/common/MvpCommonPageId;)V", "getLastPage", "()Lcom/baidu/searchbox/mvp/common/MvpCommonPageId;", "setLastPage", "(Lcom/baidu/searchbox/mvp/common/MvpCommonPageId;)V", "getRefreshClickAction", "()Lcom/baidu/searchbox/feed/detail/frame/Action;", "setRefreshClickAction", "(Lcom/baidu/searchbox/feed/detail/frame/Action;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MvpErrorRefreshModel.kt */
public final class MvpErrorRefreshModel implements NoProGuard {
    private MvpCommonPageId lastPage;
    private Action refreshClickAction;
    private String title;

    public MvpErrorRefreshModel() {
        this((String) null, (Action) null, (MvpCommonPageId) null, 7, (DefaultConstructorMarker) null);
    }

    public MvpErrorRefreshModel(String title2, Action refreshClickAction2, MvpCommonPageId lastPage2) {
        this.title = title2;
        this.refreshClickAction = refreshClickAction2;
        this.lastPage = lastPage2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MvpErrorRefreshModel(String str, Action action, MvpCommonPageId mvpCommonPageId, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : action, (i2 & 4) != 0 ? null : mvpCommonPageId);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final Action getRefreshClickAction() {
        return this.refreshClickAction;
    }

    public final void setRefreshClickAction(Action action) {
        this.refreshClickAction = action;
    }

    public final MvpCommonPageId getLastPage() {
        return this.lastPage;
    }

    public final void setLastPage(MvpCommonPageId mvpCommonPageId) {
        this.lastPage = mvpCommonPageId;
    }
}
