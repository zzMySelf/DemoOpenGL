package com.baidu.android.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import fe.fe.fe.th;

public final class Util {
    public static final boolean a = false;
    public static final String b = "Util";

    public static boolean hasOtherServiceRuninMyPid(Context context, String str) {
        for (ActivityManager.RunningServiceInfo next : ((ActivityManager) context.getApplicationContext().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(100)) {
            if (next.pid == Process.myPid() && !TextUtils.equals(next.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        return th.de.qw(bArr, str, z);
    }

    public static String toMd5(byte[] bArr, boolean z) {
        return th.de.ad(bArr, z);
    }
}
