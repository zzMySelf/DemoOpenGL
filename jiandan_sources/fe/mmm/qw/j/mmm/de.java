package fe.mmm.qw.j.mmm;

import android.content.Context;
import android.os.Build;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static fe f7967ad;

    /* renamed from: de  reason: collision with root package name */
    public static final String f7968de = Build.MODEL.toLowerCase();
    public static qw qw;

    public final boolean ad() {
        String str = f7968de;
        return str != null && str.equals("u8800") && new fe().uk();
    }

    public ad qw(Context context) {
        if (ad()) {
            if (f7967ad == null) {
                f7967ad = new fe();
            }
            return f7967ad;
        }
        if (qw == null) {
            qw = new qw(context);
        }
        return qw;
    }
}
