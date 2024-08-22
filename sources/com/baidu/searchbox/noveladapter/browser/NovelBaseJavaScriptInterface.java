package com.baidu.searchbox.noveladapter.browser;

import android.content.Context;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.baidu.searchbox.lightbrowser.jsbridge.BaseJavaScriptInterface;
import com.baidu.searchbox.noveladapter.browser.webcore.warpper.NovelBdSailorWebViewWarpper;
import com.baidu.swan.game.ad.jsbridge.BaseHtmlBridgeHandler;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public abstract class NovelBaseJavaScriptInterface extends BaseJavaScriptInterface implements NoProGuard {
    public NovelBaseJavaScriptInterface(Context context) {
        super(context);
    }

    public NovelBaseJavaScriptInterface(Context context, NovelBdSailorWebViewWarpper bdSailorWebView) {
        this(context);
        if (bdSailorWebView != null) {
            bindKernel(bdSailorWebView.getBdSailorWebView());
        }
    }

    public void setContext(Context context) {
        if (context != null) {
            setContextRef(new WeakReference(context));
        }
    }

    public Context getNovelContext() {
        return getContext();
    }

    public void setWebView(NovelBdSailorWebViewWarpper webViewWarpper) {
        super.setWebView(webViewWarpper == null ? null : webViewWarpper.getBdSailorWebView());
    }

    public NovelBdSailorWebViewWarpper getWebViewWrapper() {
        return new NovelBdSailorWebViewWarpper(getWebView());
    }

    public Object getNovelLogContext() {
        return getLogContext();
    }

    /* access modifiers changed from: protected */
    public void askToExecuteJavaScript(JSONObject jsonObject, String callBack) {
        super.executeJavaScript(callBack, jsonObject);
    }

    /* access modifiers changed from: protected */
    public void loadNovelJavaScript(String js) {
        super.loadJavaScript(js);
    }

    /* access modifiers changed from: protected */
    public void postLoadJavaScript(final String callBack, final String info) {
        if (getWebView() != null) {
            getWebView().post(new Runnable() {
                public void run() {
                    NovelBaseJavaScriptInterface.this.loadJavaScript(BaseHtmlBridgeHandler.JAVASCRIPT_PREFIX + callBack + FileViewerActivity.LEFT_BRACKET + info + ");");
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void postFireJavascriptMethod(String method, String info) {
        super.executeFireJavascript(method, info);
    }
}
