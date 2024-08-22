package com.baidu.wallet.base.statistics;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.UAFilterUtil;
import com.baidu.wallet.utils.NetUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class a {
    public static final String a = "a";
    public Pattern b;

    /* renamed from: com.baidu.wallet.base.statistics.a$a  reason: collision with other inner class name */
    public static class C0062a {
        public static a a = new a();
    }

    public static a a() {
        return C0062a.a;
    }

    public String b(Context context) {
        String str;
        try {
            str = PhoneUtils.getCUID2(context);
            try {
                return this.b.matcher(str).replaceAll("");
            } catch (Exception e) {
                e = e;
                LogUtil.d(a, e.getMessage());
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
            LogUtil.d(a, e.getMessage());
            return str;
        }
    }

    public String c(Context context) {
        try {
            return UAFilterUtil.getInstance().getTrueUA(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public String d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e) {
            LogUtil.d(a, e.getMessage());
            return null;
        }
    }

    public String e(Context context) {
        if (AccountManager.getInstance(context).getLoginType() == 0) {
            return SafePay.getInstance().getpwProxy();
        }
        return null;
    }

    public String f(Context context) {
        String gPSLocation = PhoneUtils.getGPSLocation(context);
        if (TextUtils.isEmpty(gPSLocation)) {
            return null;
        }
        return SafePay.getInstance().encryptProxy(gPSLocation);
    }

    public String g(Context context) {
        JSONObject connectedWifi = NetUtils.getConnectedWifi(context);
        if (connectedWifi == null) {
            return null;
        }
        String optString = connectedWifi.optString("ssid", (String) null);
        return optString != null ? SafePay.getInstance().encryptProxy(optString) : optString;
    }

    public a() {
        this.b = Pattern.compile("\\s*|\t|\r|\n");
    }

    public String a(Context context) {
        String str;
        try {
            str = PhoneUtils.getCUID(context);
            try {
                return this.b.matcher(str).replaceAll("");
            } catch (Exception e) {
                e = e;
                LogUtil.d(a, e.getMessage());
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
            LogUtil.d(a, e.getMessage());
            return str;
        }
    }

    public String b() {
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        if (TextUtils.isEmpty(unionId)) {
            return "";
        }
        return SafePay.getInstance().encryptProxy(unionId);
    }
}
