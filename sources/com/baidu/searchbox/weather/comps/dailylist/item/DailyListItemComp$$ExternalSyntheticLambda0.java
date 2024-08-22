package com.baidu.searchbox.weather.comps.dailylist.item;

import androidx.lifecycle.Observer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DailyListItemComp$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ DailyListItemComp f$0;
    public final /* synthetic */ DailyListItemViewModel f$1;

    public /* synthetic */ DailyListItemComp$$ExternalSyntheticLambda0(DailyListItemComp dailyListItemComp, DailyListItemViewModel dailyListItemViewModel) {
        this.f$0 = dailyListItemComp;
        this.f$1 = dailyListItemViewModel;
    }

    public final void onChanged(Object obj) {
        DailyListItemComp.m7442bindDate$lambda19(this.f$0, this.f$1, (String) obj);
    }
}
