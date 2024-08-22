package com.dxmpay.wallet.transparent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;

public class TransparentActivity extends BaseActivity {
    public static final int REQUEST_CODE_OVERLAY = 999;
    public static final int REQUEST_PERMISSION_WRITE = 2;
    public static final int RESULT_FAILED = 0;
    public static final int RESULT_SUCESS = 1;
    public static SettingCallback callback;
    public static int mRequestCode;

    public class qw implements BaiduWalletUtils.IRequestPermissionCallBack {
        public qw() {
        }

        public void isAllAgree(Boolean bool) {
            if (bool.booleanValue()) {
                if (!PermissionManager.checkCallingOrSelfPermission(TransparentActivity.this, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 2)) {
                    TransparentActivity.this.handlerCallback(0);
                    TransparentActivity.this.finishWithoutAnim();
                    return;
                }
                TransparentActivity.this.onRequestPermissionsResult(2, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{0});
            } else if (Build.VERSION.SDK_INT >= 23) {
                TransparentActivity.this.onRequestPermissionsResult(2, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1});
            }
        }

        public void isShow(String str, Boolean bool) {
        }

        public void requestResult(String str, Boolean bool) {
        }
    }

    /* access modifiers changed from: private */
    public void handlerCallback(int i2) {
        SettingCallback settingCallback = callback;
        if (settingCallback != null) {
            settingCallback.result(i2);
        }
    }

    private void requestWritePermissions() {
        BaiduWalletUtils.requestPermissionsDialog((String) null, this, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new qw());
    }

    public static void startTransparentActivity(Context context, SettingCallback settingCallback, int i2) {
        callback = settingCallback;
        mRequestCode = i2;
        context.startActivity(new Intent(context, TransparentActivity.class));
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 999) {
            handlerCallback(0);
        } else if (Build.VERSION.SDK_INT < 23) {
            handlerCallback(0);
        } else if (!Settings.canDrawOverlays(this)) {
            handlerCallback(0);
        } else {
            handlerCallback(1);
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i2 = mRequestCode;
        if (i2 == 2) {
            requestWritePermissions();
        } else if (i2 != 999) {
            handlerCallback(0);
            finish();
        } else {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 999);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (callback != null) {
            callback = null;
        }
        mRequestCode = 0;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 2) {
            return;
        }
        if (strArr == null || iArr == null || strArr.length == 0 || iArr.length == 0) {
            handlerCallback(0);
            finishWithoutAnim();
            return;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i3]) && iArr != null && iArr.length > i3) {
                if (iArr[i3] == 0) {
                    handlerCallback(1);
                    finishWithoutAnim();
                } else if (-1 == iArr[i3]) {
                    handlerCallback(0);
                    finishWithoutAnim();
                }
            }
        }
    }
}
