package fe.uk.qw.pf.th.fe;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ppp {

    /* renamed from: i  reason: collision with root package name */
    public static final File f5965i = new File("/proc/self/fd");

    /* renamed from: o  reason: collision with root package name */
    public static volatile ppp f5966o;

    /* renamed from: pf  reason: collision with root package name */
    public static volatile int f5967pf = -1;

    /* renamed from: uk  reason: collision with root package name */
    public static final boolean f5968uk;

    /* renamed from: yj  reason: collision with root package name */
    public static final boolean f5969yj = (Build.VERSION.SDK_INT < 29);

    /* renamed from: ad  reason: collision with root package name */
    public final int f5970ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f5971de;
    @GuardedBy("this")

    /* renamed from: fe  reason: collision with root package name */
    public int f5972fe;
    public final boolean qw = th();
    @GuardedBy("this")

    /* renamed from: rg  reason: collision with root package name */
    public boolean f5973rg = true;

    /* renamed from: th  reason: collision with root package name */
    public final AtomicBoolean f5974th = new AtomicBoolean(false);

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 26) {
            z = false;
        }
        f5968uk = z;
    }

    @VisibleForTesting
    public ppp() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5970ad = 20000;
            this.f5971de = 0;
            return;
        }
        this.f5970ad = 700;
        this.f5971de = 128;
    }

    public static ppp ad() {
        if (f5966o == null) {
            synchronized (ppp.class) {
                if (f5966o == null) {
                    f5966o = new ppp();
                }
            }
        }
        return f5966o;
    }

    public static boolean th() {
        return !yj() && !uk();
    }

    public static boolean uk() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList(new String[]{"LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM"}).contains(Build.MODEL);
    }

    public static boolean yj() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        for (String startsWith : Arrays.asList(new String[]{"SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play"})) {
            if (Build.MODEL.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public final int de() {
        if (f5967pf != -1) {
            return f5967pf;
        }
        return this.f5970ad;
    }

    public final synchronized boolean fe() {
        boolean z = true;
        int i2 = this.f5972fe + 1;
        this.f5972fe = i2;
        if (i2 >= 50) {
            this.f5972fe = 0;
            int length = f5965i.list().length;
            long de2 = (long) de();
            if (((long) length) >= de2) {
                z = false;
            }
            this.f5973rg = z;
            if (!z && Log.isLoggable("Downsampler", 5)) {
                "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + de2;
            }
        }
        return this.f5973rg;
    }

    @TargetApi(26)
    public boolean i(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean rg2 = rg(i2, i3, z, z2);
        if (rg2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return rg2;
    }

    public final boolean qw() {
        return f5969yj && !this.f5974th.get();
    }

    public boolean rg(int i2, int i3, boolean z, boolean z2) {
        if (!z) {
            boolean isLoggable = Log.isLoggable("HardwareConfig", 2);
            return false;
        } else if (!this.qw) {
            boolean isLoggable2 = Log.isLoggable("HardwareConfig", 2);
            return false;
        } else if (!f5968uk) {
            boolean isLoggable3 = Log.isLoggable("HardwareConfig", 2);
            return false;
        } else if (qw()) {
            boolean isLoggable4 = Log.isLoggable("HardwareConfig", 2);
            return false;
        } else if (z2) {
            boolean isLoggable5 = Log.isLoggable("HardwareConfig", 2);
            return false;
        } else {
            int i4 = this.f5971de;
            if (i2 < i4) {
                boolean isLoggable6 = Log.isLoggable("HardwareConfig", 2);
                return false;
            } else if (i3 < i4) {
                boolean isLoggable7 = Log.isLoggable("HardwareConfig", 2);
                return false;
            } else if (fe()) {
                return true;
            } else {
                boolean isLoggable8 = Log.isLoggable("HardwareConfig", 2);
                return false;
            }
        }
    }
}
