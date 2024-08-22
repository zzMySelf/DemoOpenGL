package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.impl.inlinewidget.video.widget.SwanInlineBaseVideoWidget;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class hr {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f7135a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f513a;

    /* renamed from: b  reason: collision with root package name */
    private static long f7136b = 0;

    /* renamed from: b  reason: collision with other field name */
    private static String f514b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f7137c = (ic.a(5) + "-");

    /* renamed from: a  reason: collision with other field name */
    public long f515a;

    /* renamed from: a  reason: collision with other field name */
    private hv f516a = null;

    /* renamed from: a  reason: collision with other field name */
    private List<ho> f517a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Object> f518a = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f7138d = f514b;

    /* renamed from: e  reason: collision with root package name */
    private String f7139e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f7140f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f7141g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f7142h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f7143i = null;

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m8602a();

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f513a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static synchronized String i() {
        String sb;
        synchronized (hr.class) {
            StringBuilder append = new StringBuilder().append(f7137c);
            long j2 = f7136b;
            f7136b = 1 + j2;
            sb = append.append(Long.toString(j2)).toString();
        }
        return sb;
    }

    public hr() {
    }

    public hr(Bundle bundle) {
        this.f7140f = bundle.getString("ext_to");
        this.f7141g = bundle.getString(SwanInlineBaseVideoWidget.UbcConstants.EXT_KEY_FROM);
        this.f7142h = bundle.getString("ext_chid");
        this.f7139e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f517a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                ho a2 = ho.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f517a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f516a = new hv(bundle2);
        }
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f7139e)) {
            return null;
        }
        if (this.f7139e == null) {
            this.f7139e = i();
        }
        return this.f7139e;
    }

    public void k(String str) {
        this.f7139e = str;
    }

    public String k() {
        return this.f7142h;
    }

    public void l(String str) {
        this.f7142h = str;
    }

    public String l() {
        return this.f7140f;
    }

    public void m(String str) {
        this.f7140f = str;
    }

    public String m() {
        return this.f7141g;
    }

    public void n(String str) {
        this.f7141g = str;
    }

    public String n() {
        return this.f7143i;
    }

    public void o(String str) {
        this.f7143i = str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hv m8600a() {
        return this.f516a;
    }

    public void a(hv hvVar) {
        this.f516a = hvVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<ho> m8603a() {
        if (this.f517a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f517a));
    }

    public ho a(String str) {
        return a(str, (String) null);
    }

    public ho a(String str, String str2) {
        for (ho next : this.f517a) {
            if ((str2 == null || str2.equals(next.b())) && str.equals(next.a())) {
                return next;
            }
        }
        return null;
    }

    public void a(ho hoVar) {
        this.f517a.add(hoVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m8601a(String str) {
        Map<String, Object> map = this.f518a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized Collection<String> b() {
        if (this.f518a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f518a.keySet()));
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f7138d)) {
            bundle.putString("ext_ns", this.f7138d);
        }
        if (!TextUtils.isEmpty(this.f7141g)) {
            bundle.putString(SwanInlineBaseVideoWidget.UbcConstants.EXT_KEY_FROM, this.f7141g);
        }
        if (!TextUtils.isEmpty(this.f7140f)) {
            bundle.putString("ext_to", this.f7140f);
        }
        if (!TextUtils.isEmpty(this.f7139e)) {
            bundle.putString("ext_pkt_id", this.f7139e);
        }
        if (!TextUtils.isEmpty(this.f7142h)) {
            bundle.putString("ext_chid", this.f7142h);
        }
        hv hvVar = this.f516a;
        if (hvVar != null) {
            bundle.putBundle("ext_ERROR", hvVar.a());
        }
        List<ho> list = this.f517a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (ho a2 : this.f517a) {
                Bundle a3 = a2.a();
                if (a3 != null) {
                    bundleArr[i2] = a3;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0131 A[SYNTHETIC, Splitter:B:55:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0138 A[SYNTHETIC, Splitter:B:59:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0149 A[SYNTHETIC, Splitter:B:68:0x0149] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0150 A[SYNTHETIC, Splitter:B:72:0x0150] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String o() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            r0.<init>()     // Catch:{ all -> 0x0161 }
            java.util.Collection r1 = r6.a()     // Catch:{ all -> 0x0161 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0161 }
        L_0x000e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x0022
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0161 }
            com.xiaomi.push.hs r2 = (com.xiaomi.push.hs) r2     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = r2.d()     // Catch:{ all -> 0x0161 }
            r0.append(r2)     // Catch:{ all -> 0x0161 }
            goto L_0x000e
        L_0x0022:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.f518a     // Catch:{ all -> 0x0161 }
            if (r1 == 0) goto L_0x015b
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0161 }
            if (r1 != 0) goto L_0x015b
            java.lang.String r1 = "PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="
            java.lang.String r1 = com.xiaomi.push.bl.b(r1)     // Catch:{ all -> 0x0161 }
            r0.append(r1)     // Catch:{ all -> 0x0161 }
            java.util.Collection r1 = r6.b()     // Catch:{ all -> 0x0161 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0161 }
        L_0x003d:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x0156
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0161 }
            java.lang.Object r3 = r6.a((java.lang.String) r2)     // Catch:{ all -> 0x0161 }
            java.lang.String r4 = "<property>"
            r0.append(r4)     // Catch:{ all -> 0x0161 }
            java.lang.String r4 = "<name>"
            java.lang.StringBuilder r4 = r0.append(r4)     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = com.xiaomi.push.ic.a((java.lang.String) r2)     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.String r4 = "</name>"
            r2.append(r4)     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = "<value type=\""
            r0.append(r2)     // Catch:{ all -> 0x0161 }
            boolean r2 = r3 instanceof java.lang.Integer     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x007f
            java.lang.String r2 = "integer\">"
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0161 }
            java.lang.String r3 = "</value>"
            r2.append(r3)     // Catch:{ all -> 0x0161 }
            goto L_0x013e
        L_0x007f:
            boolean r2 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x0095
            java.lang.String r2 = "long\">"
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0161 }
            java.lang.String r3 = "</value>"
            r2.append(r3)     // Catch:{ all -> 0x0161 }
            goto L_0x013e
        L_0x0095:
            boolean r2 = r3 instanceof java.lang.Float     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x00aa
            java.lang.String r2 = "float\">"
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0161 }
            java.lang.String r3 = "</value>"
            r2.append(r3)     // Catch:{ all -> 0x0161 }
            goto L_0x013e
        L_0x00aa:
            boolean r2 = r3 instanceof java.lang.Double     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x00bf
            java.lang.String r2 = "double\">"
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0161 }
            java.lang.String r3 = "</value>"
            r2.append(r3)     // Catch:{ all -> 0x0161 }
            goto L_0x013e
        L_0x00bf:
            boolean r2 = r3 instanceof java.lang.Boolean     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x00d4
            java.lang.String r2 = "boolean\">"
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0161 }
            java.lang.String r3 = "</value>"
            r2.append(r3)     // Catch:{ all -> 0x0161 }
            goto L_0x013e
        L_0x00d4:
            boolean r2 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x00ed
            java.lang.String r2 = "string\">"
            r0.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = com.xiaomi.push.ic.a((java.lang.String) r3)     // Catch:{ all -> 0x0161 }
            r0.append(r2)     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ all -> 0x0161 }
            goto L_0x013e
        L_0x00ed:
            r2 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0128, all -> 0x0125 }
            r4.<init>()     // Catch:{ Exception -> 0x0128, all -> 0x0125 }
            java.io.ObjectOutputStream r5 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r5.writeObject(r3)     // Catch:{ Exception -> 0x011e }
            java.lang.String r2 = "java-object\">"
            r0.append(r2)     // Catch:{ Exception -> 0x011e }
            byte[] r2 = r4.toByteArray()     // Catch:{ Exception -> 0x011e }
            java.lang.String r2 = com.xiaomi.push.ic.a((byte[]) r2)     // Catch:{ Exception -> 0x011e }
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ Exception -> 0x011e }
            java.lang.String r3 = "</value>"
            r2.append(r3)     // Catch:{ Exception -> 0x011e }
            r5.close()     // Catch:{ Exception -> 0x0118 }
            goto L_0x0119
        L_0x0118:
            r2 = move-exception
        L_0x0119:
            r4.close()     // Catch:{ Exception -> 0x013c }
            goto L_0x013b
        L_0x011e:
            r2 = move-exception
            goto L_0x012c
        L_0x0120:
            r0 = move-exception
            goto L_0x0147
        L_0x0122:
            r3 = move-exception
            r5 = r2
            goto L_0x012b
        L_0x0125:
            r0 = move-exception
            r4 = r2
            goto L_0x0147
        L_0x0128:
            r3 = move-exception
            r4 = r2
            r5 = r4
        L_0x012b:
            r2 = r3
        L_0x012c:
            r2.printStackTrace()     // Catch:{ all -> 0x0145 }
            if (r5 == 0) goto L_0x0136
            r5.close()     // Catch:{ Exception -> 0x0135 }
            goto L_0x0136
        L_0x0135:
            r2 = move-exception
        L_0x0136:
            if (r4 == 0) goto L_0x013e
            r4.close()     // Catch:{ Exception -> 0x013c }
        L_0x013b:
            goto L_0x013e
        L_0x013c:
            r2 = move-exception
            goto L_0x013b
        L_0x013e:
            java.lang.String r2 = "</property>"
            r0.append(r2)     // Catch:{ all -> 0x0161 }
            goto L_0x003d
        L_0x0145:
            r0 = move-exception
            r2 = r5
        L_0x0147:
            if (r2 == 0) goto L_0x014e
            r2.close()     // Catch:{ Exception -> 0x014d }
            goto L_0x014e
        L_0x014d:
            r1 = move-exception
        L_0x014e:
            if (r4 == 0) goto L_0x0155
            r4.close()     // Catch:{ Exception -> 0x0154 }
            goto L_0x0155
        L_0x0154:
            r1 = move-exception
        L_0x0155:
            throw r0     // Catch:{ all -> 0x0161 }
        L_0x0156:
            java.lang.String r1 = "</properties>"
            r0.append(r1)     // Catch:{ all -> 0x0161 }
        L_0x015b:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0161 }
            monitor-exit(r6)
            return r0
        L_0x0161:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.hr.o():java.lang.String");
    }

    public String p() {
        return this.f7138d;
    }

    public static String q() {
        return f7135a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hr hrVar = (hr) obj;
        hv hvVar = this.f516a;
        if (hvVar == null ? hrVar.f516a != null : !hvVar.equals(hrVar.f516a)) {
            return false;
        }
        String str = this.f7141g;
        if (str == null ? hrVar.f7141g != null : !str.equals(hrVar.f7141g)) {
            return false;
        }
        if (!this.f517a.equals(hrVar.f517a)) {
            return false;
        }
        String str2 = this.f7139e;
        if (str2 == null ? hrVar.f7139e != null : !str2.equals(hrVar.f7139e)) {
            return false;
        }
        String str3 = this.f7142h;
        if (str3 == null ? hrVar.f7142h != null : !str3.equals(hrVar.f7142h)) {
            return false;
        }
        Map<String, Object> map = this.f518a;
        if (map == null ? hrVar.f518a != null : !map.equals(hrVar.f518a)) {
            return false;
        }
        String str4 = this.f7140f;
        if (str4 == null ? hrVar.f7140f != null : !str4.equals(hrVar.f7140f)) {
            return false;
        }
        String str5 = this.f7138d;
        String str6 = hrVar.f7138d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f7138d;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7139e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f7140f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f7141g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f7142h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f517a.hashCode()) * 31) + this.f518a.hashCode()) * 31;
        hv hvVar = this.f516a;
        if (hvVar != null) {
            i2 = hvVar.hashCode();
        }
        return hashCode5 + i2;
    }
}
