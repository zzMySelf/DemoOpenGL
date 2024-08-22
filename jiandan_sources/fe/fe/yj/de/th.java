package fe.fe.yj.de;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.i.qw.qw;
import java.util.HashMap;
import java.util.Locale;

public class th {

    /* renamed from: i  reason: collision with root package name */
    public static HashMap<String, Integer> f3210i = new HashMap<>();

    /* renamed from: o  reason: collision with root package name */
    public static HashMap<String, Integer> f3211o = new HashMap<>();

    /* renamed from: pf  reason: collision with root package name */
    public static String f3212pf = null;

    /* renamed from: uk  reason: collision with root package name */
    public static String f3213uk = "networkparam";

    /* renamed from: yj  reason: collision with root package name */
    public static boolean f3214yj = AppConfig.rg();

    /* renamed from: ad  reason: collision with root package name */
    public boolean f3215ad;

    /* renamed from: de  reason: collision with root package name */
    public String f3216de;

    /* renamed from: fe  reason: collision with root package name */
    public String f3217fe;
    public Context qw = qw.qw();

    /* renamed from: rg  reason: collision with root package name */
    public int f3218rg;

    /* renamed from: th  reason: collision with root package name */
    public int f3219th;

    static {
        f3210i.put("WIFI", 1);
        f3210i.put("3GNET", 21);
        f3210i.put("3GWAP", 22);
        f3210i.put("CMNET", 31);
        f3210i.put("UNINET", 32);
        f3210i.put("CTNET", 33);
        f3210i.put("CMWAP", 41);
        f3210i.put("UNIWAP", 42);
        f3210i.put("CTWAP", 43);
        f3211o.put("46000", 1);
        f3211o.put("46001", 2);
        f3211o.put("46002", 1);
        f3211o.put("46003", 3);
        f3211o.put("46004", 1);
        f3211o.put("46005", 3);
        f3211o.put("46006", 2);
        f3211o.put("46007", 1);
        f3211o.put("46008", 1);
        f3211o.put("46009", 2);
        f3211o.put("46010", 2);
        f3211o.put("46011", 3);
        f3211o.put("46012", 3);
    }

    public String ad() {
        return this.f3217fe;
    }

    public String de() {
        return this.f3216de;
    }

    public int fe() {
        return this.f3218rg;
    }

    public String i(String str) {
        if (TextUtils.equals(str, "5_0")) {
            return !TextUtils.isEmpty(f3212pf) ? f3212pf : str;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "5_0")) {
            f3212pf = str;
        }
        return str;
    }

    @Deprecated
    public String qw() {
        String str;
        long uptimeMillis = f3214yj ? SystemClock.uptimeMillis() : 0;
        ConnectManager connectManager = new ConnectManager(this.qw);
        String netType = connectManager.getNetType();
        int subType = connectManager.getSubType();
        if (!TextUtils.isEmpty(netType)) {
            netType = netType.toUpperCase(Locale.getDefault());
            int i2 = f3210i.get(netType);
            if (i2 == null) {
                i2 = 5;
            }
            str = i2 + "_" + subType;
        } else {
            str = 5 + "_" + subType;
        }
        if (f3214yj) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            "getCurrentNetTypeId cost " + (uptimeMillis2 - uptimeMillis) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName();
        }
        return str;
    }

    public boolean rg() {
        if (!qw.ad().th() || this.f3215ad) {
            return true;
        }
        DeviceIdBag d = DeviceInfoManager.qw.d(qw.qw(), "pub_param", "");
        if (d.errorCode != 3) {
            return true;
        }
        return !th(d.deviceId, this.f3219th);
    }

    public final boolean th(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            Integer num = f3211o.get(str);
            if (num == null) {
                qw.ad().yj(new yj(3));
            } else if (i2 > 30 && (i2 - num.intValue()) % 10 == 0) {
                return true;
            } else {
                if ((i2 == 21 || i2 == 22) && num.intValue() == 2) {
                    return true;
                }
            }
        }
        qw.ad().yj(new yj(2));
        return false;
    }

    public final String uk(int i2, int i3) {
        if (i2 == 21 || i2 == 22 || i2 == 42) {
            i2 = 32;
        } else if (i2 == 41) {
            i2 = 31;
        } else if (i2 == 43) {
            i2 = 33;
        }
        return i2 + "_" + i3;
    }

    public void yj(boolean z) {
        ConnectManager connectManager = new ConnectManager(this.qw);
        String netType = connectManager.getNetType();
        int subType = connectManager.getSubType();
        if (!TextUtils.isEmpty(netType)) {
            String upperCase = netType.toUpperCase(Locale.getDefault());
            if (f3210i.get(upperCase) == null) {
                this.f3219th = 5;
                qw.ad().yj(new yj(4));
            } else {
                this.f3219th = f3210i.get(upperCase).intValue();
            }
            this.f3216de = this.f3219th + "_" + subType;
            this.f3217fe = uk(this.f3219th, subType);
        } else {
            this.f3219th = 5;
            String str = this.f3219th + "_" + subType;
            this.f3216de = str;
            this.f3217fe = str;
        }
        this.f3218rg = subType;
        int i2 = this.f3219th;
        if (i2 == 5 || i2 == 1) {
            this.f3215ad = true;
        } else {
            this.f3215ad = false;
        }
        if (z) {
            this.f3216de = i(this.f3216de);
        }
    }
}
