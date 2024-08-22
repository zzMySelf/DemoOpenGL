package com.baidu.swan.apps.impl.map.data;

import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.statistic.SwanAppFuncUbc;
import com.baidu.swan.apps.statistic.event.SwanAppUBCBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/swan/apps/impl/map/data/MapStatisticEvent;", "", "()V", "EXT_KEY_MAP_APP", "", "EXT_VAL_BAIDU", "EXT_VAL_BAIDU_DOWNLOAD", "EXT_VAL_GAODE", "PAGE_LOCATION", "VALUE_ROUTE_ACTIONSHEET", "VALUE_ROUTE_ENTRANCE", "doUbcReport", "", "type", "value", "extVal", "lib-swan-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MapStatisticEvent.kt */
public final class MapStatisticEvent {
    public static final String EXT_KEY_MAP_APP = "mapApp";
    public static final String EXT_VAL_BAIDU = "baidu";
    public static final String EXT_VAL_BAIDU_DOWNLOAD = "baiduDownload";
    public static final String EXT_VAL_GAODE = "gaode";
    public static final MapStatisticEvent INSTANCE = new MapStatisticEvent();
    public static final String PAGE_LOCATION = "openLocation";
    public static final String VALUE_ROUTE_ACTIONSHEET = "routeActionsheet";
    public static final String VALUE_ROUTE_ENTRANCE = "routeEntrance";

    private MapStatisticEvent() {
    }

    public final void doUbcReport(String type, String value, String extVal) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        SwanAppUBCBaseEvent event = new SwanAppUBCBaseEvent();
        event.mType = type;
        event.mValue = value;
        event.mPage = PAGE_LOCATION;
        CharSequence charSequence = extVal;
        if (!(charSequence == null || charSequence.length() == 0)) {
            event.addExt(EXT_KEY_MAP_APP, extVal);
        }
        SwanAppFuncUbc.addCommonParamToEvent(event, Swan.get().getApp().getInfo());
        SwanAppFuncUbc.onFuncStatistic(event);
    }

    public final void doUbcReport(String type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        doUbcReport(type, value, (String) null);
    }
}
