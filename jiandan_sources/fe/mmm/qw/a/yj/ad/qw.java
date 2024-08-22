package fe.mmm.qw.a.yj.ad;

import android.content.Context;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import kotlin.jvm.JvmInline;

@JvmInline
@Tag("Temperature")
public final class qw {
    public static final Double ad(Context context, boolean z, Double d, String str) {
        Double d2 = null;
        if (d == null) {
            return null;
        }
        d.doubleValue();
        if (z) {
            if (ad.qw.contains(d)) {
                ad.ad(str);
                return d;
            }
            double d3 = (double) 1000;
            if (ad.qw.contains(Double.valueOf(d.doubleValue() / d3))) {
                ad.ad(str);
                return Double.valueOf(d.doubleValue() / d3);
            }
        } else if (ad.qw.contains(d)) {
            ad.de((String) LoggerKt.d$default(str, (Object) null, 1, (Object) null));
            return d;
        } else {
            double d4 = (double) 10;
            if (ad.qw.contains(Double.valueOf(d.doubleValue() / d4))) {
                ad.de((String) LoggerKt.d$default(str, (Object) null, 1, (Object) null));
                d2 = Double.valueOf(d.doubleValue() / d4);
            } else {
                double d5 = (double) 1000;
                if (ad.qw.contains(Double.valueOf(d.doubleValue() / d5))) {
                    ad.de((String) LoggerKt.d$default(str, (Object) null, 1, (Object) null));
                    d2 = Double.valueOf(d.doubleValue() / d5);
                }
            }
        }
        return d2;
    }
}
