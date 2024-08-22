package com.baidu.swan.apps.impl.permission;

import android.app.Activity;
import com.baidu.android.common.PermissionDialog;
import com.baidu.android.common.PermissionManager;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.swan.apps.permission.IPermissionDialogIOC;

public class PermissionDialogIOC implements IPermissionDialogIOC {
    public void setLauncherSource(String appId) {
        WarmTipsManager.setLauncherSource("swan", appId);
    }

    public boolean canShowConfirmDialog() {
        return WarmTipsManager.canShowConfirmDialog("swan");
    }

    public Object showWarmPermissionDialog(Activity activity, String appId, final IPermissionDialogIOC.OnCloseCallBack closeCallBack, boolean isAddBackground) {
        PermissionDialog permissionDialog = new PermissionDialog();
        permissionDialog.setSource("swan", appId);
        permissionDialog.showWarmPermissionDialog(activity, new PermissionManager.OnCloseCallBack() {
            public void callback() {
                IPermissionDialogIOC.OnCloseCallBack onCloseCallBack = closeCallBack;
                if (onCloseCallBack != null) {
                    onCloseCallBack.callback();
                }
            }
        }, isAddBackground);
        return permissionDialog;
    }

    public boolean handleRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults, Object permissionDialog) {
        if (permissionDialog instanceof PermissionDialog) {
            return ((PermissionDialog) permissionDialog).handleRequestPermissionsResult(activity, requestCode, permissions, grantResults);
        }
        return false;
    }

    public void checkPermissionDialogOnResume(Activity activity, Object permissionDialog) {
        if (permissionDialog instanceof PermissionDialog) {
            ((PermissionDialog) permissionDialog).checkPermissionDialogOnResume(activity);
        }
    }

    public void dismissDialog(Activity activity, Object permissionDialog) {
        if (permissionDialog instanceof PermissionDialog) {
            ((PermissionDialog) permissionDialog).dissmissDialog(activity);
        }
    }
}
