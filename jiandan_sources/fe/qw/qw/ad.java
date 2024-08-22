package fe.qw.qw;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.baidu.android.common.others.IStringUtil;
import fe.qw.qw.when.de;
import fe.qw.qw.when.fe;
import java.io.File;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f3225ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static String[] f3226de = null;

    /* renamed from: fe  reason: collision with root package name */
    public static long[] f3227fe = null;

    /* renamed from: i  reason: collision with root package name */
    public static volatile fe f3228i = null;

    /* renamed from: o  reason: collision with root package name */
    public static volatile de f3229o = null;
    public static boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public static int f3230rg;

    /* renamed from: th  reason: collision with root package name */
    public static int f3231th;

    /* renamed from: uk  reason: collision with root package name */
    public static LottieNetworkCacheProvider f3232uk;

    /* renamed from: yj  reason: collision with root package name */
    public static LottieNetworkFetcher f3233yj;

    public class qw implements LottieNetworkCacheProvider {
        public final /* synthetic */ Context qw;

        public qw(Context context) {
            this.qw = context;
        }

        @NonNull
        public File qw() {
            return new File(this.qw.getCacheDir(), "lottie_network_cache");
        }
    }

    public static float ad(String str) {
        int i2 = f3231th;
        if (i2 > 0) {
            f3231th = i2 - 1;
            return 0.0f;
        } else if (!f3225ad) {
            return 0.0f;
        } else {
            int i3 = f3230rg - 1;
            f3230rg = i3;
            if (i3 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f3226de[i3])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f3227fe[f3230rg])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f3226de[f3230rg] + IStringUtil.CURRENT_PATH);
            }
        }
    }

    @NonNull
    public static de de(@NonNull Context context) {
        de deVar = f3229o;
        if (deVar == null) {
            synchronized (de.class) {
                deVar = f3229o;
                if (deVar == null) {
                    deVar = new de(f3232uk != null ? f3232uk : new qw(context));
                    f3229o = deVar;
                }
            }
        }
        return deVar;
    }

    @NonNull
    public static fe fe(@NonNull Context context) {
        fe feVar = f3228i;
        if (feVar == null) {
            synchronized (fe.class) {
                feVar = f3228i;
                if (feVar == null) {
                    feVar = new fe(de(context), f3233yj != null ? f3233yj : new fe.qw.qw.when.ad());
                    f3228i = feVar;
                }
            }
        }
        return feVar;
    }

    public static void qw(String str) {
        if (f3225ad) {
            int i2 = f3230rg;
            if (i2 == 20) {
                f3231th++;
                return;
            }
            f3226de[i2] = str;
            f3227fe[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            f3230rg++;
        }
    }
}
