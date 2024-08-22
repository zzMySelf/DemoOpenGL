package com.tera.scan.vip.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.service.Result;
import com.mars.united.international.pay.PayMessage;
import com.mars.united.international.pay.PayProxy;
import com.tera.scan.vip.VipInfoManager;
import com.tera.scan.vip.network.VipManager;
import com.tera.scan.vip.network.model.PreCreateOrderData;
import com.tera.scan.vip.network.model.PreCreateOrderResponse;
import fe.de.qw.qw.Cif;
import fe.de.qw.qw.o;
import fe.ggg.ad.ad.qw.de;
import fe.ggg.ad.qw.de.th.rg;
import fe.mmm.qw.k.p027if.ad;
import fe.mmm.qw.k.yj.qw;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0016\u0010#\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/tera/scan/vip/util/VipSellerCodeReview;", "", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "serverProductId", "", "googleProductId", "isSubs", "", "from", "context", "Landroid/content/Context;", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Landroid/content/Context;)V", "getActivity", "()Ljava/lang/ref/WeakReference;", "buyResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tera/scan/vip/model/VipBuyResult;", "getContext", "()Landroid/content/Context;", "getFrom", "()Ljava/lang/String;", "launchBuyStartTime", "", "buy", "Landroidx/lifecycle/LiveData;", "handleGoogleResult", "", "msg", "Lcom/mars/united/international/pay/PayMessage;", "serverOrderId", "handleServerResult", "serverCode", "", "launchBuy", "uk", "reportToken", "payMessage", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("VipSellerCodeReview")
public final class VipSellerCodeReview {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f7471ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f7472de;

    /* renamed from: fe  reason: collision with root package name */
    public final boolean f7473fe;
    @NotNull
    public final WeakReference<Activity> qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final String f7474rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final Context f7475th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final MutableLiveData<qw> f7476yj;

    public VipSellerCodeReview(@NotNull WeakReference<Activity> weakReference, @NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(weakReference, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "serverProductId");
        Intrinsics.checkNotNullParameter(str2, "googleProductId");
        Intrinsics.checkNotNullParameter(str3, "from");
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = weakReference;
        this.f7471ad = str;
        this.f7472de = str2;
        this.f7473fe = z;
        this.f7474rg = str3;
        this.f7475th = context;
        this.f7476yj = new MutableLiveData<>();
    }

    public static final void de(VipSellerCodeReview vipSellerCodeReview, Result result) {
        String str;
        PreCreateOrderData data;
        String uk2;
        PreCreateOrderData data2;
        Intrinsics.checkNotNullParameter(vipSellerCodeReview, "this$0");
        int i2 = 804;
        String str2 = "";
        if (result instanceof Result.Success) {
            PreCreateOrderResponse preCreateOrderResponse = (PreCreateOrderResponse) result.getData();
            if (preCreateOrderResponse == null || (data2 = preCreateOrderResponse.getData()) == null || (str = data2.getOrderNo()) == null) {
                str = str2;
            }
            PreCreateOrderResponse preCreateOrderResponse2 = (PreCreateOrderResponse) result.getData();
            if (!(preCreateOrderResponse2 == null || (data = preCreateOrderResponse2.getData()) == null || (uk2 = data.getUk()) == null)) {
                str2 = uk2;
            }
            if (StringsKt__StringsJVMKt.isBlank(str) || StringsKt__StringsJVMKt.isBlank(str2)) {
                vipSellerCodeReview.th(804, str);
            } else {
                vipSellerCodeReview.yj(str, str2);
            }
        } else if (result instanceof Result.ServerError) {
            Integer errorNumber = result.getErrorNumber();
            if (errorNumber != null) {
                i2 = errorNumber.intValue();
            }
            vipSellerCodeReview.th(i2, str2);
        } else {
            Integer errorNumber2 = result.getErrorNumber();
            vipSellerCodeReview.th(errorNumber2 != null ? errorNumber2.intValue() : 805, str2);
        }
    }

