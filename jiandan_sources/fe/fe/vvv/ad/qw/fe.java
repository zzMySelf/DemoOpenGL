package fe.fe.vvv.ad.qw;

import android.app.Application;
import android.content.Context;

public class fe {
    public static Application qw;

    public static void ad(Application application) {
        qw = application;
    }

    public static Context qw() {
        return qw;
    }
}
