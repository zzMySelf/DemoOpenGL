package com.baidu.searchbox.floating.permission;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.searchbox.floating.permission.FloatingPermissionDialog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FloatingPermissionDialog$Builder$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ DialogInterface.OnClickListener f$0;
    public final /* synthetic */ FloatingPermissionDialog.Builder f$1;

    public /* synthetic */ FloatingPermissionDialog$Builder$$ExternalSyntheticLambda0(DialogInterface.OnClickListener onClickListener, FloatingPermissionDialog.Builder builder) {
        this.f$0 = onClickListener;
        this.f$1 = builder;
    }

    public final void onClick(View view2) {
        FloatingPermissionDialog.Builder.m19839setPositiveButton$lambda0(this.f$0, this.f$1, view2);
    }
}
