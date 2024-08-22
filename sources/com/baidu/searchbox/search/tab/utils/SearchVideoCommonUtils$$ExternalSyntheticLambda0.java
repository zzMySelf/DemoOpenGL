package com.baidu.searchbox.search.tab.utils;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchVideoCommonUtils$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ RecyclerView.ItemAnimator f$0;
    public final /* synthetic */ RecyclerView f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ SearchVideoCommonUtils$$ExternalSyntheticLambda0(RecyclerView.ItemAnimator itemAnimator, RecyclerView recyclerView, int i2, int i3) {
        this.f$0 = itemAnimator;
        this.f$1 = recyclerView;
        this.f$2 = i2;
        this.f$3 = i3;
    }

    public final void run() {
        SearchVideoCommonUtils.m2881handleDataInsert$lambda0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
