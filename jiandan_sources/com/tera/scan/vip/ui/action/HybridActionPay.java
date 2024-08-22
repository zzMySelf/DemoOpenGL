package com.tera.scan.vip.ui.action;

import android.content.Context;
import android.webkit.WebView;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.sapi2.views.SmsLoginView;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.ui.view.IBaseView;
import com.tera.scan.network.network.request.RequestCommonParams;
import com.tera.scan.vip.ui.viewmodel.VipBuyViewModel;
import com.tera.scan.vip.util.VipSellerCodeReview;
import com.tera.scan.webview.hybrid.action.IWebViewListener;
import fe.ggg.ad.qw.de.th.rg;
import fe.mmm.qw.m.ggg.fe.ad;
import fe.mmm.qw.m.ggg.qw.qw;
import fe.mmm.qw.nn.qw.qw.i;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J8\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J.\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010 \u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J.\u0010#\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J.\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010&\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010'\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/tera/scan/vip/ui/action/HybridActionPay;", "Lcom/tera/scan/webview/hybrid/action/HybridAction;", "baseView", "Lcom/tera/scan/framework/ui/view/IBaseView;", "baseUrl", "", "fromScene", "(Lcom/tera/scan/framework/ui/view/IBaseView;Ljava/lang/String;Ljava/lang/String;)V", "injectForwards", "", "Lcom/tera/scan/web/hybrid/factory/HybridForwardProvider;", "addSuccessParams", "orderNo", "buyProduct", "", "isSubs", "", "productId", "googleProductId", "vipBuyViewModel", "Lcom/tera/scan/vip/ui/viewmodel/VipBuyViewModel;", "param", "Lcom/tera/scan/webview/hybrid/param/HybridUrlParam;", "loginForPurchase", "callH5Function", "funName", "code", "", "msg", "result", "Lorg/json/JSONObject;", "handleBuyProductAction", "handleGetInternetAction", "handleGetMemberParamsAction", "handleGoHomeAction", "handleHybridCallback", "handleNewHybridCallback", "callBackId", "handleRecognizeSchemeError", "onAction", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Keep
@Tag("HybridActionPay")
public final class HybridActionPay extends qw {
    @NotNull
    public final String baseUrl;
    @Nullable
    public final String fromScene;
    @Nullable
    public List<? extends Object> injectForwards;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HybridActionPay(@NotNull IBaseView iBaseView, @NotNull String str, @Nullable String str2) {
        super(iBaseView);
        Intrinsics.checkNotNullParameter(iBaseView, "baseView");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        this.baseUrl = str;
        this.fromScene = str2;
    }

    private final String addSuccessParams(String str, String str2) {
        Locale qw = fe.mmm.qw.when.qw.qw();
        Intrinsics.checkNotNullExpressionValue(qw, "getAppLocale()");
        StringBuilder sb = new StringBuilder();
        sb.append("?lang=");
        sb.append(qw.getLanguage());
        sb.append("&username=");
        fe.mmm.qw.qw.rg.qw qw2 = fe.mmm.qw.qw.qw.qw.qw();
        String str3 = null;
        sb.append(qw2 != null ? qw2.de() : null);
        sb.append("&avatar=");
        fe.mmm.qw.qw.rg.qw qw3 = fe.mmm.qw.qw.qw.qw.qw();
        if (qw3 != null) {
            str3 = qw3.fe();
        }
        sb.append(str3);
        sb.append("&order_no=");
        sb.append(str);
        sb.append("&successFrom=");
        sb.append(str2);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final void buyProduct(boolean z, String str, String str2, VipBuyViewModel vipBuyViewModel, ad adVar, boolean z2) {
        IBaseView iBaseView = this.mBaseView;
        VipBuyViewModel.buy$default(vipBuyViewModel, new VipSellerCodeReview(new WeakReference(iBaseView != null ? iBaseView.getActivity() : null), str, str2, z, "7", (Context) null, 32, (DefaultConstructorMarker) null), false, 2, (Object) null).observeForever(new fe.mmm.qw.k.pf.yj.qw(z2, this, adVar));
    }

    /* renamed from: buyProduct$lambda-2  reason: not valid java name */
    public static final void m944buyProduct$lambda2(boolean z, HybridActionPay hybridActionPay, ad adVar, fe.mmm.qw.k.yj.qw qwVar) {
        WebView webView;
        Intrinsics.checkNotNullParameter(hybridActionPay, "this$0");
        Intrinsics.checkNotNullParameter(adVar, "$param");
        JSONObject jSONObject = new JSONObject();
        fe.ggg.ad.qw.fe.qw.qw(jSONObject, "order_no", qwVar.ad());
        if (qwVar.fe()) {
            if (z) {
                fe.mmm.qw.ggg.qw.qw.qw("payment_login_and_pay_success_count", CollectionsKt__CollectionsJVMKt.listOf("cashier_desk"));
            }
            hybridActionPay.handleHybridCallback(adVar, 1, SmsLoginView.f.k, jSONObject);
            IWebViewListener iWebViewListener = hybridActionPay.mWebViewListener;
            if (iWebViewListener != null && (webView = iWebViewListener.getWebView()) != null) {
                webView.loadUrl(hybridActionPay.baseUrl + "/commercial/purchasesuccess" + hybridActionPay.addSuccessParams(qwVar.ad(), hybridActionPay.fromScene));
                return;
            }
            return;
        }
        hybridActionPay.handleHybridCallback(adVar, 0, qwVar.qw(), jSONObject);
    }

    private final void handleBuyProductAction(ad adVar) {
        String str;
        ViewModelStoreOwner viewModelStoreOwner;
        ad adVar2 = adVar;
        if (adVar2 != null) {
            JSONObject ad2 = fe.ggg.ad.qw.fe.qw.ad(adVar2.f8047fe);
            boolean optBoolean = ad2 != null ? ad2.optBoolean("can_auto_renew") : false;
            String optString = ad2 != null ? ad2.optString("product_id", "") : null;
            if (optString == null) {
                optString = "";
            }
            String optString2 = ad2 != null ? ad2.optString("third_product_id", "") : null;
            if (optString2 == null) {
                str = "";
            } else {
                str = optString2;
            }
            LoggerKt.d(adVar2, "handleBuyProductAction ");
            IBaseView iBaseView = this.mBaseView;
            if (iBaseView != null && (viewModelStoreOwner = iBaseView.getViewModelStoreOwner()) != null) {
                VipBuyViewModel vipBuyViewModel = (VipBuyViewModel) new ViewModelProvider(viewModelStoreOwner).get(VipBuyViewModel.class);
                if (vipBuyViewModel.needLogin()) {
                    FragmentActivity activity = this.mBaseView.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "mBaseView.activity");
                    rg.th(VipBuyViewModel.login$default(vipBuyViewModel, activity, (Fragment) null, "cashier_desk", 2, (Object) null), (LifecycleOwner) null, new HybridActionPay$handleBuyProductAction$1$1(this, optBoolean, optString, str, vipBuyViewModel, adVar), 1, (Object) null);
                    return;
                }
                buyProduct(optBoolean, optString, str, vipBuyViewModel, adVar, false);
            }
        }
    }

