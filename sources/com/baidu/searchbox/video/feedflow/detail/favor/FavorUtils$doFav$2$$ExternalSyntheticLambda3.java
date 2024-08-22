package com.baidu.searchbox.video.feedflow.detail.favor;

import com.baidu.searchbox.video.feedflow.detail.favor.FavorUtils;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FavorUtils$doFav$2$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ FavorUtils.DemoteFavorListener f$0;
    public final /* synthetic */ Ref.BooleanRef f$1;
    public final /* synthetic */ Ref.ObjectRef f$2;
    public final /* synthetic */ FavorToastType f$3;
    public final /* synthetic */ boolean f$4;

    public /* synthetic */ FavorUtils$doFav$2$$ExternalSyntheticLambda3(FavorUtils.DemoteFavorListener demoteFavorListener, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, FavorToastType favorToastType, boolean z) {
        this.f$0 = demoteFavorListener;
        this.f$1 = booleanRef;
        this.f$2 = objectRef;
        this.f$3 = favorToastType;
        this.f$4 = z;
    }

    public final void run() {
        FavorUtils$doFav$2.m11345onExecute$lambda3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
