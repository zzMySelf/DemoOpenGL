package com.baidu.growthsystem.wealth.context.popupinterceptor;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/baidu/growthsystem/wealth/context/popupinterceptor/DialogPopupInterceptor;", "Lcom/baidu/growthsystem/wealth/context/popupinterceptor/IDialogPopupInterceptor;", "()V", "onDialogDismissed", "", "type", "", "onDialogShown", "showAble", "", "wealth-task-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IDialogPopupInterceptor.kt */
public abstract class DialogPopupInterceptor implements IDialogPopupInterceptor {
    public void onDialogShown(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public void onDialogDismissed(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public final boolean showAble() {
        return showAbleWithReason().getShowAble();
    }
}
