package com.baidu.lcp.sdk.connect;

import android.content.Context;
import com.baidu.lcp.sdk.request.HttpExecutor;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import fe.fe.p004if.qw.yj.fe;
import fe.fe.p004if.qw.yj.rg;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class DNSUrlProvider {

    /* renamed from: ad  reason: collision with root package name */
    public static Context f870ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static List<String> f871de = Collections.synchronizedList(new ArrayList());

    /* renamed from: fe  reason: collision with root package name */
    public static int f872fe = 0;
    public static int qw = 2;

    public interface DNSUrlProviderInternal {
        void ad(String str, IGetUrlAsyncListener iGetUrlAsyncListener);

        void qw(String str, boolean z);
    }

    public interface IGetUrlAsyncListener {
        void qw(int i2, String str, String str2);
    }

    public static class ad implements DNSUrlProviderInternal {
        public static ad qw;

        public static synchronized DNSUrlProviderInternal de() {
            ad adVar;
            synchronized (ad.class) {
                if (qw == null) {
                    qw = new ad();
                }
                adVar = qw;
            }
            return adVar;
        }

        public void ad(String str, IGetUrlAsyncListener iGetUrlAsyncListener) {
            fe.fe("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "12N", "DefaultUrlProvider begin");
            if (iGetUrlAsyncListener != null) {
                DNSUrlProvider.o();
                fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "12Y", "DefaultUrlProvider begin");
                iGetUrlAsyncListener.qw(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, str);
            }
        }

        public void qw(String str, boolean z) {
        }
    }

    public static class de implements DNSUrlProviderInternal {
        public static de qw;

        public de(Context context) {
            Context unused = DNSUrlProvider.f870ad = context.getApplicationContext();
        }

        public static synchronized de de(Context context) {
            de deVar;
            synchronized (de.class) {
                if (qw == null) {
                    qw = new de(context);
                }
                deVar = qw;
            }
            return deVar;
        }

        public void ad(String str, IGetUrlAsyncListener iGetUrlAsyncListener) {
            fe.qw("DNSUrlProvider", "will getLCPHttpDnsAddress......");
            try {
                fe.fe.p004if.qw.rg.ad adVar = new fe.fe.p004if.qw.rg.ad(DNSUrlProvider.f870ad);
                adVar.rg(iGetUrlAsyncListener);
                HttpExecutor.rg(adVar, adVar);
            } catch (Exception unused) {
                DNSUrlProvider.yj(true);
                DNSUrlProvider.fe(DNSUrlProvider.f870ad).ad(str, iGetUrlAsyncListener);
            }
        }

        public void qw(String str, boolean z) {
        }
    }

    public static class qw implements DNSUrlProviderInternal {
        public static qw qw;

        /* renamed from: com.baidu.lcp.sdk.connect.DNSUrlProvider$qw$qw  reason: collision with other inner class name */
        public class C0033qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ String f873ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ Timer f874th;

            /* renamed from: yj  reason: collision with root package name */
            public final /* synthetic */ IGetUrlAsyncListener f875yj;

            /* renamed from: com.baidu.lcp.sdk.connect.DNSUrlProvider$qw$qw$qw  reason: collision with other inner class name */
            public class C0034qw extends TimerTask {

                /* renamed from: ad  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f876ad;

                public C0034qw(AtomicBoolean atomicBoolean) {
                    this.f876ad = atomicBoolean;
                }

                public void run() {
                    fe.qw("DNSUrlProvider", "bddns > bdDnsIps is null");
                    fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "11N_3", "BDDNS timeout");
                    IGetUrlAsyncListener iGetUrlAsyncListener = C0033qw.this.f875yj;
                    if (iGetUrlAsyncListener != null) {
                        iGetUrlAsyncListener.qw(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        DNSUrlProvider.yj(true);
                        DNSUrlProviderInternal fe2 = DNSUrlProvider.fe(DNSUrlProvider.f870ad);
                        C0033qw qwVar = C0033qw.this;
                        fe2.ad(qwVar.f873ad, qwVar.f875yj);
                    }
                    this.f876ad.set(true);
                }
            }

            public C0033qw(qw qwVar, String str, Timer timer, IGetUrlAsyncListener iGetUrlAsyncListener) {
                this.f873ad = str;
                this.f874th = timer;
                this.f875yj = iGetUrlAsyncListener;
            }

            public void run() {
                fe.qw("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f873ad);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f874th.schedule(new C0034qw(atomicBoolean), 10000);
                try {
                    DnsHelper dnsHelper = new DnsHelper(DNSUrlProvider.f870ad);
                    dnsHelper.setHttpDnsState(false, (HttpDNSStat) null, false, true);
                    DNSUrlProvider.pf(dnsHelper.getIpList(this.f873ad));
                    fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "11N_1", "BDDNS get ips");
                    List<String> list = DNSUrlProvider.f871de;
                    if (list != null && list.size() > 0) {
                        fe.qw("DNSUrlProvider", "bddns > bdDnsIps = " + DNSUrlProvider.f871de);
                        String str = DNSUrlProvider.f871de.get(0);
                        fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "11Y", "BDDNS success");
                        if (this.f875yj != null && !atomicBoolean.get()) {
                            this.f875yj.qw(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, str);
                            if (DNSUrlProvider.f871de.size() > 1) {
                                DNSUrlProvider.f872fe++;
                                DNSUrlProvider.yj(false);
                            }
                        }
                        fe.qw("DNSUrlProvider", "bddns > return ip = " + str);
                        this.f874th.cancel();
                    }
                } catch (UnknownHostException unused) {
                    fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "11N_3", "DnsHelper exception, HTTPDNS begin");
                    fe.qw("DNSUrlProvider", "bddns > DnsHelper get exception ");
                    DNSUrlProvider.yj(true);
                    DNSUrlProvider.fe(DNSUrlProvider.f870ad).ad(this.f873ad, this.f875yj);
                }
            }
        }

        public qw(Context context) {
            Context unused = DNSUrlProvider.f870ad = context.getApplicationContext();
            DNSUrlProvider.o();
        }

        public static synchronized qw de(Context context) {
            qw qwVar;
            synchronized (qw.class) {
                if (qw == null) {
                    qw = new qw(context);
                }
                qwVar = qw;
            }
            return qwVar;
        }

        public void ad(String str, IGetUrlAsyncListener iGetUrlAsyncListener) {
            try {
                fe.fe("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (DNSUrlProvider.f871de == null || DNSUrlProvider.f871de.size() <= 0) {
                    fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "11N", "BDDNS begin");
                    fe.fe.p004if.qw.th.qw.qw(DNSUrlProvider.f870ad).ad(new C0033qw(this, str, new Timer(), iGetUrlAsyncListener));
                } else if (DNSUrlProvider.f872fe < DNSUrlProvider.f871de.size()) {
                    fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "11Y", "BDDNS retry success");
                    if (iGetUrlAsyncListener != null) {
                        iGetUrlAsyncListener.qw(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, DNSUrlProvider.f871de.get(DNSUrlProvider.f872fe));
                        fe.qw("DNSUrlProvider", "retry bddns > return ip = " + DNSUrlProvider.f871de.get(DNSUrlProvider.f872fe));
                    }
                    DNSUrlProvider.f872fe++;
                } else {
                    DNSUrlProvider.yj(true);
                    DNSUrlProvider.fe(DNSUrlProvider.f870ad).ad(str, iGetUrlAsyncListener);
                }
            } catch (Throwable unused) {
                fe.fe.p004if.qw.qw.fe.qqq(DNSUrlProvider.f870ad, "11N_2", "BDDNS exception, HTTPDNS begin");
                fe.qw("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                DNSUrlProvider.yj(true);
                DNSUrlProvider.fe(DNSUrlProvider.f870ad).ad(str, iGetUrlAsyncListener);
            }
        }

        public void qw(String str, boolean z) {
        }
    }

    public static int de() {
        return qw;
    }

    public static DNSUrlProviderInternal fe(Context context) {
        f870ad = context.getApplicationContext();
        int qw2 = fe.fe.p004if.qw.yj.de.qw(context);
        if (qw2 == 1 || qw2 == 2) {
            qw = 0;
            return ad.de();
        } else if (rg.de(context) && qw == 2) {
            return qw.de(context);
        } else {
            if (qw == 3) {
                return de.de(context);
            }
            return ad.de();
        }
    }

    public static void i(Context context, String str, boolean z) {
        o();
        ad.de().qw(str, true);
    }

    public static void o() {
        try {
            f872fe = 0;
            f871de.clear();
            qw = 2;
        } catch (Exception e) {
            fe.de("DNSUrlProvider", "resetBdDns exception", e);
        }
    }

    public static void pf(List<String> list) {
        f871de.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (th(list.get(i2))) {
                    arrayList.add(list.get(i2));
                } else {
                    arrayList2.add(list.get(i2));
                }
            }
        }
        if (arrayList.size() + arrayList2.size() > 0) {
            int th2 = rg.th(f870ad);
            fe.ad("DNSUrlProvider", "getIpPriority :" + th2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (th2 == 1) {
                f871de.addAll(arrayList2);
            } else if (th2 == 2) {
                f871de.addAll(arrayList2);
                f871de.addAll(arrayList);
            } else if (th2 != 4) {
                f871de.addAll(arrayList);
                f871de.addAll(arrayList2);
            } else {
                f871de.addAll(arrayList);
            }
        }
    }

    public static boolean rg() {
        List<String> list = f871de;
        return list != null && f872fe <= list.size();
    }

    public static boolean th(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static void uk(Context context, String str) {
        i(context, str, true);
    }

    public static int yj(boolean z) {
        if (z) {
            int qw2 = fe.fe.p004if.qw.yj.de.qw(f870ad);
            if (qw2 == 1 || qw2 == 2) {
                qw = 0;
            } else {
                int i2 = qw;
                if (i2 == 0) {
                    qw = 2;
                } else if (i2 == 2) {
                    qw = 3;
                } else if (i2 == 3) {
                    qw = 0;
                }
            }
        }
        fe.qw("DNSUrlProvider", "try to connect ip, now policy =" + qw);
        return qw;
    }
}
