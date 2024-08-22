package com.baidu.wallet.lightapp.base.utils;

import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class a {
    public static HashMap<String, LinkedList<Long>> d;
    public final int a = 30000;
    public final int b = 4;
    public final String c = "MultiRefreshUtils";
    public int e = 30000;
    public int f = 4;

    public void a(String str) {
        a(str, this.e, this.f);
    }

    public void a(String str, int i2, int i3) {
        if (d == null) {
            d = new HashMap<>();
        }
        LinkedList linkedList = d.get(str);
        if (linkedList == null) {
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(Long.valueOf(System.currentTimeMillis()));
            d.put(str, linkedList2);
        } else if (linkedList.size() > 0) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Iterator it = linkedList.iterator();
            while (it.hasNext() && valueOf.longValue() - ((Long) it.next()).longValue() > ((long) i2)) {
                it.remove();
            }
            if (linkedList.size() >= i3 - 1) {
                LogUtil.d("MultiRefreshUtils", (i2 / 1000) + "s内频繁刷新了" + (linkedList.size() + 1) + "次");
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_REPETITION_LOAD_URL, arrayList);
                d.remove(str);
                return;
            }
            linkedList.add(valueOf);
        }
    }

    public void a() {
        if (d != null) {
            d = null;
        }
    }
}
