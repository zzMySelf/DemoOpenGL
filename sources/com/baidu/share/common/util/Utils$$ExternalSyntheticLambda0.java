package com.baidu.share.common.util;

import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Utils$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int f$0;

    public /* synthetic */ Utils$$ExternalSyntheticLambda0(int i2) {
        this.f$0 = i2;
    }

    public final void run() {
        Toast.makeText(AppRuntime.getAppContext(), this.f$0, 0).show();
    }
}
