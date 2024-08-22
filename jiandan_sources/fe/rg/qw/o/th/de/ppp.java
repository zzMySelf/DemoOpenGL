package fe.rg.qw.o.th.de;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.uk;

public final class ppp implements Resource<BitmapDrawable>, Initializable {

    /* renamed from: ad  reason: collision with root package name */
    public final Resources f4970ad;

    /* renamed from: th  reason: collision with root package name */
    public final Resource<Bitmap> f4971th;

    public ppp(@NonNull Resources resources, @NonNull Resource<Bitmap> resource) {
        uk.fe(resources);
        this.f4970ad = resources;
        uk.fe(resource);
        this.f4971th = resource;
    }

    @Nullable
    public static Resource<BitmapDrawable> fe(@NonNull Resources resources, @Nullable Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new ppp(resources, resource);
    }

    @NonNull
    public Class<BitmapDrawable> ad() {
        return BitmapDrawable.class;
    }

    @NonNull
    /* renamed from: de */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f4970ad, this.f4971th.get());
    }

    public void initialize() {
        Resource<Bitmap> resource = this.f4971th;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }

    public int qw() {
        return this.f4971th.qw();
    }

    public void recycle() {
        this.f4971th.recycle();
    }
}
