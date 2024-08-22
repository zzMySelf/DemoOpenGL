package com.baidu.searchbox.home.weather;

import com.baidu.searchbox.home.weather.request.WeatherRequestSession;
import com.baidu.searchbox.weather.WeatherLocationConfig;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeWeatherManager$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ HomeWeatherManager f$0;
    public final /* synthetic */ WeatherRequestSession f$1;
    public final /* synthetic */ WeatherLocationConfig f$2;

    public /* synthetic */ HomeWeatherManager$$ExternalSyntheticLambda5(HomeWeatherManager homeWeatherManager, WeatherRequestSession weatherRequestSession, WeatherLocationConfig weatherLocationConfig) {
        this.f$0 = homeWeatherManager;
        this.f$1 = weatherRequestSession;
        this.f$2 = weatherLocationConfig;
    }

    public final void run() {
        this.f$0.m20302lambda$requestWeatherIfLocationPicked$5$combaidusearchboxhomeweatherHomeWeatherManager(this.f$1, this.f$2);
    }
}
