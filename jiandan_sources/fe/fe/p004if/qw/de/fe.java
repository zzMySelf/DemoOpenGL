package fe.fe.p004if.qw.de;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPResponse;
import com.baidu.lcp.sdk.connect.DNSUrlProvider;
import fe.fe.p004if.qw.qw.qw;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: fe.fe.if.qw.de.fe  reason: invalid package */
public final class fe extends Observable {
    public static volatile fe.fe.p004if.qw.ad.ad a = new fe.fe.p004if.qw.ad.ad();
    public static volatile fe b;
    public String aaa = "";

    /* renamed from: ad  reason: collision with root package name */
    public AtomicInteger f1916ad = new AtomicInteger(0);
    public Cif ddd = new Cif(this, (qw) null);

    /* renamed from: de  reason: collision with root package name */
    public int f1917de = 0;
    public String eee = "";

    /* renamed from: fe  reason: collision with root package name */
    public boolean f1918fe = false;
    public AtomicInteger ggg = new AtomicInteger(0);

    /* renamed from: i  reason: collision with root package name */
    public fe.fe.p004if.qw.fe.ad f1919i = new fe.fe.p004if.qw.fe.ad();

    /* renamed from: if  reason: not valid java name */
    public pf f43if;
    public long mmm;
    public uk nn = new uk(Looper.getMainLooper());

    /* renamed from: o  reason: collision with root package name */
    public Map<Long, BLCPResponse> f1920o = new LinkedHashMap();

    /* renamed from: pf  reason: collision with root package name */
    public Map<Long, BLCPResponse> f1921pf = new LinkedHashMap();
    public boolean ppp = false;
    public String qqq = "";
    public final Map<Integer, Boolean> qw = new TreeMap();

    /* renamed from: rg  reason: collision with root package name */
    public volatile LinkedList<qw> f1922rg = new LinkedList<>();
    public Runnable rrr = new de();

    /* renamed from: switch  reason: not valid java name */
    public o f44switch;

    /* renamed from: th  reason: collision with root package name */
    public final HashMap<Long, qw> f1923th = new LinkedHashMap();
    public Runnable tt = new C0105fe();

    /* renamed from: uk  reason: collision with root package name */
    public final Object f1924uk = new Object();
    public Context vvv;
    public i when = new i(this, (qw) null);
    public ad xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final Object f1925yj = new Object();

    /* renamed from: fe.fe.if.qw.de.fe$ad */
    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f1926ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f1927th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f1929yj;

        public ad(int i2, String str, String str2) {
            this.f1926ad = i2;
            this.f1927th = str;
            this.f1929yj = str2;
        }

        public void run() {
            qw.de deVar = new qw.de(fe.this.vvv);
            deVar.th(fe.this.mmm);
            deVar.yj(System.currentTimeMillis());
            deVar.qw((long) this.f1926ad);
            deVar.fe(this.f1927th);
            deVar.de(this.f1929yj);
            deVar.rg((long) fe.this.ggg.get());
            deVar.ad();
            if (fe.fe.p004if.qw.qw.fe.i(fe.this.vvv, 401216) && fe.this.ggg.get() >= 5 && this.f1926ad != 401211) {
                fe.fe.p004if.qw.qw.ad.o(fe.this.vvv, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(fe.this.mmm).setStopTime(System.currentTimeMillis()).setAliasId(401216).setReason(this.f1927th).setExt(this.f1929yj).setRetryCount((long) fe.this.ggg.get()).build()).build());
            }
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$de */
    public class de implements Runnable {
        public de() {
        }

