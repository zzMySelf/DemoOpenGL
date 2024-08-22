package com.baidu.searchbox.feed.dynamicdetail.silex;

import com.baidu.elinkagescroll.ELinkageScrollListenerAdapter;
import com.baidu.elinkagescroll.EPosIndicator;
import com.baidu.searchbox.feed.dynamicdetail.linkagescroll.DynamicScrollHandler;
import com.baidu.searchbox.ui.CommonEmptyView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/feed/dynamicdetail/silex/DynamicImmersiveSilexActivity$handleScroll$2", "Lcom/baidu/elinkagescroll/ELinkageScrollListenerAdapter;", "onContentScrolled", "", "dy", "", "posIndicator", "Lcom/baidu/elinkagescroll/EPosIndicator;", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersiveSilexActivity.kt */
public final class DynamicImmersiveSilexActivity$handleScroll$2 extends ELinkageScrollListenerAdapter {
    final /* synthetic */ DynamicImmersiveSilexActivity this$0;

    DynamicImmersiveSilexActivity$handleScroll$2(DynamicImmersiveSilexActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onContentScrolled(int dy, EPosIndicator posIndicator) {
        DynamicScrollHandler access$getScrollHandler$p;
        super.onContentScrolled(dy, posIndicator);
        CommonEmptyView access$getNoContentView$p = this.this$0.noContentView;
        boolean z = false;
        if (access$getNoContentView$p != null && access$getNoContentView$p.getVisibility() == 0) {
            z = true;
        }
        if (!z && (access$getScrollHandler$p = this.this$0.scrollHandler) != null) {
            access$getScrollHandler$p.onScrolled(dy);
        }
    }
}
