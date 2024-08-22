package com.baidu.searchbox.widget.weather;

import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.location.LocationListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/widget/weather/WidgetWeatherDataManager$registerLocationListener$1", "Lcom/baidu/searchbox/location/LocationListener;", "onError", "", "errCode", "", "onReceiveLocation", "locationInfo", "Lcom/baidu/searchbox/location/LocationInfo;", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetWeatherDataManager.kt */
public final class WidgetWeatherDataManager$registerLocationListener$1 implements LocationListener {
    WidgetWeatherDataManager$registerLocationListener$1() {
    }

    public void onReceiveLocation(LocationInfo locationInfo) {
        WidgetWeatherDataManager.INSTANCE.updateLocInfoDataFromLocation();
    }

    public void onError(int errCode) {
    }
}
