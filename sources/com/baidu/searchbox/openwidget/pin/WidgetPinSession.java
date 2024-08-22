package com.baidu.searchbox.openwidget.pin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/openwidget/pin/WidgetPinSession;", "", "request", "Lcom/baidu/searchbox/openwidget/pin/WidgetPinRequest;", "response", "Lcom/baidu/searchbox/openwidget/pin/WidgetPinResponse;", "callback", "Lcom/baidu/searchbox/openwidget/pin/WidgetPinCallback;", "(Lcom/baidu/searchbox/openwidget/pin/WidgetPinRequest;Lcom/baidu/searchbox/openwidget/pin/WidgetPinResponse;Lcom/baidu/searchbox/openwidget/pin/WidgetPinCallback;)V", "getCallback", "()Lcom/baidu/searchbox/openwidget/pin/WidgetPinCallback;", "getRequest", "()Lcom/baidu/searchbox/openwidget/pin/WidgetPinRequest;", "getResponse", "()Lcom/baidu/searchbox/openwidget/pin/WidgetPinResponse;", "lib-openwidget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetPinSession.kt */
public final class WidgetPinSession {
    private final WidgetPinCallback callback;
    private final WidgetPinRequest request;
    private final WidgetPinResponse response;

    public WidgetPinSession(WidgetPinRequest request2, WidgetPinResponse response2, WidgetPinCallback callback2) {
        Intrinsics.checkNotNullParameter(request2, "request");
        Intrinsics.checkNotNullParameter(response2, "response");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.request = request2;
        this.response = response2;
        this.callback = callback2;
    }

    public final WidgetPinRequest getRequest() {
        return this.request;
    }

    public final WidgetPinResponse getResponse() {
        return this.response;
    }

    public final WidgetPinCallback getCallback() {
        return this.callback;
    }
}
