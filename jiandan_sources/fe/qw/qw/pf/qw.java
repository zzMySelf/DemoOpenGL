package fe.qw.qw.pf;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

public class qw extends Paint {
    public qw() {
    }

    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public qw(int i2) {
        super(i2);
    }

    public qw(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public qw(int i2, PorterDuff.Mode mode) {
        super(i2);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
