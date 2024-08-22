package com.baidu.searchbox.video.component.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.video.component.base.LayoutInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0019\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&J\b\u0010\u0017\u001a\u00020\rH&J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0012H&J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\"\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020&H\u0016J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020&J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0016J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078DX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8DX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128DX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/video/component/base/AbsFlowComponent;", "M", "Lcom/baidu/searchbox/video/component/base/LayoutInfo;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "Lcom/baidu/searchbox/video/component/base/PagerListener;", "()V", "adapter", "Lcom/baidu/searchbox/video/component/base/FlowAdapter;", "getAdapter", "()Lcom/baidu/searchbox/video/component/base/FlowAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "pagerLayout", "Lcom/baidu/searchbox/video/component/base/PagerLayout;", "getPagerLayout", "()Lcom/baidu/searchbox/video/component/base/PagerLayout;", "pagerLayout$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "createAdapter", "createLayoutManager", "createPagerListener", "com/baidu/searchbox/video/component/base/AbsFlowComponent$createPagerListener$1", "()Lcom/baidu/searchbox/video/component/base/AbsFlowComponent$createPagerListener$1;", "createRecyclerView", "createView", "Landroid/view/View;", "onAttachedToWindow", "", "view", "onDetachedFromWindow", "onPageSelected", "isUp", "", "position", "", "onScrollStateChanged", "state", "scrollBy", "dy", "scrollToPosition", "smoothScrollToPosition", "lib-component-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsFlowComponent.kt */
public abstract class AbsFlowComponent<M extends LayoutInfo> extends LiveDataComponent implements PagerListener {
    private final Lazy adapter$delegate = LazyKt.lazy(new AbsFlowComponent$adapter$2(this));
    private final Lazy pagerLayout$delegate = LazyKt.lazy(new AbsFlowComponent$pagerLayout$2(this));
    private final Lazy recyclerView$delegate = LazyKt.lazy(new AbsFlowComponent$recyclerView$2(this));

    public abstract FlowAdapter<M> createAdapter();

    public abstract PagerLayout createLayoutManager();

    public abstract RecyclerView createRecyclerView();

    /* access modifiers changed from: protected */
    public final RecyclerView getRecyclerView() {
        return (RecyclerView) this.recyclerView$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final PagerLayout getPagerLayout() {
        return (PagerLayout) this.pagerLayout$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final FlowAdapter<M> getAdapter() {
        return (FlowAdapter) this.adapter$delegate.getValue();
    }

    public View createView() {
        getRecyclerView().setItemViewCacheSize(1);
        getRecyclerView().setLayoutManager(getPagerLayout().getLayoutManager());
        getPagerLayout().setPagerListener(createPagerListener());
        getRecyclerView().setAdapter(getAdapter());
        return getRecyclerView();
    }

    public void onAttachedToWindow(View view2) {
    }

    public void onDetachedFromWindow(View view2) {
    }

    public void onPageSelected(boolean isUp, int position, View view2) {
    }

    public void onScrollStateChanged(int state) {
    }

    private final AbsFlowComponent$createPagerListener$1 createPagerListener() {
        return new AbsFlowComponent$createPagerListener$1(this);
    }

    public final void scrollBy(int dy) {
        getRecyclerView().scrollBy(0, dy);
    }

    public void scrollToPosition(int position) {
        getRecyclerView().scrollToPosition(position);
    }

    public final void smoothScrollToPosition(int position) {
        getRecyclerView().smoothScrollToPosition(position);
    }
}
