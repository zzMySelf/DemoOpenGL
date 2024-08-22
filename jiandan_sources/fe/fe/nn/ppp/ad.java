package fe.fe.nn.ppp;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static long f2298ad = 3600000;

    /* renamed from: de  reason: collision with root package name */
    public static long f2299de = 86400000;
    public static long qw = 60000;

    public static boolean ad(Context context) {
        try {
            if (context.getApplicationInfo().targetSdkVersion < 31 || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            de.fe(th2);
            return false;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static void qw(Context context, long j) {
        AlarmManager alarmManager;
        PendingIntent pendingIntent;
        if (j > 0) {
            try {
                alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("sso_action_t_m");
                if (ad(context)) {
                    pendingIntent = PendingIntent.getBroadcast(context, 101, intent, 201326592);
                } else {
                    pendingIntent = PendingIntent.getBroadcast(context, 101, intent, 134217728);
                }
                alarmManager.cancel(pendingIntent);
            } catch (Throwable th2) {
                de.fe(th2);
                return;
            }
            alarmManager.set(1, System.currentTimeMillis() + j, pendingIntent);
        }
    }
}
