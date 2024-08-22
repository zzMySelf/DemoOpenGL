package com.baidu.swan.card.utils.ipc.delegation;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.card.storage.sp.IpcSp;
import com.baidu.swan.card.storage.sp.SpMethodInfo;
import com.baidu.swan.card.storage.sp.SwanAppSpHelper;

public class SwanAppSharedPrefsPutDelegation extends SwanAppSharedPrefsDelegation {
    /* access modifiers changed from: protected */
    public Bundle doSpMethodCall(SpMethodInfo info) {
        IpcSp sp = SwanAppSpHelper.getInstance(info.mSpName);
        if (sp != null) {
            switch (info.mDataType) {
                case 1:
                    sp.putInt(info.mPrefName, Integer.parseInt(info.mDataValue));
                    break;
                case 2:
                    sp.putLong(info.mPrefName, Long.parseLong(info.mDataValue));
                    break;
                case 3:
                    sp.putBoolean(info.mPrefName, Boolean.parseBoolean(info.mDataValue));
                    break;
                case 4:
                    sp.putString(info.mPrefName, info.mDataValue);
                    break;
                case 5:
                    sp.putFloat(info.mPrefName, Float.parseFloat(info.mDataValue));
                    break;
                default:
                    if (DEBUG) {
                        throw new IllegalArgumentException("wrong info params.");
                    }
                    break;
            }
            if (DEBUG) {
                Log.d("SwanAppSpDelegation", "Put: " + info);
            }
            return Bundle.EMPTY;
        } else if (!DEBUG) {
            return Bundle.EMPTY;
        } else {
            throw new IllegalArgumentException("illegal sp.");
        }
    }
}
