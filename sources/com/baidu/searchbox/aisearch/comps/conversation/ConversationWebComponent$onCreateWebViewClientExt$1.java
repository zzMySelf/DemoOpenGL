package com.baidu.searchbox.aisearch.comps.conversation;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.aisearch.runtime.IAISearchSpeedStat;
import com.baidu.searchbox.aisearch.yalog.AISearchYalog;
import com.baidu.webkit.sdk.FirstScreenImageInfomation;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0011\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006\u0017"}, d2 = {"com/baidu/searchbox/aisearch/comps/conversation/ConversationWebComponent$onCreateWebViewClientExt$1", "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt;", "onFirstContentfulPaintExt", "", "webView", "Lcom/baidu/browser/sailor/BdSailorWebView;", "url", "", "onFirstLayoutDidExt", "onFirstScreenImagePaintFinished", "info", "Lcom/baidu/webkit/sdk/FirstScreenImageInfomation;", "onFirstScreenLayoutExt", "onFirstScreenPaintFinishedExt", "firstScreenInfo", "Lcom/baidu/browser/sailor/BdSailorWebViewClientExt$FirstScreenInfo;", "onFirstTextPaintExt", "onReceivedSslErrorExt", "", "sslErrorHandler", "Landroid/webkit/SslErrorHandler;", "sslError", "Landroid/net/http/SslError;", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationWebComponent.kt */
public final class ConversationWebComponent$onCreateWebViewClientExt$1 extends BdSailorWebViewClientExt {
    final /* synthetic */ ConversationWebComponent this$0;

    ConversationWebComponent$onCreateWebViewClientExt$1(ConversationWebComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onFirstScreenPaintFinishedExt(BdSailorWebView webView, String url, BdSailorWebViewClientExt.FirstScreenInfo firstScreenInfo) {
        super.onFirstScreenPaintFinishedExt(webView, url, firstScreenInfo);
        IAISearchSpeedStat.Companion.getImpl().updateStatistic(this.this$0.speedStatPage, "firstPaint");
        AISearchYalog.INSTANCE.i("ConversationComp", "channelId=" + this.this$0.getActionId() + ", onFirstScreenPaintFinishedExt");
    }

    public void onFirstScreenImagePaintFinished(BdSailorWebView webView, FirstScreenImageInfomation info) {
        super.onFirstScreenImagePaintFinished(webView, info);
        IAISearchSpeedStat.Companion.getImpl().updateStatistic(this.this$0.speedStatPage, "imagePaint");
        AISearchYalog.INSTANCE.i("ConversationComp", "channelId=" + this.this$0.getActionId() + ", onFirstScreenImagePaintFinished");
    }

    public void onFirstLayoutDidExt(BdSailorWebView webView, String url) {
        super.onFirstLayoutDidExt(webView, url);
        AISearchYalog.INSTANCE.i("ConversationComp", "channelId=" + this.this$0.getActionId() + ", onFirstLayoutDidExt");
    }

    public void onFirstContentfulPaintExt(BdSailorWebView webView, String url) {
        super.onFirstContentfulPaintExt(webView, url);
        AISearchYalog.INSTANCE.i("ConversationComp", "channelId=" + this.this$0.getActionId() + ", onFirstContentfulPaintExt");
    }

    public void onFirstTextPaintExt(BdSailorWebView webView, String url) {
        super.onFirstTextPaintExt(webView, url);
        AISearchYalog.INSTANCE.i("ConversationComp", "channelId=" + this.this$0.getActionId() + ", onFirstTextPaintExt");
    }

    public void onFirstScreenLayoutExt(BdSailorWebView webView, String url) {
        super.onFirstScreenLayoutExt(webView, url);
        AISearchYalog.INSTANCE.i("ConversationComp", "channelId=" + this.this$0.getActionId() + ", onFirstScreenLayoutExt");
    }

    public boolean onReceivedSslErrorExt(BdSailorWebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        AISearchYalog.INSTANCE.i("ConversationComp", "channelId=" + this.this$0.getActionId() + ", onReceivedSslErrorExt, sslError=" + sslError);
        return super.onReceivedSslErrorExt(webView, sslErrorHandler, sslError);
    }
}
