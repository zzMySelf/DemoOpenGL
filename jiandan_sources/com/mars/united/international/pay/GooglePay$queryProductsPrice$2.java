package com.mars.united.international.pay;

import androidx.lifecycle.MutableLiveData;
import fe.de.qw.qw.o;
import fe.ggg.ad.ad.qw.fe;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.mars.united.international.pay.GooglePay$queryProductsPrice$2", f = "GooglePay.kt", i = {0, 0, 1}, l = {265, 266}, m = "invokeSuspend", n = {"result", "inAppProducts", "result"}, s = {"L$0", "L$1", "L$0"})
public final class GooglePay$queryProductsPrice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableLiveData<List<o>> $livedata;
    public final /* synthetic */ List<fe> $productParams;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public int label;
    public final /* synthetic */ GooglePay this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePay$queryProductsPrice$2(List<fe> list, MutableLiveData<List<o>> mutableLiveData, GooglePay googlePay, Continuation<? super GooglePay$queryProductsPrice$2> continuation) {
        super(2, continuation);
        this.$productParams = list;
        this.$livedata = mutableLiveData;
        this.this$0 = googlePay;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GooglePay$queryProductsPrice$2 googlePay$queryProductsPrice$2 = new GooglePay$queryProductsPrice$2(this.$productParams, this.$livedata, this.this$0, continuation);
        googlePay$queryProductsPrice$2.L$0 = obj;
        return googlePay$queryProductsPrice$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GooglePay$queryProductsPrice$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0112  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 == r5) goto L_0x0024
            if (r2 != r3) goto L_0x001c
            java.lang.Object r1 = r0.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r2 = r17
            goto L_0x00f7
        L_0x001c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0024:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r17)
            r13 = r6
            r6 = r17
            goto L_0x00d3
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.util.List<fe.ggg.ad.ad.qw.fe> r6 = r0.$productParams
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0046:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x006e
            java.lang.Object r8 = r6.next()
            fe.ggg.ad.ad.qw.fe r8 = (fe.ggg.ad.ad.qw.fe) r8
            java.lang.String r9 = r8.ad()
            java.lang.Object r10 = r7.get(r9)
            if (r10 != 0) goto L_0x0064
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r7.put(r9, r10)
        L_0x0064:
            java.util.List r10 = (java.util.List) r10
            java.lang.String r8 = r8.qw()
            r10.add(r8)
            goto L_0x0046
        L_0x006e:
            java.lang.String r6 = "subs"
            java.lang.Object r6 = r7.get(r6)
            java.util.List r6 = (java.util.List) r6
            java.lang.String r8 = "inapp"
            java.lang.Object r7 = r7.get(r8)
            r12 = r7
            java.util.List r12 = (java.util.List) r12
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r14 = 0
            if (r6 == 0) goto L_0x0090
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x008e
            goto L_0x0090
        L_0x008e:
            r7 = 0
            goto L_0x0091
        L_0x0090:
            r7 = 1
        L_0x0091:
            if (r7 != 0) goto L_0x00a5
            r7 = 0
            r8 = 0
            com.mars.united.international.pay.GooglePay$queryProductsPrice$2$1 r9 = new com.mars.united.international.pay.GooglePay$queryProductsPrice$2$1
            com.mars.united.international.pay.GooglePay r10 = r0.this$0
            r9.<init>(r10, r6, r4)
            r10 = 3
            r11 = 0
            r6 = r2
            kotlinx.coroutines.Deferred r6 = i.qw.Cif.ad(r6, r7, r8, r9, r10, r11)
            r15 = r6
            goto L_0x00a6
        L_0x00a5:
            r15 = r4
        L_0x00a6:
            if (r12 == 0) goto L_0x00ae
            boolean r6 = r12.isEmpty()
            if (r6 == 0) goto L_0x00af
        L_0x00ae:
            r14 = 1
        L_0x00af:
            if (r14 != 0) goto L_0x00c2
            r7 = 0
            r8 = 0
            com.mars.united.international.pay.GooglePay$queryProductsPrice$2$2 r9 = new com.mars.united.international.pay.GooglePay$queryProductsPrice$2$2
            com.mars.united.international.pay.GooglePay r6 = r0.this$0
            r9.<init>(r6, r12, r4)
            r10 = 3
            r11 = 0
            r6 = r2
            kotlinx.coroutines.Deferred r2 = i.qw.Cif.ad(r6, r7, r8, r9, r10, r11)
            goto L_0x00c3
        L_0x00c2:
            r2 = r4
        L_0x00c3:
            if (r15 != 0) goto L_0x00c6
            goto L_0x00e6
        L_0x00c6:
            r0.L$0 = r13
            r0.L$1 = r2
            r0.label = r5
            java.lang.Object r6 = r15.th(r0)
            if (r6 != r1) goto L_0x00d3
            return r1
        L_0x00d3:
            fe.de.qw.qw.pf r6 = (fe.de.qw.qw.pf) r6
            if (r6 != 0) goto L_0x00d8
            goto L_0x00e6
        L_0x00d8:
            java.util.List r6 = r6.ad()
            if (r6 != 0) goto L_0x00df
            goto L_0x00e6
        L_0x00df:
            boolean r6 = r13.addAll(r6)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x00e6:
            if (r2 != 0) goto L_0x00e9
            goto L_0x010b
        L_0x00e9:
            r0.L$0 = r13
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r2 = r2.th(r0)
            if (r2 != r1) goto L_0x00f6
            return r1
        L_0x00f6:
            r1 = r13
        L_0x00f7:
            fe.de.qw.qw.pf r2 = (fe.de.qw.qw.pf) r2
            if (r2 != 0) goto L_0x00fc
            goto L_0x010a
        L_0x00fc:
            java.util.List r2 = r2.ad()
            if (r2 != 0) goto L_0x0103
            goto L_0x010a
        L_0x0103:
            boolean r2 = r1.addAll(r2)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
        L_0x010a:
            r13 = r1
        L_0x010b:
            boolean r1 = r13.isEmpty()
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x0117
            androidx.lifecycle.MutableLiveData<java.util.List<fe.de.qw.qw.o>> r1 = r0.$livedata
            r1.postValue(r13)
        L_0x0117:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.united.international.pay.GooglePay$queryProductsPrice$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
