package fe.th.qw.qw.qw;

import android.content.Context;
import android.content.SharedPreferences;

public class ad {

    /* renamed from: fe.th.qw.qw.qw.ad$ad  reason: collision with other inner class name */
    public static final class C0228ad {
        public static final ad qw = new ad();
    }

    public static ad qw() {
        return C0228ad.qw;
    }

    public String ad(Context context) {
        return context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0).getString("stat__lastdata", "");
    }

    public void de(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0).edit();
        edit.putLong("last_evt_id", j);
        edit.commit();
    }

    public void fe(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0).edit();
        edit.putString("stat__lastdata", str);
        edit.commit();
    }

    public long rg(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0);
        try {
            return sharedPreferences.getLong("last_evt_id", 0);
        } catch (ClassCastException unused) {
            return (long) sharedPreferences.getInt("last_evt_id", 0);
        }
    }

    public void th(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0).edit();
        edit.putString("stat_strategy", str);
        edit.commit();
    }

    public String yj(Context context) {
        return context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0).getString("stat_strategy", "");
    }

    public ad() {
    }
}
