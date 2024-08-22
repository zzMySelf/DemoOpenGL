package fe.uk.qw.pf.fe.aaa;

import android.util.Log;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.cache.DiskCache;
import fe.uk.qw.i.qw;
import java.io.File;
import java.io.IOException;

public class de implements DiskCache {

    /* renamed from: ad  reason: collision with root package name */
    public final File f5721ad;

    /* renamed from: de  reason: collision with root package name */
    public final long f5722de;

    /* renamed from: fe  reason: collision with root package name */
    public final ad f5723fe = new ad();
    public final yj qw;

    /* renamed from: rg  reason: collision with root package name */
    public qw f5724rg;

    @Deprecated
    public de(File file, long j) {
        this.f5721ad = file;
        this.f5722de = j;
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
            qw.rg mmm = fe().mmm(ad2);
            if (mmm != null) {
                return mmm.qw(0);
            }
            return null;
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final synchronized qw fe() throws IOException {
        if (this.f5724rg == null) {
            this.f5724rg = qw.qqq(this.f5721ad, 1, 1, this.f5722de);
        }
        return this.f5724rg;
    }

    public void qw(Key key, DiskCache.Writer writer) {
        qw.de xxx;
        String ad2 = this.qw.ad(key);
        this.f5723fe.qw(ad2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                "Put: Obtained: " + ad2 + " for for Key: " + key;
            }
            try {
                qw fe2 = fe();
                if (fe2.mmm(ad2) == null) {
                    xxx = fe2.xxx(ad2);
                    if (xxx != null) {
                        if (writer.qw(xxx.th(0))) {
                            xxx.rg();
                        }
                        xxx.ad();
                        this.f5723fe.ad(ad2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + ad2);
                }
            } catch (IOException unused) {
                boolean isLoggable = Log.isLoggable("DiskLruCacheWrapper", 5);
            } catch (Throwable th2) {
                xxx.ad();
                throw th2;
            }
        } finally {
            this.f5723fe.ad(ad2);
        }
    }
}
