package com.baidu.swan.apps.impl.utils;

import android.text.TextUtils;

public final class SwanImplUtils {
    private SwanImplUtils() {
    }

    public static String getPluginPackageName(String mimeType) {
        if (TextUtils.isEmpty(mimeType)) {
            return null;
        }
        if (TextUtils.equals("application/pdf", mimeType)) {
            return "com.baidu.browser.pdfviewer";
        }
        if (TextUtils.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document", mimeType) || TextUtils.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", mimeType) || TextUtils.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation", mimeType) || TextUtils.equals("application/msword", mimeType) || TextUtils.equals("application/vnd.ms-excel", mimeType) || TextUtils.equals("application/vnd.ms-powerpoint", mimeType)) {
            return "com.baidu.browser.officereader";
        }
        return null;
    }
}
