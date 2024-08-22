package com.baidu.wallet.utils;

import android.text.TextUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;

public class LbAbilityNewWayUtils implements NoProguard {
    public static String ABILITY_NEW_WAY_METHODS = "[\"gotoDXMPayService\"]";
    public static Set<String> mSets = new HashSet();

    public static void generateCallbackKey(StringBuffer stringBuffer, String str) {
        try {
            if (mSets.isEmpty()) {
                generateLocalMethodList();
            }
            if (!mSets.isEmpty() && mSets.contains(str)) {
                stringBuffer.append(":");
                stringBuffer.append(System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("generateCallbackKey exception:: ");
            sb.append(e);
            LogUtil.d("LbAbilityNewWayUtils", sb.toString() != null ? e.toString() : "");
        }
    }

    public static void generateLocalMethodList() {
        Set<String> set;
        List<String> generateMethodList = generateMethodList(ABILITY_NEW_WAY_METHODS);
        if (!(generateMethodList == null || (set = mSets) == null)) {
            set.clear();
            mSets.addAll(generateMethodList);
        }
        LogUtil.d("LbAbilityNewWayUtils", "use local methods");
    }

    public static List<String> generateMethodList(String str) {
        try {
            String[] strArr = (String[]) JsonUtils.fromJson(str, String[].class);
            if (strArr != null) {
                if (strArr.length > 0) {
                    return Arrays.asList(strArr);
                }
            }
            return null;
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("generateMethodList exception:: ");
            sb.append(e);
            LogUtil.d("LbAbilityNewWayUtils", sb.toString() != null ? e.toString() : "");
            return null;
        }
    }

    public static void setAbilityNewWayMethods(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.d("LbAbilityNewWayUtils", "methods is empty");
            generateLocalMethodList();
            return;
        }
        List<String> generateMethodList = generateMethodList(str);
        if (generateMethodList != null) {
            LogUtil.d("LbAbilityNewWayUtils", "use remote methods");
            mSets.clear();
            mSets.addAll(generateMethodList);
            return;
        }
        generateLocalMethodList();
    }
}
