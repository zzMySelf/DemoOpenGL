package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.NaMethodStatUtils;
import java.util.HashMap;

public class EnterWalletDoPostEventAction implements RouterAction {
    public EnterWalletDoPostEventAction() {
        BdWalletUtils.putFunctionNameList("postEvent");
    }

    private void a(Context context, String str, String str2) {
        EventBus instance = EventBus.getInstance();
        instance.getClass();
        EventBus.getInstance().post(new EventBus.Event(str, str2));
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context == null || hashMap == null || !hashMap.containsKey("event_key") || !(hashMap.get("event_key") instanceof String) || !hashMap.containsKey("event_value") || !(hashMap.get("event_value") instanceof String)) {
            if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
            }
            StatisticManager.onEvent(PayStatServiceEvent.PAY_DO_POST_EVENT_FAIL);
            return;
        }
        String str = (String) hashMap.get("event_key");
        a(context, str, (String) hashMap.get("event_value"));
        NaMethodStatUtils.statEnter("postEvent", str);
        NaMethodStatUtils.statResult("postEvent", 0, "");
    }
}
