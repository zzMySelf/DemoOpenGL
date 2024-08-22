package fe.mmm.qw.eee;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tera.scan.permission.IPermission;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Context f7764ad;
    @NotNull
    public final WeakReference<Activity> qw;

    public qw(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.qw = new WeakReference<>(activity);
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
        this.f7764ad = applicationContext;
    }

    public final boolean ad(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        return qw(this.f7764ad, strArr);
    }

    public final boolean de() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.READ_MEDIA_IMAGES"};
        } else {
            strArr = IPermission.qw;
            Intrinsics.checkNotNullExpressionValue(strArr, "STORAGE_GROUP_PERMISSION");
        }
        return ad(strArr);
    }

    public final boolean fe(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) != 0;
    }

    public final boolean qw(@NotNull Context context, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        for (String fe2 : strArr) {
            if (fe(context, fe2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean rg(@NotNull String[] strArr, int i2) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Activity activity = (Activity) this.qw.get();
        if (activity == null || activity.isFinishing() || qw(activity, strArr)) {
            return false;
        }
        ActivityCompat.requestPermissions(activity, strArr, i2);
        return true;
    }

    public final boolean th(int i2) {
        if (Build.VERSION.SDK_INT >= 33) {
            return rg(new String[]{"android.permission.READ_MEDIA_IMAGES"}, i2);
        }
        String[] strArr = IPermission.qw;
        Intrinsics.checkNotNullExpressionValue(strArr, "STORAGE_GROUP_PERMISSION");
        return rg(strArr, i2);
    }
}
