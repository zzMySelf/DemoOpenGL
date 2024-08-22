package fe.mmm.qw.h;

import android.content.res.Resources;

public class qw {
    public static int qw(int i2) {
        return (int) (((float) i2) * Resources.getSystem().getDisplayMetrics().density);
    }
}
