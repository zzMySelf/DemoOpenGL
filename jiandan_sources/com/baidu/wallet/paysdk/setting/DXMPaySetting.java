package com.baidu.wallet.paysdk.setting;

import android.content.Context;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;

public class DXMPaySetting {
    public static final String BIG_WORD_MODE_CLOSE = "0";
    public static final String BIG_WORD_MODE_OPEN = "1";

    public static class a {
        public static final DXMPaySetting a = new DXMPaySetting();
    }

    public static DXMPaySetting getInstance() {
        return a.a;
    }

    public String getBigWordMode(Context context) {
        return a.a().a(context);
    }

    public boolean setBigWordMode(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add("1");
        StatisticManager.onEventWithValues(PayStatServiceEvent.SET_BIG_WORD, arrayList);
        return a.a().a(context, str);
    }

    public DXMPaySetting() {
    }
}
