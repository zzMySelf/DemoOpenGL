package com.baidu.searchbox.personalcenter.controller;

import com.baidu.searchbox.account.IAccountDialog;
import com.baidu.searchbox.account.IAccountDialogContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/personalcenter/controller/AccountController$halfAccountDialog$1$onShow$1", "Lcom/baidu/searchbox/account/IAccountDialogContext;", "onDialogCreate", "", "dialog", "Lcom/baidu/searchbox/account/IAccountDialog;", "lib-personal-center-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountController.kt */
public final class AccountController$halfAccountDialog$1$onShow$1 implements IAccountDialogContext {
    final /* synthetic */ AccountController this$0;

    AccountController$halfAccountDialog$1$onShow$1(AccountController $receiver) {
        this.this$0 = $receiver;
    }

    public void onDialogCreate(IAccountDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.this$0.halfDialog = dialog;
    }
}
