package com.baidu.searchbox.feed.dynamicdetail.silex.processors;

import com.baidu.searchbox.feed.ad.NotifyListChangeCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/dynamicdetail/silex/processors/DynamicImmersiveAdInsertProcessor$initAdInsertModule$1$callback$1", "Lcom/baidu/searchbox/feed/ad/NotifyListChangeCallback;", "notifyInsert", "", "position", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersiveAdInsertProcessor.kt */
public final class DynamicImmersiveAdInsertProcessor$initAdInsertModule$1$callback$1 implements NotifyListChangeCallback {
    final /* synthetic */ DynamicImmersiveAdInsertProcessor this$0;

    DynamicImmersiveAdInsertProcessor$initAdInsertModule$1$callback$1(DynamicImmersiveAdInsertProcessor $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r0 = r0.getCacheManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyInsert(int r3) {
        /*
            r2 = this;
            com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor r0 = r2.this$0
            com.baidu.searchbox.feed.flow.RefreshablePage r0 = r0.getPage()
            r0.notifyDataSetChanged()
            com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor r0 = r2.this$0
            com.baidu.searchbox.feed.listpage.domain.DisplayList r0 = r0.getDisplayList()
            if (r0 == 0) goto L_0x001c
            com.baidu.searchbox.feed.controller.datamanager.FeedCacheManager r0 = r0.getCacheManager()
            if (r0 == 0) goto L_0x001c
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r0.getCacheFeed((int) r3)
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor r1 = r2.this$0
            com.baidu.searchbox.feed.listpage.domain.DisplayList r1 = r1.getDisplayList()
            if (r1 == 0) goto L_0x0030
            java.util.List r1 = r1.getHistoryFeeds()
            if (r1 == 0) goto L_0x0030
            int r1 = r1.size()
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            if (r3 >= r1) goto L_0x0044
            com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor r1 = r2.this$0
            com.baidu.searchbox.feed.listpage.domain.DisplayList r1 = r1.getDisplayList()
            if (r1 == 0) goto L_0x0044
            java.util.List r1 = r1.getHistoryFeeds()
            if (r1 == 0) goto L_0x0044
            r1.add(r3, r0)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.dynamicdetail.silex.processors.DynamicImmersiveAdInsertProcessor$initAdInsertModule$1$callback$1.notifyInsert(int):void");
    }
}
