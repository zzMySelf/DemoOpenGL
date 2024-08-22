package com.baidu.swan.apps.env.so;

import com.baidu.swan.pms.solib.SoPkgInstaller;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SoLibManager$$ExternalSyntheticLambda2 implements SoPkgInstaller.Callback {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ SoLibManager$$ExternalSyntheticLambda2(String str, Ref.ObjectRef objectRef, Function1 function1) {
        this.f$0 = str;
        this.f$1 = objectRef;
        this.f$2 = function1;
    }

    public final void onInstalled(int i2, String str) {
        SoLibManager.m7942tryInstallUpdatePkg$lambda6(this.f$0, this.f$1, this.f$2, i2, str);
    }
}
