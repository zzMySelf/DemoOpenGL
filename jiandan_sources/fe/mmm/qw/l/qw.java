package fe.mmm.qw.l;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.TeraScanWebView;
import org.jetbrains.annotations.Nullable;

public final class qw extends WebChromeClient {
    public void onProgressChanged(@Nullable WebView webView, int i2) {
        BaseWebViewFragment webViewFragment;
        super.onProgressChanged(webView, i2);
        if ((webView instanceof TeraScanWebView) && (webViewFragment = ((TeraScanWebView) webView).getWebViewFragment()) != null) {
            TextView textLoading = webViewFragment.getTextLoading();
            if (textLoading != null) {
                fe.mmm.qw.th.qw.rg.fe.de.qw.qw(textLoading);
            }
            LottieAnimationView lottieAnimationView = webViewFragment.getLottieAnimationView();
            if (lottieAnimationView != null) {
                fe.mmm.qw.th.qw.rg.fe.de.qw.rg(lottieAnimationView, i2 != 100);
            }
        }
    }
}
