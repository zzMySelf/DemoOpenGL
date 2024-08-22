package fe.i.qw.de;

import android.content.Context;
import android.content.SharedPreferences;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public static SharedPreferences.Editor f4479ad;
    public static SharedPreferences qw;

    static {
        de.class.getClass().getSimpleName();
    }

    public static void ad(Context context, String str, long j) {
        qw(context);
        f4479ad.putLong(str, j);
        f4479ad.commit();
    }

    public static long de(Context context, String str, long j) {
        qw(context);
        return qw.getLong(str, j);
    }

    public static void qw(Context context) {
        if (qw == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("DxmHeartBeatSP", 0);
            qw = sharedPreferences;
            f4479ad = sharedPreferences.edit();
        }
    }
}
