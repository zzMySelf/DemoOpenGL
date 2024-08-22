package com.sdk.base.module.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

public class PermissionActivity extends Activity {
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getStringArrayExtra("KEY_INPUT_PERMISSIONS") == null) {
            finish();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        finish();
    }
}
