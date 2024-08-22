package com.baidu.searchbox.lightbrowser.prerender.processor;

import com.baidu.android.util.time.CountDownTimer;
import com.baidu.searchbox.lightbrowser.prerender.base.PreRenderWebView;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/lightbrowser/prerender/processor/AdPreRenderProcessor$initResourceCleaner$1", "Lcom/baidu/android/util/time/CountDownTimer$StatusListener;", "onFinish", "", "lib-lightbrowser-prerender_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdPreRenderProcessor.kt */
public final class AdPreRenderProcessor$initResourceCleaner$1 extends CountDownTimer.StatusListener {
    final /* synthetic */ AdPreRenderProcessor this$0;

    AdPreRenderProcessor$initResourceCleaner$1(AdPreRenderProcessor $receiver) {
        this.this$0 = $receiver;
    }

    public void onFinish() {
        Iterator it = this.this$0.getWebViewPool().iterator();
        while (it.hasNext()) {
            PreRenderWebView webView = (PreRenderWebView) it.next();
            if (!webView.isInUse()) {
                this.this$0.handleClearResource(webView);
            }
        }
    }
}
