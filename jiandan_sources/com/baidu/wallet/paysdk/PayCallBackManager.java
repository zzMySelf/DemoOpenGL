package com.baidu.wallet.paysdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.Map;

public final class PayCallBackManager implements NoProguard {
    public static final String PAY_FAIL_MSG = "支付失败";
    public static final String PAY_SUCCESS_MSG = "支付成功";
    public static final String PRE_HASH_ID = "paySDKPercashierPayResult";
    public static final String PRE_HASH_NAME = "前置收银台支付结果";
    public static final String STD_HASH_ID = "paySDKStdPayResult";
    public static final String STD_HASH_NAME = "标准收银台支付结果";
    public static boolean isClientDead = false;

    public static class PayStateModle implements Serializable {
        public static final int PAY_STATUS_CANCEL = 2;
        public static final int PAY_STATUS_CHARGE_SUCCESS_REPAYMENT_FAIL = 3;
        public static final int PAY_STATUS_CLEAR = 1000;
        public static final int PAY_STATUS_PAYING = 1;
        public static final int PAY_STATUS_PLACE_ORDER_FAIL = 5;
        public static final int PAY_STATUS_PLACE_ORDER_SUCCESS = 4;
        public static final int PAY_STATUS_SUCCESS = 0;
        public static final long serialVersionUID = 393136306694361260L;
        public String mNotify;
        public String mOrder_no;
        public int mStatecode;

        public PayStateModle(int i2, String str) {
            this.mStatecode = i2;
            this.mNotify = str;
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                this.mOrder_no = payRequest.mOrderNo;
            } else {
                reviseOrderByNotify();
            }
        }

