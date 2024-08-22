package fe.fe.yj.ad;

import android.text.TextUtils;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static qw f3195ad;
    public String qw;

    public static qw ad() {
        if (f3195ad == null) {
            synchronized (qw.class) {
                if (f3195ad == null) {
                    f3195ad = new qw();
                }
            }
        }
        return f3195ad;
    }

    public void de(String str) {
        this.qw = str;
    }

    public String qw() {
        if (!TextUtils.isEmpty(this.qw)) {
            return this.qw;
        }
        return ad.qw().getAppName();
    }
}
