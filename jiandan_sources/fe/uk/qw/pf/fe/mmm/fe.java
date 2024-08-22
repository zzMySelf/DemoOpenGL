package fe.uk.qw.pf.fe.mmm;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class fe implements BitmapPool {
    public void ad() {
    }

    public void de(Bitmap bitmap) {
        bitmap.recycle();
    }

    @NonNull
    public Bitmap fe(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    public void qw(int i2) {
    }

    @NonNull
    public Bitmap rg(int i2, int i3, Bitmap.Config config) {
        return fe(i2, i3, config);
    }
}
