package com.baidu.android.lbspay;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Map;

public class BaiduLBSPay {

    public static class a {
        public static BaiduLBSPay a = new BaiduLBSPay();
    }

    public static BaiduLBSPay getInstance() {
        return a.a;
    }

    public void doCallFrontCashierPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        doCallFrontCashierPay(activity, getPayOrderListener, lBSPayBack, map, str, (LBSOriginalPayBack) null);
    }

    public void doPolymerAuthorizeSign(Activity activity, LBSPayBack lBSPayBack, Map<String, String> map) {
        doPolymerAuthorizeSign(activity, lBSPayBack, map, (LBSOriginalPayBack) null);
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map) {
        doPolymerPay(context, lBSPayBack, map, (LBSOriginalPayBack) null);
    }

    public String getReqData(Context context) {
        if (BaiduWalletDelegate.getInstance().getAppContext() != null) {
            return LBSPayInner.getInstance().getReqData(context);
        }
        StatisticManager.onEvent(LbsStatistics.LBS_GET_REQDATA_CONTEXT_NULL);
        return "";
    }

    public BaiduLBSPay() {
    }

    public void doCallFrontCashierPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str, LBSOriginalPayBack lBSOriginalPayBack) {
        if (BaiduWalletDelegate.getInstance().getAppContext() != null) {
            LBSOriginalPayBackManage.getInstance().setOriginalPayBack(lBSOriginalPayBack);
            LBSPayInner.getInstance().doCallFrontCashierPay(activity, getPayOrderListener, lBSPayBack, map, str);
        }
    }

    public void doPolymerAuthorizeSign(Activity activity, LBSPayBack lBSPayBack, Map<String, String> map, LBSOriginalPayBack lBSOriginalPayBack) {
        if (BaiduWalletDelegate.getInstance().getAppContext() != null) {
            LBSOriginalPayBackManage.getInstance().setOriginalPayBack(lBSOriginalPayBack);
            LBSPayInner.getInstance().doPolymerAuthorizeSign(activity, lBSPayBack, map);
        }
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map, LBSOriginalPayBack lBSOriginalPayBack) {
        if (BaiduWalletDelegate.getInstance().getAppContext() != null) {
            LBSOriginalPayBackManage.getInstance().setOriginalPayBack(lBSOriginalPayBack);
            LBSPayInner.getInstance().doPolymerPay(context, lBSPayBack, map);
        }
    }
}
