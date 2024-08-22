package com.baidu.android.lbspay.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.m.u.h;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.GetPayOrderListener;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.ChannelPayUtil;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.channelpay.fast.ChannelFastPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class PayChannelController implements IBeanResponseCallback, NoProguard {
    public static final String ALIPAY_PAYCHANNEL = "BAIDU-ALIPAY-WISE";
    public static final String BAIFUBAO_PAYCHANNEL = "BAIDU-BAIFUBAO-WISE";
    public static final String BAIFUBAO_PAYCHANNEL_CODE = "BAIFUBAO-WISE";
    public static final String BANKCARD_PAYCHANNEL = "BAIDU-BANK-CARD-PAY";
    public static final String BEAN_TAG = "ChannelListViewController";
    public static final String WXPAY_PAYCHANNEL = "BAIDU-SUPER-WECHAT-WISE";
    public GetPayOrderListener getPayOrderListener;
    public Activity mAct;
    public Activity mAlipayActivity = null;
    public CashierDataNew mCashierData;
    public int mChannelId;
    public IChannelPay mChannelPay;
    public GetPayBean mGetPayBean;
    public Handler mHandler;

    public interface DoShowAllChannelClick {
        void doClick();
    }

    public interface GetPayModeListener {
        void getSelectPayMode(PayMode payMode);
    }

    public interface SelectChannelListener {
        void onSelectChannel(String str);
    }

    public PayChannelController(Activity activity) {
        this.mAct = activity;
        this.mHandler = new Handler(activity.getMainLooper());
    }

    /* access modifiers changed from: private */
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 2) {
            LBSPayAli.getInstance().clearChannelPay();
            this.mChannelPay = null;
            if (!TextUtils.isEmpty(str)) {
                GlobalUtils.toast(this.mAct, str);
            }
            GetPayOrderListener getPayOrderListener2 = this.getPayOrderListener;
            if (getPayOrderListener2 != null) {
                getPayOrderListener2.complete();
            }
            LBSPayResult.payResult(this.mAct, 2, "");
        }
    }

    /* access modifiers changed from: private */
    public void handlerResponse(int i2, Object obj, String str) {
        if (obj != null && i2 == 2) {
            GetPayContent getPayContent = null;
            if (obj instanceof GetPayContent) {
                getPayContent = (GetPayContent) obj;
            }
            GetPayOrderListener getPayOrderListener2 = this.getPayOrderListener;
            if (getPayOrderListener2 != null) {
                getPayOrderListener2.complete();
            }
            if (getPayContent != null) {
                int i3 = getPayContent.authorize_err_no;
                if (i3 == 100000) {
                    LBSPayResult.payResult(this.mAct, 0, getPayContent.authorize_return_data);
                } else if (i3 <= 100000 || i3 > 110000) {
                    doPay(getPayContent);
                } else {
                    doPay(getPayContent);
                }
            }
        }
    }

    public void doDirectCallThirdPay(GetPayOrderListener getPayOrderListener2, CashierDataNew cashierDataNew, String str) {
        if (!TextUtils.isEmpty(str) && cashierDataNew != null) {
            this.mCashierData = cashierDataNew;
            this.getPayOrderListener = getPayOrderListener2;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("payChannel")) {
                    String valueOf = String.valueOf(jSONObject.get("payChannel"));
                    if (ALIPAY_PAYCHANNEL.equals(valueOf)) {
                        this.mChannelId = 105;
                        this.mChannelPay = ChannelPayUtil.getChannelPay(105);
                    } else if (WXPAY_PAYCHANNEL.equals(valueOf)) {
                        this.mChannelId = IChannelPay.ID_WX_PAY;
                        this.mChannelPay = ChannelPayUtil.getChannelPay(IChannelPay.ID_WX_PAY);
                    } else if (BAIFUBAO_PAYCHANNEL.equals(valueOf)) {
                        this.mChannelId = 126;
                        this.mChannelPay = ChannelPayUtil.getChannelPay(126);
                    } else if (BANKCARD_PAYCHANNEL.equals(valueOf)) {
                        this.mChannelId = IChannelPay.ID_BANK_CARD_PAY;
                        this.mChannelPay = ChannelPayUtil.getChannelPay(IChannelPay.ID_BANK_CARD_PAY);
                    } else {
                        LBSPayResult.payResult(this.mAct, 2, "");
                        return;
                    }
                    ((AbstractChannelPay) this.mChannelPay).setNotifyOnError(true);
                    StatHelper.cacheChannelId(this.mChannelId + "");
                    String orderNo = this.mCashierData.getOrderNo();
                    List<String> collectData = StatHelper.collectData(orderNo, this.mChannelId + "");
                    HashMap hashMap = new HashMap();
                    hashMap.put("pay_amount", StatHelper.getPayAmount());
                    StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_CHANNEL, (Collection<String>) collectData, (Map<String, Object>) hashMap);
                    GetPayBean getPayBean = (GetPayBean) LbsPayBeanFactory.getInstance().getBean((Context) this.mAct, 2, BEAN_TAG);
                    this.mGetPayBean = getPayBean;
                    getPayBean.setmCashierData(this.mCashierData);
                    this.mGetPayBean.setmReqData(str);
                    this.mGetPayBean.setResponseCallback(this);
                    this.mGetPayBean.execBean();
                    StatisticManager.onEventWithValue(LbsStatistics.LBS_DO_PAY_CLICK, ChannelPayUtil.getChannelTag(this.mChannelId));
                    return;
                }
                if (this.getPayOrderListener != null) {
                    this.getPayOrderListener.complete();
                }
                GlobalUtils.toast(this.mAct, ResUtils.getString(this.mAct, "dxm_ebpay_resolve_error"));
                LBSPayResult.payResult(this.mAct, 2, "");
            } catch (Exception unused) {
                LBSPayResult.payResult(this.mAct, 2, "");
            }
        }
    }

    public void doPay(GetPayContent getPayContent) {
        Activity activity;
        IChannelPay iChannelPay = this.mChannelPay;
        if (iChannelPay == null) {
            LBSPayResult.payResult(this.mAct, 2, "");
            GlobalUtils.toast(this.mAct, "暂不支持这种支付方式");
        } else if (!(iChannelPay instanceof ChannelAliPay) || (activity = this.mAlipayActivity) == null) {
            IChannelPay iChannelPay2 = this.mChannelPay;
            if (!(iChannelPay2 instanceof ChannelFastPay) || !TextUtils.isEmpty(((ChannelFastPay) iChannelPay2).getUrl(getPayContent))) {
                this.mChannelPay.pay(this.mAct, getPayContent);
            } else {
                this.mChannelPay.payCancel();
            }
        } else {
            iChannelPay.pay(this.mAct, activity, getPayContent);
        }
    }

    public void getUnionPayResult(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("pay_result");
            "result =" + string;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (string.equalsIgnoreCase(SmsLoginView.f.k)) {
                IChannelPay iChannelPay = this.mChannelPay;
                if (iChannelPay != null) {
                    iChannelPay.paySuccess("");
                }
            } else if (string.equalsIgnoreCase(QueryResponse.Options.CANCEL)) {
                IChannelPay iChannelPay2 = this.mChannelPay;
                if (iChannelPay2 != null) {
                    iChannelPay2.payCancel();
                }
            } else {
                string.equalsIgnoreCase(h.f684i);
            }
        }
    }

    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    PayChannelController.this.handleFailure(i2, i3, str);
                }
            });
        }
    }

    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    PayChannelController.this.handlerResponse(i2, obj, str);
                }
            });
        }
    }

    public PayChannelController(Activity activity, Activity activity2) {
        this.mAct = activity;
        this.mAlipayActivity = activity2;
        this.mHandler = new Handler(activity.getMainLooper());
    }
}
