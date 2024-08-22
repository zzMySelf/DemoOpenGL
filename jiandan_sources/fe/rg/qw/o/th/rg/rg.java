package fe.rg.qw.o.th.rg;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.o.ad;

public class rg implements ResourceDecoder<Drawable, Drawable> {
    @Nullable
    /* renamed from: de */
    public Resource<Drawable> ad(@NonNull Drawable drawable, int i2, int i3, @NonNull ad adVar) {
        return de.fe(drawable);
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Drawable drawable, @NonNull ad adVar) {
        return true;
    }
}
