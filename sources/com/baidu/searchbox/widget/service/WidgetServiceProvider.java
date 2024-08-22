package com.baidu.searchbox.widget.service;

import com.baidu.pyramid.annotation.ServiceProvider;
import com.baidu.pyramid.runtime.service.CachedServiceFetcher;
import com.baidu.searchbox.widget.IWidgetService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/widget/service/WidgetServiceProvider;", "Lcom/baidu/pyramid/runtime/service/CachedServiceFetcher;", "Lcom/baidu/searchbox/widget/IWidgetService;", "()V", "createService", "Lcom/baidu/searchbox/widget/service/WidgetService;", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ServiceProvider(module = "widget", name = "lib_widget_interface")
/* compiled from: WidgetServiceProvider.kt */
public final class WidgetServiceProvider extends CachedServiceFetcher<IWidgetService> {
    /* access modifiers changed from: protected */
    public WidgetService createService() {
        return new WidgetService();
    }
}
