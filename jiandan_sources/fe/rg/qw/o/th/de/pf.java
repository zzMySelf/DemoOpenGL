package fe.rg.qw.o.th.de;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import fe.rg.qw.ad;
import java.security.MessageDigest;

public class pf implements Transformation<Drawable> {

    /* renamed from: ad  reason: collision with root package name */
    public final Transformation<Bitmap> f4968ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f4969de;

    public pf(Transformation<Bitmap> transformation, boolean z) {
        this.f4968ad = transformation;
        this.f4969de = z;
    }

    @NonNull
    public Resource<Drawable> ad(@NonNull Context context, @NonNull Resource<Drawable> resource, int i2, int i3) {
        BitmapPool th2 = ad.de(context).th();
        Drawable drawable = resource.get();
        Resource<Bitmap> qw = o.qw(th2, drawable, i2, i3);
        if (qw != null) {
            Resource<Bitmap> ad2 = this.f4968ad.ad(context, qw, i2, i3);
            if (!ad2.equals(qw)) {
                return fe(context, ad2);
            }
            ad2.recycle();
            return resource;
        } else if (!this.f4969de) {
            return resource;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public Transformation<BitmapDrawable> de() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof pf) {
            return this.f4968ad.equals(((pf) obj).f4968ad);
        }
        return false;
    }

    public final Resource<Drawable> fe(Context context, Resource<Bitmap> resource) {
        return ppp.fe(context.getResources(), resource);
    }

    public int hashCode() {
        return this.f4968ad.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        this.f4968ad.qw(messageDigest);
    }
}
