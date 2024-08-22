package com.baidu.searchbox.lightbrowser.prerender.base;

import com.baidu.searchbox.lightbrowser.prerender.base.PreRenderWebView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/lightbrowser/prerender/base/PreRenderWebView$PreRenderLogContext;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreRenderWebView.kt */
final class PreRenderWebView$logContext$2 extends Lambda implements Function0<PreRenderWebView.PreRenderLogContext> {
    final /* synthetic */ PreRenderWebView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreRenderWebView$logContext$2(PreRenderWebView preRenderWebView) {
        super(0);
        this.this$0 = preRenderWebView;
    }

    public final PreRenderWebView.PreRenderLogContext invoke() {
        return new PreRenderWebView.PreRenderLogContext(this.this$0);
    }
}
