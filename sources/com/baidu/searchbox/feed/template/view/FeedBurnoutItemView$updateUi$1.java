package com.baidu.searchbox.feed.template.view;

import android.view.View;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBurnoutItemChildData;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/template/view/FeedBurnoutItemView$updateUi$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBurnoutItemView.kt */
public final class FeedBurnoutItemView$updateUi$1 implements View.OnClickListener {
    final /* synthetic */ Ref.ObjectRef<FeedBaseModel> $feedBaseModel;
    final /* synthetic */ FeedBurnoutItemChildData $model;
    final /* synthetic */ FeedBaseModel $parentModel;
    final /* synthetic */ int $pos;
    final /* synthetic */ FeedBurnoutItemView this$0;

    FeedBurnoutItemView$updateUi$1(Ref.ObjectRef<FeedBaseModel> $feedBaseModel2, FeedBurnoutItemView $receiver, FeedBaseModel $parentModel2, FeedBurnoutItemChildData $model2, int $pos2) {
        this.$feedBaseModel = $feedBaseModel2;
        this.this$0 = $receiver;
        this.$parentModel = $parentModel2;
        this.$model = $model2;
        this.$pos = $pos2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        r1 = (r1 = r1.data).cmd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r13) {
        /*
            r12 = this;
            kotlin.jvm.internal.Ref$ObjectRef<com.baidu.searchbox.feed.model.FeedBaseModel> r0 = r12.$feedBaseModel
            T r0 = r0.element
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = (com.baidu.searchbox.feed.model.FeedBaseModel) r0
            com.baidu.searchbox.feed.biserial.BiSerialFlowItemClickManager.setClickItemMap(r0, r13)
            com.baidu.searchbox.feed.template.view.FeedBurnoutItemView r0 = r12.this$0
            android.content.Context r0 = r0.getContext()
            kotlin.jvm.internal.Ref$ObjectRef<com.baidu.searchbox.feed.model.FeedBaseModel> r1 = r12.$feedBaseModel
            T r1 = r1.element
            com.baidu.searchbox.feed.model.FeedBaseModel r1 = (com.baidu.searchbox.feed.model.FeedBaseModel) r1
            r2 = 0
            if (r1 == 0) goto L_0x0025
            com.baidu.searchbox.feed.model.FeedItemData r1 = r1.data
            if (r1 == 0) goto L_0x0025
            com.baidu.searchbox.feed.model.CString r1 = r1.cmd
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r1.get()
            goto L_0x0026
        L_0x0025:
            r1 = r2
        L_0x0026:
            r3 = 0
            com.baidu.searchbox.feed.util.FeedRouter.invoke(r0, r1, r3)
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r12.$parentModel
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = r0.id
            r3 = r0
            goto L_0x0033
        L_0x0032:
            r3 = r2
        L_0x0033:
            com.baidu.searchbox.feed.model.FeedBurnoutItemChildData r0 = r12.$model
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r0.id
            r4 = r0
            goto L_0x003c
        L_0x003b:
            r4 = r2
        L_0x003c:
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r12.$parentModel
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r0 = r0.runtimeStatus
            int r5 = r0.viewPosition
            int r6 = r12.$pos
            kotlin.jvm.internal.Ref$ObjectRef<com.baidu.searchbox.feed.model.FeedBaseModel> r0 = r12.$feedBaseModel
            T r0 = r0.element
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = (com.baidu.searchbox.feed.model.FeedBaseModel) r0
            if (r0 == 0) goto L_0x0052
            com.baidu.searchbox.feed.model.FeedBackData r0 = r0.feedback
            if (r0 == 0) goto L_0x0052
            java.lang.String r2 = r0.ext
        L_0x0052:
            r7 = r2
            r8 = 0
            java.lang.String r10 = "clk"
            java.lang.String r11 = "index"
            com.baidu.searchbox.feed.controller.FeedDataReportUtils.reportFeedHScrollClick(r3, r4, r5, r6, r7, r8, r10, r11)
            com.baidu.searchbox.feed.model.FeedBurnoutItemChildData r0 = r12.$model
            r1 = 1
            r0.hasClick = r1
            com.baidu.searchbox.feed.model.FeedBurnoutItemChildData r0 = r12.$model
            long r1 = java.lang.System.currentTimeMillis()
            r0.clickTimeMillis = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.view.FeedBurnoutItemView$updateUi$1.onClick(android.view.View):void");
    }
}
