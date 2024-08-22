package fe.fe.p004if.qw.qw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.HashSet;
import java.util.Set;

/* renamed from: fe.fe.if.qw.qw.fe  reason: invalid package */
public class fe {

    /* renamed from: fe.fe.if.qw.qw.fe$ad */
    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1971ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f1972th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Set f1973yj;

        public ad(Context context, String str, Set set) {
            this.f1971ad = context;
            this.f1972th = str;
            this.f1973yj = set;
        }

        public void run() {
            this.f1971ad.getSharedPreferences("track_sp", 0).edit().putStringSet(this.f1972th, this.f1973yj).apply();
        }
    }

    /* renamed from: fe.fe.if.qw.qw.fe$qw */
    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f1974ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f1975th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Object f1976yj;

        public qw(SharedPreferences sharedPreferences, String str, Object obj) {
            this.f1974ad = sharedPreferences;
            this.f1975th = str;
            this.f1976yj = obj;
        }

        public void run() {
            fe.tt(this.f1974ad, this.f1975th, this.f1976yj);
        }
    }

    public static void a(Context context, Set<String> set) {
        d(context, "track_request", set);
    }

    public static void aaa(Context context) {
        rrr(context, "login_call_time", System.currentTimeMillis());
    }

    public static void ad(Context context) {
        d(context, "track_connection", new HashSet());
        d(context, "track_request", new HashSet());
    }

    public static void b(Context context, String str, Object obj) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("track_sp", 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                fe.fe.p004if.qw.th.qw.qw(context).ad(new qw(sharedPreferences, str, obj));
            } else {
                tt(sharedPreferences, str, obj);
            }
        } catch (Throwable th2) {
            fe.fe.p004if.qw.yj.fe.ad("TrackUtils", th2.getMessage());
        }
    }

    public static void c(Context context, String str, String str2) {
        b(context, str, str2);
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void d(Context context, String str, Set<String> set) {
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                fe.fe.p004if.qw.th.qw.qw(context).ad(new ad(context, str, set));
            } else {
                context.getSharedPreferences("track_sp", 0).edit().putStringSet(str, set).apply();
            }
        } catch (Throwable th2) {
            fe.fe.p004if.qw.yj.fe.ad("TrackUtils", th2.getMessage());
        }
    }

    public static void ddd(Context context, int i2) {
        mmm(context, "track_upload_state", i2);
    }

    public static Set<String> de(Context context) {
        return ppp(context, "track_connection", new HashSet());
    }

    public static void eee(Context context, int i2) {
        mmm(context, "login_open_type", i2);
    }

    public static long fe(Context context) {
        return m113switch(context, "login_call_time", 0);
    }

    public static void ggg(Context context, int i2, int i3) {
        mmm(context, i2 + "real_time_track", i3);
    }

    public static boolean i(Context context, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("real_time_track");
        return m112if(context, sb.toString(), 0) == 1;
    }

    /* renamed from: if  reason: not valid java name */
    public static int m112if(Context context, String str, int i2) {
        return context.getSharedPreferences("track_sp", 0).getInt(str, i2);
    }

    public static void mmm(Context context, String str, int i2) {
        b(context, str, Integer.valueOf(i2));
    }

    public static void nn(Context context, Set<String> set) {
        d(context, "track_connection", set);
    }

    public static boolean o(Context context) {
        return m112if(context, "track_upload_state", 1) == 1;
    }

    public static boolean pf(Context context) {
        long j = m113switch(context, "track_upload_time", -1);
        if (j <= 0) {
            xxx(context);
            return false;
        } else if (System.currentTimeMillis() - j >= 21600000) {
            return true;
        } else {
            return false;
        }
    }

    public static Set<String> ppp(Context context, String str, Set<String> set) {
        return context.getSharedPreferences("track_sp", 0).getStringSet(str, set);
    }

    public static void qqq(Context context, String str, String str2) {
        if (o(context)) {
            c(context, "login_flag_state", System.currentTimeMillis() + ":" + str + ":" + str2);
        }
    }

    public static String[] rg(Context context) {
        return when(context, "login_flag_state", "0:1Y:ext").split(":");
    }

    public static void rrr(Context context, String str, long j) {
        b(context, str, Long.valueOf(j));
    }

    /* renamed from: switch  reason: not valid java name */
    public static long m113switch(Context context, String str, long j) {
        return context.getSharedPreferences("track_sp", 0).getLong(str, j);
    }

    public static int th(Context context) {
        return m112if(context, "login_open_type", -1);
    }

    public static void tt(SharedPreferences sharedPreferences, String str, Object obj) {
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

    public static int uk(Context context) {
        return m112if(context, "track_upload_state_fail_count", 1);
    }

    public static void vvv(Context context, int i2) {
        mmm(context, "track_upload_state_fail_count", i2);
    }

    public static String when(Context context, String str, String str2) {
        return context.getSharedPreferences("track_sp", 0).getString(str, str2);
    }

    public static void xxx(Context context) {
        rrr(context, "track_upload_time", System.currentTimeMillis());
    }

    public static Set<String> yj(Context context) {
        return ppp(context, "track_request", new HashSet());
    }
}
