package fe.fe.fe.qw;

import com.baidu.cesium.a.b;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static int f1883ad = 5;

    /* renamed from: de  reason: collision with root package name */
    public static int f1884de = 40;
    public b qw;

    public fe() {
        b bVar = new b(f1884de);
        this.qw = bVar;
        bVar.a(0, f1884de, true);
    }

    public byte[] ad() {
        return this.qw.a();
    }

    public void qw(b bVar, int i2, int i3, int i4) {
        b d = this.qw.d(i2, i2 + i3);
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    d.e(bVar);
                } else if (i4 == 3) {
                    d.c(bVar);
                }
            }
            d.d(bVar);
        } else {
            d.b(bVar);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            this.qw.a(i2 + i5, d.d(i5));
        }
    }
}
