package com.baidu.android.lbspay.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alipay.sdk.m.s.a;
import com.baidu.android.lbspay.LBSOriginalPayBack;
import com.baidu.android.lbspay.LBSPayBack;
import com.baidu.android.lbspay.LBSPayInner;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.List;

public class JuheH5PayResultProcess extends H5PayResultProcess {
    public static final String TAG = "JuheH5PayResultProcess";
    public String mCallbackParam;
    public H5LifeCycleCallback mH5LifeCycleCb = null;
    public GetPayBean mPayBean;
    public String mUrlAndParams;

    public JuheH5PayResultProcess(Context context, String str, String str2, GetPayBean getPayBean, String str3) {
        this.mContext = context;
        this.mH5 = new H5ResultParams("-1", str, str2, "1", (CashierDeskPayResult.PayScenario) null);
        this.mPayBean = getPayBean;
        this.mCallbackParam = str3;
        this.mUrlAndParams = null;
    }

    private String getH5ResultPageParams() {
        GetPayBean getPayBean;
        String str = this.mUrlAndParams;
        if (str != null) {
            return str;
        }
        if (this.mContext == null || (getPayBean = this.mPayBean) == null) {
            return null;
        }
        List<RestNameValuePair> requestParams = getPayBean.getRequestParams();
        this.mPayBean = null;
        if (requestParams == null) {
            return null;
        }
        if (!TextUtils.isEmpty(this.mH5.pay_result_params)) {
            String[] split = this.mH5.pay_result_params.split(a.n);
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                requestParams.add(new RestNameValuePair(split3[0], split3[1]));
            }
        }
        String processedParams = H5PayResultProcess.getProcessedParams(requestParams, "UTF-8");
        if (TextUtils.isEmpty(processedParams)) {
            return null;
        }
        String str2 = this.mH5.pay_result_url + "?is_from_sdk=1&result_type=cashier&order_query=" + processedParams;
        this.mUrlAndParams = str2;
        return str2;
    }

    public void afterShow() {
        Intent intent = new Intent(LBSPayResult.ACTION_EXIT);
        LBSPayBack callBack = LBSPayInner.getInstance().getCallBack();
        if (callBack != null) {
            try {
                if (this.mContext != null) {
                    StatisticManager.onEvent("#onPayResult");
                }
                callBack.onPayResult(0, this.mCallbackParam);
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
        }
        LBSPayInner.getInstance().clearLbsPayBack();
        Context context = this.mContext;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
        PayDataCache.getInstance().setmWxAppId((String) null);
        StatHelper.clearSensor();
        LBSOriginalPayBackManage.getInstance().setOriginalPayBack((LBSOriginalPayBack) null);
    }

    public void beforeShow() {
        PayRequestCache.getInstance().removeBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
    }

    public void show() {
        String h5ResultPageParams = getH5ResultPageParams();
        this.mQueryResultString = h5ResultPageParams;
        if (h5ResultPageParams == null) {
            afterShow();
            return;
        }
        if (this.mH5LifeCycleCb == null) {
            AnonymousClass1 r0 = new H5LifeCycleCallback() {
                public void onActivityDestroyed(Activity activity) {
                    BaiduWalletDelegate.getInstance().removeH5LifeCycleCb(activity, this);
                    JuheH5PayResultProcess.this.afterShow();
                }
            };
            this.mH5LifeCycleCb = r0;
            r0.push();
        }
        BaiduWalletDelegate.getInstance();
        Bundle bundle = new Bundle();
        bundle.putBoolean("with_anim", false);
        bundle.putBoolean("show_share", false);
        bundle.putString("url", this.mQueryResultString);
        bundle.putParcelable("lifecycleLsnr", this.mH5LifeCycleCb);
        BaiduWalletDelegate.getInstance().openH5Module(this.mContext, bundle);
    }
}
