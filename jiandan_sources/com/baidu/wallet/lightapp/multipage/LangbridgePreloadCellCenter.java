package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import androidx.collection.ArraySet;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.multipage.h;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class LangbridgePreloadCellCenter implements NoProguard, h.a {
    public static final int Millis = 1000;
    public static final String PRELOAD_POOL_TAG_FROM_NA = "PRELOAD";
    public static final String TAG = "LangbridgePreloadCellCenter";
    public LinkedHashMap<String, LinkedHashMap<b, c>> a;
    public Handler b;
    public Context c;

    public static class a {
        public static LangbridgePreloadCellCenter a = new LangbridgePreloadCellCenter();
    }

    public static class b {
        public String a;
        public Integer b;
        public HashMap c;
        public String d;
        public long e;
        public int f = 0;
        public String g;

        public b(String str, long j) {
            this.a = str;
            this.e = j;
            this.b = Integer.valueOf(CheckUtils.stripUrlParams(str).hashCode());
            this.c = (HashMap) LangbridgePreloadCellCenter.getURLRequest(str);
            this.d = LangbridgePreloadCellCenter.c(str);
            this.g = LangbridgePreloadCellCenter.d(str);
        }

        public String toString() {
            return "originUrl = " + this.a + "\tdeadTime = " + this.e + "\turlHashCode = " + this.b + "\turlReMap = " + this.c.toString() + "\tref = " + this.d + "\turlTag = " + this.g;
        }
    }

    public static boolean checkURL(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        boolean matches = Patterns.WEB_URL.matcher(charSequence).matches();
        if (matches) {
            return matches;
        }
        String str = charSequence + "";
        if (!URLUtil.isNetworkUrl(str)) {
            return matches;
        }
        try {
            new URL(str);
            return true;
        } catch (Exception unused) {
            return matches;
        }
    }

    private void e() {
    }

    public static LangbridgePreloadCellCenter getInstance(Context context) {
        LangbridgePreloadCellCenter langbridgePreloadCellCenter = a.a;
        if (langbridgePreloadCellCenter.c == null && context != null) {
            langbridgePreloadCellCenter.c = DxmApplicationContextImpl.getApplicationContext(context);
            a.a.b = new Handler(Looper.getMainLooper());
            a.a.c();
        }
        return a.a;
    }

    public static Map<String, String> getURLRequest(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String str2 = null;
        try {
            str2 = new URL(str).getQuery();
            LogUtil.d(TAG, "query = " + str2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str2)) {
            return hashMap;
        }
        for (String split : str2.split("[&]")) {
            String[] split2 = split.split("[=]");
            if (split2 != null && split2.length > 0) {
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                } else if (split2[0] != "") {
                    hashMap.put(split2[0], "");
                }
            }
        }
        return hashMap;
    }

    public static boolean needNewWebviewOpen(String str) {
        return !TextUtils.isEmpty(str) && str.contains("LangbridgePreloadPageTag=");
    }

    public void clearPreloadPool() {
        DXMSdkSAUtils.onEvent("#clearPreloadPool");
        AnonymousClass7 r0 = new Runnable() {
            public void run() {
                c cVar;
                try {
                    for (Map.Entry entry : LangbridgePreloadCellCenter.this.a.entrySet()) {
                        String str = (String) entry.getKey();
                        Iterator it = ((Map) entry.getValue()).keySet().iterator();
                        while (it != null && it.hasNext()) {
                            b bVar = (b) it.next();
                            if (!(bVar == null || (cVar = (c) ((LinkedHashMap) LangbridgePreloadCellCenter.this.a.get(str)).get(bVar)) == null)) {
                                cVar.i();
                            }
                        }
                        LangbridgePreloadCellCenter.this.a.remove(str);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            r0.run();
        } else {
            this.b.post(r0);
        }
    }

    public void clearPreloadPoolByGroup(final String str) {
        DXMSdkSAUtils.onEventWithValues("#clearPreloadPool", Arrays.asList(new String[]{str}));
        AnonymousClass6 r0 = new Runnable() {
            public void run() {
                c cVar;
                try {
                    for (Map.Entry entry : LangbridgePreloadCellCenter.this.a.entrySet()) {
                        if (((String) entry.getKey()).equals(str)) {
                            Iterator it = ((Map) entry.getValue()).keySet().iterator();
                            while (it != null && it.hasNext()) {
                                b bVar = (b) it.next();
                                if (!(bVar == null || (cVar = (c) ((LinkedHashMap) LangbridgePreloadCellCenter.this.a.get(str)).get(bVar)) == null)) {
                                    cVar.i();
                                }
                            }
                            LangbridgePreloadCellCenter.this.a.remove(str);
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            r0.run();
        } else {
            this.b.post(r0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.baidu.wallet.lightapp.multipage.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.baidu.wallet.lightapp.multipage.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.wallet.lightapp.multipage.c getCellFromPrePool(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            com.baidu.wallet.lightapp.multipage.h r0 = com.baidu.wallet.lightapp.multipage.h.a()
            android.content.Context r1 = r5.c
            com.baidu.wallet.lightapp.multipage.LangbridgeSettings r0 = r0.a((android.content.Context) r1)
            boolean r0 = r0.MW_ON
            r1 = 0
            java.lang.String r2 = "#preloadURLMatchRet"
            if (r0 != 0) goto L_0x001f
            java.lang.String r6 = "-1"
            java.lang.String[] r6 = new java.lang.String[]{r6}
            java.util.List r6 = java.util.Arrays.asList(r6)
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r2, r6)
            return r1
        L_0x001f:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r3 = "LangbridgePreloadCellCenter"
            if (r0 != 0) goto L_0x008a
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r0 = r5.a
            java.lang.Object r0 = r0.get(r7)
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0
            com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b r0 = r5.a(r6, r0)
            java.lang.String r4 = "getCell success"
            if (r0 == 0) goto L_0x0058
            com.baidu.wallet.core.utils.LogUtil.d(r3, r4)
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r8 = r5.a
            java.lang.Object r8 = r8.get(r7)
            java.util.LinkedHashMap r8 = (java.util.LinkedHashMap) r8
            java.lang.Object r8 = r8.get(r0)
            r1 = r8
            com.baidu.wallet.lightapp.multipage.c r1 = (com.baidu.wallet.lightapp.multipage.c) r1
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r8 = r5.a
            java.lang.Object r7 = r8.get(r7)
            java.util.LinkedHashMap r7 = (java.util.LinkedHashMap) r7
            r7.remove(r0)
            r5.e()
            goto L_0x008a
        L_0x0058:
            if (r8 == 0) goto L_0x008a
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r7 = r5.a
            java.lang.String r8 = "PRELOAD"
            java.lang.Object r7 = r7.get(r8)
            java.util.LinkedHashMap r7 = (java.util.LinkedHashMap) r7
            com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b r7 = r5.a(r6, r7)
            if (r7 == 0) goto L_0x008a
            com.baidu.wallet.core.utils.LogUtil.d(r3, r4)
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r0 = r5.a
            java.lang.Object r0 = r0.get(r8)
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0
            java.lang.Object r0 = r0.get(r7)
            r1 = r0
            com.baidu.wallet.lightapp.multipage.c r1 = (com.baidu.wallet.lightapp.multipage.c) r1
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r0 = r5.a
            java.lang.Object r8 = r0.get(r8)
            java.util.LinkedHashMap r8 = (java.util.LinkedHashMap) r8
            r8.remove(r7)
            r5.e()
        L_0x008a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getCell result = "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            com.baidu.wallet.core.utils.LogUtil.d(r3, r7)
            r7 = 1
            r8 = 0
            r0 = 2
            if (r1 != 0) goto L_0x00b3
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r3 = "1"
            r0[r8] = r3
            r0[r7] = r6
            java.util.List r6 = java.util.Arrays.asList(r0)
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r2, r6)
            goto L_0x00ca
        L_0x00b3:
            com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$4 r3 = new com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$4
            r3.<init>(r1)
            r5.a((java.lang.Runnable) r3)
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r3 = "0"
            r0[r8] = r3
            r0[r7] = r6
            java.util.List r6 = java.util.Arrays.asList(r0)
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r2, r6)
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.getCellFromPrePool(java.lang.String, java.lang.String, boolean):com.baidu.wallet.lightapp.multipage.c");
    }

    public HashSet<String> getLangbridgeCellHashStampByGroup(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();
        for (Map.Entry next : this.a.entrySet()) {
            if (((String) next.getKey()).equals(str)) {
                Iterator it = ((Map) next.getValue()).keySet().iterator();
                while (it != null && it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar != null) {
                        hashSet.add(((c) this.a.get(str).get(bVar)).k());
                    }
                }
            }
        }
        return hashSet;
    }

    public void onSettingUpdated(LangbridgeSettings langbridgeSettings) {
        if (!langbridgeSettings.MW_ON) {
            clearPreloadPool();
        }
    }

    public void preload(ArrayList<String> arrayList, String str, String str2) {
        preload(arrayList, h.a().a(this.c).MW_PRELOAD_LIFE_TIME, str, str2);
    }

    public void preloadUrls(String[] strArr, boolean z) {
        final int i2;
        if (h.a().a(this.c).MW_ON && strArr != null && strArr.length > 0) {
            ArraySet arraySet = new ArraySet();
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            for (final String str : strArr) {
                if (!arraySet.contains(str) && checkURL(str)) {
                    arraySet.add(str);
                    if (!TextUtils.isEmpty(str) && str.contains("LangbridgePreloadMode=")) {
                        try {
                            int indexOf = str.indexOf("LangbridgePreloadMode=");
                            int indexOf2 = str.indexOf("LangbridgePreloadTime=");
                            String str2 = "";
                            String str3 = indexOf >= 0 ? str.substring(indexOf + 22).split(com.alipay.sdk.m.s.a.n)[0] : str2;
                            if (indexOf2 >= 0) {
                                str2 = str.substring(indexOf2 + 22).split(com.alipay.sdk.m.s.a.n)[0];
                            }
                            if ("2".equals(str3) || ("1".equals(str3) && !z)) {
                                try {
                                    i2 = Integer.valueOf(str2).intValue();
                                } catch (Exception unused) {
                                    i2 = 0;
                                }
                                if (i2 <= 0) {
                                    i2 = h.a().a(this.c).MW_PRELOAD_LIFE_TIME;
                                }
                                this.b.post(new Runnable() {
                                    public void run() {
                                        LangbridgePreloadCellCenter.this.a(str, i2, (String) null, (String) null);
                                    }
                                });
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            LogUtil.d(TAG, "preloadUrls cost:" + (System.currentTimeMillis() - valueOf.longValue()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        r0 = (com.baidu.wallet.lightapp.multipage.c) r7.a.get(r2).get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeCellByCell(com.baidu.wallet.lightapp.multipage.c r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 != 0) goto L_0x0005
            monitor-exit(r7)
            return
        L_0x0005:
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r0 = r7.a     // Catch:{ all -> 0x00a5 }
            int r0 = r0.size()     // Catch:{ all -> 0x00a5 }
            if (r0 > 0) goto L_0x000f
            monitor-exit(r7)
            return
        L_0x000f:
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r0 = r7.a     // Catch:{ all -> 0x00a5 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00a5 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a5 }
            r1 = 0
            r2 = r1
        L_0x001b:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00a5 }
            if (r3 == 0) goto L_0x0060
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00a5 }
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r4 = r7.a     // Catch:{ all -> 0x00a5 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x00a5 }
            if (r4 != 0) goto L_0x0030
            goto L_0x001b
        L_0x0030:
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r4 = r7.a     // Catch:{ all -> 0x00a5 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x00a5 }
            java.util.LinkedHashMap r4 = (java.util.LinkedHashMap) r4     // Catch:{ all -> 0x00a5 }
            java.util.Set r4 = r4.keySet()     // Catch:{ all -> 0x00a5 }
            if (r4 != 0) goto L_0x003f
            goto L_0x001b
        L_0x003f:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00a5 }
        L_0x0043:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00a5 }
            if (r5 == 0) goto L_0x001b
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00a5 }
            com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b r5 = (com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.b) r5     // Catch:{ all -> 0x00a5 }
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r6 = r7.a     // Catch:{ all -> 0x00a5 }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ all -> 0x00a5 }
            java.util.LinkedHashMap r6 = (java.util.LinkedHashMap) r6     // Catch:{ all -> 0x00a5 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x00a5 }
            if (r8 != r6) goto L_0x0043
            r2 = r3
            r1 = r5
            goto L_0x001b
        L_0x0060:
            if (r1 == 0) goto L_0x00a3
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x00a3
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r0 = r7.a     // Catch:{ all -> 0x00a5 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x00a5 }
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0     // Catch:{ all -> 0x00a5 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00a5 }
            com.baidu.wallet.lightapp.multipage.c r0 = (com.baidu.wallet.lightapp.multipage.c) r0     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x00a3
            if (r0 != r8) goto L_0x00a3
            com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$2 r8 = new com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$2     // Catch:{ all -> 0x00a5 }
            r8.<init>(r0)     // Catch:{ all -> 0x00a5 }
            r7.a((java.lang.Runnable) r8)     // Catch:{ all -> 0x00a5 }
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r8 = r7.a     // Catch:{ all -> 0x00a5 }
            java.lang.Object r8 = r8.get(r2)     // Catch:{ all -> 0x00a5 }
            java.util.LinkedHashMap r8 = (java.util.LinkedHashMap) r8     // Catch:{ all -> 0x00a5 }
            r8.remove(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r8 = "LangbridgePreloadCellCenter"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r0.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = "remove cell from repload webviewPool，origin url: "
            r0.append(r2)     // Catch:{ all -> 0x00a5 }
            r0.append(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a5 }
            com.baidu.wallet.core.utils.LogUtil.i(r8, r0)     // Catch:{ all -> 0x00a5 }
        L_0x00a3:
            monitor-exit(r7)
            return
        L_0x00a5:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.removeCellByCell(com.baidu.wallet.lightapp.multipage.c):void");
    }

    public void setAllCellsEnable(final boolean z) {
        a((Runnable) new Runnable() {
            public void run() {
                c cVar;
                try {
                    for (Map.Entry entry : LangbridgePreloadCellCenter.this.a.entrySet()) {
                        String str = (String) entry.getKey();
                        Iterator it = ((Map) entry.getValue()).keySet().iterator();
                        while (it != null && it.hasNext()) {
                            b bVar = (b) it.next();
                            if (!(bVar == null || (cVar = (c) ((LinkedHashMap) LangbridgePreloadCellCenter.this.a.get(str)).get(bVar)) == null || cVar.b() == null)) {
                                if (z) {
                                    cVar.b().onResume();
                                } else {
                                    cVar.b().onPause();
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    public LangbridgePreloadCellCenter() {
        this.a = new LinkedHashMap<>();
        h.a().a((h.a) this);
    }

    /* access modifiers changed from: private */
    public void c() {
        this.b.postDelayed(new Runnable() {
            public void run() {
                LangbridgePreloadCellCenter.this.d();
                LangbridgePreloadCellCenter.this.c();
            }
        }, (long) (h.a().a(this.c).MW_PRELOAD_CHECK_TIME * 1000));
    }

    /* access modifiers changed from: private */
    public synchronized void d() {
        if (this.a.size() > 0) {
            for (Map.Entry next : this.a.entrySet()) {
                Set<b> keySet = ((LinkedHashMap) next.getValue()).keySet();
                Vector<b> vector = new Vector<>();
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                for (b bVar : keySet) {
                    if (bVar.e <= valueOf.longValue()) {
                        LogUtil.d(TAG, "release cell : " + bVar.a);
                        c cVar = (c) this.a.get(next.getKey()).get(bVar);
                        if (cVar != null) {
                            cVar.i();
                        }
                        vector.add(bVar);
                    }
                }
                for (b remove : vector) {
                    this.a.get(next.getKey()).remove(remove);
                }
            }
        }
    }

    public void preload(ArrayList<String> arrayList, int i2, String str, String str2) {
        if (h.a().a(this.c).MW_ON && arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                a(it.next(), i2, str, str2);
            }
            LogUtil.d(TAG, "preload map = " + this.a.toString());
        }
    }

    private void b() {
        if (this.a.size() > 0) {
            String str = null;
            b bVar = null;
            for (String next : this.a.keySet()) {
                for (b bVar2 : this.a.get(next).keySet()) {
                    if (bVar == null || bVar2.e < bVar.e) {
                        str = next;
                        bVar = bVar2;
                    }
                }
            }
            if (!TextUtils.isEmpty(str) && bVar != null && this.a.get(str) != null) {
                c cVar = (c) this.a.get(str).get(bVar);
                if (cVar != null) {
                    cVar.i();
                }
                this.a.get(str).remove(bVar);
                DXMSdkSAUtils.onEventWithValues("#popOldestPreloadUrl", Arrays.asList(new String[]{bVar.toString()}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0113, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r11, int r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "#preloadURL"
            r1 = 2
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ all -> 0x0114 }
            r3 = 0
            r2[r3] = r11     // Catch:{ all -> 0x0114 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            r4.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ all -> 0x0114 }
            r4.append(r12)     // Catch:{ all -> 0x0114 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0114 }
            r5 = 1
            r2[r5] = r4     // Catch:{ all -> 0x0114 }
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r0, r2)     // Catch:{ all -> 0x0114 }
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0114 }
            if (r0 == 0) goto L_0x002c
            monitor-exit(r10)
            return
        L_0x002c:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0114 }
            int r12 = r12 * 1000
            long r8 = (long) r12     // Catch:{ all -> 0x0114 }
            long r6 = r6 + r8
            java.lang.Long r12 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0114 }
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0114 }
            if (r0 == 0) goto L_0x0040
            java.lang.String r13 = "PRELOAD"
        L_0x0040:
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r0 = r10.a     // Catch:{ all -> 0x0114 }
            java.lang.Object r0 = r0.get(r13)     // Catch:{ all -> 0x0114 }
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b r0 = r10.a(r11, r0)     // Catch:{ all -> 0x0114 }
            if (r0 == 0) goto L_0x0092
            java.util.LinkedHashMap<java.lang.String, java.util.LinkedHashMap<com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b, com.baidu.wallet.lightapp.multipage.c>> r14 = r10.a     // Catch:{ all -> 0x0114 }
            java.lang.Object r14 = r14.get(r13)     // Catch:{ all -> 0x0114 }
            java.util.LinkedHashMap r14 = (java.util.LinkedHashMap) r14     // Catch:{ all -> 0x0114 }
            java.lang.Object r14 = r14.get(r0)     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.lightapp.multipage.c r14 = (com.baidu.wallet.lightapp.multipage.c) r14     // Catch:{ all -> 0x0114 }
            if (r14 == 0) goto L_0x0079
            java.lang.String r2 = "LangbridgePreloadCellCenter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            r4.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r6 = "had preloaded, refresh"
            r4.append(r6)     // Catch:{ all -> 0x0114 }
            r4.append(r0)     // Catch:{ all -> 0x0114 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.core.utils.LogUtil.i(r2, r4)     // Catch:{ all -> 0x0114 }
            r0.f = r3     // Catch:{ all -> 0x0114 }
            r10.b(r13, r0, r14)     // Catch:{ all -> 0x0114 }
        L_0x0079:
            long r12 = r12.longValue()     // Catch:{ all -> 0x0114 }
            r0.e = r12     // Catch:{ all -> 0x0114 }
            java.lang.String r12 = "#preloadURLRet"
            java.lang.String[] r13 = new java.lang.String[r1]     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "0"
            r13[r3] = r14     // Catch:{ all -> 0x0114 }
            r13[r5] = r11     // Catch:{ all -> 0x0114 }
            java.util.List r11 = java.util.Arrays.asList(r13)     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r12, r11)     // Catch:{ all -> 0x0114 }
            monitor-exit(r10)
            return
        L_0x0092:
            int r0 = r10.a()     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.lightapp.multipage.h r2 = com.baidu.wallet.lightapp.multipage.h.a()     // Catch:{ all -> 0x0114 }
            android.content.Context r4 = r10.c     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.lightapp.multipage.LangbridgeSettings r2 = r2.a((android.content.Context) r4)     // Catch:{ all -> 0x0114 }
            int r2 = r2.MW_PRELOAD_POOL_SUM     // Catch:{ all -> 0x0114 }
            if (r0 < r2) goto L_0x00a7
            r10.b()     // Catch:{ all -> 0x0114 }
        L_0x00a7:
            com.baidu.wallet.lightapp.base.LightappWebViewCenter r0 = com.baidu.wallet.lightapp.base.LightappWebViewCenter.getInstance()     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.lightapp.business.LightappBrowserWebView r0 = r0.getLightappWebViewFromPool()     // Catch:{ all -> 0x0114 }
            if (r0 != 0) goto L_0x00bc
            r10.b()     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.lightapp.base.LightappWebViewCenter r0 = com.baidu.wallet.lightapp.base.LightappWebViewCenter.getInstance()     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.lightapp.business.LightappBrowserWebView r0 = r0.getLightappWebViewFromPool()     // Catch:{ all -> 0x0114 }
        L_0x00bc:
            if (r0 == 0) goto L_0x00e6
            com.baidu.wallet.lightapp.multipage.LangbridgeCell r2 = new com.baidu.wallet.lightapp.multipage.LangbridgeCell     // Catch:{ all -> 0x0114 }
            android.content.Context r4 = r10.c     // Catch:{ all -> 0x0114 }
            r2.<init>((android.content.Context) r4, (com.baidu.wallet.lightapp.business.LightappBrowserWebView) r0, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b r14 = new com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter$b     // Catch:{ all -> 0x0114 }
            long r6 = r12.longValue()     // Catch:{ all -> 0x0114 }
            r14.<init>(r11, r6)     // Catch:{ all -> 0x0114 }
            r10.a(r13, r14, r2)     // Catch:{ all -> 0x0114 }
            r10.b(r13, r14, r2)     // Catch:{ all -> 0x0114 }
            java.lang.String r12 = "#preloadURLRet"
            java.lang.String[] r13 = new java.lang.String[r1]     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "1"
            r13[r3] = r14     // Catch:{ all -> 0x0114 }
            r13[r5] = r11     // Catch:{ all -> 0x0114 }
            java.util.List r11 = java.util.Arrays.asList(r13)     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r12, r11)     // Catch:{ all -> 0x0114 }
            goto L_0x0112
        L_0x00e6:
            java.lang.String r12 = "LangbridgePreloadCellCenter"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            r13.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "preload fail ["
            r13.append(r14)     // Catch:{ all -> 0x0114 }
            r13.append(r11)     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "]"
            r13.append(r14)     // Catch:{ all -> 0x0114 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.core.utils.LogUtil.d(r12, r13)     // Catch:{ all -> 0x0114 }
            java.lang.String r12 = "#preloadURLRet"
            java.lang.String[] r13 = new java.lang.String[r1]     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "-1"
            r13[r3] = r14     // Catch:{ all -> 0x0114 }
            r13[r5] = r11     // Catch:{ all -> 0x0114 }
            java.util.List r11 = java.util.Arrays.asList(r13)     // Catch:{ all -> 0x0114 }
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r12, r11)     // Catch:{ all -> 0x0114 }
        L_0x0112:
            monitor-exit(r10)
            return
        L_0x0114:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter.a(java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    public static String c(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = new URL(str).getRef();
            LogUtil.d(TAG, "getURlRef = " + str2);
            return str2;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* access modifiers changed from: private */
    public void b(final String str, final b bVar, final c cVar) {
        if (bVar != null && cVar != null && !TextUtils.isEmpty(bVar.a)) {
            LogUtil.d(TAG, "preloadUrlbyCell url = " + bVar.a + " ; cell = " + cVar + " ; reloadTimes = " + bVar.f);
            int i2 = bVar.f;
            bVar.f = i2 + -1;
            if (i2 >= 0) {
                cVar.a(bVar.a, (b) new b() {
                    public void a(int i2, String str, String str2) {
                        if (i2 == 0 && !TextUtils.isEmpty(str2) && !TextUtils.equals("about:blank", str2)) {
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preload success url = " + str2);
                        } else if (i2 == 1101 || i2 == 1102) {
                            cVar.i();
                            if (LangbridgePreloadCellCenter.this.a.containsKey(str) && ((LinkedHashMap) LangbridgePreloadCellCenter.this.a.get(str)).values() != null) {
                                ((LinkedHashMap) LangbridgePreloadCellCenter.this.a.get(str)).values().remove(cVar);
                            }
                            e a2 = e.a();
                            Context d2 = LangbridgePreloadCellCenter.this.c;
                            a2.a(d2, 1, "preload exception", Arrays.asList(new String[]{str2, "" + i2, str}));
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onException destory url = " + str2);
                        } else if (bVar.f < 0) {
                            cVar.i();
                            if (LangbridgePreloadCellCenter.this.a.containsKey(str) && ((LinkedHashMap) LangbridgePreloadCellCenter.this.a.get(str)).values() != null) {
                                ((LinkedHashMap) LangbridgePreloadCellCenter.this.a.get(str)).values().remove(cVar);
                            }
                            e a3 = e.a();
                            Context d3 = LangbridgePreloadCellCenter.this.c;
                            a3.a(d3, 1, "preload fail", Arrays.asList(new String[]{str2, "" + i2, str}));
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onError destory url = " + str2);
                        } else {
                            LogUtil.d(LangbridgePreloadCellCenter.TAG, "preloadUrlbyCell onError code = " + i2 + " ; desc = " + str + " ; url = " + str2);
                            LangbridgePreloadCellCenter.this.b(str, bVar, cVar);
                        }
                    }
                }, true);
            }
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("LangbridgePreloadPageTag=");
        return indexOf >= 0 ? str.substring(indexOf + 25).split(com.alipay.sdk.m.s.a.n)[0] : "";
    }

    private int a() {
        int i2 = 0;
        for (String str : this.a.keySet()) {
            i2 += this.a.get(str).size();
        }
        return i2;
    }

    private void a(String str, b bVar, c cVar) {
        if (this.a.containsKey(str)) {
            this.a.get(str).put(bVar, cVar);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(bVar, cVar);
        this.a.put(str, linkedHashMap);
    }

    private b a(String str, LinkedHashMap linkedHashMap) {
        b bVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (TextUtils.isEmpty(str) || linkedHashMap == null || linkedHashMap.size() <= 0) {
            return null;
        }
        b bVar2 = new b(str, 0);
        Integer valueOf = Integer.valueOf(CheckUtils.stripUrlParams(str).hashCode());
        DXMSdkSAUtils.onEventStart("#webviewPoolMatchTime");
        LogUtil.d(TAG, "targetIns = " + bVar2.toString());
        if (valueOf != null) {
            Iterator it = linkedHashMap.entrySet().iterator();
            bVar = null;
            while (true) {
                if (it == null || !it.hasNext()) {
                    break;
                }
                bVar = (b) ((Map.Entry) it.next()).getKey();
                if (bVar != null && bVar.b != null) {
                    if (!TextUtils.isEmpty(bVar2.g) && bVar2.g.equals(bVar.g)) {
                        atomicBoolean.set(true);
                        break;
                    }
                    LogUtil.d(TAG, "poolIns = " + bVar.toString());
                    if (bVar.a.equals(bVar2.a)) {
                        atomicBoolean.set(true);
                        break;
                    }
                } else {
                    atomicBoolean.set(false);
                }
            }
        } else {
            bVar = null;
        }
        DXMSdkSAUtils.onEventEnd("#webviewPoolMatchTime", atomicBoolean.get() ? 1 : 0);
        if (atomicBoolean.get()) {
            return bVar;
        }
        return null;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }
}
