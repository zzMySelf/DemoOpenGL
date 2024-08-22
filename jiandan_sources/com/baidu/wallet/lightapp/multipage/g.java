package com.baidu.wallet.lightapp.multipage;

import android.text.TextUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class g {
    public static final Set<String> a;
    public Map<String, Map<String, String>> b;

    public static class a {
        public static g a = new g();
    }

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add("getItem");
        a.add("setItem");
        a.add("clear");
        a.add("key");
        a.add("length");
        a.add("removeItem");
    }

    public static boolean a(String str) {
        return a.contains(str);
    }

    private void b() {
    }

    public void b(String str) {
        this.b.remove(str);
    }

    public void c(String str) {
        for (Map.Entry next : this.b.entrySet()) {
            if (((String) next.getKey()).startsWith(str)) {
                this.b.remove(next.getKey());
            }
        }
    }

    public int d(String str) {
        if (this.b.containsKey(str)) {
            return this.b.get(str).size();
        }
        return 0;
    }

    public g() {
        this.b = new ConcurrentHashMap();
    }

    public static g a() {
        return a.a;
    }

    public void b(String str, String str2) {
        if (this.b.containsKey(str2) && this.b.get(str2).containsKey(str)) {
            this.b.get(str2).remove(str);
        }
    }

    public String a(String str, String str2) {
        if (!this.b.containsKey(str2) || !this.b.get(str2).containsKey(str)) {
            return null;
        }
        return (String) this.b.get(str2).get(str);
    }

    public void d(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (String next : this.b.keySet()) {
            if (!TextUtils.isEmpty(next) && next.startsWith(str)) {
                concurrentHashMap2.put(next, this.b.get(next));
                concurrentHashMap.put(str2 + next.substring(next.indexOf(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) + 1, next.length()), this.b.get(next));
            }
        }
        for (String remove : concurrentHashMap2.keySet()) {
            this.b.remove(remove);
        }
        Iterator it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (this.b.containsKey(str3)) {
                Map map = (Map) concurrentHashMap.get(str3);
                Iterator it2 = map.keySet().iterator();
                while (it.hasNext()) {
                    String str4 = (String) it2.next();
                    if (!this.b.get(str3).containsKey(str4)) {
                        this.b.get(str3).put(str4, map.get(str4));
                    }
                }
            } else {
                this.b.put(str3, concurrentHashMap.get(str3));
            }
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.b.containsKey(str3)) {
            this.b.get(str3).put(str, str2);
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(str, str2);
        this.b.put(str3, concurrentHashMap);
    }

    public String c(String str, String str2) {
        int i2;
        try {
            i2 = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            i2 = -1;
        }
        if (!this.b.containsKey(str2)) {
            return null;
        }
        Map map = this.b.get(str2);
        String[] strArr = (String[]) map.keySet().toArray(new String[map.keySet().size()]);
        if (i2 < 0 || i2 >= strArr.length) {
            return null;
        }
        return strArr[i2];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r6, java.lang.String[] r7) {
        /*
            r5 = this;
            r5.b()
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            r3 = 3
            r4 = 2
            switch(r0) {
                case -1106363674: goto L_0x0055;
                case -354615841: goto L_0x004b;
                case -75439223: goto L_0x0041;
                case 106079: goto L_0x0037;
                case 94746189: goto L_0x002d;
                case 1098253751: goto L_0x0023;
                case 1280882667: goto L_0x0019;
                case 1984670357: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x005f
        L_0x000f:
            java.lang.String r0 = "setItem"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005f
            r6 = 1
            goto L_0x0060
        L_0x0019:
            java.lang.String r0 = "transfer"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005f
            r6 = 5
            goto L_0x0060
        L_0x0023:
            java.lang.String r0 = "removeItem"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005f
            r6 = 2
            goto L_0x0060
        L_0x002d:
            java.lang.String r0 = "clear"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005f
            r6 = 3
            goto L_0x0060
        L_0x0037:
            java.lang.String r0 = "key"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005f
            r6 = 4
            goto L_0x0060
        L_0x0041:
            java.lang.String r0 = "getItem"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005f
            r6 = 0
            goto L_0x0060
        L_0x004b:
            java.lang.String r0 = "clear_by_tab"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005f
            r6 = 6
            goto L_0x0060
        L_0x0055:
            java.lang.String r0 = "length"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005f
            r6 = 7
            goto L_0x0060
        L_0x005f:
            r6 = -1
        L_0x0060:
            switch(r6) {
                case 0: goto L_0x00c1;
                case 1: goto L_0x00b4;
                case 2: goto L_0x00a9;
                case 3: goto L_0x00a0;
                case 4: goto L_0x0094;
                case 5: goto L_0x0089;
                case 6: goto L_0x0080;
                case 7: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x00cd
        L_0x0065:
            int r6 = r7.length
            if (r6 < r3) goto L_0x00cd
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = ""
            r6.append(r0)
            r7 = r7[r4]
            int r7 = r5.d(r7)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto L_0x00ce
        L_0x0080:
            int r6 = r7.length
            if (r6 < r1) goto L_0x00cd
            r6 = r7[r2]
            r5.c(r6)
            goto L_0x00cd
        L_0x0089:
            int r6 = r7.length
            if (r6 < r4) goto L_0x00cd
            r6 = r7[r2]
            r7 = r7[r1]
            r5.d(r6, r7)
            goto L_0x00cd
        L_0x0094:
            int r6 = r7.length
            if (r6 < r3) goto L_0x00cd
            r6 = r7[r2]
            r7 = r7[r4]
            java.lang.String r6 = r5.c(r6, r7)
            goto L_0x00ce
        L_0x00a0:
            int r6 = r7.length
            if (r6 < r3) goto L_0x00cd
            r6 = r7[r4]
            r5.b(r6)
            goto L_0x00cd
        L_0x00a9:
            int r6 = r7.length
            if (r6 < r3) goto L_0x00cd
            r6 = r7[r2]
            r7 = r7[r4]
            r5.b(r6, r7)
            goto L_0x00cd
        L_0x00b4:
            int r6 = r7.length
            if (r6 < r3) goto L_0x00cd
            r6 = r7[r2]
            r0 = r7[r1]
            r7 = r7[r4]
            r5.a(r6, r0, r7)
            goto L_0x00cd
        L_0x00c1:
            int r6 = r7.length
            if (r6 < r3) goto L_0x00cd
            r6 = r7[r2]
            r7 = r7[r4]
            java.lang.String r6 = r5.a((java.lang.String) r6, (java.lang.String) r7)
            goto L_0x00ce
        L_0x00cd:
            r6 = 0
        L_0x00ce:
            r5.b()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.g.a(java.lang.String, java.lang.String[]):java.lang.String");
    }
}
