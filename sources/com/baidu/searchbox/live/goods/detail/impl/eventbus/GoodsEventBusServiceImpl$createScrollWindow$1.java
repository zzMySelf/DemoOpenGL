package com.baidu.searchbox.live.goods.detail.impl.eventbus;

import com.baidu.nadcore.business.webpanel.IPanelPopupWindowScroll;
import com.baidu.nadcore.business.webpanel.IPanelPopupWindowScrollListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/live/goods/detail/impl/eventbus/GoodsEventBusServiceImpl$createScrollWindow$1", "Lcom/baidu/nadcore/business/webpanel/IPanelPopupWindowScroll;", "getPanelHeight", "", "setScrollListener", "", "listener", "Lcom/baidu/nadcore/business/webpanel/IPanelPopupWindowScrollListener;", "lib-goods-detail-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsEventBusServiceImpl.kt */
public final class GoodsEventBusServiceImpl$createScrollWindow$1 implements IPanelPopupWindowScroll {
    final /* synthetic */ GoodsEventBusServiceImpl this$0;

    GoodsEventBusServiceImpl$createScrollWindow$1(GoodsEventBusServiceImpl $receiver) {
        this.this$0 = $receiver;
    }

    public int getPanelHeight() {
        return this.this$0.windowHeight;
    }

    public void setScrollListener(IPanelPopupWindowScrollListener listener) {
        this.this$0.scrollListener = listener;
    }
}
