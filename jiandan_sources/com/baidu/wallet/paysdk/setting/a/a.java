package com.baidu.wallet.paysdk.setting.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class a {
    public Context a;
    public String b;
    public PayCallBack c;
    public Map<String, String> d;
    public String e;
    public H5LifeCycleCallback f = null;
    public String g = null;

    public a(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        this.a = context;
        this.b = str;
        this.c = payCallBack;
        this.d = map;
        this.e = StatHelper.getOrderNo(str);
        this.g = StatHelper.getPureSign(this.b);
        PayDataCache.getInstance().setOrderNo(this.e);
        PayDataCache.getInstance().registerEventBus();
    }

    public void a() {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(StatHelper.getProcesssId());
        arrayList.add(this.e);
        if ("0".equals(this.g)) {
            arrayList.add("1");
        } else if ("1".equals(this.g)) {
            arrayList.add("2");
        } else {
            arrayList.add("0");
        }
        StatisticManager.onEventWithValues(PayStatServiceEvent.START_H5_CASHIER_DESK, arrayList);
        String c2 = c();
        if (this.a != null && !TextUtils.isEmpty(c2)) {
            Bundle bundle = new Bundle();
            if (this.f == null) {
                AnonymousClass1 r2 = new H5LifeCycleCallback() {
                    public void onActivityDestroyed(Activity activity) {
                        pop();
                        a.this.b();
                    }
                };
                this.f = r2;
                r2.push();
            }
            bundle.putParcelable("lifecycleLsnr", this.f);
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", c2);
            BaiduWalletDelegate.getInstance().openH5Module(this.a, bundle);
        } else if (this.c != null) {
            String str2 = "IllegalArgument:";
            if (this.a == null) {
                str2 = str2 + "context is null ";
            }
            if (TextUtils.isEmpty(c2)) {
                str = str2 + "orderInfo is empty ";
            } else {
                str = str2 + "orderInfo = " + StatHelper.getOrderNo(this.b);
            }
            a(2, a(2, str), "1");
        }
    }

    public void b() {
        String str;
        HashMap<String, String> h5PayResult = PayDataCache.getInstance().getH5PayResult(this.e);
        String str2 = "";
        if (h5PayResult != null) {
            str2 = h5PayResult.get("pay_result");
            str = h5PayResult.get("notify");
        } else {
            str = str2;
        }
        if ("0".equals(str2)) {
            a(0, a(0, str), "0");
        } else {
            a(2, a(2, str), "1");
        }
        PayDataCache.getInstance().removeH5PayResult(this.e);
        PayBaseBeanActivity.exitEbpay();
    }

    public String c() {
        String str;
        String str2;
        if (BaiduPay.PAY_FROM_HUA_FEI.equals(this.d.get("pay_from"))) {
            str = SdkInitResponse.getInstance().getH5ChargeUrl(this.a);
            if (TextUtils.isEmpty(str)) {
                str = DxmPayBeanConstants.API_PAY_H5_CHARGE_URL;
            }
        } else if (!TextUtils.isEmpty(this.g)) {
            if ("0".equals(this.g)) {
                str2 = SdkInitResponse.getInstance().getPayAuthSignUrl(this.a);
                if (TextUtils.isEmpty(str2)) {
                    str2 = DxmPayBeanConstants.API_PAY_AUTH_SIGN_URL;
                }
            } else {
                str2 = SdkInitResponse.getInstance().getAuthSignUrl(this.a);
                if (TextUtils.isEmpty(str2)) {
                    str2 = DxmPayBeanConstants.API_AUTH_SIGN_URL;
                }
            }
            return str2 + com.alipay.sdk.m.s.a.n + this.b;
        } else {
            str = SdkInitResponse.getInstance().getH5CashierUrl(this.a);
            if (TextUtils.isEmpty(str)) {
                str = DxmPayBeanConstants.API_PAY_H5_CASHIER_URL;
            }
        }
        String a2 = com.baidu.wallet.paysdk.setting.a.a().a(this.a);
        return str + com.alipay.sdk.m.s.a.n + this.b + "&is_big_word=" + a2;
    }

    public void a(int i2, String str, String str2) {
        PayCallBack payCallBack = this.c;
        if (payCallBack != null) {
            payCallBack.onPayResult(i2, str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(StatHelper.getProcesssId());
        arrayList.add(this.e);
        arrayList.add(str2);
        if ("0".equals(this.g)) {
            arrayList.add("1");
        } else if ("1".equals(this.g)) {
            arrayList.add("2");
        } else {
            arrayList.add("0");
        }
        StatisticManager.onEventWithValues(PayStatServiceEvent.H5_CASHIER_DESK_RESULT, arrayList);
    }

    public String a(int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("statecode={");
        stringBuffer.append(i2);
        stringBuffer.append("};");
        String str2 = this.e;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        stringBuffer.append("order_no={");
        stringBuffer.append(str2);
        stringBuffer.append("};");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        stringBuffer.append("notify={");
        stringBuffer.append(str);
        stringBuffer.append("};");
        return stringBuffer.toString();
    }
}
