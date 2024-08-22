package fe.fe.pf.yj.ad;

import com.baidu.helios.common.cc.a;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static int f2952ad = 5;

    /* renamed from: de  reason: collision with root package name */
    public static int f2953de = 40;
    public a qw;

    public de() {
        a aVar = new a(f2953de);
        this.qw = aVar;
        aVar.a(0, f2953de, true);
    }

    public byte[] ad() {
        return this.qw.a();
    }

    public void qw(a aVar, int i2, int i3, int i4) {
        a d = this.qw.d(i2, i2 + i3);
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    d.e(aVar);
                } else if (i4 == 3) {
                    d.c(aVar);
                }
            }
            d.d(aVar);
        } else {
            d.b(aVar);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            this.qw.a(i2 + i5, d.d(i5));
        }
    }
}
