package com.baidu.searchbox.smartmenu.views;

import android.widget.FrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/smartmenu/views/SmartMenuView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuPopupWindow.kt */
final class SmartMenuPopupWindow$menuView$2 extends Lambda implements Function0<SmartMenuView> {
    final /* synthetic */ SmartMenuPopupWindow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmartMenuPopupWindow$menuView$2(SmartMenuPopupWindow smartMenuPopupWindow) {
        super(0);
        this.this$0 = smartMenuPopupWindow;
    }

    public final SmartMenuView invoke() {
        SmartMenuView smartMenuView = new SmartMenuView(this.this$0.getContext());
        SmartMenuPopupWindow smartMenuPopupWindow = this.this$0;
        SmartMenuView $this$invoke_u24lambda_u2d2 = smartMenuView;
        FrameLayout.LayoutParams $this$invoke_u24lambda_u2d2_u24lambda_u2d0 = new FrameLayout.LayoutParams(-1, -2);
        $this$invoke_u24lambda_u2d2_u24lambda_u2d0.gravity = 80;
        $this$invoke_u24lambda_u2d2.setLayoutParams($this$invoke_u24lambda_u2d2_u24lambda_u2d0);
        $this$invoke_u24lambda_u2d2.setOnCloseClickListener(new SmartMenuPopupWindow$menuView$2$1$2(smartMenuPopupWindow));
        List it = smartMenuPopupWindow.blockList;
        if (it != null) {
            $this$invoke_u24lambda_u2d2.setBlockList(it);
        }
        return smartMenuView;
    }
}
