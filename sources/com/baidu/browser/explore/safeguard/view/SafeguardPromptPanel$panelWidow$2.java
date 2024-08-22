package com.baidu.browser.explore.safeguard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.common.menu.BaseMenuPopupWindow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/browser/explore/safeguard/view/SafeguardPromptPanel$panelWidow$2$1", "invoke", "()Lcom/baidu/browser/explore/safeguard/view/SafeguardPromptPanel$panelWidow$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeguardPromptPanel.kt */
final class SafeguardPromptPanel$panelWidow$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ SafeguardPromptPanel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeguardPromptPanel$panelWidow$2(SafeguardPromptPanel safeguardPromptPanel) {
        super(0);
        this.this$0 = safeguardPromptPanel;
    }

    public final AnonymousClass1 invoke() {
        Context context = this.this$0.attachView.getContext();
        View access$getAttachView$p = this.this$0.attachView;
        final SafeguardPromptPanel safeguardPromptPanel = this.this$0;
        return new BaseMenuPopupWindow<SafeMenuView>(context, access$getAttachView$p) {
            public SafeMenuView initMainMenuView() {
                Context context = safeguardPromptPanel.attachView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "attachView.context");
                SafeMenuView $this$initMainMenuView_u24lambda_u2d0 = new SafeMenuView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                $this$initMainMenuView_u24lambda_u2d0.setContentView(safeguardPromptPanel.f11143view, new LinearLayout.LayoutParams(-1, -2));
                return $this$initMainMenuView_u24lambda_u2d0;
            }
        };
    }
}
