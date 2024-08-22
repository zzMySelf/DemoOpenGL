package com.baidu.searchbox.impl;

import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.search.pyramid.OperatorStatus;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchH5FavorServiceImpl$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function3 f$1;
    public final /* synthetic */ OperatorStatus f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ FavorModel f$4;
    public final /* synthetic */ FavorModel f$5;

    public /* synthetic */ SearchH5FavorServiceImpl$$ExternalSyntheticLambda2(boolean z, Function3 function3, OperatorStatus operatorStatus, boolean z2, FavorModel favorModel, FavorModel favorModel2) {
        this.f$0 = z;
        this.f$1 = function3;
        this.f$2 = operatorStatus;
        this.f$3 = z2;
        this.f$4 = favorModel;
        this.f$5 = favorModel2;
    }

    public final void run() {
        SearchH5FavorServiceImpl.m20396interceptAddOrRemoveFavor$lambda8$lambda7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
