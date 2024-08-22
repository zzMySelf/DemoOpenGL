package com.baidu.searchbox.weather.comps.page.locationcheck;

import com.baidu.searchbox.weather.WeatherLocationConfig;
import com.baidu.searchbox.weather.model.WeatherModel;
import com.baidu.searchbox.weather.repo.WeatherRequest;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationCheckViewModel$$ExternalSyntheticLambda0 implements Action1 {
    public final /* synthetic */ LocationCheckViewModel f$0;
    public final /* synthetic */ WeatherModel f$1;
    public final /* synthetic */ WeatherLocationConfig f$2;
    public final /* synthetic */ WeatherLocationConfig f$3;
    public final /* synthetic */ WeatherRequest f$4;

    public /* synthetic */ LocationCheckViewModel$$ExternalSyntheticLambda0(LocationCheckViewModel locationCheckViewModel, WeatherModel weatherModel, WeatherLocationConfig weatherLocationConfig, WeatherLocationConfig weatherLocationConfig2, WeatherRequest weatherRequest) {
        this.f$0 = locationCheckViewModel;
        this.f$1 = weatherModel;
        this.f$2 = weatherLocationConfig;
        this.f$3 = weatherLocationConfig2;
        this.f$4 = weatherRequest;
    }

    public final void call(Object obj) {
        LocationCheckViewModel.m7512checkDiffByServer$lambda0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (WeatherModel) obj);
    }
}
