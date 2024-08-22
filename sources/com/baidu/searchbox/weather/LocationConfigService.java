package com.baidu.searchbox.weather;

import com.baidu.searchbox.location.LocationInfo;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J$\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H'J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H'¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/weather/LocationConfigService;", "", "addConfig", "", "config", "Lcom/baidu/searchbox/weather/WeatherLocationConfig;", "moveToTop", "closeSource", "", "getConfigData", "param", "Lcom/baidu/searchbox/weather/GetConfigParam;", "callback", "Lkotlin/Function1;", "Lcom/baidu/searchbox/weather/LocationConfigData;", "getFirstManualLocation", "removeConfig", "swapConfig", "src", "dst", "switchToManualMode", "syncAutoConfig", "location", "Lcom/baidu/searchbox/location/LocationInfo;", "city", "", "district", "country", "lib-weather-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationConfigService.kt */
public interface LocationConfigService {
    boolean addConfig(WeatherLocationConfig weatherLocationConfig, boolean z);

    void closeSource();

    void getConfigData(GetConfigParam getConfigParam, Function1<? super LocationConfigData, Unit> function1);

    WeatherLocationConfig getFirstManualLocation();

    void removeConfig(WeatherLocationConfig weatherLocationConfig);

    boolean swapConfig(WeatherLocationConfig weatherLocationConfig, WeatherLocationConfig weatherLocationConfig2);

    void switchToManualMode();

    void syncAutoConfig(LocationInfo locationInfo);

    @Deprecated(message = "新版推全后删除")
    void syncAutoConfig(String str, String str2, String str3);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LocationConfigService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean addConfig$default(LocationConfigService locationConfigService, WeatherLocationConfig weatherLocationConfig, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = false;
                }
                return locationConfigService.addConfig(weatherLocationConfig, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addConfig");
        }
    }
}
