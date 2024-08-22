package fe.fe.th.ad;

import android.content.Context;
import fe.fe.th.i.i;

public final class qw {

    /* renamed from: de  reason: collision with root package name */
    public static qw f3089de;

    /* renamed from: ad  reason: collision with root package name */
    public i f3090ad;
    public Context qw = null;

    public qw(Context context) {
        this.qw = context.getApplicationContext();
        this.f3090ad = i.yj(context);
    }

    public static qw qw(Context context) {
        if (f3089de == null) {
            f3089de = new qw(context);
        }
        return f3089de;
    }

    public void de(byte[] bArr) {
        new ad(this, fe.fe.th.th.qw.qw(this.qw).ad() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
