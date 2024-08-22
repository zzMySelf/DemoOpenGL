package fe.mmm.qw.m;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.TeraScanWebView;

public class th extends WebChromeClient {
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        BaseWebViewFragment webViewFragment = ((TeraScanWebView) webView).getWebViewFragment();
        if (webViewFragment != null) {
            if (webViewFragment.getProgressBar().getVisibility() != 0) {
                webViewFragment.getProgressBar().setVisibility(0);
            }
            if (webViewFragment.getTextLoading().getVisibility() != 8) {
                webViewFragment.getTextLoading().setVisibility(8);
            }
            webViewFragment.getProgressBar().setProgress(i2);
        }
    }
}
