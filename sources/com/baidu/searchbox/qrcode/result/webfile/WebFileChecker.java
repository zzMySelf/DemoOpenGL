package com.baidu.searchbox.qrcode.result.webfile;

import android.content.Context;

public final class WebFileChecker {
    private WebFileChecker() {
    }

    public static boolean checkWebFile(Context context, String url) {
        if (FileSuffixParser.parserUrl(context, url).getType() != -1) {
            return true;
        }
        return false;
    }
}
