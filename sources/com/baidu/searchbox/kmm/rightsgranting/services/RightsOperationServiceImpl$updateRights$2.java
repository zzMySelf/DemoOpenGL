package com.baidu.searchbox.kmm.rightsgranting.services;

import com.baidu.searchbox.home.tabs.bubble.HomeTabBubbleInfo;
import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import com.baidu.searchbox.kmm.rightsgranting.ubc.RightsGrantingUBCKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "code", "", "msg", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RightsOperationServiceImpl.kt */
final class RightsOperationServiceImpl$updateRights$2 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $completionCB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RightsOperationServiceImpl$updateRights$2(Function1<? super Boolean, Unit> function1) {
        super(2);
        this.$completionCB = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((String) p1, (String) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(String code, String msg) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Intrinsics.areEqual((Object) code, (Object) HomeTabBubbleInfo.BUBBLE_ID_DEFAULT) || Intrinsics.areEqual((Object) code, (Object) "-400")) {
            RightsGrantingUBCKt.rightsUpdateFailureUBC(code, msg);
        }
        final Function1<Boolean, Unit> function1 = this.$completionCB;
        BackgroundTaskUtilsKt.mainWork(new Function0<Unit>() {
            public final void invoke() {
                Function1<Boolean, Unit> function1 = function1;
                if (function1 != null) {
                    function1.invoke(false);
                }
            }
        });
    }
}
