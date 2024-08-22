package com.baidu.searchbox.base.ui.scheme;

import android.content.DialogInterface;
import com.baidu.searchbox.unitedscheme.CallbackHandler;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UnitedSchemeDialogDispatcher$$ExternalSyntheticLambda4 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ CallbackHandler f$1;

    public /* synthetic */ UnitedSchemeDialogDispatcher$$ExternalSyntheticLambda4(String str, CallbackHandler callbackHandler) {
        this.f$0 = str;
        this.f$1 = callbackHandler;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        UnitedSchemeDialogDispatcher.m16085handleShowNewDialog$lambda9$lambda8(this.f$0, this.f$1, dialogInterface);
    }
}
