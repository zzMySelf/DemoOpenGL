package com.baidu.searchbox.smartmenu.views;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.android.util.devices.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/smartmenu/views/SmartMenuResumePlayBlockView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuView.kt */
final class SmartMenuView$resumePlayCardView$2 extends Lambda implements Function0<SmartMenuResumePlayBlockView> {
    final /* synthetic */ SmartMenuView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartMenuView$resumePlayCardView$2(SmartMenuView smartMenuView) {
        super(0);
        this.this$0 = smartMenuView;
    }

    public final SmartMenuResumePlayBlockView invoke() {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SmartMenuResumePlayBlockView smartMenuResumePlayBlockView = new SmartMenuResumePlayBlockView(context);
        SmartMenuResumePlayBlockView $this$invoke_u24lambda_u2d2 = smartMenuResumePlayBlockView;
        LinearLayout.LayoutParams $this$invoke_u24lambda_u2d2_u24lambda_u2d0 = new LinearLayout.LayoutParams(-1, -2);
        $this$invoke_u24lambda_u2d2_u24lambda_u2d0.topMargin = DeviceUtils.ScreenInfo.dp2px($this$invoke_u24lambda_u2d2.getContext(), 8.0f);
        $this$invoke_u24lambda_u2d2.setLayoutParams($this$invoke_u24lambda_u2d2_u24lambda_u2d0);
        $this$invoke_u24lambda_u2d2.getViewTreeObserver().addOnGlobalLayoutListener(new SmartMenuView$resumePlayCardView$2$$ExternalSyntheticLambda0($this$invoke_u24lambda_u2d2));
        return smartMenuResumePlayBlockView;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m3257invoke$lambda2$lambda1(SmartMenuResumePlayBlockView $this_apply) {
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        $this_apply.setPivotX(((float) $this_apply.getWidth()) / 2.0f);
        $this_apply.setPivotY(0.0f);
    }
}
