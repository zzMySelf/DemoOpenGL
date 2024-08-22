package com.baidu.searchbox.weather;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationConfigServiceImpl.kt */
final class LocationConfigServiceImpl$removeConfig$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WeatherLocationConfig $config;
    final /* synthetic */ LocationConfigServiceImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationConfigServiceImpl$removeConfig$1(LocationConfigServiceImpl locationConfigServiceImpl, WeatherLocationConfig weatherLocationConfig) {
        super(0);
        this.this$0 = locationConfigServiceImpl;
        this.$config = weatherLocationConfig;
    }

    public final void invoke() {
        this.this$0.configDao.deleteConfig(this.$config);
    }
}
