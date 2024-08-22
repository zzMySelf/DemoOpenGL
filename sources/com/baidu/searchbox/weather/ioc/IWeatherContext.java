package com.baidu.searchbox.weather.ioc;

import com.baidu.searchbox.http.cookie.CookieManager;

public interface IWeatherContext {
    CookieManager createCookieManager(boolean z, boolean z2);
}
