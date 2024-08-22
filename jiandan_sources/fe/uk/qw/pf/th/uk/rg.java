package fe.uk.qw.pf.th.uk;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import fe.uk.qw.vvv.i;
import java.security.MessageDigest;

public class rg implements Transformation<GifDrawable> {

    /* renamed from: ad  reason: collision with root package name */
    public final Transformation<Bitmap> f6002ad;

    public rg(Transformation<Bitmap> transformation) {
        i.fe(transformation);
        this.f6002ad = transformation;
    }

    @NonNull
    public Resource<GifDrawable> ad(@NonNull Context context, @NonNull Resource<GifDrawable> resource, int i2, int i3) {
        GifDrawable gifDrawable = resource.get();
        fe.uk.qw.pf.th.fe.rg rgVar = new fe.uk.qw.pf.th.fe.rg(gifDrawable.getFirstFrame(), Glide.de(context).th());
        Resource<Bitmap> ad2 = this.f6002ad.ad(context, rgVar, i2, i3);
        if (!rgVar.equals(ad2)) {
            rgVar.recycle();
        }
        gifDrawable.setFrameTransformation(this.f6002ad, ad2.get());
        return resource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof rg) {
            return this.f6002ad.equals(((rg) obj).f6002ad);
        }
        return false;
    }

    public int hashCode() {
        return this.f6002ad.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        this.f6002ad.qw(messageDigest);
    }
}
