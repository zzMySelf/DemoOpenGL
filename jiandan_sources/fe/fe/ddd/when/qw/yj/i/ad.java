package fe.fe.ddd.when.qw.yj.i;

import android.os.Build;
import android.text.TextUtils;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public String f1711ad;

    /* renamed from: de  reason: collision with root package name */
    public String f1712de;

    /* renamed from: fe  reason: collision with root package name */
    public String f1713fe;
    public String qw;

    public ad() {
        ad();
    }

    public final void ad() {
        String str = Build.MODEL;
        this.qw = str;
        if (TextUtils.isEmpty(str)) {
            this.qw = "NUL";
        } else {
            this.qw = this.qw.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f1711ad = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f1711ad = "NUL";
        } else {
            this.f1711ad = this.f1711ad.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f1712de = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f1712de = "0.0";
        } else {
            this.f1712de = this.f1712de.replace("_", "-");
        }
        this.f1713fe = de();
    }

    public final String de() {
        String str = this.qw;
        String str2 = this.f1712de;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = this.f1711ad;
        return str + "_" + str2 + "_" + i2 + "_" + str3;
    }

    public String qw() {
        return this.f1713fe;
    }
}
