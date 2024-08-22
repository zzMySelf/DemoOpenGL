package com.tera.scan.account.network;

import android.content.Context;
import android.content.Intent;
import com.mars.kotlin.service.IHandlable;
import fe.mmm.qw.a.yj.qw.de;
import org.jetbrains.annotations.NotNull;

public final class AccountService implements IAccount, IHandlable<IAccount> {
    public AccountService(@NotNull de deVar, @NotNull Context context) {
    }

    public void onHandle(@NotNull Intent intent) {
        if (intent.getAction() == null) {
        }
    }
}
