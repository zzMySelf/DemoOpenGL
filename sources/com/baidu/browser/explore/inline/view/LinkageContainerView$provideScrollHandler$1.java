package com.baidu.browser.explore.inline.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.linkagescroll.LinkageScrollHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0013"}, d2 = {"com/baidu/browser/explore/inline/view/LinkageContainerView$provideScrollHandler$1", "Lcom/baidu/linkagescroll/LinkageScrollHandler;", "canScrollVertically", "", "direction", "", "flingContentVertically", "", "target", "Landroid/view/View;", "velocityY", "getContentHeight", "getScrollY", "isFlinging", "scrollContentBy", "y", "scrollContentToBottom", "scrollContentToTop", "stopContentScroll", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkageContainerView.kt */
public final class LinkageContainerView$provideScrollHandler$1 implements LinkageScrollHandler {
    final /* synthetic */ LinkageContainerView this$0;

    LinkageContainerView$provideScrollHandler$1(LinkageContainerView $receiver) {
        this.this$0 = $receiver;
    }

    public void flingContentVertically(View target, int velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        RecyclerView access$getMRecyclerView$p = this.this$0.mRecyclerView;
        if (access$getMRecyclerView$p != null) {
            access$getMRecyclerView$p.fling(0, velocityY);
        }
    }

    public void scrollContentBy(View target, int y) {
        Intrinsics.checkNotNullParameter(target, "target");
        RecyclerView access$getMRecyclerView$p = this.this$0.mRecyclerView;
        if (access$getMRecyclerView$p != null) {
            access$getMRecyclerView$p.scrollBy(0, y);
        }
    }

    public void scrollContentToTop() {
        RecyclerView access$getMRecyclerView$p = this.this$0.mRecyclerView;
        if (access$getMRecyclerView$p != null) {
            access$getMRecyclerView$p.scrollBy(0, -this.this$0.mScrollY);
        }
        if (this.this$0.mRecyclerView != null) {
            this.this$0.mScrollY = 0;
        }
    }

    public void scrollContentToBottom() {
    }

    public int getScrollY() {
        RecyclerView access$getMRecyclerView$p = this.this$0.mRecyclerView;
        if (access$getMRecyclerView$p != null) {
            return access$getMRecyclerView$p.getScrollY();
        }
        return 0;
    }

    public int getContentHeight() {
        RecyclerView access$getMRecyclerView$p = this.this$0.mRecyclerView;
        if (access$getMRecyclerView$p != null) {
            return access$getMRecyclerView$p.getHeight();
        }
        return 0;
    }

    public void stopContentScroll(View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        RecyclerView access$getMRecyclerView$p = this.this$0.mRecyclerView;
        if (access$getMRecyclerView$p != null) {
            access$getMRecyclerView$p.stopScroll();
        }
    }

    public boolean canScrollVertically(int direction) {
        return this.this$0.canScrollVertically(direction);
    }

    public boolean isFlinging() {
        return false;
    }
}
