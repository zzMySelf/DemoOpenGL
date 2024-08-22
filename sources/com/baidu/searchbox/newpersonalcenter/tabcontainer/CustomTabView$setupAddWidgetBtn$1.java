package com.baidu.searchbox.newpersonalcenter.tabcontainer;

import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomTabView.kt */
final class CustomTabView$setupAddWidgetBtn$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ CustomTabView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomTabView$setupAddWidgetBtn$1(CustomTabView customTabView) {
        super(1);
        this.this$0 = customTabView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Boolean) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean it) {
        this.this$0.isAddWidgetBtnVisible = it != null ? it.booleanValue() : false;
        if (this.this$0.isAddWidgetBtnVisible) {
            ViewParent parent = this.this$0.getAddWidgetButton().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.this$0.getAddWidgetButton());
            }
            CustomTabView customTabView = this.this$0;
            customTabView.addView(customTabView.getAddWidgetButton());
        }
    }
}
