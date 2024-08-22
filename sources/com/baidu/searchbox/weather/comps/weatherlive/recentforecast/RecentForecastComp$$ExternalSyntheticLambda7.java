package com.baidu.searchbox.weather.comps.weatherlive.recentforecast;

import androidx.lifecycle.Observer;
import kotlin.Pair;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RecentForecastComp$$ExternalSyntheticLambda7 implements Observer {
    public final /* synthetic */ RecentForecastComp f$0;

    public /* synthetic */ RecentForecastComp$$ExternalSyntheticLambda7(RecentForecastComp recentForecastComp) {
        this.f$0 = recentForecastComp;
    }

    public final void onChanged(Object obj) {
        RecentForecastComp.m7561bindChartData$lambda11(this.f$0, (Pair) obj);
    }
}