    public static final void i(VipSellerCodeReview vipSellerCodeReview, Cif ifVar, String str, Result result) {
        String str2;
        Intrinsics.checkNotNullParameter(vipSellerCodeReview, "this$0");
        Intrinsics.checkNotNullParameter(str, "$serverOrderId");
        if (result instanceof Result.Success) {
            LoggerKt.d$default("上报凭证成功", (Object) null, 1, (Object) null);
            if (!vipSellerCodeReview.f7473fe) {
                if (ifVar == null || (str2 = ifVar.th()) == null) {
                    str2 = "";
                }
                new PayProxy(vipSellerCodeReview.f7475th).ad(CollectionsKt__CollectionsJVMKt.listOf(str2), VipSellerCodeReview$reportToken$1$1.INSTANCE);
            }
            VipInfoManager.o(VipInfoManager.qw, vipSellerCodeReview.f7475th, 0, 0, 6, (Object) null);
            MutableLiveData<qw> mutableLiveData = vipSellerCodeReview.f7476yj;
            String string = vipSellerCodeReview.f7475th.getString(R.string.vip_pay_success);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.vip_pay_success)");
            mutableLiveData.postValue(new qw(801, string, str));
            return;
        }
        int i2 = 805;
        if (result instanceof Result.NetworkError) {
            vipSellerCodeReview.th(805, str);
        } else if (result instanceof Result.ServerError) {
            Integer errorNumber = result.getErrorNumber();
            vipSellerCodeReview.th(errorNumber != null ? errorNumber.intValue() : 804, str);
        } else {
            Integer errorNumber2 = result.getErrorNumber();
            if (errorNumber2 != null) {
                i2 = errorNumber2.intValue();
            }
            vipSellerCodeReview.th(i2, str);
        }
    }

    @NotNull
    public final LiveData<qw> ad() {
        new VipManager(this.f7475th).ad(this.f7471ad, this.f7474rg).observeForever(new ad(this));
        return this.f7476yj;
    }

    @NotNull
    public final WeakReference<Activity> fe() {
        return this.qw;
    }

    public final void rg(PayMessage payMessage, String str) {
        qw qwVar;
        int code = payMessage.getCode();
        if (code == -2) {
            String string = this.f7475th.getString(R.string.vip_pay_not_support);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.vip_pay_not_support)");
            qwVar = new qw(807, string, str);
        } else if (code == -1) {
            String string2 = this.f7475th.getString(R.string.vip_pay_connected_error);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri….vip_pay_connected_error)");
            qwVar = new qw(806, string2, str);
        } else if (code == 0) {
            qwVar = new qw(801, "", str);
        } else if (code == 1) {
            String string3 = this.f7475th.getString(R.string.vip_pay_cancel);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.vip_pay_cancel)");
            qwVar = new qw(802, string3, str);
        } else if (code == 7) {
            String string4 = this.f7475th.getString(R.string.vip_pay_already_owned);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.vip_pay_already_owned)");
            qwVar = new qw(803, string4, str);
        } else if (code != 1801) {
            String string5 = this.f7475th.getString(R.string.vip_pay_not_support);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.vip_pay_not_support)");
            qwVar = new qw(807, string5, str);
        } else {
            String string6 = this.f7475th.getString(R.string.vip_pay_null_product);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.string.vip_pay_null_product)");
            qwVar = new qw(100004, string6, str);
        }
        if (qwVar.fe()) {
            this.f7476yj.postValue(new qw(CustomerServiceMenu.WITHDRAW_RECORD, "", str));
            uk(payMessage, str);
            return;
        }
        this.f7476yj.postValue(qwVar);
    }

    public final void th(int i2, String str) {
        qw qwVar;
        switch (i2) {
            case 804:
                String string = this.f7475th.getString(R.string.internal_server_error);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.internal_server_error)");
                qwVar = new qw(804, string, str);
                break;
            case 805:
                String string2 = this.f7475th.getString(R.string.network_exception_message);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…etwork_exception_message)");
                qwVar = new qw(805, string2, str);
                break;
            case 809:
                String string3 = this.f7475th.getString(R.string.error_busy_info);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.error_busy_info)");
                qwVar = new qw(809, string3, str);
                break;
            case 39513:
                String string4 = this.f7475th.getString(R.string.vip_pay_vip_max_limit);
                Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.vip_pay_vip_max_limit)");
                qwVar = new qw(39513, string4, str);
                break;
            case 46032:
                String string5 = this.f7475th.getString(R.string.server_google_network_exception_message);
                Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…etwork_exception_message)");
                qwVar = new qw(804, string5, str);
                break;
            case 46033:
                String string6 = this.f7475th.getString(R.string.google_pay_token_error);
                Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.string.google_pay_token_error)");
                qwVar = new qw(804, string6, str);
                break;
            default:
                String string7 = this.f7475th.getString(R.string.internal_server_error);
                Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.string.internal_server_error)");
                qwVar = new qw(804, string7, str);
                break;
        }
        this.f7476yj.postValue(qwVar);
    }

    public final void uk(PayMessage payMessage, String str) {
        Object obj;
        String str2;
        String str3;
        String str4;
        String th2;
        List<String> fe2;
        String str5;
        String ad2;
        Cif ifVar = null;
        try {
            Result.Companion companion = kotlin.Result.Companion;
            PackageInfo packageInfo = this.f7475th.getPackageManager().getPackageInfo(this.f7475th.getPackageName(), 64);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…geManager.GET_SIGNATURES)");
            Signature[] signatureArr = packageInfo.signatures;
            Intrinsics.checkNotNullExpressionValue(signatureArr, "signatures");
            String charsString = signatureArr.length > 0 ? signatureArr[0].toCharsString() : null;
            String originalJson = payMessage.getOriginalJson();
            if (originalJson == null) {
                originalJson = "";
            }
            if (charsString == null) {
                charsString = "";
            }
            obj = kotlin.Result.m1155constructorimpl(new Cif(originalJson, charsString));
        } catch (Throwable th3) {
            Result.Companion companion2 = kotlin.Result.Companion;
            obj = kotlin.Result.m1155constructorimpl(ResultKt.createFailure(th3));
        }
        if (!kotlin.Result.m1161isFailureimpl(obj)) {
            ifVar = obj;
        }
        Cif ifVar2 = ifVar;
        VipManager vipManager = new VipManager(this.f7475th);
        if (ifVar2 == null || (ad2 = ifVar2.ad()) == null) {
            str2 = "";
        } else {
            str2 = ad2;
        }
        String packageName = this.f7475th.getPackageName();
        if (ifVar2 == null || (fe2 = ifVar2.fe()) == null || (str5 = (String) CollectionsKt___CollectionsKt.getOrNull(fe2, 0)) == null) {
            str3 = "";
        } else {
            str3 = str5;
        }
        if (ifVar2 == null || (th2 = ifVar2.th()) == null) {
            str4 = "";
        } else {
            str4 = th2;
        }
        vipManager.de(str2, packageName, str3, str4, this.f7473fe).observeForever(new fe.mmm.qw.k.p027if.qw(this, ifVar2, str));
    }

    public final void yj(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "serverOrderId");
        Intrinsics.checkNotNullParameter(str2, "uk");
        de deVar = new de(this.qw, str2, this.f7472de, str, this.f7473fe);
        System.currentTimeMillis();
        rg.th(new PayProxy(this.f7475th).fe(deVar, (o) null), (LifecycleOwner) null, new VipSellerCodeReview$launchBuy$1(this, str), 1, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VipSellerCodeReview(java.lang.ref.WeakReference r8, java.lang.String r9, java.lang.String r10, boolean r11, java.lang.String r12, android.content.Context r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r14 = r14 & 32
            if (r14 == 0) goto L_0x000d
            android.content.Context r13 = com.tera.scan.framework.kernel.BaseApplication.getInstance()
            java.lang.String r14 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
        L_0x000d:
            r6 = r13
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.vip.util.VipSellerCodeReview.<init>(java.lang.ref.WeakReference, java.lang.String, java.lang.String, boolean, java.lang.String, android.content.Context, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
