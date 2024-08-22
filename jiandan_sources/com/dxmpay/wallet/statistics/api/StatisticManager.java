package com.dxmpay.wallet.statistics.api;

import com.dxmpay.apollon.NoProguard;
import java.util.Collection;
import java.util.Map;

public class StatisticManager implements NoProguard {
    public static int VALUE_MAX_LENGTH = 255;

    /* renamed from: ad  reason: collision with root package name */
    public static SensorStatisticApi f4364ad;

    public static class ad {
        public static StatisticManager qw = new StatisticManager();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String ad(java.lang.String r4) {
        /*
            java.lang.Class<com.dxmpay.wallet.statistics.api.StatisticManager> r0 = com.dxmpay.wallet.statistics.api.StatisticManager.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0038
            int r1 = r4.length()     // Catch:{ all -> 0x003a }
            int r2 = VALUE_MAX_LENGTH     // Catch:{ all -> 0x003a }
            if (r1 <= r2) goto L_0x0038
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x003a }
            r1.<init>()     // Catch:{ all -> 0x003a }
            r2 = 0
            int r3 = VALUE_MAX_LENGTH     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r4.substring(r2, r3)     // Catch:{ all -> 0x003a }
            r1.append(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "，"
            r1.append(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "size is "
            r1.append(r2)     // Catch:{ all -> 0x003a }
            byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x003a }
            int r4 = r4.length     // Catch:{ all -> 0x003a }
            r1.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x003a }
            monitor-exit(r0)
            return r4
        L_0x0038:
            monitor-exit(r0)
            return r4
        L_0x003a:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.statistics.api.StatisticManager.ad(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.Collection<java.lang.String> de(java.util.Collection<java.lang.String> r3) {
        /*
            java.lang.Class<com.dxmpay.wallet.statistics.api.StatisticManager> r0 = com.dxmpay.wallet.statistics.api.StatisticManager.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x0033
            boolean r1 = r3.isEmpty()     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x0033
            int r1 = r3.size()     // Catch:{ all -> 0x0030 }
            if (r1 <= 0) goto L_0x0033
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0030 }
            r1.<init>()     // Catch:{ all -> 0x0030 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0030 }
        L_0x001a:
            boolean r2 = r3.hasNext()     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r3.next()     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = ad(r2)     // Catch:{ all -> 0x0030 }
            r1.add(r2)     // Catch:{ all -> 0x0030 }
            goto L_0x001a
        L_0x002e:
            monitor-exit(r0)
            return r1
        L_0x0030:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x0033:
            monitor-exit(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.statistics.api.StatisticManager.de(java.util.Collection):java.util.Collection");
    }

    public static void onEvent(String str) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            f4364ad.onEvent(str);
        }
    }

    public static void onEventEnd(String str) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            f4364ad.onEventEnd(str);
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tresultCode: " + i2;
            String ad2 = ad(str2);
            "\tvalue: " + ad2;
            f4364ad.onEventEndWithValue(str, i2, ad2);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tresultCode: " + i2;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            f4364ad.onEventEndWithValues(str, i2, collection);
        }
    }

    public static void onEventStart(String str) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            f4364ad.onEventStart(str);
        }
    }

    public static void onEventWithValue(String str, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            String ad2 = ad(str2);
            "\tvalue: " + ad2;
            f4364ad.onEventWithValue(str, ad2);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            f4364ad.onEventWithValues(str, collection);
        }
    }

    public static StatisticManager qw() {
        return ad.qw;
    }

    public static void triggerSending() {
        qw();
        SensorStatisticApi sensorStatisticApi = f4364ad;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.triggerSending();
        }
    }

    public StatisticManager() {
        f4364ad = SensorStatisticApi.getInstance();
    }

    public static void onEvent(String str, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tabType: " + str2;
            f4364ad.onEvent(str, str2);
        }
    }

    public static void onEventEnd(String str, int i2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tresultCode: " + i2;
            f4364ad.onEventEnd(str, i2);
        }
    }

    public static void onEventWithValue(String str, String str2, String str3) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tabType: " + str3;
            String ad2 = ad(str2);
            "\tvalue: " + ad2;
            f4364ad.onEventWithValue(str, ad2, str3);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            if (map != null) {
                "\tkv: " + map.toString();
            }
            f4364ad.onEventWithValues(str, collection, map);
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2, String str3) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tresultCode: " + i2;
            String ad2 = ad(str2);
            "\tvalue: " + ad2;
            "\tabType: " + str3;
            f4364ad.onEventEndWithValue(str, i2, ad2, str3);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tresultCode: " + i2;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            if (map != null) {
                "\tkv: " + map.toString();
            }
            f4364ad.onEventEndWithValues(str, i2, collection, map);
        }
    }

    public static void onEventEnd(String str, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tabType: " + str2;
            f4364ad.onEventEnd(str, str2);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tabType: " + str2;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            f4364ad.onEventWithValues(str, collection, str2);
        }
    }

    public static void onEventEnd(String str, int i2, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tresultCode: " + i2;
            "\tabType: " + str2;
            f4364ad.onEventEnd(str, i2, str2);
        }
    }

    public static void onEventEndWithValue(String str, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            String ad2 = ad(str2);
            "\tvalue: " + ad2;
            f4364ad.onEventEndWithValue(str, ad2);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tresultCode: " + i2;
            "\tabType: " + str2;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            f4364ad.onEventEndWithValues(str, i2, collection, str2);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tabType: " + str2;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            if (map != null) {
                "\tkv: " + map.toString();
            }
            f4364ad.onEventWithValues(str, collection, map, str2);
        }
    }

    public static void onEventEndWithValue(String str, String str2, String str3) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            String ad2 = ad(str2);
            "\tvalue: " + ad2;
            "\tabType: " + str3;
            f4364ad.onEventEndWithValue(str, ad2, str3);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tresultCode: " + i2;
            "\tabType: " + str2;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            Collection<String> collection2 = collection;
            if (map != null) {
                "\tkv: " + map.toString();
            }
            f4364ad.onEventEndWithValues(str, i2, collection2, map, str2);
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            f4364ad.onEventEndWithValues(str, collection);
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            if (map != null) {
                "\tkv: " + map.toString();
            }
            f4364ad.onEventEndWithValues(str, collection, map);
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tabType: " + str2;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            f4364ad.onEventEndWithValues(str, collection, str2);
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        qw();
        if (f4364ad != null) {
            "\tEventId: " + str;
            "\tabType: " + str2;
            if (collection != null) {
                collection = de(collection);
                "\tvalues: " + collection.toString();
            }
            if (map != null) {
                "\tkv: " + map.toString();
            }
            f4364ad.onEventEndWithValues(str, collection, map, str2);
        }
    }
}
