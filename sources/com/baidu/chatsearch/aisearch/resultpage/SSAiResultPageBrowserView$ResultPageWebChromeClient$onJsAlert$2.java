package com.baidu.chatsearch.aisearch.resultpage;

import com.baidu.webkit.sdk.JsResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiResultPageBrowserView.kt */
final class SSAiResultPageBrowserView$ResultPageWebChromeClient$onJsAlert$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsResult $jsResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SSAiResultPageBrowserView$ResultPageWebChromeClient$onJsAlert$2(JsResult jsResult) {
        super(0);
        this.$jsResult = jsResult;
    }

    public final void invoke() {
        JsResult jsResult = this.$jsResult;
        if (jsResult != null) {
            jsResult.confirm();
        }
    }
}
