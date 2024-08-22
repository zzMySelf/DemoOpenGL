package fe.mmm.qw.o.qw.ad.ad;

import android.content.Context;
import android.view.WindowManager;

public class qw {
    public static int qw(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }
}
