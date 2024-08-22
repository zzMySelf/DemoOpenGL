package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.o;

public final class qqq implements ResourceDecoder<Bitmap, Bitmap> {

    public static final class qw implements Resource<Bitmap> {

        /* renamed from: ad  reason: collision with root package name */
        public final Bitmap f5975ad;

        public qw(@NonNull Bitmap bitmap) {
            this.f5975ad = bitmap;
        }

        @NonNull
        public Class<Bitmap> ad() {
            return Bitmap.class;
        }

        @NonNull
        /* renamed from: de */
        public Bitmap get() {
            return this.f5975ad;
        }

        public int qw() {
            return o.yj(this.f5975ad);
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
