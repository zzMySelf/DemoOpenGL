package com.baidu.searchbox.smartmenu.views;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.smartmenu.utils.AnimatorHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuFavorHisBlockView.kt */
final class SmartMenuFavorHisBlockView$onShieldTypeClick$1$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.IntRef $deleteIndex1;
    final /* synthetic */ View $fillOutView1;
    final /* synthetic */ HistoryModel $newModel1;
    final /* synthetic */ SmartMenuFavorHisBlockView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartMenuFavorHisBlockView$onShieldTypeClick$1$4(View view2, SmartMenuFavorHisBlockView smartMenuFavorHisBlockView, HistoryModel historyModel, Ref.IntRef intRef) {
        super(0);
        this.$fillOutView1 = view2;
        this.this$0 = smartMenuFavorHisBlockView;
        this.$newModel1 = historyModel;
        this.$deleteIndex1 = intRef;
    }

    public final void invoke() {
        this.$fillOutView1.setVisibility(4);
        List access$getTempHistoryList$p = this.this$0.tempHistoryList;
        boolean z = true;
        if (access$getTempHistoryList$p == null || !access$getTempHistoryList$p.isEmpty()) {
            z = false;
        }
        if (z) {
            SmartMenuFavorHisBlockView smartMenuFavorHisBlockView = this.this$0;
            AnimatorHelperKt.makeCardHideAnimator(smartMenuFavorHisBlockView, smartMenuFavorHisBlockView.getTitleView(), this.this$0.getJumpBtn());
        } else if (this.$newModel1 == null) {
            View view2 = this.$fillOutView1;
            LinearLayout access$getContentView = this.this$0.getContentView();
            Intrinsics.checkNotNullExpressionValue(access$getContentView, "contentView");
            AnimatorHelperKt.makeTwoItemToSingleItemAnimator(view2, access$getContentView);
        } else {
            this.this$0.getContentView().removeView(this.$fillOutView1);
            if (this.$deleteIndex1.element > this.this$0.getContentView().getChildCount()) {
                this.$deleteIndex1.element = this.this$0.getContentView().getChildCount();
            }
            final SmartMenuFavorHisItemView newView = this.this$0.createFillInView(this.$newModel1, this.$deleteIndex1.element);
            this.this$0.getContentView().addView(newView, this.$deleteIndex1.element);
            AnimatorHelperKt.makeSingleItemShieldShowAnimator(newView, new Function0<Unit>() {
                public final void invoke() {
                    newView.setVisibility(0);
                }
            });
        }
    }
}
