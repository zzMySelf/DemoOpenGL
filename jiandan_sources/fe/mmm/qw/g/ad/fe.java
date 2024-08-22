package fe.mmm.qw.g.ad;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.baidu.android.util.io.ActionJsonData;
import com.tera.scan.permission.util.NotificationPermissionHelper;
import fe.mmm.qw.de.ad.qw.qw;
import fe.mmm.qw.j.de;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public Notification f7831ad;

    /* renamed from: de  reason: collision with root package name */
    public Notification f7832de;

    /* renamed from: fe  reason: collision with root package name */
    public final NotificationManager f7833fe;
    public Notification qw;

    /* renamed from: rg  reason: collision with root package name */
    public NotificationCompat.Builder f7834rg;

    public fe(Context context) {
        if (context != null) {
            if (context instanceof FragmentActivity) {
                NotificationPermissionHelper.ad((FragmentActivity) context);
            }
            this.f7833fe = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(qw.f7755yj, "VersionUpdate", 3);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{500});
                this.f7833fe.createNotificationChannel(notificationChannel);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void ad(Context context, int i2) {
        if (context != null) {
            this.f7832de = new NotificationCompat.Builder(context, qw.f7755yj).setSmallIcon((int) R.mipmap.ic_application_scan_round).setContentIntent(rg(1010, (String) null, context)).setContentTitle(context.getString(R.string.apk_version_info)).setContentText(context.getString(i2)).setAutoCancel(true).setWhen(System.currentTimeMillis()).build();
            qw();
            this.f7833fe.notify(PointerIconCompat.TYPE_NO_DROP, this.f7832de);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void de(Context context, int i2, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        qw();
        NotificationCompat.Builder when = new NotificationCompat.Builder(context, qw.f7755yj).setSmallIcon((int) R.mipmap.ic_application_scan_round).setProgress(100, 0, false).setContentIntent(rg(1010, (String) null, context)).setContentTitle(context.getString(R.string.apk_version_info)).setContentText(String.format(context.getString(i2), new Object[]{str})).setWhen(System.currentTimeMillis());
        this.f7834rg = when;
        this.qw = when.build();
        this.f7833fe.cancel(PointerIconCompat.TYPE_NO_DROP);
        this.f7833fe.notify(1010, this.qw);
    }

    public void fe(Context context, String str) {
        if (context != null) {
            this.f7831ad = new NotificationCompat.Builder(context, qw.f7755yj).setSmallIcon((int) R.mipmap.ic_application_scan_round).setContentTitle(context.getString(R.string.apk_version_info)).setContentText(context.getString(R.string.download_apk_finish_wait_install)).setContentIntent(rg(1011, str, context)).setWhen(System.currentTimeMillis()).build();
            this.f7833fe.cancel(1010);
            this.f7833fe.notify(1011, this.f7831ad);
        }
    }

    public void qw() {
        this.f7833fe.cancel(1010);
        this.f7833fe.cancel(PointerIconCompat.TYPE_NO_DROP);
        this.f7833fe.cancel(1011);
    }

    public final PendingIntent rg(int i2, String str, Context context) {
        if (i2 == 1010) {
            return PendingIntent.getActivity(context, 0, new Intent(), 201326592);
        }
        if (i2 != 1011) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri ad2 = new de().ad(context, str);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(ad2, "application/vnd.android.package-archive");
        return PendingIntent.getActivity(context, 0, intent, 201326592);
    }

    public void th(int i2) {
        NotificationCompat.Builder builder = this.f7834rg;
        if (builder != null && this.f7833fe != null) {
            builder.setProgress(100, i2, false);
            this.qw = this.f7834rg.build();
            this.f7833fe.cancel(PointerIconCompat.TYPE_NO_DROP);
            this.f7833fe.notify(1010, this.qw);
        }
    }
}
