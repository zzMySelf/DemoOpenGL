package com.baidu.searchbox.settings.teenager.view;

import com.baidu.searchbox.settings.teenager.view.PasswordInputView;
import com.baidu.swan.apps.system.wifi.model.SwanWifiAccessData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/settings/teenager/view/PasswordContentView$handleChangeConfirm$1", "Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$InputComplete;", "complete", "", "password", "", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PasswordContentView.kt */
public final class PasswordContentView$handleChangeConfirm$1 implements PasswordInputView.InputComplete {
    final /* synthetic */ PasswordContentView this$0;

    PasswordContentView$handleChangeConfirm$1(PasswordContentView $receiver) {
        this.this$0 = $receiver;
    }

    public void complete(String password) {
        Intrinsics.checkNotNullParameter(password, SwanWifiAccessData.PARAM_KEY_PASSWORD);
        this.this$0.mActivity.handleChangePassword$lib_settings_teenager_release(password);
    }
}
