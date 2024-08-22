package com.baidu.searchbox.home.weather;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeWeatherManager$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ IFetchWeatherDataListener f$0;

    public /* synthetic */ HomeWeatherManager$$ExternalSyntheticLambda7(IFetchWeatherDataListener iFetchWeatherDataListener) {
        this.f$0 = iFetchWeatherDataListener;
    }

    public final void run() {
        this.f$0.onGetLocationFailed();
    }
}
