package com.baidu.searchbox.downloads.appsearch.helper;

import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.searchbox.data.DialogData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommonDialogHelper$$ExternalSyntheticLambda0 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ DialogData f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ CommonDialogHelper$$ExternalSyntheticLambda0(String str, DialogData dialogData, boolean z) {
        this.f$0 = str;
        this.f$1 = dialogData;
        this.f$2 = z;
    }

    public final void onDismiss() {
        CommonDialogHelper.lambda$buildNormalCommonWindow$0(this.f$0, this.f$1, this.f$2);
    }
}
