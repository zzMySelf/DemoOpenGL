package fe.uk.qw.pf.th.fe;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.uk.qw.vvv.o;

public abstract class th implements Transformation<Bitmap> {
    @NonNull
    public final Resource<Bitmap> ad(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i2, int i3) {
        if (o.ddd(i2, i3)) {
            BitmapPool th2 = Glide.de(context).th();
            Bitmap bitmap = resource.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap de2 = de(th2, bitmap, i2, i3);
            return bitmap.equals(de2) ? resource : rg.fe(de2, th2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public abstract Bitmap de(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3);
}
