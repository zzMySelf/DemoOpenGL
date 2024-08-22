package fe.when.ad.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class n1 {

    /* renamed from: i  reason: collision with root package name */
    public static final v0 f9543i = new v0(1);

    /* renamed from: uk  reason: collision with root package name */
    public static final q0 f9544uk = new q0("[1 0 0 1 0 0]");

    /* renamed from: ad  reason: collision with root package name */
    public m1 f9545ad;

    /* renamed from: de  reason: collision with root package name */
    public e2 f9546de;

    /* renamed from: fe  reason: collision with root package name */
    public HashMap<Integer, j0> f9547fe = new HashMap<>();
    public int[] qw;

    /* renamed from: rg  reason: collision with root package name */
    public c2 f9548rg;

    /* renamed from: th  reason: collision with root package name */
    public HashSet<Integer> f9549th = new HashSet<>();

    /* renamed from: yj  reason: collision with root package name */
    public ArrayList<Integer> f9550yj = new ArrayList<>();

    public n1(m1 m1Var, c2 c2Var) {
        this.f9545ad = m1Var;
        this.f9548rg = c2Var;
        this.f9546de = m1Var.mmm();
        this.qw = new int[m1Var.rrr()];
    }

    public int ad(int i2, int i3) {
        int[] iArr = this.qw;
        if (iArr[i2] == 0) {
            iArr[i2] = this.f9548rg.B();
            this.f9550yj.add(Integer.valueOf(i2));
        }
        return this.qw[i2];
    }

    public m1 de() {
        return this.f9545ad;
    }

    public y0 fe(int i2) {
        return m1.ddd(this.f9545ad.when(i2).qqq(s0.s4));
    }

    public v1 qw(int i2, int i3) throws IOException {
        byte[] bArr;
        x when = this.f9545ad.when(i2);
        y0 ddd = m1.ddd(when.qqq(s0.Z));
        x xVar = new x();
        if (ddd == null) {
            bArr = new byte[0];
        } else if (ddd.ggg()) {
            xVar.j((d) ddd);
            bArr = null;
        } else {
            bArr = this.f9545ad.m1089if(i2, this.f9546de);
        }
        s0 s0Var = s0.s4;
        xVar.h(s0Var, m1.ddd(when.qqq(s0Var)));
        xVar.h(s0.K5, s0.v6);
        xVar.h(s0.b5, s0.y1);
        j0 j0Var = this.f9547fe.get(Integer.valueOf(i2));
        xVar.h(s0.m, new o1(j0Var.d1()));
        k j1 = j0Var.j1();
        if (j1 == null) {
            xVar.h(s0.R2, f9544uk);
        } else {
            xVar.h(s0.R2, j1);
        }
        xVar.h(s0.z1, f9543i);
        if (bArr == null) {
            return new d((d) ddd, xVar);
        }
        d dVar = new d(this.f9545ad, bArr, i3);
        dVar.j(xVar);
        return dVar;
    }

    public void rg() throws IOException {
        try {
            this.f9546de.fe();
            for (j0 next : this.f9547fe.values()) {
                if (next.u1()) {
                    this.f9548rg.tt(next.e1(this.f9548rg.r()), next.h1());
                    next.v1();
                }
            }
            th();
        } finally {
            try {
                this.f9546de.close();
            } catch (Exception unused) {
            }
        }
    }

    public void th() throws IOException {
        while (!this.f9550yj.isEmpty()) {
            ArrayList<Integer> arrayList = this.f9550yj;
            this.f9550yj = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = arrayList.get(i2);
                if (!this.f9549th.contains(num)) {
                    this.f9549th.add(num);
                    int intValue = num.intValue();
                    this.f9548rg.rrr(this.f9545ad.xxx(intValue), this.qw[intValue]);
                }
            }
        }
    }
}
