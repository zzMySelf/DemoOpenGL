package com.dxmpay.perm.listener;

import androidx.annotation.NonNull;
import com.dxmpay.apollon.NoProguard;

public interface MerToolPermissionListener extends NoProguard {
    void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
}
