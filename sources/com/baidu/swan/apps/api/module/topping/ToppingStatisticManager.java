package com.baidu.swan.apps.api.module.topping;

import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.statistic.IStat;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.event.SwanAppUBCBaseEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/swan/apps/api/module/topping/ToppingStatisticManager;", "", "()V", "UBC_EXT_KEY_IS_TOPPING", "", "UBC_EXT_KEY_ITEMS", "UBC_SOURCE_BULK_TOPPING", "UBC_TYPE_TOPPING", "UBC_VALUE_CLICK", "doBulkToppingStatistic", "", "isAddTopping", "", "appIds", "", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToppingStatisticManager.kt */
public final class ToppingStatisticManager {
    public static final ToppingStatisticManager INSTANCE = new ToppingStatisticManager();
    private static final String UBC_EXT_KEY_IS_TOPPING = "istopping";
    private static final String UBC_EXT_KEY_ITEMS = "items";
    private static final String UBC_SOURCE_BULK_TOPPING = "bulktopping";
    private static final String UBC_TYPE_TOPPING = "topping";
    private static final String UBC_VALUE_CLICK = "click";

    private ToppingStatisticManager() {
    }

    public final void doBulkToppingStatistic(boolean isAddTopping, List<String> appIds) {
        Intrinsics.checkNotNullParameter(appIds, "appIds");
        JSONArray appIdArray = new JSONArray();
        for (String it : appIds) {
            appIdArray.put(it);
        }
        SwanAppUBCBaseEvent event = new SwanAppUBCBaseEvent();
        event.mType = "topping";
        event.mValue = "click";
        event.mSource = UBC_SOURCE_BULK_TOPPING;
        event.mAppId = Swan.get().getAppId();
        event.addExt(UBC_EXT_KEY_IS_TOPPING, Boolean.valueOf(isAddTopping));
        event.addExt("items", appIdArray);
        SwanAppUBCStatistic.onEvent(IStat.UBC_ID_FAVORITE_ACTION, event);
    }
}
