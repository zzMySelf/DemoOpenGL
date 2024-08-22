package com.baidu.searchbox.personalcenter.loginview;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginInterceptor$$ExternalSyntheticLambda4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LoginInterceptor$$ExternalSyntheticLambda4(Function0 function0, String str) {
        this.f$0 = function0;
        this.f$1 = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        LoginInterceptor.m2205showBrowserModeDialogWithOneKey$lambda8(this.f$0, this.f$1, dialogInterface, i2);
    }
}
