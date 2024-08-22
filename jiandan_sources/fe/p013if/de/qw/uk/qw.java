package fe.p013if.de.qw.uk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidubce.services.vod.VodClient;
import fe.p013if.de.qw.de;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: fe.if.de.qw.uk.qw  reason: invalid package */
public class qw {
    public static String a;
    public static int b;
    public static final SimpleDateFormat eee = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String rrr = de.fe().o();
    public static String tt = Build.MODEL;
    public StringBuilder aaa = new StringBuilder();

    /* renamed from: ad  reason: collision with root package name */
    public String f4614ad;
    public ArrayList<String> ddd = new ArrayList<>();

    /* renamed from: de  reason: collision with root package name */
    public String f4615de = "";

    /* renamed from: fe  reason: collision with root package name */
    public int f4616fe = -1;
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public String f4617i;

    /* renamed from: if  reason: not valid java name */
    public long f170if;
    public StringBuilder mmm = new StringBuilder();
    public StringBuilder nn = new StringBuilder();

    /* renamed from: o  reason: collision with root package name */
    public String f4618o;

    /* renamed from: pf  reason: collision with root package name */
    public String f4619pf;
    public String ppp;
    public StringBuilder qqq = new StringBuilder();
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f4620rg;

    /* renamed from: switch  reason: not valid java name */
    public long f171switch;

    /* renamed from: th  reason: collision with root package name */
    public String f4621th;

    /* renamed from: uk  reason: collision with root package name */
    public int f4622uk;
    public String vvv;
    public String when;
    public String xxx = "-1";

    /* renamed from: yj  reason: collision with root package name */
    public String f4623yj = "";

    static {
        a = "";
        b = -1;
        b = ad.ad();
        a = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static qw ad() {
        qw qwVar = new qw();
        Context th2 = de.fe().th();
        String str = qwVar.f4623yj;
        if (str == null || str.length() == 0) {
            try {
                PackageInfo packageInfo = th2.getPackageManager().getPackageInfo(th2.getPackageName(), 0);
                qwVar.f4622uk = packageInfo.versionCode;
                qwVar.f4623yj = packageInfo.versionName;
            } catch (Throwable unused) {
            }
        }
        qwVar.f4616fe = b;
        qwVar.f4614ad = tt;
        qwVar.f4615de = a;
        qwVar.qw = rrr;
        qwVar.f4620rg = de.fe().pf();
        qwVar.f4621th = de.qw();
        qwVar.f4617i = de.fe().uk();
        qwVar.f4618o = String.valueOf(ad.qw());
        qwVar.f4619pf = String.valueOf(ad.de());
        if (Build.VERSION.SDK_INT >= 24) {
            qwVar.xxx = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return qwVar;
    }

    public qw de(long j, long j2, long j3, long j4) {
        this.f170if = j2 - j;
        this.f171switch = j4 - j3;
        this.when = Long.toString(j);
        this.ppp = Long.toString(j2);
        return this;
    }

    public qw fe(String str) {
        this.vvv = str;
        return this;
    }

    public qw qw() {
        StringBuilder sb = this.nn;
        sb.append("qua");
        sb.append(" = ");
        sb.append(this.qw);
        sb.append("\r\n");
        StringBuilder sb2 = this.nn;
        sb2.append("versionName");
        sb2.append(" = ");
        sb2.append(this.f4623yj);
        sb2.append("\r\n");
        StringBuilder sb3 = this.nn;
        sb3.append("versionCode");
        sb3.append(" = ");
        sb3.append(this.f4622uk);
        sb3.append("\r\n");
        StringBuilder sb4 = this.nn;
        sb4.append("uid");
        sb4.append(" = ");
        sb4.append(this.f4620rg);
        sb4.append("\r\n");
        StringBuilder sb5 = this.nn;
        sb5.append("network");
        sb5.append(" = ");
        sb5.append(this.f4617i);
        sb5.append("\r\n");
        StringBuilder sb6 = this.nn;
        sb6.append(UrlOcrConfig.IdCardKey.OS_MODEL);
        sb6.append(" = ");
        sb6.append(this.f4614ad);
        sb6.append("\r\n");
        StringBuilder sb7 = this.nn;
        sb7.append("api-level");
        sb7.append(" = ");
        sb7.append(this.f4615de);
        sb7.append("\r\n");
        StringBuilder sb8 = this.nn;
        sb8.append("cpu-core");
        sb8.append(" = ");
        sb8.append(this.f4616fe);
        sb8.append("\r\n");
        StringBuilder sb9 = this.nn;
        sb9.append(VodClient.PARA_PROCESS);
        sb9.append(" = ");
        sb9.append(this.f4621th);
        sb9.append("\r\n");
        StringBuilder sb10 = this.nn;
        sb10.append("freeMemory");
        sb10.append(" = ");
        sb10.append(this.f4618o);
        sb10.append("\r\n");
        StringBuilder sb11 = this.nn;
        sb11.append("totalMemory");
        sb11.append(" = ");
        sb11.append(this.f4619pf);
        sb11.append("\r\n");
        StringBuilder sb12 = this.aaa;
        sb12.append("time");
        sb12.append(" = ");
        sb12.append(this.f170if);
        sb12.append("\r\n");
        StringBuilder sb13 = this.aaa;
        sb13.append("thread-time");
        sb13.append(" = ");
        sb13.append(this.f171switch);
        sb13.append("\r\n");
        StringBuilder sb14 = this.aaa;
        sb14.append("time-start");
        sb14.append(" = ");
        sb14.append(this.when);
        sb14.append("\r\n");
        StringBuilder sb15 = this.aaa;
        sb15.append("time-end");
        sb15.append(" = ");
        sb15.append(this.ppp);
        sb15.append("\r\n");
        StringBuilder sb16 = this.mmm;
        sb16.append("cpu-busy");
        sb16.append(" = ");
        sb16.append(this.ggg);
        sb16.append("\r\n");
        StringBuilder sb17 = this.mmm;
        sb17.append("cpu-rate");
        sb17.append(" = ");
        sb17.append(this.vvv);
        sb17.append("\r\n");
        ArrayList<String> arrayList = this.ddd;
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder sb18 = new StringBuilder();
            Iterator<String> it = this.ddd.iterator();
            while (it.hasNext()) {
                sb18.append(it.next());
                sb18.append("\r\n");
            }
            StringBuilder sb19 = this.qqq;
            sb19.append("stack");
            sb19.append(" = ");
            sb19.append(sb18.toString());
            sb19.append("\r\n");
        }
        return this;
    }

    public qw rg(ArrayList<String> arrayList) {
        this.ddd = arrayList;
        return this;
    }

    public String toString() {
        return String.valueOf(this.nn) + this.aaa + this.mmm + this.qqq;
    }
}
