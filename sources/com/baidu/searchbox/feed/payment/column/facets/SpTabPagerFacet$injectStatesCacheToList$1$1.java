package com.baidu.searchbox.feed.payment.column.facets;

import com.baidu.searchbox.feed.flow.IPagerViewCreateCallback;
import com.baidu.searchbox.feed.tab.fragment.FeedBaseFragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/feed/payment/column/facets/SpTabPagerFacet$injectStatesCacheToList$1$1", "Lcom/baidu/searchbox/feed/flow/IPagerViewCreateCallback;", "onPagerViewCreated", "", "onRootViewMounted", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpTabPagerFacet.kt */
public final class SpTabPagerFacet$injectStatesCacheToList$1$1 implements IPagerViewCreateCallback {
    final /* synthetic */ FeedBaseFragment $it;
    final /* synthetic */ SpTabPagerFacet this$0;

    SpTabPagerFacet$injectStatesCacheToList$1$1(SpTabPagerFacet $receiver, FeedBaseFragment $it2) {
        this.this$0 = $receiver;
        this.$it = $it2;
    }

    public void onPagerViewCreated() {
        this.this$0.updateLastReadForListIfNeed();
    }

    public void onRootViewMounted() {
        this.this$0.setWebViewAttribute(this.$it);
    }
}
