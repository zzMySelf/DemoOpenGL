package fe.fe.fe.qw;

import com.baidu.cesium.a.b;
import com.baidu.cesium.a.i;
import java.lang.reflect.Method;

public final class th extends rg {

    /* renamed from: fe  reason: collision with root package name */
    public ad f1887fe = new ad();

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public Method f1888ad;

        /* renamed from: de  reason: collision with root package name */
        public Method f1889de;
        public Class<?> qw;

        public ad() {
            fe();
        }

        public final long ad(Object obj) {
            try {
                return ((Long) this.f1889de.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final void fe() {
            try {
                this.qw = Class.forName(i.qw(de.qw()), true, Object.class.getClassLoader());
                String qw2 = i.qw(de.ad());
                this.f1888ad = i.ad(this.qw, qw2, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f1889de = i.ad(this.qw, i.qw(de.de()), (Class<?>[]) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void th(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f1888ad.invoke(obj, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3)});
            } catch (Exception unused) {
                throw new i.a("");
            }
        }

        public final Object yj() {
            return this.qw.newInstance();
        }
    }

    public th(int i2, int i3) {
        this.qw = 32;
        this.f1885ad = i2;
        this.f1886de = i3;
    }

    public b ad(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object de2 = this.f1887fe.yj();
            this.f1887fe.th(de2, bArr, i2, i3);
            j = this.f1887fe.ad(de2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return b.a(new long[]{j});
    }
}
