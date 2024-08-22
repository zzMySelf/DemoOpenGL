package com.baidu.android.lbspay;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.presenter.JuheH5PayResultProcess;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LBSPayResult {
    public static String ACTION_EXIT = "com.baidu.android.lbspay.EXIT";
    public String mOrderInfo;
    public String mOrderNo;
    public String mStateCode;

    public static void payResult(Context context, int i2, String str) {
        payResult(context, i2, str, (AbstractChannelPay) null);
    }

    public static void payResult(Context context, int i2, String str, AbstractChannelPay abstractChannelPay) {
        GetPayBean payBean;
        GetPayContent payResponse;
        List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), StatHelper.getChannelId());
        HashMap hashMap = new HashMap();
        hashMap.put("pay_amount", StatHelper.getPayAmount());
        if (TextUtils.isEmpty(StatHelper.getSignChannel())) {
            if (i2 == 0) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_SUCCESS, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            } else if (i2 == 1) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_PAYING, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            } else if (i2 == 2) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_CANCEL, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            } else {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_ERROR, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            }
        }
        String orderNo = LBSPayInner.getInstance().getOrderNo();
        if (orderNo == null) {
            orderNo = "";
        }
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("statecode={");
        stringBuffer.append(String.valueOf(i2));
        stringBuffer.append("};");
        stringBuffer.append("order_no={");
        stringBuffer.append(orderNo);
        stringBuffer.append("};");
        stringBuffer.append("notify={");
        stringBuffer.append(str);
        stringBuffer.append("};");
        String stringBuffer2 = stringBuffer.toString();
        "result=" + stringBuffer2;
        if (abstractChannelPay == null || context == null || (payBean = abstractChannelPay.getPayBean()) == null || (payResponse = abstractChannelPay.getPayResponse()) == null) {
            Intent intent = new Intent(ACTION_EXIT);
            LBSPayBack callBack = LBSPayInner.getInstance().getCallBack();
            if (callBack != null) {
                if (context != null) {
                    try {
                        StatisticManager.onEvent("#onPayResult");
                    } catch (Exception e) {
                        LogUtil.e("Pay", "call back error", e);
                    }
                }
                callBack.onPayResult(i2, stringBuffer2);
            }
            LBSPayInner.getInstance().clearLbsPayBack();
            PayDataCache.getInstance().setmWxAppId((String) null);
            StatHelper.clearSensor();
            if (context != null) {
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
            LBSOriginalPayBackManage.getInstance().setOriginalPayBack((LBSOriginalPayBack) null);
            return;
        }
        JuheH5PayResultProcess juheH5PayResultProcess = new JuheH5PayResultProcess(context, payResponse.pay_result_url, payResponse.pay_result_param, payBean, stringBuffer2);
        juheH5PayResultProcess.beforeShow();
        juheH5PayResultProcess.show();
    }
}
