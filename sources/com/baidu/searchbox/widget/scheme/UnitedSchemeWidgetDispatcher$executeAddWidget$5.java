package com.baidu.searchbox.widget.scheme;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.widget.IWidgetService;
import com.baidu.searchbox.widget.WidgetDataStatisticUtils;
import com.baidu.searchbox.widget.debug.WidgetDebugKt;
import com.baidu.searchbox.widget.pin.IWidgetAddCallback;
import com.baidu.searchbox.widget.pin.PinResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/widget/scheme/UnitedSchemeWidgetDispatcher$executeAddWidget$5", "Lcom/baidu/searchbox/widget/pin/IWidgetAddCallback;", "onFailure", "", "failureResponse", "Lcom/baidu/searchbox/widget/pin/PinResponse;", "onShowing", "showIngResponse", "onSuccess", "successResponse", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnitedSchemeWidgetDispatcher.kt */
public final class UnitedSchemeWidgetDispatcher$executeAddWidget$5 implements IWidgetAddCallback {
    final /* synthetic */ CallbackHandler $callbackHandler;
    final /* synthetic */ UnitedSchemeEntity $entity;
    final /* synthetic */ Ref.ObjectRef<String> $from;
    final /* synthetic */ Ref.ObjectRef<String> $name;
    final /* synthetic */ Ref.BooleanRef $showGuide;
    final /* synthetic */ Ref.IntRef $type;

    UnitedSchemeWidgetDispatcher$executeAddWidget$5(CallbackHandler $callbackHandler2, UnitedSchemeEntity $entity2, Ref.IntRef $type2, Ref.ObjectRef<String> $name2, Ref.BooleanRef $showGuide2, Ref.ObjectRef<String> $from2) {
        this.$callbackHandler = $callbackHandler2;
        this.$entity = $entity2;
        this.$type = $type2;
        this.$name = $name2;
        this.$showGuide = $showGuide2;
        this.$from = $from2;
    }

    public void onSuccess(PinResponse successResponse) {
        Intrinsics.checkNotNullParameter(successResponse, "successResponse");
        WidgetDebugKt.printLog("SchemeWidgetDispatcher", (Function0<String>) new UnitedSchemeWidgetDispatcher$executeAddWidget$5$onSuccess$1(this.$type, this.$name));
        UnitedSchemeUtility.callCallback(this.$callbackHandler, this.$entity, 0);
    }

    public void onFailure(PinResponse failureResponse) {
        IWidgetService getOrNull;
        Intrinsics.checkNotNullParameter(failureResponse, "failureResponse");
        WidgetDebugKt.printLog("SchemeWidgetDispatcher", (Function0<String>) new UnitedSchemeWidgetDispatcher$executeAddWidget$5$onFailure$1(failureResponse, this.$type, this.$name));
        UnitedSchemeUtility.callCallback(this.$callbackHandler, this.$entity, failureResponse.getStatusCode());
        if (this.$showGuide.element && 1003 != failureResponse.getStatusCode() && (getOrNull = IWidgetService.Companion.getGetOrNull()) != null) {
            String widgetStatisticType = WidgetDataStatisticUtils.getWidgetStatisticType(this.$type.element);
            Intrinsics.checkNotNullExpressionValue(widgetStatisticType, "getWidgetStatisticType(type)");
            String str = (String) this.$from.element;
            IWidgetService getOrNull2 = IWidgetService.Companion.getGetOrNull();
            getOrNull.showWidgetGuideDialog(widgetStatisticType, str, getOrNull2 != null ? getOrNull2.getWidgetGuideData() : null);
        }
    }

    public void onShowing(PinResponse showIngResponse) {
        Intrinsics.checkNotNullParameter(showIngResponse, "showIngResponse");
    }
}
