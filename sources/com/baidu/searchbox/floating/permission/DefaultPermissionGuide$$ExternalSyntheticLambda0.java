package com.baidu.searchbox.floating.permission;

import android.content.DialogInterface;
import com.baidu.searchbox.floating.permission.FloatPermissionUtil;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultPermissionGuide$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ FloatPermissionUtil.OnPermissionResult f$0;

    public /* synthetic */ DefaultPermissionGuide$$ExternalSyntheticLambda0(FloatPermissionUtil.OnPermissionResult onPermissionResult) {
        this.f$0 = onPermissionResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        DefaultPermissionGuide.m19833showGuideDialog$lambda0(this.f$0, dialogInterface, i2);
    }
}
