package com.baidu.android.ext.widget.dialog;

import com.baidu.android.ext.widget.dialog.LoadingDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/android/ext/widget/dialog/LoadingDialog$setOnCloseListener$1", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$OnCloseListener;", "onCloseByBtn", "", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadingDialog.kt */
public final class LoadingDialog$setOnCloseListener$1 implements LoadingDialog.OnCloseListener {
    final /* synthetic */ Function0<Unit> $onCloseListener;

    LoadingDialog$setOnCloseListener$1(Function0<Unit> $onCloseListener2) {
        this.$onCloseListener = $onCloseListener2;
    }

    public void onCloseByBtn() {
        this.$onCloseListener.invoke();
    }
}
