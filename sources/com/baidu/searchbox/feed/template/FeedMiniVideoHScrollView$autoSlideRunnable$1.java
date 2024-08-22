package com.baidu.searchbox.feed.template;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/feed/template/FeedMiniVideoHScrollView$autoSlideRunnable$1", "Ljava/lang/Runnable;", "run", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedMiniVideoHScrollView.kt */
public final class FeedMiniVideoHScrollView$autoSlideRunnable$1 implements Runnable {
    final /* synthetic */ FeedMiniVideoHScrollView this$0;

    FeedMiniVideoHScrollView$autoSlideRunnable$1(FeedMiniVideoHScrollView $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            r0 = 0
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView r1 = r6.this$0
            boolean r1 = r1.isFeedScrolling
            if (r1 != 0) goto L_0x0046
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView r1 = r6.this$0
            androidx.recyclerview.widget.RecyclerView r1 = r1.recyclerView
            if (r1 == 0) goto L_0x0016
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r1.getLayoutManager()
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            boolean r2 = r1 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r2 == 0) goto L_0x0046
            r2 = r1
            androidx.recyclerview.widget.LinearLayoutManager r2 = (androidx.recyclerview.widget.LinearLayoutManager) r2
            int r2 = r2.findFirstVisibleItemPosition()
            int r2 = r2 + 1
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView r3 = r6.this$0
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter r3 = r3.adapter
            if (r3 == 0) goto L_0x0031
            int r3 = r3.getItemCount()
            goto L_0x0032
        L_0x0031:
            r3 = 0
        L_0x0032:
            int r4 = r3 + -1
            if (r2 >= r4) goto L_0x0046
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView r4 = r6.this$0
            androidx.recyclerview.widget.RecyclerView r4 = r4.recyclerView
            if (r4 == 0) goto L_0x0041
            r4.smoothScrollToPosition(r2)
        L_0x0041:
            int r4 = r3 + -2
            if (r2 != r4) goto L_0x0046
            r0 = 1
        L_0x0046:
            if (r0 == 0) goto L_0x004e
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView r1 = r6.this$0
            r1.stopAutoSlide()
            goto L_0x0068
        L_0x004e:
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView r1 = r6.this$0
            com.baidu.searchbox.feed.model.FeedBaseModel r1 = r1.getFeedModel()
            com.baidu.searchbox.feed.model.FeedItemData r1 = r1.data
            if (r1 == 0) goto L_0x0069
            com.baidu.searchbox.feed.model.FeedItemMiniVideo r1 = (com.baidu.searchbox.feed.model.FeedItemMiniVideo) r1
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView r2 = r6.this$0
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView$AutoSlideHandler r2 = r2.getAutoSlideHandler()
            r3 = r6
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            long r4 = r1.slideIntervalTime
            r2.postDelayed(r3, r4)
        L_0x0068:
            return
        L_0x0069:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedItemMiniVideo"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.FeedMiniVideoHScrollView$autoSlideRunnable$1.run():void");
    }
}
