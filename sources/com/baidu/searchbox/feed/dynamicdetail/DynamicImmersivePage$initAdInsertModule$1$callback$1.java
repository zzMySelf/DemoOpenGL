package com.baidu.searchbox.feed.dynamicdetail;

import com.baidu.searchbox.feed.ad.NotifyListChangeCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/dynamicdetail/DynamicImmersivePage$initAdInsertModule$1$callback$1", "Lcom/baidu/searchbox/feed/ad/NotifyListChangeCallback;", "notifyInsert", "", "position", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersivePage.kt */
public final class DynamicImmersivePage$initAdInsertModule$1$callback$1 implements NotifyListChangeCallback {
    final /* synthetic */ DynamicImmersivePage this$0;

    DynamicImmersivePage$initAdInsertModule$1$callback$1(DynamicImmersivePage $receiver) {
        this.this$0 = $receiver;
    }

    public void notifyInsert(int position) {
        this.this$0.notifyDataSetChanged();
    }
}
