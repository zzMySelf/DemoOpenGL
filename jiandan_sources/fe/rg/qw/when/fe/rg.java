package fe.rg.qw.when.fe;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class rg {
    @NonNull
    public <Z> yj<ImageView, Z> qw(@NonNull ImageView imageView, @NonNull Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new ad(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new de(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
