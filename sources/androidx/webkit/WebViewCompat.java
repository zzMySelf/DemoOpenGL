package androidx.webkit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.WebMessagePortImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import androidx.webkit.internal.WebViewProviderAdapter;
import androidx.webkit.internal.WebViewProviderFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

public class WebViewCompat {
    private static final Uri EMPTY_URI = Uri.parse("");
    private static final Uri WILDCARD_URI = Uri.parse("*");

    public interface VisualStateCallback {
        void onComplete(long j2);
    }

    private WebViewCompat() {
    }

    public static void postVisualStateCallback(WebView webview, long requestId, final VisualStateCallback callback) {
        WebViewFeatureInternal webViewFeature = WebViewFeatureInternal.getFeature("VISUAL_STATE_CALLBACK");
        if (webViewFeature.isSupportedByFramework()) {
            webview.postVisualStateCallback(requestId, new WebView.VisualStateCallback() {
                public void onComplete(long l) {
                    callback.onComplete(l);
                }
            });
        } else if (webViewFeature.isSupportedByWebView()) {
            checkThread(webview);
            getProvider(webview).insertVisualStateCallback(requestId, callback);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static void startSafeBrowsing(Context context, ValueCallback<Boolean> callback) {
        WebViewFeatureInternal webviewFeature = WebViewFeatureInternal.getFeature("START_SAFE_BROWSING");
        if (webviewFeature.isSupportedByFramework()) {
            WebView.startSafeBrowsing(context, callback);
        } else if (webviewFeature.isSupportedByWebView()) {
            getFactory().getStatics().initSafeBrowsing(context, callback);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static void setSafeBrowsingWhitelist(List<String> hosts, ValueCallback<Boolean> callback) {
        WebViewFeatureInternal webviewFeature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_WHITELIST");
        if (webviewFeature.isSupportedByFramework()) {
            WebView.setSafeBrowsingWhitelist(hosts, callback);
        } else if (webviewFeature.isSupportedByWebView()) {
            getFactory().getStatics().setSafeBrowsingWhitelist(hosts, callback);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static Uri getSafeBrowsingPrivacyPolicyUrl() {
        WebViewFeatureInternal webviewFeature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_PRIVACY_POLICY_URL");
        if (webviewFeature.isSupportedByFramework()) {
            return WebView.getSafeBrowsingPrivacyPolicyUrl();
        }
        if (webviewFeature.isSupportedByWebView()) {
            return getFactory().getStatics().getSafeBrowsingPrivacyPolicyUrl();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static PackageInfo getCurrentWebViewPackage(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return WebView.getCurrentWebViewPackage();
        }
        try {
            PackageInfo loadedWebViewPackageInfo = getLoadedWebViewPackageInfo();
            if (loadedWebViewPackageInfo != null) {
                return loadedWebViewPackageInfo;
            }
            return getNotYetLoadedWebViewPackageInfo(context);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            return null;
        }
    }

    private static PackageInfo getLoadedWebViewPackageInfo() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke((Object) null, new Object[0]);
    }

    private static PackageInfo getNotYetLoadedWebViewPackageInfo(Context context) {
        String webviewPackageName;
        try {
            if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 23) {
                webviewPackageName = (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", new Class[0]).invoke((Object) null, new Object[0]);
            } else {
                webviewPackageName = (String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", new Class[0]).invoke((Object) null, new Object[0]);
            }
            if (webviewPackageName == null) {
                return null;
            }
            try {
                return context.getPackageManager().getPackageInfo(webviewPackageName, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                return null;
            }
        } catch (ClassNotFoundException e3) {
            return null;
        } catch (IllegalAccessException e4) {
            return null;
        } catch (InvocationTargetException e5) {
            return null;
        } catch (NoSuchMethodException e6) {
            return null;
        }
    }

    private static WebViewProviderAdapter getProvider(WebView webview) {
        return new WebViewProviderAdapter(createProvider(webview));
    }

    public static WebMessagePortCompat[] createWebMessageChannel(WebView webview) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("CREATE_WEB_MESSAGE_CHANNEL");
        if (feature.isSupportedByFramework()) {
            return WebMessagePortImpl.portsToCompat(webview.createWebMessageChannel());
        }
        if (feature.isSupportedByWebView()) {
            return getProvider(webview).createWebMessageChannel();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void postWebMessage(WebView webview, WebMessageCompat message, Uri targetOrigin) {
        if (WILDCARD_URI.equals(targetOrigin)) {
            targetOrigin = EMPTY_URI;
        }
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("POST_WEB_MESSAGE");
        if (feature.isSupportedByFramework()) {
            webview.postWebMessage(WebMessagePortImpl.compatToFrameworkMessage(message), targetOrigin);
        } else if (feature.isSupportedByWebView()) {
            getProvider(webview).postWebMessage(message, targetOrigin);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static WebViewClient getWebViewClient(WebView webview) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("GET_WEB_VIEW_CLIENT");
        if (feature.isSupportedByFramework()) {
            return webview.getWebViewClient();
        }
        if (feature.isSupportedByWebView()) {
            return getProvider(webview).getWebViewClient();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static WebChromeClient getWebChromeClient(WebView webview) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("GET_WEB_CHROME_CLIENT");
        if (feature.isSupportedByFramework()) {
            return webview.getWebChromeClient();
        }
        if (feature.isSupportedByWebView()) {
            return getProvider(webview).getWebChromeClient();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static WebViewRenderProcess getWebViewRenderProcess(WebView webview) {
        if (WebViewFeatureInternal.getFeature("GET_WEB_VIEW_RENDERER").isSupportedByWebView()) {
            return getProvider(webview).getWebViewRenderProcess();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setWebViewRenderProcessClient(WebView webview, Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        if (WebViewFeatureInternal.getFeature("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE").isSupportedByWebView()) {
            getProvider(webview).setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setWebViewRenderProcessClient(WebView webview, WebViewRenderProcessClient webViewRenderProcessClient) {
        if (WebViewFeatureInternal.getFeature("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE").isSupportedByWebView()) {
            getProvider(webview).setWebViewRenderProcessClient((Executor) null, webViewRenderProcessClient);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static WebViewRenderProcessClient getWebViewRenderProcessClient(WebView webview) {
        if (WebViewFeatureInternal.getFeature("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE").isSupportedByWebView()) {
            return getProvider(webview).getWebViewRenderProcessClient();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean isMultiProcessEnabled() {
        if (WebViewFeatureInternal.getFeature("MULTI_PROCESS_QUERY").isSupportedByWebView()) {
            return getFactory().getStatics().isMultiProcessEnabled();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private static WebViewProviderFactory getFactory() {
        return WebViewGlueCommunicator.getFactory();
    }

    private static WebViewProviderBoundaryInterface createProvider(WebView webview) {
        return getFactory().createWebView(webview);
    }

    private static void checkThread(WebView webview) {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                Method checkThreadMethod = WebView.class.getDeclaredMethod("checkThread", new Class[0]);
                checkThreadMethod.setAccessible(true);
                checkThreadMethod.invoke(webview, new Object[0]);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        } else if (webview.getWebViewLooper() != Looper.myLooper()) {
            throw new RuntimeException("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + webview.getWebViewLooper() + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + ")");
        }
    }
}
