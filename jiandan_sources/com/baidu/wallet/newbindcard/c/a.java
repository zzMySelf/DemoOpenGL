package com.baidu.wallet.newbindcard.c;

import android.text.TextUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class a {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static String g = "";

    /* renamed from: com.baidu.wallet.newbindcard.c.a$a  reason: collision with other inner class name */
    public static class C0159a {
        public static a a = new a();
    }

    public static void a(String str, Map<String, Object> map, String str2, String str3, String str4, String... strArr) {
        h();
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(i());
            if (strArr != null) {
                for (String add : strArr) {
                    arrayList.add(add);
                }
            }
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    map.put(next.getKey(), next.getValue());
                }
            }
            map.put(StatHelper.HASH_NAME, str2);
            map.put("hash", str3);
            map.put(StatHelper.EVENT_TAG, str4);
            map.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_INITIATIVE_BIND_CARD_NAME);
            map.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_INITIATIVE_BIND_CARD_ID);
            map.put(StatHelper.EVENT_PATH, StatHelper.PAY_SDK_EVENT_PATH + str);
            map.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
            StatisticManager.onEventEndWithValues(str, (Collection<String>) arrayList, map);
        }
    }

    public static String b() {
        return c;
    }

    public static String c() {
        return d;
    }

    public static String d() {
        return e;
    }

    public static String e() {
        return f;
    }

    public static String f() {
        return g;
    }

    public static void g() {
        h();
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        StatHelper.cacheSessionId((String) null);
    }

    public static a h() {
        return C0159a.a;
    }

    public static String i() {
        h();
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String j = j();
        a = j;
        return j;
    }

    public static String j() {
        h();
        String uuid = UUID.randomUUID().toString();
        return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
    }

    public a() {
    }

    public static void b(String str) {
        c = str;
    }

    public static void c(String str) {
        d = str;
    }

    public static void d(String str) {
        e = str;
    }

    public static void e(String str) {
        f = str;
    }

    public static void f(String str) {
        g = str;
    }

    public static void a(String str, String str2, String str3, String str4, String... strArr) {
        h();
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(i());
            if (strArr != null) {
                for (String add : strArr) {
                    arrayList.add(add);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.HASH_NAME, str2);
            hashMap.put("hash", str3);
            hashMap.put(StatHelper.EVENT_TAG, str4);
            hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_INITIATIVE_BIND_CARD_NAME);
            hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_INITIATIVE_BIND_CARD_ID);
            hashMap.put(StatHelper.EVENT_PATH, StatHelper.PAY_SDK_EVENT_PATH + str);
            hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
            StatisticManager.onEventEndWithValues(str, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        }
    }

    public static String a() {
        return b;
    }

    public static void a(String str) {
        b = str;
    }
}
