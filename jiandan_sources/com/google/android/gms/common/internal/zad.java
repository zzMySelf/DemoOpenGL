package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

public final class zad extends DialogRedirect {
    public final /* synthetic */ Activity val$activity;
    public final /* synthetic */ int val$requestCode;
    public final /* synthetic */ Intent zaos;

    public zad(Intent intent, Activity activity, int i2) {
        this.zaos = intent;
        this.val$activity = activity;
        this.val$requestCode = i2;
    }

    public final void redirect() {
        Intent intent = this.zaos;
        if (intent != null) {
            this.val$activity.startActivityForResult(intent, this.val$requestCode);
        }
    }
}
