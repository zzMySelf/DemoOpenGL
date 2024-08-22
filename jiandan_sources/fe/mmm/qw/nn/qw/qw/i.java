package fe.mmm.qw.nn.qw.qw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.j.vvv.fe;
import fe.mmm.qw.j.vvv.rg;
import fe.mmm.qw.nn.de.o.ad;

public class i {
    public static String ad(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            qw.ad("NetworkUtil", "uid或bduss为空");
            return str;
        } else if (str.contains("&rand=") || str.contains("?rand=")) {
            qw.ad("NetworkUtil", "添加过rand");
            return str;
        } else {
            boolean z = str.contains("&time=") || str.contains("?time=");
            String str4 = null;
            if (z) {
                int indexOf = str.indexOf("&time=");
                if (indexOf == -1) {
                    indexOf = str.indexOf("?time=");
                }
                int i2 = indexOf + 6;
                try {
                    str4 = str.substring(i2, Math.min(i2 + 10, str.length()));
                } catch (Exception e) {
                    qw.ggg("NetworkUtil", "addRand", e);
                }
                qw.ad("NetworkUtil", "time in url:" + str4);
                if (TextUtils.isEmpty(str4) || str4.length() < 10) {
                    return str;
                }
            } else {
                str4 = String.valueOf(fe.mmm.qw.j.i.ad() / 1000);
            }
            String de2 = de(str2, str3, str4);
            if (TextUtils.isEmpty(de2)) {
                qw.ppp("NetworkUtil", "rand参数为空");
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str5 = "?";
            sb.append(str.contains(str5) ? a.n : str5);
            sb.append("rand");
            sb.append("=");
            sb.append(de2);
            String sb2 = sb.toString();
            if (!z) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                if (sb2.contains(str5)) {
                    str5 = a.n;
                }
                sb3.append(str5);
                sb3.append("time");
                sb3.append("=");
                sb3.append(str4);
                sb2 = sb3.toString();
            }
            qw.ad("NetworkUtil", sb2);
            return sb2;
        }
    }

    public static String de(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        String th2 = th(str2);
        if (TextUtils.isEmpty(th2)) {
            return null;
        }
        String qw = rg.qw(str);
        if (TextUtils.isEmpty(qw)) {
            return null;
        }
        return rg.qw(qw + str2 + th2 + str3 + fe.mmm.qw.de.ad.qw.qw.f7750o);
    }

    public static String fe() {
        int i2;
        qw qwVar = new qw(fe.mmm.qw.ppp.qw.qw.qw().getApplicationContext());
        String de2 = qwVar.de();
        int fe2 = qwVar.fe();
        if (!TextUtils.isEmpty(de2)) {
            String upperCase = de2.toUpperCase();
            if ("WIFI".equals(upperCase)) {
                i2 = 1;
            } else if ("3GNET".equals(upperCase)) {
                i2 = 21;
            } else if ("3GWAP".equals(upperCase)) {
                i2 = 22;
            } else if ("CMNET".equals(upperCase)) {
                i2 = 31;
            } else if ("UNINET".equals(upperCase)) {
                i2 = 32;
            } else if ("CTNET".equals(upperCase)) {
                i2 = 33;
            } else if ("CMWAP".equals(upperCase)) {
                i2 = 41;
            } else if ("UNIWAP".equals(upperCase)) {
                i2 = 42;
            } else if ("CTWAP".equals(upperCase)) {
                i2 = 43;
            }
            qw.ad("NetworkUtil", " APN DBG getCurrentNetworkAPN:" + i2 + "_" + fe2);
            return i2 + "_" + fe2;
        }
        i2 = 0;
        qw.ad("NetworkUtil", " APN DBG getCurrentNetworkAPN:" + i2 + "_" + fe2);
        return i2 + "_" + fe2;
    }

    public static void qw(Context context, ad adVar) {
        if (context != null && adVar != null && !adVar.rg("network_type")) {
            String qw = fe.mmm.qw.ppp.ad.qw.qw.qw(context);
            if (!TextUtils.isEmpty(qw)) {
                adVar.ad("network_type", qw);
            }
        }
    }

    public static boolean rg(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String th(String str) {
        String qw = fe.mmm.qw.nn.fe.qw.qw();
        if (TextUtils.isEmpty(qw)) {
            return null;
        }
        return new String(fe.fe(fe.mmm.qw.j.vvv.qw.de(qw), str));
    }

    public static void yj(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                boolean z = false;
                boolean z2 = activeNetworkInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected();
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.isConnected()) {
                    z = true;
                }
                if (z2 != z) {
                    fe.mmm.qw.nn.ad.qw.qw.qw.vvv("network_type_inconsistent", String.valueOf(z2), String.valueOf(z));
                }
            } catch (Exception e) {
                qw.th("NetworkUtil", e.getMessage(), e);
            }
        }
    }
}
