package fe.fe.pf.uk;

import android.content.Context;
import android.content.pm.PackageInfo;
import fe.fe.pf.yj.fe.de.th;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public String[] f2947ad;

    /* renamed from: de  reason: collision with root package name */
    public int f2948de;

    /* renamed from: fe  reason: collision with root package name */
    public String f2949fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f2950rg;

    /* renamed from: th  reason: collision with root package name */
    public long f2951th;

    public ad(Context context, String str) {
        this.qw = str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            this.f2949fe = packageInfo.versionName;
            this.f2948de = packageInfo.versionCode;
            this.f2950rg = packageInfo.firstInstallTime;
            this.f2951th = packageInfo.lastUpdateTime;
            this.f2947ad = new String[packageInfo.signatures.length];
            for (int i2 = 0; i2 < this.f2947ad.length; i2++) {
                this.f2947ad[i2] = th.de(packageInfo.signatures[i2].toByteArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "SappInfo{pkg='" + this.qw + ExtendedMessageFormat.QUOTE + ", sigs=" + Arrays.toString(this.f2947ad) + ", vc=" + this.f2948de + ", va=" + this.f2949fe + ", installts=" + this.f2950rg + ", lstupdatets=" + this.f2951th + ExtendedMessageFormat.END_FE;
    }
}
