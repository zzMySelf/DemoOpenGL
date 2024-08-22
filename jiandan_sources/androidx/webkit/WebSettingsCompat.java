package androidx.webkit;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class WebSettingsCompat {
    public static final int DARK_STRATEGY_PREFER_WEB_THEME_OVER_USER_AGENT_DARKENING = 2;
    public static final int DARK_STRATEGY_USER_AGENT_DARKENING_ONLY = 0;
    public static final int DARK_STRATEGY_WEB_THEME_DARKENING_ONLY = 1;
    public static final int FORCE_DARK_AUTO = 1;
    public static final int FORCE_DARK_OFF = 0;
    public static final int FORCE_DARK_ON = 2;

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDark {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDarkStrategy {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuItemFlags {
    }

    public static WebSettingsAdapter getAdapter(WebSettings webSettings) {
        return WebViewGlueCommunicator.getCompatConverter().convertSettings(webSettings);
    }

    @SuppressLint({"NewApi"})
    public static int getDisabledActionModeMenuItems(@NonNull WebSettings webSettings) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.DISABLED_ACTION_MODE_MENU_ITEMS;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return webSettings.getDisabledActionModeMenuItems();
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getAdapter(webSettings).getDisabledActionModeMenuItems();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static int getForceDark(@NonNull WebSettings webSettings) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.FORCE_DARK;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return webSettings.getForceDark();
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getAdapter(webSettings).getForceDark();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static int getForceDarkStrategy(@NonNull WebSettings webSettings) {
        if (WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView()) {
            return getAdapter(webSettings).getForceDark();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static boolean getOffscreenPreRaster(@NonNull WebSettings webSettings) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.OFF_SCREEN_PRERASTER;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return webSettings.getOffscreenPreRaster();
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getAdapter(webSettings).getOffscreenPreRaster();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static boolean getSafeBrowsingEnabled(@NonNull WebSettings webSettings) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SAFE_BROWSING_ENABLE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return webSettings.getSafeBrowsingEnabled();
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getAdapter(webSettings).getSafeBrowsingEnabled();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static void setDisabledActionModeMenuItems(@NonNull WebSettings webSettings, int i2) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.DISABLED_ACTION_MODE_MENU_ITEMS;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            webSettings.setDisabledActionModeMenuItems(i2);
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getAdapter(webSettings).setDisabledActionModeMenuItems(i2);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static void setForceDark(@NonNull WebSettings webSettings, int i2) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.FORCE_DARK;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            webSettings.setForceDark(i2);
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getAdapter(webSettings).setForceDark(i2);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static void setForceDarkStrategy(@NonNull WebSettings webSettings, int i2) {
        if (WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView()) {
            getAdapter(webSettings).setForceDarkStrategy(i2);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    public static void setOffscreenPreRaster(@NonNull WebSettings webSettings, boolean z) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.OFF_SCREEN_PRERASTER;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            webSettings.setOffscreenPreRaster(z);
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getAdapter(webSettings).setOffscreenPreRaster(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    public static void setSafeBrowsingEnabled(@NonNull WebSettings webSettings, boolean z) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SAFE_BROWSING_ENABLE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            webSettings.setSafeBrowsingEnabled(z);
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getAdapter(webSettings).setSafeBrowsingEnabled(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setWillSuppressErrorPage(@NonNull WebSettings webSettings, boolean z) {
        if (WebViewFeatureInternal.SUPPRESS_ERROR_PAGE.isSupportedByWebView()) {
            getAdapter(webSettings).setWillSuppressErrorPage(z);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean willSuppressErrorPage(@NonNull WebSettings webSettings) {
        if (WebViewFeatureInternal.SUPPRESS_ERROR_PAGE.isSupportedByWebView()) {
            return getAdapter(webSettings).willSuppressErrorPage();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
