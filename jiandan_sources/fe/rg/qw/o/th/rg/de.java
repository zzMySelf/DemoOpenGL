package fe.rg.qw.o.th.rg;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;

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
        return this.f4986ad.getClass();
    }

    public int qw() {
        return Math.max(1, this.f4986ad.getIntrinsicWidth() * this.f4986ad.getIntrinsicHeight() * 4);
    }

    public void recycle() {
    }
}
