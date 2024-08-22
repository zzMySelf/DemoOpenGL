package com.baidu.searchbox.weather.comps.weatherlive.recentforecast;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.weather.model.RecentForecast;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007R,\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/weather/comps/weatherlive/recentforecast/RecentForecastVM;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "chartData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "", "", "getChartData$lib_weather_landing_release", "()Landroidx/lifecycle/MutableLiveData;", "detailPageUrl", "", "getDetailPageUrl$lib_weather_landing_release", "()Ljava/lang/String;", "setDetailPageUrl$lib_weather_landing_release", "(Ljava/lang/String;)V", "heavyText", "getHeavyText$lib_weather_landing_release", "image", "getImage$lib_weather_landing_release", "lightText", "getLightText$lib_weather_landing_release", "tip", "getTip$lib_weather_landing_release", "video", "getVideo$lib_weather_landing_release", "buildColors", "weather", "setData", "", "data", "Lcom/baidu/searchbox/weather/model/RecentForecast;", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecentForecastVM.kt */
public final class RecentForecastVM extends BaseViewModel {
    private final MutableLiveData<Pair<List<Float>, int[]>> chartData = new MutableLiveData<>();
    private String detailPageUrl;
    private final MutableLiveData<String> heavyText = new MutableLiveData<>();
    private final MutableLiveData<String> image = new MutableLiveData<>();
    private final MutableLiveData<String> lightText = new MutableLiveData<>();
    private final MutableLiveData<String> tip = new MutableLiveData<>();
    private final MutableLiveData<String> video = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecentForecastVM(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    public final MutableLiveData<String> getHeavyText$lib_weather_landing_release() {
        return this.heavyText;
    }

    public final MutableLiveData<String> getLightText$lib_weather_landing_release() {
        return this.lightText;
    }

    public final MutableLiveData<String> getImage$lib_weather_landing_release() {
        return this.image;
    }

    public final MutableLiveData<String> getVideo$lib_weather_landing_release() {
        return this.video;
    }

    public final MutableLiveData<String> getTip$lib_weather_landing_release() {
        return this.tip;
    }

    public final MutableLiveData<Pair<List<Float>, int[]>> getChartData$lib_weather_landing_release() {
        return this.chartData;
    }

    public final String getDetailPageUrl$lib_weather_landing_release() {
        return this.detailPageUrl;
    }

    public final void setDetailPageUrl$lib_weather_landing_release(String str) {
        this.detailPageUrl = str;
    }

    public final void setData(RecentForecast data) {
        Intrinsics.checkNotNullParameter(data, "data");
        RecentForecast $this$setData_u24lambda_u2d0 = data;
        this.heavyText.setValue(22823 + $this$setData_u24lambda_u2d0.getWeather());
        this.lightText.setValue(23567 + $this$setData_u24lambda_u2d0.getWeather());
        this.image.setValue($this$setData_u24lambda_u2d0.getImageUri());
        this.video.setValue($this$setData_u24lambda_u2d0.getVideoUri());
        this.tip.setValue($this$setData_u24lambda_u2d0.getDescription());
        this.chartData.setValue(new Pair($this$setData_u24lambda_u2d0.getPrecipitations(), buildColors($this$setData_u24lambda_u2d0.getWeather())));
        this.detailPageUrl = data.getRecentForecastUrl();
    }

    private final int[] buildColors(String weather) {
        if (Intrinsics.areEqual((Object) weather, (Object) "雪")) {
            if (NightModeHelper.getNightModeSwitcherState()) {
                return new int[]{-16749460, -13733009, -10323080};
            }
            return new int[]{-16721447, -10622753, -3737615};
        } else if (NightModeHelper.getNightModeSwitcherState()) {
            return new int[]{-15125889, -16754056, -10323080};
        } else {
            return new int[]{-13408513, -16730638, -3737615};
        }
    }
}
