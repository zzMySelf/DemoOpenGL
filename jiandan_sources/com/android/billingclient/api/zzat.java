package com.android.billingclient.api;

import fe.de.qw.qw.Cif;
import fe.de.qw.qw.Cswitch;
import fe.de.qw.qw.vvv;
import fe.de.qw.qw.yj;
import java.util.Collections;
import java.util.List;

public final class zzat implements AcknowledgePurchaseResponseListener, BillingClientStateListener, ConsumeResponseListener, PriceChangeConfirmationListener, PurchaseHistoryResponseListener, PurchasesResponseListener, PurchasesUpdatedListener, SkuDetailsResponseListener {
    public final long qw = 0;

    public static native void nativeOnAcknowledgePurchaseResponse(int i2, String str, long j);

    public static native void nativeOnBillingServiceDisconnected();

    public static native void nativeOnBillingSetupFinished(int i2, String str, long j);

    public static native void nativeOnConsumePurchaseResponse(int i2, String str, String str2, long j);

    public static native void nativeOnPriceChangeConfirmationResult(int i2, String str, long j);

    public static native void nativeOnPurchaseHistoryResponse(int i2, String str, Cswitch[] switchArr, long j);

    public static native void nativeOnPurchasesUpdated(int i2, String str, Cif[] ifVarArr);

    public static native void nativeOnQueryPurchasesResponse(int i2, String str, Cif[] ifVarArr, long j);

    public static native void nativeOnSkuDetailsResponse(int i2, String str, vvv[] vvvArr, long j);

    public final void ad(yj yjVar) {
        nativeOnBillingSetupFinished(yjVar.ad(), yjVar.qw(), this.qw);
    }

    public final void de() {
        nativeOnBillingServiceDisconnected();
    }

    public final void fe(yj yjVar, List<Cif> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        nativeOnPurchasesUpdated(yjVar.ad(), yjVar.qw(), (Cif[]) list.toArray(new Cif[list.size()]));
    }

    public final void qw(yj yjVar, List<Cif> list) {
        nativeOnQueryPurchasesResponse(yjVar.ad(), yjVar.qw(), (Cif[]) list.toArray(new Cif[list.size()]), this.qw);
    }

    public final void rg(yj yjVar) {
        nativeOnPriceChangeConfirmationResult(yjVar.ad(), yjVar.qw(), this.qw);
    }

    public final void th(yj yjVar, String str) {
        nativeOnConsumePurchaseResponse(yjVar.ad(), yjVar.qw(), str, this.qw);
    }
}
