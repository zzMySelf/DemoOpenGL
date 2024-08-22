package a.a.a.a.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.provider.BDCellInfo;
import com.baidu.location.provider.KeyEventListener;
import com.baidu.location.provider.NetworkDataProvider;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a implements a.a.a.a.c.a {
    public static Class<?> F;
    public static int G;
    public boolean A = false;
    public Handler B = null;
    public int C = -1;
    public int D = -1;
    public final Object E = new Object();

    /* renamed from: c  reason: collision with root package name */
    public int f1175c = 30;

    /* renamed from: d  reason: collision with root package name */
    public int f1176d = 100;

    /* renamed from: e  reason: collision with root package name */
    public float f1177e = 0.2f;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1178f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1179g = false;

    /* renamed from: h  reason: collision with root package name */
    public TelephonyManager f1180h = null;

    /* renamed from: i  reason: collision with root package name */
    public TelephonyManager f1181i = null;

    /* renamed from: j  reason: collision with root package name */
    public TelephonyManager f1182j = null;
    public SubscriptionManager k = null;
    public BDCellInfo l = new BDCellInfo();
    public BDCellInfo m = null;
    public List<BDCellInfo> n = null;
    public e o = null;
    public d p;
    public b q;
    public c r;
    public Context s;
    public boolean t = false;
    public int u = 0;
    public boolean v = false;
    public long w = 0;
    public long x = 0;
    public boolean y = false;
    public boolean z = true;

    /* renamed from: a.a.a.a.b.a$a  reason: collision with other inner class name */
    public class C0001a implements Runnable {
        public C0001a() {
        }

        public void run() {
            try {
                a.this.h();
                synchronized (a.this.E) {
                    a.this.E.notifyAll();
                    if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                        NetworkDataProvider.getListener().setLog("update mCellInfo completed");
                    }
                }
            } catch (Exception e2) {
                if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                    NetworkDataProvider.getListener().setLog("handleCellInfo error = " + e2);
                }
            }
        }
    }

    public class b extends TelephonyManager.CellInfoCallback {
        public b() {
        }

        public /* synthetic */ b(a aVar, C0001a aVar2) {
            this();
        }

        public void onCellInfo(List<CellInfo> list) {
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog("onCellInfo");
            }
            if (list != null) {
                if (!a.a.a.a.c.a.f1202b || NetworkDataProvider.getListener().onCellInfo(list)) {
                    if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                        NetworkDataProvider.getListener().setLog("request sim1 cellInfo");
                    }
                    if (a.this.y) {
                        a aVar = a.this;
                        boolean unused = aVar.z = !aVar.z;
                    }
                    if (!a.this.y || a.this.z) {
                        a.this.b();
                    }
                }
            }
        }
    }

    public class c extends TelephonyManager.CellInfoCallback {
        public c() {
        }

        public /* synthetic */ c(a aVar, C0001a aVar2) {
            this();
        }

        public void onCellInfo(List<CellInfo> list) {
            if (list != null) {
                if (!a.a.a.a.c.a.f1202b || NetworkDataProvider.getListener().onCellInfo(list)) {
                    if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                        NetworkDataProvider.getListener().setLog("request sim2 cellInfo");
                    }
                    if (a.this.y) {
                        a aVar = a.this;
                        boolean unused = aVar.z = !aVar.z;
                    }
                    if (!a.this.y || a.this.z) {
                        a.this.b();
                    }
                }
            }
        }
    }

    public class d extends TelephonyManager.CellInfoCallback {
        public d() {
        }

        public /* synthetic */ d(a aVar, C0001a aVar2) {
            this();
        }

        public void onCellInfo(List<CellInfo> list) {
            if (list != null) {
                if (!a.a.a.a.c.a.f1202b || NetworkDataProvider.getListener().onCellInfo(list)) {
                    a.this.b();
                }
            }
        }

        public void onError(int i2, Throwable th2) {
            if (th2 != null) {
                th2.printStackTrace();
            }
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog("cell onError = " + i2);
            }
        }
    }

    public class e extends PhoneStateListener {

        /* renamed from: a.a.a.a.b.a$e$a  reason: collision with other inner class name */
        public class C0002a implements Runnable {
            public C0002a() {
            }

            public void run() {
                try {
                    if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                        NetworkDataProvider.getListener().setLog("cell received cellinfo change");
                    }
                    a.this.h();
                } catch (Exception e2) {
                    if (a.a.a.a.c.a.f1201a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public e() {
        }

        public void onCellInfoChanged(List<CellInfo> list) {
            if (list != null) {
                a.this.B.post(new C0002a());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSignalStrengthsChanged(android.telephony.SignalStrength r3) {
            /*
                r2 = this;
                a.a.a.a.b.a r0 = a.a.a.a.b.a.this
                com.baidu.location.provider.BDCellInfo r0 = r0.l
                if (r0 == 0) goto L_0x0062
                a.a.a.a.b.a r0 = a.a.a.a.b.a.this
                com.baidu.location.provider.BDCellInfo r0 = r0.l
                char r0 = r0.mNetworkType
                r1 = 103(0x67, float:1.44E-43)
                if (r0 != r1) goto L_0x0021
                a.a.a.a.b.a r0 = a.a.a.a.b.a.this
                com.baidu.location.provider.BDCellInfo r0 = r0.l
                int r3 = r3.getGsmSignalStrength()
            L_0x001e:
                r0.mStrength = r3
                goto L_0x0038
            L_0x0021:
                a.a.a.a.b.a r0 = a.a.a.a.b.a.this
                com.baidu.location.provider.BDCellInfo r0 = r0.l
                char r0 = r0.mNetworkType
                r1 = 99
                if (r0 != r1) goto L_0x0038
                a.a.a.a.b.a r0 = a.a.a.a.b.a.this
                com.baidu.location.provider.BDCellInfo r0 = r0.l
                int r3 = r3.getCdmaDbm()
                goto L_0x001e
            L_0x0038:
                boolean r3 = a.a.a.a.c.a.f1201a
                if (r3 == 0) goto L_0x0062
                boolean r3 = a.a.a.a.c.a.f1202b
                if (r3 == 0) goto L_0x0062
                com.baidu.location.provider.KeyEventListener r3 = com.baidu.location.provider.NetworkDataProvider.getListener()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "cell strength===== cell singal strength changed : "
                java.lang.StringBuilder r0 = r0.append(r1)
                a.a.a.a.b.a r1 = a.a.a.a.b.a.this
                com.baidu.location.provider.BDCellInfo r1 = r1.l
                int r1 = r1.mStrength
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                r3.setLog(r0)
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.e.onSignalStrengthsChanged(android.telephony.SignalStrength):void");
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public static a f1189a = new a();
    }

    public static int a(CellIdentityNr cellIdentityNr) {
        try {
            int a2 = a.a.a.a.c.c.a(cellIdentityNr, "getHwTac");
            if (!a.a.a.a.c.a.f1201a || !a.a.a.a.c.a.f1202b) {
                return a2;
            }
            NetworkDataProvider.getListener().setLog(" get hw tac = " + a2);
            return a2;
        } catch (Throwable th2) {
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog(" get hw tac exception !" + th2);
            }
            return -1;
        }
    }

    public static int b(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(" ", ""));
        while (true) {
            int i2 = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    String group = matcher.group(1);
                    if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                        NetworkDataProvider.getListener().setLog(" pasrse mnrtac = " + group);
                    }
                    try {
                        i2 = Integer.parseInt(group);
                    } catch (Throwable th2) {
                        if (a.a.a.a.c.a.f1201a) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
            return i2;
        }
    }

    public static int d(int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2;
    }

    public static a j() {
        return f.f1189a;
    }

    public final int a(String str) {
        if (str != null && str.contains("cl_s2")) {
            try {
                Matcher matcher = Pattern.compile("cl_s2=[0-9]{1,}").matcher(str);
                if (matcher.find()) {
                    String group = matcher.group();
                    return Integer.parseInt(group.substring(group.indexOf("cl_s2=") + 6, group.length()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public BDCellInfo a(int i2) {
        BDCellInfo bDCellInfo;
        KeyEventListener listener;
        String str;
        if (this.f1180h != null) {
            try {
                h();
                if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                    NetworkDataProvider.getListener().setLog(" lastDiffTime = " + this.x + ", diffTime = " + i2);
                }
                if (Build.VERSION.SDK_INT >= 29 && this.v) {
                    if (i2 < Integer.MAX_VALUE) {
                        long j2 = (long) i2;
                        if (j2 != this.x) {
                            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                                listener = NetworkDataProvider.getListener();
                                str = "diff time is changed";
                            }
                            f();
                        } else if (System.currentTimeMillis() - this.w > j2) {
                            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                                listener = NetworkDataProvider.getListener();
                                str = " over diff time";
                            }
                            f();
                        }
                        listener.setLog(str);
                        f();
                    }
                    this.x = (long) i2;
                }
            } catch (Exception e2) {
                if (a.a.a.a.c.a.f1201a) {
                    e2.printStackTrace();
                }
            }
        }
        BDCellInfo bDCellInfo2 = this.l;
        if (bDCellInfo2 != null && bDCellInfo2.isTrueValid()) {
            this.m = null;
            this.m = new BDCellInfo(this.l);
        }
        BDCellInfo bDCellInfo3 = this.l;
        if (!(bDCellInfo3 == null || !bDCellInfo3.isNotTrueValid2() || (bDCellInfo = this.m) == null)) {
            BDCellInfo bDCellInfo4 = this.l;
            if (bDCellInfo4.mNetworkType == 'g') {
                bDCellInfo4.mMnc = bDCellInfo.mMnc;
                bDCellInfo4.mMcc = bDCellInfo.mMcc;
            }
        }
        return this.l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0077, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0164, code lost:
        if (r0 >= 0) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01dd, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0247, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L_0x0249;
     */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0494 A[SYNTHETIC, Splitter:B:194:0x0494] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0522 A[Catch:{ Error -> 0x05b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f3 A[Catch:{ Exception -> 0x0485 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x024f A[Catch:{ Exception -> 0x0485 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.location.provider.BDCellInfo a(android.telephony.CellInfo r19, com.baidu.location.provider.BDCellInfo r20, android.telephony.TelephonyManager r21) {
        /*
            r18 = this;
            r1 = r19
            r0 = r20
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r2 = r2.intValue()
            r3 = 0
            r4 = 17
            if (r2 >= r4) goto L_0x0014
            return r3
        L_0x0014:
            com.baidu.location.provider.BDCellInfo r4 = new com.baidu.location.provider.BDCellInfo
            r4.<init>()
            boolean r5 = r1 instanceof android.telephony.CellInfoGsm
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 3
            r10 = -1
            r11 = 103(0x67, float:1.44E-43)
            r12 = 28
            if (r5 == 0) goto L_0x007b
            r0 = r1
            android.telephony.CellInfoGsm r0 = (android.telephony.CellInfoGsm) r0
            android.telephony.CellIdentityGsm r5 = r0.getCellIdentity()
            boolean r13 = a.a.a.a.c.a.f1201a
            if (r13 == 0) goto L_0x003e
            boolean r13 = a.a.a.a.c.a.f1202b
            if (r13 == 0) goto L_0x003e
            com.baidu.location.provider.KeyEventListener r13 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.String r14 = "CellInfoGsm"
            r13.setLog(r14)
        L_0x003e:
            int r13 = r5.getMcc()
            int r13 = d((int) r13)
            r4.mMcc = r13
            int r13 = r5.getMnc()
            int r13 = d((int) r13)
            r4.mMnc = r13
            int r13 = r5.getLac()
            int r13 = d((int) r13)
            r4.mLac = r13
            int r5 = r5.getCid()
            int r5 = d((int) r5)
            long r13 = (long) r5
            r4.mCid = r13
            r4.mNetworkType = r11
            android.telephony.CellSignalStrengthGsm r0 = r0.getCellSignalStrength()
            int r0 = r0.getAsuLevel()
            r4.mStrength = r0
            r4.cellType = r6
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r12) goto L_0x01e5
            goto L_0x01df
        L_0x007b:
            boolean r5 = r1 instanceof android.telephony.CellInfoCdma
            if (r5 == 0) goto L_0x0188
            r5 = r1
            android.telephony.CellInfoCdma r5 = (android.telephony.CellInfoCdma) r5
            android.telephony.CellIdentityCdma r13 = r5.getCellIdentity()
            boolean r14 = a.a.a.a.c.a.f1201a
            if (r14 == 0) goto L_0x00d3
            boolean r14 = a.a.a.a.c.a.f1202b
            if (r14 == 0) goto L_0x00d3
            com.baidu.location.provider.KeyEventListener r14 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.String r15 = "CellInfoCdma"
            r14.setLog(r15)
            com.baidu.location.provider.KeyEventListener r14 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r3 = "lat = "
            java.lang.StringBuilder r3 = r15.append(r3)
            int r15 = r13.getLatitude()
            java.lang.StringBuilder r3 = r3.append(r15)
            java.lang.String r3 = r3.toString()
            r14.setLog(r3)
            com.baidu.location.provider.KeyEventListener r3 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "lon = "
            java.lang.StringBuilder r14 = r14.append(r15)
            int r15 = r13.getLongitude()
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            r3.setLog(r14)
        L_0x00d3:
            int r3 = r13.getLatitude()
            r4.mBSLat = r3
            int r3 = r13.getLongitude()
            r4.mBSLon = r3
            int r3 = r13.getSystemId()
            int r3 = d((int) r3)
            r4.mMnc = r3
            int r3 = r13.getNetworkId()
            int r3 = d((int) r3)
            r4.mLac = r3
            int r3 = r13.getBasestationId()
            int r3 = d((int) r3)
            long r13 = (long) r3
            r4.mCid = r13
            r3 = 99
            r4.mNetworkType = r3
            android.telephony.CellSignalStrengthCdma r3 = r5.getCellSignalStrength()
            int r3 = r3.getCdmaDbm()
            r4.mStrength = r3
            r4.cellType = r7
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r12) goto L_0x0118
            int r3 = r19.getCellConnectionStatus()
            r4.mConnectionStatus = r3
        L_0x0118:
            if (r0 == 0) goto L_0x0146
            int r0 = r0.mMcc
            if (r0 <= 0) goto L_0x0146
            r4.mMcc = r0
            boolean r0 = a.a.a.a.c.a.f1201a
            if (r0 == 0) goto L_0x01e5
            boolean r0 = a.a.a.a.c.a.f1202b
            if (r0 == 0) goto L_0x01e5
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "cdma set old cellinfo mcc = "
        L_0x0133:
            java.lang.StringBuilder r3 = r3.append(r5)
            int r5 = r4.mMcc
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r3 = r3.toString()
            r0.setLog(r3)
            goto L_0x01e5
        L_0x0146:
            java.lang.String r0 = r21.getNetworkOperator()     // Catch:{ Exception -> 0x0167 }
            if (r0 == 0) goto L_0x016f
            int r3 = r0.length()     // Catch:{ Exception -> 0x0167 }
            if (r3 <= 0) goto L_0x016f
            int r3 = r0.length()     // Catch:{ Exception -> 0x0167 }
            if (r3 < r9) goto L_0x016f
            java.lang.String r0 = r0.substring(r8, r9)     // Catch:{ Exception -> 0x0167 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0167 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0167 }
            if (r0 >= 0) goto L_0x0170
            goto L_0x016f
        L_0x0167:
            r0 = move-exception
            boolean r3 = a.a.a.a.c.a.f1201a
            if (r3 == 0) goto L_0x016f
            r0.printStackTrace()
        L_0x016f:
            r0 = r10
        L_0x0170:
            if (r0 <= 0) goto L_0x01e5
            r4.mMcc = r0
            boolean r0 = a.a.a.a.c.a.f1201a
            if (r0 == 0) goto L_0x01e5
            boolean r0 = a.a.a.a.c.a.f1202b
            if (r0 == 0) goto L_0x01e5
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "cdma set old mcc = "
            goto L_0x0133
        L_0x0188:
            boolean r0 = r1 instanceof android.telephony.CellInfoLte
            if (r0 == 0) goto L_0x01e7
            r0 = r1
            android.telephony.CellInfoLte r0 = (android.telephony.CellInfoLte) r0
            android.telephony.CellIdentityLte r3 = r0.getCellIdentity()
            boolean r5 = a.a.a.a.c.a.f1201a
            if (r5 == 0) goto L_0x01a4
            boolean r5 = a.a.a.a.c.a.f1202b
            if (r5 == 0) goto L_0x01a4
            com.baidu.location.provider.KeyEventListener r5 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.String r13 = "CellInfoLte"
            r5.setLog(r13)
        L_0x01a4:
            int r5 = r3.getMcc()
            int r5 = d((int) r5)
            r4.mMcc = r5
            int r5 = r3.getMnc()
            int r5 = d((int) r5)
            r4.mMnc = r5
            int r5 = r3.getTac()
            int r5 = d((int) r5)
            r4.mLac = r5
            int r3 = r3.getCi()
            int r3 = d((int) r3)
            long r13 = (long) r3
            r4.mCid = r13
            r4.mNetworkType = r11
            android.telephony.CellSignalStrengthLte r0 = r0.getCellSignalStrength()
            int r0 = r0.getAsuLevel()
            r4.mStrength = r0
            r4.cellType = r9
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r12) goto L_0x01e5
        L_0x01df:
            int r0 = r19.getCellConnectionStatus()
            r4.mConnectionStatus = r0
        L_0x01e5:
            r0 = r7
            goto L_0x01e8
        L_0x01e7:
            r0 = r8
        L_0x01e8:
            r3 = 18
            if (r2 < r3) goto L_0x048d
            if (r0 != 0) goto L_0x048d
            boolean r0 = r1 instanceof android.telephony.CellInfoWcdma     // Catch:{ Exception -> 0x0485 }
            r3 = 4
            if (r0 == 0) goto L_0x024f
            r0 = r1
            android.telephony.CellInfoWcdma r0 = (android.telephony.CellInfoWcdma) r0     // Catch:{ Exception -> 0x0485 }
            android.telephony.CellIdentityWcdma r0 = r0.getCellIdentity()     // Catch:{ Exception -> 0x0485 }
            boolean r5 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r5 == 0) goto L_0x020b
            boolean r5 = a.a.a.a.c.a.f1202b     // Catch:{ Exception -> 0x0485 }
            if (r5 == 0) goto L_0x020b
            com.baidu.location.provider.KeyEventListener r5 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Exception -> 0x0485 }
            java.lang.String r6 = "CellInfoWcdma"
            r5.setLog(r6)     // Catch:{ Exception -> 0x0485 }
        L_0x020b:
            int r5 = r0.getMcc()     // Catch:{ Exception -> 0x0485 }
            int r5 = d((int) r5)     // Catch:{ Exception -> 0x0485 }
            r4.mMcc = r5     // Catch:{ Exception -> 0x0485 }
            int r5 = r0.getMnc()     // Catch:{ Exception -> 0x0485 }
            int r5 = d((int) r5)     // Catch:{ Exception -> 0x0485 }
            r4.mMnc = r5     // Catch:{ Exception -> 0x0485 }
            int r5 = r0.getLac()     // Catch:{ Exception -> 0x0485 }
            int r5 = d((int) r5)     // Catch:{ Exception -> 0x0485 }
            r4.mLac = r5     // Catch:{ Exception -> 0x0485 }
            int r0 = r0.getCid()     // Catch:{ Exception -> 0x0485 }
            int r0 = d((int) r0)     // Catch:{ Exception -> 0x0485 }
            long r5 = (long) r0     // Catch:{ Exception -> 0x0485 }
            r4.mCid = r5     // Catch:{ Exception -> 0x0485 }
            r4.mNetworkType = r11     // Catch:{ Exception -> 0x0485 }
            r0 = r1
            android.telephony.CellInfoWcdma r0 = (android.telephony.CellInfoWcdma) r0     // Catch:{ Exception -> 0x0485 }
            android.telephony.CellSignalStrengthWcdma r0 = r0.getCellSignalStrength()     // Catch:{ Exception -> 0x0485 }
            int r0 = r0.getAsuLevel()     // Catch:{ Exception -> 0x0485 }
            r4.mStrength = r0     // Catch:{ Exception -> 0x0485 }
            r4.cellType = r3     // Catch:{ Exception -> 0x0485 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0485 }
            if (r0 < r12) goto L_0x048d
        L_0x0249:
            int r0 = r19.getCellConnectionStatus()     // Catch:{ Exception -> 0x0485 }
            goto L_0x02d8
        L_0x024f:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0485 }
            r5 = 29
            if (r0 < r5) goto L_0x048d
            boolean r0 = r1 instanceof android.telephony.CellInfoTdscdma     // Catch:{ Exception -> 0x0485 }
            r5 = 5
            if (r0 == 0) goto L_0x02dc
            r0 = r1
            android.telephony.CellInfoTdscdma r0 = (android.telephony.CellInfoTdscdma) r0     // Catch:{ Exception -> 0x0485 }
            android.telephony.CellIdentityTdscdma r3 = r0.getCellIdentity()     // Catch:{ Exception -> 0x0485 }
            boolean r0 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x0272
            boolean r0 = a.a.a.a.c.a.f1202b     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x0272
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Exception -> 0x0485 }
            java.lang.String r6 = "CellInfoTdscdma"
            r0.setLog(r6)     // Catch:{ Exception -> 0x0485 }
        L_0x0272:
            java.lang.String r0 = r3.getMccString()     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x028f
            java.lang.String r0 = r3.getMccString()     // Catch:{ all -> 0x0287 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0287 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0287 }
            r4.mMcc = r0     // Catch:{ all -> 0x0287 }
            goto L_0x028f
        L_0x0287:
            r0 = move-exception
            boolean r6 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r6 == 0) goto L_0x028f
            r0.printStackTrace()     // Catch:{ Exception -> 0x0485 }
        L_0x028f:
            java.lang.String r0 = r3.getMncString()     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x02ac
            java.lang.String r0 = r3.getMncString()     // Catch:{ all -> 0x02a4 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x02a4 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x02a4 }
            r4.mMnc = r0     // Catch:{ all -> 0x02a4 }
            goto L_0x02ac
        L_0x02a4:
            r0 = move-exception
            boolean r6 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r6 == 0) goto L_0x02ac
            r0.printStackTrace()     // Catch:{ Exception -> 0x0485 }
        L_0x02ac:
            int r0 = r3.getLac()     // Catch:{ Exception -> 0x0485 }
            int r0 = d((int) r0)     // Catch:{ Exception -> 0x0485 }
            r4.mLac = r0     // Catch:{ Exception -> 0x0485 }
            int r0 = r3.getCid()     // Catch:{ Exception -> 0x0485 }
            int r0 = d((int) r0)     // Catch:{ Exception -> 0x0485 }
            long r6 = (long) r0     // Catch:{ Exception -> 0x0485 }
            r4.mCid = r6     // Catch:{ Exception -> 0x0485 }
            r4.mNetworkType = r11     // Catch:{ Exception -> 0x0485 }
            r0 = r1
            android.telephony.CellInfoTdscdma r0 = (android.telephony.CellInfoTdscdma) r0     // Catch:{ Exception -> 0x0485 }
            android.telephony.CellSignalStrengthTdscdma r0 = r0.getCellSignalStrength()     // Catch:{ Exception -> 0x0485 }
            int r0 = r0.getAsuLevel()     // Catch:{ Exception -> 0x0485 }
            r4.mStrength = r0     // Catch:{ Exception -> 0x0485 }
            r4.cellType = r5     // Catch:{ Exception -> 0x0485 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0485 }
            if (r0 < r12) goto L_0x048d
            goto L_0x0249
        L_0x02d8:
            r4.mConnectionStatus = r0     // Catch:{ Exception -> 0x0485 }
            goto L_0x048d
        L_0x02dc:
            boolean r0 = r1 instanceof android.telephony.CellInfoNr     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x048d
            r0 = r1
            android.telephony.CellInfoNr r0 = (android.telephony.CellInfoNr) r0     // Catch:{ all -> 0x0311 }
            android.telephony.CellIdentity r0 = r0.getCellIdentity()     // Catch:{ all -> 0x0311 }
            android.telephony.CellIdentityNr r0 = (android.telephony.CellIdentityNr) r0     // Catch:{ all -> 0x0311 }
            boolean r13 = a.a.a.a.c.a.f1201a     // Catch:{ all -> 0x0311 }
            if (r13 == 0) goto L_0x030f
            boolean r13 = a.a.a.a.c.a.f1202b     // Catch:{ all -> 0x0311 }
            if (r13 == 0) goto L_0x030f
            com.baidu.location.provider.KeyEventListener r13 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ all -> 0x0311 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0311 }
            r14.<init>()     // Catch:{ all -> 0x0311 }
            java.lang.String r15 = " get cell nr = "
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x0311 }
            java.lang.String r15 = r0.toString()     // Catch:{ all -> 0x0311 }
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x0311 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0311 }
            r13.setLog(r14)     // Catch:{ all -> 0x0311 }
        L_0x030f:
            r13 = r0
            goto L_0x0316
        L_0x0311:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0485 }
            r13 = 0
        L_0x0316:
            boolean r0 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x0327
            boolean r0 = a.a.a.a.c.a.f1202b     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x0327
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Exception -> 0x0485 }
            java.lang.String r14 = "CellInfoNr"
            r0.setLog(r14)     // Catch:{ Exception -> 0x0485 }
        L_0x0327:
            if (r13 == 0) goto L_0x048d
            java.lang.String r0 = r13.getMccString()     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x0346
            java.lang.String r0 = r13.getMccString()     // Catch:{ all -> 0x033e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x033e }
            int r0 = r0.intValue()     // Catch:{ all -> 0x033e }
            r4.mMcc = r0     // Catch:{ all -> 0x033e }
            goto L_0x0346
        L_0x033e:
            r0 = move-exception
            boolean r14 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r14 == 0) goto L_0x0346
            r0.printStackTrace()     // Catch:{ Exception -> 0x0485 }
        L_0x0346:
            java.lang.String r0 = r13.getMncString()     // Catch:{ Exception -> 0x0485 }
            if (r0 == 0) goto L_0x0363
            java.lang.String r0 = r13.getMncString()     // Catch:{ all -> 0x035b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x035b }
            int r0 = r0.intValue()     // Catch:{ all -> 0x035b }
            r4.mMnc = r0     // Catch:{ all -> 0x035b }
            goto L_0x0363
        L_0x035b:
            r0 = move-exception
            boolean r14 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r14 == 0) goto L_0x0363
            r0.printStackTrace()     // Catch:{ Exception -> 0x0485 }
        L_0x0363:
            int r0 = r13.getTac()     // Catch:{ Exception -> 0x0485 }
            int r0 = d((int) r0)     // Catch:{ Exception -> 0x0485 }
            r4.mLac = r0     // Catch:{ Exception -> 0x0485 }
            int r0 = r4.mLac     // Catch:{ Exception -> 0x0485 }
            if (r0 != r10) goto L_0x03a6
            int r0 = a((android.telephony.CellIdentityNr) r13)     // Catch:{ all -> 0x039e }
            boolean r14 = a.a.a.a.c.a.f1201a     // Catch:{ all -> 0x039e }
            if (r14 == 0) goto L_0x0397
            boolean r14 = a.a.a.a.c.a.f1202b     // Catch:{ all -> 0x039e }
            if (r14 == 0) goto L_0x0397
            com.baidu.location.provider.KeyEventListener r14 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ all -> 0x039e }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x039e }
            r15.<init>()     // Catch:{ all -> 0x039e }
            java.lang.String r5 = " get nrtac for huawei = "
            java.lang.StringBuilder r5 = r15.append(r5)     // Catch:{ all -> 0x039e }
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch:{ all -> 0x039e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x039e }
            r14.setLog(r5)     // Catch:{ all -> 0x039e }
        L_0x0397:
            int r0 = d((int) r0)     // Catch:{ all -> 0x039e }
            r4.mLac = r0     // Catch:{ all -> 0x039e }
            goto L_0x03a6
        L_0x039e:
            r0 = move-exception
            boolean r5 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r5 == 0) goto L_0x03a6
            r0.printStackTrace()     // Catch:{ Exception -> 0x0485 }
        L_0x03a6:
            int r0 = r4.mLac     // Catch:{ Exception -> 0x0485 }
            if (r0 != r10) goto L_0x03e3
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x03db }
            int r0 = b((java.lang.String) r0)     // Catch:{ all -> 0x03db }
            boolean r5 = a.a.a.a.c.a.f1201a     // Catch:{ all -> 0x03db }
            if (r5 == 0) goto L_0x03d4
            boolean r5 = a.a.a.a.c.a.f1202b     // Catch:{ all -> 0x03db }
            if (r5 == 0) goto L_0x03d4
            com.baidu.location.provider.KeyEventListener r5 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ all -> 0x03db }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03db }
            r14.<init>()     // Catch:{ all -> 0x03db }
            java.lang.String r15 = " get nrtac for samsung = "
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x03db }
            java.lang.StringBuilder r14 = r14.append(r0)     // Catch:{ all -> 0x03db }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x03db }
            r5.setLog(r14)     // Catch:{ all -> 0x03db }
        L_0x03d4:
            int r0 = d((int) r0)     // Catch:{ all -> 0x03db }
            r4.mLac = r0     // Catch:{ all -> 0x03db }
            goto L_0x03e3
        L_0x03db:
            r0 = move-exception
            boolean r5 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x0485 }
            if (r5 == 0) goto L_0x03e3
            r0.printStackTrace()     // Catch:{ Exception -> 0x0485 }
        L_0x03e3:
            int r0 = r4.mLac     // Catch:{ Exception -> 0x0485 }
            if (r0 != r10) goto L_0x03ed
            int r0 = r13.getTac()     // Catch:{ Exception -> 0x0485 }
            r4.mLac = r0     // Catch:{ Exception -> 0x0485 }
        L_0x03ed:
            long r14 = r13.getNci()     // Catch:{ Exception -> 0x0485 }
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0400
            long r13 = r13.getNci()     // Catch:{ Exception -> 0x0485 }
            r4.mCid = r13     // Catch:{ Exception -> 0x0485 }
        L_0x0400:
            r4.mNetworkType = r11     // Catch:{ Exception -> 0x0485 }
            r0 = 6
            r4.cellType = r0     // Catch:{ Exception -> 0x0485 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0485 }
            if (r5 < r12) goto L_0x040f
            int r5 = r19.getCellConnectionStatus()     // Catch:{ Exception -> 0x0485 }
            r4.mConnectionStatus = r5     // Catch:{ Exception -> 0x0485 }
        L_0x040f:
            r5 = r1
            android.telephony.CellInfoNr r5 = (android.telephony.CellInfoNr) r5     // Catch:{ Exception -> 0x0485 }
            android.telephony.CellSignalStrength r5 = r5.getCellSignalStrength()     // Catch:{ Exception -> 0x0485 }
            android.telephony.CellSignalStrengthNr r5 = (android.telephony.CellSignalStrengthNr) r5     // Catch:{ Exception -> 0x0485 }
            int r10 = r5.getAsuLevel()     // Catch:{ Exception -> 0x0485 }
            r4.mStrength = r10     // Catch:{ Exception -> 0x0485 }
            boolean r10 = r4.isValid()     // Catch:{ Exception -> 0x0485 }
            if (r10 == 0) goto L_0x048d
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ Exception -> 0x0485 }
            java.lang.String r11 = "%d|%d|%d|%d|%d|%d|%d|%d"
            r12 = 8
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x0485 }
            int r13 = r5.getCsiRsrp()     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0485 }
            r12[r8] = r13     // Catch:{ Exception -> 0x0485 }
            int r8 = r5.getCsiRsrq()     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0485 }
            r12[r7] = r8     // Catch:{ Exception -> 0x0485 }
            int r7 = r5.getCsiSinr()     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0485 }
            r12[r6] = r7     // Catch:{ Exception -> 0x0485 }
            int r6 = r5.getDbm()     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0485 }
            r12[r9] = r6     // Catch:{ Exception -> 0x0485 }
            int r6 = r5.getLevel()     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0485 }
            r12[r3] = r6     // Catch:{ Exception -> 0x0485 }
            int r3 = r5.getSsRsrp()     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0485 }
            r6 = 5
            r12[r6] = r3     // Catch:{ Exception -> 0x0485 }
            int r3 = r5.getSsRsrq()     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0485 }
            r12[r0] = r3     // Catch:{ Exception -> 0x0485 }
            r0 = 7
            int r3 = r5.getSsSinr()     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0485 }
            r12[r0] = r3     // Catch:{ Exception -> 0x0485 }
            java.lang.String r0 = java.lang.String.format(r10, r11, r12)     // Catch:{ Exception -> 0x0485 }
            r4.signalExtraInfo = r0     // Catch:{ Exception -> 0x0485 }
            goto L_0x048d
        L_0x0485:
            r0 = move-exception
            boolean r3 = a.a.a.a.c.a.f1201a
            if (r3 == 0) goto L_0x048d
            r0.printStackTrace()
        L_0x048d:
            r0 = 30
            java.lang.String r3 = "new cell delta3 time(ms) = "
            if (r2 < r0) goto L_0x0522
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Error -> 0x05b8 }
            long r7 = r19.getTimestampMillis()     // Catch:{ Error -> 0x05b8 }
            long r5 = r5 - r7
            boolean r0 = a.a.a.a.c.a.f1201a     // Catch:{ Error -> 0x05b8 }
            if (r0 == 0) goto L_0x04fb
            boolean r0 = a.a.a.a.c.a.f1202b     // Catch:{ Error -> 0x05b8 }
            if (r0 == 0) goto L_0x04fb
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Error -> 0x05b8 }
            r2.<init>()     // Catch:{ Error -> 0x05b8 }
            java.lang.String r7 = "new cell delta1 time(ms) = "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Error -> 0x05b8 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Error -> 0x05b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ Error -> 0x05b8 }
            r0.setLog(r2)     // Catch:{ Error -> 0x05b8 }
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Error -> 0x05b8 }
            r2.<init>()     // Catch:{ Error -> 0x05b8 }
            java.lang.String r7 = "new cell delta2 time(ms) = "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Error -> 0x05b8 }
            long r7 = r19.getTimestampMillis()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = r2.append(r7)     // Catch:{ Error -> 0x05b8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Error -> 0x05b8 }
            r0.setLog(r1)     // Catch:{ Error -> 0x05b8 }
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Error -> 0x05b8 }
            r1.<init>()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ Error -> 0x05b8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Error -> 0x05b8 }
            r0.setLog(r1)     // Catch:{ Error -> 0x05b8 }
        L_0x04fb:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Error -> 0x05b8 }
            long r0 = r0 - r5
            r4.mTime = r0     // Catch:{ Error -> 0x05b8 }
            boolean r0 = a.a.a.a.c.a.f1201a     // Catch:{ Error -> 0x05b8 }
            if (r0 == 0) goto L_0x05c6
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Error -> 0x05b8 }
            r1.<init>()     // Catch:{ Error -> 0x05b8 }
            java.lang.String r2 = "new cell time apilevel up 30 (ms) = "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Error -> 0x05b8 }
            long r2 = r4.mTime     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Error -> 0x05b8 }
        L_0x051c:
            java.lang.String r1 = r1.toString()     // Catch:{ Error -> 0x05b8 }
            goto L_0x05b4
        L_0x0522:
            long r5 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch:{ Error -> 0x05b8 }
            long r7 = r19.getTimeStamp()     // Catch:{ Error -> 0x05b8 }
            long r5 = r5 - r7
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r5 / r7
            boolean r0 = a.a.a.a.c.a.f1201a     // Catch:{ Error -> 0x05b8 }
            if (r0 == 0) goto L_0x058d
            boolean r0 = a.a.a.a.c.a.f1202b     // Catch:{ Error -> 0x05b8 }
            if (r0 == 0) goto L_0x058d
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Error -> 0x05b8 }
            r2.<init>()     // Catch:{ Error -> 0x05b8 }
            java.lang.String r7 = "new cell delta1 time(ns) = "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Error -> 0x05b8 }
            long r7 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Error -> 0x05b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ Error -> 0x05b8 }
            r0.setLog(r2)     // Catch:{ Error -> 0x05b8 }
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Error -> 0x05b8 }
            r2.<init>()     // Catch:{ Error -> 0x05b8 }
            java.lang.String r7 = "new cell delta2 time(ns) = "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Error -> 0x05b8 }
            long r7 = r19.getTimeStamp()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = r2.append(r7)     // Catch:{ Error -> 0x05b8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Error -> 0x05b8 }
            r0.setLog(r1)     // Catch:{ Error -> 0x05b8 }
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Error -> 0x05b8 }
            r1.<init>()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ Error -> 0x05b8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Error -> 0x05b8 }
            r0.setLog(r1)     // Catch:{ Error -> 0x05b8 }
        L_0x058d:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Error -> 0x05b8 }
            long r0 = r0 - r5
            r4.mTime = r0     // Catch:{ Error -> 0x05b8 }
            boolean r0 = a.a.a.a.c.a.f1201a     // Catch:{ Error -> 0x05b8 }
            if (r0 == 0) goto L_0x05c6
            boolean r0 = a.a.a.a.c.a.f1202b     // Catch:{ Error -> 0x05b8 }
            if (r0 == 0) goto L_0x05c6
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Error -> 0x05b8 }
            r1.<init>()     // Catch:{ Error -> 0x05b8 }
            java.lang.String r2 = "new cell time(ms) = "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Error -> 0x05b8 }
            long r2 = r4.mTime     // Catch:{ Error -> 0x05b8 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Error -> 0x05b8 }
            goto L_0x051c
        L_0x05b4:
            r0.setLog(r1)     // Catch:{ Error -> 0x05b8 }
            goto L_0x05c6
        L_0x05b8:
            r0 = move-exception
            boolean r1 = a.a.a.a.c.a.f1201a
            if (r1 == 0) goto L_0x05c0
            r0.printStackTrace()
        L_0x05c0:
            long r0 = java.lang.System.currentTimeMillis()
            r4.mTime = r0
        L_0x05c6:
            boolean r0 = a.a.a.a.c.a.f1201a
            if (r0 == 0) goto L_0x065b
            boolean r0 = a.a.a.a.c.a.f1202b
            if (r0 == 0) goto L_0x065b
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "mcc = "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r4.mMcc
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setLog(r1)
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "mnc = "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r4.mMnc
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setLog(r1)
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "lac = "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r4.mLac
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setLog(r1)
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cid = "
            java.lang.StringBuilder r1 = r1.append(r2)
            long r2 = r4.mCid
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setLog(r1)
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cs = "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r4.mConnectionStatus
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setLog(r1)
        L_0x065b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(android.telephony.CellInfo, com.baidu.location.provider.BDCellInfo, android.telephony.TelephonyManager):com.baidu.location.provider.BDCellInfo");
    }

    public final BDCellInfo a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    public final BDCellInfo a(CellLocation cellLocation, boolean z2) {
        if (cellLocation == null || this.f1180h == null) {
            return null;
        }
        if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
            NetworkDataProvider.getListener().setLog("set cell info..");
        }
        BDCellInfo bDCellInfo = new BDCellInfo();
        bDCellInfo.cellApiType = 1;
        if (z2) {
            bDCellInfo.isNewApi = true;
        }
        bDCellInfo.mTime = System.currentTimeMillis();
        try {
            String networkOperator = this.f1180h.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                int i2 = -1;
                if (networkOperator.length() >= 3) {
                    i2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    bDCellInfo.mMcc = i2 < 0 ? this.l.mMcc : i2;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= charArray.length) {
                            break;
                        } else if (!Character.isDigit(charArray[i3])) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    i2 = Integer.valueOf(substring.substring(0, i3)).intValue();
                }
                if (i2 < 0) {
                    i2 = this.l.mMnc;
                }
                bDCellInfo.mMnc = i2;
            }
            this.u = this.f1180h.getSimState();
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog("sim state:" + this.u);
            }
        } catch (Exception e2) {
            if (a.a.a.a.c.a.f1201a) {
                e2.printStackTrace();
            }
            G = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            bDCellInfo.mLac = gsmCellLocation.getLac();
            bDCellInfo.mCid = (long) gsmCellLocation.getCid();
            bDCellInfo.mNetworkType = 'g';
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog("bslocation mNetworkType = 'g'");
            }
        } else if (cellLocation instanceof CdmaCellLocation) {
            bDCellInfo.mNetworkType = 'c';
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog("bslocation mNetworkType = 'c'");
            }
            if (F == null) {
                try {
                    F = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception e3) {
                    F = null;
                    return bDCellInfo;
                }
            }
            Class<?> cls = F;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.l.mMnc;
                    }
                    bDCellInfo.mMnc = systemId;
                    bDCellInfo.mCid = (long) ((CdmaCellLocation) cellLocation).getBaseStationId();
                    bDCellInfo.mLac = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                        NetworkDataProvider.getListener().setLog("bslocation lat " + (((double) baseStationLatitude) / 14400.0d));
                    }
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        bDCellInfo.mBSLat = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                        NetworkDataProvider.getListener().setLog("bslocation lon" + (((double) baseStationLongitude) / 14400.0d));
                    }
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        bDCellInfo.mBSLon = baseStationLongitude;
                    }
                } catch (Exception e4) {
                    if (a.a.a.a.c.a.f1201a) {
                        e4.printStackTrace();
                    }
                    G = 3;
                    return bDCellInfo;
                }
            }
        }
        f(bDCellInfo);
        return bDCellInfo;
    }

    public BDCellInfo a(BDCellInfo bDCellInfo, TelephonyManager telephonyManager) {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            this.u = telephonyManager.getSimState();
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                BDCellInfo bDCellInfo2 = null;
                for (CellInfo next : allCellInfo) {
                    if (next.isRegistered()) {
                        boolean z2 = false;
                        if (bDCellInfo2 != null) {
                            z2 = true;
                        }
                        BDCellInfo a2 = a(next, bDCellInfo, telephonyManager);
                        if (a2 != null) {
                            if (!a2.isValid()) {
                                if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                                    NetworkDataProvider.getListener().setLog("res.isValid()");
                                }
                                a2 = null;
                            } else {
                                if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                                    NetworkDataProvider.getListener().setLog(" cell res.isValid() = " + e(a2));
                                }
                                if (z2 && bDCellInfo2 != null) {
                                    bDCellInfo2.extra = d(a2);
                                    bDCellInfo2.otherRegistered = e(a2);
                                }
                            }
                            if (bDCellInfo2 == null) {
                                bDCellInfo2 = a2;
                            }
                        }
                    }
                }
                return bDCellInfo2;
            } else if (!a.a.a.a.c.a.f1201a || !a.a.a.a.c.a.f1202b) {
                return null;
            } else {
                NetworkDataProvider.getListener().setLog("getAllCellInfo=null");
                return null;
            }
        } catch (Throwable th2) {
            if (!a.a.a.a.c.a.f1201a) {
                return null;
            }
            th2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(com.baidu.location.provider.BDCellInfo r10) {
        /*
            r9 = this;
            java.lang.String r10 = "|"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r1.intValue()
            r2 = 0
            r3 = 17
            if (r1 < r3) goto L_0x00e5
            android.telephony.TelephonyManager r1 = r9.f1180h     // Catch:{ all -> 0x00dd }
            java.util.List r1 = r1.getAllCellInfo()     // Catch:{ all -> 0x00dd }
            if (r1 == 0) goto L_0x00cb
            int r3 = r1.size()     // Catch:{ all -> 0x00dd }
            if (r3 <= 0) goto L_0x00cb
            java.lang.String r3 = "&nc="
            r0.append(r3)     // Catch:{ all -> 0x00dd }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00dd }
        L_0x002e:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00dd }
            if (r3 == 0) goto L_0x00e5
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00dd }
            android.telephony.CellInfo r3 = (android.telephony.CellInfo) r3     // Catch:{ all -> 0x00dd }
            boolean r4 = r3.isRegistered()     // Catch:{ all -> 0x00dd }
            if (r4 == 0) goto L_0x0041
            goto L_0x002e
        L_0x0041:
            com.baidu.location.provider.BDCellInfo r4 = r9.l     // Catch:{ all -> 0x00dd }
            android.telephony.TelephonyManager r5 = r9.f1180h     // Catch:{ all -> 0x00dd }
            com.baidu.location.provider.BDCellInfo r3 = r9.a(r3, r4, r5)     // Catch:{ all -> 0x00dd }
            if (r3 != 0) goto L_0x004c
            goto L_0x002e
        L_0x004c:
            int r4 = r3.mLac     // Catch:{ all -> 0x00dd }
            r5 = -1
            java.lang.String r6 = ";"
            if (r4 == r5) goto L_0x008c
            long r4 = r3.mCid     // Catch:{ all -> 0x00dd }
            r7 = -1
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x008c
            int r4 = r3.mMcc     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r0.append(r4)     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r4.append(r10)     // Catch:{ all -> 0x00dd }
            int r5 = r3.mMnc     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r4.append(r10)     // Catch:{ all -> 0x00dd }
            int r5 = r3.mLac     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r4.append(r10)     // Catch:{ all -> 0x00dd }
            long r7 = r3.mCid     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r4.append(r10)     // Catch:{ all -> 0x00dd }
            int r5 = r3.mStrength     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00dd }
            r4.append(r6)     // Catch:{ all -> 0x00dd }
        L_0x008c:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00dd }
            r5 = 28
            if (r4 <= r5) goto L_0x002e
            int r4 = r3.cellType     // Catch:{ all -> 0x00dd }
            r5 = 6
            if (r4 != r5) goto L_0x002e
            java.lang.String r4 = r3.signalExtraInfo     // Catch:{ all -> 0x00dd }
            if (r4 == 0) goto L_0x002e
            boolean r4 = r3.isValid()     // Catch:{ all -> 0x00dd }
            if (r4 == 0) goto L_0x002e
            if (r2 != 0) goto L_0x00b1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r4.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "&ncnr="
            r4.append(r2)     // Catch:{ all -> 0x00af }
            r2 = r4
            goto L_0x00b1
        L_0x00af:
            r10 = move-exception
            goto L_0x00c9
        L_0x00b1:
            java.lang.String r4 = r9.e((com.baidu.location.provider.BDCellInfo) r3)     // Catch:{ all -> 0x00c7 }
            r2.append(r4)     // Catch:{ all -> 0x00c7 }
            java.lang.String r4 = "_"
            r2.append(r4)     // Catch:{ all -> 0x00c7 }
            java.lang.String r3 = r3.signalExtraInfo     // Catch:{ all -> 0x00c7 }
            r2.append(r3)     // Catch:{ all -> 0x00c7 }
            r2.append(r6)     // Catch:{ all -> 0x00c7 }
            goto L_0x002e
        L_0x00c7:
            r10 = move-exception
            r4 = r2
        L_0x00c9:
            r2 = r4
            goto L_0x00de
        L_0x00cb:
            boolean r10 = a.a.a.a.c.a.f1201a     // Catch:{ all -> 0x00dd }
            if (r10 == 0) goto L_0x00e5
            boolean r10 = a.a.a.a.c.a.f1202b     // Catch:{ all -> 0x00dd }
            if (r10 == 0) goto L_0x00e5
            com.baidu.location.provider.KeyEventListener r10 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "getAllCellInfo = null"
            r10.setLog(r1)     // Catch:{ all -> 0x00dd }
            goto L_0x00e5
        L_0x00dd:
            r10 = move-exception
        L_0x00de:
            boolean r1 = a.a.a.a.c.a.f1201a
            if (r1 == 0) goto L_0x00e5
            r10.printStackTrace()
        L_0x00e5:
            if (r2 == 0) goto L_0x0101
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r10 = r10.toString()
            return r10
        L_0x0101:
            java.lang.String r10 = r0.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(com.baidu.location.provider.BDCellInfo):java.lang.String");
    }

    public List<BDCellInfo> a() {
        ArrayList arrayList = new ArrayList();
        try {
            List<CellInfo> allCellInfo = this.f1180h.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                for (CellInfo a2 : allCellInfo) {
                    arrayList.add(a(a2, this.l, this.f1180h));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public void a(float f2) {
        this.f1177e = f2;
    }

    public void a(Context context) {
        e eVar;
        if (!this.t) {
            this.s = context;
            this.f1180h = (TelephonyManager) context.getSystemService("phone");
            this.n = new LinkedList();
            if (Looper.myLooper() != null) {
                this.o = new e();
            }
            if (this.B == null) {
                this.B = new Handler(Looper.getMainLooper());
            }
            if (this.f1179g) {
                d();
            }
            if (this.f1180h != null && this.o != null) {
                if (Build.VERSION.SDK_INT >= this.f1175c) {
                    this.v = a.a.a.a.c.c.a("android.telephony.TelephonyManager$CellInfoCallback");
                    if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                        NetworkDataProvider.getListener().setLog("isCellinfoCallbackExist = " + this.v);
                    }
                }
                if ((Build.VERSION.SDK_INT < this.f1175c || !this.v) && (eVar = this.o) != null) {
                    try {
                        this.f1180h.listen(eVar, 1280);
                    } catch (Exception e2) {
                    }
                }
                if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                    NetworkDataProvider.getListener().setLog("cell manager start...");
                }
                this.t = true;
            }
        }
    }

    public void a(Handler handler) {
        this.B = handler;
    }

    public void a(boolean z2) {
        this.f1178f = z2;
    }

    public boolean a(BDCellInfo bDCellInfo, BDCellInfo bDCellInfo2) {
        boolean z2;
        if (bDCellInfo == null && bDCellInfo2 == null) {
            return false;
        }
        if (bDCellInfo == null || bDCellInfo2 == null) {
            return true;
        }
        float abs = (float) Math.abs(bDCellInfo.mStrength - bDCellInfo2.mStrength);
        int i2 = bDCellInfo.mStrength;
        int i3 = -1;
        if (i2 == 0) {
            i2 = -1;
        }
        float f2 = abs / ((float) i2);
        if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
            NetworkDataProvider.getListener().setLog("cl-cache, str, old:" + bDCellInfo.mStrength + " new:" + bDCellInfo2.mStrength);
            NetworkDataProvider.getListener().setLog("cl-cache, str, diffRate:" + f2);
        }
        String str = bDCellInfo.extra;
        if (!(str == null || bDCellInfo2.extra == null)) {
            int a2 = a(str);
            int abs2 = Math.abs(a2 - a(bDCellInfo2.extra));
            if (a2 != 0) {
                i3 = a2;
            }
            if (((float) Math.abs(abs2 / i3)) > this.f1177e) {
                z2 = true;
                if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                    NetworkDataProvider.getListener().setLog("cl-cache, isStrengthChange2:" + z2);
                }
                return f2 <= this.f1177e || z2;
            }
        }
        z2 = false;
        NetworkDataProvider.getListener().setLog("cl-cache, isStrengthChange2:" + z2);
        if (f2 <= this.f1177e) {
        }
    }

    public String b(BDCellInfo bDCellInfo) {
        int i2;
        if (bDCellInfo == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(bDCellInfo.mNetworkType);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(bDCellInfo.mMcc), Integer.valueOf(bDCellInfo.mMnc), Integer.valueOf(bDCellInfo.mLac), Long.valueOf(bDCellInfo.mCid), Integer.valueOf(bDCellInfo.mStrength)}));
        if (bDCellInfo.mBSLat < Integer.MAX_VALUE && (i2 = bDCellInfo.mBSLon) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[]{Double.valueOf(((double) i2) / 14400.0d), Double.valueOf(((double) bDCellInfo.mBSLat) / 14400.0d)}));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(bDCellInfo.mTime);
        stringBuffer.append("&cl_api=");
        stringBuffer.append(bDCellInfo.cellApiType);
        stringBuffer.append("&clp=");
        stringBuffer.append(bDCellInfo.cellType);
        if (bDCellInfo.signalExtraInfo != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(bDCellInfo.signalExtraInfo);
        }
        if (Build.VERSION.SDK_INT >= 28 && bDCellInfo.mConnectionStatus != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(bDCellInfo.mConnectionStatus);
        }
        try {
            List<BDCellInfo> list = this.n;
            if (list != null && list.size() > 0) {
                int size = this.n.size();
                stringBuffer.append("&clt=");
                for (int i3 = 0; i3 < size; i3++) {
                    BDCellInfo bDCellInfo2 = this.n.get(i3);
                    if (bDCellInfo2 != null) {
                        if (bDCellInfo2.mMcc != bDCellInfo.mMcc) {
                            stringBuffer.append(bDCellInfo2.mMcc);
                        }
                        stringBuffer.append("|");
                        if (bDCellInfo2.mMnc != bDCellInfo.mMnc) {
                            stringBuffer.append(bDCellInfo2.mMnc);
                        }
                        stringBuffer.append("|");
                        if (bDCellInfo2.mLac != bDCellInfo.mLac) {
                            stringBuffer.append(bDCellInfo2.mLac);
                        }
                        stringBuffer.append("|");
                        if (bDCellInfo2.mCid != bDCellInfo.mCid) {
                            stringBuffer.append(bDCellInfo2.mCid);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - bDCellInfo2.mTime) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception e2) {
            if (a.a.a.a.c.a.f1201a) {
                e2.printStackTrace();
            }
        }
        if (this.u > 100) {
            this.u = 0;
        }
        int i4 = this.u + (G << 8);
        if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
            NetworkDataProvider.getListener().setLog("sim state:" + this.u + "," + i4);
        }
        stringBuffer.append("&cs=" + i4);
        String str = bDCellInfo.extra;
        if (str != null) {
            stringBuffer.append(str);
        }
        if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
            NetworkDataProvider.getListener().setLog("cell sb.toString() = " + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public final void b() {
        this.B.post(new C0001a());
    }

    public void b(int i2) {
        this.f1175c = i2;
    }

    public void b(boolean z2) {
        this.f1179g = z2;
    }

    public String c(BDCellInfo bDCellInfo) {
        String str = "";
        try {
            String a2 = a(bDCellInfo);
            int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if ((a2 != null && !str.equals(a2) && !"&nc=".equals(a2)) || intValue >= 17) {
                return a2;
            }
            str = a2;
            if (str == null || !"&nc=".equals(str)) {
                return str;
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void c(int i2) {
        this.f1176d = i2;
    }

    public boolean c() {
        return this.A;
    }

    public final String d(BDCellInfo bDCellInfo) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(bDCellInfo.mNetworkType);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d&cl_t2=%d", new Object[]{Integer.valueOf(bDCellInfo.mMcc), Integer.valueOf(bDCellInfo.mMnc), Integer.valueOf(bDCellInfo.mLac), Long.valueOf(bDCellInfo.mCid), Integer.valueOf(bDCellInfo.mStrength), Integer.valueOf(bDCellInfo.cellType), Long.valueOf(bDCellInfo.mTime)}));
        if (bDCellInfo.mConnectionStatus != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(bDCellInfo.mConnectionStatus);
        }
        if (bDCellInfo.signalExtraInfo != null) {
            stringBuffer.append("&clnrs2=");
            stringBuffer.append(bDCellInfo.signalExtraInfo);
        }
        return stringBuffer.toString();
    }

    public final void d() {
        KeyEventListener listener;
        String str;
        String b2 = a.a.a.a.c.c.b(this.s);
        if (b2 != null) {
            File file = new File(b2 + File.separator + "lcvif2.dat");
            if (file.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                    randomAccessFile.seek(0);
                    long readLong = randomAccessFile.readLong();
                    if (System.currentTimeMillis() - readLong > 60000) {
                        if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                            NetworkDataProvider.getListener().setLog("cellbuffer System.currentTimeMillis() - time > 1 *60 *1000" + readLong);
                        }
                        randomAccessFile.close();
                        file.delete();
                        return;
                    }
                    randomAccessFile.readInt();
                    for (int i2 = 0; i2 < 3; i2++) {
                        long readLong2 = randomAccessFile.readLong();
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        long readLong3 = randomAccessFile.readLong();
                        int readInt4 = randomAccessFile.readInt();
                        if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                            NetworkDataProvider.getListener().setLog("cellbuffer cell info = " + readLong2 + " " + readInt + " " + readInt2 + " " + readInt3 + " " + readLong3 + " " + readInt4);
                        }
                        char c2 = readInt4 == 1 ? 'g' : 0;
                        if (readInt4 == 2) {
                            c2 = 'c';
                        }
                        char c3 = c2;
                        if (readLong2 == 0) {
                            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                                listener = NetworkDataProvider.getListener();
                                str = "loc cell time1 == 0";
                            }
                        } else {
                            BDCellInfo bDCellInfo = r10;
                            BDCellInfo bDCellInfo2 = new BDCellInfo(readInt3, readLong3, readInt, readInt2, 0, c3, -1);
                            bDCellInfo2.mTime = readLong2;
                            if (bDCellInfo2.isValid()) {
                                this.A = true;
                                this.n.add(bDCellInfo2);
                            }
                            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                                listener = NetworkDataProvider.getListener();
                                str = "loc cell " + b(bDCellInfo2);
                            }
                        }
                        listener.setLog(str);
                    }
                    randomAccessFile.close();
                } catch (Exception e2) {
                    if (a.a.a.a.c.a.f1201a) {
                        e2.printStackTrace();
                    }
                    file.delete();
                }
            }
        }
    }

    public final String e(BDCellInfo bDCellInfo) {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", new Object[]{Integer.valueOf(bDCellInfo.mMcc), Integer.valueOf(bDCellInfo.mMnc), Integer.valueOf(bDCellInfo.mLac), Long.valueOf(bDCellInfo.mCid)});
    }

    public final void e() {
        if (this.p == null) {
            this.p = new d(this, (C0001a) null);
        }
        this.f1180h.requestCellInfoUpdate(this.s.getMainExecutor(), this.p);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0113, code lost:
        if (r0 == false) goto L_0x0115;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bd A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ec A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f7 A[Catch:{ Exception -> 0x010b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r8 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r8.w = r0
            boolean r0 = r8.f1178f
            if (r0 != 0) goto L_0x000c
            goto L_0x0115
        L_0x000c:
            r0 = 0
            android.telephony.SubscriptionManager r1 = r8.k     // Catch:{ Exception -> 0x010b }
            if (r1 != 0) goto L_0x001e
            android.content.Context r1 = r8.s     // Catch:{ Exception -> 0x010b }
            java.lang.String r2 = "telephony_subscription_service"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x010b }
            android.telephony.SubscriptionManager r1 = (android.telephony.SubscriptionManager) r1     // Catch:{ Exception -> 0x010b }
            r8.k = r1     // Catch:{ Exception -> 0x010b }
        L_0x001e:
            android.telephony.SubscriptionManager r1 = r8.k     // Catch:{ Exception -> 0x010b }
            int[] r1 = r1.getSubscriptionIds(r0)     // Catch:{ Exception -> 0x010b }
            android.telephony.SubscriptionManager r2 = r8.k     // Catch:{ Exception -> 0x010b }
            r3 = 1
            int[] r2 = r2.getSubscriptionIds(r3)     // Catch:{ Exception -> 0x010b }
            r4 = -1
            if (r1 == 0) goto L_0x0034
            int r5 = r1.length     // Catch:{ Exception -> 0x010b }
            if (r5 <= 0) goto L_0x0034
            r1 = r1[r0]     // Catch:{ Exception -> 0x010b }
            goto L_0x0035
        L_0x0034:
            r1 = r4
        L_0x0035:
            if (r2 == 0) goto L_0x003c
            int r5 = r2.length     // Catch:{ Exception -> 0x010b }
            if (r5 <= 0) goto L_0x003c
            r4 = r2[r0]     // Catch:{ Exception -> 0x010b }
        L_0x003c:
            boolean r2 = android.telephony.SubscriptionManager.isValidSubscriptionId(r1)     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x004b
            boolean r2 = android.telephony.SubscriptionManager.isValidSubscriptionId(r4)     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x004b
            r8.y = r3     // Catch:{ Exception -> 0x010b }
            goto L_0x004d
        L_0x004b:
            r8.y = r0     // Catch:{ Exception -> 0x010b }
        L_0x004d:
            boolean r2 = a.a.a.a.c.a.f1201a     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x0091
            boolean r2 = a.a.a.a.c.a.f1202b     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x0091
            com.baidu.location.provider.KeyEventListener r2 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
            r5.<init>()     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = "getCellInfo: subId0 = "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r5 = r5.append(r1)     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = ", subId1 = "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r5 = r5.append(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = ", mLastSubId0 = "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x010b }
            int r6 = r8.C     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = ", mLastSubId1 = "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x010b }
            int r6 = r8.D     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x010b }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x010b }
            r2.setLog(r5)     // Catch:{ Exception -> 0x010b }
        L_0x0091:
            boolean r2 = android.telephony.SubscriptionManager.isValidSubscriptionId(r1)     // Catch:{ Exception -> 0x010b }
            r5 = 0
            if (r2 == 0) goto L_0x00ca
            android.telephony.TelephonyManager r2 = r8.f1181i     // Catch:{ Exception -> 0x010b }
            if (r2 != 0) goto L_0x00a3
            android.telephony.TelephonyManager r2 = r8.f1180h     // Catch:{ Exception -> 0x010b }
        L_0x009e:
            android.telephony.TelephonyManager r2 = r2.createForSubscriptionId(r1)     // Catch:{ Exception -> 0x010b }
            goto L_0x00ac
        L_0x00a3:
            int r2 = r8.C     // Catch:{ Exception -> 0x010b }
            if (r2 == r1) goto L_0x00ae
            r8.f1181i = r5     // Catch:{ Exception -> 0x010b }
            android.telephony.TelephonyManager r2 = r8.f1180h     // Catch:{ Exception -> 0x010b }
            goto L_0x009e
        L_0x00ac:
            r8.f1181i = r2     // Catch:{ Exception -> 0x010b }
        L_0x00ae:
            a.a.a.a.b.a$b r2 = r8.q     // Catch:{ Exception -> 0x010b }
            if (r2 != 0) goto L_0x00b9
            a.a.a.a.b.a$b r2 = new a.a.a.a.b.a$b     // Catch:{ Exception -> 0x010b }
            r2.<init>(r8, r5)     // Catch:{ Exception -> 0x010b }
            r8.q = r2     // Catch:{ Exception -> 0x010b }
        L_0x00b9:
            android.telephony.TelephonyManager r2 = r8.f1181i     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x00cc
            android.content.Context r6 = r8.s     // Catch:{ Exception -> 0x010b }
            java.util.concurrent.Executor r6 = r6.getMainExecutor()     // Catch:{ Exception -> 0x010b }
            a.a.a.a.b.a$b r7 = r8.q     // Catch:{ Exception -> 0x010b }
            r2.requestCellInfoUpdate(r6, r7)     // Catch:{ Exception -> 0x010b }
            r0 = r3
            goto L_0x00cc
        L_0x00ca:
            r8.f1181i = r5     // Catch:{ Exception -> 0x010b }
        L_0x00cc:
            boolean r2 = android.telephony.SubscriptionManager.isValidSubscriptionId(r4)     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x0104
            android.telephony.TelephonyManager r2 = r8.f1182j     // Catch:{ Exception -> 0x010b }
            if (r2 != 0) goto L_0x00dd
            android.telephony.TelephonyManager r2 = r8.f1180h     // Catch:{ Exception -> 0x010b }
        L_0x00d8:
            android.telephony.TelephonyManager r2 = r2.createForSubscriptionId(r4)     // Catch:{ Exception -> 0x010b }
            goto L_0x00e6
        L_0x00dd:
            int r2 = r8.D     // Catch:{ Exception -> 0x010b }
            if (r2 == r4) goto L_0x00e8
            r8.f1182j = r5     // Catch:{ Exception -> 0x010b }
            android.telephony.TelephonyManager r2 = r8.f1180h     // Catch:{ Exception -> 0x010b }
            goto L_0x00d8
        L_0x00e6:
            r8.f1182j = r2     // Catch:{ Exception -> 0x010b }
        L_0x00e8:
            a.a.a.a.b.a$c r2 = r8.r     // Catch:{ Exception -> 0x010b }
            if (r2 != 0) goto L_0x00f3
            a.a.a.a.b.a$c r2 = new a.a.a.a.b.a$c     // Catch:{ Exception -> 0x010b }
            r2.<init>(r8, r5)     // Catch:{ Exception -> 0x010b }
            r8.r = r2     // Catch:{ Exception -> 0x010b }
        L_0x00f3:
            android.telephony.TelephonyManager r2 = r8.f1182j     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x0106
            android.content.Context r5 = r8.s     // Catch:{ Exception -> 0x010b }
            java.util.concurrent.Executor r5 = r5.getMainExecutor()     // Catch:{ Exception -> 0x010b }
            a.a.a.a.b.a$c r6 = r8.r     // Catch:{ Exception -> 0x010b }
            r2.requestCellInfoUpdate(r5, r6)     // Catch:{ Exception -> 0x010b }
            r0 = r3
            goto L_0x0106
        L_0x0104:
            r8.f1182j = r5     // Catch:{ Exception -> 0x010b }
        L_0x0106:
            r8.C = r1     // Catch:{ Exception -> 0x010b }
            r8.D = r4     // Catch:{ Exception -> 0x010b }
            goto L_0x0113
        L_0x010b:
            r1 = move-exception
            boolean r2 = a.a.a.a.c.a.f1201a
            if (r2 == 0) goto L_0x0113
            r1.printStackTrace()
        L_0x0113:
            if (r0 != 0) goto L_0x0118
        L_0x0115:
            r8.e()
        L_0x0118:
            java.lang.Object r0 = r8.E
            monitor-enter(r0)
            boolean r1 = a.a.a.a.c.a.f1201a     // Catch:{ InterruptedException -> 0x013a }
            if (r1 == 0) goto L_0x012d
            boolean r1 = a.a.a.a.c.a.f1202b     // Catch:{ InterruptedException -> 0x013a }
            if (r1 == 0) goto L_0x012d
            com.baidu.location.provider.KeyEventListener r1 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ InterruptedException -> 0x013a }
            java.lang.String r2 = "start waiting update to finish"
            r1.setLog(r2)     // Catch:{ InterruptedException -> 0x013a }
        L_0x012d:
            int r1 = r8.f1176d     // Catch:{ InterruptedException -> 0x013a }
            if (r1 == 0) goto L_0x0142
            java.lang.Object r2 = r8.E     // Catch:{ InterruptedException -> 0x013a }
            long r3 = (long) r1     // Catch:{ InterruptedException -> 0x013a }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x013a }
            goto L_0x0142
        L_0x0138:
            r1 = move-exception
            goto L_0x0144
        L_0x013a:
            r1 = move-exception
            boolean r2 = a.a.a.a.c.a.f1201a     // Catch:{ all -> 0x0138 }
            if (r2 == 0) goto L_0x0142
            r1.printStackTrace()     // Catch:{ all -> 0x0138 }
        L_0x0142:
            monitor-exit(r0)     // Catch:{ all -> 0x0138 }
            return
        L_0x0144:
            monitor-exit(r0)     // Catch:{ all -> 0x0138 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.f():void");
    }

    public final void f(BDCellInfo bDCellInfo) {
        BDCellInfo bDCellInfo2;
        BDCellInfo bDCellInfo3 = this.l;
        if (bDCellInfo.isValid() && ((bDCellInfo2 = this.l) == null || !bDCellInfo2.isSameWith(bDCellInfo) || a(this.l, bDCellInfo))) {
            this.l = bDCellInfo;
        }
        if (!bDCellInfo.isValid()) {
            return;
        }
        if (bDCellInfo3 != null && bDCellInfo3.isSameWith(bDCellInfo)) {
            return;
        }
        if (bDCellInfo.isValid()) {
            int size = this.n.size();
            BDCellInfo bDCellInfo4 = size == 0 ? null : this.n.get(size - 1);
            if (bDCellInfo4 != null) {
                long j2 = bDCellInfo4.mCid;
                BDCellInfo bDCellInfo5 = this.l;
                if (j2 == bDCellInfo5.mCid && bDCellInfo4.mLac == bDCellInfo5.mLac) {
                    return;
                }
            }
            this.n.add(this.l);
            if (this.n.size() > 3) {
                this.n.remove(0);
            }
            if (this.f1179g) {
                i();
            }
            this.A = false;
            return;
        }
        List<BDCellInfo> list = this.n;
        if (list != null) {
            list.clear();
        }
    }

    public void g() {
        TelephonyManager telephonyManager;
        if (this.t) {
            e eVar = this.o;
            if (!(eVar == null || (telephonyManager = this.f1180h) == null)) {
                telephonyManager.listen(eVar, 0);
            }
            this.o = null;
            this.f1180h = null;
            this.f1181i = null;
            this.f1182j = null;
            this.n.clear();
            this.n = null;
            if (this.f1179g) {
                i();
            }
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog("cell manager stop ...");
            }
            this.t = false;
        }
    }

    public final synchronized void h() {
        CellLocation cellLocation;
        BDCellInfo a2 = a(this.l, this.f1180h);
        if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b && a2 != null) {
            NetworkDataProvider.getListener().setLog("new cell api = " + e(a2));
        }
        if (a2 != null) {
            f(a2);
        }
        if (Build.VERSION.SDK_INT <= 28 && (a2 == null || !a2.isValid())) {
            BDCellInfo bDCellInfo = null;
            try {
                cellLocation = this.f1180h.getCellLocation();
            } catch (Throwable th2) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                bDCellInfo = a(cellLocation);
            }
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b && bDCellInfo != null) {
                NetworkDataProvider.getListener().setLog(" old cell api = " + e(bDCellInfo));
            }
        }
    }

    public final void i() {
        List<BDCellInfo> list = this.n;
        if (list != null || this.m != null) {
            if (list == null && this.m != null) {
                LinkedList linkedList = new LinkedList();
                this.n = linkedList;
                linkedList.add(this.m);
            }
            String b2 = a.a.a.a.c.c.b(this.s);
            if (b2 != null && this.n != null) {
                File file = new File(b2 + File.separator + "lcvif2.dat");
                int size = this.n.size();
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                    randomAccessFile.seek(0);
                    randomAccessFile.writeLong(this.n.get(size - 1).mTime);
                    randomAccessFile.writeInt(size);
                    for (int i2 = 0; i2 < 3 - size; i2++) {
                        randomAccessFile.writeLong(0);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeLong(-1);
                        randomAccessFile.writeInt(2);
                    }
                    for (int i3 = 0; i3 < size; i3++) {
                        randomAccessFile.writeLong(this.n.get(i3).mTime);
                        randomAccessFile.writeInt(this.n.get(i3).mMcc);
                        randomAccessFile.writeInt(this.n.get(i3).mMnc);
                        randomAccessFile.writeInt(this.n.get(i3).mLac);
                        randomAccessFile.writeLong(this.n.get(i3).mCid);
                        if (this.n.get(i3).mNetworkType == 'g') {
                            randomAccessFile.writeInt(1);
                        } else if (this.n.get(i3).mNetworkType == 'c') {
                            randomAccessFile.writeInt(2);
                        } else {
                            randomAccessFile.writeInt(3);
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e2) {
                    if (a.a.a.a.c.a.f1201a) {
                        e2.printStackTrace();
                    }
                }
            }
        } else if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
            NetworkDataProvider.getListener().setLog("cellbuffer mTrackList == null");
        }
    }
}
