package com.baidu.searchbox.weather.util;

import com.baidu.searchbox.scene.IScenePermissionCallback;
import com.baidu.searchbox.weather.statistic.WeatherStats;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/weather/util/LocationPermissionHelper$checkLocPermission$1$1", "Lcom/baidu/searchbox/scene/IScenePermissionCallback;", "onPermissionStateChange", "", "state", "", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationUtil.kt */
public final class LocationPermissionHelper$checkLocPermission$1$1 implements IScenePermissionCallback {
    final /* synthetic */ int $requestCode;
    final /* synthetic */ LocationPermissionHelper this$0;

    LocationPermissionHelper$checkLocPermission$1$1(LocationPermissionHelper $receiver, int $requestCode2) {
        this.this$0 = $receiver;
        this.$requestCode = $requestCode2;
    }

    public void onPermissionStateChange(boolean state) {
        this.this$0.onPermissionStateChange(this.$requestCode, state);
        WeatherStats.of(this.this$0.token).setIsRequestingPermission(false);
    }
}
