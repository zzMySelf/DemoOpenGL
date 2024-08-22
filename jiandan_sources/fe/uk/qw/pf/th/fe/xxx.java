package fe.uk.qw.pf.th.fe;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Initializable;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.vvv.i;

public final class xxx implements Resource<BitmapDrawable>, Initializable {

    /* renamed from: ad  reason: collision with root package name */
    public final Resources f5980ad;

    /* renamed from: th  reason: collision with root package name */
    public final Resource<Bitmap> f5981th;

    public xxx(@NonNull Resources resources, @NonNull Resource<Bitmap> resource) {
        i.fe(resources);
        this.f5980ad = resources;
        i.fe(resource);
        this.f5981th = resource;
    }

    @Nullable
    public static Resource<BitmapDrawable> fe(@NonNull Resources resources, @Nullable Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new xxx(resources, resource);
    }

    @NonNull
    public Class<BitmapDrawable> ad() {
        return BitmapDrawable.class;
    }

    @NonNull
    /* renamed from: de */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f5980ad, this.f5981th.get());
    }

    public void initialize() {
        Resource<Bitmap> resource = this.f5981th;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }

    public int qw() {
        return this.f5981th.qw();
    }

    public void recycle() {
        this.f5981th.recycle();
    }
}
