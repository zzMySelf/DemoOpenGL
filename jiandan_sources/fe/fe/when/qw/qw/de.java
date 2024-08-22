package fe.fe.when.qw.qw;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.baidu.aiscan.R;
import com.baidu.netdisk.trade.pay.order.IPayResult;
import com.baidu.netdisk.trade.pay.order._;
import com.baidu.netdisk.trade.pay.order.model.Purchase;
import com.baidu.netdisk.trade.pay.order.view.LoadingDialog;
import com.mars.kotlin.extension.Tag;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import fe.fe.when.qw.qw.yj.ad;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("MarsPaySdk")
public final class de {
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        r4 = r7._();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void rg(com.baidu.netdisk.trade.pay.order.view.LoadingDialog r2, com.baidu.netdisk.trade.pay.order.IPayResult r3, fe.fe.when.qw.qw.de r4, androidx.fragment.app.FragmentActivity r5, java.lang.String r6, com.baidu.netdisk.trade.pay.order.model.Purchase r7) {
        /*
            java.lang.String r0 = "$waitResultDialog"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "$payResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = "$activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            java.lang.String r4 = "$param"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)
            boolean r4 = r2.isShowing()
            if (r4 == 0) goto L_0x0022
            r2.dismiss()
        L_0x0022:
            r2 = 0
            if (r7 == 0) goto L_0x0030
            java.util.Map r4 = r7._()
            if (r4 == 0) goto L_0x0030
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.toMap(r4)
            goto L_0x0031
        L_0x0030:
            r4 = r2
        L_0x0031:
            if (r4 == 0) goto L_0x0040
            java.lang.String r0 = "orderId"
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r2 = r0
            goto L_0x004a
        L_0x0040:
            if (r4 == 0) goto L_0x004a
            java.lang.String r2 = "order_no"
            java.lang.Object r2 = r4.get(r2)
            java.lang.String r2 = (java.lang.String) r2
        L_0x004a:
            if (r7 == 0) goto L_0x00a5
            r4 = 0
            r0 = 1
            if (r2 == 0) goto L_0x0059
            int r1 = r2.length()
            if (r1 != 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r1 = 0
            goto L_0x005a
        L_0x0059:
            r1 = 1
        L_0x005a:
            if (r1 != 0) goto L_0x00a5
            java.util.Map r1 = r7._()
            if (r1 == 0) goto L_0x0068
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0069
        L_0x0068:
            r4 = 1
        L_0x0069:
            if (r4 == 0) goto L_0x006c
            goto L_0x00a5
        L_0x006c:
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0089 }
            com.dxmpay.wallet.api.BaiduWalletDelegate r4 = com.dxmpay.wallet.api.BaiduWalletDelegate.getInstance()     // Catch:{ all -> 0x0089 }
            android.content.Context r4 = r4.getAppContext()     // Catch:{ all -> 0x0089 }
            if (r4 != 0) goto L_0x0083
            com.dxmpay.wallet.api.BaiduWalletDelegate r4 = com.dxmpay.wallet.api.BaiduWalletDelegate.getInstance()     // Catch:{ all -> 0x0089 }
            android.content.Context r0 = r5.getApplicationContext()     // Catch:{ all -> 0x0089 }
            r4.setAppContext(r0)     // Catch:{ all -> 0x0089 }
        L_0x0083:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0089 }
            kotlin.Result.m1155constructorimpl(r4)     // Catch:{ all -> 0x0089 }
            goto L_0x0093
        L_0x0089:
            r4 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            kotlin.Result.m1155constructorimpl(r4)
        L_0x0093:
            com.baidu.netdisk.trade.pay.order._ r4 = new com.baidu.netdisk.trade.pay.order._
            r4.<init>()
            androidx.lifecycle.LiveData r4 = r4.qw(r5, r7)
            fe.fe.when.qw.qw.qw r7 = new fe.fe.when.qw.qw.qw
            r7.<init>(r3, r6, r2)
            r4.observe(r5, r7)
            return
        L_0x00a5:
            fe.fe.when.qw.qw.yj.ad$qw r2 = fe.fe.when.qw.qw.yj.ad.f3192ad
            fe.fe.when.qw.qw.yj.ad r2 = r2.qw()
            r3.actionResult(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.when.qw.qw.de.rg(com.baidu.netdisk.trade.pay.order.view.LoadingDialog, com.baidu.netdisk.trade.pay.order.IPayResult, fe.fe.when.qw.qw.de, androidx.fragment.app.FragmentActivity, java.lang.String, com.baidu.netdisk.trade.pay.order.model.Purchase):void");
    }

    public static final void th(IPayResult iPayResult, String str, String str2, ad adVar) {
        String str3;
        Intrinsics.checkNotNullParameter(iPayResult, "$payResult");
        Intrinsics.checkNotNullParameter(str, "$param");
        Intrinsics.checkNotNullExpressionValue(adVar, "it");
        iPayResult.actionResult(adVar);
        if (adVar.fe()) {
            String qw = fe.fe.when.qw.qw.fe.ad.qw(str, "return_url");
            if (qw == null || (str3 = fe.fe.when.qw.qw.fe.ad.ad(qw, "order_no", str2)) == null) {
                str3 = "";
            }
            iPayResult.openResultPage(str3, str2);
        }
    }

    public final void ad(@NotNull Context context, @Nullable BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(context, "context");
        new rg().yj(context, baseResp);
    }

    public final void de(@NotNull Context context, @Nullable String str, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        new rg().rg(context, str, function0);
    }

    public final void fe(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull IPayResult iPayResult) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "param");
        Intrinsics.checkNotNullParameter(iPayResult, "payResult");
        if (str.length() == 0) {
            iPayResult.actionResult(ad.f3192ad.qw());
            return;
        }
        LiveData<Purchase> ad2 = new _().ad(fe.fe.when.qw.qw.fe.ad.fe(str));
        LoadingDialog loadingDialog = new LoadingDialog(fragmentActivity);
        loadingDialog.show(R.string.vip_getting_order);
        ad2.observe(fragmentActivity, new ad(loadingDialog, iPayResult, this, fragmentActivity, str));
    }

    public final void qw(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        new rg().th(context, intent);
    }
}
