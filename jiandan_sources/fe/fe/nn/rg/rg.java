package fe.fe.nn.rg;

import android.content.Context;
import android.text.TextUtils;
import fe.fe.nn.ppp.de;
import fe.fe.nn.when.fe;

public class rg extends fe {

    public class ad extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2347th;

        public ad(int i2) {
            this.f2347th = i2;
        }

        public void ad() {
            try {
                rg rgVar = rg.this;
                rgVar.yj(this.f2347th, rgVar.f2314de, rgVar.f2320uk);
            } catch (Throwable th2) {
                de.fe(th2);
                rg rgVar2 = rg.this;
                rgVar2.when(this.f2347th, 3, 2009, rgVar2.f2314de, "cu on getToken unknown error.");
            }
        }
    }

    public class qw extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2349th;

        public qw(int i2) {
            this.f2349th = i2;
        }

        public void ad() {
            try {
                rg.this.ad(this.f2349th);
            } catch (Throwable th2) {
                de.fe(th2);
                rg rgVar = rg.this;
                rgVar.fe(this.f2349th, 3, 2009, rgVar.f2314de, "cu on getToken unknown error.");
            }
        }
    }

    public rg(Context context) {
        super(context);
    }

    public void ggg(Context context, int i2, long j) {
        super.ggg(context, i2, j);
        de(i2, 4);
        fe.de().ad(new ad(i2));
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m156if() {
        if (TextUtils.isEmpty(this.f2318rg)) {
            this.f2321yj = null;
            this.f2319th = 0;
            return true;
        }
        if (this.f2319th - System.currentTimeMillis() >= fe.fe.nn.ppp.ad.qw) {
            return false;
        }
        this.f2321yj = null;
        this.f2319th = 0;
        return true;
    }

    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
        de(i2, 2);
        fe.de().ad(new qw(i2));
    }

    public boolean vvv() {
        if (TextUtils.isEmpty(this.f2320uk)) {
            this.f2316i = 0;
            return true;
        }
        if (this.f2316i - System.currentTimeMillis() >= fe.fe.nn.ppp.ad.qw) {
            return false;
        }
        this.f2316i = 0;
        return true;
    }
}
