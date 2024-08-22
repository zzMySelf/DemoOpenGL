package com.mars.united.international.pay;

import fe.de.qw.qw.Cif;
import i.qw.i0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class GooglePay$queryPurchases$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function2<List<? extends Cif>, List<? extends Cif>, Unit> $onResult;
    public final /* synthetic */ GooglePay this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.mars.united.international.pay.GooglePay$queryPurchases$1$1", f = "GooglePay.kt", i = {1}, l = {195, 200, 205}, m = "invokeSuspend", n = {"inAppPurchase"}, s = {"L$0"})
    /* renamed from: com.mars.united.international.pay.GooglePay$queryPurchases$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object L$0;
        public int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(googlePay, function2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0092 A[RETURN] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                java.lang.String r2 = "newBuilder()\n           …                 .build()"
                java.lang.String r3 = "billingClientInstant"
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x002e
                if (r1 == r6) goto L_0x002a
                if (r1 == r5) goto L_0x0022
                if (r1 != r4) goto L_0x001a
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x0093
            L_0x001a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0022:
                java.lang.Object r1 = r8.L$0
                fe.de.qw.qw.when r1 = (fe.de.qw.qw.when) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x007a
            L_0x002a:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x0053
            L_0x002e:
                kotlin.ResultKt.throwOnFailure(r9)
                com.mars.united.international.pay.GooglePay r9 = r1
                fe.de.qw.qw.de r9 = r9.pf()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
                fe.de.qw.qw.ggg$qw r1 = fe.de.qw.qw.ggg.qw()
                java.lang.String r7 = "inapp"
                r1.ad(r7)
                fe.de.qw.qw.ggg r1 = r1.qw()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                r8.label = r6
                java.lang.Object r9 = fe.de.qw.qw.rg.ad(r9, r1, r8)
                if (r9 != r0) goto L_0x0053
                return r0
            L_0x0053:
                r1 = r9
                fe.de.qw.qw.when r1 = (fe.de.qw.qw.when) r1
                com.mars.united.international.pay.GooglePay r9 = r1
                fe.de.qw.qw.de r9 = r9.pf()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
                fe.de.qw.qw.ggg$qw r3 = fe.de.qw.qw.ggg.qw()
                java.lang.String r6 = "subs"
                r3.ad(r6)
                fe.de.qw.qw.ggg r3 = r3.qw()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
                r8.L$0 = r1
                r8.label = r5
                java.lang.Object r9 = fe.de.qw.qw.rg.ad(r9, r3, r8)
                if (r9 != r0) goto L_0x007a
                return r0
            L_0x007a:
                fe.de.qw.qw.when r9 = (fe.de.qw.qw.when) r9
                i.qw.z0 r2 = i.qw.u.de()
                com.mars.united.international.pay.GooglePay$queryPurchases$1$1$1 r3 = new com.mars.united.international.pay.GooglePay$queryPurchases$1$1$1
                kotlin.jvm.functions.Function2<java.util.List<? extends fe.de.qw.qw.if>, java.util.List<? extends fe.de.qw.qw.if>, kotlin.Unit> r5 = r2
                r6 = 0
                r3.<init>(r5, r1, r9, r6)
                r8.L$0 = r6
                r8.label = r4
                java.lang.Object r9 = i.qw.o.yj(r2, r3, r8)
                if (r9 != r0) goto L_0x0093
                return r0
            L_0x0093:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mars.united.international.pay.GooglePay$queryPurchases$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePay$queryPurchases$1(GooglePay googlePay, Function2<? super List<? extends Cif>, ? super List<? extends Cif>, Unit> function2) {
        super(0);
        this.this$0 = googlePay;
        this.$onResult = function2;
    }

    public final void invoke() {
        i0 i0Var = i0.f6136ad;
        final GooglePay googlePay = this.this$0;
        final Function2<List<? extends Cif>, List<? extends Cif>, Unit> function2 = this.$onResult;
        Job unused = i.qw.Cif.fe(i0Var, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
