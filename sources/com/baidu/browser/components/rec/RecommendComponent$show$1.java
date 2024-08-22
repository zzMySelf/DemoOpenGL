package com.baidu.browser.components.rec;

import android.view.ViewGroup;
import com.baidu.searchbox.ng.errorview.rec.model.RecResponseData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "success", "", "result", "Lcom/baidu/searchbox/ng/errorview/rec/model/RecResponseData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendComponent.kt */
final class RecommendComponent$show$1 extends Lambda implements Function2<Boolean, RecResponseData, Unit> {
    final /* synthetic */ String $eventType;
    final /* synthetic */ ViewGroup $parentView;
    final /* synthetic */ RecommendComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecommendComponent$show$1(ViewGroup viewGroup, RecommendComponent recommendComponent, String str) {
        super(2);
        this.$parentView = viewGroup;
        this.this$0 = recommendComponent;
        this.$eventType = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), (RecResponseData) p2);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        r2 = r9.getRsrgData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(boolean r8, com.baidu.searchbox.ng.errorview.rec.model.RecResponseData r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x00c1
            r1 = 1
            if (r9 == 0) goto L_0x0014
            com.baidu.searchbox.ng.errorview.rec.model.RsrgData r2 = r9.getRsrgData()
            if (r2 == 0) goto L_0x0014
            boolean r2 = r2.isValid()
            if (r2 != r1) goto L_0x0014
            r2 = r1
            goto L_0x0015
        L_0x0014:
            r2 = r0
        L_0x0015:
            if (r2 == 0) goto L_0x00c1
            android.view.ViewGroup r2 = r7.$parentView
            if (r2 != 0) goto L_0x001d
            goto L_0x00c1
        L_0x001d:
            com.baidu.browser.components.rec.RecommendComponent r0 = r7.this$0
            com.baidu.searchbox.ng.errorview.rec.view.RecommendView r0 = r0.recView
            if (r0 != 0) goto L_0x0048
            com.baidu.browser.components.rec.RecommendComponent r0 = r7.this$0
            com.baidu.searchbox.ng.errorview.rec.view.RecommendView r2 = new com.baidu.searchbox.ng.errorview.rec.view.RecommendView
            com.baidu.browser.components.rec.RecommendComponent r3 = r7.this$0
            com.baidu.browser.arch.component.IBrowserComponentManager r3 = r3.getManager()
            android.content.Context r3 = r3.getContext()
            r2.<init>(r3)
            com.baidu.browser.components.rec.RecommendComponent r3 = r7.this$0
            r4 = r2
            r5 = 0
            com.baidu.browser.components.rec.RecommendComponent$show$1$1$1 r6 = new com.baidu.browser.components.rec.RecommendComponent$show$1$1$1
            r6.<init>(r3)
            com.baidu.searchbox.ng.errorview.rec.view.RecommendView$Listener r6 = (com.baidu.searchbox.ng.errorview.rec.view.RecommendView.Listener) r6
            r4.setListener(r6)
            r0.recView = r2
        L_0x0048:
            java.lang.String r0 = r7.$eventType
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "cpage_dead"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = "dead_page"
            goto L_0x006c
        L_0x0059:
            java.lang.String r0 = r7.$eventType
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "cpage_block"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = "block_page"
            goto L_0x006c
        L_0x006a:
            java.lang.String r0 = "err_page"
        L_0x006c:
            com.baidu.browser.components.rec.RecommendComponent r2 = r7.this$0
            com.baidu.searchbox.ng.errorview.rec.view.RecommendView r2 = r2.recView
            if (r2 == 0) goto L_0x0078
            r2.setPage(r0)
        L_0x0078:
            com.baidu.browser.components.rec.RecommendComponent r2 = r7.this$0
            com.baidu.searchbox.ng.errorview.rec.view.RecommendView r2 = r2.recView
            if (r2 == 0) goto L_0x0083
            r2.setRecData(r9)
        L_0x0083:
            com.baidu.browser.components.rec.RecommendComponent r2 = r7.this$0
            com.baidu.searchbox.ng.errorview.rec.view.RecommendView r2 = r2.recView
            if (r2 == 0) goto L_0x0092
            android.view.ViewGroup r3 = r7.$parentView
            r4 = 80
            r2.showAtLocation(r3, r4)
        L_0x0092:
            java.lang.String r2 = "rec"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.baidu.searchbox.ng.errorview.rec.model.RsrgData r3 = r9.getRsrgData()
            r4 = 0
            if (r3 == 0) goto L_0x00a3
            java.lang.String r3 = r3.getTarget()
            goto L_0x00a4
        L_0x00a3:
            r3 = r4
        L_0x00a4:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L_0x00c0
            com.baidu.searchbox.ng.errorview.utils.GuessDataCacheUtils r2 = com.baidu.searchbox.ng.errorview.utils.GuessDataCacheUtils.INSTANCE
            r2.setShow(r1)
            com.baidu.searchbox.ng.errorview.utils.GuessDataCacheUtils r1 = com.baidu.searchbox.ng.errorview.utils.GuessDataCacheUtils.INSTANCE
            com.baidu.searchbox.ng.errorview.rec.model.RsrgData r2 = r9.getRsrgData()
            if (r2 == 0) goto L_0x00bd
            java.util.List r4 = r2.getItemList()
        L_0x00bd:
            r1.updateGuessList(r4)
        L_0x00c0:
            return
        L_0x00c1:
            com.baidu.browser.components.rec.RecommendComponent r1 = r7.this$0
            r1.isShow = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.components.rec.RecommendComponent$show$1.invoke(boolean, com.baidu.searchbox.ng.errorview.rec.model.RecResponseData):void");
    }
}
