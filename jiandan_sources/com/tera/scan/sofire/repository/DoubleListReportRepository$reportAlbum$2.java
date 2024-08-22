package com.tera.scan.sofire.repository;

import android.content.Context;
import com.mars.kotlin.extension.fp.Either;
import fe.mmm.qw.b.qw.qw;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.sofire.repository.DoubleListReportRepository$reportAlbum$2", f = "DoubleListReportRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoubleListReportRepository$reportAlbum$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public final /* synthetic */ Context $context;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoubleListReportRepository$reportAlbum$2(Context context, Continuation<? super DoubleListReportRepository$reportAlbum$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DoubleListReportRepository$reportAlbum$2(this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((DoubleListReportRepository$reportAlbum$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(new qw().o(this.$context) instanceof Either.Right);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
