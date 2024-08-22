package fe.uk.qw.pf.fe.aaa;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;

public final class th {

    /* renamed from: ad  reason: collision with root package name */
    public final int f5727ad;

    /* renamed from: de  reason: collision with root package name */
    public final Context f5728de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f5729fe;
    public final int qw;

    public static final class ad implements de {
        public final DisplayMetrics qw;

        public ad(DisplayMetrics displayMetrics) {
            this.qw = displayMetrics;
        }

        public int ad() {
            return this.qw.widthPixels;
        }

        public int qw() {
            return this.qw.heightPixels;
        }
    }

    public interface de {
        int ad();

        int qw();
    }

    public static final class qw {

        /* renamed from: i  reason: collision with root package name */
        public static final int f5730i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: ad  reason: collision with root package name */
        public ActivityManager f5731ad;

        /* renamed from: de  reason: collision with root package name */
        public de f5732de;

        /* renamed from: fe  reason: collision with root package name */
        public float f5733fe = 2.0f;
        public final Context qw;

        /* renamed from: rg  reason: collision with root package name */
        public float f5734rg = ((float) f5730i);

        /* renamed from: th  reason: collision with root package name */
        public float f5735th = 0.4f;

        /* renamed from: uk  reason: collision with root package name */
        public int f5736uk = 4194304;

        /* renamed from: yj  reason: collision with root package name */
        public float f5737yj = 0.33f;

        public qw(Context context) {
            this.qw = context;
            this.f5731ad = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.f5732de = new ad(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && th.rg(this.f5731ad)) {
                this.f5734rg = 0.0f;
            }
        }

        public th qw() {
            return new th(this);
        }
    }

    public th(qw qwVar) {
        int i2;
        this.f5728de = qwVar.qw;
        if (rg(qwVar.f5731ad)) {
            i2 = qwVar.f5736uk / 2;
        } else {
            i2 = qwVar.f5736uk;
        }
        this.f5729fe = i2;
        int de2 = de(qwVar.f5731ad, qwVar.f5735th, qwVar.f5737yj);
        float ad2 = (float) (qwVar.f5732de.ad() * qwVar.f5732de.qw() * 4);
        int round = Math.round(qwVar.f5734rg * ad2);
        int round2 = Math.round(ad2 * qwVar.f5733fe);
        int i3 = de2 - this.f5729fe;
        int i4 = round2 + round;
        if (i4 <= i3) {
            this.f5727ad = round2;
            this.qw = round;
        } else {
            float f = (float) i3;
            float f2 = qwVar.f5734rg;
            float f3 = qwVar.f5733fe;
            float f4 = f / (f2 + f3);
            this.f5727ad = Math.round(f3 * f4);
            this.qw = Math.round(f4 * qwVar.f5734rg);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(th(this.f5727ad));
            sb.append(", pool size: ");
            sb.append(th(this.qw));
            sb.append(", byte array size: ");
            sb.append(th(this.f5729fe));
            sb.append(", memory class limited? ");
            sb.append(i4 > de2);
            sb.append(", max size: ");
            sb.append(th(de2));
            sb.append(", memoryClass: ");
            sb.append(qwVar.f5731ad.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(rg(qwVar.f5731ad));
            sb.toString();
        }
    }

    public static int de(ActivityManager activityManager, float f, float f2) {
        boolean rg2 = rg(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (rg2) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    @TargetApi(19)
    public static boolean rg(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int ad() {
        return this.qw;
    }

    public int fe() {
        return this.f5727ad;
    }

    public int qw() {
        return this.f5729fe;
    }

    public final String th(int i2) {
        return Formatter.formatFileSize(this.f5728de, (long) i2);
    }
}
