package com.baidu.searchbox.account.userinfo.feed.view;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.searchbox.account.userinfo.utils.PersonalPageExtensionsKt;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.list.widget.CommonFooterView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u0000 U2\u00020\u0001:\u0004UVWXB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bJ\u0016\u0010A\u001a\u00020)2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bJ\b\u0010B\u001a\u00020\bH\u0002J\u0006\u0010C\u001a\u00020\bJ\u0010\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\b2\u0006\u0010E\u001a\u00020FH\u0002J\n\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u000e\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020\u0017J\u000e\u0010L\u001a\u00020)2\u0006\u0010K\u001a\u00020\u0017J\u0010\u0010M\u001a\u00020)2\b\u0010N\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010O\u001a\u00020)J\u0018\u0010P\u001a\u00020)2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u0017J\u000e\u0010T\u001a\u00020)2\u0006\u0010S\u001a\u00020\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R7\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u001a\u00107\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001aR\u0018\u0010:\u001a\u00060;R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006Y"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView;", "Landroid/widget/FrameLayout;", "context", "Landroid/app/Activity;", "mTarget", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroid/app/Activity;Landroidx/recyclerview/widget/RecyclerView;)V", "footerState", "", "getFooterState", "()I", "setFooterState", "(I)V", "<set-?>", "Lcom/baidu/searchbox/feed/list/widget/CommonFooterView;", "footerView", "getFooterView", "()Lcom/baidu/searchbox/feed/list/widget/CommonFooterView;", "headerView", "getHeaderView", "setHeaderView", "(Lcom/baidu/searchbox/feed/list/widget/CommonFooterView;)V", "isFetching", "", "()Z", "setFetching", "(Z)V", "loadMoreTriggerLimit", "getLoadMoreTriggerLimit", "setLoadMoreTriggerLimit", "mOnScrollListener", "Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$OnRecyclerViewScrollListener;", "getMOnScrollListener", "()Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$OnRecyclerViewScrollListener;", "setMOnScrollListener", "(Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$OnRecyclerViewScrollListener;)V", "onLastCompletelyVisibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getOnLastCompletelyVisibleCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLastCompletelyVisibleCallback", "(Lkotlin/jvm/functions/Function1;)V", "onLoadMoreListener", "Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$OnLoadMoreListener;", "getOnLoadMoreListener", "()Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$OnLoadMoreListener;", "setOnLoadMoreListener", "(Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$OnLoadMoreListener;)V", "postHasMore", "getPostHasMore", "setPostHasMore", "preHasMore", "getPreHasMore", "setPreHasMore", "scrollListener", "Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$ScrollListener;", "getScrollListener$lib_userinfo_release", "()Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$ScrollListener;", "dispatchPostLoadMore", "dx", "dy", "dispatchPreLoadMore", "findFirstVisiblePosition", "findLastCompletelyVisiblePosition", "findMax", "array", "", "findMin", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onLoadMoreComplete", "hasMore", "onPreLoadMoreComplete", "setFooter", "footer", "stopAnimation", "triggerPostLoadMore", "last", "", "isPrefetch", "triggerPreLoadMore", "Companion", "OnLoadMoreListener", "OnRecyclerViewScrollListener", "ScrollListener", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DoubleLoadMoreView.kt */
public final class DoubleLoadMoreView extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_LOAD_MORE_TRIGGER_LIMIT = 12;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int footerState;
    private CommonFooterView footerView;
    private CommonFooterView headerView;
    private boolean isFetching;
    private int loadMoreTriggerLimit;
    private OnRecyclerViewScrollListener mOnScrollListener;
    /* access modifiers changed from: private */
    public final RecyclerView mTarget;
    private Function1<? super Integer, Unit> onLastCompletelyVisibleCallback;
    private OnLoadMoreListener onLoadMoreListener;
    private boolean postHasMore;
    private boolean preHasMore;
    private final ScrollListener scrollListener;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$OnLoadMoreListener;", "", "invokePostLoadMore", "", "last", "isPrefetch", "", "invokePreLoadMore", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DoubleLoadMoreView.kt */
    public interface OnLoadMoreListener {
        void invokePostLoadMore(Object obj, boolean z);

        void invokePreLoadMore(boolean z);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$OnRecyclerViewScrollListener;", "", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DoubleLoadMoreView.kt */
    public interface OnRecyclerViewScrollListener {
        void onScrollStateChanged(RecyclerView recyclerView, int i2);

        void onScrolled(RecyclerView recyclerView, int i2, int i3);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoubleLoadMoreView(Activity context, RecyclerView mTarget2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mTarget2, "mTarget");
        this.mTarget = mTarget2;
        this.loadMoreTriggerLimit = 12;
        this.postHasMore = true;
        ScrollListener scrollListener2 = new ScrollListener();
        this.scrollListener = scrollListener2;
        addView(mTarget2, -1, -1);
        mTarget2.addOnScrollListener(scrollListener2);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$Companion;", "", "()V", "DEFAULT_LOAD_MORE_TRIGGER_LIMIT", "", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DoubleLoadMoreView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getLoadMoreTriggerLimit() {
        return this.loadMoreTriggerLimit;
    }

    public final void setLoadMoreTriggerLimit(int i2) {
        this.loadMoreTriggerLimit = i2;
    }

    public final CommonFooterView getHeaderView() {
        return this.headerView;
    }

    public final void setHeaderView(CommonFooterView commonFooterView) {
        this.headerView = commonFooterView;
    }

    public final CommonFooterView getFooterView() {
        return this.footerView;
    }

    public final int getFooterState() {
        return this.footerState;
    }

    public final void setFooterState(int i2) {
        this.footerState = i2;
    }

    public final boolean getPreHasMore() {
        return this.preHasMore;
    }

    public final void setPreHasMore(boolean z) {
        this.preHasMore = z;
    }

    public final boolean getPostHasMore() {
        return this.postHasMore;
    }

    public final void setPostHasMore(boolean z) {
        this.postHasMore = z;
    }

    public final boolean isFetching() {
        return this.isFetching;
    }

    public final void setFetching(boolean z) {
        this.isFetching = z;
    }

    public final OnLoadMoreListener getOnLoadMoreListener() {
        return this.onLoadMoreListener;
    }

    public final void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener2) {
        this.onLoadMoreListener = onLoadMoreListener2;
    }

    public final Function1<Integer, Unit> getOnLastCompletelyVisibleCallback() {
        return this.onLastCompletelyVisibleCallback;
    }

    public final void setOnLastCompletelyVisibleCallback(Function1<? super Integer, Unit> function1) {
        this.onLastCompletelyVisibleCallback = function1;
    }

    public final OnRecyclerViewScrollListener getMOnScrollListener() {
        return this.mOnScrollListener;
    }

    public final void setMOnScrollListener(OnRecyclerViewScrollListener onRecyclerViewScrollListener) {
        this.mOnScrollListener = onRecyclerViewScrollListener;
    }

    public final ScrollListener getScrollListener$lib_userinfo_release() {
        return this.scrollListener;
    }

    public final void setFooter(CommonFooterView footer) {
        this.footerView = footer;
        if (footer != null) {
            PersonalPageExtensionsKt.onStateChangedEx(footer, this.footerState);
        }
    }

    public final void onPreLoadMoreComplete(boolean hasMore) {
        this.preHasMore = hasMore;
        int i2 = 0;
        this.isFetching = false;
        CommonFooterView commonFooterView = this.headerView;
        if (commonFooterView != null) {
            if (!hasMore) {
                i2 = 802;
            }
            PersonalPageExtensionsKt.onStateChangedEx(commonFooterView, i2);
        }
    }

    public final void onLoadMoreComplete(boolean hasMore) {
        this.postHasMore = hasMore;
        int i2 = 0;
        this.isFetching = false;
        if (!hasMore) {
            i2 = 802;
        }
        this.footerState = i2;
        CommonFooterView commonFooterView = this.footerView;
        if (commonFooterView != null) {
            PersonalPageExtensionsKt.onStateChangedEx(commonFooterView, i2);
        }
    }

    private final int findFirstVisiblePosition() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return -1;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return -1;
        }
        int[] completeVisibleInto = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
        ((StaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions(completeVisibleInto);
        return findMin(completeVisibleInto);
    }

    public final int findLastCompletelyVisiblePosition() {
        int lastPosition = -1;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return -1;
        }
        try {
            Result.Companion companion = Result.Companion;
            DoubleLoadMoreView $this$findLastCompletelyVisiblePosition_u24lambda_u2d0 = this;
            if (layoutManager instanceof LinearLayoutManager) {
                lastPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] into = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(into);
                lastPosition = $this$findLastCompletelyVisiblePosition_u24lambda_u2d0.findMax(into);
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        return lastPosition;
    }

    /* access modifiers changed from: private */
    public final RecyclerView.LayoutManager getLayoutManager() {
        return this.mTarget.getLayoutManager();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0094, code lost:
        if (r12 > 0) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatchPostLoadMore(int r11, int r12) {
        /*
            r10 = this;
            com.baidu.searchbox.account.userinfo.feed.view.DoubleLoadMoreView$OnLoadMoreListener r0 = r10.onLoadMoreListener
            if (r0 == 0) goto L_0x00a5
            boolean r0 = r10.postHasMore
            if (r0 == 0) goto L_0x00a5
            com.baidu.searchbox.feed.list.widget.CommonFooterView r0 = r10.footerView
            if (r0 == 0) goto L_0x00a5
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0019
            int r0 = r0.getState()
            r3 = 3
            if (r0 != r3) goto L_0x0019
            r0 = r1
            goto L_0x001a
        L_0x0019:
            r0 = r2
        L_0x001a:
            if (r0 == 0) goto L_0x001e
            goto L_0x00a5
        L_0x001e:
            androidx.recyclerview.widget.RecyclerView r0 = r10.mTarget
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x002b
            int r0 = r0.getItemCount()
            goto L_0x002c
        L_0x002b:
            r0 = r2
        L_0x002c:
            if (r0 <= 0) goto L_0x00a4
            int r3 = r10.findLastCompletelyVisiblePosition()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r10.getLayoutManager()
            r5 = 0
            if (r4 == 0) goto L_0x003e
            android.view.View r4 = r4.findViewByPosition(r3)
            goto L_0x003f
        L_0x003e:
            r4 = r5
        L_0x003f:
            com.baidu.searchbox.feed.list.widget.CommonFooterView r6 = r10.footerView
            if (r6 == 0) goto L_0x0048
            android.view.View r6 = r6.getRootView()
            goto L_0x0049
        L_0x0048:
            r6 = r5
        L_0x0049:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x005d
            kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r6 = r10.onLastCompletelyVisibleCallback
            if (r6 == 0) goto L_0x0068
            int r7 = r3 + -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.invoke(r7)
            goto L_0x0068
        L_0x005d:
            kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r6 = r10.onLastCompletelyVisibleCallback
            if (r6 == 0) goto L_0x0068
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            r6.invoke(r7)
        L_0x0068:
            r6 = 0
            r7 = 0
            int r8 = r10.loadMoreTriggerLimit
            if (r8 <= 0) goto L_0x007a
            r9 = -1
            if (r3 <= r9) goto L_0x007a
            int r8 = r0 - r8
            if (r8 > r3) goto L_0x007a
            r7 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
        L_0x007a:
            if (r7 != 0) goto L_0x009f
            androidx.recyclerview.widget.RecyclerView$LayoutManager r8 = r10.getLayoutManager()
            if (r8 == 0) goto L_0x0087
            android.view.View r8 = r8.findViewByPosition(r3)
            goto L_0x0088
        L_0x0087:
            r8 = r5
        L_0x0088:
            if (r8 == 0) goto L_0x0097
            com.baidu.searchbox.feed.list.widget.CommonFooterView r9 = r10.footerView
            if (r9 == 0) goto L_0x0092
            android.view.View r5 = r9.getContentView()
        L_0x0092:
            if (r8 != r5) goto L_0x0097
            if (r12 <= 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r1 = r2
        L_0x0098:
            if (r1 == 0) goto L_0x009f
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
        L_0x009f:
            if (r6 == 0) goto L_0x00a4
            r10.triggerPostLoadMore(r6, r7)
        L_0x00a4:
            return
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.feed.view.DoubleLoadMoreView.dispatchPostLoadMore(int, int):void");
    }

    public final void triggerPostLoadMore(Object last, boolean isPrefetch) {
        this.footerState = 3;
        CommonFooterView commonFooterView = this.footerView;
        if (commonFooterView != null) {
            PersonalPageExtensionsKt.onStateChangedEx(commonFooterView, 3);
        }
        OnLoadMoreListener onLoadMoreListener2 = this.onLoadMoreListener;
        if (onLoadMoreListener2 != null) {
            onLoadMoreListener2.invokePostLoadMore(last, isPrefetch);
        }
        this.isFetching = true;
        if (AppConfig.isDebug()) {
            Log.d("DoubleLoadStateView", "invoke post load more, isPrefetch:" + isPrefetch);
        }
    }

    public final void dispatchPreLoadMore(int dx, int dy) {
        CommonFooterView commonFooterView;
        if (this.onLoadMoreListener != null && this.preHasMore && (commonFooterView = this.headerView) != null) {
            boolean isViewVisible = true;
            if (!(commonFooterView != null && commonFooterView.getState() == 3)) {
                RecyclerView.Adapter adapter = this.mTarget.getAdapter();
                if ((adapter != null ? adapter.getItemCount() : 0) > 0) {
                    int lastModel = null;
                    int firstVisiblePos = findFirstVisiblePosition();
                    boolean isPrefetch = false;
                    int i2 = this.loadMoreTriggerLimit;
                    if (i2 > 0 && firstVisiblePos > -1 && firstVisiblePos <= i2) {
                        isPrefetch = true;
                        lastModel = 1;
                    }
                    if (!isPrefetch) {
                        RecyclerView.LayoutManager layoutManager = getLayoutManager();
                        View firstView = layoutManager != null ? layoutManager.findViewByPosition(firstVisiblePos) : null;
                        if (((firstView == null || !Intrinsics.areEqual((Object) firstView, (Object) this.headerView)) && firstVisiblePos != 0) || dy >= 0) {
                            isViewVisible = false;
                        }
                        if (isViewVisible) {
                            lastModel = 0;
                        }
                    }
                    if (lastModel != null) {
                        triggerPreLoadMore(isPrefetch);
                    }
                }
            }
        }
    }

    public final void triggerPreLoadMore(boolean isPrefetch) {
        CommonFooterView commonFooterView = this.headerView;
        if (commonFooterView != null) {
            PersonalPageExtensionsKt.onStateChangedEx(commonFooterView, 3);
        }
        OnLoadMoreListener onLoadMoreListener2 = this.onLoadMoreListener;
        if (onLoadMoreListener2 != null) {
            onLoadMoreListener2.invokePreLoadMore(isPrefetch);
        }
        this.isFetching = true;
        if (AppConfig.isDebug()) {
            Log.d("DoubleLoadStateView", "invoke pre load more, isPrefetch:" + isPrefetch);
        }
    }

    public final void stopAnimation() {
        CommonFooterView commonFooterView = this.headerView;
        if (commonFooterView != null) {
            commonFooterView.stopAnimation();
        }
        CommonFooterView commonFooterView2 = this.footerView;
        if (commonFooterView2 != null) {
            commonFooterView2.stopAnimation();
        }
    }

    private final int findMax(int[] array) {
        Integer maxOrNull = ArraysKt.maxOrNull(array);
        if (maxOrNull != null) {
            return maxOrNull.intValue();
        }
        return 0;
    }

    private final int findMin(int[] array) {
        Integer minOrNull = ArraysKt.minOrNull(array);
        if (minOrNull != null) {
            return minOrNull.intValue();
        }
        return 0;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView$ScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "(Lcom/baidu/searchbox/account/userinfo/feed/view/DoubleLoadMoreView;)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DoubleLoadMoreView.kt */
    public final class ScrollListener extends RecyclerView.OnScrollListener {
        public ScrollListener() {
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            if (dy > 0) {
                DoubleLoadMoreView.this.dispatchPostLoadMore(dx, dy);
            }
            if (dy < 0) {
                DoubleLoadMoreView.this.dispatchPreLoadMore(dx, dy);
            }
            OnRecyclerViewScrollListener mOnScrollListener = DoubleLoadMoreView.this.getMOnScrollListener();
            if (mOnScrollListener != null) {
                mOnScrollListener.onScrolled(recyclerView, dx, dy);
            }
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                RecyclerView.Adapter adapter = DoubleLoadMoreView.this.mTarget.getAdapter();
                if ((adapter != null ? adapter.getItemCount() : 0) > 0) {
                    int lastVisiblePos = DoubleLoadMoreView.this.findLastCompletelyVisiblePosition();
                    RecyclerView.LayoutManager access$getLayoutManager = DoubleLoadMoreView.this.getLayoutManager();
                    View view2 = null;
                    View lastView = access$getLayoutManager != null ? access$getLayoutManager.findViewByPosition(lastVisiblePos) : null;
                    CommonFooterView footerView = DoubleLoadMoreView.this.getFooterView();
                    if (footerView != null) {
                        view2 = footerView.getRootView();
                    }
                    if (Intrinsics.areEqual((Object) lastView, (Object) view2)) {
                        Function1<Integer, Unit> onLastCompletelyVisibleCallback = DoubleLoadMoreView.this.getOnLastCompletelyVisibleCallback();
                        if (onLastCompletelyVisibleCallback != null) {
                            onLastCompletelyVisibleCallback.invoke(Integer.valueOf(lastVisiblePos - 1));
                        }
                    } else {
                        Function1<Integer, Unit> onLastCompletelyVisibleCallback2 = DoubleLoadMoreView.this.getOnLastCompletelyVisibleCallback();
                        if (onLastCompletelyVisibleCallback2 != null) {
                            onLastCompletelyVisibleCallback2.invoke(Integer.valueOf(lastVisiblePos));
                        }
                    }
                }
            }
            OnRecyclerViewScrollListener mOnScrollListener = DoubleLoadMoreView.this.getMOnScrollListener();
            if (mOnScrollListener != null) {
                mOnScrollListener.onScrollStateChanged(recyclerView, newState);
            }
        }
    }
}
