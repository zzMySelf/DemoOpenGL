package fe.fe.pf.yj.ad;

import com.baidu.helios.common.cc.a;
import com.baidu.helios.common.cc.n;
import java.lang.reflect.Method;

public final class rg extends fe {

    /* renamed from: fe  reason: collision with root package name */
    public ad f2956fe = new ad();

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public Method f2957ad;

        /* renamed from: de  reason: collision with root package name */
        public Method f2958de;
        public Class<?> qw;

        public ad() {
            fe();
        }

        public final long ad(Object obj) {
            try {
                return ((Long) this.f2958de.invoke(obj, new Object[0])).longValue();
            } catch (Exception unused) {
                throw new n.a("");
            }
        }

        public final void fe() {
            try {
                this.qw = Class.forName(n.qw(uk.qw()), true, Object.class.getClassLoader());
                String qw2 = n.qw(uk.ad());
                this.f2957ad = n.ad(this.qw, qw2, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                this.f2958de = n.ad(this.qw, n.qw(uk.de()), (Class<?>[]) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void th(Object obj, byte[] bArr, int i2, int i3) {
            try {
                this.f2957ad.invoke(obj, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3)});
            } catch (Exception unused) {
                throw new n.a("");
            }
        }

        public final Object yj() {
            return this.qw.newInstance();
        }
    }

    public rg(int i2, int i3) {
        this.qw = 32;
        this.f2954ad = i2;
        this.f2955de = i3;
    }

    public a ad(byte[] bArr, int i2, int i3) {
        long j;
        try {
            Object de2 = this.f2956fe.yj();
            this.f2956fe.th(de2, bArr, i2, i3);
            j = this.f2956fe.ad(de2);
        } catch (Exception unused) {
            j = 4294967295L;
        }
        return a.a(new long[]{j});
    }
}
