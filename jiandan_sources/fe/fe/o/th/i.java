package fe.fe.o.th;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.idl.statistics.Statistics;
import com.baidu.util.Base64Encoder;

public class i {

    /* renamed from: fe  reason: collision with root package name */
    public static i f2672fe;

    /* renamed from: ad  reason: collision with root package name */
    public String f2673ad;

    /* renamed from: de  reason: collision with root package name */
    public String f2674de;
    public Context qw;

    public i(Context context) {
        rg(context);
    }

    public static synchronized i qw(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f2672fe == null) {
                f2672fe = new i(context);
            }
            iVar = f2672fe;
        }
        return iVar;
    }

    public String ad() {
        if (!TextUtils.isEmpty(this.f2673ad)) {
            return this.f2673ad;
        }
        String de2 = fe.de(this.qw, "uid_v3", "");
        if (TextUtils.isEmpty(de2)) {
            try {
                de2 = CommonParam.getCUID(this.qw);
            } catch (Exception unused) {
            }
            fe.rg(this.qw, "uid_v3", de2);
        }
        return de2;
    }

    public String de(String str) {
        when when = new when(str);
        when.de("from", Statistics.AS_FILE_NAME);
        when.de("sdk_ver", "3.1");
        when.de("uid", qw(this.qw).fe());
        when.de("network", ggg.qw(this.qw));
        try {
            PackageInfo packageInfo = this.qw.getPackageManager().getPackageInfo(this.qw.getPackageName(), 0);
            when.de("ver", packageInfo.versionCode + "");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return when.toString();
    }

    public String fe() {
        String str;
        if (!TextUtils.isEmpty(this.f2674de)) {
            return this.f2674de;
        }
        String uk2 = ggg.uk(ad());
        if (!TextUtils.isEmpty(uk2)) {
            byte[] qw2 = Base64Encoder.qw(uk2.getBytes());
            if (qw2 != null) {
                str = ggg.uk(new String(qw2));
            }
            return this.f2674de;
        }
        str = "";
        this.f2674de = str;
        return this.f2674de;
    }

    public void rg(Context context) {
        this.qw = context.getApplicationContext();
    }
}
