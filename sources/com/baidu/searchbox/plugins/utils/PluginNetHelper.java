package com.baidu.searchbox.plugins.utils;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import java.util.List;
import java.util.regex.Pattern;

public final class PluginNetHelper {
    private static final boolean DEBUG = (AppConfig.isDebug() & true);
    public static final String PLUGIN_VALUE_RE_PRE = "re:";

    private PluginNetHelper() {
    }

    public static boolean isValueMatch(String value, List<String> matcherList) {
        if (TextUtils.isEmpty(value) || matcherList == null) {
            return false;
        }
        for (String matcher : matcherList) {
            if (isValueMatch(value, matcher)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValueMatch(String value, String matcher) {
        String iMatcher;
        if (TextUtils.isEmpty(value) || TextUtils.isEmpty(matcher)) {
            return false;
        }
        if (matcher.startsWith("re:")) {
            try {
                iMatcher = matcher.substring("re:".length());
            } catch (IndexOutOfBoundsException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                iMatcher = null;
            }
            if (TextUtils.isEmpty(iMatcher) || !Pattern.compile(iMatcher).matcher(value).matches()) {
                return false;
            }
            return true;
        } else if (TextUtils.equals(value, matcher)) {
            return true;
        }
        return false;
    }
}
