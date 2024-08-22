package fe.fe.mmm;

import android.text.TextUtils;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import org.json.JSONArray;

/* renamed from: fe.fe.mmm.switch  reason: invalid class name */
public class Cswitch {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f2122ad;
    public int ddd = 2;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2123de;

    /* renamed from: fe  reason: collision with root package name */
    public int f2124fe;
    public JSONArray ggg;

    /* renamed from: i  reason: collision with root package name */
    public String f2125i;

    /* renamed from: if  reason: not valid java name */
    public int f59if;
    public boolean nn = true;

    /* renamed from: o  reason: collision with root package name */
    public int f2126o;

    /* renamed from: pf  reason: collision with root package name */
    public int f2127pf;
    public boolean ppp;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f2128rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f60switch;

    /* renamed from: th  reason: collision with root package name */
    public int f2129th;

    /* renamed from: uk  reason: collision with root package name */
    public int f2130uk;
    public int vvv;
    public String when;
    public int xxx = -1;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f2131yj;

    /* renamed from: fe.fe.mmm.switch$qw */
    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f2132ad = true;

        /* renamed from: de  reason: collision with root package name */
        public boolean f2133de = false;

        /* renamed from: fe  reason: collision with root package name */
        public int f2134fe = CameraUtilsForScan.MAX_SIZE_HEIGHT;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2135i = false;

        /* renamed from: if  reason: not valid java name */
        public boolean f61if = true;

        /* renamed from: o  reason: collision with root package name */
        public int f2136o = 0;

        /* renamed from: pf  reason: collision with root package name */
        public int f2137pf = 1;
        public String qw = "1";

        /* renamed from: rg  reason: collision with root package name */
        public int f2138rg = 0;

        /* renamed from: th  reason: collision with root package name */
        public boolean f2139th = false;

        /* renamed from: uk  reason: collision with root package name */
        public String f2140uk = "0";

        /* renamed from: yj  reason: collision with root package name */
        public boolean f2141yj = false;

        public qw ad(boolean z) {
            this.f2141yj = z;
            return this;
        }

        public qw de(String str) {
            this.qw = str;
            return this;
        }

        public qw fe(boolean z) {
            this.f61if = z;
            return this;
        }

        public Cswitch qw() {
            return new Cswitch(this);
        }

        public qw rg(boolean z) {
            this.f2133de = z;
            return this;
        }

        public qw th(boolean z) {
            this.f2132ad = z;
            return this;
        }

        public qw yj(int i2) {
            this.f2134fe = i2;
            return this;
        }
    }

    public Cswitch(String str, boolean z, boolean z2, int i2, int i3, boolean z3) {
        this.qw = str;
        this.f2122ad = z;
        this.f2123de = z2;
        this.f2124fe = i2;
        this.f2129th = i3;
        this.f2131yj = z3;
    }

    public void a(boolean z) {
        this.f60switch = z;
    }

    public boolean aaa() {
        return this.xxx == -1;
    }

    public String ad() {
        return this.f2125i;
    }

    public void b(boolean z) {
        this.nn = z;
    }

    public void c(int i2) {
        this.f2127pf = i2;
    }

    public void d(int i2) {
        this.f2126o = i2;
    }

    public boolean ddd() {
        return this.nn;
    }

    public int de() {
        return this.vvv;
    }

    public void e(int i2) {
        this.ddd = i2;
    }

    public void eee(String str) {
        this.f2125i = str;
    }

    public void f(boolean z) {
        this.f2128rg = z;
    }

    public String fe() {
        return this.qw;
    }

    public void g(int i2) {
        this.f2130uk = i2;
    }

    public boolean ggg() {
        return this.f2128rg;
    }

    public void h(boolean z) {
        this.ppp = z;
    }

    public int i() {
        return this.f2124fe;
    }

    /* renamed from: if  reason: not valid java name */
    public String m138if() {
        if (TextUtils.isEmpty(this.when)) {
            return "0";
        }
        return this.when;
    }

    public void j(int i2) {
        this.xxx = i2;
    }

    public void k(String str) {
        this.when = str;
    }

    public boolean mmm() {
        return this.f2122ad;
    }

    public boolean nn() {
        return this.vvv != 0;
    }

    public int o() {
        return this.f2129th;
    }

    public int pf() {
        return this.xxx;
    }

    public boolean ppp() {
        return this.f59if == 1;
    }

    public void qqq(JSONArray jSONArray) {
        this.ggg = jSONArray;
    }

    public JSONArray qw() {
        return this.ggg;
    }

    public int rg() {
        return this.f2127pf;
    }

    public void rrr(int i2) {
        this.vvv = i2;
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m139switch() {
        return this.f2131yj;
    }

    public int th() {
        return this.f2126o;
    }

    public void tt(int i2) {
        this.f59if = i2;
    }

    public int uk() {
        return this.f2130uk;
    }

    public boolean vvv() {
        return this.f2123de;
    }

    public boolean when() {
        return this.f60switch;
    }

    public boolean xxx() {
        return this.ppp;
    }

    public int yj() {
        return this.ddd;
    }

    public Cswitch(qw qwVar) {
        this.qw = qwVar.qw;
        this.f2122ad = qwVar.f2132ad;
        this.f2123de = qwVar.f2133de;
        this.f2124fe = qwVar.f2134fe;
        this.f2129th = qwVar.f2138rg;
        this.f2131yj = qwVar.f2139th;
        this.f60switch = qwVar.f2141yj;
        this.ppp = qwVar.f2135i;
        this.when = qwVar.f2140uk;
        this.vvv = qwVar.f2136o;
        this.xxx = qwVar.f2137pf;
        this.nn = qwVar.f61if;
    }
}
