package com.baidu.searchbox.openwidget;

import com.baidu.searchbox.openwidget.utils.OpenWidgetProcess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/openwidget/OpenWidgetRenderServiceCallback;", "", "onServiceCreateCalled", "", "service", "Lcom/baidu/searchbox/openwidget/OpenWidgetRenderService;", "onServiceDestroyCalled", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@OpenWidgetProcess
/* compiled from: OpenWidgetRenderServiceCallback.kt */
public interface OpenWidgetRenderServiceCallback {
    void onServiceCreateCalled(OpenWidgetRenderService openWidgetRenderService);

    void onServiceDestroyCalled(OpenWidgetRenderService openWidgetRenderService);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetRenderServiceCallback.kt */
    public static final class DefaultImpls {
        public static void onServiceCreateCalled(OpenWidgetRenderServiceCallback openWidgetRenderServiceCallback, OpenWidgetRenderService service) {
            Intrinsics.checkNotNullParameter(service, "service");
        }

        public static void onServiceDestroyCalled(OpenWidgetRenderServiceCallback openWidgetRenderServiceCallback, OpenWidgetRenderService service) {
            Intrinsics.checkNotNullParameter(service, "service");
        }
    }
}
