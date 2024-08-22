package com.baidu.searchbox.kmm.medal.services;

import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MedalService.kt */
final class MedalServiceKt$showMedalDetailDialog$popedResultCallback$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $popedCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MedalServiceKt$showMedalDetailDialog$popedResultCallback$1(Function1<? super Boolean, Unit> function1) {
        super(1);
        this.$popedCallback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean success) {
        final Function1<Boolean, Unit> function1 = this.$popedCallback;
        BackgroundTaskUtilsKt.mainWork(new Function0<Unit>() {
            public final void invoke() {
                function1.invoke(Boolean.valueOf(success));
            }
        });
    }
}