        public void run() {
            fe.this.n();
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$fe  reason: collision with other inner class name */
    public class C0105fe implements Runnable {
        public C0105fe() {
        }

        public void run() {
            fe feVar = fe.this;
            feVar.H(feVar.f1919i.ad(fe.this.vvv, 1));
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$if  reason: invalid class name */
    public class Cif implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public long f1934ad;

        /* renamed from: th  reason: collision with root package name */
        public String f1935th;

        public Cif() {
        }

        public void ad(long j) {
            this.f1934ad = j;
        }

        public void qw(String str) {
            this.f1935th = str;
        }

        public void run() {
            fe.this.B(this.f1934ad, this.f1935th);
            fe.this.r("read and write thread timeout:", this.f1935th);
        }

        public /* synthetic */ Cif(fe feVar, qw qwVar) {
            this();
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$o */
    public class o extends Thread {

        /* renamed from: ad  reason: collision with root package name */
        public String f1937ad;

        public o(String str) {
            this.f1937ad = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        public void run() {
            qw qwVar;
            while (!fe.this.ppp) {
                try {
                    try {
                        qw de2 = fe.this.f1919i.de(fe.this.xxx.ad());
                        if (de2 != null && de2.when > 0) {
                            fe.this.nn.removeCallbacks(fe.this.ddd);
                            de2.f46switch = false;
                            fe.fe.p004if.qw.yj.fe.fe("SocketTransceiver", "ReadThread :" + de2.toString());
                            if (!de2.f1957pf) {
                                if (de2.f45if) {
                                    fe.fe.p004if.qw.qw.fe.qqq(fe.this.vvv, "17N_1", "Read LoginMsg Response");
                                }
                                if (de2.f1955i == 1 && de2.f1960uk == 4) {
                                    Context context = fe.this.vvv;
                                    fe.fe.p004if.qw.yj.ad.qw(context, 1, "read", de2.when + "");
                                }
                                if (de2.f1955i == 50 && de2.f1960uk == 2) {
                                    Context context2 = fe.this.vvv;
                                    fe.fe.p004if.qw.yj.ad.qw(context2, 50, "read", de2.when + "");
                                }
                                synchronized (fe.this.f1924uk) {
                                    fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "ReadThread handleResponseMessage...");
                                    qwVar = (qw) fe.this.f1923th.remove(Long.valueOf(de2.when));
                                }
                                fe.this.z(de2, qwVar, this.f1937ad);
                            }
                            synchronized (fe.this.f1924uk) {
                                if (fe.this.f1923th.size() != 0) {
                                    fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    fe.this.ddd.ad(de2.when);
                                    fe.this.ddd.qw(this.f1937ad);
                                    fe.this.nn.qw(this.f1937ad);
                                    fe.this.nn.postDelayed(fe.this.ddd, de2.f1952ad);
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (!fe.this.ppp) {
                            fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "ReadThread exception: " + e, e);
                            boolean unused = fe.this.f1918fe = false;
                            fe feVar = fe.this;
                            feVar.r("ReadThread exception: " + e, this.f1937ad);
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    if (!fe.this.ppp) {
                        fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "onStartCommand", e2);
                        boolean unused2 = fe.this.f1918fe = false;
                        fe feVar2 = fe.this;
                        feVar2.r("onStartCommand:" + e2, this.f1937ad);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$pf */
    public class pf extends Thread {

        /* renamed from: ad  reason: collision with root package name */
        public String f1939ad;

        public pf(String str) {
            this.f1939ad = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        public void run() {
            while (!fe.this.ppp) {
                try {
                    qw qwVar = null;
                    try {
                        synchronized (fe.this.f1922rg) {
                            if (fe.this.f1922rg.size() == 0) {
                                fe.this.f1922rg.wait();
                            } else {
                                qwVar = (qw) fe.this.f1922rg.removeFirst();
                            }
                        }
                    } catch (InterruptedException e) {
                        fe.fe.p004if.qw.yj.fe.ad("SocketTransceiver", "SendThread wait exception: " + e);
                        fe feVar = fe.this;
                        feVar.r("SendThread wait exception: " + e, this.f1939ad);
                    }
                    if (qwVar != null) {
                        try {
                            if (fe.this.ppp) {
                                fe.this.A(qwVar.when, this.f1939ad);
                                return;
                            }
                            qwVar.f46switch = true;
                            qwVar.f1956o = fe.a.qw;
                            if (qwVar.ppp) {
                                synchronized (fe.this.f1924uk) {
                                    if (fe.this.f1923th.isEmpty()) {
                                        fe.this.nn.removeCallbacks(fe.this.ddd);
                                        fe.this.ddd.ad(qwVar.when);
                                        fe.this.ddd.qw(this.f1939ad);
                                        fe.this.nn.qw(this.f1939ad);
                                        fe.this.nn.postDelayed(fe.this.ddd, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                                    }
                                }
                            }
                            fe.fe.p004if.qw.yj.fe.rg("SocketTransceiver", "SendThread :" + qwVar.toString());
                            if (qwVar.f45if) {
                                fe.fe.p004if.qw.qw.fe.qqq(fe.this.vvv, "17N", "Send LoginMsg request");
                            }
                            if (qwVar.f1955i == 1 && qwVar.f1960uk == 4) {
                                Context context = fe.this.vvv;
                                fe.fe.p004if.qw.yj.ad.qw(context, 1, "send", qwVar.when + "");
                            }
                            if (qwVar.f1955i == 50 && qwVar.f1960uk == 2) {
                                Context context2 = fe.this.vvv;
                                fe.fe.p004if.qw.yj.ad.qw(context2, 50, "send", qwVar.when + "");
                            }
                            synchronized (fe.this.f1925yj) {
                                fe.this.xxx.th(qwVar);
                            }
                            if (!qwVar.f1957pf && qwVar.ppp) {
                                synchronized (fe.this.f1924uk) {
                                    fe.this.f1923th.put(Long.valueOf(qwVar.when), qwVar);
                                }
                            }
                        } catch (Exception e2) {
                            fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "SendThread sendMessage Exception:", e2);
                            fe.this.w(qwVar.when, e2.toString(), this.f1939ad);
                            fe feVar2 = fe.this;
                            feVar2.r("SendThread sendMessage Exception:" + e2, this.f1939ad);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "SendThread Exception:", e3);
                    fe feVar3 = fe.this;
                    feVar3.r("SendThread Exception:" + e3, this.f1939ad);
                    return;
                }
            }
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$qw */
    public class qw implements DNSUrlProvider.IGetUrlAsyncListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1941ad;
        public final /* synthetic */ String qw;

        public qw(String str, String str2) {
            this.qw = str;
            this.f1941ad = str2;
        }

        public void qw(int i2, String str, String str2) {
            fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "-----try to connect ip:" + str2);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.qw;
            }
            fe feVar = fe.this;
            feVar.aaa = str2;
            Context context = feVar.vvv;
            fe.fe.p004if.qw.qw.fe.qqq(context, "14N_0", "socketConnect :" + fe.this.aaa);
            if (i2 == 0) {
                fe.fe.p004if.qw.th.qw qw2 = fe.fe.p004if.qw.th.qw.qw(fe.this.vvv);
                fe feVar2 = fe.this;
                qw2.ad(new th(str2, this.f1941ad, Integer.valueOf(feVar2.f1916ad.incrementAndGet())));
            }
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$rg */
    public static /* synthetic */ class rg {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.baidu.lcp.sdk.client.bean.BLCPRequest$SendTimeoutSecond[] r0 = com.baidu.lcp.sdk.client.bean.BLCPRequest.SendTimeoutSecond.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.baidu.lcp.sdk.client.bean.BLCPRequest$SendTimeoutSecond r1 = com.baidu.lcp.sdk.client.bean.BLCPRequest.SendTimeoutSecond.TIMEOUT_20s     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.lcp.sdk.client.bean.BLCPRequest$SendTimeoutSecond r1 = com.baidu.lcp.sdk.client.bean.BLCPRequest.SendTimeoutSecond.TIMEOUT_30s     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.lcp.sdk.client.bean.BLCPRequest$SendTimeoutSecond r1 = com.baidu.lcp.sdk.client.bean.BLCPRequest.SendTimeoutSecond.TIMEOUT_50s     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.lcp.sdk.client.bean.BLCPRequest$SendTimeoutSecond r1 = com.baidu.lcp.sdk.client.bean.BLCPRequest.SendTimeoutSecond.TIMEOUT_120s     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.p004if.qw.de.fe.rg.<clinit>():void");
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$th */
    public final class th implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public String f1943ad;

        /* renamed from: th  reason: collision with root package name */
        public String f1944th;

        /* renamed from: yj  reason: collision with root package name */
        public Integer f1946yj;

        public th(String str, String str2, Integer num) {
            this.f1944th = str;
            this.f1943ad = str2;
            this.f1946yj = num;
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public synchronized void run() {
            /*
                r5 = this;
                monitor-enter(r5)
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                boolean r0 = r0.j()     // Catch:{ Exception -> 0x0286 }
                if (r0 == 0) goto L_0x0012
                java.lang.String r0 = "SocketTransceiver"
                java.lang.String r1 = "socket create begin, but socket has created ok."
                fe.fe.p004if.qw.yj.fe.qw(r0, r1)     // Catch:{ Exception -> 0x0286 }
                monitor-exit(r5)
                return
            L_0x0012:
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$o r0 = r0.f44switch     // Catch:{ Exception -> 0x0286 }
                if (r0 == 0) goto L_0x0036
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$o r0 = r0.f44switch     // Catch:{ Exception -> 0x0286 }
                boolean r0 = r0.isAlive()     // Catch:{ Exception -> 0x0286 }
                if (r0 == 0) goto L_0x0036
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$o r0 = r0.f44switch     // Catch:{ Exception -> 0x0286 }
                r0.interrupt()     // Catch:{ Exception -> 0x0286 }
                java.lang.String r0 = "SocketTransceiver"
                java.lang.String r1 = "readThread interrupt"
                fe.fe.p004if.qw.yj.fe.qw(r0, r1)     // Catch:{ Exception -> 0x0286 }
            L_0x0036:
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$pf r0 = r0.f43if     // Catch:{ Exception -> 0x0286 }
                if (r0 == 0) goto L_0x005a
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$pf r0 = r0.f43if     // Catch:{ Exception -> 0x0286 }
                boolean r0 = r0.isAlive()     // Catch:{ Exception -> 0x0286 }
                if (r0 == 0) goto L_0x005a
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$pf r0 = r0.f43if     // Catch:{ Exception -> 0x0286 }
                r0.interrupt()     // Catch:{ Exception -> 0x0286 }
                java.lang.String r0 = "SocketTransceiver"
                java.lang.String r1 = "sendThread interrupt"
                fe.fe.p004if.qw.yj.fe.qw(r0, r1)     // Catch:{ Exception -> 0x0286 }
            L_0x005a:
                fe.fe.if.qw.de.fe$yj r0 = new fe.fe.if.qw.de.fe$yj     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                java.lang.Integer r2 = r5.f1946yj     // Catch:{ Exception -> 0x0286 }
                java.lang.String r3 = r5.f1944th     // Catch:{ Exception -> 0x0286 }
                r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$uk r1 = r1.nn     // Catch:{ Exception -> 0x0286 }
                java.lang.String r2 = r5.f1944th     // Catch:{ Exception -> 0x0286 }
                r1.qw(r2)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$uk r1 = r1.nn     // Catch:{ Exception -> 0x0286 }
                r2 = 5000(0x1388, double:2.4703E-320)
                r1.postDelayed(r0, r2)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                android.content.Context r1 = r1.vvv     // Catch:{ all -> 0x020b }
                java.lang.String r2 = "14N"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x020b }
                r3.<init>()     // Catch:{ all -> 0x020b }
                java.lang.String r4 = "socketConnect :"
                r3.append(r4)     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.fe r4 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                java.lang.String r4 = r4.aaa     // Catch:{ all -> 0x020b }
                r3.append(r4)     // Catch:{ all -> 0x020b }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x020b }
                fe.fe.p004if.qw.qw.fe.qqq(r1, r2, r3)     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.ad r1 = r1.xxx     // Catch:{ all -> 0x020b }
                java.lang.String r2 = r5.f1944th     // Catch:{ all -> 0x020b }
                java.lang.String r3 = r5.f1943ad     // Catch:{ all -> 0x020b }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x020b }
                int r3 = r3.intValue()     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.de r1 = r1.rg(r2, r3)     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.fe r2 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                boolean r2 = r2.j()     // Catch:{ all -> 0x020b }
                if (r2 == 0) goto L_0x00c7
                java.lang.String r2 = "SocketTransceiver"
                java.lang.String r3 = "socketConnect after, but socket has created ok."
                fe.fe.p004if.qw.yj.fe.qw(r2, r3)     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.fe r2 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                r2.k(r1)     // Catch:{ all -> 0x020b }
                monitor-exit(r5)
                return
            L_0x00c7:
                java.lang.Boolean r2 = r1.f1912ad     // Catch:{ all -> 0x020b }
                boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x020b }
                if (r2 != 0) goto L_0x00fc
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                android.content.Context r1 = r1.vvv     // Catch:{ all -> 0x020b }
                java.lang.String r2 = "15N"
                java.lang.String r3 = "connect env error"
                fe.fe.p004if.qw.qw.fe.qqq(r1, r2, r3)     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                r2 = 401213(0x61f3d, float:5.62219E-40)
                java.lang.String r3 = "connect env error"
                java.lang.String r4 = r5.f1944th     // Catch:{ all -> 0x020b }
                r1.p(r2, r3, r4)     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.fe$uk r1 = r1.nn     // Catch:{ all -> 0x020b }
                r1.removeCallbacks(r0)     // Catch:{ all -> 0x020b }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                java.lang.String r2 = "connect env error:"
                java.lang.String r3 = r5.f1944th     // Catch:{ all -> 0x020b }
                r1.K(r2, r3)     // Catch:{ all -> 0x020b }
                monitor-exit(r5)
                return
            L_0x00fc:
                fe.fe.if.qw.de.fe r2 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x020b }
                java.util.Map r2 = r2.qw     // Catch:{ all -> 0x020b }
                monitor-enter(r2)     // Catch:{ all -> 0x020b }
                java.lang.String r3 = "SocketTransceiver"
                java.lang.String r4 = "socketNeedCloseMap remove connectTimeoutTask"
                fe.fe.p004if.qw.yj.fe.qw(r3, r4)     // Catch:{ all -> 0x0208 }
                fe.fe.if.qw.de.fe r3 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x0208 }
                fe.fe.if.qw.de.fe$uk r3 = r3.nn     // Catch:{ all -> 0x0208 }
                r3.removeCallbacks(r0)     // Catch:{ all -> 0x0208 }
                r0.qw()     // Catch:{ all -> 0x0208 }
                fe.fe.if.qw.de.fe r3 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x0208 }
                boolean r3 = r3.j()     // Catch:{ all -> 0x0208 }
                if (r3 == 0) goto L_0x012d
                java.lang.String r3 = "SocketTransceiver"
                java.lang.String r4 = "socketNeedCloseMap but socket has created ok."
                fe.fe.p004if.qw.yj.fe.qw(r3, r4)     // Catch:{ all -> 0x0208 }
                fe.fe.if.qw.de.fe r3 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x0208 }
                r3.k(r1)     // Catch:{ all -> 0x0208 }
                monitor-exit(r2)     // Catch:{ all -> 0x0208 }
                monitor-exit(r5)
                return
            L_0x012d:
                fe.fe.if.qw.de.fe r3 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x0208 }
                java.util.Map r3 = r3.qw     // Catch:{ all -> 0x0208 }
                java.lang.Integer r4 = r5.f1946yj     // Catch:{ all -> 0x0208 }
                java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0208 }
                if (r3 != 0) goto L_0x014b
                java.lang.String r3 = "SocketTransceiver"
                java.lang.String r4 = "socketNeedCloseMap setCurrentSocketState"
                fe.fe.p004if.qw.yj.fe.qw(r3, r4)     // Catch:{ all -> 0x0208 }
                fe.fe.if.qw.de.fe r3 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x0208 }
                fe.fe.if.qw.de.ad r3 = r3.xxx     // Catch:{ all -> 0x0208 }
                r3.de(r1)     // Catch:{ all -> 0x0208 }
            L_0x014b:
                monitor-exit(r2)     // Catch:{ all -> 0x0208 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                android.content.Context r0 = r0.vvv     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                java.util.concurrent.atomic.AtomicInteger r1 = r1.ggg     // Catch:{ Exception -> 0x0286 }
                int r1 = r1.get()     // Catch:{ Exception -> 0x0286 }
                if (r1 != 0) goto L_0x0160
                r1 = 1
                goto L_0x0161
            L_0x0160:
                r1 = 2
            L_0x0161:
                fe.fe.p004if.qw.yj.rg.tt(r0, r1)     // Catch:{ Exception -> 0x0286 }
                java.lang.String r0 = "SocketTransceiver"
                java.lang.String r1 = "create Socket ok"
                fe.fe.p004if.qw.yj.fe.fe(r0, r1)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                r1 = 401211(0x61f3b, float:5.62216E-40)
                java.lang.String r2 = "connect ok"
                java.lang.String r3 = r5.f1944th     // Catch:{ Exception -> 0x0286 }
                r0.p(r1, r2, r3)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                android.content.Context r0 = r0.vvv     // Catch:{ Exception -> 0x0286 }
                java.lang.String r1 = "16Y"
                java.lang.String r2 = "connect ok"
                fe.fe.p004if.qw.qw.fe.qqq(r0, r1, r2)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                android.content.Context r0 = r0.vvv     // Catch:{ Exception -> 0x0286 }
                java.lang.String r1 = r5.f1944th     // Catch:{ Exception -> 0x0286 }
                com.baidu.lcp.sdk.connect.DNSUrlProvider.uk(r0, r1)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.fe.ad r1 = r1.f1919i     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r2 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                android.content.Context r2 = r2.vvv     // Catch:{ Exception -> 0x0286 }
                r3 = 1
                fe.fe.if.qw.de.qw r1 = r1.ad(r2, r3)     // Catch:{ Exception -> 0x0286 }
                r0.H(r1)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                long r1 = android.os.SystemClock.currentThreadTimeMillis()     // Catch:{ Exception -> 0x0286 }
                long unused = r0.mmm = r1     // Catch:{ Exception -> 0x0286 }
                java.lang.String r0 = "SocketTransceiver"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0286 }
                r1.<init>()     // Catch:{ Exception -> 0x0286 }
                java.lang.String r2 = "connectImpl time:"
                r1.append(r2)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r2 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                long r2 = r2.mmm     // Catch:{ Exception -> 0x0286 }
                r1.append(r2)     // Catch:{ Exception -> 0x0286 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0286 }
                fe.fe.p004if.qw.yj.fe.qw(r0, r1)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.ad.ad r0 = fe.fe.p004if.qw.de.fe.a     // Catch:{ Exception -> 0x0286 }
                r1 = -2
                r0.qw = r1     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                r1 = 0
                boolean unused = r0.ppp = r1     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$pf r1 = new fe.fe.if.qw.de.fe$pf     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r2 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                java.lang.String r3 = r5.f1944th     // Catch:{ Exception -> 0x0286 }
                r1.<init>(r3)     // Catch:{ Exception -> 0x0286 }
                fe.fe.p004if.qw.de.fe.pf unused = r0.f43if = r1     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$pf r0 = r0.f43if     // Catch:{ Exception -> 0x0286 }
                r0.start()     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$o r1 = new fe.fe.if.qw.de.fe$o     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r2 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                java.lang.String r3 = r5.f1944th     // Catch:{ Exception -> 0x0286 }
                r1.<init>(r3)     // Catch:{ Exception -> 0x0286 }
                fe.fe.p004if.qw.de.fe.o unused = r0.f44switch = r1     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$o r0 = r0.f44switch     // Catch:{ Exception -> 0x0286 }
                r0.start()     // Catch:{ Exception -> 0x0286 }
                goto L_0x029b
            L_0x0208:
                r1 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0208 }
                throw r1     // Catch:{ all -> 0x020b }
            L_0x020b:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0286 }
                r2.<init>()     // Catch:{ Exception -> 0x0286 }
                java.lang.String r3 = "Throwable : "
                r2.append(r3)     // Catch:{ Exception -> 0x0286 }
                r2.append(r1)     // Catch:{ Exception -> 0x0286 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0286 }
                java.lang.String r3 = "SocketTransceiver"
                fe.fe.p004if.qw.yj.fe.de(r3, r2, r1)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                android.content.Context r1 = r1.vvv     // Catch:{ Exception -> 0x0286 }
                java.lang.String r3 = "16N"
                fe.fe.p004if.qw.qw.fe.qqq(r1, r3, r2)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                r3 = 401215(0x61f3f, float:5.62222E-40)
                java.lang.String r4 = r5.f1944th     // Catch:{ Exception -> 0x0286 }
                r1.p(r3, r2, r4)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe$uk r1 = r1.nn     // Catch:{ Exception -> 0x0286 }
                r1.removeCallbacks(r0)     // Catch:{ Exception -> 0x0286 }
                r0.qw()     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                java.util.Map r0 = r0.qw     // Catch:{ Exception -> 0x0286 }
                monitor-enter(r0)     // Catch:{ Exception -> 0x0286 }
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x0281 }
                java.util.Map r1 = r1.qw     // Catch:{ all -> 0x0281 }
                java.lang.Integer r3 = r5.f1946yj     // Catch:{ all -> 0x0281 }
                java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x0281 }
                if (r1 == 0) goto L_0x0266
                fe.fe.if.qw.de.fe r1 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x0281 }
                java.util.Map r1 = r1.qw     // Catch:{ all -> 0x0281 }
                java.lang.Integer r2 = r5.f1946yj     // Catch:{ all -> 0x0281 }
                r1.remove(r2)     // Catch:{ all -> 0x0281 }
                monitor-exit(r0)     // Catch:{ all -> 0x0281 }
                monitor-exit(r5)
                return
            L_0x0266:
                monitor-exit(r0)     // Catch:{ all -> 0x0281 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ Exception -> 0x0286 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0286 }
                r1.<init>()     // Catch:{ Exception -> 0x0286 }
                java.lang.String r3 = "ConnectTask exception:"
                r1.append(r3)     // Catch:{ Exception -> 0x0286 }
                r1.append(r2)     // Catch:{ Exception -> 0x0286 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0286 }
                java.lang.String r2 = r5.f1944th     // Catch:{ Exception -> 0x0286 }
                r0.r(r1, r2)     // Catch:{ Exception -> 0x0286 }
                monitor-exit(r5)
                return
            L_0x0281:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0281 }
                throw r1     // Catch:{ Exception -> 0x0286 }
            L_0x0284:
                r0 = move-exception
                goto L_0x029d
            L_0x0286:
                r0 = move-exception
                java.lang.String r1 = "SocketTransceiver"
                java.lang.String r2 = "connectRunnable"
                fe.fe.p004if.qw.yj.fe.de(r1, r2, r0)     // Catch:{ all -> 0x0284 }
                fe.fe.if.qw.de.fe r0 = fe.fe.p004if.qw.de.fe.this     // Catch:{ all -> 0x0284 }
                android.content.Context r0 = r0.vvv     // Catch:{ all -> 0x0284 }
                java.lang.String r1 = "16N"
                java.lang.String r2 = "connect exception"
                fe.fe.p004if.qw.qw.fe.qqq(r0, r1, r2)     // Catch:{ all -> 0x0284 }
            L_0x029b:
                monitor-exit(r5)
                return
            L_0x029d:
                monitor-exit(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.p004if.qw.de.fe.th.run():void");
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$uk */
    public class uk extends Handler {
        public String qw;

        public uk(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                long j = (long) message.arg1;
                synchronized (fe.this.f1924uk) {
                    fe.this.B(j, this.qw);
                }
            }
        }

        public void qw(String str) {
            this.qw = str;
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$yj */
    public class yj implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public Integer f1948ad;

        /* renamed from: th  reason: collision with root package name */
        public boolean f1949th = false;

        /* renamed from: yj  reason: collision with root package name */
        public String f1951yj;

        public yj(Integer num, String str) {
            this.f1948ad = num;
            this.f1951yj = str;
        }

        public void qw() {
            this.f1949th = true;
        }

        public void run() {
            synchronized (fe.this.qw) {
                if (!this.f1949th) {
                    if (fe.a.qw != 0) {
                        fe.this.qw.put(this.f1948ad, Boolean.TRUE);
                        Context context = fe.this.vvv;
                        fe.fe.p004if.qw.qw.fe.qqq(context, "14N_1", "socketConnect_timeout :" + fe.this.aaa);
                        fe.this.p(401214, "time out", this.f1951yj);
                        fe.this.r("time out:", this.f1951yj);
                        return;
                    }
                }
                fe.fe.p004if.qw.yj.fe.ad("SocketTransceiver", "ConnectTimeOutTask has stoped");
                fe.this.nn.removeCallbacks(this);
            }
        }
    }

    public fe(Context context) {
        this.vvv = context;
    }

    public static synchronized fe v(Context context) {
        fe feVar;
        synchronized (fe.class) {
            if (b == null) {
                b = new fe(context.getApplicationContext());
            }
            feVar = b;
        }
        return feVar;
    }

    public final void A(long j, String str) {
        try {
            if (this.f1923th.size() > 0 && this.f1923th.containsKey(Long.valueOf(j))) {
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "handle msg socket stoped!!! " + this.f1923th.get(Long.valueOf(j)).toString());
                qw remove = this.f1923th.remove(Long.valueOf(j));
                if (remove != null) {
                    remove.f1953de = 8006;
                    remove.f1954fe = "socket stopped :";
                    z(remove, remove, str);
                }
            }
        } catch (Exception e) {
            fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "handle msg socket stoped!!! " + e);
        }
    }

    public final void B(long j, String str) {
        try {
            if (this.f1923th.size() > 0 && this.f1923th.containsKey(Long.valueOf(j))) {
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "handle msg timeout!!! " + this.f1923th.get(Long.valueOf(j)).toString());
                qw remove = this.f1923th.remove(Long.valueOf(j));
                if (remove != null) {
                    remove.f1953de = 8004;
                    remove.f1954fe = "socket timeout";
                    z(remove, remove, str);
                }
            }
        } catch (Exception e) {
            fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "handle msg timeout!!! " + e);
        }
    }

    public void C() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", a.qw);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.vvv).sendBroadcast(intent);
    }

    public final synchronized void D(qw qwVar) {
        BLCPResponse bLCPResponse = null;
        try {
            Long valueOf = Long.valueOf(!qwVar.f1958rg ? qwVar.when : (qwVar.f1960uk * 10000) + qwVar.f1955i);
            fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + qwVar.when + ", invoke keys :" + this.f1920o.keySet().toString() + ", notify keys :" + this.f1921pf.keySet().toString());
            if (this.f1921pf.size() > 0 && this.f1921pf.containsKey(valueOf)) {
                bLCPResponse = this.f1921pf.get(valueOf);
            } else if (this.f1920o.size() > 0 && this.f1920o.containsKey(valueOf)) {
                bLCPResponse = this.f1920o.remove(valueOf);
            }
            if (bLCPResponse != null) {
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "onBLCPResponse methodId :" + qwVar.f1955i + ", serviceId :" + qwVar.f1960uk + ", error :" + qwVar.f1953de + ", msgId :" + qwVar.when + ", errMsg :" + qwVar.f1954fe + ", invoke keys :" + this.f1920o.keySet().toString());
                bLCPResponse.qw(qwVar.f1953de, qwVar.f1954fe, qwVar.f1960uk, qwVar.f1955i, qwVar.when, qwVar.f1959th);
                if (qwVar.f1953de == 1011) {
                    fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "onBLCPResponse errorCode :" + qwVar.f1953de + ", and will send lcm login msg .");
                    H(this.f1919i.ad(this.vvv, 1));
                }
            }
        } catch (Exception e) {
            fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "onBLCPResponse Exception!!!", e);
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void E() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r6.qqq     // Catch:{ all -> 0x011d }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x011d }
            if (r0 != 0) goto L_0x0029
            java.lang.String r0 = r6.eee     // Catch:{ all -> 0x011d }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x011d }
            if (r0 != 0) goto L_0x0029
            boolean r0 = com.baidu.lcp.sdk.connect.DNSUrlProvider.rg()     // Catch:{ all -> 0x011d }
            if (r0 == 0) goto L_0x0029
            android.content.Context r0 = r6.vvv     // Catch:{ all -> 0x011d }
            java.lang.String r1 = "10N_2"
            java.lang.String r2 = "connecting"
            fe.fe.p004if.qw.qw.fe.qqq(r0, r1, r2)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = r6.qqq     // Catch:{ all -> 0x011d }
            java.lang.String r1 = r6.eee     // Catch:{ all -> 0x011d }
            r6.m(r0, r1)     // Catch:{ all -> 0x011d }
            monitor-exit(r6)
            return
        L_0x0029:
            int r0 = r6.f1917de     // Catch:{ all -> 0x011d }
            android.content.Context r1 = r6.vvv     // Catch:{ all -> 0x011d }
            int r1 = fe.fe.p004if.qw.yj.rg.i(r1)     // Catch:{ all -> 0x011d }
            r2 = 0
            if (r0 < r1) goto L_0x0036
            r6.f1917de = r2     // Catch:{ all -> 0x011d }
        L_0x0036:
            android.content.Context r0 = r6.vvv     // Catch:{ all -> 0x011d }
            java.lang.String r1 = "10N_1"
            java.lang.String r3 = "connecting"
            fe.fe.p004if.qw.qw.fe.qqq(r0, r1, r3)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = "SocketTransceiver"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r1.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r3 = "protocolOption  thread :"
            r1.append(r3)     // Catch:{ all -> 0x011d }
            int r3 = java.lang.Thread.activeCount()     // Catch:{ all -> 0x011d }
            r1.append(r3)     // Catch:{ all -> 0x011d }
            java.lang.String r3 = ", cur :"
            r1.append(r3)     // Catch:{ all -> 0x011d }
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x011d }
            r1.append(r3)     // Catch:{ all -> 0x011d }
            java.lang.String r3 = "， protocol count :"
            r1.append(r3)     // Catch:{ all -> 0x011d }
            int r3 = r6.f1917de     // Catch:{ all -> 0x011d }
            r1.append(r3)     // Catch:{ all -> 0x011d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x011d }
            fe.fe.p004if.qw.yj.fe.th(r0, r1)     // Catch:{ all -> 0x011d }
            android.content.Context r0 = r6.vvv     // Catch:{ all -> 0x011d }
            int r1 = r6.f1917de     // Catch:{ all -> 0x011d }
            java.lang.String r0 = fe.fe.p004if.qw.yj.rg.uk(r0, r1)     // Catch:{ all -> 0x011d }
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ all -> 0x011d }
            int r1 = r0.length     // Catch:{ all -> 0x011d }
            r3 = 3
            if (r1 >= r3) goto L_0x0083
            monitor-exit(r6)
            return
        L_0x0083:
            r1 = r0[r2]     // Catch:{ all -> 0x011d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x011d }
            if (r1 == 0) goto L_0x008e
            java.lang.String r1 = "tcp"
            goto L_0x0090
        L_0x008e:
            r1 = r0[r2]     // Catch:{ all -> 0x011d }
        L_0x0090:
            r2 = 1
            r3 = r0[r2]     // Catch:{ all -> 0x011d }
            r4 = 2
            r0 = r0[r4]     // Catch:{ all -> 0x011d }
            java.lang.String r4 = "quic"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x011d }
            if (r4 == 0) goto L_0x00ae
            fe.fe.if.qw.de.ad r4 = r6.xxx     // Catch:{ all -> 0x011d }
            boolean r4 = r4 instanceof com.baidu.lcp.sdk.connect.QuicMessageHandler     // Catch:{ all -> 0x011d }
            if (r4 != 0) goto L_0x00ae
            com.baidu.lcp.sdk.connect.QuicMessageHandler r4 = new com.baidu.lcp.sdk.connect.QuicMessageHandler     // Catch:{ all -> 0x011d }
            android.content.Context r5 = r6.vvv     // Catch:{ all -> 0x011d }
            r4.<init>(r5)     // Catch:{ all -> 0x011d }
            r6.xxx = r4     // Catch:{ all -> 0x011d }
            goto L_0x00cd
        L_0x00ae:
            java.lang.String r4 = "tcp"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x011d }
            if (r4 != 0) goto L_0x00c4
            java.lang.String r4 = "tls"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x011d }
            if (r4 == 0) goto L_0x00cd
            fe.fe.if.qw.de.ad r4 = r6.xxx     // Catch:{ all -> 0x011d }
            boolean r4 = r4 instanceof fe.fe.p004if.qw.de.rg     // Catch:{ all -> 0x011d }
            if (r4 != 0) goto L_0x00cd
        L_0x00c4:
            fe.fe.if.qw.de.rg r4 = new fe.fe.if.qw.de.rg     // Catch:{ all -> 0x011d }
            android.content.Context r5 = r6.vvv     // Catch:{ all -> 0x011d }
            r4.<init>(r5, r1)     // Catch:{ all -> 0x011d }
            r6.xxx = r4     // Catch:{ all -> 0x011d }
        L_0x00cd:
            int r4 = r6.f1917de     // Catch:{ all -> 0x011d }
            int r4 = r4 + r2
            r6.f1917de = r4     // Catch:{ all -> 0x011d }
            fe.fe.if.qw.de.ad r2 = r6.xxx     // Catch:{ all -> 0x011d }
            if (r2 == 0) goto L_0x0110
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x011d }
            if (r2 != 0) goto L_0x0110
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x011d }
            if (r2 != 0) goto L_0x0110
            java.lang.String r2 = "SocketTransceiver"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r4.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r5 = "type :"
            r4.append(r5)     // Catch:{ all -> 0x011d }
            r4.append(r1)     // Catch:{ all -> 0x011d }
            java.lang.String r1 = ", host :"
            r4.append(r1)     // Catch:{ all -> 0x011d }
            r4.append(r3)     // Catch:{ all -> 0x011d }
            java.lang.String r1 = ", port :"
            r4.append(r1)     // Catch:{ all -> 0x011d }
            r4.append(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x011d }
            fe.fe.p004if.qw.yj.fe.qw(r2, r1)     // Catch:{ all -> 0x011d }
            r6.qqq = r3     // Catch:{ all -> 0x011d }
            r6.eee = r0     // Catch:{ all -> 0x011d }
            r6.m(r3, r0)     // Catch:{ all -> 0x011d }
            goto L_0x011b
        L_0x0110:
            java.lang.String r0 = ""
            r6.qqq = r0     // Catch:{ all -> 0x011d }
            java.lang.String r0 = ""
            r6.eee = r0     // Catch:{ all -> 0x011d }
            r6.E()     // Catch:{ all -> 0x011d }
        L_0x011b:
            monitor-exit(r6)
            return
        L_0x011d:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p004if.qw.de.fe.E():void");
    }

    public final void F() {
        this.f1917de = 0;
        this.ggg.set(0);
        DNSUrlProvider.o();
    }

    public final void G(boolean z) {
        try {
            this.ggg.incrementAndGet();
            if (this.ggg.get() <= 10 && a.qw == -1) {
                long l = l(this.ggg.get());
                this.nn.removeCallbacks(this.when);
                this.nn.removeCallbacks(z ? this.rrr : this.tt);
                this.nn.postDelayed(z ? this.tt : this.rrr, l);
                StringBuilder sb = new StringBuilder();
                sb.append("Schedule retry ");
                sb.append(z ? "login" : "connect");
                sb.append(" -- retry times: ");
                sb.append(this.ggg.get());
                sb.append(" time delay: ");
                sb.append(l);
                fe.fe.p004if.qw.yj.fe.fe("SocketTransceiver", sb.toString());
            }
        } catch (Exception e) {
            fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "retry Exception", e);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized void H(fe.fe.p004if.qw.de.qw r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.LinkedList<fe.fe.if.qw.de.qw> r0 = r8.f1922rg     // Catch:{ Exception -> 0x00d5 }
            monitor-enter(r0)     // Catch:{ Exception -> 0x00d5 }
            r1 = 0
            java.util.LinkedList<fe.fe.if.qw.de.qw> r2 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00d0 }
        L_0x000b:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00d0 }
            if (r3 == 0) goto L_0x0035
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00d0 }
            fe.fe.if.qw.de.qw r3 = (fe.fe.p004if.qw.de.qw) r3     // Catch:{ all -> 0x00d0 }
            java.lang.String r4 = "SocketTransceiver"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r5.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r6 = "sendMessage queue :"
            r5.append(r6)     // Catch:{ all -> 0x00d0 }
            long r6 = r3.when     // Catch:{ all -> 0x00d0 }
            r5.append(r6)     // Catch:{ all -> 0x00d0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00d0 }
            fe.fe.p004if.qw.yj.fe.qw(r4, r5)     // Catch:{ all -> 0x00d0 }
            boolean r3 = r3.f45if     // Catch:{ all -> 0x00d0 }
            if (r3 == 0) goto L_0x000b
            r1 = 1
            goto L_0x000b
        L_0x0035:
            boolean r2 = r9.f45if     // Catch:{ all -> 0x00d0 }
            r3 = -1
            if (r2 == 0) goto L_0x0075
            if (r1 != 0) goto L_0x0058
            fe.fe.if.qw.ad.ad r1 = a     // Catch:{ all -> 0x00d0 }
            int r1 = r1.qw     // Catch:{ all -> 0x00d0 }
            if (r1 == r3) goto L_0x0043
            goto L_0x0058
        L_0x0043:
            java.util.LinkedList<fe.fe.if.qw.de.qw> r1 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            r1.addFirst(r9)     // Catch:{ all -> 0x00d0 }
            java.util.LinkedList<fe.fe.if.qw.de.qw> r9 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            r9.notifyAll()     // Catch:{ all -> 0x00d0 }
            android.content.Context r9 = r8.vvv     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = "16Y_2"
            java.lang.String r2 = "send Logig msg"
            fe.fe.p004if.qw.qw.fe.qqq(r9, r1, r2)     // Catch:{ all -> 0x00d0 }
            goto L_0x00ce
        L_0x0058:
            java.lang.String r9 = "SocketTransceiver"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r1.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r2 = "sendMessage cur methodId :1, state :"
            r1.append(r2)     // Catch:{ all -> 0x00d0 }
            fe.fe.if.qw.ad.ad r2 = a     // Catch:{ all -> 0x00d0 }
            int r2 = r2.qw     // Catch:{ all -> 0x00d0 }
            r1.append(r2)     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d0 }
            fe.fe.p004if.qw.yj.fe.ad(r9, r1)     // Catch:{ all -> 0x00d0 }
            monitor-exit(r0)     // Catch:{ all -> 0x00d0 }
            monitor-exit(r8)
            return
        L_0x0075:
            fe.fe.if.qw.ad.ad r2 = a     // Catch:{ all -> 0x00d0 }
            int r2 = r2.qw     // Catch:{ all -> 0x00d0 }
            if (r2 != r3) goto L_0x00c4
            boolean r2 = r8.j()     // Catch:{ all -> 0x00d0 }
            if (r2 == 0) goto L_0x00b7
            java.util.LinkedList<fe.fe.if.qw.de.qw> r2 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            int r2 = r2.size()     // Catch:{ all -> 0x00d0 }
            if (r2 <= 0) goto L_0x008b
            if (r1 != 0) goto L_0x00a8
        L_0x008b:
            java.util.LinkedList<fe.fe.if.qw.de.qw> r1 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            fe.fe.if.qw.fe.ad r2 = r8.f1919i     // Catch:{ all -> 0x00d0 }
            android.content.Context r3 = r8.vvv     // Catch:{ all -> 0x00d0 }
            r4 = 1
            fe.fe.if.qw.de.qw r2 = r2.ad(r3, r4)     // Catch:{ all -> 0x00d0 }
            r1.addFirst(r2)     // Catch:{ all -> 0x00d0 }
            java.util.LinkedList<fe.fe.if.qw.de.qw> r1 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            r1.notifyAll()     // Catch:{ all -> 0x00d0 }
            android.content.Context r1 = r8.vvv     // Catch:{ all -> 0x00d0 }
            java.lang.String r2 = "16Y_3"
            java.lang.String r3 = "heart rate and send Logig msg"
            fe.fe.p004if.qw.qw.fe.qqq(r1, r2, r3)     // Catch:{ all -> 0x00d0 }
        L_0x00a8:
            boolean r1 = r9.f1957pf     // Catch:{ all -> 0x00d0 }
            if (r1 != 0) goto L_0x00ce
            java.util.LinkedList<fe.fe.if.qw.de.qw> r1 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            r1.add(r9)     // Catch:{ all -> 0x00d0 }
            java.util.LinkedList<fe.fe.if.qw.de.qw> r9 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            r9.notifyAll()     // Catch:{ all -> 0x00d0 }
            goto L_0x00ce
        L_0x00b7:
            boolean r1 = r9.f1957pf     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x00be
            r8.E()     // Catch:{ all -> 0x00d0 }
        L_0x00be:
            java.util.LinkedList<fe.fe.if.qw.de.qw> r1 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            r1.add(r9)     // Catch:{ all -> 0x00d0 }
            goto L_0x00ce
        L_0x00c4:
            java.util.LinkedList<fe.fe.if.qw.de.qw> r1 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            r1.add(r9)     // Catch:{ all -> 0x00d0 }
            java.util.LinkedList<fe.fe.if.qw.de.qw> r9 = r8.f1922rg     // Catch:{ all -> 0x00d0 }
            r9.notifyAll()     // Catch:{ all -> 0x00d0 }
        L_0x00ce:
            monitor-exit(r0)     // Catch:{ all -> 0x00d0 }
            goto L_0x00dd
        L_0x00d0:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d0 }
            throw r9     // Catch:{ Exception -> 0x00d5 }
        L_0x00d3:
            r9 = move-exception
            goto L_0x00df
        L_0x00d5:
            r9 = move-exception
            java.lang.String r0 = "SocketTransceiver"
            java.lang.String r1 = "sendMessage Exception :"
            fe.fe.p004if.qw.yj.fe.de(r0, r1, r9)     // Catch:{ all -> 0x00d3 }
        L_0x00dd:
            monitor-exit(r8)
            return
        L_0x00df:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p004if.qw.de.fe.H(fe.fe.if.qw.de.qw):void");
    }

