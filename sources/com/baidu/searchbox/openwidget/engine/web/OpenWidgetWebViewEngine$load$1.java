package com.baidu.searchbox.openwidget.engine.web;

import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.openwidget.model.OpenWidgetExtsKt;
import com.baidu.searchbox.openwidget.model.OpenWidgetInstance;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetWebViewEngine.kt */
final class OpenWidgetWebViewEngine$load$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NgWebView $webView;
    final /* synthetic */ OpenWidgetInstance $widget;
    final /* synthetic */ OpenWidgetWebViewEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OpenWidgetWebViewEngine$load$1(OpenWidgetWebViewEngine openWidgetWebViewEngine, NgWebView ngWebView, OpenWidgetInstance openWidgetInstance) {
        super(0);
        this.this$0 = openWidgetWebViewEngine;
        this.$webView = ngWebView;
        this.$widget = openWidgetInstance;
    }

    public final void invoke() {
        this.this$0.tracer.traceEvent(WebViewEngineTraceEventsKt.EV_LOAD_URL);
        this.$webView.loadUrl(OpenWidgetExtsKt.getRenderPageUrl(this.$widget));
    }
}
