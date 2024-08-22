package com.baidu.location.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.e.e;
import com.baidu.location.e.f;
import com.baidu.location.e.h;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class d {

    /* renamed from: h  reason: collision with root package name */
    private static Method f13641h = null;

    /* renamed from: i  reason: collision with root package name */
    private static Method f13642i = null;

    /* renamed from: j  reason: collision with root package name */
    private static Method f13643j = null;
    private static Method k = null;
    private static Method l = null;
    private static Class<?> m = null;

    /* renamed from: a  reason: collision with root package name */
    String f13644a = null;

    /* renamed from: b  reason: collision with root package name */
    String f13645b = null;

    /* renamed from: c  reason: collision with root package name */
    c f13646c = new c();

    /* renamed from: d  reason: collision with root package name */
    private Address f13647d = null;

    /* renamed from: e  reason: collision with root package name */
    private Context f13648e = null;

    /* renamed from: f  reason: collision with root package name */
    private TelephonyManager f13649f = null;

    /* renamed from: g  reason: collision with root package name */
    private a f13650g = new a();
    /* access modifiers changed from: private */
    public WifiManager n = null;
    private C0230d o = null;
    private String p = null;
    /* access modifiers changed from: private */
    public LocationClientOption q;
    /* access modifiers changed from: private */
    public b r;
    private String s = null;
    private long t = 0;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public int f13651a;

        /* renamed from: b  reason: collision with root package name */
        public int f13652b;

        /* renamed from: c  reason: collision with root package name */
        public int f13653c;

        /* renamed from: d  reason: collision with root package name */
        public int f13654d;

        /* renamed from: e  reason: collision with root package name */
        public int f13655e;

        /* renamed from: f  reason: collision with root package name */
        public int f13656f;

        /* renamed from: g  reason: collision with root package name */
        public char f13657g;

        private a() {
            this.f13651a = -1;
            this.f13652b = -1;
            this.f13653c = -1;
            this.f13654d = -1;
            this.f13655e = Integer.MAX_VALUE;
            this.f13656f = Integer.MAX_VALUE;
            this.f13657g = 0;
        }

        /* access modifiers changed from: private */
        public boolean b() {
            return this.f13651a > -1 && this.f13652b > 0;
        }

        public String a() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(this.f13657g);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d", new Object[]{Integer.valueOf(this.f13653c), Integer.valueOf(this.f13654d), Integer.valueOf(this.f13651a), Integer.valueOf(this.f13652b)}));
            if (this.f13655e < Integer.MAX_VALUE && this.f13656f < Integer.MAX_VALUE) {
                stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[]{Double.valueOf(((double) this.f13656f) / 14400.0d), Double.valueOf(((double) this.f13655e) / 14400.0d)}));
            }
            return stringBuffer.toString();
        }
    }

    public interface b {
        void onReceiveFixLocation(BDLocation bDLocation);
    }

    class c extends f {

        /* renamed from: a  reason: collision with root package name */
        String f13659a = null;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13661c = false;

        c() {
            this.k = new HashMap();
        }

        private void b() {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(63);
            d.this.r.onReceiveFixLocation(bDLocation);
        }

        public void a() {
            this.f13951h = h.e();
            String str = this.f13659a + "&enc=2";
            this.f13659a = str;
            String encodeTp4 = Jni.encodeTp4(str);
            this.f13659a = null;
            this.k.put("bloc", encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        }

        public void a(String str) {
            this.f13659a = str;
            if (!this.f13661c) {
                this.f13661c = true;
                a(n.a().c(), false, "");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00c4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(boolean r5) {
            /*
                r4 = this;
                java.lang.String r0 = ";"
                java.lang.String r1 = "enc"
                if (r5 == 0) goto L_0x00bd
                java.lang.String r5 = r4.f13953j
                if (r5 == 0) goto L_0x00bd
                java.lang.String r5 = r4.f13953j     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r2 = "\"enc\""
                boolean r2 = r5.contains(r2)     // Catch:{ Exception -> 0x00b9 }
                if (r2 == 0) goto L_0x0030
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x002c }
                r2.<init>(r5)     // Catch:{ Exception -> 0x002c }
                boolean r3 = r2.has(r1)     // Catch:{ Exception -> 0x002c }
                if (r3 == 0) goto L_0x0030
                java.lang.String r1 = r2.getString(r1)     // Catch:{ Exception -> 0x002c }
                com.baidu.location.a.i r2 = com.baidu.location.a.i.a()     // Catch:{ Exception -> 0x002c }
                java.lang.String r5 = r2.a(r1)     // Catch:{ Exception -> 0x002c }
                goto L_0x0030
            L_0x002c:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ Exception -> 0x00b9 }
            L_0x0030:
                com.baidu.location.BDLocation r1 = new com.baidu.location.BDLocation     // Catch:{ Exception -> 0x0036 }
                r1.<init>((java.lang.String) r5)     // Catch:{ Exception -> 0x0036 }
                goto L_0x0041
            L_0x0036:
                r5 = move-exception
                com.baidu.location.BDLocation r1 = new com.baidu.location.BDLocation     // Catch:{ Exception -> 0x00b9 }
                r1.<init>()     // Catch:{ Exception -> 0x00b9 }
                r5 = 63
                r1.setLocType(r5)     // Catch:{ Exception -> 0x00b9 }
            L_0x0041:
                int r5 = r1.getLocType()     // Catch:{ Exception -> 0x00b9 }
                r2 = 161(0xa1, float:2.26E-43)
                if (r5 != r2) goto L_0x00b5
                com.baidu.location.a.d r5 = com.baidu.location.a.d.this     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.LocationClientOption r5 = r5.q     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r5 = r5.coorType     // Catch:{ Exception -> 0x00b9 }
                r1.setCoorType(r5)     // Catch:{ Exception -> 0x00b9 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b9 }
                r5.<init>()     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.a.d r2 = com.baidu.location.a.d.this     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r2 = r2.f13644a     // Catch:{ Exception -> 0x00b9 }
                java.lang.StringBuilder r5 = r5.append(r2)     // Catch:{ Exception -> 0x00b9 }
                java.lang.StringBuilder r5 = r5.append(r0)     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.a.d r2 = com.baidu.location.a.d.this     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r2 = r2.f13645b     // Catch:{ Exception -> 0x00b9 }
                java.lang.StringBuilder r5 = r5.append(r2)     // Catch:{ Exception -> 0x00b9 }
                java.lang.StringBuilder r5 = r5.append(r0)     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r0 = r1.getTime()     // Catch:{ Exception -> 0x00b9 }
                java.lang.StringBuilder r5 = r5.append(r0)     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r5 = com.baidu.location.Jni.en1(r5)     // Catch:{ Exception -> 0x00b9 }
                r1.setLocationID(r5)     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.Address r5 = r1.getAddress()     // Catch:{ Exception -> 0x00b9 }
                int r5 = com.baidu.location.a.d.b((com.baidu.location.Address) r5)     // Catch:{ Exception -> 0x00b9 }
                r0 = 1
                if (r5 != r0) goto L_0x00a2
                com.baidu.location.a.d r5 = com.baidu.location.a.d.this     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.Address r0 = r1.getAddress()     // Catch:{ Exception -> 0x00b9 }
                r5.a((com.baidu.location.Address) r0)     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.a.d r5 = com.baidu.location.a.d.this     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.a.d$b r5 = r5.r     // Catch:{ Exception -> 0x00b9 }
            L_0x009e:
                r5.onReceiveFixLocation(r1)     // Catch:{ Exception -> 0x00b9 }
                goto L_0x00c0
            L_0x00a2:
                com.baidu.location.Address$Builder r5 = new com.baidu.location.Address$Builder     // Catch:{ Exception -> 0x00b9 }
                r5.<init>()     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.Address r5 = r5.build()     // Catch:{ Exception -> 0x00b9 }
                r1.setAddr(r5)     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.a.d r5 = com.baidu.location.a.d.this     // Catch:{ Exception -> 0x00b9 }
                com.baidu.location.a.d$b r5 = r5.r     // Catch:{ Exception -> 0x00b9 }
                goto L_0x009e
            L_0x00b5:
                r4.b()     // Catch:{ Exception -> 0x00b9 }
                goto L_0x00c0
            L_0x00b9:
                r5 = move-exception
                r5.printStackTrace()
            L_0x00bd:
                r4.b()
            L_0x00c0:
                java.util.Map r5 = r4.k
                if (r5 == 0) goto L_0x00c9
                java.util.Map r5 = r4.k
                r5.clear()
            L_0x00c9:
                r5 = 0
                r4.f13661c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.d.c.a(boolean):void");
        }
    }

    /* renamed from: com.baidu.location.a.d$d  reason: collision with other inner class name */
    protected class C0230d {

        /* renamed from: a  reason: collision with root package name */
        public List<ScanResult> f13662a = null;

        /* renamed from: c  reason: collision with root package name */
        private long f13664c = 0;

        public C0230d(List<ScanResult> list) {
            this.f13662a = list;
            this.f13664c = System.currentTimeMillis();
            d();
        }

        private int b() {
            List<ScanResult> list = this.f13662a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        private String c() {
            WifiInfo connectionInfo = d.this.n.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            try {
                String bssid = connectionInfo.getBSSID();
                String replace = bssid != null ? bssid.replace(":", "") : null;
                if (replace == null || replace.length() == 12) {
                    return new String(replace);
                }
                return null;
            } catch (Exception e2) {
                return null;
            }
        }

        private void d() {
            if (b() >= 1) {
                int size = this.f13662a.size() - 1;
                boolean z = true;
                while (size >= 1 && z) {
                    int i2 = 0;
                    boolean z2 = false;
                    while (i2 < size) {
                        int i3 = i2 + 1;
                        if (this.f13662a.get(i2).level < this.f13662a.get(i3).level) {
                            List<ScanResult> list = this.f13662a;
                            list.set(i3, list.get(i2));
                            this.f13662a.set(i2, this.f13662a.get(i3));
                            z2 = true;
                        }
                        i2 = i3;
                    }
                    size--;
                    z = z2;
                }
            }
        }

        public int a() {
            List<ScanResult> list = this.f13662a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String a(int i2) {
            if (a() < 2) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.f13662a.size();
            String c2 = c();
            boolean z = true;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if (this.f13662a.get(i6).level != 0) {
                    i3++;
                    if (z) {
                        stringBuffer.append("&wf=");
                        z = false;
                    } else {
                        stringBuffer.append("|");
                    }
                    String replace = this.f13662a.get(i6).BSSID.replace(":", "");
                    stringBuffer.append(replace);
                    if (c2 != null && replace.equals(c2)) {
                        i5 = i3;
                    }
                    int i7 = this.f13662a.get(i6).level;
                    if (i7 < 0) {
                        i7 = -i7;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(i7)}));
                    i4++;
                    if (i4 > i2) {
                        break;
                    }
                }
            }
            if (i5 > 0) {
                stringBuffer.append("&wf_n=");
                stringBuffer.append(i5);
            }
            if (z) {
                return null;
            }
            return stringBuffer.toString();
        }
    }

    public d(Context context, LocationClientOption locationClientOption, b bVar) {
        StringBuilder sb;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        this.f13648e = applicationContext;
        try {
            h.ay = applicationContext.getPackageName();
        } catch (Exception e2) {
        }
        this.q = locationClientOption;
        this.r = bVar;
        this.f13644a = this.f13648e.getPackageName();
        this.f13645b = null;
        try {
            this.f13649f = (TelephonyManager) this.f13648e.getSystemService("phone");
            this.n = (WifiManager) this.f13648e.getApplicationContext().getSystemService("wifi");
        } catch (Exception e3) {
            this.n = null;
            this.f13649f = null;
        }
        if (this.f13645b != null) {
            sb = new StringBuilder().append("&prod=").append(this.q.prodName).append(":").append(this.f13644a).append("|&cu=");
            str = this.f13645b;
        } else {
            sb = new StringBuilder().append("&prod=").append(this.q.prodName).append(":").append(this.f13644a).append("|&im=");
        }
        this.p = sb.append(str).append("&coor=").append(locationClientOption.getCoorType()).toString();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("8.053");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(e.a().b());
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        this.p += "&addr=allj";
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.p += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.p += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.p += "aptagd|";
            }
        }
        stringBuffer.append("&first=2");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK_INT);
        this.p += stringBuffer.toString();
    }

    private String a(int i2) {
        String str;
        String str2;
        if (i2 < 3) {
            i2 = 3;
        }
        try {
            a(this.f13649f.getCellLocation());
            str = this.f13650g.a();
        } catch (Throwable th2) {
            str = null;
        }
        try {
            this.o = null;
            C0230d dVar = new C0230d(this.n.getScanResults());
            this.o = dVar;
            str2 = dVar.a(i2);
        } catch (Exception e2) {
            str2 = null;
        }
        if (str == null && str2 == null) {
            this.s = null;
            return null;
        }
        if (str2 != null) {
            str = str + str2;
        }
        if (str == null) {
            return null;
        }
        this.s = str;
        if (this.p != null) {
            this.s += this.p;
        }
        return str + this.p;
    }

    private void a(CellLocation cellLocation) {
        if (cellLocation != null && this.f13649f != null) {
            a aVar = new a();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                aVar.f13651a = gsmCellLocation.getLac();
                aVar.f13652b = gsmCellLocation.getCid();
                aVar.f13657g = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                aVar.f13657g = 'c';
                if (m == null) {
                    try {
                        Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        m = cls;
                        f13641h = cls.getMethod("getBaseStationId", new Class[0]);
                        f13642i = m.getMethod("getNetworkId", new Class[0]);
                        f13643j = m.getMethod("getSystemId", new Class[0]);
                        k = m.getMethod("getBaseStationLatitude", new Class[0]);
                        l = m.getMethod("getBaseStationLongitude", new Class[0]);
                    } catch (Exception e2) {
                        m = null;
                        return;
                    }
                }
                Class<?> cls2 = m;
                if (cls2 != null && cls2.isInstance(cellLocation)) {
                    try {
                        int intValue = ((Integer) f13643j.invoke(cellLocation, new Object[0])).intValue();
                        if (intValue < 0) {
                            intValue = this.f13650g.f13654d;
                        }
                        aVar.f13654d = intValue;
                        aVar.f13652b = ((Integer) f13641h.invoke(cellLocation, new Object[0])).intValue();
                        aVar.f13651a = ((Integer) f13642i.invoke(cellLocation, new Object[0])).intValue();
                        Object invoke = k.invoke(cellLocation, new Object[0]);
                        if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                            aVar.f13655e = ((Integer) invoke).intValue();
                        }
                        Object invoke2 = l.invoke(cellLocation, new Object[0]);
                        if (((Integer) invoke2).intValue() < Integer.MAX_VALUE) {
                            aVar.f13656f = ((Integer) invoke2).intValue();
                        }
                    } catch (Exception e3) {
                        return;
                    }
                }
            }
            if (aVar.b()) {
                this.f13650g = aVar;
            } else {
                this.f13650g = null;
            }
        }
    }

    public static synchronized int b(Address address) {
        int i2;
        synchronized (d.class) {
            int i3 = 0;
            String str = null;
            if (address != null) {
                try {
                    str = address.cityCode;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            i2 = 2;
            if (address != null && !TextUtils.isEmpty(str)) {
                Integer.parseInt(str);
                i3 = 1;
            }
            if (address == null || i3 != 1 || address.countryCode == null || !address.countryCode.equals("0") || address.country == null || address.country.equals("中国")) {
                i2 = i3;
            } else {
                Log.w(com.baidu.location.e.a.f13907a, "FixAddrManager addr country is wrong");
            }
        }
        return i2;
    }

    private String b() {
        try {
            return a(15);
        } catch (Exception e2) {
            return null;
        }
    }

    private void c() {
        b();
        String str = this.s;
        if (str != null) {
            this.f13646c.a(str);
        }
    }

    public Address a() {
        Address address = this.f13647d;
        if (address == null) {
            address = new Address.Builder().build();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.t;
        if (currentTimeMillis > 300000 || currentTimeMillis < -10000) {
            this.t = System.currentTimeMillis();
            c();
        }
        return address;
    }

    public void a(Address address) {
        if (b(address) == 1) {
            this.f13647d = new Address.Builder().country(address.country).countryCode(address.countryCode).province(address.province).city(address.city).cityCode(address.cityCode).district(address.district).street(address.street).adcode(address.adcode).streetNumber(address.streetNumber).build();
            this.t = System.currentTimeMillis();
        }
    }
}
