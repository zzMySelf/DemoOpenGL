package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;

public class WebViewRenderProcessClientAdapter implements WebViewRendererClientBoundaryInterface {
    public static final String[] sSupportedFeatures = {"WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"};
    public final Executor mExecutor;
    public final WebViewRenderProcessClient mWebViewRenderProcessClient;

    @SuppressLint({"LambdaLast"})
    public WebViewRenderProcessClientAdapter(@Nullable Executor executor, @Nullable WebViewRenderProcessClient webViewRenderProcessClient) {
        this.mExecutor = executor;
        this.mWebViewRenderProcessClient = webViewRenderProcessClient;
    }

    @NonNull
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @Nullable
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }

    public final void onRendererResponsive(@NonNull final WebView webView, @NonNull InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl forInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
        Executor executor = this.mExecutor;
        if (executor == null) {
            webViewRenderProcessClient.onRenderProcessResponsive(webView, forInvocationHandler);
        } else {
            executor.execute(new Runnable() {
                public void run() {
                    webViewRenderProcessClient.onRenderProcessResponsive(webView, forInvocationHandler);
                }
            });
        }
    }

    public final void onRendererUnresponsive(@NonNull final WebView webView, @NonNull InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl forInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
        Executor executor = this.mExecutor;
        if (executor == null) {
            webViewRenderProcessClient.onRenderProcessUnresponsive(webView, forInvocationHandler);
        } else {
            executor.execute(new Runnable() {
                public void run() {
                    webViewRenderProcessClient.onRenderProcessUnresponsive(webView, forInvocationHandler);
                }
            });
        }
    }
}
