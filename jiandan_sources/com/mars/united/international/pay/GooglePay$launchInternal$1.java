package com.mars.united.international.pay;

import com.mars.kotlin.extension.LoggerKt;
import fe.de.qw.qw.o;
import fe.de.qw.qw.pf;
import fe.ggg.ad.ad.qw.de;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.mars.united.international.pay.GooglePay$launchInternal$1", f = "GooglePay.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
public final class GooglePay$launchInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ de $params;
    public final /* synthetic */ o $productDetails;
    public int label;
    public final /* synthetic */ GooglePay this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePay$launchInternal$1(o oVar, GooglePay googlePay, de deVar, Continuation<? super GooglePay$launchInternal$1> continuation) {
        super(2, continuation);
        this.$productDetails = oVar;
        this.this$0 = googlePay;
        this.$params = deVar;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GooglePay$launchInternal$1(this.$productDetails, this.this$0, this.$params, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GooglePay$launchInternal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            o oVar = this.$productDetails;
            if (oVar != null) {
                this.this$0.when(this.$params, oVar, true);
                return Unit.INSTANCE;
            }
            GooglePay googlePay = this.this$0;
            ArrayList arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.$params.de());
            String fe2 = this.$params.fe();
            this.label = 1;
            obj = googlePay.vvv(arrayListOf, fe2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        pf pfVar = (pf) obj;
        List<o> ad2 = pfVar.ad();
        o oVar2 = ad2 == null ? null : (o) CollectionsKt___CollectionsKt.firstOrNull(ad2);
        if (pfVar.qw().ad() != 0 || oVar2 == null) {
            if (pfVar.qw().ad() == 0 && oVar2 == null) {
                this.this$0.f6663ad.postValue((PayMessage) LoggerKt.d$default(new PayMessage(1801, pfVar.qw().qw(), this.$params.rg(), (String) null, (String) null, 24, (DefaultConstructorMarker) null), (Object) null, 1, (Object) null));
            } else {
                this.this$0.f6663ad.postValue((PayMessage) LoggerKt.d$default(new PayMessage(pfVar.qw().ad(), pfVar.qw().qw(), this.$params.rg(), (String) null, (String) null, 24, (DefaultConstructorMarker) null), (Object) null, 1, (Object) null));
            }
            return Unit.INSTANCE;
        }
        GooglePay.ppp(this.this$0, this.$params, oVar2, false, 4, (Object) null);
        return Unit.INSTANCE;
    }
}