        private void reviseOrderByNotify() {
            String[] split;
            if (TextUtils.isEmpty(this.mOrder_no) && !TextUtils.isEmpty(this.mNotify) && (split = this.mNotify.split(a.n)) != null && split.length > 0) {
                for (String str : split) {
                    if (str != null) {
                        String trim = str.trim();
                        if (trim.toLowerCase().startsWith("order_no")) {
                            String[] split2 = trim.split("\\s*=\\s*");
                            if (split2 != null && 2 == split2.length) {
                                this.mOrder_no = split2[1];
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("statecode={");
            stringBuffer.append(this.mStatecode);
            stringBuffer.append("};");
            if (TextUtils.isEmpty(this.mOrder_no)) {
                this.mOrder_no = "";
            }
            stringBuffer.append("order_no={");
            stringBuffer.append(this.mOrder_no);
            stringBuffer.append("};");
            if (TextUtils.isEmpty(this.mNotify)) {
                this.mNotify = "";
            }
            stringBuffer.append("notify={");
            stringBuffer.append(this.mNotify);
            stringBuffer.append("};");
            return stringBuffer.toString();
        }
    }

    public static void a(Context context, int i2, String str) {
        PayCallBack payBack = BaiduPay.getInstance().getPayBack();
        if (payBack != null) {
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_DURATION, (Map<String, Object>) null, new String[0]);
            try {
                payBack.onPayResult(i2, str);
            } catch (Exception e) {
                LogUtil.e("PayCallBackManager", e.getMessage(), e);
            }
        } else {
            BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
            if (bindCallback != null) {
                if (i2 == 0) {
                    bindCallback.onChangeSucceed(str);
                } else {
                    bindCallback.onChangeFailed(str);
                }
                BaiduPay.getInstance().clearBindCallback();
            } else {
                BindBack bindCallbackExt = BaiduPay.getInstance().getBindCallbackExt();
                if (bindCallbackExt != null) {
                    try {
                        StatisticManager.onEvent("#onPayResult");
                        bindCallbackExt.onBindResult(i2, str);
                    } catch (Exception e2) {
                        LogUtil.e("PayCallBackManager", e2.getMessage(), e2);
                    }
                }
            }
        }
        if (PayDataCache.getInstance().isRemotePay()) {
            if (BaiduPay.getInstance().getRemotePayContext() != null) {
                if (i2 != 1000) {
                    try {
                        b(BaiduPay.getInstance().getRemotePayContext(), i2, str);
                    } catch (Exception e3) {
                        LogUtil.e("PayCallBackManager", e3.getMessage(), e3);
                        StatisticManager.onEventWithValue("remoteGobackToRemotePayCatch", e3.getMessage());
                    } catch (Throwable th2) {
                        BaiduPay.getInstance().resetRemotePayContext();
                        throw th2;
                    }
                }
                BaiduPay.getInstance().resetRemotePayContext();
            }
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().setRemotePayHostName((String) null);
            PayDataCache.getInstance().setRemotePkg((String) null);
            PayDataCache.getInstance().setRemoteWhereToBackAct((String) null);
        }
        PayDataCache.getInstance().resetFromPrecashier();
        PayController.getInstance().clearPreModifiedCallBack();
        PayRequestCache.getInstance().clearPaySdkRequestCache();
        BaiduPay.getInstance().clearPayBack();
        BaiduPay.getInstance().clearBindCallbackExt();
        PayDataCache.getInstance().clearDataCache();
        if (i2 == 0 || i2 == 3) {
            com.baidu.wallet.paysdk.c.a.a().j();
        }
        PayBaseBeanActivity.exitEbpay();
    }

    public static void b(Context context, int i2, String str) {
        if (!TextUtils.isEmpty(PayDataCache.getInstance().getRemotePkg()) && !TextUtils.isEmpty(PayDataCache.getInstance().getRemoteWhereToBackAct())) {
            ComponentName componentName = new ComponentName(PayDataCache.getInstance().getRemotePkg(), PayDataCache.getInstance().getRemoteWhereToBackAct());
            Intent intent = new Intent();
            intent.setComponent(componentName);
            if (isClientDead) {
                intent.putExtra("statuscode", i2);
                intent.putExtra("payresult", str);
            }
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            isClientDead = false;
            context.startActivity(intent);
            BaseActivity.clearTask();
        }
    }

    public static void callBackClientCancel(Context context, String str) {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_FAILED, PRE_HASH_NAME, PRE_HASH_ID, PAY_FAIL_MSG, new String[0]);
        } else {
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.STD_PAY_FAILED, STD_HASH_NAME, STD_HASH_ID, PAY_FAIL_MSG, new String[0]);
        }
        StatisticManager.onEventWithValue("#callBackClientCancel", str);
        PayStateModle payStateModle = new PayStateModle(2, "");
        StatHelper.cacheCodeAndMsg("2", payStateModle.toString());
        a(context, 2, payStateModle.toString());
    }

    public static void callBackClientClear(Context context, String str) {
        PayStateModle payStateModle = new PayStateModle(1000, "");
        StatHelper.cacheCodeAndMsg("1000", payStateModle.toString());
        a(context, 1000, payStateModle.toString());
    }

    public static void callBackClientPaying(Context context) {
        PayStateModle payStateModle = new PayStateModle(1, "");
        StatHelper.cacheCodeAndMsg("1", "paying");
        a(context, 1, payStateModle.toString());
    }

    public static void callBackClientSuccess(Context context, String str) {
        PayStateModle payStateModle = new PayStateModle(0, str);
        StatHelper.cacheCodeAndMsg("0", "paySuccess");
        a(context, 0, payStateModle.toString());
    }

    public static void callBackLicaiBalance(Context context, int i2, String str, String str2, String str3) {
        StatHelper.cacheCodeAndMsg(i2 + "", "");
        StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("statecode={");
        stringBuffer.append(i2);
        stringBuffer.append("};");
        stringBuffer.append("order_no={");
        stringBuffer.append(str);
        stringBuffer.append("};");
        stringBuffer.append("notify={");
        stringBuffer.append(str2);
        stringBuffer.append("};");
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append("trans_need_to_pay={");
            stringBuffer.append(str3);
            stringBuffer.append("};");
        }
        a(context, i2, stringBuffer.toString());
    }
}
