package com.dxmpay.wallet.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.apollon.utils.BussinessUtils;

public class UAFilterUtil {

    public static class ad {
        public static UAFilterUtil qw = new UAFilterUtil();
    }

    public static UAFilterUtil getInstance() {
        return ad.qw;
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
