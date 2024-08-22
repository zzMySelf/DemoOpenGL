package com.tera.scan.sofire.repository;

import android.content.Context;
import i.qw.o;
import i.qw.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/tera/scan/sofire/repository/DoubleListReportRepository;", "", "()V", "reportAlbum", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_sofire_privacy_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DoubleListReportRepository {
    @Nullable
    public final Object qw(@NotNull Context context, @NotNull Continuation<? super Boolean> continuation) {
        return o.yj(u.ad(), new DoubleListReportRepository$reportAlbum$2(context, (Continuation<? super DoubleListReportRepository$reportAlbum$2>) null), continuation);
    }
}
