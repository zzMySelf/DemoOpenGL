package fe.fe.p004if.qw.yj;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.util.KVStorageFactory;

/* renamed from: fe.fe.if.qw.yj.rg  reason: invalid package */
public class rg {

    /* renamed from: fe.fe.if.qw.yj.rg$qw */
    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f1988ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f1989th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Object f1990yj;

        public qw(SharedPreferences sharedPreferences, String str, Object obj) {
            this.f1988ad = sharedPreferences;
            this.f1989th = str;
            this.f1990yj = obj;
        }

        public void run() {
            rg.b(this.f1988ad, this.f1989th, this.f1990yj);
        }
    }

    public static void a(Context context, String str, int i2) {
        c(context, str, Integer.valueOf(i2));
    }

    public static void aaa(Context context, int i2) {
        a(context, "protocols_size", i2);
    }

    public static String ad(Context context) {
        return ggg(context, "blcp_app_id", "");
    }

    public static void b(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof Boolean) {
            sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
        } else if (obj instanceof Integer) {
            sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
        } else if (obj instanceof Long) {
            sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
        } else if (obj instanceof Float) {
            sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
        } else if (obj instanceof String) {
            sharedPreferences.edit().putString(str, (String) obj).apply();
        }
    }

    public static void c(Context context, String str, Object obj) {
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = KVStorageFactory.getSharedPreferences("blcp_sp", 0);
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    fe.fe.p004if.qw.th.qw.qw(context).ad(new qw(sharedPreferences, str, obj));
                } else {
                    b(sharedPreferences, str, obj);
                }
            } catch (Throwable th2) {
                fe.ad("SpUtils", th2.getMessage());
            }
        }
    }

    public static void d(Context context, String str, String str2) {
        c(context, str, str2);
    }

    public static void ddd(Context context, String str) {
        d(context, "blcp_cuid", str);
    }

    public static boolean de(Context context) {
        return when(context, "bddns_enable", false);
    }

    public static void eee(Context context, String str) {
        d(context, "blcp_token", str);
    }

    public static int fe(Context context) {
        return ppp(context, "conn_type", 1);
    }

    public static String ggg(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        return KVStorageFactory.getSharedPreferences("blcp_sp", 0).getString(str, str2);
    }

    public static int i(Context context) {
        return ppp(context, "protocols_size", 1);
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m114if(Context context) {
        return when(context, "lcp_debug", false);
    }

    public static void mmm(Context context, String str, int i2) {
        d(context, "protocol_priority" + i2, str);
    }

    public static void nn(Context context, int i2) {
        a(context, "key_vip_connect_type", i2);
    }

    public static String o(Context context) {
        return ggg(context, "blcp_token", "");
    }

    public static boolean pf(Context context) {
        return !TextUtils.isEmpty(o(context));
    }

    public static int ppp(Context context, String str, int i2) {
        if (context == null) {
            return -1;
        }
        return KVStorageFactory.getSharedPreferences("blcp_sp", 0).getInt(str, i2);
    }

    public static void qqq(Context context, boolean z) {
        qw.qw().de(z);
        rrr(context, "small_flow", z);
    }

    public static String rg(Context context) {
        return ggg(context, "blcp_cuid", "");
    }

    public static void rrr(Context context, String str, boolean z) {
        c(context, str, Boolean.valueOf(z));
    }

    /* renamed from: switch  reason: not valid java name */
    public static boolean m115switch(Context context) {
        if (qw.qw().ad() || when(context, "small_flow", true)) {
            return true;
        }
        return false;
    }

    public static int th(Context context) {
        return ppp(context, "key_vip_connect_type", 3);
    }

    public static void tt(Context context, int i2) {
        a(context, "conn_type", i2);
    }

    public static String uk(Context context, int i2) {
        return ggg(context, "protocol_priority" + i2, " : : ");
    }

    public static void vvv(Context context, String str) {
        d(context, "blcp_app_id", str);
    }

    public static boolean when(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        return KVStorageFactory.getSharedPreferences("blcp_sp", 0).getBoolean(str, z);
    }

    public static void xxx(Context context, boolean z) {
        rrr(context, "bddns_enable", z);
    }

    public static int yj(Context context) {
        return ppp(context, "lcp_env_debug", 0);
    }
}
