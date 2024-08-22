package com.baidu.wallet.paysdk.payresult.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.aa;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.NetworkBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CashierDeskPayResult extends H5PayResultProcess implements NoProguard {
    public String a;
    public H5LifeCycleCallback b = null;

    public enum PayScenario {
        BankcardPay,
        BalancedPay
    }

    public CashierDeskPayResult(Context context, H5ResultParams h5ResultParams) {
        this.mContext = context;
        this.mH5 = h5ResultParams;
    }

    private String a() {
        H5ResultParams h5ResultParams;
        List<RestNameValuePair> list;
        if (this.mContext == null || (h5ResultParams = this.mH5) == null || TextUtils.isEmpty(h5ResultParams.pay_result_url)) {
            return null;
        }
        if (PayScenario.BalancedPay == this.mH5.pay_scenario) {
            list = c();
        } else {
            list = b();
        }
        if (list == null) {
            return null;
        }
        if (!TextUtils.isEmpty(this.mH5.pay_result_params)) {
            String[] split = this.mH5.pay_result_params.split(a.n);
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                list.add(new RestNameValuePair(split3[0], split3[1]));
            }
        }
        list.add(new RestNameValuePair("session_id", NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null)));
        String processedParams = H5PayResultProcess.getProcessedParams(list, "UTF-8");
        if (TextUtils.isEmpty(processedParams)) {
            return null;
        }
        return this.mH5.pay_result_url + "?is_from_sdk=1&result_type=cashdesk&order_query=" + processedParams;
    }

    private List<RestNameValuePair> b() {
        aa aaVar = (aa) PayBeanFactory.getInstance().getBean(this.mContext, 12, "CashierDeskPayResult");
        List<RestNameValuePair> generateRequestParam = aaVar.generateRequestParam();
        BeanManager.getInstance().removeBean(aaVar);
        if (generateRequestParam != null) {
            Iterator<RestNameValuePair> it = generateRequestParam.iterator();
            boolean z = false;
            while (!z && it.hasNext()) {
                RestNameValuePair next = it.next();
                if (next != null && "sign".equals(next.getName())) {
                    it.remove();
                    z = true;
                }
            }
        }
        return generateRequestParam;
    }

    private List<RestNameValuePair> c() {
        PayResultContent payStateContent = PayDataCache.getInstance().getPayStateContent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("session_id", NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null)));
        arrayList.add(new RestNameValuePair("name", "get_balance_pay_trans_state"));
        arrayList.add(new RestNameValuePair("order_no", payStateContent.order_no));
        return arrayList;
    }

    public void afterShow() {
        String str;
        PayDataCache.getInstance().setH5ResultParams((H5ResultParams) null);
        if (this.mContext != null) {
            PayResultContent payStateContent = PayDataCache.getInstance().getPayStateContent();
            if (payStateContent == null) {
                str = "";
            } else {
                str = payStateContent.notify;
            }
            PayCallBackManager.callBackClientSuccess(this.mContext, str);
            PayDataCache.getInstance().setPayReslutContent((PayResultContent) null);
        }
    }

    public void beforeShow() {
    }

    public void show() {
        this.a = a();
        PayRequestCache.getInstance().removeBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (this.a == null) {
            afterShow();
            return;
        }
        if (this.b == null) {
            AnonymousClass1 r0 = new H5LifeCycleCallback() {
                public void onActivityDestroyed(Activity activity) {
                    pop();
                    CashierDeskPayResult.this.afterShow();
                }
            };
            this.b = r0;
            r0.push();
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("with_anim", false);
        bundle.putBoolean("show_share", false);
        bundle.putString("url", this.a);
        bundle.putParcelable("lifecycleLsnr", this.b);
        BaiduWalletDelegate.getInstance().openH5Module(this.mContext, bundle);
        PayBaseBeanActivity.exitEbpay();
    }
}
