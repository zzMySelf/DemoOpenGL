package fe.rg.qw.o.fe.aaa;

import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import fe.rg.qw.uk.qw;
import java.io.File;
import java.io.IOException;

public class de implements DiskCache {

    /* renamed from: ad  reason: collision with root package name */
    public final File f4754ad;

    /* renamed from: de  reason: collision with root package name */
    public final long f4755de;

    /* renamed from: fe  reason: collision with root package name */
    public final ad f4756fe = new ad();
    public final yj qw;

    /* renamed from: rg  reason: collision with root package name */
    public qw f4757rg;

    @Deprecated
    public de(File file, long j) {
        this.f4754ad = file;
        this.f4755de = j;
        this.qw = new yj();
    }

    public static DiskCache de(File file, long j) {
        return new de(file, j);
    }

    public File ad(Key key) {
        String ad2 = this.qw.ad(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            "Get: Obtained: " + ad2 + " for for Key: " + key;
        }
        try {
            qw.rg ddd = fe().ddd(ad2);
            if (ddd != null) {
                return ddd.qw(0);
            }
            return null;
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final synchronized qw fe() throws IOException {
        if (this.f4757rg == null) {
            this.f4757rg = qw.mmm(this.f4754ad, 1, 1, this.f4755de);
        }
        return this.f4757rg;
    }

    public void qw(Key key, DiskCache.Writer writer) {
        qw.de vvv;
        String ad2 = this.qw.ad(key);
        this.f4756fe.qw(ad2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                "Put: Obtained: " + ad2 + " for for Key: " + key;
            }
            try {
                qw fe2 = fe();
                if (fe2.ddd(ad2) == null) {
                    vvv = fe2.vvv(ad2);
                    if (vvv != null) {
                        if (writer.qw(vvv.th(0))) {
                            vvv.rg();
                        }
                        vvv.ad();
                        this.f4756fe.ad(ad2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + ad2);
                }
            } catch (IOException unused) {
                boolean isLoggable = Log.isLoggable("DiskLruCacheWrapper", 5);
            } catch (Throwable th2) {
                vvv.ad();
                throw th2;
            }
        } finally {
            this.f4756fe.ad(ad2);
        }
    }
}
