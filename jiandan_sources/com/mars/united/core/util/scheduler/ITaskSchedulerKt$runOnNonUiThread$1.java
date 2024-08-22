package com.mars.united.core.util.scheduler;

import com.mars.kotlin.extension.Logger;
import com.mars.united.core.debug.DevelopException;
import fe.ggg.ad.qw.ad.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class ITaskSchedulerKt$runOnNonUiThread$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final ITaskSchedulerKt$runOnNonUiThread$1 INSTANCE = new ITaskSchedulerKt$runOnNonUiThread$1();

    public ITaskSchedulerKt$runOnNonUiThread$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        if (Logger.INSTANCE.getEnable() && qw.qw.ad()) {
            throw new DevelopException(th2);
        }
    }
}
