package com.baidu.android.lbspay.channelpay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.CallSuper;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public abstract class AbstractChannelPay implements IChannelPay {
    public static final String TAG = "AbstractChannelPay";
    public WeakReference<Context> mContext;
    public boolean mNotifyOnError;
    public GetPayBean mPayBean;
    public GetPayContent mPayResponse;
    public IChannelPay.State mState = IChannelPay.State.Init;

    public GetPayBean getPayBean() {
        return this.mPayBean;
    }

    public PayDataBean getPayData(GetPayContent getPayContent) {
        String str = getPayContent.paydata;
        if (!TextUtils.isEmpty(str)) {
            String str2 = new String(Base64.decode(str, 0));
            "decodeddata=" + str2;
            try {
                return (PayDataBean) JsonUtils.fromJson(str2, PayDataBean.class);
            } catch (JSONException e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
        }
        return null;
    }

    public GetPayContent getPayResponse() {
        return this.mPayResponse;
    }

    public IChannelPay.State getState() {
        return this.mState;
    }

    public void pay(Activity activity, Activity activity2, GetPayContent getPayContent) {
    }

    @CallSuper
    public void pay(Activity activity, GetPayContent getPayContent) {
        this.mContext = new WeakReference<>(activity);
        this.mState = IChannelPay.State.Paying;
        this.mPayResponse = getPayContent;
    }

    public void payCancel() {
        this.mState = IChannelPay.State.PayEnd;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference == null ? null : (Context) weakReference.get();
        if (this.mNotifyOnError) {
            LBSPayResult.payResult(context, 2, (String) null);
        }
        if (context != null) {
            if (!this.mNotifyOnError) {
                GlobalUtils.toast(context, ResUtils.getString(context, "lbspay_pay_cancel"));
            }
            int channelId = getChannelId();
            if (channelId == 105) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_ALIPAY, "app_canncel");
            } else if (channelId == 107) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_FAST_PAY, "canncel");
            } else if (channelId == 126) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "canncel");
            } else if (channelId == 158) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_WXPAY, "wxpay_canncel");
            } else if (channelId == 163) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_IPAY_PAY, "Ipaypay_canncel");
            }
        }
    }

    public void payError(String str, String str2) {
        this.mState = IChannelPay.State.PayEnd;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference == null ? null : (Context) weakReference.get();
        if (this.mNotifyOnError) {
            LBSPayResult.payResult(context, 2, (String) null);
        }
        String orderId = StatHelper.getOrderId();
        List<String> collectData = StatHelper.collectData(orderId, StatHelper.getChannelId(), str + "", str2);
        HashMap hashMap = new HashMap();
        hashMap.put("pay_amount", StatHelper.getPayAmount());
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_ERROR, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        if (context != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = PayCallBackManager.PAY_FAIL_MSG;
            }
            GlobalUtils.toast(context, str2);
            int channelId = getChannelId();
            if (channelId == 105) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_ALIPAY, str);
            } else if (channelId == 107) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_FAST_PAY, str);
            } else if (channelId == 126) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, str);
            } else if (channelId == 158) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_WXPAY, str);
            } else if (channelId == 163) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_IPAY_PAY, str);
            }
        }
    }

    @CallSuper
    public void paySuccess(String str) {
        this.mState = IChannelPay.State.PayEnd;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference == null ? null : (Context) weakReference.get();
        LBSPayResult.payResult(context, 0, str, this);
        if (context != null) {
            int channelId = getChannelId();
            if (channelId == 105) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_ALIPAY, "app_success");
            } else if (channelId == 107) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_FAST_PAY, SmsLoginView.f.k);
            } else if (channelId == 126) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, SmsLoginView.f.k);
            } else if (channelId == 158) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_WXPAY, "wxpay_success");
            } else if (channelId == 163) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_IPAY_PAY, "Ipaypay_success");
            }
        }
    }

    public void paying() {
        this.mState = IChannelPay.State.PayEnd;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference == null ? null : (Context) weakReference.get();
        LBSPayResult.payResult(context, 1, "");
        if (context != null) {
            int channelId = getChannelId();
            if (channelId == 105) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_ALIPAY, "app_paying");
            } else if (channelId == 107) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_FAST_PAY, "paying");
            } else if (channelId == 126) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "paying");
            } else if (channelId == 158) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_WXPAY, "wxpay_paying");
            } else if (channelId == 163) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_IPAY_PAY, "Ipaypay_paying");
            }
        }
    }

    public void setNotifyOnError(boolean z) {
        this.mNotifyOnError = z;
    }

    public void setPayBean(GetPayBean getPayBean) {
        this.mPayBean = getPayBean;
    }
}
