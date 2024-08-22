package com.baidu.searchbox.bookmark.favor.playlet;

import com.baidu.android.common.menu.CommonMenu;
import com.baidu.android.common.menu.listener.OnCommonMenuDisplayListener;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.userassetsaggr.container.ui.FavorHisBottomMenu;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FavorPlayletView$mItemListener$1$$ExternalSyntheticLambda0 implements OnCommonMenuDisplayListener {
    public final /* synthetic */ FavorHisBottomMenu f$0;
    public final /* synthetic */ FavorModel f$1;

    public /* synthetic */ FavorPlayletView$mItemListener$1$$ExternalSyntheticLambda0(FavorHisBottomMenu favorHisBottomMenu, FavorModel favorModel) {
        this.f$0 = favorHisBottomMenu;
        this.f$1 = favorModel;
    }

    public final void onDisplay(CommonMenu commonMenu, boolean z) {
        FavorPlayletView$mItemListener$1.m16647onItemLongClick$lambda0(this.f$0, this.f$1, commonMenu, z);
    }
}
