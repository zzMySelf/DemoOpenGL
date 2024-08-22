package com.baidu.searchbox.weather.ioc;

import com.baidu.searchbox.weather.ioc.IWeatherPageRouter;
import com.baidu.searchbox.weather.runtime.WeatherRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/weather/ioc/IWeatherPageRouter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWeatherPageRouter.kt */
final class IWeatherPageRouter$Companion$Impl$2 extends Lambda implements Function0<IWeatherPageRouter> {
    public static final IWeatherPageRouter$Companion$Impl$2 INSTANCE = new IWeatherPageRouter$Companion$Impl$2();

    IWeatherPageRouter$Companion$Impl$2() {
        super(0);
    }

    public final IWeatherPageRouter invoke() {
        IWeatherPageRouter router = WeatherRuntime.getRouter();
        return router == null ? IWeatherPageRouter.Companion.$$INSTANCE.getEmpty() : router;
    }
}
