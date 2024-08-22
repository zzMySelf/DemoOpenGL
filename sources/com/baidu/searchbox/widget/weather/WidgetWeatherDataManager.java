package com.baidu.searchbox.widget.weather;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.homepage.extend.top.IHomeTop;
import com.baidu.searchbox.homepage.extend.top.WeatherData;
import com.baidu.searchbox.location.BoxLocationManager;
import com.baidu.searchbox.location.business.inter.ILocationBusinessApi;
import com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0016\u001a\u00020\n¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/widget/weather/WidgetWeatherDataManager;", "", "()V", "getGpsLocInfo", "", "getIpLocInfo", "getWeatherData", "Lcom/baidu/searchbox/homepage/extend/top/WeatherData;", "getWeatherWidgetVersion", "registerLocationListener", "", "saveGpsLocInfo", "gpsLocInfo", "Lorg/json/JSONObject;", "saveIpLocInfo", "ipLocInfo", "saveWeatherData", "weatherObj", "saveWidgetDataVersion", "version", "updateIpLocInfo", "ipLocInfoData", "updateLocInfoDataFromLocation", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetWeatherDataManager.kt */
public final class WidgetWeatherDataManager {
    public static final WidgetWeatherDataManager INSTANCE = new WidgetWeatherDataManager();

    private WidgetWeatherDataManager() {
    }

    public final void registerLocationListener() {
        Object service = ServiceManager.getService(BoxLocationManager.SERVICE_REFERENCE);
        Intrinsics.checkNotNullExpressionValue(service, "getService(BoxLocationManager.SERVICE_REFERENCE)");
        BoxLocationManager mBoxLocationManager = (BoxLocationManager) service;
        mBoxLocationManager.addLocationListener(new WidgetWeatherDataManager$registerLocationListener$1());
        mBoxLocationManager.addOnlyIPLocationListener(new WidgetWeatherDataManager$registerLocationListener$2());
    }

    public final void updateLocInfoDataFromLocation() {
        JSONObject locRequestData;
        ILocationBusinessApi api = ILocationBusinessApi.Companion.getApi();
        JSONObject ipLocInfoObj = null;
        if (api != null) {
            ILocationBusinessApi.RequestBodyConfig requestBodyConfig = new ILocationBusinessApi.RequestBodyConfig();
            ILocationBusinessApi.RequestBodyConfig $this$updateLocInfoDataFromLocation_u24lambda_u2d0 = requestBodyConfig;
            $this$updateLocInfoDataFromLocation_u24lambda_u2d0.setSource("widget");
            $this$updateLocInfoDataFromLocation_u24lambda_u2d0.setEncode(false);
            $this$updateLocInfoDataFromLocation_u24lambda_u2d0.setMainProcess(true);
            locRequestData = api.getRequestBody(requestBodyConfig);
        } else {
            locRequestData = null;
        }
        if (locRequestData != null) {
            JSONObject optJSONObject = locRequestData.optJSONObject("locInfo");
            if (optJSONObject != null) {
                ipLocInfoObj = optJSONObject.optJSONObject(WidgetWeatherDataManagerKt.KEY_IP_LOC);
            }
            INSTANCE.updateIpLocInfo(ipLocInfoObj);
        }
    }

    public final void updateIpLocInfo(JSONObject ipLocInfoData) {
        if (ipLocInfoData != null) {
            JSONObject it = ipLocInfoData;
            WidgetWeatherDataManager widgetWeatherDataManager = INSTANCE;
            String lastIpLocInfo = widgetWeatherDataManager.getIpLocInfo();
            if (TextUtils.isEmpty(lastIpLocInfo)) {
                widgetWeatherDataManager.saveIpLocInfo(it);
                return;
            }
            try {
                if (it.optLong("fresh_time", 0) > new JSONObject(lastIpLocInfo).optLong("fresh_time", 0)) {
                    widgetWeatherDataManager.saveIpLocInfo(it);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void saveIpLocInfo(JSONObject ipLocInfo) {
        if (ipLocInfo != null) {
            WidgetSharePreferenceUtils.Companion.getInstance().putString(WidgetWeatherDataManagerKt.SP_KEY_IP_LOC_INFO, ipLocInfo.toString());
        }
    }

    public final void saveGpsLocInfo(JSONObject gpsLocInfo) {
        if (gpsLocInfo != null) {
            WidgetSharePreferenceUtils.Companion.getInstance().putString(WidgetWeatherDataManagerKt.SP_KEY_GPS_LOC_INFO, gpsLocInfo.toString());
        }
    }

    public final String getIpLocInfo() {
        return WidgetSharePreferenceUtils.Companion.getInstance().getString(WidgetWeatherDataManagerKt.SP_KEY_IP_LOC_INFO, (String) null);
    }

    public final String getGpsLocInfo() {
        return WidgetSharePreferenceUtils.Companion.getInstance().getString(WidgetWeatherDataManagerKt.SP_KEY_GPS_LOC_INFO, (String) null);
    }

    public final void saveWidgetDataVersion(String version) {
        if (version != null) {
            WidgetSharePreferenceUtils.Companion.getInstance().putString(WidgetWeatherDataManagerKt.SP_KEY_WEATHER_WIDGET_VERSION, version);
        }
    }

    public final String getWeatherWidgetVersion() {
        return WidgetSharePreferenceUtils.Companion.getInstance().getString(WidgetWeatherDataManagerKt.SP_KEY_WEATHER_WIDGET_VERSION, (String) null);
    }

    public final void saveWeatherData(JSONObject weatherObj) {
        if (weatherObj != null) {
            JSONObject it = weatherObj;
            if (it.has("weather")) {
                WidgetSharePreferenceUtils.Companion.getInstance().putString(WidgetWeatherDataManagerKt.SP_KEY_WEATHER_DATA, it.toString());
            }
        }
    }

    public final WeatherData getWeatherData() {
        String string = WidgetSharePreferenceUtils.Companion.getInstance().getString(WidgetWeatherDataManagerKt.SP_KEY_WEATHER_DATA, "");
        if (TextUtils.isEmpty(string)) {
            return ((IHomeTop) ServiceManager.getService(IHomeTop.SERVICE_REFERENCE)).getWeatherData();
        }
        WeatherData weatherData = new WeatherData();
        WeatherData $this$getWeatherData_u24lambda_u2d7 = weatherData;
        try {
            JSONObject weatherJson = new JSONObject(string);
            $this$getWeatherData_u24lambda_u2d7.setAirQuality(weatherJson.optString("air_quality"));
            $this$getWeatherData_u24lambda_u2d7.setCity(weatherJson.optString("city"));
            $this$getWeatherData_u24lambda_u2d7.setCountry(weatherJson.optString("country"));
            $this$getWeatherData_u24lambda_u2d7.setTemp(weatherJson.optString("temp"));
            $this$getWeatherData_u24lambda_u2d7.setWeather(weatherJson.optString("weather"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return weatherData;
    }
}
