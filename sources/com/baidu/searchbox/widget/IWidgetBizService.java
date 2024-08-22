package com.baidu.searchbox.widget;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.pyramid.annotation.nps.PluginAccessible;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.widget.pin.WidgetPinData;
import com.baidu.searchbox.widget.pin.openwidget.OpenWidgetPinData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fJ0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/widget/IWidgetBizService;", "", "addVideoWidget", "", "activity", "Landroid/app/Activity;", "videoChannel", "", "widgetPinData", "Lcom/baidu/searchbox/widget/pin/WidgetPinData;", "openWidgetPinData", "Lcom/baidu/searchbox/widget/pin/openwidget/OpenWidgetPinData;", "widgetAddCallback", "Lcom/baidu/searchbox/widget/IWidgetBizService$IWidgetAddBizCallback;", "Companion", "IWidgetAddBizCallback", "lib_widget_interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWidgetBizService.kt */
public interface IWidgetBizService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @StableApi
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/widget/IWidgetBizService$IWidgetAddBizCallback;", "", "onPinFail", "", "errorCode", "", "onPinStart", "onPinSuccess", "response", "Landroid/os/Bundle;", "lib_widget_interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IWidgetBizService.kt */
    public interface IWidgetAddBizCallback {
        void onPinFail(int i2);

        void onPinStart();

        void onPinSuccess(Bundle bundle);
    }

    @PluginAccessible
    void addVideoWidget(Activity activity, String str, WidgetPinData widgetPinData, OpenWidgetPinData openWidgetPinData, IWidgetAddBizCallback iWidgetAddBizCallback);

    @StableApi
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/widget/IWidgetBizService$Companion;", "", "()V", "getOrNull", "Lcom/baidu/searchbox/widget/IWidgetBizService;", "getGetOrNull", "()Lcom/baidu/searchbox/widget/IWidgetBizService;", "reference", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getReference", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "setReference", "(Lcom/baidu/pyramid/runtime/service/ServiceReference;)V", "lib_widget_interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IWidgetBizService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IWidgetBizService getOrNull;
        private static ServiceReference reference;

        private Companion() {
        }

        static {
            ServiceReference serviceReference = new ServiceReference("widget", "lib_widget_biz_interface");
            reference = serviceReference;
            getOrNull = (IWidgetBizService) ServiceManager.getService(serviceReference);
        }

        public final ServiceReference getReference() {
            return reference;
        }

        public final void setReference(ServiceReference serviceReference) {
            Intrinsics.checkNotNullParameter(serviceReference, "<set-?>");
            reference = serviceReference;
        }

        public final IWidgetBizService getGetOrNull() {
            return getOrNull;
        }
    }
}
