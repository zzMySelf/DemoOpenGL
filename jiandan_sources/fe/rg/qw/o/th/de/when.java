package fe.rg.qw.o.th.de;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

public final class when {

    /* renamed from: de  reason: collision with root package name */
    public static final File f4977de = new File("/proc/self/fd");

    /* renamed from: fe  reason: collision with root package name */
    public static volatile when f4978fe;

    /* renamed from: ad  reason: collision with root package name */
    public volatile boolean f4979ad = true;
    public volatile int qw;

    public static when qw() {
        if (f4978fe == null) {
            synchronized (when.class) {
                if (f4978fe == null) {
                    f4978fe = new when();
                }
            }
        }
        return f4978fe;
    }

    public final synchronized boolean ad() {
        boolean z = true;
        int i2 = this.qw + 1;
        this.qw = i2;
        if (i2 >= 50) {
            this.qw = 0;
            int length = f4977de.list().length;
            if (length >= 700) {
                z = false;
            }
            this.f4979ad = z;
            if (!this.f4979ad && Log.isLoggable("Downsampler", 5)) {
                "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + 700;
            }
        }
        return this.f4979ad;
    }

    @TargetApi(26)
    public boolean de(int i2, int i3, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i2 >= 128 && i3 >= 128 && ad();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
