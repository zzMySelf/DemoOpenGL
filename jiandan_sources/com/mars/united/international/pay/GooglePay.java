package com.mars.united.international.pay;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.de.qw.qw.Cif;
import fe.de.qw.qw.o;
import fe.de.qw.qw.pf;
import fe.de.qw.qw.ppp;
import fe.de.qw.qw.yj;
import fe.ggg.ad.ad.qw.de;
import fe.ggg.ad.ad.qw.fe;
import i.qw.i0;
import i.qw.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u00110\u0013j\u0002`\u0014H\u0002J0\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00110\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J \u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020$H\u0002J'\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010(\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010)J \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00170!2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0017J*\u0010*\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00172\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00170\fH\u0002JP\u0010.\u001a\u00020\u00112F\u0010\u0019\u001aB\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u000200\u0018\u00010\u0017¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u000200\u0018\u00010\u0017¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u00110/H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/mars/united/international/pay/GooglePay;", "Lcom/mars/united/international/pay/IPay;", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "billingClientInstant", "Lcom/android/billingclient/api/BillingClient;", "getBillingClientInstant", "()Lcom/android/billingclient/api/BillingClient;", "billingClientInstant$delegate", "Lkotlin/Lazy;", "messageLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/mars/united/international/pay/PayMessage;", "purchasesUpdateListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "connectGooglePlay", "", "onReady", "Lkotlin/Function0;", "Lcom/mars/united/international/pay/onReady;", "consume", "purchaseToken", "", "", "onResult", "Lkotlin/Function1;", "launchInternal", "params", "Lcom/mars/united/international/pay/PayParams;", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "launchPay", "Landroidx/lifecycle/LiveData;", "launchPayClient", "isFromCache", "", "queryProductDetails", "Lcom/android/billingclient/api/ProductDetailsResult;", "productIds", "productType", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryProductsPrice", "productParams", "Lcom/mars/united/international/pay/ProductParam;", "livedata", "queryPurchases", "Lkotlin/Function2;", "Lcom/android/billingclient/api/Purchase;", "Lkotlin/ParameterName;", "name", "inAppResult", "subResult", "BillingClientStateListenerImpl", "pay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Tag("GooglePay")
public final class GooglePay implements IPay {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final MutableLiveData<PayMessage> f6663ad = new MutableLiveData<>();
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Lazy f6664de = LazyKt__LazyJVMKt.lazy(new GooglePay$billingClientInstant$2(this));
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final PurchasesUpdatedListener f6665fe = new fe.ggg.ad.ad.qw.qw(this);
    @NotNull
    public final Context qw;

    public static final class qw implements BillingClientStateListener {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final WeakReference<Function0<Unit>> f6666ad;
        @NotNull
        public final WeakReference<GooglePay> qw;

        public qw(@NotNull WeakReference<GooglePay> weakReference, @NotNull WeakReference<Function0<Unit>> weakReference2) {
            Intrinsics.checkNotNullParameter(weakReference, "googlePayWeakRef");
            Intrinsics.checkNotNullParameter(weakReference2, "onReadyWeakRef");
            this.qw = weakReference;
            this.f6666ad = weakReference2;
        }

        public void ad(@NotNull yj yjVar) {
            Intrinsics.checkNotNullParameter(yjVar, "p0");
            if (yjVar.ad() == 0) {
                Function0 function0 = (Function0) this.f6666ad.get();
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            PayMessage payMessage = (PayMessage) LoggerKt.d$default(new PayMessage(yjVar.ad(), yjVar.qw(), (String) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null), (Object) null, 1, (Object) null);
            GooglePay googlePay = (GooglePay) this.qw.get();
            if (googlePay != null) {
                googlePay.f6663ad.postValue(payMessage);
            }
        }

        public void de() {
        }
    }

    public GooglePay(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        this.qw = context;
    }

    public static final void ggg(GooglePay googlePay, yj yjVar, List list) {
        String str;
        String qw2;
        String ad2;
        Intrinsics.checkNotNullParameter(googlePay, "this$0");
        Intrinsics.checkNotNullParameter(yjVar, "billingResult");
        Cif ifVar = list == null ? null : (Cif) CollectionsKt___CollectionsKt.firstOrNull(list);
        if (yjVar.ad() != 0 || ifVar == null) {
            googlePay.f6663ad.postValue((PayMessage) LoggerKt.d$default(new PayMessage(yjVar.ad(), yjVar.qw(), (String) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null), (Object) null, 1, (Object) null));
            return;
        }
        String de2 = ifVar.de();
        Intrinsics.checkNotNullExpressionValue(de2, "purchase.originalJson");
        fe.de.qw.qw.qw qw3 = ifVar.qw();
        String str2 = (qw3 == null || (ad2 = qw3.ad()) == null) ? "" : ad2;
        fe.de.qw.qw.qw qw4 = ifVar.qw();
        if (qw4 == null || (qw2 = qw4.qw()) == null) {
            str = "";
        } else {
            str = qw2;
        }
        if (ifVar.rg() != 1) {
            googlePay.f6663ad.postValue((PayMessage) LoggerKt.d$default(new PayMessage(6, Intrinsics.stringPlus("purchaseState = ", Integer.valueOf(ifVar.rg())), str2, de2, (String) null, 16, (DefaultConstructorMarker) null), (Object) null, 1, (Object) null));
        } else {
            googlePay.f6663ad.postValue((PayMessage) LoggerKt.d$default(new PayMessage(yjVar.ad(), yjVar.qw(), str, str2, de2), (Object) null, 1, (Object) null));
        }
    }

    public static /* synthetic */ void ppp(GooglePay googlePay, de deVar, o oVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        googlePay.when(deVar, oVar, z);
    }

    public final void i(Function0<Unit> function0) {
        if (pf().ad()) {
            function0.invoke();
        } else {
            pf().yj(new qw(new WeakReference(this), new WeakReference(function0)));
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m707if(de deVar, o oVar) {
        Job unused = i.qw.Cif.fe(i0.f6136ad, (CoroutineContext) null, (CoroutineStart) null, new GooglePay$launchInternal$1(oVar, this, deVar, (Continuation<? super GooglePay$launchInternal$1>) null), 3, (Object) null);
    }

    public void o(@NotNull List<String> list, @NotNull Function1<? super List<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "purchaseToken");
        Intrinsics.checkNotNullParameter(function1, "onResult");
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            function1.invoke(arrayList);
            return;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = list.size();
        i(new GooglePay$consume$1(list, this, intRef, arrayList, function1));
    }

    public final fe.de.qw.qw.de pf() {
        return (fe.de.qw.qw.de) this.f6664de.getValue();
    }

    @NotNull
    /* renamed from: switch  reason: not valid java name */
    public LiveData<PayMessage> m708switch(@NotNull de deVar, @Nullable o oVar) {
        Intrinsics.checkNotNullParameter(deVar, "params");
        i(new GooglePay$launchPay$1(this, deVar, oVar));
        return this.f6663ad;
    }

    public final Object vvv(List<String> list, String str, Continuation<? super pf> continuation) {
        ppp.qw qw2 = ppp.qw();
        Intrinsics.checkNotNullExpressionValue(qw2, "newBuilder()");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (String ad2 : list) {
            ppp.ad.qw qw3 = ppp.ad.qw();
            qw3.ad(ad2);
            qw3.de(str);
            arrayList.add(qw3.qw());
        }
        qw2.ad(arrayList);
        return i.qw.o.yj(u.ad(), new GooglePay$queryProductDetails$3(this, qw2, (Continuation<? super GooglePay$queryProductDetails$3>) null), continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r13 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        if (r13 == null) goto L_0x005d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void when(fe.ggg.ad.ad.qw.de r11, fe.de.qw.qw.o r12, boolean r13) {
        /*
            r10 = this;
            java.lang.ref.WeakReference r0 = r11.ad()
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 == 0) goto L_0x00c3
            boolean r1 = r0.isDestroyed()
            if (r1 != 0) goto L_0x00c3
            boolean r1 = r0.isFinishing()
            if (r1 == 0) goto L_0x001a
            goto L_0x00c3
        L_0x001a:
            r1 = 0
            java.lang.String r2 = ""
            if (r13 == 0) goto L_0x0047
            java.util.List r13 = r12.fe()
            boolean r3 = r13 instanceof java.util.List
            if (r3 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r13 = r1
        L_0x0029:
            if (r13 != 0) goto L_0x002c
            goto L_0x005d
        L_0x002c:
            java.lang.Object r13 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r13)
            com.google.gson.internal.LinkedTreeMap r13 = (com.google.gson.internal.LinkedTreeMap) r13
            if (r13 != 0) goto L_0x0035
            goto L_0x005d
        L_0x0035:
            java.lang.String r3 = "offerToken"
            java.lang.Object r13 = r13.get(r3)
            if (r13 != 0) goto L_0x003e
            goto L_0x005d
        L_0x003e:
            java.lang.String r13 = r13.toString()
            if (r13 != 0) goto L_0x0045
            goto L_0x005d
        L_0x0045:
            r2 = r13
            goto L_0x005d
        L_0x0047:
            java.util.List r13 = r12.fe()
            if (r13 != 0) goto L_0x004e
            goto L_0x005d
        L_0x004e:
            java.lang.Object r13 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r13)
            fe.de.qw.qw.o$fe r13 = (fe.de.qw.qw.o.fe) r13
            if (r13 != 0) goto L_0x0057
            goto L_0x005d
        L_0x0057:
            java.lang.String r13 = r13.qw()
            if (r13 != 0) goto L_0x0045
        L_0x005d:
            fe.de.qw.qw.th$ad$qw r13 = fe.de.qw.qw.th.ad.qw()
            r13.ad(r2)
            r13.de(r12)
            fe.de.qw.qw.th$ad r12 = r13.qw()
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r12)
            fe.de.qw.qw.th$qw r13 = fe.de.qw.qw.th.qw()
            r13.fe(r12)
            java.lang.String r12 = r11.rg()
            r13.de(r12)
            java.lang.String r12 = r11.qw()
            r13.ad(r12)
            fe.de.qw.qw.th r12 = r13.qw()
            java.lang.String r13 = "newBuilder()\n           …tId)\n            .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            fe.de.qw.qw.de r13 = r10.pf()
            fe.de.qw.qw.yj r12 = r13.de(r0, r12)
            java.lang.String r13 = "billingClientInstant.lau…low(activity, flowParams)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            int r13 = r12.ad()
            if (r13 == 0) goto L_0x00c3
            com.mars.united.international.pay.PayMessage r13 = new com.mars.united.international.pay.PayMessage
            int r3 = r12.ad()
            java.lang.String r4 = r12.qw()
            java.lang.String r5 = r11.rg()
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r11 = 1
            java.lang.Object r11 = com.mars.kotlin.extension.LoggerKt.d$default(r13, r1, r11, r1)
            com.mars.united.international.pay.PayMessage r11 = (com.mars.united.international.pay.PayMessage) r11
            androidx.lifecycle.MutableLiveData<com.mars.united.international.pay.PayMessage> r12 = r10.f6663ad
            r12.postValue(r11)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.united.international.pay.GooglePay.when(fe.ggg.ad.ad.qw.de, fe.de.qw.qw.o, boolean):void");
    }

    public final void xxx(List<fe> list, MutableLiveData<List<o>> mutableLiveData) {
        Job unused = i.qw.Cif.fe(i0.f6136ad, (CoroutineContext) null, (CoroutineStart) null, new GooglePay$queryProductsPrice$2(list, mutableLiveData, this, (Continuation<? super GooglePay$queryProductsPrice$2>) null), 3, (Object) null);
    }
}
