package com.baidu.searchbox.weather.ioc;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.net.SearchBoxCookieManager;

public class WeatherContextImpl implements IWeatherContext {
    public CookieManager createCookieManager(boolean needSync, boolean needSaveBduss) {
        return new SearchBoxCookieManager(needSync, needSaveBduss);
    }
}
