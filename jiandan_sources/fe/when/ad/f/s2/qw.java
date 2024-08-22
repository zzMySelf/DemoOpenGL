package fe.when.ad.f.s2;

import com.baidu.ubc.UBCManager;
import com.google.common.net.MediaType;
import com.itextpdf.text.ExceptionConverter;
import com.tera.scan.ui.widget.RotateProgress;
import fe.when.ad.aaa;
import fe.when.ad.ad;
import fe.when.ad.f.c0;
import fe.when.ad.f.c2;
import fe.when.ad.f.e0;
import fe.when.ad.f.g;
import fe.when.ad.f.h;
import fe.when.ad.f.j;
import fe.when.ad.f.k;
import fe.when.ad.f.o1;
import fe.when.ad.f.s0;
import fe.when.ad.f.w1;
import fe.when.ad.f.z1;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public ArrayList<j> f9770ad;

    /* renamed from: de  reason: collision with root package name */
    public ArrayList<j> f9771de = new ArrayList<>();
    public g qw;

    public qw(c2 c2Var) {
        this.qw = new g(c2Var);
    }

    public static j fe(c2 c2Var, ad adVar, aaa aaa) throws IOException {
        c0 c0Var;
        switch (adVar.qw()) {
            case 1:
                return new j(c2Var, adVar.fe(), adVar.th(), adVar.o(), adVar.m1063if(), new h((URL) adVar.ad().get("url")));
            case 2:
                return new j(c2Var, adVar.fe(), adVar.th(), adVar.o(), adVar.m1063if(), new h((String) adVar.ad().get("file")));
            case 3:
                return new j(c2Var, adVar.fe(), adVar.th(), adVar.o(), adVar.m1063if(), new h((String) adVar.ad().get("file"), (String) adVar.ad().get("destination")));
            case 4:
                return new j(c2Var, adVar.fe(), adVar.th(), adVar.o(), adVar.m1063if(), new h((String) adVar.ad().get("file"), ((Integer) adVar.ad().get(UBCManager.CONTENT_KEY_PAGE)).intValue()));
            case 5:
                return new j(c2Var, adVar.fe(), adVar.th(), adVar.o(), adVar.m1063if(), new h(((Integer) adVar.ad().get("named")).intValue()));
            case 6:
                return new j(c2Var, adVar.fe(), adVar.th(), adVar.o(), adVar.m1063if(), new h((String) adVar.ad().get(MediaType.APPLICATION_TYPE), (String) adVar.ad().get("parameters"), (String) adVar.ad().get("operation"), (String) adVar.ad().get("defaultdir")));
            case 7:
                boolean[] zArr = (boolean[]) adVar.ad().get("parameters");
                String str = (String) adVar.ad().get("file");
                String str2 = (String) adVar.ad().get("mime");
                if (zArr[0]) {
                    c0Var = c0.l(c2Var, str, str, (byte[]) null);
                } else {
                    c0Var = c0.p(c2Var, str);
                }
                return j.m(c2Var, new aaa(adVar.fe(), adVar.th(), adVar.o(), adVar.m1063if()), str, c0Var, str2, zArr[1]);
            default:
                return new j(c2Var, aaa.vvv(), aaa.when(), aaa.ddd(), aaa.aaa(), new w1(adVar.i(), "UnicodeBig"), new w1(adVar.de(), "UnicodeBig"));
        }
    }

    public void ad(e0 e0Var) {
        this.f9770ad.add(e0Var);
        ArrayList<e0> w = e0Var.w();
        if (w != null) {
            for (int i2 = 0; i2 < w.size(); i2++) {
                ad(w.get(i2));
            }
        }
    }

    public void de(j jVar) {
        this.f9770ad.add(jVar);
    }

    public k i(c2 c2Var, aaa aaa) {
        o1 o1Var;
        HashSet<z1> q;
        k kVar = new k();
        int mmm = aaa.mmm() % RotateProgress.FULL_DEGREE;
        int u = c2Var.u();
        for (int i2 = 0; i2 < this.f9770ad.size(); i2++) {
            j jVar = this.f9770ad.get(i2);
            if (jVar.p() > u) {
                this.f9771de.add(jVar);
            } else {
                if (jVar.s()) {
                    if (!jVar.t() && (q = jVar.q()) != null) {
                        this.qw.m(q);
                    }
                    e0 e0Var = (e0) jVar;
                    if (e0Var.x() == null) {
                        this.qw.l(e0Var.n());
                    }
                }
                if (jVar.r()) {
                    kVar.qqq(jVar.n());
                    if (!jVar.t()) {
                        k eee = jVar.eee(s0.m4);
                        if (eee.size() == 4) {
                            o1Var = new o1(eee.e(0).qqq(), eee.e(1).qqq(), eee.e(2).qqq(), eee.e(3).qqq());
                        } else {
                            o1Var = new o1(eee.e(0).qqq(), eee.e(1).qqq());
                        }
                        if (mmm == 90) {
                            jVar.h(s0.m4, new o1(aaa.aaa() - o1Var.k(), o1Var.m(), aaa.aaa() - o1Var.p(), o1Var.n()));
                        } else if (mmm == 180) {
                            jVar.h(s0.m4, new o1(aaa.ddd() - o1Var.m(), aaa.aaa() - o1Var.k(), aaa.ddd() - o1Var.n(), aaa.aaa() - o1Var.p()));
                        } else if (mmm == 270) {
                            jVar.h(s0.m4, new o1(o1Var.k(), aaa.ddd() - o1Var.m(), o1Var.p(), aaa.ddd() - o1Var.n()));
                        }
                    }
                }
                if (!jVar.t()) {
                    jVar.v();
                    try {
                        c2Var.tt(jVar, jVar.n());
                    } catch (IOException e) {
                        throw new ExceptionConverter(e);
                    }
                }
            }
        }
        return kVar;
    }

    public void qw(j jVar) {
        if (jVar.s()) {
            e0 e0Var = (e0) jVar;
            if (e0Var.x() == null) {
                ad(e0Var);
                return;
            }
            return;
        }
        this.f9770ad.add(jVar);
    }

    public g rg() {
        return this.qw;
    }

    public boolean th() {
        return !this.f9770ad.isEmpty();
    }

    public void uk() {
        this.f9770ad = this.f9771de;
        this.f9771de = new ArrayList<>();
    }

    public boolean yj() {
        return this.qw.n();
    }
}
