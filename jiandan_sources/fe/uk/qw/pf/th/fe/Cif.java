package fe.uk.qw.pf.th.fe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* renamed from: fe.uk.qw.pf.th.fe.if  reason: invalid class name */
public class Cif implements Transformation<Drawable> {

    /* renamed from: ad  reason: collision with root package name */
    public final Transformation<Bitmap> f5959ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f5960de;

    public Cif(Transformation<Bitmap> transformation, boolean z) {
        this.f5959ad = transformation;
        this.f5960de = z;
    }

    @NonNull
    public Resource<Drawable> ad(@NonNull Context context, @NonNull Resource<Drawable> resource, int i2, int i3) {
        BitmapPool th2 = Glide.de(context).th();
        Drawable drawable = resource.get();
        Resource<Bitmap> qw = pf.qw(th2, drawable, i2, i3);
        if (qw != null) {
            Resource<Bitmap> ad2 = this.f5959ad.ad(context, qw, i2, i3);
            if (!ad2.equals(qw)) {
                return fe(context, ad2);
            }
            ad2.recycle();
            return resource;
        } else if (!this.f5960de) {
            return resource;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public Transformation<BitmapDrawable> de() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cif) {
            return this.f5959ad.equals(((Cif) obj).f5959ad);
        }
        return false;
    }

    public final Resource<Drawable> fe(Context context, Resource<Bitmap> resource) {
        return xxx.fe(context.getResources(), resource);
    }

    public int hashCode() {
        return this.f5959ad.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        this.f5959ad.qw(messageDigest);
    }
}
