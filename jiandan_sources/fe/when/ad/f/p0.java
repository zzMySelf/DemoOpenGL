package fe.when.ad.f;

import com.itextpdf.text.ListItem;
import com.itextpdf.text.TabStop;
import fe.when.ad.fe;
import fe.when.ad.i;
import java.util.ArrayList;
import java.util.Iterator;

public class p0 {

    /* renamed from: ad  reason: collision with root package name */
    public float f9676ad;

    /* renamed from: de  reason: collision with root package name */
    public float f9677de;

    /* renamed from: fe  reason: collision with root package name */
    public int f9678fe;

    /* renamed from: i  reason: collision with root package name */
    public ListItem f9679i = null;

    /* renamed from: if  reason: not valid java name */
    public float f447if = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public TabStop f9680o = null;

    /* renamed from: pf  reason: collision with root package name */
    public float f9681pf = Float.NaN;
    public ArrayList<n> qw;

    /* renamed from: rg  reason: collision with root package name */
    public float f9682rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f9683th = false;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f9684uk = false;

    /* renamed from: yj  reason: collision with root package name */
    public float f9685yj;

    public p0(float f, float f2, int i2, float f3) {
        this.f9676ad = f;
        float f4 = f2 - f;
        this.f9677de = f4;
        this.f9685yj = f4;
        this.f9678fe = i2;
        this.f9682rg = f3;
        this.qw = new ArrayList<>();
    }

