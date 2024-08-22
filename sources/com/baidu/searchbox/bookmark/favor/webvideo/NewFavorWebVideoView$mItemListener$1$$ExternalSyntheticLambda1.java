package com.baidu.searchbox.bookmark.favor.webvideo;

import android.view.View;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.common.menu.listener.OnCommonMenuItemClickListener;
import com.baidu.searchbox.userassetsaggr.container.ui.FavorHisBottomMenu;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NewFavorWebVideoView$mItemListener$1$$ExternalSyntheticLambda1 implements OnCommonMenuItemClickListener {
    public final /* synthetic */ NewFavorWebVideoView f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ FavorWebVideoModel f$2;
    public final /* synthetic */ FavorHisBottomMenu f$3;

    public /* synthetic */ NewFavorWebVideoView$mItemListener$1$$ExternalSyntheticLambda1(NewFavorWebVideoView newFavorWebVideoView, int i2, FavorWebVideoModel favorWebVideoModel, FavorHisBottomMenu favorHisBottomMenu) {
        this.f$0 = newFavorWebVideoView;
        this.f$1 = i2;
        this.f$2 = favorWebVideoModel;
        this.f$3 = favorHisBottomMenu;
    }

    public final boolean onClick(View view2, CommonMenuItem commonMenuItem) {
        return NewFavorWebVideoView$mItemListener$1.m16668onItemLongClick$lambda3(this.f$0, this.f$1, this.f$2, this.f$3, view2, commonMenuItem);
    }
}
