package com.baidu.searchbox.video.component.toast;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.video.component.toast.ToastAction;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ToastPlugin$$ExternalSyntheticLambda0 implements UniversalToast.ToastCallback {
    public final /* synthetic */ ToastPlugin f$0;
    public final /* synthetic */ ToastAction.Show f$1;

    public /* synthetic */ ToastPlugin$$ExternalSyntheticLambda0(ToastPlugin toastPlugin, ToastAction.Show show) {
        this.f$0 = toastPlugin;
        this.f$1 = show;
    }

    public final void onToastClick() {
        ToastPlugin.m5258showToast$lambda4(this.f$0, this.f$1);
    }
}
