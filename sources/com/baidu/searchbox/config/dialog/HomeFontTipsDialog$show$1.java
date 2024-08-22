package com.baidu.searchbox.config.dialog;

import com.baidu.searchbox.config.dialog.IHomeFontTipsDialog;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.exclusion.popup.ShowStatus;
import com.baidu.searchbox.exclusion.popup.ShowStatusCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/config/dialog/HomeFontTipsDialog$show$1", "Lcom/baidu/searchbox/exclusion/popup/PopupExclusionManagerMap$Operation;", "onBreaked", "", "onShow", "callback", "Lcom/baidu/searchbox/exclusion/popup/ShowStatusCallback;", "lib-fontsize-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeFontTipsDialog.kt */
public final class HomeFontTipsDialog$show$1 extends PopupExclusionManagerMap.Operation {
    final /* synthetic */ HomeFontTipsDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFontTipsDialog$show$1(HomeFontTipsDialog $receiver, ExclusionType $super_call_param$1, float $super_call_param$2) {
        super($super_call_param$1, $super_call_param$2, false, true);
        this.this$0 = $receiver;
    }

    public void onShow(ShowStatusCallback callback) {
        Function0<Boolean> interceptFun;
        Intrinsics.checkNotNullParameter(callback, "callback");
        IHomeFontTipsDialog.Constructor access$getMConstructor$p = this.this$0.mConstructor;
        boolean z = true;
        if (access$getMConstructor$p == null || (interceptFun = access$getMConstructor$p.getInterceptFun()) == null || !interceptFun.invoke().booleanValue()) {
            z = false;
        }
        if (z) {
            callback.callback(ShowStatus.NOT_SHOW);
            this.this$0.exclusionDisplay();
        } else if (!this.this$0.fontWindowRealShow()) {
            callback.callback(ShowStatus.NOT_SHOW);
            this.this$0.exclusionDisplay();
        } else {
            callback.callback(ShowStatus.REAL_SHOW);
        }
    }

    public void onBreaked() {
        this.this$0.isBreaked = true;
        if (this.this$0.isShowing) {
            this.this$0.hide();
        }
    }
}
