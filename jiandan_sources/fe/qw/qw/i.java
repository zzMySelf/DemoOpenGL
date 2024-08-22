package fe.qw.qw;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

public class i extends PorterDuffColorFilter {
    public i(@ColorInt int i2) {
        super(i2, PorterDuff.Mode.SRC_ATOP);
    }
}
