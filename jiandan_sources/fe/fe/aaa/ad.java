package fe.fe.aaa;

import android.content.Context;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static ad f1311ad;
    public Context qw;

    public ad(Context context) {
        this.qw = context;
    }

    public static synchronized ad ad(Context context) {
        ad adVar;
        synchronized (ad.class) {
            if (f1311ad == null) {
                f1311ad = new ad(context);
            }
            adVar = f1311ad;
        }
        return adVar;
    }

    public String de(String str, String str2, String str3) {
        try {
            return this.qw.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void fe(String str, String str2, long j) {
        this.qw.getSharedPreferences(str, 0).edit().putLong(str2, j).commit();
    }

    public long qw(String str, String str2, long j) {
        try {
            return this.qw.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Exception e) {
            e.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public void rg(String str, String str2, String str3) {
        this.qw.getSharedPreferences(str, 0).edit().putString(str2, str3).commit();
    }
}
