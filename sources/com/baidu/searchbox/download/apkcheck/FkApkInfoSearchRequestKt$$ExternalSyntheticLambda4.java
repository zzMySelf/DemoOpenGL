package com.baidu.searchbox.download.apkcheck;

import com.baidu.searchbox.download.model.CategoryInfoData;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FkApkInfoSearchRequestKt$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ CategoryInfoData f$0;
    public final /* synthetic */ String[] f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ FkApkInfoSearchRequestKt$$ExternalSyntheticLambda4(CategoryInfoData categoryInfoData, String[] strArr, Function1 function1) {
        this.f$0 = categoryInfoData;
        this.f$1 = strArr;
        this.f$2 = function1;
    }

    public final void run() {
        FkApkInfoSearchRequestKt.m17036checkApkStatus$lambda1(this.f$0, this.f$1, this.f$2);
    }
}
