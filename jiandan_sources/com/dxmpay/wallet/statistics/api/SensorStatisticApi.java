package com.dxmpay.wallet.statistics.api;

import com.duxiaoman.dxmpay.statistics.StatApi;
import com.duxiaoman.dxmpay.statistics.internal.LogSender;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import com.dxmpay.wallet.passport.PassLoginUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SensorStatisticApi extends StatisticDecorate {

    public static class qw {
        public static SensorStatisticApi qw = new SensorStatisticApi();
    }

    public static SensorStatisticApi getInstance() {
        return qw.qw;
    }

    public void onEvent(String str) {
        super.onEvent(str);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventWithValues(str, (Collection<String>) null, (Map<String, Object>) hashMap);
    }

    public void onEventEnd(String str, int i2) {
        super.onEventEnd(str, i2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventEndWithValues(str, i2, (Collection<String>) null, (Map<String, Object>) hashMap);
    }

    public void onEventEndWithValue(String str, int i2, String str2) {
        super.onEventEndWithValue(str, i2, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        StatApi.onEventEndWithValues(str, i2, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
    }

    public void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        super.onEventEndWithValues(str, i2, collection);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventEndWithValues(str, i2, collection, (Map<String, Object>) hashMap);
    }

    public void onEventStart(String str) {
        super.onEventStart(str);
        StatApi.onEventStart(str);
    }

    public void onEventWithValue(String str, String str2) {
        super.onEventWithValue(str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        StatApi.onEventWithValues(str, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
    }

    public void onEventWithValues(String str, Collection<String> collection) {
        super.onEventWithValues(str, collection);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventWithValues(str, collection, (Map<String, Object>) hashMap);
    }

    public final int qw() {
        if (PassLoginUtil.getInstance().isLogin()) {
            return (!DxmPassManagerDelegate.getInstance().hasDxmPass() || DxmPassManagerDelegate.getInstance().dxmGetLoginType() != 2) ? 1 : 2;
        }
        return 0;
    }

    public void triggerSending() {
        super.triggerSending();
        LogSender.getInstance().triggerSending("normal_log");
    }

    public void onEvent(String str, String str2) {
        super.onEvent(str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventWithValues(str, (Collection<String>) null, hashMap, str2);
    }

    public void onEventEnd(String str, int i2, String str2) {
        super.onEventEnd(str, i2, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventEndWithValues(str, i2, (Collection<String>) null, hashMap, str2);
    }

    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        super.onEventEndWithValues(str, i2, collection, map);
        if (map == null) {
            map = new HashMap<>();
        }
        if (!map.containsKey("pass_type")) {
            map.put("pass_type", Integer.valueOf(qw()));
        }
        StatApi.onEventEndWithValues(str, i2, collection, map);
    }

    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        super.onEventWithValues(str, collection, map);
        if (map == null) {
            map = new HashMap<>();
        }
        if (!map.containsKey("pass_type")) {
            map.put("pass_type", Integer.valueOf(qw()));
        }
        StatApi.onEventWithValues(str, collection, map);
    }

    public void onEventEndWithValue(String str, int i2, String str2, String str3) {
        super.onEventEndWithValue(str, i2, str2, str3);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        StatApi.onEventEndWithValues(str, i2, arrayList, hashMap, str3);
    }

    public void onEventWithValue(String str, String str2, String str3) {
        super.onEventWithValue(str, str2, str3);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        StatApi.onEventWithValues(str, arrayList, hashMap, str3);
    }

    public void onEventEnd(String str) {
        super.onEventEnd(str);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventEndWithValues(str, (Collection<String>) null, (Map<String, Object>) hashMap);
    }

    public void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        super.onEventEndWithValues(str, i2, collection, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventEndWithValues(str, i2, collection, hashMap, str2);
    }

    public void onEventWithValues(String str, Collection<String> collection, String str2) {
        super.onEventWithValues(str, collection, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventWithValues(str, collection, hashMap, str2);
    }

    public void onEventEnd(String str, String str2) {
        super.onEventEnd(str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventEndWithValues(str, (Collection<String>) null, (Map<String, Object>) hashMap, str2);
    }

    public void onEventEndWithValue(String str, String str2) {
        super.onEventEndWithValue(str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        StatApi.onEventEndWithValues(str, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
    }

    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        super.onEventEndWithValues(str, i2, collection, map, str2);
        if (map == null) {
            map = new HashMap<>();
        }
        if (!map.containsKey("pass_type")) {
            map.put("pass_type", Integer.valueOf(qw()));
        }
        StatApi.onEventEndWithValues(str, i2, collection, map, str2);
    }

    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        super.onEventWithValues(str, collection, map, str2);
        if (map == null) {
            map = new HashMap<>();
        }
        if (!map.containsKey("pass_type")) {
            map.put("pass_type", Integer.valueOf(qw()));
        }
        StatApi.onEventWithValues(str, collection, map, str2);
    }

    public void onEventEndWithValue(String str, String str2, String str3) {
        super.onEventEndWithValue(str, str2, str3);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        StatApi.onEventEndWithValues(str, (Collection<String>) arrayList, (Map<String, Object>) hashMap, str3);
    }

    public void onEventEndWithValues(String str, Collection<String> collection) {
        super.onEventEndWithValues(str, collection);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventEndWithValues(str, collection, (Map<String, Object>) hashMap);
    }

    public void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        super.onEventEndWithValues(str, collection, map);
        if (map == null) {
            map = new HashMap<>();
        }
        if (!map.containsKey("pass_type")) {
            map.put("pass_type", Integer.valueOf(qw()));
        }
        StatApi.onEventEndWithValues(str, collection, map);
    }

    public void onEventEndWithValues(String str, Collection<String> collection, String str2) {
        super.onEventEndWithValues(str, collection, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pass_type", Integer.valueOf(qw()));
        StatApi.onEventEndWithValues(str, collection, (Map<String, Object>) hashMap, str2);
    }

    public void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        super.onEventEndWithValues(str, collection, map, str2);
        if (map == null) {
            map = new HashMap<>();
        }
        if (!map.containsKey("pass_type")) {
            map.put("pass_type", Integer.valueOf(qw()));
        }
        StatApi.onEventEndWithValues(str, collection, map, str2);
    }
}
