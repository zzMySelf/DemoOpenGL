package com.tera.scan.permission.util;

import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import fe.mmm.qw.eee.de.de.de;
import fe.mmm.qw.eee.de.qw;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/permission/util/NotificationPermissionHelper;", "", "()V", "onRequestPermissionsResult", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "requestCode", "", "permissions", "", "", "grantResults", "", "(Landroidx/fragment/app/FragmentActivity;I[Ljava/lang/String;[I)V", "requestNotificationPermission", "lib_permission_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NotificationPermissionHelper {
    @JvmStatic
    public static final void ad(@Nullable FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.POST_NOTIFICATIONS") == -1) {
                    String string = fragmentActivity.getString(R.string.permission_desc_title_in_notification);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…sc_title_in_notification)");
                    String string2 = fragmentActivity.getString(R.string.permission_desc_detail_in_notification);
                    Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…c_detail_in_notification)");
                    qw.qw(fragmentActivity, string, string2);
                    ActivityCompat.requestPermissions(fragmentActivity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 102);
                }
            } else if (!NotificationManagerCompat.from(fragmentActivity).areNotificationsEnabled()) {
                de deVar = new de();
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                deVar.ad(fragmentActivity, supportFragmentManager, new NotificationPermissionHelper$requestNotificationPermission$1(fragmentActivity));
            }
        }
    }

    @JvmStatic
    public static final void qw(@Nullable FragmentActivity fragmentActivity, int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Integer num;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (fragmentActivity != null && 102 == i2) {
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    num = null;
                    break;
                }
                int i4 = iArr[i3];
                if (i4 != 0) {
                    num = Integer.valueOf(i4);
                    break;
                }
                i3++;
            }
            if (num != null) {
                de deVar = new de();
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                deVar.ad(fragmentActivity, supportFragmentManager, new NotificationPermissionHelper$onRequestPermissionsResult$2(fragmentActivity));
                return;
            }
            qw.ad(fragmentActivity);
        }
    }
}
