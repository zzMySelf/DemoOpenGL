package fe.uk.qw.pf.fe.aaa;

import android.content.Context;
import com.dxmbumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class fe extends DiskLruCacheFactory {

    public class qw implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f5725ad;
        public final /* synthetic */ Context qw;

        public qw(Context context, String str) {
            this.qw = context;
            this.f5725ad = str;
        }

        public File qw() {
            File cacheDir = this.qw.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f5725ad != null ? new File(cacheDir, this.f5725ad) : cacheDir;
        }
    }

    public fe(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public fe(Context context, String str, long j) {
        super(new qw(context, str), j);
    }
}
