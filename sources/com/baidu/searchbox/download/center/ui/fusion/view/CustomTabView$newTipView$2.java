package com.baidu.searchbox.download.center.ui.fusion.view;

import com.baidu.searchbox.ui.view.BadgeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ui/view/BadgeView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomTabView.kt */
final class CustomTabView$newTipView$2 extends Lambda implements Function0<BadgeView> {
    final /* synthetic */ CustomTabView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomTabView$newTipView$2(CustomTabView customTabView) {
        super(0);
        this.this$0 = customTabView;
    }

    public final BadgeView invoke() {
        return new BadgeView(this.this$0.getContext());
    }
}
