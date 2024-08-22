package com.baidu.searchbox.feed.template;

import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/feed/template/FeedBaseHScrollViewListener$addOnScrollListener$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBaseHScrollViewListener.kt */
public final class FeedBaseHScrollViewListener$addOnScrollListener$1$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ RecyclerView $this_run;
    final /* synthetic */ FeedBaseHScrollViewListener this$0;

    FeedBaseHScrollViewListener$addOnScrollListener$1$1(FeedBaseHScrollViewListener $receiver, RecyclerView $receiver2) {
        this.this$0 = $receiver;
        this.$this_run = $receiver2;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int lastScrollState = this.this$0.getCurrentScrollState();
        this.this$0.beforeOnScrollStateChanged(newState);
        if (lastScrollState == 0 && newState == 2 && this.this$0.getItemScrollType() != this.this$0.getITEM_OVER_SCROLL()) {
            FeedBaseHScrollViewListener feedBaseHScrollViewListener = this.this$0;
            feedBaseHScrollViewListener.setItemScrollType(feedBaseHScrollViewListener.getITEM_AUTO_SCROLL());
        } else if (lastScrollState != 1 && newState == 1) {
            FeedBaseHScrollViewListener feedBaseHScrollViewListener2 = this.this$0;
            feedBaseHScrollViewListener2.setItemScrollType(feedBaseHScrollViewListener2.getITEM_ACTIVE_SCROLL());
        } else if (newState == 0) {
            if (this.this$0.getItemScrollType() != this.this$0.getITEM_ACTIVE_SCROLL() || this.$this_run.isPressed()) {
                FeedBaseHScrollViewListener feedBaseHScrollViewListener3 = this.this$0;
                feedBaseHScrollViewListener3.setItemScrollType(feedBaseHScrollViewListener3.ITEM_NO_SCROLL);
            } else {
                int tranX = this.this$0.getReboundDistance(lastScrollState);
                if (tranX > 0) {
                    FeedBaseHScrollViewListener feedBaseHScrollViewListener4 = this.this$0;
                    feedBaseHScrollViewListener4.setItemScrollType(feedBaseHScrollViewListener4.getITEM_OVER_SCROLL());
                    recyclerView.smoothScrollBy(-tranX, 0, (Interpolator) null, this.this$0.OVER_SCROLL_DURATION);
                } else {
                    FeedBaseHScrollViewListener feedBaseHScrollViewListener5 = this.this$0;
                    feedBaseHScrollViewListener5.setItemScrollType(feedBaseHScrollViewListener5.ITEM_NO_SCROLL);
                }
            }
        }
        this.this$0.setCurrentScrollState(newState);
        this.this$0.beforeSuperScrollStateChanged(newState);
        super.onScrollStateChanged(recyclerView, newState);
        this.this$0.afterSuperScrollStateChanged(newState);
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.this$0.beforeOnScrolled(dx, dy);
        super.onScrolled(recyclerView, dx, dy);
        this.this$0.afterOnScrolled(dx, dy);
    }
}
