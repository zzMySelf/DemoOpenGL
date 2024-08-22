package com.baidu.android.lbspay.channelpay.wxpay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.view.PayChannelController;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class ChannelWXPay extends AbstractChannelPay {
    public static final int WX_PAY_CANCLE = -2;
    public static final int WX_PAY_FAILED = -1;
    public static final int WX_PAY_SUCCESS = 0;

    public static class a {
        public static ChannelWXPay a = new ChannelWXPay();
    }

    private PayReq genPayReq(PayDataBean payDataBean) {
        PayReq payReq = new PayReq();
        payReq.appId = payDataBean.appid;
        payReq.partnerId = payDataBean.partnerid;
        payReq.prepayId = payDataBean.prepayid;
        payReq.packageValue = payDataBean.packagealias;
        payReq.nonceStr = payDataBean.noncestr;
        payReq.timeStamp = payDataBean.timestamp;
        payReq.sign = payDataBean.sign;
        return payReq;
    }

    public static ChannelWXPay getInstance() {
        return a.a;
    }

    public int getChannelId() {
        return IChannelPay.ID_WX_PAY;
    }

    public void handlerPayResult(Context context, BaseResp baseResp) {
        if (baseResp == null) {
            GlobalUtils.toast(context, "微信返回失败");
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "2", "微信返回失败");
            payCancel();
            return;
        }
        LBSOriginalPayBackManage instance = LBSOriginalPayBackManage.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(baseResp.errCode);
        String str = "";
        sb.append(str);
        instance.originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, sb.toString(), baseResp.errStr);
        int i2 = baseResp.errCode;
        if (i2 == 0) {
            paySuccess(str);
        } else if (i2 == -1) {
            try {
                str = String.valueOf(i2);
            } catch (Exception unused) {
            }
            payError(str, baseResp.errStr);
        } else if (i2 == -2) {
            payCancel();
        }
    }

    public void handlerPayResultBundle(Context context, Bundle bundle) {
        if (bundle != null) {
            handlerPayResult(context, new PayResp(bundle));
        }
    }

    public void pay(Activity activity, GetPayContent getPayContent) {
        super.pay(activity, getPayContent);
        PayDataBean payData = getPayData(getPayContent);
        PayReq genPayReq = payData != null ? genPayReq(payData) : null;
        if (genPayReq == null || TextUtils.isEmpty(genPayReq.appId)) {
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "2", ResUtils.getString(activity, "lbspay_wx_getpay_failed"));
            payError("-1", ResUtils.getString(activity, "lbspay_wx_getpay_failed"));
            return;
        }
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity, (String) null);
        if (createWXAPI == null) {
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "2", ResUtils.getString(activity, "lbspay_wx_start_failed"));
            payError("-1", ResUtils.getString(activity, "lbspay_wx_start_failed"));
            return;
        }
        createWXAPI.registerApp(genPayReq.appId);
        if (!createWXAPI.isWXAppInstalled()) {
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "2", ResUtils.getString(activity, "lbspay_wx_not_installed"));
            payError("-1", ResUtils.getString(activity, "lbspay_wx_not_installed"));
        } else if (!createWXAPI.sendReq(genPayReq)) {
            LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "2", ResUtils.getString(activity, "lbspay_wx_start_failed"));
            payError("-1", ResUtils.getString(activity, "lbspay_wx_start_failed"));
        }
    }

    public ChannelWXPay() {
    }
}
