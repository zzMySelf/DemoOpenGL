package fe.qw.qw.pf.de;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import fe.qw.qw.de;
import fe.qw.qw.vvv.qw;

public class yj extends qw<PointF> {
    public final qw<PointF> ggg;
    @Nullable
    public Path ppp;

    public yj(de deVar, qw<PointF> qwVar) {
        super(deVar, qwVar.f3525ad, qwVar.f3526de, qwVar.f3527fe, qwVar.f3531rg, qwVar.f3532th);
        this.ggg = qwVar;
        i();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r4.f3525ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r4 = this;
            T r0 = r4.f3526de
            if (r0 == 0) goto L_0x001b
            T r1 = r4.f3525ad
            if (r1 == 0) goto L_0x001b
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            r2 = r0
            android.graphics.PointF r2 = (android.graphics.PointF) r2
            float r2 = r2.x
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            float r0 = r0.y
            boolean r0 = r1.equals(r2, r0)
            if (r0 == 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            T r1 = r4.f3526de
            if (r1 == 0) goto L_0x0034
            if (r0 != 0) goto L_0x0034
            T r0 = r4.f3525ad
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            fe.qw.qw.vvv.qw<android.graphics.PointF> r2 = r4.ggg
            android.graphics.PointF r3 = r2.f120switch
            android.graphics.PointF r2 = r2.when
            android.graphics.Path r0 = fe.qw.qw.ggg.yj.fe(r0, r1, r3, r2)
            r4.ppp = r0
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.pf.de.yj.i():void");
    }

    @Nullable
    public Path o() {
        return this.ppp;
    }
}
