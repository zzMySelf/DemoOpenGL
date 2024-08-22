package com.baidu.searchbox.kmm.personalpage.shop.api;

import com.baidu.searchbox.kmm.foundation.common.ErrorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageCoverShopApi.kt */
final class PersonalPageCoverShopApiKt$setPersonalPageTaskCover$callbackFailed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ErrorInfo $errorInfo;
    final /* synthetic */ Function1<ErrorInfo, Unit> $failedCB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageCoverShopApiKt$setPersonalPageTaskCover$callbackFailed$1(Function1<? super ErrorInfo, Unit> function1, ErrorInfo errorInfo) {
        super(0);
        this.$failedCB = function1;
        this.$errorInfo = errorInfo;
    }

    public final void invoke() {
        Function1<ErrorInfo, Unit> function1 = this.$failedCB;
        if (function1 != null) {
            function1.invoke(this.$errorInfo);
        }
    }
}
