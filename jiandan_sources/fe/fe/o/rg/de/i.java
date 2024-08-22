package fe.fe.o.rg.de;

import android.content.Context;
import fe.fe.o.de.fe;

public final class i {

    /* renamed from: de  reason: collision with root package name */
    public static i f2623de;

    /* renamed from: ad  reason: collision with root package name */
    public qw f2624ad;
    public Context qw;

    public i(Context context, fe feVar) {
        this.qw = context;
        this.f2624ad = new qw(this.qw, feVar);
    }

    public static i ad(Context context) {
        return de(context, (fe) null);
    }

    public static i de(Context context, fe feVar) {
        if (f2623de == null) {
            synchronized (i.class) {
                if (f2623de == null) {
                    if (context == null) {
                        return null;
                    }
                    f2623de = new i(context.getApplicationContext(), feVar);
                }
            }
        }
        return f2623de;
    }

    public qw qw() {
        return this.f2624ad;
    }
}