    public void aaa() {
        if (this.f9678fe == 3) {
            this.f9678fe = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        r0 = r4.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ad(fe.when.ad.f.n r4) {
        /*
            r3 = this;
            boolean r0 = r4.f426switch
            if (r0 == 0) goto L_0x002e
            boolean r0 = r4.eee()
            if (r0 == 0) goto L_0x0022
            fe.when.ad.i r0 = r4.yj()
            float r1 = r4.uk()
            float r2 = r4.o()
            float r1 = r1 + r2
            float r2 = r0.m1062switch()
            float r1 = r1 + r2
            float r0 = r0.getSpacingBefore()
            float r1 = r1 + r0
            goto L_0x0026
        L_0x0022:
            float r1 = r4.m1094switch()
        L_0x0026:
            float r0 = r3.f9682rg
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x002e
            r3.f9682rg = r1
        L_0x002e:
            com.itextpdf.text.TabStop r0 = r3.f9680o
            if (r0 == 0) goto L_0x0067
            com.itextpdf.text.TabStop$Alignment r0 = r0.qw()
            com.itextpdf.text.TabStop$Alignment r1 = com.itextpdf.text.TabStop.Alignment.ANCHOR
            if (r0 != r1) goto L_0x0067
            float r0 = r3.f9681pf
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r4.toString()
            com.itextpdf.text.TabStop r1 = r3.f9680o
            char r1 = r1.ad()
            int r1 = r0.indexOf(r1)
            r2 = -1
            if (r1 == r2) goto L_0x0067
            int r2 = r0.length()
            java.lang.String r0 = r0.substring(r1, r2)
            float r0 = r4.q(r0)
            float r1 = r3.f9685yj
            float r2 = r3.f9677de
            float r1 = r1 - r2
            float r1 = r1 - r0
            r3.f9681pf = r1
        L_0x0067:
            java.util.ArrayList<fe.when.ad.f.n> r0 = r3.qw
            r0.add(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.f.p0.ad(fe.when.ad.f.n):void");
    }

    public ListItem ddd() {
        return this.f9679i;
    }

    public void de() {
        TabStop tabStop = this.f9680o;
        if (tabStop != null) {
            float f = this.f9685yj;
            float f2 = this.f9677de;
            float f3 = this.f447if;
            float rg2 = tabStop.rg(f3, f - f2, this.f9681pf);
            float f4 = (this.f9685yj - rg2) - ((f - f2) - f3);
            this.f9677de = f4;
            if (f4 < 0.0f) {
                rg2 += f4;
            }
            this.f9680o.yj(rg2);
            this.f9680o = null;
            this.f447if = Float.NaN;
        }
    }

    public void eee(ListItem listItem) {
        this.f9679i = listItem;
    }

    public float fe() {
        float f = 0.0f;
        for (int i2 = 0; i2 < this.qw.size(); i2++) {
            n nVar = this.qw.get(i2);
            if (nVar.eee()) {
                f = Math.max(f, nVar.uk() + nVar.o());
            } else {
                d0 fe2 = nVar.fe();
                float ggg = nVar.ggg();
                if (ggg <= 0.0f) {
                    ggg = 0.0f;
                }
                f = Math.max(f, ggg + fe2.fe().m1066switch(1, fe2.uk()));
            }
        }
        return f;
    }

    public boolean ggg() {
        return this.f9684uk;
    }

    public float[] i(float f, float f2) {
        float f3 = -10000.0f;
        float f4 = 0.0f;
        for (int i2 = 0; i2 < this.qw.size(); i2++) {
            n nVar = this.qw.get(i2);
            if (nVar.eee()) {
                i yj2 = nVar.yj();
                if (nVar.ad()) {
                    f3 = Math.max(nVar.uk() + nVar.o() + yj2.getSpacingBefore(), f3);
                }
            } else if (nVar.ad()) {
                f4 = Math.max(nVar.m1094switch(), f4);
            } else {
                f4 = Math.max((nVar.fe().uk() * f2) + f, f4);
            }
        }
        float[] fArr = new float[2];
        if (f4 > 0.0f) {
            f = f4;
        }
        fArr[0] = f;
        fArr[1] = f3;
        return fArr;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m1109if() {
        return ((this.f9678fe == 3 && !this.f9683th) || this.f9678fe == 8) && this.f9677de != 0.0f;
    }

    public int mmm() {
        Iterator<n> it = this.qw.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String nVar = it.next().toString();
            int length = nVar.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (nVar.charAt(i3) == ' ') {
                    i2++;
                }
            }
        }
        return i2;
    }

    public fe nn() {
        ListItem listItem = this.f9679i;
        if (listItem != null) {
            return listItem.getListSymbol();
        }
        return null;
    }

    public float o() {
        return this.f9685yj;
    }

    public int pf() {
        Iterator<n> it = this.qw.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next.c()) {
                if (!next.mmm("TABSETTINGS")) {
                    return -1;
                }
            } else if (next.qqq()) {
                i2++;
            }
        }
        return i2;
    }

    public boolean ppp() {
        return this.f9683th && this.f9678fe != 8;
    }

    public void qqq(float f) {
        this.f9676ad += f;
        this.f9677de -= f;
        this.f9685yj -= f;
    }

    public n qw(n nVar) {
        if (nVar == null || nVar.toString().equals("")) {
            return null;
        }
        n j = nVar.j(this.f9677de);
        this.f9683th = nVar.rrr() || j == null;
        if (nVar.c()) {
            Object[] objArr = (Object[]) nVar.rg("TAB");
            if (nVar.mmm("TABSETTINGS")) {
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                if (booleanValue && this.qw.isEmpty()) {
                    return null;
                }
                de();
                this.f9681pf = Float.NaN;
                TabStop ppp = n.ppp(nVar, this.f9685yj - this.f9677de);
                this.f9680o = ppp;
                if (ppp.fe() > this.f9685yj) {
                    this.f9677de = 0.0f;
                    if (booleanValue) {
                        return null;
                    }
                    return nVar;
                }
                TabStop tabStop = this.f9680o;
                tabStop.yj(tabStop.fe());
                nVar.h(this.f9680o);
                if (this.f9680o.qw() == TabStop.Alignment.LEFT) {
                    this.f9677de = this.f9685yj - this.f9680o.fe();
                    this.f9680o = null;
                    this.f447if = Float.NaN;
                } else {
                    this.f447if = this.f9685yj - this.f9677de;
                }
            } else {
                Float valueOf = Float.valueOf(((Float) objArr[1]).floatValue());
                if (((Boolean) objArr[2]).booleanValue() && this.f447if < this.f9685yj - this.f9677de) {
                    return nVar;
                }
                nVar.qw(this.f9676ad);
                this.f9677de = this.f9685yj - valueOf.floatValue();
            }
            ad(nVar);
        } else if (nVar.d() > 0 || nVar.eee()) {
            if (j != null) {
                nVar.m();
            }
            this.f9677de -= nVar.p();
            ad(nVar);
        } else if (this.qw.size() < 1) {
            n n = j.n(this.f9677de);
            this.f9677de -= j.p();
            if (j.d() > 0) {
                ad(j);
                return n;
            }
            if (n != null) {
                ad(n);
            }
            return null;
        } else {
            float f = this.f9677de;
            ArrayList<n> arrayList = this.qw;
            this.f9677de = f + arrayList.get(arrayList.size() - 1).m();
        }
        return j;
    }

    public n rg(int i2) {
        if (i2 < 0 || i2 >= this.qw.size()) {
            return null;
        }
        return this.qw.get(i2);
    }

    public int rrr() {
        return this.qw.size();
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1110switch() {
        return this.f9682rg;
    }

    public float th() {
        float f = 0.0f;
        for (int i2 = 0; i2 < this.qw.size(); i2++) {
            n nVar = this.qw.get(i2);
            if (nVar.eee()) {
                f = Math.min(f, nVar.o());
            } else {
                d0 fe2 = nVar.fe();
                float ggg = nVar.ggg();
                if (ggg >= 0.0f) {
                    ggg = 0.0f;
                }
                f = Math.min(f, ggg + fe2.fe().m1066switch(3, fe2.uk()));
            }
        }
        return f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<n> it = this.qw.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        return stringBuffer.toString();
    }

    public float tt() {
        return this.f9677de;
    }

    public int uk() {
        Iterator<n> it = this.qw.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().e();
        }
        return i2;
    }

    public Iterator<n> vvv() {
        return this.qw.iterator();
    }

    public float when() {
        if (this.f9684uk) {
            int i2 = this.f9678fe;
            if (i2 == 0) {
                return this.f9676ad + this.f9677de;
            }
            if (i2 != 1) {
                return this.f9676ad;
            }
            return this.f9676ad + (this.f9677de / 2.0f);
        }
        if (pf() <= 0) {
            int i3 = this.f9678fe;
            if (i3 == 1) {
                return this.f9676ad + (this.f9677de / 2.0f);
            }
            if (i3 == 2) {
                return this.f9676ad + this.f9677de;
            }
        }
        return this.f9676ad;
    }

    public float xxx() {
        ListItem listItem = this.f9679i;
        if (listItem != null) {
            return listItem.getIndentationLeft();
        }
        return 0.0f;
    }

    public int yj() {
        int size = this.qw.size() - 1;
        while (size >= 0 && !this.qw.get(size).b()) {
            size--;
        }
        return size;
    }

    public p0(float f, float f2, float f3, int i2, boolean z, ArrayList<n> arrayList, boolean z2) {
        this.f9676ad = f;
        this.f9685yj = f2;
        this.f9677de = f3;
        this.f9678fe = i2;
        this.qw = arrayList;
        this.f9683th = z;
        this.f9684uk = z2;
    }
}
