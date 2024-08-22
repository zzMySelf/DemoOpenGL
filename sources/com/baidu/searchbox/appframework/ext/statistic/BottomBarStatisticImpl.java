package com.baidu.searchbox.appframework.ext.statistic;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.unifiedtoolbar.ioc.IStatisticInterface;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/appframework/ext/statistic/BottomBarStatisticImpl;", "Lcom/baidu/searchbox/unifiedtoolbar/ioc/IStatisticInterface;", "()V", "onEvent", "", "eventId", "", "value", "Lorg/json/JSONObject;", "lib-appframework-toolbarext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarStatisticImpl.kt */
public final class BottomBarStatisticImpl implements IStatisticInterface {
    public void onEvent(String eventId, JSONObject value) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(value, "value");
        UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (ubcManager != null) {
            ubcManager.onEvent(eventId, value);
        }
    }
}
