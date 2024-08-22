package com.baidu.searchbox.video.collectionflow.flow.lazy;

import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.api.LazyLayoutManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.lazy.ComponentHolder;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.common.downgrade.LazyInflateHelper;
import com.baidu.searchbox.video.feedflow.common.downgrade.LazyInflateWrap;
import com.baidu.searchbox.video.feedflow.detail.error.NetErrorState;
import com.baidu.searchbox.video.feedflow.detail.toast.TipState;
import com.baidu.searchbox.video.feedflow.flow.loading.FlowLoadingState;
import com.baidu.searchbox.video.feedflow.tab.lazy.TabLazyInflateState;
import com.baidu.searchbox.video.hotflow.detail.lazy.feature.HotFlowState;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dJ\u001e\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0006\u0010%\u001a\u00020&R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001a\u0010\u000b¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/flow/lazy/SecondaryPageFlowLazyInflateHelper;", "", "layoutManager", "Lcom/baidu/searchbox/feed/detail/arch/api/LazyLayoutManager;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "(Lcom/baidu/searchbox/feed/detail/arch/api/LazyLayoutManager;Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;)V", "flowNetErrorHolder", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateWrap;", "Lcom/baidu/searchbox/video/feedflow/detail/error/NetErrorState;", "getFlowNetErrorHolder", "()Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateWrap;", "flowNetErrorHolder$delegate", "Lkotlin/Lazy;", "inflateHelper", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateHelper;", "getLayoutManager", "()Lcom/baidu/searchbox/feed/detail/arch/api/LazyLayoutManager;", "loadingHolder", "Lcom/baidu/searchbox/video/feedflow/flow/loading/FlowLoadingState;", "getLoadingHolder", "loadingHolder$delegate", "getManager", "()Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "tipHolder", "Lcom/baidu/searchbox/video/feedflow/detail/toast/TipState;", "getTipHolder", "tipHolder$delegate", "lazyInflateLoading", "Lcom/baidu/searchbox/feed/detail/lazy/ComponentHolder;", "lazyInflateNetError", "lazyInflateTip", "subscriber", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondaryPageFlowLazyInflateHelper.kt */
public final class SecondaryPageFlowLazyInflateHelper {
    private final Lazy flowNetErrorHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageFlowLazyInflateHelper$flowNetErrorHolder$2(this));
    /* access modifiers changed from: private */
    public final LazyInflateHelper inflateHelper;
    private final LazyLayoutManager<?> layoutManager;
    private final Lazy loadingHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageFlowLazyInflateHelper$loadingHolder$2(this));
    private final ComponentArchManager manager;
    private final Lazy tipHolder$delegate = BdPlayerUtils.lazyNone(new SecondaryPageFlowLazyInflateHelper$tipHolder$2(this));

    public SecondaryPageFlowLazyInflateHelper(LazyLayoutManager<?> layoutManager2, ComponentArchManager manager2) {
        Intrinsics.checkNotNullParameter(layoutManager2, "layoutManager");
        Intrinsics.checkNotNullParameter(manager2, FeedStatisticConstants.UBC_TYPE_PLUS);
        this.layoutManager = layoutManager2;
        this.manager = manager2;
        this.inflateHelper = new LazyInflateHelper(layoutManager2, manager2);
    }

    public final LazyLayoutManager<?> getLayoutManager() {
        return this.layoutManager;
    }

    public final ComponentArchManager getManager() {
        return this.manager;
    }

    private final LazyInflateWrap<TipState> getTipHolder() {
        return (LazyInflateWrap) this.tipHolder$delegate.getValue();
    }

    private final LazyInflateWrap<FlowLoadingState> getLoadingHolder() {
        return (LazyInflateWrap) this.loadingHolder$delegate.getValue();
    }

    private final LazyInflateWrap<NetErrorState> getFlowNetErrorHolder() {
        return (LazyInflateWrap) this.flowNetErrorHolder$delegate.getValue();
    }

    public final ComponentHolder lazyInflateTip() {
        return getTipHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateNetError() {
        return getFlowNetErrorHolder().lazyInflate();
    }

    public final ComponentHolder lazyInflateLoading() {
        return getLoadingHolder().lazyInflate();
    }

    public final void subscriber(Store<CommonState> store, LifecycleOwner owner) {
        HotFlowState $this$subscriber_u24lambda_u2d4;
        TabLazyInflateState $this$subscriber_u24lambda_u2d1;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (!(store == null || ($this$subscriber_u24lambda_u2d1 = (TabLazyInflateState) store.subscribe((Class<T>) TabLazyInflateState.class)) == null)) {
            $this$subscriber_u24lambda_u2d1.getInflateTip().observe(owner, new SecondaryPageFlowLazyInflateHelper$$ExternalSyntheticLambda0(this));
        }
        if (store != null && ($this$subscriber_u24lambda_u2d4 = (HotFlowState) store.subscribe((Class<T>) HotFlowState.class)) != null) {
            $this$subscriber_u24lambda_u2d4.getInflateLoading().observe(owner, new SecondaryPageFlowLazyInflateHelper$$ExternalSyntheticLambda1(this));
            $this$subscriber_u24lambda_u2d4.getInflateNetError().observe(owner, new SecondaryPageFlowLazyInflateHelper$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-1$lambda-0  reason: not valid java name */
    public static final void m5184subscriber$lambda1$lambda0(SecondaryPageFlowLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getTipHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-4$lambda-2  reason: not valid java name */
    public static final void m5185subscriber$lambda4$lambda2(SecondaryPageFlowLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLoadingHolder().onInflate();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscriber$lambda-4$lambda-3  reason: not valid java name */
    public static final void m5186subscriber$lambda4$lambda3(SecondaryPageFlowLazyInflateHelper this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFlowNetErrorHolder().onInflate();
    }
}
