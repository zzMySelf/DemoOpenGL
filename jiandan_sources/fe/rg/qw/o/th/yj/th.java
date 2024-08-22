package fe.rg.qw.o.th.yj;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ad;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.th.de.fe;
import java.security.MessageDigest;

public class th implements Transformation<de> {

    /* renamed from: ad  reason: collision with root package name */
    public final Transformation<Bitmap> f5008ad;

    public th(Transformation<Bitmap> transformation) {
        uk.fe(transformation);
        this.f5008ad = transformation;
    }

    @NonNull
    public Resource<de> ad(@NonNull Context context, @NonNull Resource<de> resource, int i2, int i3) {
        de deVar = resource.get();
        fe feVar = new fe(deVar.fe(), ad.de(context).th());
        Resource<Bitmap> ad2 = this.f5008ad.ad(context, feVar, i2, i3);
        if (!feVar.equals(ad2)) {
            feVar.recycle();
        }
        deVar.pf(this.f5008ad, ad2.get());
        return resource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof th) {
            return this.f5008ad.equals(((th) obj).f5008ad);
        }
        return false;
    }

    public int hashCode() {
        return this.f5008ad.hashCode();
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        this.f5008ad.qw(messageDigest);
    }
}
