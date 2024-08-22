package fe.mmm.qw.m.ggg.qw;

import android.webkit.WebView;
import com.tera.scan.framework.ui.view.IBaseView;
import com.tera.scan.webview.hybrid.action.IWebViewListener;
import fe.mmm.qw.m.ggg.ad.de;
import fe.mmm.qw.m.ggg.ad.fe;
import fe.mmm.qw.m.ggg.ad.rg;
import fe.mmm.qw.m.ggg.fe.ad;
import org.json.JSONObject;

public abstract class qw {
    public static final String TAG = "HybridAction";
    public final IBaseView mBaseView;
    public ad mHybridParam;
    public IWebViewListener mWebViewListener;

    public qw(IBaseView iBaseView) {
        this.mBaseView = iBaseView;
        if (iBaseView.getActivity() instanceof IWebViewListener) {
            this.mWebViewListener = (IWebViewListener) this.mBaseView.getActivity();
            return;
        }
        IBaseView iBaseView2 = this.mBaseView;
        if (iBaseView2 instanceof IWebViewListener) {
            this.mWebViewListener = (IWebViewListener) iBaseView2;
        }
    }

    private WebView getPageWebView() {
        IWebViewListener iWebViewListener = this.mWebViewListener;
        WebView webView = iWebViewListener != null ? iWebViewListener.getWebView() : null;
        if (webView != null) {
            return webView;
        }
        IBaseView iBaseView = this.mBaseView;
        return iBaseView instanceof IWebViewListener ? ((IWebViewListener) iBaseView).getWebView() : webView;
    }

    public void callH5Function(String str, int i2, String str2, JSONObject jSONObject) {
        if (!isDestroy() && getPageWebView() != null) {
            fe.qw(getPageWebView(), new fe.mmm.qw.m.ggg.ad.ad(str, i2, str2, jSONObject));
        }
    }

    public void handleHybridCallback(ad adVar, int i2, String str, JSONObject jSONObject) {
        if (!isDestroy() && getPageWebView() != null) {
            fe.qw(getPageWebView(), new fe.mmm.qw.m.ggg.ad.qw(adVar.f8045ad, i2, str, jSONObject));
        }
    }

    public void handleNewHybridCallback(String str, int i2, String str2, JSONObject jSONObject) {
        if (!isDestroy() && getPageWebView() != null) {
            fe.qw(getPageWebView(), new de(str, i2, str2, jSONObject));
        }
    }

    public void handleRecognizeSchemeError(ad adVar) {
        if (!isDestroy() && getPageWebView() != null) {
            fe.qw(getPageWebView(), new rg("handleError", adVar.f8045ad, adVar.qw.qw, adVar.f8046de));
        }
    }

    public boolean isDestroy() {
        IBaseView iBaseView = this.mBaseView;
        return iBaseView == null || iBaseView.getActivity() == null || this.mBaseView.getActivity().isFinishing();
    }

    public abstract void onAction(ad adVar);
}
