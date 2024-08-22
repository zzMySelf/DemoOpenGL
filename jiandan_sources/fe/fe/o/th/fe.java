package fe.fe.o.th;

import android.content.Context;
import android.content.SharedPreferences;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static String f2668ad = "1";

    /* renamed from: de  reason: collision with root package name */
    public static String f2669de = "1";

    /* renamed from: fe  reason: collision with root package name */
    public static String f2670fe = "pref_speed_config_key";
    public static String qw = "0";

    /* renamed from: rg  reason: collision with root package name */
    public static String f2671rg = "pref_speed_config_acquire_time_key";

    public static long ad(Context context, String str, long j) {
        return context.getSharedPreferences("pref_download_setting", 0).getLong(str, j);
    }

    public static String de(Context context, String str, String str2) {
        return context.getSharedPreferences("pref_download_setting", 0).getString(str, str2);
    }

    public static long fe(Context context, String str, long j) {
        return context.getSharedPreferences("pref_download_setting", 0).getLong(str, j);
    }

    public static int qw(Context context, String str, int i2) {
        return context.getSharedPreferences("pref_download_setting", 0).getInt(str, i2);
    }

    public static void rg(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && str != null && (sharedPreferences = context.getSharedPreferences("pref_download_setting", 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public static void th(Context context, String str, long j) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && (sharedPreferences = context.getSharedPreferences("pref_download_setting", 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, j);
            edit.commit();
        }
    }
}
