package fe.uk.qw.pf.th.th;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Resource;

public final class de extends ad<Drawable> {
    public de(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    public static Resource<Drawable> fe(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new de(drawable);
        }
        return null;
    }

    @NonNull
    public Class<Drawable> ad() {
        return this.f5994ad.getClass();
    }

    public int qw() {
        return Math.max(1, this.f5994ad.getIntrinsicWidth() * this.f5994ad.getIntrinsicHeight() * 4);
    }

    public void recycle() {
    }
}
