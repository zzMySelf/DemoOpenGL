package com.baidu.android.lbspay.channelpay.baidu;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.activity.LBSTransCashierActivity;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ChannelBaiduPay extends AbstractChannelPay {
    public static final String TAG = "ChannelBaiduPay";
    public CashierDataNew mOrderInfo;
    public WeakReference<Activity> mWeakReference;

    public String gatValue(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.indexOf("}"));
    }

    public int getChannelId() {
        return 126;
    }

    public String getNotify(String str) {
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

    public void handlepayResult(int i2, String str) {
        CashierDataNew cashierDataNew;
        LBSOriginalPayBackManage instance = LBSOriginalPayBackManage.getInstance();
        instance.originalCallbackResult(PayChannelController.BAIFUBAO_PAYCHANNEL, i2 + "", str);
        if (i2 == 0) {
            paySuccess(getNotify(str));
        } else if (i2 != 1) {
            payCancel();
            WeakReference<Activity> weakReference = this.mWeakReference;
            Activity activity = weakReference == null ? null : (Activity) weakReference.get();
            if (activity != null && (cashierDataNew = this.mOrderInfo) != null && cashierDataNew.isShowAllPayType()) {
                Intent intent = new Intent(activity, LBSTransCashierActivity.class);
                intent.setFlags(268435456);
                intent.putExtra(CashierDataNew.DELIVERY_CASHIER_DATA, this.mOrderInfo);
                activity.startActivity(intent);
            }
        } else {
            paying();
        }
    }

    public void pay(Activity activity, GetPayContent getPayContent) {
        String str;
        this.mWeakReference = new WeakReference<>(activity);
        if (getPayContent != null) {
            this.mOrderInfo = getPayContent.extraOrderInfo;
        }
        super.pay(activity, getPayContent);
        boolean z = true;
        if (getPayContent != null && getPayContent.checkResponseValidity()) {
            HashMap hashMap = new HashMap();
            PayDataBean payData = getPayData(getPayContent);
            if (payData != null) {
                String str2 = payData.params;
                if (payData.isBaifubaoAuthPay()) {
                    hashMap.put("pay_from", BaiduPay.PAY_FROM_AUTHORIZE);
                }
                str = str2;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                StatHelper.cachePayFrom("2");
                PrecashierCreateOrderResponse precashierCreateOrderResponse = getPayContent.sdk_info;
                if (precashierCreateOrderResponse == null) {
                    StatisticManager.onEventWithValue(StatServiceEvent.LBS_PREPAY_RESULET, "0");
                    BaiduPayDelegate.getInstance().doPay(activity, str, new PayCallBack() {
                        public boolean isHideLoadingDialog() {
                            return false;
                        }

                        public void onPayResult(int i2, String str) {
                            ChannelBaiduPay.this.handlepayResult(i2, str);
                        }
                    }, hashMap);
                } else if (TextUtils.isEmpty(precashierCreateOrderResponse.ret) || !getPayContent.sdk_info.ret.equals(String.valueOf(5003))) {
                    StatisticManager.onEventWithValue(StatServiceEvent.LBS_PREPAY_RESULET, "1");
                    BaiduPayDelegate.getInstance().doPrecashierPay(activity, str, new PayCallBack() {
                        public boolean isHideLoadingDialog() {
                            return false;
                        }

                        public void onPayResult(int i2, String str) {
                            ChannelBaiduPay.this.handlepayResult(i2, str);
                        }
                    }, hashMap, getPayContent.sdk_info, (IModifyPayTypeCallback) null);
                } else {
                    AccountManager.getInstance(activity).logout();
                    WalletLoginHelper.getInstance().logout(false);
                    WalletLoginHelper.getInstance().handlerWalletError(5003);
                    if (!TextUtils.isEmpty(getPayContent.sdk_info.msg)) {
                        GlobalUtils.toast(activity, getPayContent.sdk_info.msg);
                    }
                }
                z = false;
            }
        }
        if (z && this.mNotifyOnError) {
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.BAIFUBAO_PAYCHANNEL, "2", "");
            payCancel();
        }
    }
}
