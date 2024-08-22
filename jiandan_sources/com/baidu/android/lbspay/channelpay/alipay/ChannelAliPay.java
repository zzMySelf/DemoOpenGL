package com.baidu.android.lbspay.channelpay.alipay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelAliPay extends AbstractChannelPay {
    public static final int MSG_AILI_PAY = 100;
    public static final int MSG_AILI_PAYV2 = 101;
    public static final int PAY_VERSION = 2;
    public static final String TAG = "ChannelAliPay";
    @SuppressLint({"HandlerLeak"})
    public Handler mAliPayChannelHandler = new Handler() {
        public void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            String str4;
            int i2 = message.what;
            if (i2 == 100 || i2 == 101) {
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), StatHelper.getAlipayVersion());
                HashMap hashMap = new HashMap();
                hashMap.put("pay_amount", StatHelper.getPayAmount());
                Object obj = message.obj;
                if (obj == null || !(obj instanceof String)) {
                    str = "";
                } else {
                    str = (String) obj;
                }
                if (message.what == 100) {
                    Result result = new Result(str);
                    str4 = result.resultStatus;
                    str3 = result.result;
                    str2 = result.memo;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        str4 = jSONObject.optString("resultStatus");
                        String optString = jSONObject.optString("result");
                        str2 = jSONObject.optString("memo");
                        str3 = optString;
                    } catch (JSONException e) {
                        LogUtil.e(ChannelAliPay.TAG, e.getMessage(), e);
                        ChannelAliPay.this.payError(Result.RESULT_FAILED, PayCallBackManager.PAY_FAIL_MSG);
                        str4 = Result.RESULT_FAILED;
                        str3 = PayCallBackManager.PAY_FAIL_MSG;
                        str2 = "";
                    }
                }
                LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.ALIPAY_PAYCHANNEL, str4, str);
                if (Result.RESULT_SUCCESS.equals(str4)) {
                    ChannelAliPay.this.paySuccess(str3);
                } else if (Result.RESULT_CANCLE.equals(str4)) {
                    ChannelAliPay.this.payCancel();
                } else if (Result.RESULT_PAYING.equals(str4)) {
                    ChannelAliPay.this.paying();
                } else if (Result.RESULT_NETWROK_ERROR.equals(str4)) {
                    ChannelAliPay.this.payError(Result.RESULT_NETWROK_ERROR, "网络连接出错");
                } else {
                    ChannelAliPay.this.payError(Result.RESULT_FAILED, str2);
                }
                collectData.add(str4);
                if (TextUtils.isEmpty(str3)) {
                    collectData.add(str2);
                } else {
                    collectData.add(str3);
                }
                StatisticManager.onEventWithValues(PayStatServiceEvent.ALIPAY_RESULT, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            }
        }
    };
    public LBSPayAli.INoSupportAliAuthorizePay mAliPayNoSupportCallBack;
    public Handler mHandler;
    public int mPayTag;

    private void startAlipay(final Activity activity, final String str, final PayDataBean payDataBean) {
        this.mHandler = new Handler();
        new Thread() {
            public void run() {
                StatisticManager.onEventStart(StatServiceEvent.LBS_ALIPAY);
                PayTask payTask = new PayTask(activity);
                Message message = new Message();
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), new String[0]);
                HashMap hashMap = new HashMap();
                hashMap.put("pay_amount", StatHelper.getPayAmount());
                PayDataBean payDataBean = payDataBean;
                int i2 = 1;
                if (payDataBean == null || 2 != payDataBean.alipayVersion) {
                    LogUtil.d("alipay:", "alipayV1");
                    message.obj = payTask.pay(str, true);
                    message.what = 100;
                } else {
                    LogUtil.d("alipay:", "alipayV2");
                    int i3 = payDataBean.alipayVersion;
                    message.obj = new JSONObject(payTask.payV2(str, true)).toString();
                    message.what = 101;
                    i2 = i3;
                }
                collectData.add(i2 + "");
                StatHelper.cacheAlipayVersion(i2 + "");
                StatisticManager.onEventWithValues(PayStatServiceEvent.ALIPAY_ENTER, (Collection<String>) collectData, (Map<String, Object>) hashMap);
                ChannelAliPay.this.mAliPayChannelHandler.sendMessage(message);
            }
        }.start();
    }

    public int getChannelId() {
        return this.mPayTag;
    }

    public String getUrl(GetPayContent getPayContent) {
        return getPayContent.payurl;
    }

    public void pay(Activity activity, GetPayContent getPayContent) {
        super.pay(activity, getPayContent);
        this.mPayTag = 105;
        PayDataBean payData = getPayData(getPayContent);
        if (payData == null || !payData.isAliAuthPay()) {
            startAlipay(activity, (payData == null || TextUtils.isEmpty(payData.appurl)) ? "" : payData.appurl, payData);
            return;
        }
        if (!LBSPayAli.getInstance().aliAuthorizePay(activity, payData.auth_appurl, this)) {
            LBSPayAli.INoSupportAliAuthorizePay iNoSupportAliAuthorizePay = this.mAliPayNoSupportCallBack;
            if (iNoSupportAliAuthorizePay != null) {
                iNoSupportAliAuthorizePay.onNoSupportAliAuthorizePay();
                return;
            }
            StatisticManager.onEvent(LbsStatistics.WALLET_LBS_FRONT_CASHIER_ALI_AUTHORIZE_PAY_CANCEL);
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.ALIPAY_PAYCHANNEL, "2", ResUtils.getString(activity, "lbspay_pay_guide_install_ali_pay_pkg_msg"));
            LBSPayResult.payResult(activity, 2, ResUtils.getString(activity, "lbspay_pay_guide_install_ali_pay_pkg_msg"));
        }
    }

    public void setAliPayNoSupportCallBack(LBSPayAli.INoSupportAliAuthorizePay iNoSupportAliAuthorizePay) {
        this.mAliPayNoSupportCallBack = iNoSupportAliAuthorizePay;
    }

    public void pay(Activity activity, Activity activity2, GetPayContent getPayContent) {
        super.pay(activity, getPayContent);
        this.mPayTag = 105;
        PayDataBean payData = getPayData(getPayContent);
        if (payData == null || !payData.isAliAuthPay()) {
            startAlipay(activity2, (payData == null || TextUtils.isEmpty(payData.appurl)) ? "" : payData.appurl, payData);
            return;
        }
        if (!LBSPayAli.getInstance().aliAuthorizePay(activity, payData.auth_appurl, this)) {
            StatisticManager.onEvent(LbsStatistics.WALLET_LBS_FRONT_CASHIER_ALI_AUTHORIZE_PAY_CANCEL);
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.ALIPAY_PAYCHANNEL, "2", ResUtils.getString(activity, "lbspay_pay_guide_install_ali_pay_pkg_msg"));
            LBSPayResult.payResult(activity, 2, ResUtils.getString(activity, "lbspay_pay_guide_install_ali_pay_pkg_msg"));
        }
    }
}
