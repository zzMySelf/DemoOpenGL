package fe.mmm.qw.j.mmm;

import android.content.Context;
import fe.mmm.qw.j.rg;
import java.io.File;

public abstract class ad {
    public static volatile de qw;

    public static ad qw(Context context) {
        if (qw == null) {
            synchronized (ad.class) {
                if (qw == null) {
                    qw = new de();
                    ad qw2 = qw.qw(context);
                    return qw2;
                }
            }
        }
        return qw.qw(context);
    }

    public File ad() {
        return rg.ad();
    }

    public String de() {
        File ad2 = ad();
        if (ad2 != null) {
            return ad2.getAbsolutePath();
        }
        return null;
    }

    public abstract File fe();

    public boolean rg() {
        return ad() != null;
    }

    public abstract boolean th();

    public abstract boolean uk();

    public boolean yj() {
        return "mounted".equals(rg.de());
    }
}
