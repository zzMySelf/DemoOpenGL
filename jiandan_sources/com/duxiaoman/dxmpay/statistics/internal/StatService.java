package com.duxiaoman.dxmpay.statistics.internal;

import android.text.TextUtils;
import fe.th.qw.qw.qw.rg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatService {
    public ConcurrentHashMap<String, Long> qw;

    public enum ETag {
        in,
        out,
        push,
        back
    }

    public static class qw {
        public static StatService qw = new StatService();
    }

    public static void ad(String str) {
        qw().qw.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized void de(String str, ETag eTag, Collection<String> collection) {
        synchronized (StatService.class) {
            if (eTag != null) {
                th(str, eTag.name(), collection, (String) null);
            }
        }
    }

    public static void fe(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            rg.qw().ad(str, (String) null, str2, str3, System.currentTimeMillis());
        }
    }

    public static long i(String str) {
        Long l = qw().qw.get(str);
        if (l == null) {
            return -1;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
        qw().qw.remove(str);
        return valueOf.longValue();
    }

    public static void o(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        long i2 = i(str);
        if (i2 > 0) {
            hashMap.put("duration", Long.valueOf(i2));
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        yj(str, (String) null, arrayList, hashMap, str3);
    }

    public static void pf(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, "");
        long i2 = i(str);
        if (i2 > 0) {
            arrayList.add(Long.toString(i2));
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("duration", Long.valueOf(i2));
        }
        arrayList.add(str2);
        if (collection != null) {
            arrayList.addAll(collection);
        }
        yj(str, (String) null, arrayList, map, str3);
    }

    public static StatService qw() {
        return qw.qw;
    }

    public static void rg(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, "");
        long i2 = i(str);
        if (i2 > 0) {
            arrayList.add(Long.toString(i2));
            hashMap.put("duration", Long.valueOf(i2));
        }
        arrayList.add(str2);
        if (str3 != null) {
            arrayList.add(str3);
        }
        yj(str, (String) null, arrayList, hashMap, str4);
    }

    public static void th(String str, String str2, Collection<String> collection, String str3) {
        yj(str, str2, collection, (Map<String, Object>) null, str3);
    }

    public static void uk(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        ArrayList arrayList = new ArrayList();
        long i2 = i(str);
        if (i2 > 0) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("duration", Long.valueOf(i2));
        }
        if (collection != null) {
            arrayList.addAll(collection);
        }
        yj(str, (String) null, arrayList, map, str2);
    }

    public static void yj(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3) {
        if (!TextUtils.isEmpty(str)) {
            rg.qw().de(str, str2, collection, map, str3, System.currentTimeMillis());
        }
    }

    public StatService() {
        this.qw = new ConcurrentHashMap<>();
    }
}
