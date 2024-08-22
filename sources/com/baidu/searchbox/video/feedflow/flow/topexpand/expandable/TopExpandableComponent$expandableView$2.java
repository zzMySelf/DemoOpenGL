package com.baidu.searchbox.video.feedflow.flow.topexpand.expandable;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopExpandableComponent.kt */
final class TopExpandableComponent$expandableView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ TopExpandableComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopExpandableComponent$expandableView$2(TopExpandableComponent topExpandableComponent) {
        super(0);
        this.this$0 = topExpandableComponent;
    }

    public final View invoke() {
        View initView = this.this$0.initView();
        TopExpandableComponent topExpandableComponent = this.this$0;
        View $this$invoke_u24lambda_u2d0 = initView;
        $this$invoke_u24lambda_u2d0.setVisibility(4);
        $this$invoke_u24lambda_u2d0.getViewTreeObserver().addOnGlobalLayoutListener(topExpandableComponent.getGlobalLayoutListener());
        return initView;
    }
}
