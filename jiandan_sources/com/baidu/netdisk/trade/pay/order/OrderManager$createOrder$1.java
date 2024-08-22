package com.baidu.netdisk.trade.pay.order;

import androidx.lifecycle.MutableLiveData;
import com.baidu.netdisk.trade.pay.order.model.Purchase;
import fe.fe.when.qw.qw.uk.qw.qw;
import java.util.Map;
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
@DebugMetadata(c = "com.baidu.netdisk.trade.pay.order.OrderManager$createOrder$1", f = "OrderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OrderManager$createOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableLiveData<Purchase> $liveData;
    public final /* synthetic */ Map<String, String> $map;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderManager$createOrder$1(Map<String, String> map, MutableLiveData<Purchase> mutableLiveData, Continuation<? super OrderManager$createOrder$1> continuation) {
        super(2, continuation);
        this.$map = map;
        this.$liveData = mutableLiveData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrderManager$createOrder$1(this.$map, this.$liveData, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OrderManager$createOrder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            new qw().qw(this.$map, this.$liveData);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
