package com.baidu.searchbox.home.weather;

import com.baidu.searchbox.home.weather.HomeWeatherManager;
import com.baidu.searchbox.home.weather.request.WeatherRequestSession;
import com.baidu.searchbox.location.LocationInfo;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeWeatherManager$2$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ HomeWeatherManager.AnonymousClass2 f$0;
    public final /* synthetic */ WeatherRequestSession f$1;
    public final /* synthetic */ LocationInfo f$2;

    public /* synthetic */ HomeWeatherManager$2$$ExternalSyntheticLambda0(HomeWeatherManager.AnonymousClass2 r1, WeatherRequestSession weatherRequestSession, LocationInfo locationInfo) {
        this.f$0 = r1;
        this.f$1 = weatherRequestSession;
        this.f$2 = locationInfo;
    }

    public final void run() {
        this.f$0.m20304lambda$onReceiveLocation$0$combaidusearchboxhomeweatherHomeWeatherManager$2(this.f$1, this.f$2);
    }
}
