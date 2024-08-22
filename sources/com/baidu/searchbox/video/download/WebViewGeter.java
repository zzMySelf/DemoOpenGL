package com.baidu.searchbox.video.download;

import android.content.Context;
import android.util.Log;
import android.webkit.ConsoleMessage;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.browser.BrowserType;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.searchbox.ng.browser.init.BlinkInitHelper;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.video.detail.export.IVideoIdentityManager;
import com.baidu.searchbox.video.detail.utils.VideoUrlConfig;
import com.baidu.searchbox.video.runtime.VideoRuntime;
import org.apache.commons.codec.digest4util.MD5Utils;

public class WebViewGeter implements IVideoGetDownUrlGeter {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = VideoRuntime.DEBUG;
    private static final String TAG = "WebViewGeter";
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final VDownUrlGetInfo mDownloadInfo;

    public WebViewGeter(Context context, VDownUrlGetInfo info) {
        this.mContext = context;
        this.mDownloadInfo = info;
    }

    public void doGet() {
        initWebview();
    }

    private void initWebview() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                BlinkInitHelper.getInstance(WebViewGeter.this.mContext).initBWebkit();
                BdSailorWebView webView = new BdSailorWebView(WebViewGeter.this.mContext);
                webView.clearCache(true);
                BdSailorWebSettings settings = webView.getSettings();
                settings.setUserAgentString(BaiduIdentityManager.getInstance(WebViewGeter.this.mContext).processUserAgent(settings.getUserAgentString(), BrowserType.MAIN));
                settings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new BdSailorWebViewClient() {
                    public boolean shouldOverrideUrlLoading(BdSailorWebView view2, String url) {
                        view2.loadUrl(url);
                        return true;
                    }

                    public void onReceivedError(BdSailorWebView view2, int errorCode, String description, String failingUrl) {
                        if (WebViewGeter.this.mDownloadInfo.getListener() != null) {
                            WebViewGeter.this.mDownloadInfo.getListener().onUrlGet((String) null, 40000 + errorCode, VideoDownloadGMV.build(failingUrl, (String) null, (String) null, (String) null, (String) null, (String) null, 40000, Integer.valueOf(errorCode), "abcd12345xxiiiyy"));
                        }
                        super.onReceivedError(view2, errorCode, description, failingUrl);
                    }
                });
                webView.setWebChromeClient(new BdSailorWebChromeClient() {
                    public boolean onConsoleMessage(BdSailorWebView webview, ConsoleMessage consoleMessage) {
                        if (WebViewGeter.DEBUG) {
                            Log.d(WebViewGeter.TAG, consoleMessage.message());
                        }
                        return super.onConsoleMessage(webview, consoleMessage);
                    }
                });
                VGetDownUrlJSInterface jsInterface = new VGetDownUrlJSInterface(WebViewGeter.this.mContext);
                jsInterface.bindKernel(webView);
                if (WebViewGeter.this.mDownloadInfo != null) {
                    if (WebViewGeter.this.mDownloadInfo.getListener() != null) {
                        jsInterface.setDownloadListener(WebViewGeter.this.mDownloadInfo.getListener());
                    }
                    webView.resumeTimers();
                    webView.addJavascriptInterface(jsInterface, VGetDownUrlJSInterface.JAVASCRIPT_INTERFACE_NAME);
                    webView.loadUrl(IVideoIdentityManager.Impl.get().processUrl(VideoUrlConfig.getVideoGetUrl() + WebViewGeter.this.mDownloadInfo.getEpisodeId() + "&format=" + WebViewGeter.this.mDownloadInfo.getFormat() + "&sign=" + MD5Utils.toMd5((BaiduIdentityManager.getInstance(WebViewGeter.this.mContext).getEnUid() + WebViewGeter.this.mDownloadInfo.getToken() + WebViewGeter.this.mDownloadInfo.getEpisodeId() + WebViewGeter.this.mDownloadInfo.getFormat()).getBytes(), false)));
                    if (WebViewGeter.DEBUG) {
                        Log.d(WebViewGeter.TAG, "WebViewGeter loadUrl finish");
                    }
                }
            }
        });
    }
}
