package com.dxmpay.wallet.core;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.OrientationEventListener;

public class a extends OrientationEventListener {
    public Context a;

    public a(Context context) {
        super(context);
        this.a = context;
    }

    public void a() {
        disable();
        this.a = null;
    }

    public void onOrientationChanged(int i2) {
        Context context = this.a;
        if (!(context instanceof Activity)) {
            return;
        }
        if (Build.VERSION.SDK_INT != 26 || context.getApplicationInfo().targetSdkVersion <= 26) {
            ((Activity) this.a).setRequestedOrientation(1);
        }
    }
}
