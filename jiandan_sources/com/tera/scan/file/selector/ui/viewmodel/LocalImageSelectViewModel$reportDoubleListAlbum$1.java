package com.tera.scan.file.selector.ui.viewmodel;

import android.content.Context;
import com.tera.scan.sofire.repository.DoubleListReportRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.file.selector.ui.viewmodel.LocalImageSelectViewModel$reportDoubleListAlbum$1", f = "LocalImageSelectViewModel.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
public final class LocalImageSelectViewModel$reportDoubleListAlbum$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectViewModel$reportDoubleListAlbum$1(Context context, Continuation<? super LocalImageSelectViewModel$reportDoubleListAlbum$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LocalImageSelectViewModel$reportDoubleListAlbum$1(this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LocalImageSelectViewModel$reportDoubleListAlbum$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DoubleListReportRepository doubleListReportRepository = new DoubleListReportRepository();
            Context context = this.$context;
            this.label = 1;
            if (doubleListReportRepository.qw(context, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
