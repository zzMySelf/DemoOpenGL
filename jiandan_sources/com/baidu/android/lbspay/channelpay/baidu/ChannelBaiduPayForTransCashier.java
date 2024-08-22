package com.baidu.android.lbspay.channelpay.baidu;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.android.pay.PayCallBack;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;

public class ChannelBaiduPayForTransCashier {
    public static final String TAG = "ChannelBaiduPayForTransCashier";

    public static class a {
        public static ChannelBaiduPayForTransCashier a = new ChannelBaiduPayForTransCashier();
    }

    public static ChannelBaiduPayForTransCashier getInstance() {
        return a.a;
    }

    private String getNotify(String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str3 : str.split(i.b)) {
                    if (str3.startsWith("notify")) {
                        str2 = gatValue(str3, "notify");
                    }
                }
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
        }
        return str2;
    }

    /* access modifiers changed from: private */
    public void handlepayResult(Context context, int i2, String str) {
        LBSOriginalPayBackManage instance = LBSOriginalPayBackManage.getInstance();
        instance.originalCallbackResult(PayChannelController.BAIFUBAO_PAYCHANNEL, i2 + "", str);
        if (i2 == 0) {
            paySuccess(context, str);
        } else if (i2 == 1) {
            paying(context);
        } else if (i2 == 2) {
            payCancel(context);
        }
    }

    private void paySuccess(Context context, String str) {
        LBSPayResult.payResult(context, 0, getNotify(str));
        StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, SmsLoginView.f.k);
    }

    public String gatValue(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.indexOf("}"));
    }

    public void pay(final Context context, String str, PrecashierCreateOrderResponse precashierCreateOrderResponse, CashierDataNew cashierDataNew) {
        if (!TextUtils.isEmpty(str) && precashierCreateOrderResponse != null) {
            String str2 = StatServiceEvent.LBS_TRANSPARENT_POLYMERPAY;
            StatisticManager.onEventWithValue(str2, cashierDataNew.getCustomId() + "|" + cashierDataNew.getOrderNo());
            Context context2 = context;
            String str3 = str;
            BaiduPayDelegate.getInstance().doPrecashierPay(context2, str3, new PayCallBack() {
                public boolean isHideLoadingDialog() {
                    return false;
                }

                public void onPayResult(int i2, String str) {
                    ChannelBaiduPayForTransCashier.this.handlepayResult(context, i2, str);
                }
            }, new HashMap(), precashierCreateOrderResponse, (IModifyPayTypeCallback) null);
        }
    }

    public void payCancel(Context context) {
        if (context != null) {
            LBSPayResult.payResult(context, 2, "");
            StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "canncel");
        }
    }

    public void paying(Context context) {
        LBSPayResult.payResult(context, 1, "");
        StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "paying");
    }

    public ChannelBaiduPayForTransCashier() {
    }
}
