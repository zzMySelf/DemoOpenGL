package com.baidu.searchbox.home.weather;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0002¨\u0006\u0005"}, d2 = {"getUbcSource", "", "Lcom/baidu/searchbox/home/weather/WeatherStatus;", "isErrorState", "", "lib-home-top_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WeatherStatus.kt */
public final class WeatherStatusKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WeatherStatus.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WeatherStatus.values().length];
            iArr[WeatherStatus.NORMAL.ordinal()] = 1;
            iArr[WeatherStatus.PICK_CITY.ordinal()] = 2;
            iArr[WeatherStatus.NO_WEATHER_DATA.ordinal()] = 3;
            iArr[WeatherStatus.NETWORK_ERROR.ordinal()] = 4;
            iArr[WeatherStatus.DATA_ERROR.ordinal()] = 5;
            iArr[WeatherStatus.DATA_FETCHING.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getUbcSource(WeatherStatus $this$getUbcSource) {
        switch ($this$getUbcSource == null ? -1 : WhenMappings.$EnumSwitchMapping$0[$this$getUbcSource.ordinal()]) {
            case 2:
                return WeatherConstantsKt.SOURCE_PICK_CITY;
            case 3:
                return WeatherConstantsKt.SOURCE_DATA_ERROR;
            case 4:
                return WeatherConstantsKt.SOURCE_NETWORK_ERROR;
            case 5:
                return WeatherConstantsKt.SOURCE_DATA_ERROR_2;
            case 6:
                return WeatherConstantsKt.SOURCE_DATA_FETCHING;
            default:
                return "normal";
        }
    }

    public static final boolean isErrorState(WeatherStatus $this$isErrorState) {
        if ($this$isErrorState == null) {
            return true;
        }
        WeatherStatus $this$isErrorState_u24lambda_u2d0 = $this$isErrorState;
        if ($this$isErrorState_u24lambda_u2d0 == WeatherStatus.NORMAL || $this$isErrorState_u24lambda_u2d0 == WeatherStatus.DATA_FETCHING) {
            return false;
        }
        return true;
    }
}
