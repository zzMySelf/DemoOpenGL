package com.baidu.wallet.paysdk.banksign;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.banksign.a.a;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.j;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.PostWebviewActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;

public class b implements a {
    public void a(Context context) {
        BaiduPayDelegate.getInstance().reOrderPay(context);
    }

    public void b(Context context) {
        if (context != null) {
            String j = a.a().j();
            byte[] l = a.a().l();
            String k = a.a().k();
            if (TextUtils.isEmpty(k)) {
                k = ResUtils.getString(context, "dxmpay_banksign_web_title");
            }
            StatisticManager.onEvent("enterBankSign");
            PostWebviewActivity.startPostWebview(context, j, l, k);
        }
    }

    public void c(Context context) {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            j f = a.a().f();
            PayTypeActivity e = a.a().e();
            if (f != null) {
                f.f();
                a.a().a((j) null);
            } else if (e != null) {
                e.jumpPwdPayActivity();
                e.finishWithoutAnim();
                a.a().a((PayTypeActivity) null);
            } else if (a.a().d() && context != null && (context instanceof PayBaseActivity)) {
                ((PayBaseActivity) context).continuePay(true);
                a.a().a(false);
            }
        } else {
            OrderConfirmActivity c = a.a().c();
            if (c != null) {
                c.pay(a.a().i(), a.a().h(), true);
                a.a().a((OrderConfirmActivity) null);
            }
        }
    }

    public void d(Context context) {
        if (context != null && (context instanceof BusinessSignedGuideActivity)) {
            ((BusinessSignedGuideActivity) context).bindcard();
        }
    }

    public void e(Context context) {
        if (context != null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                payRequest.clearMktSolution();
            }
            PayController.getInstance().gotoPayTypePage(context, true);
        }
    }

    public void f(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, BusinessSignedGuideActivity.class);
            intent.putExtra("isActiveSign", a.a().g());
            context.startActivity(intent);
        }
    }
}
