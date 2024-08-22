package com.baidu.swan.apps.impl.account;

import android.os.Bundle;
import com.baidu.swan.apps.process.delegate.delegation.SwanAppMessengerDelegation;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

public class InstallFaceVerifyModuleDelegation extends SwanAppMessengerDelegation {
    public void execCall(Bundle params) {
        AccountUtils.installFaceVerifyModule(new TypedCallback<Integer>() {
            public void onCallback(Integer resultCode) {
                InstallFaceVerifyModuleDelegation.this.result.putInt("code", Integer.valueOf(resultCode != null ? resultCode.intValue() : -206).intValue());
                InstallFaceVerifyModuleDelegation.this.finish();
            }
        });
    }
}
