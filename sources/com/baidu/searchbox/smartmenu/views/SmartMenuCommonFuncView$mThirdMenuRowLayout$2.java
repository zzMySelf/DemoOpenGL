package com.baidu.searchbox.smartmenu.views;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.android.util.devices.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuCommonFuncView.kt */
final class SmartMenuCommonFuncView$mThirdMenuRowLayout$2 extends Lambda implements Function0<LinearLayout> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartMenuCommonFuncView$mThirdMenuRowLayout$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final LinearLayout invoke() {
        LinearLayout linearLayout = new LinearLayout(this.$context);
        Context context = this.$context;
        LinearLayout $this$invoke_u24lambda_u2d1 = linearLayout;
        $this$invoke_u24lambda_u2d1.setVisibility(8);
        $this$invoke_u24lambda_u2d1.setOrientation(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        FrameLayout.LayoutParams $this$invoke_u24lambda_u2d1_u24lambda_u2d0 = layoutParams;
        $this$invoke_u24lambda_u2d1_u24lambda_u2d0.topMargin = DeviceUtils.ScreenInfo.dp2px(context, 7.0f);
        $this$invoke_u24lambda_u2d1_u24lambda_u2d0.leftMargin = DeviceUtils.ScreenInfo.dp2px(context, 3.0f);
        $this$invoke_u24lambda_u2d1_u24lambda_u2d0.rightMargin = DeviceUtils.ScreenInfo.dp2px(context, 3.0f);
        $this$invoke_u24lambda_u2d1.setLayoutParams(layoutParams);
        return linearLayout;
    }
}
