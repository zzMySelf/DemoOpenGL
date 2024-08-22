package fe.fe.nn.ppp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.sso.SSOManager;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import fe.fe.nn.o.qw;
import fe.fe.nn.pf.ad;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static long f2300ad = 3600000;

    /* renamed from: de  reason: collision with root package name */
    public static long f2301de = 86400000;

    /* renamed from: fe  reason: collision with root package name */
    public static long f2302fe = 0;
    public static String qw = null;

    /* renamed from: rg  reason: collision with root package name */
    public static boolean f2303rg = false;

    public static String ad(Context context) {
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th2) {
            fe(th2);
            return "";
        }
    }

    public static JSONObject de(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("1", ad(context));
            jSONObject2.put("2", context.getPackageName());
            jSONObject2.put("3", rg(context));
            jSONObject2.put("4", fe.ad(context));
            jSONObject2.put(BannerBaseItemInfo.TYPE_LOGIN, str);
            jSONObject2.put(BannerBaseItemInfo.TYPE_SCHEME, System.currentTimeMillis());
            jSONObject2.put("7", "");
            jSONObject2.put("8", SSOManager.f1098ad);
            jSONObject2.put("9", "sso");
            jSONObject2.put("10", "1.2.6");
            jSONObject2.put(BindFastRequest.BIND_FROM_INITIATIVE, "");
            jSONObject2.put("12", "");
            jSONObject2.put("13", 1);
            jSONObject2.put("14", yj(context));
            jSONObject2.put("26", "");
            jSONObject2.put("24", qw.qw(context));
            jSONObject2.put("module_section", jSONArray);
            return jSONObject2;
        } catch (Throwable th2) {
            fe(th2);
            return null;
        }
    }

    public static void fe(Throwable th2) {
    }

    public static String i(Context context) {
        try {
            if (!TextUtils.isEmpty(qw)) {
                return qw;
            }
            String P = fe.fe.nn.qw.qw.uk(context).P();
            qw = P;
            if (!TextUtils.isEmpty(P)) {
                return qw;
            }
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (signature == null) {
                return "";
            }
            String fe2 = uk.fe(signature.toByteArray());
            qw = fe2;
            if (TextUtils.isEmpty(fe2)) {
                return "";
            }
            fe.fe.nn.qw.qw.uk(context).w(qw);
            return qw;
        } catch (Throwable th2) {
            fe(th2);
            return "";
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m149if(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            if (!i.qw(context, "android.permission.GET_TASKS")) {
                return true;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (activityManager.getRunningTasks(1) == null || (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) == null) {
                return false;
            }
            return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
        } catch (Throwable th2) {
            fe(th2);
            return false;
        }
    }

    public static void o(Context context) {
        try {
            ppp(context);
            ad.de(context).o();
            ad.de(context).rg();
            long currentTimeMillis = System.currentTimeMillis();
            long q = fe.fe.nn.qw.qw.uk(context).q();
            long ggg = fe.fe.nn.qw.qw.uk(context).ggg();
            long j = currentTimeMillis - q;
            if (j >= ggg) {
                fe.fe.nn.qw.qw.uk(context).xxx(currentTimeMillis);
                ad.qw(context, ggg);
                return;
            }
            ad.qw(context, ggg - j);
        } catch (Throwable th2) {
            fe(th2);
        }
    }

    public static boolean pf(Context context) {
        String[] strArr;
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return m149if(context);
            }
            if (context == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses()) {
                if (next.importance == 100 && next.importanceReasonCode == 0 && (strArr = next.pkgList) != null && strArr.length != 0 && Arrays.asList(strArr).contains(context.getPackageName())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            fe(th2);
            return false;
        }
    }

    public static void ppp(Context context) {
        try {
            String u = fe.fe.nn.qw.qw.uk(context).u();
            String qw2 = qw();
            if (TextUtils.isEmpty(qw2) || !TextUtils.equals(u, qw2)) {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", context.getPackageName());
                jSONObject.put("1", rg(context));
                jSONObject.put("2", "1.2.6");
                jSONObject.put("3", "sso");
                jSONObject.put("4", System.currentTimeMillis());
                jSONArray.put(jSONObject);
                ad.de(context).th(jSONArray.toString(), "1077103", 2);
                fe.fe.nn.qw.qw.uk(context).ddd(qw2);
            }
        } catch (Throwable th2) {
            fe(th2);
        }
    }

    public static String qw() {
        try {
            Calendar instance = Calendar.getInstance();
            int i2 = instance.get(1);
            int i3 = instance.get(5);
            return i2 + "" + (instance.get(2) + 1) + "" + i3;
        } catch (Throwable th2) {
            fe(th2);
            return "";
        }
    }

    public static String rg(Context context) {
        String str;
        Throwable th2;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
            } catch (Throwable th3) {
                th2 = th3;
                fe(th2);
                return str;
            }
        } catch (Throwable th4) {
            th2 = th4;
            str = "";
            fe(th2);
            return str;
        }
        return str;
    }

    /* renamed from: switch  reason: not valid java name */
    public static boolean m150switch(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th2) {
            fe(th2);
            return false;
        }
    }

    public static int th(Context context) {
        try {
            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                default:
                    return 5;
            }
        } catch (Throwable th2) {
            fe(th2);
            return -1;
        }
    }

    public static int uk(Context context) {
        NetworkInfo networkInfo;
        context.deleteDatabase("");
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th2) {
            fe(th2);
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        int type = networkInfo.getType();
        return 1;
    }

    public static boolean when(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f2302fe < 1000) {
            return f2303rg;
        }
        boolean z = m150switch(context) && pf(context);
        f2303rg = z;
        f2302fe = currentTimeMillis;
        return z;
    }

    public static int yj(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return -1;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            return th(context);
        } catch (Throwable th2) {
            fe(th2);
            return -1;
        }
    }
}
