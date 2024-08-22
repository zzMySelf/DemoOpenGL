package fe.fe.nn.ppp;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.util.Pair;
import com.cmic.sso.sdk.auth.AuthnHelper;
import fe.fe.nn.qw.qw;
import org.json.JSONObject;

/* renamed from: fe.fe.nn.ppp.if  reason: invalid class name */
public class Cif {
    public static String ad(String str, boolean z) {
        return z ? str : "";
    }

    public static Pair<Integer, Integer> de(Context context) {
        int i2;
        int parseInt;
        int parseInt2;
        int i3 = -1;
        Pair<Integer, Integer> pair = new Pair<>(-1, -1);
        try {
            JSONObject networkType = AuthnHelper.getInstance(context).getNetworkType(context);
            if (networkType == null) {
                return pair;
            }
            if (networkType.has("networktype")) {
                parseInt = Integer.parseInt(networkType.optString("networktype", "-1"));
                parseInt2 = Integer.parseInt(networkType.optString("operatortype", "-1"));
            } else if (networkType.has("networkType")) {
                parseInt = Integer.parseInt(networkType.optString("networkType", "-1"));
                parseInt2 = Integer.parseInt(networkType.optString("operatorType", "-1"));
            } else {
                i2 = -1;
                return Pair.create(Integer.valueOf(i3), Integer.valueOf(i2));
            }
            i2 = parseInt2;
            i3 = parseInt;
            return Pair.create(Integer.valueOf(i3), Integer.valueOf(i2));
        } catch (Throwable th2) {
            de.fe(th2);
            return pair;
        }
    }

    public static Pair<Integer, String[]> fe(Context context) {
        return new Pair<>(-1, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
    }

    public static int qw(Context context) {
        try {
            if (!qw.uk(context).rg()) {
                return -1000;
            }
            if (Build.VERSION.SDK_INT < 24) {
                return -1001;
            }
            if (!de.when(context)) {
                return -1002;
            }
            return SubscriptionManager.getDefaultDataSubscriptionId();
        } catch (Throwable th2) {
            de.fe(th2);
            return -1001;
        }
    }
}
