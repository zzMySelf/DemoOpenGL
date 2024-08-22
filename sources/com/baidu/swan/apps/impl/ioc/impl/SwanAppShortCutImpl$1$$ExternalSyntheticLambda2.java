package com.baidu.swan.apps.impl.ioc.impl;

import android.content.Context;
import com.baidu.swan.apps.impl.R;
import com.baidu.swan.apps.toast.UniversalToast;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SwanAppShortCutImpl$1$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ SwanAppShortCutImpl$1$$ExternalSyntheticLambda2(Context context) {
        this.f$0 = context;
    }

    public final void run() {
        UniversalToast.makeText(this.f$0, R.string.swan_app_add_fail_no_retry_tip).showToast();
    }
}
