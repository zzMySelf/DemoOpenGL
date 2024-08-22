package com.baidu.searchbox.schemeauthenticate;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import java.io.File;
import java.util.List;

public abstract class BaseSchemeCheckerHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_CHECK_URL_ENABLE = "check_url_en";
    public static final String KEY_DEBUG_RN_SP = "debug_rn_sp";
    private static final String TAG = "SchemeCheckerHelper";
    public static int URL_PRE_CHECK_RES_LOCAL = 3;
    public static final int URL_PRE_CHECK_RES_WHITE = 0;
    public static final int URL_RPE_CHECK_RES_BLACK = 1;
    public static final int URL_RPE_CHECK_RES_QUERY_HOST = 2;
    private static volatile BaseSchemeCheckerHelper sInstance;

    public abstract int checkSpecialScheme(String str, String str2);

    public abstract boolean enableDefaultCheckUrl();

    public abstract List<String> getFrameWhiteList();

    public abstract List<String> getInternalWhiteHost();

    public abstract boolean httpSecureCheck(String str);

    public abstract void httpSecureStatistic(String str, String str2);

    @Deprecated
    public boolean isInFrameWhileList(String frameName) {
        for (String frame : getFrameWhiteList()) {
            if (TextUtils.equals(frame, frameName)) {
                return true;
            }
        }
        return false;
    }

    public int preCheckUrl(String url) {
        return preCheckUrl(url, (String) null);
    }

    public int preCheckUrl(String url, String schemeCmd) {
        return preCheckUrl(url, schemeCmd, (String) null);
    }

    public int preCheckUrl(String url, String schemeCmd, String frameName) {
        if (DEBUG && !isCheckUrl()) {
            return 0;
        }
        if (!TextUtils.isEmpty(frameName)) {
            for (String frame : getFrameWhiteList()) {
                if (TextUtils.equals(frame, frameName)) {
                    return 0;
                }
            }
        }
        if (isPublicPath(schemeCmd)) {
            return 0;
        }
        if (TextUtils.isEmpty(url)) {
            return 1;
        }
        Uri uri = Uri.parse(url);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return 1;
        }
        boolean validScheme = false;
        String[] schemes = {"http", "https", "file"};
        int length = schemes.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (schemes[i2].equalsIgnoreCase(scheme)) {
                validScheme = true;
                break;
            } else {
                i2++;
            }
        }
        if (!validScheme) {
            return 1;
        }
        if (TextUtils.equals("file", scheme)) {
            if (!TextUtils.isEmpty(uri.getPath())) {
                try {
                    if (!new File(uri.getPath()).getCanonicalPath().startsWith(new File(AppRuntime.getAppContext().getFilesDir(), "template").getCanonicalPath())) {
                        return URL_PRE_CHECK_RES_LOCAL;
                    }
                    if (DEBUG) {
                        Log.d(TAG, "url match local files. ");
                    }
                    return 0;
                } catch (Exception e2) {
                }
            }
            return 1;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return 1;
        }
        for (String whiteHost : getInternalWhiteHost()) {
            if (TextUtils.equals(whiteHost, host)) {
                if (DEBUG) {
                    Log.d(TAG, "host match baidu origin. ");
                }
                if (httpSecureCheck(url)) {
                    return 0;
                }
                httpSecureStatistic(url, schemeCmd);
            } else if (!host.endsWith("." + whiteHost)) {
                continue;
            } else {
                if (DEBUG) {
                    Log.d(TAG, "host match baidu origin. ");
                }
                if (httpSecureCheck(url)) {
                    return 0;
                }
                httpSecureStatistic(url, schemeCmd);
            }
        }
        return checkSpecialScheme(url, schemeCmd);
    }

    private boolean isPublicPath(String schemeCmd) {
        List<String> segments;
        Uri uri = null;
        try {
            uri = Uri.parse(schemeCmd);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "isPublicPath e:" + e2);
            }
        }
        if (uri != null && (segments = uri.getPathSegments()) != null && segments.size() > 0 && TextUtils.equals(UnitedSchemePublicDispatcher.MODULE_NAME, ((String[]) segments.toArray(new String[0]))[0])) {
            return true;
        }
        return false;
    }

    private boolean isCheckUrl() {
        return DebugRNPreferenceUtils.getInstance().getBoolean("check_url_en", enableDefaultCheckUrl());
    }
}
