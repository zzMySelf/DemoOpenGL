package com.baidu.wallet.core.permission;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermissionActivity extends BaseActivity {
    public static final int PERMISSION_REQUEST_CODE = 64;
    public boolean isRequireCheck;
    public String key;
    public String[] permission;

    private void permissionsDenied(List list) {
        PermissionListener fetchListener = PermissionsUtil.fetchListener(this.key);
        if (fetchListener != null) {
            fetchListener.permissionDenied(list);
        }
        overridePendingTransition(0, 0);
        finish();
    }

    private void permissionsGranted() {
        PermissionListener fetchListener = PermissionsUtil.fetchListener(this.key);
        if (fetchListener != null) {
            fetchListener.permissionGranted(Arrays.asList(this.permission));
        }
        finish();
    }

    private void requestPermissions(String[] strArr) {
        if (!PermissionManager.checkCallingOrSelfPermission(getActivity(), strArr, 64)) {
            permissionsDenied(new ArrayList(Arrays.asList(strArr)));
        }
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public boolean isSlidingEnable() {
        return false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null || !getIntent().hasExtra("permission")) {
            finish();
            return;
        }
        this.isRequireCheck = true;
        this.permission = getIntent().getStringArrayExtra("permission");
        this.key = getIntent().getStringExtra("key");
    }

    public void onDestroy() {
        PermissionsUtil.fetchListener(this.key);
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != 64) {
            return;
        }
        if (!PermissionsUtil.isGranted(iArr) || !PermissionsUtil.hasPermission(this, strArr)) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (!PermissionsUtil.hasPermission(getActivity(), strArr[i3])) {
                    arrayList.add(strArr[i3]);
                }
            }
            permissionsDenied(arrayList);
            return;
        }
        permissionsGranted();
    }

    public void onResume() {
        super.onResume();
        if (!this.isRequireCheck) {
            this.isRequireCheck = true;
        } else if (PermissionsUtil.hasPermission(this, this.permission)) {
            permissionsGranted();
        } else {
            requestPermissions(this.permission);
            this.isRequireCheck = false;
        }
    }
}
