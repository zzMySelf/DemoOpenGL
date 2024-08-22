package com.baidu.searchbox.feed.payment.column.facets;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpTitlePaneFacet.kt */
final class SpTitlePaneFacet$initTrainingTimerBar$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SpTitlePaneFacet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpTitlePaneFacet$initTrainingTimerBar$1$2(SpTitlePaneFacet spTitlePaneFacet) {
        super(0);
        this.this$0 = spTitlePaneFacet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        r1 = r1.training;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r4 = this;
            com.baidu.searchbox.feed.payment.column.facets.SpTitlePaneFacet r0 = r4.this$0
            java.lang.Object r0 = r0.getFacetsContext()
            com.baidu.searchbox.feed.payment.column.facets.SpColumnContext r0 = (com.baidu.searchbox.feed.payment.column.facets.SpColumnContext) r0
            com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel r0 = r0.getDetailViewModel()
            boolean r0 = r0.shouldShowCommentTips()
            if (r0 == 0) goto L_0x0041
            com.baidu.searchbox.feed.payment.column.facets.SpTitlePaneFacet r0 = r4.this$0
            com.baidu.searchbox.feed.payment.column.TrainingTimerBar r0 = r0.trainingTimerBar
            if (r0 == 0) goto L_0x0041
            com.baidu.searchbox.feed.payment.widget.TextViewEx r0 = r0.getTipsText()
            if (r0 == 0) goto L_0x0041
            com.baidu.searchbox.feed.payment.column.facets.SpTitlePaneFacet r1 = r4.this$0
            r2 = 0
            java.lang.Object r1 = r1.getFacetsContext()
            com.baidu.searchbox.feed.payment.column.facets.SpColumnContext r1 = (com.baidu.searchbox.feed.payment.column.facets.SpColumnContext) r1
            com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel r1 = r1.getDetailViewModel()
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r1 = r1.getDetailData()
            if (r1 == 0) goto L_0x003a
            com.baidu.searchbox.feed.payment.model.Training r1 = r1.training
            if (r1 == 0) goto L_0x003a
            java.lang.String r1 = r1.commentBubble
            goto L_0x003b
        L_0x003a:
            r1 = 0
        L_0x003b:
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            com.baidu.searchbox.feed.payment.utils.BubbleUtilsKt.showBubble(r1, r3)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.facets.SpTitlePaneFacet$initTrainingTimerBar$1$2.invoke():void");
    }
}
