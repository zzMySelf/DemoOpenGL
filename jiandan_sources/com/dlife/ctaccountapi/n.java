package com.dlife.ctaccountapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.idl.util.NetUtil;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import java.lang.reflect.Method;

public class n {
    public static int a(int i2) {
        int i3 = -101;
        if (i2 != -101) {
            i3 = -1;
            if (i2 != -1) {
                switch (i2) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 2;
                    case 13:
                    case 18:
                    case 19:
                        return 3;
                    default:
                        return i2;
                }
            }
        }
        return i3;
    }

    public static NetworkInfo a(Context context) {
        if (context == null) {
            return null;
        }
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static void a(Context context, long j) {
        try {
            h.b(context, "key_s_p_dm_time", j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        try {
            h.b(context, "key_s_p_dm", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(Context context) {
        int d = d(context);
        return d != -101 ? (d == -1 || d == 0) ? StringUtil.NULL_STRING : d != 1 ? d != 2 ? d != 3 ? Integer.toString(d) : "4G" : "3G" : "2G" : "WIFI";
    }

    public static String c(Context context) {
        String b = b(context);
        return (b == null || !b.equals("WIFI") || !i(context)) ? b : "BOTH";
    }

    public static int d(Context context) {
        int i2 = 0;
        try {
            NetworkInfo a = a(context);
            if (a == null || !a.isAvailable() || !a.isConnected()) {
                i2 = -1;
                return a(i2);
            }
            int type = a.getType();
            if (type == 1) {
                i2 = -101;
            } else if (type == 0) {
                try {
                    i2 = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i2 == 0) {
                    i2 = a.getSubtype();
                }
            }
            return a(i2);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static String e(Context context) {
        String c = c(context);
        if (!TextUtils.isEmpty(c) && !c.equals(StringUtil.NULL_STRING)) {
            if (c.equals("2G")) {
                return "10";
            }
            if (c.equals("3G")) {
                return BindFastRequest.BIND_FROM_INITIATIVE;
            }
            if (c.equals("4G")) {
                return "12";
            }
            if (c.equals("WIFI")) {
                return "13";
            }
            if (c.equals("BOTH")) {
                return "14";
            }
        }
        return "15";
    }

    public static String f(Context context) {
        String g = g(context);
        return (!TextUtils.isEmpty(g) && !g.equals("1") && g.equals("2")) ? "https://card.e.189.cn/auth/preauth.do" : "https://id6.me/auth/preauth.do";
    }

    public static String g(Context context) {
        if (System.currentTimeMillis() - h(context) > 172800000) {
            return "1";
        }
        try {
            return h.a(context, "key_s_p_dm", "1");
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
    }

    public static long h(Context context) {
        Long l;
        try {
            l = Long.valueOf(h.a(context, "key_s_p_dm_time", 0));
        } catch (Exception e) {
            e.printStackTrace();
            l = null;
        }
        return l.longValue();
    }

    public static boolean i(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th2) {
            CtAuth.warn(NetUtil.TAG, "isMobileEnable error ", th2);
            return true;
        }
    }

    public static boolean j(Context context) {
        NetworkInfo a = a(context);
        return a != null && a.getType() == 0;
    }

    public static boolean k(Context context) {
        NetworkInfo a = a(context);
        return a != null && a.isAvailable();
    }
}
