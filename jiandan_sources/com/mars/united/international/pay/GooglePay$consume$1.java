package com.mars.united.international.pay;

import fe.de.qw.qw.uk;
import fe.de.qw.qw.yj;
import fe.ggg.ad.ad.qw.ad;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class GooglePay$consume$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Ref.IntRef $count;
    public final /* synthetic */ Function1<List<String>, Unit> $onResult;
    public final /* synthetic */ List<String> $purchaseToken;
    public final /* synthetic */ List<String> $result;
    public final /* synthetic */ GooglePay this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePay$consume$1(List<String> list, GooglePay googlePay, Ref.IntRef intRef, List<String> list2, Function1<? super List<String>, Unit> function1) {
        super(0);
        this.$purchaseToken = list;
        this.this$0 = googlePay;
        this.$count = intRef;
        this.$result = list2;
        this.$onResult = function1;
    }

    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m709invoke$lambda1$lambda0(Ref.IntRef intRef, List list, String str, Function1 function1, yj yjVar, String str2) {
        Intrinsics.checkNotNullParameter(intRef, "$count");
        Intrinsics.checkNotNullParameter(list, "$result");
        Intrinsics.checkNotNullParameter(str, "$it");
        Intrinsics.checkNotNullParameter(function1, "$onResult");
        Intrinsics.checkNotNullParameter(yjVar, "billingResult");
        Intrinsics.checkNotNullParameter(str2, "$noName_1");
        intRef.element--;
        list.add("consume responseCode =" + yjVar.ad() + " msg=" + yjVar.qw() + " purchaseToken=" + str);
        if (intRef.element <= 0) {
            function1.invoke(list);
        }
    }

    public final void invoke() {
        List<String> list = this.$purchaseToken;
        GooglePay googlePay = this.this$0;
        Ref.IntRef intRef = this.$count;
        List<String> list2 = this.$result;
        Function1<List<String>, Unit> function1 = this.$onResult;
        for (String str : list) {
            uk.qw ad2 = uk.ad();
            ad2.ad(str);
            uk qw = ad2.qw();
            Intrinsics.checkNotNullExpressionValue(qw, "newBuilder()\n           …                 .build()");
            googlePay.pf().qw(qw, new ad(intRef, list2, str, function1));
        }
    }
}
