package com.dxmpay.perm;

import android.content.Context;
import android.os.Build;
import com.dxmpay.perm.bean.MerToolPermInfo;
import com.dxmpay.perm.listener.MerToolPermissionListener;
import com.dxmpay.perm.listener.MerToolSettingDialogListener;
import com.dxmpay.perm.ui.MerToolPermissionActivity;

public class MerToolPermissionManager {
    public static void request(Context context, MerToolPermInfo merToolPermInfo, MerToolPermissionListener merToolPermissionListener) {
        request(context, merToolPermInfo, merToolPermissionListener, (MerToolSettingDialogListener) null);
    }

    public static void request(Context context, MerToolPermInfo merToolPermInfo, MerToolPermissionListener merToolPermissionListener, MerToolSettingDialogListener merToolSettingDialogListener) {
        request(context, new MerToolPermInfo[]{merToolPermInfo}, merToolPermissionListener, merToolSettingDialogListener);
    }

    public static void request(Context context, MerToolPermInfo[] merToolPermInfoArr, MerToolPermissionListener merToolPermissionListener) {
        request(context, merToolPermInfoArr, merToolPermissionListener, (MerToolSettingDialogListener) null);
    }

    public static void request(Context context, MerToolPermInfo[] merToolPermInfoArr, MerToolPermissionListener merToolPermissionListener, MerToolSettingDialogListener merToolSettingDialogListener) {
        if (context != null && merToolPermInfoArr != null && merToolPermissionListener != null && merToolPermInfoArr.length != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                MerToolPermissionActivity.start(context, merToolPermInfoArr, merToolPermissionListener, merToolSettingDialogListener);
                return;
            }
            String[] strArr = new String[merToolPermInfoArr.length];
            int[] iArr = new int[merToolPermInfoArr.length];
            for (int i2 = 0; i2 < merToolPermInfoArr.length; i2++) {
                strArr[i2] = merToolPermInfoArr[i2].getPermission();
                iArr[i2] = 0;
            }
            merToolPermissionListener.onRequestPermissionsResult(merToolPermInfoArr[0].getRequestCode(), strArr, iArr);
        }
    }
}
