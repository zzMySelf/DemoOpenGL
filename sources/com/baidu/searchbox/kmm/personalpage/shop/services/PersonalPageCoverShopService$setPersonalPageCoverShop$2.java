package com.baidu.searchbox.kmm.personalpage.shop.services;

import com.baidu.searchbox.kmm.foundation.common.ErrorInfo;
import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "errorInfo", "Lcom/baidu/searchbox/kmm/foundation/common/ErrorInfo;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageCoverShopService.kt */
final class PersonalPageCoverShopService$setPersonalPageCoverShop$2 extends Lambda implements Function1<ErrorInfo, Unit> {
    final /* synthetic */ Function1<ErrorInfo, Unit> $failedCB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageCoverShopService$setPersonalPageCoverShop$2(Function1<? super ErrorInfo, Unit> function1) {
        super(1);
        this.$failedCB = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ErrorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(final ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        final Function1<ErrorInfo, Unit> function1 = this.$failedCB;
        BackgroundTaskUtilsKt.mainWork(new Function0<Unit>() {
            public final void invoke() {
                Function1<ErrorInfo, Unit> function1 = function1;
                if (function1 != null) {
                    function1.invoke(errorInfo);
                }
            }
        });
    }
}
