package com.sdk.base.api;

import android.content.Context;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.sdk.o.a;
import com.sdk.q.b;
import com.sdk.r.d;

public class ToolUtils {
    public static String Base64_Decrypt(String str) {
        return d.a(str);
    }

    public static String RsaDecrypt(String str, String str2) {
        return b.a(str, str2);
    }

    public static void clearCache(Context context) {
        a.b(com.sdk.b.a.a, "cache clear", com.sdk.b.a.b);
        com.sdk.k.a.a(context, YYInnerSSOLoginActivity.s);
    }

    public static String getAppMd5(Context context) {
        return com.sdk.j.a.b(context);
    }
}
