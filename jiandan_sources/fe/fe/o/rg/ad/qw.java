package fe.fe.o.rg.ad;

import android.content.Context;
import com.baidu.down.common.DownConstants;
import fe.fe.o.ad.th;
import fe.fe.o.de.rg;
import fe.fe.o.fe.qw.de.o;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class qw implements DownConstants, Comparable {
    public static int D = 16384;
    public static long E = 524288;
    public HashMap A;
    public int B = 3;
    public Context C = null;
    public String aaa = "";

    /* renamed from: ad  reason: collision with root package name */
    public int f2600ad = 2;
    public String ddd = "";
    public boolean e = false;
    public ad eee = new ad();
    public long f;
    public long g = 0;
    public String ggg = "";
    public long h = 0;

    /* renamed from: i  reason: collision with root package name */
    public o f2601i;

    /* renamed from: if  reason: not valid java name */
    public th f81if;
    public long j = 0;
    public long k = 0;
    public rg l;
    public boolean m = false;
    public String mmm = "";
    public String n;
    public String nn = "";

    /* renamed from: o  reason: collision with root package name */
    public Map f2602o = new HashMap();
    public long p;

    /* renamed from: pf  reason: collision with root package name */
    public fe.fe.o.qw.rg f2603pf;
    public long ppp = -1;
    public String q;
    public long qqq = 0;
    public int r;
    public File rrr = null;
    public String s;

    /* renamed from: switch  reason: not valid java name */
    public Context f82switch;
    public String t;

    /* renamed from: th  reason: collision with root package name */
    public int f2604th = 2;
    public boolean tt;
    public String u;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f2605uk = false;
    public String v;
    public String vvv = "";
    public String w = "";
    public int when = -1;
    public long x;
    public boolean xxx = false;
    public String y;

    /* renamed from: yj  reason: collision with root package name */
    public int f2606yj = 0;
    public String z = "";

    public qw(int i2) {
    }

    public String ad() {
        return this.ggg + this.ppp;
    }

    public void fe(int i2) {
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 5) {
            i2 = 5;
        }
        this.B = i2;
    }

    public abstract void i();

    public abstract void o();

    /* renamed from: qw */
    public int compareTo(qw qwVar) {
        int i2 = this.B;
        int i3 = qwVar.B;
        if (i2 > i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public void rg(rg rgVar) {
        this.l = rgVar;
    }

    public int th() {
        return this.B;
    }

    public String toString() {
        return "[mUri=" + this.ggg + "][mDownloadId=" + this.ppp + "][status=" + this.when + "]";
    }

    public abstract void uk();
}
