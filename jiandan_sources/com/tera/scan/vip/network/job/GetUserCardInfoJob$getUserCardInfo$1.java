package com.tera.scan.vip.network.job;

import androidx.lifecycle.MutableLiveData;
import com.tera.scan.vip.network.model.UserCardInfoResponse;
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
@DebugMetadata(c = "com.tera.scan.vip.network.job.GetUserCardInfoJob$getUserCardInfo$1", f = "GetUserCardInfoJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GetUserCardInfoJob$getUserCardInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableLiveData<UserCardInfoResponse> $liveData;
    public int label;
    public final /* synthetic */ GetUserCardInfoJob this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetUserCardInfoJob$getUserCardInfo$1(GetUserCardInfoJob getUserCardInfoJob, MutableLiveData<UserCardInfoResponse> mutableLiveData, Continuation<? super GetUserCardInfoJob$getUserCardInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = getUserCardInfoJob;
        this.$liveData = mutableLiveData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetUserCardInfoJob$getUserCardInfo$1(this.this$0, this.$liveData, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GetUserCardInfoJob$getUserCardInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.ad(this.$liveData);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
