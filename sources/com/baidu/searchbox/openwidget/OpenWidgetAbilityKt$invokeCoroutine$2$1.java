package com.baidu.searchbox.openwidget;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/openwidget/OpenWidgetAbilityKt$invokeCoroutine$2$1", "Lcom/baidu/searchbox/openwidget/OpenWidgetAbilityCallback;", "onFailure", "", "request", "Lcom/baidu/searchbox/openwidget/OpenWidgetAbilityRequest;", "response", "Lcom/baidu/searchbox/openwidget/OpenWidgetAbilityResponse;", "onSuccess", "lib-openwidget-ability-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetAbility.kt */
public final class OpenWidgetAbilityKt$invokeCoroutine$2$1 implements OpenWidgetAbilityCallback {
    final /* synthetic */ CancellableContinuation<OpenWidgetAbilityResponse> $continuation;

    OpenWidgetAbilityKt$invokeCoroutine$2$1(CancellableContinuation<? super OpenWidgetAbilityResponse> $continuation2) {
        this.$continuation = $continuation2;
    }

    public void onSuccess(OpenWidgetAbilityRequest request, OpenWidgetAbilityResponse response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (OpenWidgetAbilityKt.DEBUG) {
            OpenWidgetAbilityKt.log("invokeSuccess, response=" + response);
        }
        Result.Companion companion = Result.Companion;
        this.$continuation.resumeWith(Result.m8971constructorimpl(response));
    }

    public void onFailure(OpenWidgetAbilityRequest request, OpenWidgetAbilityResponse response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (OpenWidgetAbilityKt.DEBUG) {
            OpenWidgetAbilityKt.log("invokeFailure, response=" + response);
        }
        Result.Companion companion = Result.Companion;
        this.$continuation.resumeWith(Result.m8971constructorimpl(response));
    }
}
