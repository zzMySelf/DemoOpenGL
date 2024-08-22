package com.baidu.wallet.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.BussinessUtils;

public class UAFilterUtil {

    public static class a {
        public static UAFilterUtil a = new UAFilterUtil();
    }

    public static UAFilterUtil getInstance() {
        return a.a;
    }

    public synchronized String getTrueUA(Context context) {
        String ua = BussinessUtils.getUA(context);
        if (TextUtils.isEmpty(ua)) {
            return "";
        }
        return ua;
    }

    public UAFilterUtil() {
    }
}
