package com.baidu.searchbox.video.feedflow.detail.bottom.statistic;

import androidx.lifecycle.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BottomBarStatisticPlugin$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ BottomBarUbcState f$0;
    public final /* synthetic */ BottomBarStatisticPlugin f$1;

    public /* synthetic */ BottomBarStatisticPlugin$$ExternalSyntheticLambda0(BottomBarUbcState bottomBarUbcState, BottomBarStatisticPlugin bottomBarStatisticPlugin) {
        this.f$0 = bottomBarUbcState;
        this.f$1 = bottomBarStatisticPlugin;
    }

    public final void onChanged(Object obj) {
        BottomBarStatisticPlugin.m10857onCreate$lambda5$lambda1(this.f$0, this.f$1, (BottomBarCommentClickedAction) obj);
    }
}
