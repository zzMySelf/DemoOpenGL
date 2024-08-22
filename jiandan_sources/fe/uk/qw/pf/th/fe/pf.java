package fe.uk.qw.pf.th.fe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.uk.qw.pf.fe.mmm.fe;
import java.util.concurrent.locks.Lock;

public final class pf {
    public static final BitmapPool qw = new qw();

    public class qw extends fe {
        public void de(Bitmap bitmap) {
        }
    }

    @Nullable
    public static Bitmap ad(BitmapPool bitmapPool, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
            }
            return null;
        } else if (i3 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock th2 = aaa.th();
            th2.lock();
            Bitmap fe2 = bitmapPool.fe(i2, i3, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(fe2);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap((Bitmap) null);
                return fe2;
            } finally {
                th2.unlock();
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
            }
            return null;
        }
    }

    @Nullable
    public static Resource<Bitmap> qw(BitmapPool bitmapPool, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = ad(bitmapPool, current, i2, i3);
            z = true;
        } else {
            bitmap = null;
        }
        if (!z) {
            bitmapPool = qw;
        }
        return rg.fe(bitmap, bitmapPool);
    }
}
