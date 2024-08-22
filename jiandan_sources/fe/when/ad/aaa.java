package fe.when.ad;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.tera.scan.ui.widget.RotateProgress;
import java.util.ArrayList;
import java.util.List;

public class aaa implements Element {
    public de aaa;

    /* renamed from: ad  reason: collision with root package name */
    public float f9298ad;
    public de ddd;
    public float ggg;

    /* renamed from: i  reason: collision with root package name */
    public int f9299i;

    /* renamed from: if  reason: not valid java name */
    public boolean f399if;
    public de mmm;
    public de nn;

    /* renamed from: o  reason: collision with root package name */
    public de f9300o;

    /* renamed from: pf  reason: collision with root package name */
    public int f9301pf;
    public float ppp;

    /* renamed from: switch  reason: not valid java name */
    public float f400switch;

    /* renamed from: th  reason: collision with root package name */
    public float f9302th;

    /* renamed from: uk  reason: collision with root package name */
    public float f9303uk;
    public float vvv;
    public float when;
    public de xxx;

    /* renamed from: yj  reason: collision with root package name */
    public float f9304yj;

    public aaa(float f, float f2, float f3, float f4) {
        this.f9299i = 0;
        this.f9300o = null;
        this.f9301pf = -1;
        this.f399if = false;
        this.f400switch = -1.0f;
        this.when = -1.0f;
        this.ppp = -1.0f;
        this.ggg = -1.0f;
        this.vvv = -1.0f;
        this.xxx = null;
        this.ddd = null;
        this.nn = null;
        this.mmm = null;
        this.aaa = null;
        this.f9298ad = f;
        this.f9302th = f2;
        this.f9304yj = f3;
        this.f9303uk = f4;
    }

    public boolean a() {
        int i2 = this.f9301pf;
        if (i2 == -1 || i2 == 0) {
            return false;
        }
        if (this.f400switch > 0.0f || this.when > 0.0f || this.ppp > 0.0f || this.ggg > 0.0f || this.vvv > 0.0f) {
            return true;
        }
        return false;
    }

    public float aaa() {
        return this.f9303uk;
    }

    public de ad() {
        return this.f9300o;
    }

    public boolean b() {
        return this.f399if;
    }

    public void c() {
        float f = this.f9298ad;
        float f2 = this.f9304yj;
        if (f > f2) {
            this.f9298ad = f2;
            this.f9304yj = f;
        }
        float f3 = this.f9302th;
        float f4 = this.f9303uk;
        if (f3 > f4) {
            this.f9302th = f4;
            this.f9303uk = f3;
        }
    }

    public aaa d() {
        aaa aaa2 = new aaa(this.f9302th, this.f9298ad, this.f9303uk, this.f9304yj);
        aaa2.m(this.f9299i + 90);
        return aaa2;
    }

    public float ddd() {
        return this.f9304yj;
    }

    public int de() {
        return this.f9301pf;
    }

    public void e(de deVar) {
        this.f9300o = deVar;
    }

    public final float eee(float f, int i2) {
        if ((i2 & this.f9301pf) != 0) {
            return f != -1.0f ? f : this.f400switch;
        }
        return 0.0f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aaa)) {
            return false;
        }
        aaa aaa2 = (aaa) obj;
        if (aaa2.f9298ad == this.f9298ad && aaa2.f9302th == this.f9302th && aaa2.f9304yj == this.f9304yj && aaa2.f9303uk == this.f9303uk && aaa2.f9299i == this.f9299i) {
            return true;
        }
        return false;
    }

    public void f(int i2) {
        this.f9301pf = i2;
    }

    public de fe() {
        return this.xxx;
    }

    public void g(de deVar) {
        this.xxx = deVar;
    }

    public List<fe> getChunks() {
        return new ArrayList();
    }

    public float ggg() {
        return this.f9303uk - this.f9302th;
    }

    public void h(float f) {
        this.f400switch = f;
    }

    public float i() {
        return this.f400switch;
    }

    /* renamed from: if  reason: not valid java name */
    public float m1061if() {
        return eee(this.ppp, 8);
    }

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return false;
    }

    public void j(float f) {
        this.f9302th = f;
    }

    public void k(float f) {
        this.f9298ad = f;
    }

    public void l(float f) {
        this.f9304yj = f;
    }

    public void m(int i2) {
        int i3 = i2 % RotateProgress.FULL_DEGREE;
        this.f9299i = i3;
        if (i3 != 90 && i3 != 180 && i3 != 270) {
            this.f9299i = 0;
        }
    }

    public int mmm() {
        return this.f9299i;
    }

    public void n(float f) {
        this.f9303uk = f;
    }

    public float nn(float f) {
        return this.f9304yj - f;
    }

    public float o() {
        return eee(this.vvv, 2);
    }

    public float pf() {
        return eee(this.when, 4);
    }

    public float ppp(float f) {
        return this.f9302th + f;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.ad(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public float qqq(float f) {
        return this.f9303uk - f;
    }

    public void qw(aaa aaa2) {
        this.f9299i = aaa2.f9299i;
        this.f9300o = aaa2.f9300o;
        this.f9301pf = aaa2.f9301pf;
        this.f399if = aaa2.f399if;
        this.f400switch = aaa2.f400switch;
        this.when = aaa2.when;
        this.ppp = aaa2.ppp;
        this.ggg = aaa2.ggg;
        this.vvv = aaa2.vvv;
        this.xxx = aaa2.xxx;
        this.ddd = aaa2.ddd;
        this.nn = aaa2.nn;
        this.mmm = aaa2.mmm;
        this.aaa = aaa2.aaa;
    }

    public de rg() {
        de deVar = this.aaa;
        return deVar == null ? this.xxx : deVar;
    }

    public float rrr() {
        return this.f9304yj - this.f9298ad;
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1062switch() {
        return eee(this.ggg, 1);
    }

    public de th() {
        de deVar = this.ddd;
        return deVar == null ? this.xxx : deVar;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Rectangle: ");
        stringBuffer.append(rrr());
        stringBuffer.append('x');
        stringBuffer.append(ggg());
        stringBuffer.append(" (rot: ");
        stringBuffer.append(this.f9299i);
        stringBuffer.append(" degrees)");
        return stringBuffer.toString();
    }

    public boolean tt(int i2) {
        int i3 = this.f9301pf;
        return i3 != -1 && (i3 & i2) == i2;
    }

    public int type() {
        return 30;
    }

    public de uk() {
        de deVar = this.mmm;
        return deVar == null ? this.xxx : deVar;
    }

    public float vvv() {
        return this.f9298ad;
    }

    public float when() {
        return this.f9302th;
    }

    public float xxx(float f) {
        return this.f9298ad + f;
    }

    public de yj() {
        de deVar = this.nn;
        return deVar == null ? this.xxx : deVar;
    }

    public aaa(float f, float f2) {
        this(0.0f, 0.0f, f, f2);
    }

    public aaa(aaa aaa2) {
        this(aaa2.f9298ad, aaa2.f9302th, aaa2.f9304yj, aaa2.f9303uk);
        qw(aaa2);
    }
}
