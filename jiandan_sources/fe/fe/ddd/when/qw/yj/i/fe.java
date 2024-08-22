package fe.fe.ddd.when.qw.yj.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.i.qw.qw;
import java.util.HashMap;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f1723ad = AppConfig.rg();

    /* renamed from: de  reason: collision with root package name */
    public static String f1724de = "networkparam";

    /* renamed from: fe  reason: collision with root package name */
    public static HashMap<String, Integer> f1725fe;
    public Context qw = qw.qw();

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f1725fe = hashMap;
        hashMap.put("WIFI", 1);
        f1725fe.put("3GNET", 21);
        f1725fe.put("3GWAP", 22);
        f1725fe.put("CMNET", 31);
        f1725fe.put("UNINET", 32);
        f1725fe.put("CTNET", 33);
        f1725fe.put("CMWAP", 41);
        f1725fe.put("UNIWAP", 42);
        f1725fe.put("CTWAP", 43);
    }

    public String ad() {
        String str;
        long uptimeMillis = f1723ad ? SystemClock.uptimeMillis() : 0;
        ConnectManager connectManager = new ConnectManager(this.qw);
        String netType = connectManager.getNetType();
        int subType = connectManager.getSubType();
        if (!TextUtils.isEmpty(netType)) {
            netType = netType.toUpperCase();
            int i2 = f1725fe.get(netType);
            if (i2 == null) {
                i2 = 5;
            }
            str = i2 + "_" + subType;
        } else {
            str = 5 + "_" + subType;
        }
        if (f1723ad) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            "getCurrentNetTypeId cost " + (uptimeMillis2 - uptimeMillis) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName();
        }
        return str;
    }

    public String qw(String str, boolean z) {
        if (!z) {
            return UrlUtil.addParam(str, "network", ad());
        }
        String ad2 = ad();
        if (TextUtils.equals(ad2, "5_0")) {
            return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.qw.getApplicationContext()).getString("last network type", "5_0"));
        }
        if (TextUtils.isEmpty(ad2)) {
            return str;
        }
        if (!TextUtils.equals(ad2, "5_0")) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.qw.getApplicationContext()).edit();
            edit.putString("last network type", ad2);
            edit.apply();
        }
        return UrlUtil.addParam(str, "network", ad2);
    }
}
