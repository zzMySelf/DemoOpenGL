package com.mars.united.international.pay;

import android.content.Context;
import androidx.lifecycle.LiveData;
import fe.de.qw.qw.o;
import fe.ggg.ad.ad.qw.de;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\f0\u0011H\u0016J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e0\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000eJP\u0010\u001c\u001a\u00020\f2F\u0010\u0010\u001aB\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\f0\u001dH\u0016Jp\u0010#\u001a\u00020\f2\"\u0010$\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0%j\b\u0012\u0004\u0012\u00020\u000f`&\u0012\u0004\u0012\u00020\f0\u00112\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020(0\u00112\"\u0010)\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0%j\b\u0012\u0004\u0012\u00020\u000f`&\u0012\u0004\u0012\u00020\f0\u00112\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006,"}, d2 = {"Lcom/mars/united/international/pay/PayProxy;", "Lcom/mars/united/international/pay/IPay;", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "googlePay", "Lcom/mars/united/international/pay/GooglePay;", "getGooglePay", "()Lcom/mars/united/international/pay/GooglePay;", "googlePay$delegate", "Lkotlin/Lazy;", "consume", "", "purchaseToken", "", "", "onResult", "Lkotlin/Function1;", "launchPay", "Landroidx/lifecycle/LiveData;", "Lcom/mars/united/international/pay/PayMessage;", "params", "Lcom/mars/united/international/pay/PayParams;", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "queryProductsPrice", "productParams", "Lcom/mars/united/international/pay/ProductParam;", "queryPurchases", "Lkotlin/Function2;", "Lcom/android/billingclient/api/Purchase;", "Lkotlin/ParameterName;", "name", "inAppResult", "subResult", "queryPurchasesWithFilter", "inAppResultList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "subResultJsonFilter", "", "subResultList", "onFinish", "Lkotlin/Function0;", "pay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PayProxy implements IPay {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Lazy f6667ad = LazyKt__LazyJVMKt.lazy(new PayProxy$googlePay$2(this));
    @NotNull
    public final Context qw;

    public PayProxy(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        this.qw = context;
    }

    public void ad(@NotNull List<String> list, @NotNull Function1<? super List<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "purchaseToken");
        Intrinsics.checkNotNullParameter(function1, "onResult");
        de().o(list, function1);
    }

    public final GooglePay de() {
        return (GooglePay) this.f6667ad.getValue();
    }

    @NotNull
    public LiveData<PayMessage> fe(@NotNull de deVar, @Nullable o oVar) {
        Intrinsics.checkNotNullParameter(deVar, "params");
        return de().m708switch(deVar, oVar);
    }
}
