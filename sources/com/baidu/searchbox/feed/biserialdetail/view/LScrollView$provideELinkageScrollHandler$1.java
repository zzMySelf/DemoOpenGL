package com.baidu.searchbox.feed.biserialdetail.view;

import android.view.View;
import com.baidu.elinkagescroll.ELinkageScrollHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0017J\b\u0010\f\u001a\u00020\u0005H\u0017J\b\u0010\r\u001a\u00020\u0005H\u0017J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0014"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/view/LScrollView$provideELinkageScrollHandler$1", "Lcom/baidu/elinkagescroll/ELinkageScrollHandler;", "canScrollVertically", "", "direction", "", "flingContent", "", "target", "Landroid/view/View;", "velocityY", "getVerticalScrollExtent", "getVerticalScrollOffset", "getVerticalScrollRange", "isScrollable", "scrollContentBy", "y", "scrollContentToBottom", "scrollContentToTop", "stopContentScroll", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LScrollView.kt */
public final class LScrollView$provideELinkageScrollHandler$1 implements ELinkageScrollHandler {
    final /* synthetic */ LScrollView this$0;

    LScrollView$provideELinkageScrollHandler$1(LScrollView $receiver) {
        this.this$0 = $receiver;
    }

    public void flingContent(View target, int velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.this$0.fling(velocityY);
    }

    public void scrollContentToTop() {
        this.this$0.scrollTo(0, 0);
    }

    public void scrollContentToBottom() {
        this.this$0.scrollTo(0, getVerticalScrollRange());
    }

    public void stopContentScroll(View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.this$0.fling(0);
    }

    public boolean canScrollVertically(int direction) {
        return this.this$0.canScrollVertically(direction);
    }

    public boolean isScrollable() {
        return true;
    }

    public int getVerticalScrollExtent() {
        return this.this$0.computeVerticalScrollExtent();
    }

    public int getVerticalScrollOffset() {
        return this.this$0.computeVerticalScrollOffset();
    }

    public int getVerticalScrollRange() {
        return this.this$0.computeVerticalScrollRange();
    }

    public void scrollContentBy(View target, int y) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.this$0.scrollBy(0, y);
    }
}
