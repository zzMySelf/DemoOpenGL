package fe.qw.qw.ppp;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.net.MailTo;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.cmic.sso.sdk.e.i;
import com.dlife.ctaccountapi.t;
import fe.qw.qw.de;
import fe.qw.qw.vvv.qw;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class vvv {

    /* renamed from: ad  reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f3402ad;

    /* renamed from: de  reason: collision with root package name */
    public static JsonReader.qw f3403de = JsonReader.qw.qw(t.a, "s", "e", "o", i.a, "h", MailTo.TO, "ti");
    public static final Interpolator qw = new LinearInterpolator();

    public static <T> qw<T> ad(JsonReader jsonReader, de deVar, float f, k<T> kVar, boolean z) throws IOException {
        if (z) {
            return de(deVar, jsonReader, f, kVar);
        }
        return fe(jsonReader, f, kVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: android.view.animation.Interpolator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> fe.qw.qw.vvv.qw<T> de(fe.qw.qw.de r16, com.airbnb.lottie.parser.moshi.JsonReader r17, float r18, fe.qw.qw.ppp.k<T> r19) throws java.io.IOException {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r17.fe()
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = r5
            r8 = r7
            r9 = r8
            r10 = r9
            r14 = r10
            r15 = r14
            r6 = 0
            r13 = 0
        L_0x0014:
            boolean r11 = r17.yj()
            if (r11 == 0) goto L_0x0056
            com.airbnb.lottie.parser.moshi.JsonReader$qw r11 = f3403de
            int r11 = r0.ddd(r11)
            switch(r11) {
                case 0: goto L_0x0050;
                case 1: goto L_0x004b;
                case 2: goto L_0x0046;
                case 3: goto L_0x0041;
                case 4: goto L_0x003c;
                case 5: goto L_0x0031;
                case 6: goto L_0x002c;
                case 7: goto L_0x0027;
                default: goto L_0x0023;
            }
        L_0x0023:
            r17.mmm()
            goto L_0x0014
        L_0x0027:
            android.graphics.PointF r14 = fe.qw.qw.ppp.ggg.rg(r17, r18)
            goto L_0x0014
        L_0x002c:
            android.graphics.PointF r15 = fe.qw.qw.ppp.ggg.rg(r17, r18)
            goto L_0x0014
        L_0x0031:
            int r6 = r17.m4switch()
            r11 = 1
            if (r6 != r11) goto L_0x003a
            r6 = 1
            goto L_0x0014
        L_0x003a:
            r6 = 0
            goto L_0x0014
        L_0x003c:
            android.graphics.PointF r8 = fe.qw.qw.ppp.ggg.rg(r17, r18)
            goto L_0x0014
        L_0x0041:
            android.graphics.PointF r7 = fe.qw.qw.ppp.ggg.rg(r17, r18)
            goto L_0x0014
        L_0x0046:
            java.lang.Object r9 = r2.qw(r0, r1)
            goto L_0x0014
        L_0x004b:
            java.lang.Object r10 = r2.qw(r0, r1)
            goto L_0x0014
        L_0x0050:
            double r11 = r17.pf()
            float r13 = (float) r11
            goto L_0x0014
        L_0x0056:
            r17.th()
            if (r6 == 0) goto L_0x0061
            android.view.animation.Interpolator r0 = qw
            r12 = r0
            r11 = r10
            goto L_0x00fa
        L_0x0061:
            if (r7 == 0) goto L_0x00f6
            if (r8 == 0) goto L_0x00f6
            float r0 = r7.x
            float r2 = -r1
            float r0 = fe.qw.qw.ggg.th.de(r0, r2, r1)
            r7.x = r0
            float r0 = r7.y
            r3 = -1027080192(0xffffffffc2c80000, float:-100.0)
            r6 = 1120403456(0x42c80000, float:100.0)
            float r0 = fe.qw.qw.ggg.th.de(r0, r3, r6)
            r7.y = r0
            float r0 = r8.x
            float r0 = fe.qw.qw.ggg.th.de(r0, r2, r1)
            r8.x = r0
            float r0 = r8.y
            float r0 = fe.qw.qw.ggg.th.de(r0, r3, r6)
            r8.y = r0
            float r2 = r7.x
            float r3 = r7.y
            float r6 = r8.x
            int r2 = fe.qw.qw.ggg.yj.i(r2, r3, r6, r0)
            java.lang.ref.WeakReference r0 = qw(r2)
            if (r0 == 0) goto L_0x00a1
            java.lang.Object r3 = r0.get()
            r5 = r3
            android.view.animation.Interpolator r5 = (android.view.animation.Interpolator) r5
        L_0x00a1:
            if (r0 == 0) goto L_0x00a5
            if (r5 != 0) goto L_0x00f4
        L_0x00a5:
            float r0 = r7.x
            float r0 = r0 / r1
            r7.x = r0
            float r0 = r7.y
            float r0 = r0 / r1
            r7.y = r0
            float r0 = r8.x
            float r0 = r0 / r1
            r8.x = r0
            float r3 = r8.y
            float r3 = r3 / r1
            r8.y = r3
            float r1 = r7.x     // Catch:{ IllegalArgumentException -> 0x00c2 }
            float r5 = r7.y     // Catch:{ IllegalArgumentException -> 0x00c2 }
            android.view.animation.Interpolator r0 = androidx.core.view.animation.PathInterpolatorCompat.create(r1, r5, r0, r3)     // Catch:{ IllegalArgumentException -> 0x00c2 }
            goto L_0x00eb
        L_0x00c2:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "The Path cannot loop back on itself."
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00e6
            float r0 = r7.x
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = java.lang.Math.min(r0, r1)
            float r1 = r7.y
            float r3 = r8.x
            float r3 = java.lang.Math.max(r3, r4)
            float r4 = r8.y
            android.view.animation.Interpolator r0 = androidx.core.view.animation.PathInterpolatorCompat.create(r0, r1, r3, r4)
            goto L_0x00eb
        L_0x00e6:
            android.view.animation.LinearInterpolator r0 = new android.view.animation.LinearInterpolator
            r0.<init>()
        L_0x00eb:
            r5 = r0
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00f4 }
            r0.<init>(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00f4 }
            th(r2, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00f4 }
        L_0x00f4:
            r12 = r5
            goto L_0x00f9
        L_0x00f6:
            android.view.animation.Interpolator r0 = qw
            r12 = r0
        L_0x00f9:
            r11 = r9
        L_0x00fa:
            fe.qw.qw.vvv.qw r0 = new fe.qw.qw.vvv.qw
            r1 = 0
            r8 = r0
            r9 = r16
            r5 = r14
            r14 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0.f120switch = r15
            r0.when = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.ppp.vvv.de(fe.qw.qw.de, com.airbnb.lottie.parser.moshi.JsonReader, float, fe.qw.qw.ppp.k):fe.qw.qw.vvv.qw");
    }

    public static <T> qw<T> fe(JsonReader jsonReader, float f, k<T> kVar) throws IOException {
        return new qw<>(kVar.qw(jsonReader, f));
    }

    @Nullable
    public static WeakReference<Interpolator> qw(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (vvv.class) {
            weakReference = rg().get(i2);
        }
        return weakReference;
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> rg() {
        if (f3402ad == null) {
            f3402ad = new SparseArrayCompat<>();
        }
        return f3402ad;
    }

    public static void th(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (vvv.class) {
            f3402ad.put(i2, weakReference);
        }
    }
}
