package com.baidu.searchbox.userassetsaggr.container.film;

import java.util.ArrayList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FavorHisWebFilmInfoManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ Function2 f$1;
    public final /* synthetic */ ArrayList f$2;
    public final /* synthetic */ ArrayList f$3;

    public /* synthetic */ FavorHisWebFilmInfoManager$$ExternalSyntheticLambda1(Ref.IntRef intRef, Function2 function2, ArrayList arrayList, ArrayList arrayList2) {
        this.f$0 = intRef;
        this.f$1 = function2;
        this.f$2 = arrayList;
        this.f$3 = arrayList2;
    }

    public final void run() {
        FavorHisWebFilmInfoManager.m4642getFavorFilmInfo$lambda2(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
