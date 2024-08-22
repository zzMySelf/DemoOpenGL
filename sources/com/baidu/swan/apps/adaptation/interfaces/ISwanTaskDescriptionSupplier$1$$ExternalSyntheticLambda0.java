package com.baidu.swan.apps.adaptation.interfaces;

import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ISwanTaskDescriptionSupplier$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ TypedCallback f$0;
    public final /* synthetic */ SwanAppLaunchInfo f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ ISwanTaskDescriptionSupplier$1$$ExternalSyntheticLambda0(TypedCallback typedCallback, SwanAppLaunchInfo swanAppLaunchInfo, String str) {
        this.f$0 = typedCallback;
        this.f$1 = swanAppLaunchInfo;
        this.f$2 = str;
    }

    public final void run() {
        this.f$0.onCallback(SwanAppUtils.getAppIconByFresco(this.f$1, this.f$2, true));
    }
}
