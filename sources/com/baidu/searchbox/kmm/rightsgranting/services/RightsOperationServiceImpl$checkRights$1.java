package com.baidu.searchbox.kmm.rightsgranting.services;

import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import com.baidu.searchbox.kmm.foundation.concurrent.CancelableTask;
import com.baidu.searchbox.kmm.rightsgranting.ubc.RightsGrantingUBCKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/kmm/foundation/concurrent/CancelableTask;", "resultScene", "", "resultRightsId", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RightsOperationServiceImpl.kt */
final class RightsOperationServiceImpl$checkRights$1 extends Lambda implements Function2<String, String, CancelableTask> {
    final /* synthetic */ String $page;
    final /* synthetic */ Function2<String, String, Unit> $successCB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RightsOperationServiceImpl$checkRights$1(String str, Function2<? super String, ? super String, Unit> function2) {
        super(2);
        this.$page = str;
        this.$successCB = function2;
    }

    public final CancelableTask invoke(final String resultScene, final String resultRightsId) {
        Intrinsics.checkNotNullParameter(resultScene, "resultScene");
        Intrinsics.checkNotNullParameter(resultRightsId, "resultRightsId");
        RightsGrantingUBCKt.rightsCheckSuccessUBC(resultScene, resultRightsId, this.$page);
        final Function2<String, String, Unit> function2 = this.$successCB;
        return BackgroundTaskUtilsKt.mainWork(new Function0<Unit>() {
            public final void invoke() {
                function2.invoke(resultScene, resultRightsId);
            }
        });
    }
}
