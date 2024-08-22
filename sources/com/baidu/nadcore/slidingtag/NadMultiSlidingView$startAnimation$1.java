package com.baidu.nadcore.slidingtag;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/nadcore/slidingtag/NadMultiSlidingView$startAnimation$1", "Ljava/lang/Runnable;", "run", "", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadMultiSlidingView.kt */
public final class NadMultiSlidingView$startAnimation$1 implements Runnable {
    final /* synthetic */ NadMultiSlidingView this$0;

    NadMultiSlidingView$startAnimation$1(NadMultiSlidingView $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        r4 = r4.tagList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r0 = r7.this$0
            android.os.Handler r0 = r0.mainHandler
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r0 = r7.this$0
            int r0 = r0.getChildCount()
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r2 = r7.this$0
            int r2 = r2.showCount
            if (r0 <= r2) goto L_0x0028
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r0 = r7.this$0
            com.baidu.nadcore.model.NadSlidingTagModel r1 = r0.slidingModel
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r2 = r7.this$0
            long r2 = r2.delayMillis
            r0.startDelay(r1, r2)
            return
        L_0x0028:
            r0 = 0
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r2 = r7.this$0
            int r2 = r2.showCount
            if (r0 > r2) goto L_0x00ab
        L_0x0031:
            if (r0 != 0) goto L_0x0043
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r3 = r7.this$0
            android.view.View r3 = r3.getChildAt(r0)
            if (r3 == 0) goto L_0x00a6
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r4 = r7.this$0
            r5 = 0
            r4.fadeOut(r3)
            goto L_0x00a6
        L_0x0043:
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r3 = r7.this$0
            int r3 = r3.showCount
            if (r0 != r3) goto L_0x0092
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r3 = r7.this$0
            com.baidu.nadcore.model.NadSlidingTagModel r3 = r3.slidingModel
            if (r3 == 0) goto L_0x0069
            java.util.List<com.baidu.nadcore.model.NadSlidingTagModel$TagItem> r3 = r3.tagList
            if (r3 == 0) goto L_0x0069
            int r3 = r3.size()
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r4 = r7.this$0
            r5 = 0
            int r6 = r4.showIndex
            int r6 = r6 + 1
            int r6 = r6 % r3
            r4.showIndex = r6
        L_0x0069:
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r3 = r7.this$0
            com.baidu.nadcore.model.NadSlidingTagModel r4 = r3.slidingModel
            if (r4 == 0) goto L_0x0083
            java.util.List<com.baidu.nadcore.model.NadSlidingTagModel$TagItem> r4 = r4.tagList
            if (r4 == 0) goto L_0x0083
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r5 = r7.this$0
            int r5 = r5.showIndex
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r4, r5)
            com.baidu.nadcore.model.NadSlidingTagModel$TagItem r4 = (com.baidu.nadcore.model.NadSlidingTagModel.TagItem) r4
            goto L_0x0084
        L_0x0083:
            r4 = r1
        L_0x0084:
            android.view.View r3 = r3.getSlidingView(r4)
            if (r3 == 0) goto L_0x00a6
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r4 = r7.this$0
            r5 = 0
            r4.fadeIn(r3)
            goto L_0x00a6
        L_0x0092:
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r3 = r7.this$0
            android.view.View r3 = r3.getChildAt(r0)
            if (r3 == 0) goto L_0x00a6
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r4 = r7.this$0
            r5 = 0
            android.animation.ValueAnimator r4 = r4.getFadeUpPositionAnimator(r3)
            r4.start()
        L_0x00a6:
            if (r0 == r2) goto L_0x00ab
            int r0 = r0 + 1
            goto L_0x0031
        L_0x00ab:
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r0 = r7.this$0
            android.os.Handler r0 = r0.mainHandler
            r1 = r7
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 200(0xc8, double:9.9E-322)
            com.baidu.nadcore.slidingtag.NadMultiSlidingView r4 = r7.this$0
            long r4 = r4.intervalMillis
            long r4 = r4 + r2
            r0.postDelayed(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.slidingtag.NadMultiSlidingView$startAnimation$1.run():void");
    }
}
