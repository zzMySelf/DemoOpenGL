package com.baidu.swan.card.impl.modules.account.delegation;

import android.os.Bundle;
import com.baidu.swan.card.impl.modules.account.AccountUtils;
import com.baidu.swan.card.utils.ipc.delegation.base.PlaceholderDelegation;
import com.baidu.swan.card.utils.typedbox.TypedCallback;

public class InstallFaceVerifyModuleDelegation implements PlaceholderDelegation {
    /* access modifiers changed from: private */
    public Bundle mResult = new Bundle();

    public void execCall(Bundle params) {
        AccountUtils.installFaceVerifyModule(new TypedCallback<Integer>() {
            public void onCallback(Integer resultCode) {
                InstallFaceVerifyModuleDelegation.this.mResult.putInt("code", Integer.valueOf(resultCode != null ? resultCode.intValue() : -206).intValue());
            }
        });
    }
}
