package fe.rg.qw.o.th.de;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.i;
import fe.rg.qw.o.ad;

public final class ddd implements ResourceDecoder<Bitmap, Bitmap> {

    public static final class qw implements Resource<Bitmap> {

        /* renamed from: ad  reason: collision with root package name */
        public final Bitmap f4956ad;

        public qw(@NonNull Bitmap bitmap) {
            this.f4956ad = bitmap;
        }

        @NonNull
        public Class<Bitmap> ad() {
            return Bitmap.class;
        }

        @NonNull
        /* renamed from: de */
        public Bitmap get() {
            return this.f4956ad;
        }

        public int qw() {
            return i.yj(this.f4956ad);
        }

        public void recycle() {
        }
    }

    /* renamed from: de */
    public Resource<Bitmap> ad(@NonNull Bitmap bitmap, int i2, int i3, @NonNull ad adVar) {
        return new qw(bitmap);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Bitmap bitmap, @NonNull ad adVar) {
        return true;
    }
}
