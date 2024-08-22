package com.baidu.searchbox.widget.pin.strategy.impl;

import com.baidu.searchbox.widget.constants.WidgetSchemeConstantsKt;
import com.baidu.searchbox.widget.model.WidgetItemData;
import com.baidu.searchbox.widget.model.WidgetModelData;
import com.baidu.searchbox.widget.model.WidgetModelInstance;
import com.baidu.searchbox.widget.pin.PinResponse;
import com.baidu.searchbox.widget.pin.WidgetPinData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/widget/model/WidgetModelInstance;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.widget.pin.strategy.impl.OneSearchWidgetAddStrategy$buildWidgetModelInstance$2", f = "OneSearchWidgetAddStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OneSearchWidgetAddStrategy.kt */
final class OneSearchWidgetAddStrategy$buildWidgetModelInstance$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WidgetModelInstance>, Object> {
    final /* synthetic */ WidgetPinData $pinData;
    final /* synthetic */ PinResponse $pinResponse;
    final /* synthetic */ String $source;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneSearchWidgetAddStrategy$buildWidgetModelInstance$2(WidgetPinData widgetPinData, PinResponse pinResponse, String str, Continuation<? super OneSearchWidgetAddStrategy$buildWidgetModelInstance$2> continuation) {
        super(2, continuation);
        this.$pinData = widgetPinData;
        this.$pinResponse = pinResponse;
        this.$source = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OneSearchWidgetAddStrategy$buildWidgetModelInstance$2(this.$pinData, this.$pinResponse, this.$source, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WidgetModelInstance> continuation) {
        return ((OneSearchWidgetAddStrategy$buildWidgetModelInstance$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        WidgetModelData widgetModelData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Object obj3 = obj;
                WidgetPinData widgetPinData = this.$pinData;
                PinResponse pinResponse = this.$pinResponse;
                String str = this.$source;
                try {
                    Result.Companion companion = Result.Companion;
                    if (widgetPinData.getType() == 10) {
                        widgetModelData = new WidgetModelData(pinResponse.getAppWidgetId(), str, widgetPinData.getType());
                        WidgetModelData widgetModelData2 = widgetModelData;
                        WidgetItemData[] widgetItemDataArr = new WidgetItemData[1];
                        String scheme = widgetPinData.getScheme();
                        if (scheme == null) {
                            scheme = WidgetSchemeConstantsKt.getWidgetScheme(widgetPinData.getRealWidgetType());
                        }
                        widgetItemDataArr[0] = new WidgetItemData(scheme, (String) null, WidgetSchemeConstantsKt.getWidgetTitle(widgetPinData.getRealWidgetType()), widgetPinData.getRealWidgetType(), 2, (DefaultConstructorMarker) null);
                        widgetModelData2.setItems(CollectionsKt.mutableListOf(widgetItemDataArr));
                    } else {
                        widgetModelData = WidgetModelData.Companion.getEmptyWidgetModelData();
                    }
                    obj2 = Result.m8971constructorimpl(new WidgetModelInstance(pinResponse.getAppWidgetId(), widgetModelData));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
                return Result.m8977isFailureimpl(obj2) ? WidgetModelInstance.Companion.getEmptyWidgetModelInstance() : obj2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
