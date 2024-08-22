package com.baidu.wallet.utils;

import android.text.TextUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.UUID;

public class UUIDGenerator implements NoProguard {
    public static final String TAG = "UUIDGenerator";
    public static String curUUID = "";

    public static String generateUUID() {
        curUUID = UUID.randomUUID().toString().replace("-", "");
        String str = TAG;
        LogUtil.d(str, "生成UUID = " + curUUID);
        return curUUID;
    }

    public static String getCurrentUUID() {
        if (!TextUtils.isEmpty(curUUID)) {
            return curUUID;
        }
        return generateUUID();
    }
}