    private final void handleGetInternetAction(ad adVar) {
        if (adVar != null) {
            LoggerKt.d(adVar, "handleGetInternetAction ");
            JSONObject jSONObject = new JSONObject();
            if (fe.mmm.qw.ppp.qw.qw.qw() != null) {
                jSONObject.put("isInternet", i.rg(fe.mmm.qw.ppp.qw.qw.qw()));
            }
            handleHybridCallback(this.mHybridParam, 1, "", jSONObject);
        }
    }

    private final void handleGetMemberParamsAction(ad adVar) {
        if (adVar != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clienttype", RequestCommonParams.rg());
            jSONObject.put("channel", RequestCommonParams.fe());
            jSONObject.put("platform", 1);
            handleHybridCallback(this.mHybridParam, 1, "", jSONObject);
        }
    }

    private final void handleGoHomeAction(ad adVar) {
        FragmentActivity activity;
        if (adVar != null) {
            LoggerKt.d(adVar, "handleGoHomeAction ");
            fe.ad.qw.qw.ad.qw.de().qw("/home/main/activity").navigation();
            IBaseView iBaseView = this.mBaseView;
            if (iBaseView != null && (activity = iBaseView.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    public void callH5Function(@Nullable String str, int i2, @Nullable String str2, @Nullable JSONObject jSONObject) {
        super.callH5Function(str, i2, str2, jSONObject);
    }

    public void handleHybridCallback(@Nullable ad adVar, int i2, @Nullable String str, @Nullable JSONObject jSONObject) {
        super.handleHybridCallback(adVar, i2, str, jSONObject);
    }

    public void handleNewHybridCallback(@Nullable String str, int i2, @Nullable String str2, @Nullable JSONObject jSONObject) {
        super.handleNewHybridCallback(str, i2, str2, jSONObject);
    }

    public void handleRecognizeSchemeError(@Nullable ad adVar) {
        super.handleRecognizeSchemeError(adVar);
    }

    public void onAction(@Nullable ad adVar) {
        if (!isDestroy()) {
            this.mHybridParam = adVar;
            StringBuilder sb = new StringBuilder();
            sb.append("HybridActionForward param:");
            String str = null;
            sb.append(adVar != null ? adVar.f8047fe : null);
            sb.append(" FuncName=");
            sb.append(adVar != null ? adVar.f8046de : null);
            sb.append(" actions:");
            List<? extends Object> list = this.injectForwards;
            sb.append(list != null ? Integer.valueOf(list.size()) : null);
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
            if (adVar != null) {
                str = adVar.f8046de;
            }
            if (str != null) {
                switch (str.hashCode()) {
                    case -1646656329:
                        if (str.equals("getInternet")) {
                            handleGetInternetAction(adVar);
                            return;
                        }
                        break;
                    case -1315396727:
                        if (str.equals("buyProduct")) {
                            handleBuyProductAction(adVar);
                            return;
                        }
                        break;
                    case -1241398809:
                        if (str.equals("goHome")) {
                            handleGoHomeAction(adVar);
                            return;
                        }
                        break;
                    case 1135945526:
                        if (str.equals("getMemberParams")) {
                            handleGetMemberParamsAction(adVar);
                            return;
                        }
                        break;
                }
            }
            handleRecognizeSchemeError(adVar);
        }
    }
}
