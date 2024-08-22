package com.baidu.searchbox.qrcode.utils;

import com.baidu.searchbox.gamecore.util.GameCenterUtils;

public final class BdUtil {
    private BdUtil() {
    }

    public static String getQueryParameter(String url, String key) {
        String encodedKey = key;
        int length = url.length();
        int start = url.indexOf(GameCenterUtils.SCHEME_SWAN_SUFFIX) + 1;
        while (true) {
            int nextAmpersand = url.indexOf(38, start);
            int end = nextAmpersand != -1 ? nextAmpersand : length;
            int separator = url.indexOf(61, start);
            if (separator > end || separator == -1) {
                separator = end;
            }
            if (separator - start != encodedKey.length() || !url.regionMatches(start, encodedKey, 0, encodedKey.length())) {
                if (nextAmpersand == -1) {
                    return null;
                }
                start = nextAmpersand + 1;
            } else if (separator == end) {
                return "";
            } else {
                return url.substring(separator + 1, end);
            }
        }
    }
}
