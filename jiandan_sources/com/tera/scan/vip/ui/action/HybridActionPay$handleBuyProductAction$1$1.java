package com.tera.scan.vip.ui.action;

import com.tera.scan.vip.ui.viewmodel.VipBuyViewModel;
import fe.mmm.qw.m.ggg.fe.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "loginResult", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HybridActionPay$handleBuyProductAction$1$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ String $googleProductId;
    public final /* synthetic */ boolean $isSubs;
    public final /* synthetic */ ad $param;
    public final /* synthetic */ String $productId;
    public final /* synthetic */ VipBuyViewModel $vipBuyViewModel;
    public final /* synthetic */ HybridActionPay this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HybridActionPay$handleBuyProductAction$1$1(HybridActionPay hybridActionPay, boolean z, String str, String str2, VipBuyViewModel vipBuyViewModel, ad adVar) {
        super(1);
        this.this$0 = hybridActionPay;
        this.$isSubs = z;
        this.$productId = str;
        this.$googleProductId = str2;
        this.$vipBuyViewModel = vipBuyViewModel;
        this.$param = adVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            this.this$0.buyProduct(this.$isSubs, this.$productId, this.$googleProductId, this.$vipBuyViewModel, this.$param, true);
        } else {
            this.this$0.handleHybridCallback(this.$param, 0, "login fail", (JSONObject) null);
        }
    }
}
