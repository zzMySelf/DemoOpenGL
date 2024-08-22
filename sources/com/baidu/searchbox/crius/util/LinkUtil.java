package com.baidu.searchbox.crius.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class LinkUtil {
    public static boolean dealLink(Context context, String href) {
        if (context == null || TextUtils.isEmpty(href)) {
            return false;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(href)));
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }
}
