package com.baidu.searchbox.settings.teenager.view;

import android.view.View;
import com.baidu.searchbox.settings.teenager.util.TeenagerConstants;
import com.baidu.searchbox.settings.teenager.util.TeenagerUbcHelper;
import com.baidu.searchbox.settings.teenager.view.PasswordContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/settings/teenager/view/PasswordContentView$handleClose$3", "Lcom/baidu/searchbox/settings/teenager/view/PasswordContentView$AppealTextClickListener;", "onClick", "", "widget", "Landroid/view/View;", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PasswordContentView.kt */
public final class PasswordContentView$handleClose$3 implements PasswordContentView.AppealTextClickListener {
    final /* synthetic */ PasswordContentView this$0;

    PasswordContentView$handleClose$3(PasswordContentView $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        TeenagerUbcHelper.INSTANCE.ubc(TeenagerConstants.UBC_VALUE_KEY_ASK, "mode_on", "click");
        this.this$0.mActivity.handlePasswordAppeal$lib_settings_teenager_release();
    }
}