    public final void I(long j, long j2, long j3, boolean z, BLCPResponse bLCPResponse) {
        Long valueOf = Long.valueOf(j3);
        if (!z) {
            this.f1920o.put(valueOf, bLCPResponse);
        } else if (bLCPResponse != null) {
            this.f1921pf.put(valueOf, bLCPResponse);
        }
        fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "isNotify:" + z + ", methodId:" + j2 + ", invoke keys :" + this.f1920o.keySet().toString() + ", notify keys :" + this.f1921pf.keySet().toString());
    }

    public void J() {
        if (fe.fe.p004if.qw.yj.rg.m115switch(this.vvv)) {
            F();
            n();
        }
    }

    public synchronized void K(String str, String str2) {
        if (fe.fe.p004if.qw.yj.rg.m115switch(this.vvv)) {
            fe.fe.p004if.qw.yj.fe.fe("SocketTransceiver", "---socketDisconnect---");
            this.ppp = true;
            this.f1918fe = true;
            s(str2);
            F();
            this.nn.removeCallbacks(this.rrr);
            this.nn.removeCallbacks(this.tt);
            this.nn.removeCallbacks(this.when);
            DNSUrlProvider.i(this.vvv, (String) null, false);
            q(str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void h(com.baidu.lcp.sdk.client.bean.BLCPRequest r13, com.baidu.lcp.sdk.client.bean.BLCPResponse r14) {
        /*
            r12 = this;
            monitor-enter(r12)
            android.content.Context r1 = r12.vvv     // Catch:{ all -> 0x0087 }
            boolean r1 = fe.fe.p004if.qw.yj.rg.m115switch(r1)     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r12)
            return
        L_0x000b:
            fe.fe.if.qw.de.qw r10 = new fe.fe.if.qw.de.qw     // Catch:{ all -> 0x0087 }
            r10.<init>()     // Catch:{ all -> 0x0087 }
            long r1 = r13.qw     // Catch:{ all -> 0x0087 }
            r10.f1960uk = r1     // Catch:{ all -> 0x0087 }
            long r1 = r13.f866ad     // Catch:{ all -> 0x0087 }
            r10.f1955i = r1     // Catch:{ all -> 0x0087 }
            byte[] r1 = r13.f867de     // Catch:{ all -> 0x0087 }
            r10.qw = r1     // Catch:{ all -> 0x0087 }
            long r1 = r13.f868fe     // Catch:{ all -> 0x0087 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x002b
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0087 }
            r10.when = r1     // Catch:{ all -> 0x0087 }
            goto L_0x002f
        L_0x002b:
            long r1 = r13.f868fe     // Catch:{ all -> 0x0087 }
            r10.when = r1     // Catch:{ all -> 0x0087 }
        L_0x002f:
            int[] r1 = fe.fe.p004if.qw.de.fe.rg.qw     // Catch:{ all -> 0x0087 }
            com.baidu.lcp.sdk.client.bean.BLCPRequest$SendTimeoutSecond r2 = r13.f869rg     // Catch:{ all -> 0x0087 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0087 }
            r1 = r1[r2]     // Catch:{ all -> 0x0087 }
            r11 = 1
            if (r1 == r11) goto L_0x0052
            r2 = 2
            if (r1 == r2) goto L_0x004d
            r2 = 3
            if (r1 == r2) goto L_0x0047
            r1 = 5000(0x1388, double:2.4703E-320)
            r10.f1952ad = r1     // Catch:{ all -> 0x0087 }
            goto L_0x0056
        L_0x0047:
            r1 = 50000(0xc350, double:2.47033E-319)
            r10.f1952ad = r1     // Catch:{ all -> 0x0087 }
            goto L_0x0056
        L_0x004d:
            r1 = 30000(0x7530, double:1.4822E-319)
            r10.f1952ad = r1     // Catch:{ all -> 0x0087 }
            goto L_0x0056
        L_0x0052:
            r1 = 20000(0x4e20, double:9.8813E-320)
            r10.f1952ad = r1     // Catch:{ all -> 0x0087 }
        L_0x0056:
            boolean r0 = r13 instanceof fe.fe.p004if.qw.ad.fe.qw     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0071
            long r0 = r10.f1960uk     // Catch:{ all -> 0x0087 }
            r2 = 10000(0x2710, double:4.9407E-320)
            long r0 = r0 * r2
            long r2 = r10.f1955i     // Catch:{ all -> 0x0087 }
            long r6 = r0 + r2
            r10.when = r6     // Catch:{ all -> 0x0087 }
            long r2 = r10.f1960uk     // Catch:{ all -> 0x0087 }
            long r4 = r10.f1955i     // Catch:{ all -> 0x0087 }
            r8 = 1
            r1 = r12
            r9 = r14
            r1.I(r2, r4, r6, r8, r9)     // Catch:{ all -> 0x0087 }
            goto L_0x0085
        L_0x0071:
            long r2 = r10.f1960uk     // Catch:{ all -> 0x0087 }
            long r4 = r10.f1955i     // Catch:{ all -> 0x0087 }
            long r6 = r10.when     // Catch:{ all -> 0x0087 }
            r8 = 0
            r1 = r12
            r9 = r14
            r1.I(r2, r4, r6, r8, r9)     // Catch:{ all -> 0x0087 }
            fe.fe.if.qw.fe.ad r0 = r12.f1919i     // Catch:{ all -> 0x0087 }
            r0.qw(r10, r11)     // Catch:{ all -> 0x0087 }
            r12.H(r10)     // Catch:{ all -> 0x0087 }
        L_0x0085:
            monitor-exit(r12)
            return
        L_0x0087:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p004if.qw.de.fe.h(com.baidu.lcp.sdk.client.bean.BLCPRequest, com.baidu.lcp.sdk.client.bean.BLCPResponse):void");
    }

    public final boolean j() {
        ad adVar = this.xxx;
        return (adVar == null || adVar.qw() == null || this.xxx.qw().f1913de == null || !this.xxx.qw().f1913de.isConnected()) ? false : true;
    }

    public final void k(de deVar) {
        if (deVar != null && deVar.qw.booleanValue()) {
            try {
                if (deVar.f1913de == null) {
                    return;
                }
                if (deVar.f1913de.hashCode() == this.xxx.qw().f1913de.hashCode()) {
                    fe.fe.p004if.qw.yj.fe.rg("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                    return;
                }
                deVar.f1913de.close();
                deVar.f1913de = null;
                if (deVar.f1914fe != null) {
                    deVar.f1914fe.close();
                    deVar.f1914fe = null;
                }
                if (deVar.f1915rg != null) {
                    deVar.f1915rg.close();
                    deVar.f1915rg = null;
                }
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "closeExistedConnection ok");
            } catch (IOException e) {
                fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "closeExistedConnection :" + e.getMessage(), e);
            }
        }
    }

    public final long l(int i2) {
        if (i2 < 3) {
            return (long) (i2 * 1000);
        }
        return 3000;
    }

    public final synchronized void m(String str, String str2) {
        fe.fe.p004if.qw.qw.fe.qqq(this.vvv, "10Y", "DNS begin");
        DNSUrlProvider.fe(this.vvv).ad(str, new qw(str, str2));
    }

    public final synchronized void n() {
        if (!RequsetNetworkUtils.isConnected(this.vvv)) {
            F();
            return;
        }
        if (a.qw != 0) {
            if (a.qw != -2) {
                fe.fe.p004if.qw.qw.fe.qqq(this.vvv, "10N_0", "connect begin");
                this.nn.removeCallbacks(this.rrr);
                this.nn.removeCallbacks(this.tt);
                this.nn.removeCallbacks(this.when);
                E();
                return;
            }
        }
        fe.fe.p004if.qw.yj.fe.fe("SocketTransceiver", "connectImpl connect state:" + a.qw);
        Context context = this.vvv;
        fe.fe.p004if.qw.qw.fe.qqq(context, "17N_2", "connectState is " + a.qw);
    }

    public final void p(int i2, String str, String str2) {
        this.aaa += ":" + DNSUrlProvider.de();
        fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "connectTrack ext:" + this.aaa + ", retry :" + this.ggg.get() + ", reason :" + str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        fe.fe.p004if.qw.th.qw.qw(this.vvv).ad(new ad(i2, str, str2));
        this.aaa = "";
    }

    public final synchronized void q(String str, String str2) {
        if (fe.fe.p004if.qw.yj.rg.m115switch(this.vvv)) {
            fe.fe.p004if.qw.yj.fe.fe("SocketTransceiver", "destroy");
            p(401212, "connect stop, " + str, str2);
            a.qw = -1;
            setChanged();
            notifyObservers(a);
            C();
            this.nn.removeCallbacks(this.ddd);
            this.ppp = true;
            if (this.xxx != null) {
                synchronized (this.f1922rg) {
                    this.f1922rg.notifyAll();
                    fe.fe.p004if.qw.yj.fe.fe("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.xxx.fe();
                    fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e) {
                    this.xxx.de((de) null);
                    fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "Exception destroy:", e);
                }
            }
        } else {
            return;
        }
        return;
    }

    public final synchronized void r(String str, String str2) {
        fe.fe.p004if.qw.yj.fe.fe("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f1918fe + ", net :" + RequsetNetworkUtils.isConnected(this.vvv) + ", isSmallFlow :" + fe.fe.p004if.qw.yj.rg.m115switch(this.vvv));
        if (fe.fe.p004if.qw.yj.rg.m115switch(this.vvv)) {
            s(str2);
            if (this.f1918fe) {
                F();
                return;
            }
            q(str, str2);
            if (!RequsetNetworkUtils.isConnected(this.vvv)) {
                F();
            } else {
                G(false);
            }
        }
    }

    public final void s(String str) {
        try {
            fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.f1922rg) {
                while (this.f1922rg.size() > 0) {
                    t(this.f1922rg.removeFirst(), str);
                }
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.f1924uk) {
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.f1923th.keySet()) {
                    t(this.f1923th.get(l), str);
                }
                this.f1923th.clear();
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "fatalAllMessage mSync end");
            }
        } catch (Exception e) {
            fe.fe.p004if.qw.yj.fe.de("SocketTransceiver", "fatalAllMessage Exception", e);
        }
    }

    public final void t(qw qwVar, String str) {
        if (qwVar != null && qwVar.f1960uk != 1) {
            fe.fe.p004if.qw.yj.fe.ad("SocketTransceiver", "fetalAndClearAllMsgs :" + qwVar.when + ", serviceId :" + qwVar.f1960uk + ", methodId :" + qwVar.f1955i);
            z(new qw(), qwVar, str);
        }
    }

    public fe.fe.p004if.qw.ad.ad u() {
        return a;
    }

    public final void w(long j, String str, String str2) {
        try {
            if (this.f1923th.size() > 0 && this.f1923th.containsKey(Long.valueOf(j))) {
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "handle msg exception!!! " + this.f1923th.get(Long.valueOf(j)).toString());
                qw remove = this.f1923th.remove(Long.valueOf(j));
                if (remove != null) {
                    remove.f1953de = 8005;
                    remove.f1954fe = "socket exception :" + str;
                    z(remove, remove, str2);
                }
            }
        } catch (Exception e) {
            fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "handle msg exception!!! " + e);
        }
    }

    public final void x(qw qwVar, String str) {
        int i2;
        int i3 = qwVar.f1953de;
        long j = 60000;
        if (i3 == 0) {
            long j2 = qwVar.f1961yj;
            if (j2 > 0) {
                j = j2;
            }
            long j3 = qwVar.f1955i;
            if (j3 == 1) {
                y(j, true, str);
            } else if (j3 == 2) {
                K("LCP logout:", str);
                a.qw = qwVar.f1956o;
                setChanged();
                notifyObservers(a);
                C();
            } else if (j3 == 3) {
                this.when.qw(j);
            }
        } else if (String.valueOf(i3).startsWith("30") || (i2 = qwVar.f1953de) == 1011) {
            fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "login error, then request token, error :" + qwVar.f1953de);
            K("errorCode:" + String.valueOf(qwVar.f1953de), str);
            fe.fe.p004if.qw.yj.rg.eee(this.vvv, "");
            fe.fe.p004if.qw.ad.de.th().pf();
        } else if (i2 == 1012) {
            fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "login error :" + qwVar.f1953de);
        } else if (i2 == 1013) {
            y(60000, false, str);
        } else {
            a.qw = -1;
            setChanged();
            notifyObservers(a);
            C();
            G(true);
        }
    }

    public final void y(long j, boolean z, String str) {
        try {
            this.ggg.set(0);
            a.qw = 0;
            setChanged();
            notifyObservers(a);
            C();
            if (z) {
                this.nn.qw(str);
                this.nn.postDelayed(this.when, j);
                fe.fe.p004if.qw.yj.fe.qw("SocketTransceiver", "ping every 1分钟 ");
                fe.fe.p004if.qw.qw.fe.qqq(this.vvv, "17Y", "login success");
                qw.fe feVar = new qw.fe(this.vvv);
                feVar.rg("login ok");
                feVar.th("login");
                feVar.yj(System.currentTimeMillis());
                feVar.uk(System.currentTimeMillis());
                feVar.de(0);
                feVar.fe("");
                feVar.qw(501111);
                feVar.ad();
            }
        } catch (Exception e) {
            fe.fe.p004if.qw.yj.fe.ad("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e);
        }
    }

    public final void z(qw qwVar, qw qwVar2, String str) {
        long j = qwVar.f1960uk;
        if (j == 1) {
            x(qwVar, str);
        } else if (j != -1) {
            D(qwVar);
        } else if (qwVar2 != null) {
            if (qwVar2.f1960uk == 1) {
                x(qwVar2, str);
            } else {
                D(qwVar2);
            }
        }
    }

    /* renamed from: fe.fe.if.qw.de.fe$i */
    public class i implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public long f1932ad;

        public i() {
            this.f1932ad = 60000;
        }

        public void qw(long j) {
            this.f1932ad = j;
        }

        public void run() {
            fe.this.nn.removeCallbacks(fe.this.when);
            if (fe.fe.p004if.qw.yj.rg.m115switch(fe.this.vvv)) {
                fe.this.nn.postDelayed(fe.this.when, this.f1932ad);
                fe feVar = fe.this;
                feVar.H(feVar.f1919i.ad(fe.this.vvv, 3));
            }
        }

        public /* synthetic */ i(fe feVar, qw qwVar) {
            this();
        }
    }
}
