package fe.qw.qw.ggg;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.p009switch.i.yj;
import fe.qw.qw.p009switch.qw;
import java.util.List;

public class th {
    public static PointF qw = new PointF();

    public static double ad(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float de(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int fe(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static void i(yj yjVar, Path path) {
        path.reset();
        PointF ad2 = yjVar.ad();
        path.moveTo(ad2.x, ad2.y);
        qw.set(ad2.x, ad2.y);
        for (int i2 = 0; i2 < yjVar.qw().size(); i2++) {
            qw qwVar = yjVar.qw().get(i2);
            PointF qw2 = qwVar.qw();
            PointF ad3 = qwVar.ad();
            PointF de2 = qwVar.de();
            if (!qw2.equals(qw) || !ad3.equals(de2)) {
                path.cubicTo(qw2.x, qw2.y, ad3.x, ad3.y, de2.x, de2.y);
            } else {
                path.lineTo(de2.x, de2.y);
            }
            qw.set(de2.x, de2.y);
        }
        if (yjVar.fe()) {
            path.close();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static int m230if(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (((float) i2) + (f * ((float) (i3 - i2))));
    }

    public static double o(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float pf(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static PointF qw(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static boolean rg(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m231switch(fe feVar, int i2, List<fe> list, fe feVar2, KeyPathElementContent keyPathElementContent) {
        if (feVar.de(keyPathElementContent.getName(), i2)) {
            list.add(feVar2.qw(keyPathElementContent.getName()).i(keyPathElementContent));
        }
    }

    public static int th(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    public static int uk(int i2, int i3) {
        return i2 - (i3 * th(i2, i3));
    }

    public static int yj(float f, float f2) {
        return uk((int) f, (int) f2);
    }
}
