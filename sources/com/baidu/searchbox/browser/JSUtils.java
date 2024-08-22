package com.baidu.searchbox.browser;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ng.browser.explore.model.WebAddress;
import java.io.File;

public final class JSUtils {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "JSUtils";

    private JSUtils() {
    }

    public static boolean isBaiduDomain(Object webView) {
        String url;
        try {
            if (webView instanceof BdSailorWebView) {
                url = ((BdSailorWebView) webView).getUrl();
            } else if (!(webView instanceof WebView)) {
                return false;
            } else {
                url = ((WebView) webView).getUrl();
            }
            if (TextUtils.isEmpty(url)) {
                return false;
            }
            WebAddress address = new WebAddress(url);
            if (address.mHost.endsWith(".baidu.com") || address.mHost.endsWith("mbdcdn.bdstatic.com")) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean isBaiduLocalDomain(String url) {
        Uri uri;
        if (!TextUtils.isEmpty(url) && (uri = Uri.parse(url)) != null && TextUtils.equals("file", uri.getScheme())) {
            String localFilesPath = new File(AppRuntime.getAppContext().getFilesDir(), "template").getAbsolutePath();
            boolean z = DEBUG;
            if (z) {
                Log.e(TAG, "url: " + localFilesPath);
            }
            if (!TextUtils.isEmpty(uri.getPath()) && uri.getPath().startsWith(localFilesPath)) {
                if (!z) {
                    return true;
                }
                Log.d(TAG, "url match local files. ");
                return true;
            }
        }
        return false;
    }
}
