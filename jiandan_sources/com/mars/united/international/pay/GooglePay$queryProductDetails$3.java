package com.mars.united.international.pay;

import fe.de.qw.qw.de;
import fe.de.qw.qw.pf;
import fe.de.qw.qw.ppp;
import fe.de.qw.qw.rg;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/android/billingclient/api/ProductDetailsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.mars.united.international.pay.GooglePay$queryProductDetails$3", f = "GooglePay.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
public final class GooglePay$queryProductDetails$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super pf>, Object> {
    public final /* synthetic */ ppp.qw $params;
    public int label;
    public final /* synthetic */ GooglePay this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePay$queryProductDetails$3(GooglePay googlePay, ppp.qw qwVar, Continuation<? super GooglePay$queryProductDetails$3> continuation) {
        super(2, continuation);
        this.this$0 = googlePay;
        this.$params = qwVar;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GooglePay$queryProductDetails$3(this.this$0, this.$params, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super pf> continuation) {
        return ((GooglePay$queryProductDetails$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            de ad2 = this.this$0.pf();
            Intrinsics.checkNotNullExpressionValue(ad2, "billingClientInstant");
            ppp qw = this.$params.qw();
            Intrinsics.checkNotNullExpressionValue(qw, "params.build()");
            this.label = 1;
            obj = rg.qw(ad2, qw, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
